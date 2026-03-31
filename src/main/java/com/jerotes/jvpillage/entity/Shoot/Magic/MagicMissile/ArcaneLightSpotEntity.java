package com.jerotes.jvpillage.entity.Shoot.Magic.MagicMissile;

import com.jerotes.jerotes.entity.Shoot.Magic.MagicMissile.BaseMagicMissileEntity;
import com.jerotes.jerotes.init.JerotesSoundEvents;
import com.jerotes.jerotes.util.Main;
import com.jerotes.jvpillage.entity.Monster.IllagerFaction.LampWizardEntity;
import com.jerotes.jvpillage.init.JVPillageEntityType;
import com.jerotes.jvpillage.init.JVPillageItems;
import com.jerotes.jvpillage.init.JVPillageParticleTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class ArcaneLightSpotEntity extends BaseMagicMissileEntity {
    public ArcaneLightSpotEntity(EntityType<? extends ArcaneLightSpotEntity> entityType, Level level) {
        super(entityType, level);
    }

    public ArcaneLightSpotEntity(EntityType<? extends ArcaneLightSpotEntity> entityType, double d, double d2, double d3, double d4, double d5, double d6, Level level) {
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

    public ArcaneLightSpotEntity(int spellLevelDamage, int spellLevelMainEffectTime, int spellLevelMainEffectLevel, Level level, LivingEntity livingEntity, double d, double d2, double d3) {
        super(JVPillageEntityType.ARCANE_LIGHT_SPOT.get(), livingEntity, d, d2, d3, level);
        this.spellLevelDamage = spellLevelDamage;
        this.spellLevelMainEffectTime = spellLevelMainEffectTime;
        this.spellLevelMainEffectLevel = spellLevelMainEffectLevel;
    }

    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        if (this.level().isClientSide) {
            return;
        }
        Entity entity = entityHitResult.getEntity();
        if (this.getOwner() instanceof LivingEntity && entity != this.getTarget() && this.getTarget() != null) {
            return;
        }
        if (entity instanceof LivingEntity livingEntity) {
            Entity entity2 = this.getOwner();
            boolean bl = livingEntity.hurt(this.damageSources().indirectMagic(this, entity2),  Main.randomReach(RandomSource.create(), 1, 4) + 1);
            if (bl) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 20 * spellLevelMainEffectTime, spellLevelMainEffectLevel-1), this.getEffectSource());
                if (this.getOwner() != null) {
                    String string = ChatFormatting.stripFormatting(this.getOwner().getName().getString());
                    if (this.getOwner() instanceof LampWizardEntity lampWizardEntity) {
                        if (lampWizardEntity.isChampion())
                        {
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 20 * spellLevelMainEffectTime, spellLevelMainEffectLevel - 1), this.getEffectSource());
                        }
                    }
                }
            }
            this.playSound(JerotesSoundEvents.SPELL, 3.0f, 1.0f);
            this.discard();
        }
    }

    @Override
    public int getMaxLife() {
        return 40;
    }

    @Override
    protected ParticleOptions getTrailParticle() {
        return JVPillageParticleTypes.ARCANE_LIGHT_SPOT.get();
    }
    @Override
    public ItemStack getItem() {
        ItemStack itemStack = this.getItemRaw();
        return itemStack.isEmpty() ? new ItemStack(JVPillageItems.ARCANE_LIGHT_SPOT.get()) : itemStack;
    }
}
