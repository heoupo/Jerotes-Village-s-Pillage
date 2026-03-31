package com.jerotes.jvpillage.entity.Shoot.Magic.Cloud;

import com.jerotes.jvpillage.init.JVPillageEntityType;
import com.jerotes.jvpillage.init.JVPillageMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class UncleanBloodRainEntity extends RainEffectCloudEntity {
    public UncleanBloodRainEntity(EntityType<? extends UncleanBloodRainEntity> entityType, Level level) {
        super(entityType, level);
    }

    public UncleanBloodRainEntity(int spellLevelMainEffectTime, int spellLevelMainEffectLevel, Level level, double d, double d2, double d3) {
        this(JVPillageEntityType.UNCLEAN_BLOOD_RAIN.get(), level);
        this.setPos(d, d2, d3);
        this.spellLevelMainEffectTime = spellLevelMainEffectTime;
        this.spellLevelMainEffectLevel = spellLevelMainEffectLevel;
    }

    @Override
    public void addRainEffect(LivingEntity livingEntity, LivingEntity livingEntity1) {
        if (!livingEntity.level().isClientSide) {
            livingEntity.addEffect(new MobEffectInstance(JVPillageMobEffects.UNCLEAN_BODY.get(), this.spellLevelMainEffectTime * 20, this.spellLevelMainEffectLevel-1), livingEntity1);
        }
    }
}