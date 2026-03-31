package com.jerotes.jerotesvillage.entity.Shoot.Magic.Target;

import com.jerotes.jerotes.entity.Shoot.Magic.Target.BaseTargetEntity;
import com.jerotes.jerotes.init.JerotesSoundEvents;
import com.jerotes.jerotes.util.AttackFind;
import com.jerotes.jerotesvillage.init.JerotesVillageEntityType;
import com.jerotes.jerotesvillage.init.JerotesVillageItems;
import com.jerotes.jerotesvillage.init.JerotesVillageParticleTypes;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GravityForceEntity extends BaseTargetEntity {
    public GravityForceEntity(EntityType<? extends GravityForceEntity> entityType, Level level) {
        super(entityType, level);
    }

    public GravityForceEntity(EntityType<? extends GravityForceEntity> entityType, double d, double d2, double d3, double d4, double d5, double d6, Level level) {
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

    public GravityForceEntity(int spellLevelDamage, Level level, LivingEntity livingEntity, double d, double d2, double d3) {
        super(JerotesVillageEntityType.GRAVITY_FORCE.get(), livingEntity, d, d2, d3, level);
        this.spellLevelDamage = spellLevelDamage;
    }

    @Override
    public void useMagicTo(LivingEntity livingEntity) {
        super.useMagicTo(livingEntity);
        DamageSource damageSource = AttackFind.findDamageType(this, DamageTypes.FLY_INTO_WALL, this, this.getOwner());
        float base = 1.5f;
        if (livingEntity.getAttribute(Attributes.KNOCKBACK_RESISTANCE) != null) {
            base = (float) (1.5f - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
        }
        if (livingEntity.isShiftKeyDown()) {
            base -= 0.2f;
        }
        if (livingEntity.hasEffect(MobEffects.SLOW_FALLING)) {
            base -= 0.2f;
        }
        if (base < 0) {
            base = 0f;
        }
        livingEntity.hurt(damageSource, spellLevelDamage * 10 * base);
        if (!livingEntity.isNoGravity()) {
            livingEntity.setDeltaMovement(livingEntity.getDeltaMovement().add(0, base * -5f, 0));
        }
        else {
            livingEntity.setDeltaMovement(livingEntity.getDeltaMovement().add(0, base * -0.5f, 0));
        }
        this.playSound(JerotesSoundEvents.SPELL, 3.0f, 1.0f);
        this.discard();
    }

    @Override
    public int getUseLife() {
        return 10;
    }

    @Override
    public int getMaxLife() {
        return 20;
    }

    @Override
    protected ParticleOptions getTrailParticle() {
        return JerotesVillageParticleTypes.PUSH_FORCE.get();
    }

    @Override
    public ItemStack getItem() {
        ItemStack itemStack = this.getItemRaw();
        return itemStack.isEmpty() ? new ItemStack(JerotesVillageItems.OMINOUS_FORCE.get()) : itemStack;
    }

    @Override
    protected float getInertia() {
        return 1.0f;
    }

    //@Override
    protected float getLiquidInertia() {
        return 1.0f;
    }
}
