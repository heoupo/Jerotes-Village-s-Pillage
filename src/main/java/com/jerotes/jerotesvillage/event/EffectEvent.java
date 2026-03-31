package com.jerotes.jerotesvillage.event;

import com.jerotes.jerotesvillage.JerotesVillage;
import com.jerotes.jerotesvillage.init.JerotesVillageMobEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JerotesVillage.MODID)
public class EffectEvent {



	@SubscribeEvent
	public static void UncleanBody(LivingHurtEvent event) {
		DamageSource damageSource = event.getSource();
		LivingEntity entity = event.getEntity();
		if (damageSource == null || entity == null)
			return;
		if (!entity.level().isClientSide()) {
			if (entity.hasEffect(JerotesVillageMobEffects.UNCLEAN_BODY.get())) {
				int effectLevel = entity.getEffect(JerotesVillageMobEffects.UNCLEAN_BODY.get()).getAmplifier() + 1;
				float newAmount = event.getAmount() * (1 + (effectLevel * 0.2f));
				if (Float.isNaN(newAmount) || Float.isInfinite(newAmount)) {
					newAmount = 0f;
				}
				event.setAmount(newAmount);
			}
		}
	}

//	//元素吸收
//	@SubscribeEvent
//	public static void OtherAbsorption(LivingHurtEvent event) {
//		DamageSource damageSource = event.getSource();
//		LivingEntity entity = event.getEntity();
//		if (damageSource == null || entity == null)
//			return;
//		double damages = 1;
//		if (damageSource.is(DamageTypeTags.IS_FIRE)){
//			if (!entity.level().isClientSide()) {
//				if (entity.hasEffect(JerotesMobEffects.FIRE_ABSORPTION.get()) || entity instanceof FireAbsorptionEntity) {
//					double AbsorptionPercentage = Math.max(
//							(entity instanceof FireAbsorptionEntity absorptionEntity) ? absorptionEntity.FireAbsorptionPercentage() : 0,
//							(entity.hasEffect(JerotesMobEffects.FIRE_ABSORPTION.get())) ? (Objects.requireNonNull(entity.getEffect(JerotesMobEffects.FIRE_ABSORPTION.get())).getAmplifier() + 1) * 20 : 0);
//					damages -= AbsorptionPercentage / 100f;
//					boolean bl = SpellFind.FireAbsorption(entity, event.getAmount(), AbsorptionPercentage, 0.25f);
//					if (bl) {
//						if (!entity.isSilent()) {
//							entity.playSound(JerotesSoundEvents.MAGIC_FIRE_ABSORPTION, EntityAndItemFind.isBoss(entity.getType()) ? 5f : (entity instanceof EliteEntity ? 2f : 1f) * 1, 1.0F);
//						}
//					}
//				}
//			}
//		}
//		if (damageSource.is(DamageTypeTags.IS_FREEZING)){
//			if (!entity.level().isClientSide()) {
//				if (entity.hasEffect(JerotesMobEffects.FREEZE_ABSORPTION.get()) || entity instanceof FreezeAbsorptionEntity) {
//					double AbsorptionPercentage = Math.max(
//							(entity instanceof FreezeAbsorptionEntity absorptionEntity) ? absorptionEntity.FreezeAbsorptionPercentage() : 0,
//							(entity.hasEffect(JerotesMobEffects.FREEZE_ABSORPTION.get())) ? (Objects.requireNonNull(entity.getEffect(JerotesMobEffects.FREEZE_ABSORPTION.get())).getAmplifier() + 1) * 20 : 0);
//					damages -= AbsorptionPercentage / 100f;
//					boolean bl = SpellFind.FreezeAbsorption(entity, event.getAmount(), AbsorptionPercentage, 0.25f);
//					if (bl) {
//						if (!entity.isSilent()) {
//							entity.playSound(JerotesSoundEvents.MAGIC_FREEZE_ABSORPTION, EntityAndItemFind.isBoss(entity.getType()) ? 5f : (entity instanceof EliteEntity ? 2f : 1f) * 1, 1.0F);
//						}
//					}
//				}
//			}
//		}
//		if (damageSource.is(DamageTypeTags.IS_LIGHTNING)){
//			if (!entity.level().isClientSide()) {
//				if (entity.hasEffect(JerotesMobEffects.LIGHTNING_ABSORPTION.get()) || entity instanceof LightningAbsorptionEntity) {
//					double AbsorptionPercentage = Math.max(
//							(entity instanceof LightningAbsorptionEntity absorptionEntity) ? absorptionEntity.LightningAbsorptionPercentage() : 0,
//							(entity.hasEffect(JerotesMobEffects.LIGHTNING_ABSORPTION.get())) ? (Objects.requireNonNull(entity.getEffect(JerotesMobEffects.LIGHTNING_ABSORPTION.get())).getAmplifier() + 1) * 20 : 0);
//					damages -= AbsorptionPercentage / 100f;
//					boolean bl = SpellFind.LightningAbsorption(entity, event.getAmount(), AbsorptionPercentage, 0.25f);
//					if (bl) {
//						if (!entity.isSilent()) {
//							entity.playSound(JerotesSoundEvents.MAGIC_LIGHTNING_ABSORPTION, EntityAndItemFind.isBoss(entity.getType()) ? 5f : (entity instanceof EliteEntity ? 2f : 1f) * 1, 1.0F);
//						}
//					}
//				}
//			}
//		}
//		if (damages <= 0) {
//			event.setCanceled(true);
//		}
//	}
	@SubscribeEvent
	public static void LastDitch(LivingHurtEvent event) {
		DamageSource damageSource = event.getSource();
		LivingEntity entity = event.getEntity();
		if (damageSource == null || entity == null || damageSource.getEntity() == null)
			return;
		if (!entity.level().isClientSide()) {
			if (entity.hasEffect(JerotesVillageMobEffects.LAST_DITCH.get())) {
				int effectLevel = entity.getEffect(JerotesVillageMobEffects.LAST_DITCH.get()).getAmplifier() + 1;
				float newAmount = event.getAmount() * (effectLevel * 2 + 1);
				if (Float.isNaN(newAmount) || Float.isInfinite(newAmount)) {
					newAmount = 0f;
				}
				event.setAmount(newAmount);
			}
		}
	}

	@SubscribeEvent
	public static void Fairness(LivingAttackEvent event) {
		DamageSource damageSource = event.getSource();
		LivingEntity entity = event.getEntity();
		if (damageSource == null || entity == null)
			return;
		if (!entity.level().isClientSide()) {
			if (entity.hasEffect(JerotesVillageMobEffects.FAIRNESS.get())) {
				int effectLevel = entity.getEffect(JerotesVillageMobEffects.FAIRNESS.get()).getAmplifier() + 1;
				if (event.getAmount() < effectLevel * 1000) {
					event.setCanceled(true);
				}
			}
		}
	}
}

