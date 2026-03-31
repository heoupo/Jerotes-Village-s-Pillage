package com.jerotes.jvpillage.event;

import com.jerotes.jerotes.forge.JerotesMerorDamageEvent;
import com.jerotes.jerotes.init.JerotesMobEffects;
import com.jerotes.jerotes.init.JerotesSoundEvents;
import com.jerotes.jerotes.item.Tool.ItemToolBaseBandage;
import com.jerotes.jerotes.util.EntityAndItemFind;
import com.jerotes.jvpillage.JVPillage;
import com.jerotes.jvpillage.init.JVPillageItems;
import com.jerotes.jvpillage.item.HagEye;
import com.jerotes.jvpillage.item.PurpleSandHagEye;
import com.jerotes.jvpillage.item.Tool.ItemToolBaseThrowingBall;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

@Mod.EventBusSubscriber(modid = JVPillage.MODID)
public class ItemEvent {
	@SubscribeEvent
	public static void addWeaponEffect(LivingAttackEvent event) {
		LivingEntity entity = event.getEntity();
		Entity attackBy = event.getSource().getEntity();
		float amount = event.getAmount();
		if (entity == null || !entity.isAlive())
			return;
		if (attackBy != null) {
			ItemStack handItem = null;
			ItemStack otherHandItem = null;
			if (attackBy instanceof LivingEntity living) {
				handItem = living.getMainHandItem();
				otherHandItem = living.getOffhandItem();
				if (!EntityAndItemFind.MeleeDamageFromMainHandNotOffHand(living)) {
					handItem = living.getOffhandItem();
					otherHandItem = living.getMainHandItem();
				}
			}
			if (attackBy instanceof LivingEntity living && living != entity && event.getSource().getDirectEntity() == living && EntityAndItemFind.isMeleeDamage(event.getSource())) {
				if (living.getAttribute(Attributes.ATTACK_DAMAGE) != null) {
					float baseDamage = (float) living.getAttributeValue(Attributes.ATTACK_DAMAGE);
					if (baseDamage <= 0)
						return;



				}
			}
		}
	}

	public static float DaggerCount(float fs, float baseDamage) {
		final float baseMult = fs / baseDamage;
		final float softCap = 100f;
		final float hardCap = 300f;
		final float maxOutput = 500f;

		if (baseDamage > softCap) {
			float decay = 0.7f - 0.2f * (baseDamage / hardCap);
			float scaled = softCap * baseMult;

			float bonus = (float) (Math.log(baseDamage + 1) / Math.log(softCap)) * scaled * decay;
			return Math.min(Math.max(bonus, scaled), maxOutput + baseDamage * 0.2f);
		}
		return Math.min(baseDamage * baseMult, maxOutput);
	}

	@SubscribeEvent
	public static void addWeaponDamage(LivingDamageEvent event) {
		LivingEntity entity = event.getEntity();
		Entity attackBy = event.getSource().getEntity();
		float amount = event.getAmount();
		if (entity == null || !entity.isAlive())
			return;
		if (attackBy != null) {
			ItemStack handItem = null;
			ItemStack otherHandItem = null;
			if (attackBy instanceof LivingEntity living) {
				handItem = living.getMainHandItem();
				otherHandItem = living.getOffhandItem();
				if (!EntityAndItemFind.MeleeDamageFromMainHandNotOffHand(living)) {
					handItem = living.getOffhandItem();
					otherHandItem = living.getMainHandItem();
				}
			}
			if (attackBy instanceof LivingEntity living) {
				if (((attackBy instanceof Mob || attackBy instanceof Player)) && event.getSource().getDirectEntity() == living && EntityAndItemFind.isMeleeDamage(event.getSource())) {
					if (living.getAttribute(Attributes.ATTACK_DAMAGE) != null) {
						float baseDamage = (float) living.getAttributeValue(Attributes.ATTACK_DAMAGE);
						if (baseDamage <= 0)
							return;
					}
				}
			}
		}
	}

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
			if (hasCurio(entity, JVPillageItems.HAG_EYE.get())) {
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
			if (hasCurio(entity, JVPillageItems.PURPLE_SAND_HAG_EYE.get())) {
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


	@SubscribeEvent
	public static void TaczAboutMerorDamage(JerotesMerorDamageEvent event) {
		DamageSource damageSource = event.getDamageSource();
		if (damageSource == null)
			return;

		if (ModList.get().isLoaded("tacz")) {
			try {
				Class<?> entityKineticBulletClass = Class.forName("com.tacz.guns.entity.EntityKineticBullet");
				Class<?> modernKineticGunItemClass = Class.forName("com.tacz.guns.item.ModernKineticGunItem");

				if (damageSource.getDirectEntity() != null) {
					if (entityKineticBulletClass.isInstance(damageSource.getDirectEntity())) {
						Object bullet = damageSource.getDirectEntity();
						Method getAmmoIdMethod = entityKineticBulletClass.getMethod("getAmmoId");
						ResourceLocation ammoId = (ResourceLocation) getAmmoIdMethod.invoke(bullet);

						if (ammoId.toString().equals("merorsenergeticgun:meror_energy_bottles")) {
							event.setMerorDamage(true);
						}
					}
				}

				if (EntityAndItemFind.isMeleeDamage(damageSource) && damageSource.getEntity() instanceof LivingEntity livingEntity) {
					ItemStack handItem = livingEntity.getMainHandItem();
					ItemStack otherHandItem = livingEntity.getOffhandItem();
					if (!EntityAndItemFind.MeleeDamageFromMainHandNotOffHand(livingEntity)) {
						handItem = livingEntity.getOffhandItem();
						otherHandItem = livingEntity.getOffhandItem();
					}
					if (modernKineticGunItemClass.isInstance(handItem.getItem())) {
						Object gunItem = handItem.getItem();
						Method getGunIdMethod = modernKineticGunItemClass.getMethod("getGunId", ItemStack.class);
						ResourceLocation gunId = (ResourceLocation) getGunIdMethod.invoke(gunItem, handItem);

						String string = gunId.toString();
						if (string.equals("merorsenergeticgun:crimson_cunpowder_storm")
								|| string.equals("merorsenergeticgun:meror_guardian_pistol_iv")
								|| string.equals("merorsenergeticgun:star_breaker_assault_rifle")) {
							event.setMerorDamage(true);
						}
					}
				}
			} catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
					 InvocationTargetException e) {
			}
		}
	}
}