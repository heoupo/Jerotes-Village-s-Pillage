package com.jerotes.jerotesvillage.event;

import com.jerotes.jerotes.init.JerotesMobEffects;
import com.jerotes.jerotes.init.JerotesSoundEvents;
import com.jerotes.jerotes.item.Tool.ItemToolBaseBandage;
import com.jerotes.jerotesvillage.JerotesVillage;
import com.jerotes.jerotesvillage.init.JerotesVillageItems;
import com.jerotes.jerotesvillage.item.HagEye;
import com.jerotes.jerotesvillage.item.PurpleSandHagEye;
import com.jerotes.jerotesvillage.item.Tool.ItemToolBaseThrowingBall;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.util.Optional;

@Mod.EventBusSubscriber(modid = JerotesVillage.MODID)
public class ItemEvent {
	@SubscribeEvent
	public static void addWeaponEffectSelf(LivingEvent.LivingTickEvent event) {
		LivingEntity entity = event.getEntity();
		if (entity == null || !entity.isAlive())
			return;
		//投团
		if (entity.getMainHandItem().getItem() instanceof ItemToolBaseThrowingBall itemToolBaseThrowingBall) {
			itemToolBaseThrowingBall.addEffects(entity);
		}
		if (entity.getOffhandItem().getItem() instanceof ItemToolBaseThrowingBall itemToolBaseThrowingBall) {
			itemToolBaseThrowingBall.addEffects(entity);
		}
		//鬼婆之眼
		if (entity.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof HagEye) {
			if (entity.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof HagEye) {
				if (!entity.level().isClientSide()) {
					entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 5, 0, false, false), entity);
				}
				if (entity.hasEffect(MobEffects.BLINDNESS) || entity.hasEffect(MobEffects.DARKNESS)) {
					if (!entity.level().isClientSide()) {
						entity.removeEffect(MobEffects.BLINDNESS);
						entity.removeEffect(MobEffects.DARKNESS);
					}
				}
			}
		}
		if (ModList.get().isLoaded("curios")) {
			if (hasCurio(entity, JerotesVillageItems.HAG_EYE.get())) {
				if (!entity.level().isClientSide()) {
					entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 255, 0, false, false), entity);
				}
				if (entity.hasEffect(MobEffects.BLINDNESS) || entity.hasEffect(MobEffects.DARKNESS)) {
					if (!entity.level().isClientSide()) {
						entity.removeEffect(MobEffects.BLINDNESS);
						entity.removeEffect(MobEffects.DARKNESS);
					}
				}
			}
		}
		//紫沙鬼婆之眼
		if (entity.getMainHandItem().getItem() instanceof PurpleSandHagEye ||
				entity.getOffhandItem().getItem() instanceof PurpleSandHagEye ||
				entity.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof PurpleSandHagEye) {
			if (entity.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof PurpleSandHagEye) {
				if (!entity.level().isClientSide()) {
					entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 5, 0, false, false), entity);
				}
				if (entity.hasEffect(MobEffects.BLINDNESS) || entity.hasEffect(MobEffects.DARKNESS)) {
					if (!entity.level().isClientSide) {
						entity.removeEffect(MobEffects.BLINDNESS);
						entity.removeEffect(MobEffects.DARKNESS);
					}
				}
			}
			if (entity.isShiftKeyDown()) {
				if (!entity.level().isClientSide()) {
					entity.addEffect(new MobEffectInstance(JerotesMobEffects.TRUESIGHT.get(), 25, 1, false, false));
				}
			}
		}
		if (ModList.get().isLoaded("curios")) {
			if (hasCurio(entity, JerotesVillageItems.PURPLE_SAND_HAG_EYE.get())) {
				if (!entity.level().isClientSide()) {
					entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 255, 0, false, false), entity);
				}
				if (entity.hasEffect(MobEffects.BLINDNESS) || entity.hasEffect(MobEffects.DARKNESS)) {
					if (!entity.level().isClientSide()) {
						entity.removeEffect(MobEffects.BLINDNESS);
						entity.removeEffect(MobEffects.DARKNESS);
					}
				}
				if (entity.isShiftKeyDown()) {
					if (!entity.level().isClientSide()) {
						entity.addEffect(new MobEffectInstance(JerotesMobEffects.TRUESIGHT.get(), 25, 1, false, false));
					}
				}
			}
		}
		//绷带
		if (entity.getUseItem().getItem() instanceof ItemToolBaseBandage itemToolBaseBandage) {
			entity.setDeltaMovement(entity.getDeltaMovement().multiply(0.25d, 1d, 0.25d));
			float use = (float) entity.getTicksUsingItem() / itemToolBaseBandage.getUseTime();
			if (use == 1) {
				if (!entity.isSilent()) {
					entity.playSound(JerotesSoundEvents.USE_BANDAGE, 1.0F, 1.0F);
				}
			}
		}
	}

	public static ItemStack findCurio(LivingEntity livingEntity, Item item) {
		ItemStack foundStack = ItemStack.EMPTY;
		if (livingEntity != null) {
			if (ModList.get().isLoaded("curios")) {
				Optional<SlotResult> slotResult = CuriosApi.getCuriosInventory(livingEntity).map(inv -> inv.findFirstCurio(item))
						.orElse(Optional.empty());
				if (slotResult.isPresent()) {
					foundStack = slotResult.get().stack();
				}
			}
		}

		return foundStack;
	}

	public static boolean hasCurio(LivingEntity livingEntity, Item item) {
		return !findCurio(livingEntity, item).isEmpty();
	}
}