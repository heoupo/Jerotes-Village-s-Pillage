package com.jerotes.jvpillage.entity.Shoot.Magic.MagicShoot;

import com.jerotes.jerotes.entity.Shoot.Magic.MagicAboutEntity;
import com.jerotes.jerotes.init.JerotesDamageTypes;
import com.jerotes.jerotes.util.AttackFind;
import com.jerotes.jvpillage.init.JVPillageItems;
import com.jerotes.jvpillage.init.JVPillageEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class BitterColdFrostbiteEntity extends MagicAboutEntity {
    public BitterColdFrostbiteEntity(EntityType<? extends BitterColdFrostbiteEntity> entityType, Level level) {
        super(entityType, level);
    }

    public BitterColdFrostbiteEntity(EntityType<? extends BitterColdFrostbiteEntity> entityType, double d, double d2, double d3, double d4, double d5, double d6, Level level) {
        this(entityType, level);
        this.moveTo(d, d2, d3, this.getYRot(), this.getXRot());
        this.reapplyPosition();
        double d7 = Math.sqrt(d4 * d4 + d5 * d5 + d6 * d6);
        if (d7 != 0.0) {
            this.xPower = d4 / d7 * 0.1;
            this.yPower = d5 / d7 * 0.1;
            this.zPower = d6 / d7 * 0.1;
        }
    }

    public BitterColdFrostbiteEntity(int spellLevelDamage, int spellLevelFreezeTime, Level level, LivingEntity livingEntity, double d, double d2, double d3) {
        super(JVPillageEntityType.BITTER_COLD_FROSTBITE.get(), livingEntity, d, d2, d3, level);
        this.spellLevelDamage = spellLevelDamage;
        this.spellLevelFreezeTime = spellLevelFreezeTime;
    }

    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        if (this.level().isClientSide) {
            return;
        }
        Entity entity = entityHitResult.getEntity();
        Entity entity2 = this.getOwner();
        DamageSource damageSource = AttackFind.findDamageType(this, JerotesDamageTypes.FREEZE_MAGIC, this, this.getOwner());
        if (!entity.hurt(damageSource, spellLevelDamage * 3f)) {
            entity.hurt(this.damageSources().indirectMagic(this, entity2), spellLevelDamage * 2f);
        }
        else {
            if (entity.getTicksFrozen() < 140 + 20 * spellLevelFreezeTime) {
                entity.setTicksFrozen(140 + 20 * spellLevelFreezeTime);
            }
        }
    }


    @Override
    protected void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        if (this.level().isClientSide) {
            return;
        }
        if ((this.level().getBlockState(BlockPos.containing(blockHitResult.getLocation().x, blockHitResult.getLocation().y, blockHitResult.getLocation().z))).getBlock() == Blocks.LAVA) {
            this.discard();
        }
    }

    @Override
    public int getMaxLife() {
        return 20;
    }

    @Override
    protected ParticleOptions getTrailParticle() {
        return ParticleTypes.SNOWFLAKE;
    }

    @Override
    public ItemStack getItem() {
        ItemStack itemStack = this.getItemRaw();
        return itemStack.isEmpty() ? new ItemStack(JVPillageItems.BITTER_COLD_FROSTBITE.get()) : itemStack;
    }

    @Override
    protected float getInertia() {
        return 1.0f;
    }

    //@Override
    protected float getLiquidInertia() {
        return 0.9f;
    }
}
