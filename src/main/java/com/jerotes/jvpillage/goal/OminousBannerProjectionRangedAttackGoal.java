package com.jerotes.jvpillage.goal;

import com.jerotes.jvpillage.entity.Boss.OminousBannerProjectionEntity;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.pathfinder.Path;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class OminousBannerProjectionRangedAttackGoal extends Goal {
    private final OminousBannerProjectionEntity mob;
    private final OminousBannerProjectionEntity rangedAttackMob;
    private Path path;
    @Nullable
    private LivingEntity target;
    private int attackTime = -1;
    private int seeTime;
    private final int attackIntervalMin;
    private final int attackIntervalMax;
    private final float attackRadius;
    private final float attackRadiusSqr;

    public OminousBannerProjectionRangedAttackGoal(OminousBannerProjectionEntity rangedAttackMob,  int n, float f) {
        this(rangedAttackMob,  n, n, f);
    }

    public OminousBannerProjectionRangedAttackGoal(OminousBannerProjectionEntity rangedAttackMob,  int n, int n2, float f) {
        this.rangedAttackMob = rangedAttackMob;
        this.mob = (OminousBannerProjectionEntity)((Object)rangedAttackMob);
        this.attackIntervalMin = n;
        this.attackIntervalMax = n2;
        this.attackRadius = f;
        this.attackRadiusSqr = f * f;
    }

    @Override
    public boolean canUse() {
        LivingEntity livingEntity = this.mob.getTarget();
        if (livingEntity == null || !livingEntity.isAlive()) {
            return false;
        }
        if (this.mob.getThrowTick() > 0) {
            return false;
        }
        if (this.mob.distanceToSqr(livingEntity) < 12) {
            return false;
        }
        this.target = livingEntity;
        return true;
    }

    @Override
    public void start() {
        this.mob.setAggressive(true);
    }


    @Override
    public boolean canContinueToUse() {
        return this.canUse() || this.target.isAlive() && this.mob.getThrowTick() <= 0;
    }

    @Override
    public void stop() {
        this.target = null;
        this.seeTime = 0;
        this.attackTime = -1;
        this.mob.setAggressive(false);
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }

    @Override
    public void tick() {
        double d = this.mob.distanceToSqr(this.target.getX(), this.target.getY(), this.target.getZ());
        boolean bl = this.mob.getSensing().hasLineOfSight(this.target);
        this.seeTime = bl ? ++this.seeTime : 0;
        if (--this.attackTime == 0) {
            if (!bl) {
                return;
            }
            float f = (float)Math.sqrt(d) / this.attackRadius;
            float f2 = Mth.clamp(f, 0.1f, 1.0f);
            this.rangedAttackMob.performRangedAttack(this.target, f2);
            this.attackTime = Mth.floor(f * (float)(this.attackIntervalMax - this.attackIntervalMin) + (float)this.attackIntervalMin);
        } else if (this.attackTime < 0) {
            this.attackTime = Mth.floor(Mth.lerp(Math.sqrt(d) / (double)this.attackRadius,
                    (double)this.attackIntervalMin,
                    (double)this.attackIntervalMax));
        }
    }
}

