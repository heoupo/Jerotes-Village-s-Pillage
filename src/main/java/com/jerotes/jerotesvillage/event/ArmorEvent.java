package com.jerotes.jerotesvillage.event;

import com.jerotes.jerotes.entity.Interface.EliteEntity;
import com.jerotes.jerotes.spell.SpellList;
import com.jerotes.jerotes.util.EntityAndItemFind;
import com.jerotes.jerotesvillage.JerotesVillage;
import com.jerotes.jerotesvillage.init.JerotesVillageItems;
import com.jerotes.jerotesvillage.item.BaseHagEye;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.VillagerDataHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.armortrim.ArmorTrim;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Optional;


@Mod.EventBusSubscriber
public class ArmorEvent {

	//大巫婆之帽
	@SubscribeEvent
	public static void BigWitchsHat(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			LivingEntity livingEntity = event.getEntity();
			DamageSource damageSource = event.getSource();
			if (damageSource == null || livingEntity == null)
				return;
			if (!livingEntity.level().isClientSide()) {
				if (damageSource.is(DamageTypeTags.WITCH_RESISTANT_TO)) {
					if (livingEntity.getItemBySlot(EquipmentSlot.HEAD).getItem() == JerotesVillageItems.BIG_WITCHS_HAT.get()) {
						SpellList.MagicAbsorption(3, livingEntity, livingEntity).spellUse();
						float newAmount = event.getAmount() - event.getAmount() * 0.3f;
						if (Float.isNaN(newAmount) || Float.isInfinite(newAmount)) {
							newAmount = 0f;
						}
						event.setAmount(newAmount);
					}
				}
			}
		}
	}


	//鬼婆之眼
	@SubscribeEvent
	public static void HagEye(LivingEvent.LivingTickEvent event) {
		LivingEntity livingEntity = event.getEntity();
		if (livingEntity == null)
			return;
		if (livingEntity.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof BaseHagEye) {
			if (!livingEntity.level().isClientSide()) {
				livingEntity.addEffect(new MobEffectInstance((MobEffects.NIGHT_VISION), 255, 0, false, false), livingEntity);
			}
		}
	}
	//元素纹饰
	@SubscribeEvent
	public static void ElementHurt(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			LivingEntity livingEntity = event.getEntity();
			DamageSource damageSource = event.getSource();
			if (damageSource == null || livingEntity == null)
				return;
			if (!livingEntity.level().isClientSide()) {
				float damages = 1;
				Optional<ArmorTrim> head = ArmorTrim.getTrim(livingEntity.level().registryAccess(), livingEntity.getItemBySlot(EquipmentSlot.HEAD)
						//1.20.4↑//
						//, true
				);
				if (head.isPresent()) {
					ArmorTrim armorTrim = head.get();
					//火
					if (armorTrim.material().is(livingEntity.level().registryAccess().registryOrThrow(Registries.TRIM_MATERIAL).getHolder(ResourceKey.create(Registries.TRIM_MATERIAL, new ResourceLocation(JerotesVillage.MODID, "fire_secretor_adhesive"))).get().key())) {
						if (damageSource.is(DamageTypeTags.IS_FIRE)) {
							damages -= 0.08f;
						}
					}
					//冰
					if (armorTrim.material().is(livingEntity.level().registryAccess().registryOrThrow(Registries.TRIM_MATERIAL).getHolder(ResourceKey.create(Registries.TRIM_MATERIAL, new ResourceLocation(JerotesVillage.MODID, "frost_yeti_hair"))).get().key())) {
						if (damageSource.is(DamageTypeTags.IS_FREEZING)) {
							damages -= 0.08f;
						}
					}
					//雷
					if (armorTrim.material().is(livingEntity.level().registryAccess().registryOrThrow(Registries.TRIM_MATERIAL).getHolder(ResourceKey.create(Registries.TRIM_MATERIAL, new ResourceLocation(JerotesVillage.MODID, "lightning_worm_chitin"))).get().key())) {
						if (damageSource.is(DamageTypeTags.IS_LIGHTNING)) {
							damages -= 0.08f;
						}
					}
					//水
					if (armorTrim.material().is(livingEntity.level().registryAccess().registryOrThrow(Registries.TRIM_MATERIAL).getHolder(ResourceKey.create(Registries.TRIM_MATERIAL, new ResourceLocation(JerotesVillage.MODID, "malignasaur_teeth"))).get().key())) {
						if (damageSource.is(DamageTypeTags.IS_DROWNING)) {
							damages -= 0.08f;
						}
					}
				}
				Optional<ArmorTrim> chestplate = ArmorTrim.getTrim(livingEntity.level().registryAccess(), livingEntity.getItemBySlot(EquipmentSlot.CHEST)
						//1.20.4↑//
						//, true
				);
				if (chestplate.isPresent()) {
					ArmorTrim armorTrim = chestplate.get();
					//火
					if (armorTrim.material().is(livingEntity.level().registryAccess().registryOrThrow(Registries.TRIM_MATERIAL).getHolder(ResourceKey.create(Registries.TRIM_MATERIAL, new ResourceLocation(JerotesVillage.MODID, "fire_secretor_adhesive"))).get().key())) {
						if (damageSource.is(DamageTypeTags.IS_FIRE)) {
							damages -= 0.08f;
						}
					}
					//冰
					if (armorTrim.material().is(livingEntity.level().registryAccess().registryOrThrow(Registries.TRIM_MATERIAL).getHolder(ResourceKey.create(Registries.TRIM_MATERIAL, new ResourceLocation(JerotesVillage.MODID, "frost_yeti_hair"))).get().key())) {
						if (damageSource.is(DamageTypeTags.IS_FREEZING)) {
							damages -= 0.08f;
						}
					}
					//雷
					if (armorTrim.material().is(livingEntity.level().registryAccess().registryOrThrow(Registries.TRIM_MATERIAL).getHolder(ResourceKey.create(Registries.TRIM_MATERIAL, new ResourceLocation(JerotesVillage.MODID, "lightning_worm_chitin"))).get().key())) {
						if (damageSource.is(DamageTypeTags.IS_LIGHTNING)) {
							damages -= 0.08f;
						}
					}
					//水
					if (armorTrim.material().is(livingEntity.level().registryAccess().registryOrThrow(Registries.TRIM_MATERIAL).getHolder(ResourceKey.create(Registries.TRIM_MATERIAL, new ResourceLocation(JerotesVillage.MODID, "malignasaur_teeth"))).get().key())) {
						if (damageSource.is(DamageTypeTags.IS_DROWNING)) {
							damages -= 0.08f;
						}
					}
				}
				Optional<ArmorTrim> leggings = ArmorTrim.getTrim(livingEntity.level().registryAccess(), livingEntity.getItemBySlot(EquipmentSlot.LEGS)
						//1.20.4↑//
						//, true
				);
				if (leggings.isPresent()) {
					ArmorTrim armorTrim = leggings.get();
					//火
					if (armorTrim.material().is(livingEntity.level().registryAccess().registryOrThrow(Registries.TRIM_MATERIAL).getHolder(ResourceKey.create(Registries.TRIM_MATERIAL, new ResourceLocation(JerotesVillage.MODID, "fire_secretor_adhesive"))).get().key())) {
						if (damageSource.is(DamageTypeTags.IS_FIRE)) {
							damages -= 0.08f;
						}
					}
					//冰
					if (armorTrim.material().is(livingEntity.level().registryAccess().registryOrThrow(Registries.TRIM_MATERIAL).getHolder(ResourceKey.create(Registries.TRIM_MATERIAL, new ResourceLocation(JerotesVillage.MODID, "frost_yeti_hair"))).get().key())) {
						if (damageSource.is(DamageTypeTags.IS_FREEZING)) {
							damages -= 0.08f;
						}
					}
					//雷
					if (armorTrim.material().is(livingEntity.level().registryAccess().registryOrThrow(Registries.TRIM_MATERIAL).getHolder(ResourceKey.create(Registries.TRIM_MATERIAL, new ResourceLocation(JerotesVillage.MODID, "lightning_worm_chitin"))).get().key())) {
						if (damageSource.is(DamageTypeTags.IS_LIGHTNING)) {
							damages -= 0.08f;
						}
					}
					//水
					if (armorTrim.material().is(livingEntity.level().registryAccess().registryOrThrow(Registries.TRIM_MATERIAL).getHolder(ResourceKey.create(Registries.TRIM_MATERIAL, new ResourceLocation(JerotesVillage.MODID, "malignasaur_teeth"))).get().key())) {
						if (damageSource.is(DamageTypeTags.IS_DROWNING)) {
							damages -= 0.08f;
						}
					}
				}
				Optional<ArmorTrim> boots = ArmorTrim.getTrim(livingEntity.level().registryAccess(), livingEntity.getItemBySlot(EquipmentSlot.FEET)
						//1.20.4↑//
						//, true
				);
				if (boots.isPresent()) {
					ArmorTrim armorTrim = boots.get();
					//火
					if (armorTrim.material().is(livingEntity.level().registryAccess().registryOrThrow(Registries.TRIM_MATERIAL).getHolder(ResourceKey.create(Registries.TRIM_MATERIAL, new ResourceLocation(JerotesVillage.MODID, "fire_secretor_adhesive"))).get().key())) {
						if (damageSource.is(DamageTypeTags.IS_FIRE)) {
							damages -= 0.08f;
						}
					}
					//冰
					if (armorTrim.material().is(livingEntity.level().registryAccess().registryOrThrow(Registries.TRIM_MATERIAL).getHolder(ResourceKey.create(Registries.TRIM_MATERIAL, new ResourceLocation(JerotesVillage.MODID, "frost_yeti_hair"))).get().key())) {
						if (damageSource.is(DamageTypeTags.IS_FREEZING)) {
							damages -= 0.08f;
						}
					}
					//雷
					if (armorTrim.material().is(livingEntity.level().registryAccess().registryOrThrow(Registries.TRIM_MATERIAL).getHolder(ResourceKey.create(Registries.TRIM_MATERIAL, new ResourceLocation(JerotesVillage.MODID, "lightning_worm_chitin"))).get().key())) {
						if (damageSource.is(DamageTypeTags.IS_LIGHTNING)) {
							damages -= 0.08f;
						}
					}
					//水
					if (armorTrim.material().is(livingEntity.level().registryAccess().registryOrThrow(Registries.TRIM_MATERIAL).getHolder(ResourceKey.create(Registries.TRIM_MATERIAL, new ResourceLocation(JerotesVillage.MODID, "malignasaur_teeth"))).get().key())) {
						if (damageSource.is(DamageTypeTags.IS_DROWNING)) {
							damages -= 0.08f;
						}
					}
				}
				event.setAmount(event.getAmount() * damages);
			}
		}
	}

	//巨怪套装
	@SubscribeEvent
	public static void GiantMonsterHurt(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			LivingEntity livingEntity = event.getEntity();
			DamageSource damageSource = event.getSource();
			if (damageSource == null || livingEntity == null)
				return;
			boolean helmet = livingEntity.getItemBySlot(EquipmentSlot.HEAD).getItem() == JerotesVillageItems.GIANT_MONSTER_HELMET.get()
					|| livingEntity.getItemBySlot(EquipmentSlot.HEAD).getItem() == JerotesVillageItems.GIANT_MONSTER_HORNED_HELMET.get();
			boolean chestplate = livingEntity.getItemBySlot(EquipmentSlot.CHEST).getItem() == JerotesVillageItems.GIANT_MONSTER_CHESTPLATE.get();
			boolean leggings = livingEntity.getItemBySlot(EquipmentSlot.LEGS).getItem() == JerotesVillageItems.GIANT_MONSTER_LEGGINGS.get();
			boolean boots = livingEntity.getItemBySlot(EquipmentSlot.FEET).getItem() == JerotesVillageItems.GIANT_MONSTER_BOOTS.get();
			if (!livingEntity.level().isClientSide()) {
				if (damageSource.is(DamageTypeTags.IS_FREEZING)) {
					float damages = 1;
					if (helmet) {
						damages -= 0.16f;
					}
					if (chestplate) {
						damages -= 0.16f;
					}
					if (leggings) {
						damages -= 0.16f;
					}
					if (boots) {
						damages -= 0.16f;
					}
					event.setAmount(event.getAmount() * damages);
				}
			}
		}
	}
	//奴制监督者套装
	@SubscribeEvent
	public static void SlaverySupervisorDeath(LivingDeathEvent event) {
		LivingEntity livingEntity = event.getEntity();
		DamageSource damageSource = event.getSource();
		Entity entity = event.getSource().getEntity();
		if (entity instanceof Player player && livingEntity != null && damageSource != null) {
			if (livingEntity.level().isClientSide()) {
				return;
			}
			if (livingEntity instanceof AbstractIllager || livingEntity instanceof AbstractVillager) {
				boolean helmet = player.getItemBySlot(EquipmentSlot.HEAD).getItem() == JerotesVillageItems.SLAVERY_SUPERVISOR_HELMET.get();
				boolean chestplate = player.getItemBySlot(EquipmentSlot.CHEST).getItem() == JerotesVillageItems.SLAVERY_SUPERVISOR_CHESTPLATE.get();
				boolean leggings = player.getItemBySlot(EquipmentSlot.LEGS).getItem() == JerotesVillageItems.SLAVERY_SUPERVISOR_LEGGINGS.get();
				boolean boots = player.getItemBySlot(EquipmentSlot.FEET).getItem() == JerotesVillageItems.SLAVERY_SUPERVISOR_BOOTS.get();
				if (!(helmet || chestplate || leggings || boots)) return;
				if (livingEntity.isBaby()) return;

				int chance = 100;
				if (helmet) {
					chance -= 18;
				}
				if (chestplate) {
					chance -= 18;
				}
				if (leggings) {
					chance -= 18;
				}
				if (boots) {
					chance -= 18;
				}

				//boss和精英
				if (EntityAndItemFind.isBoss(livingEntity.getType())) {
					chance -= 16;
				}
				else if (livingEntity instanceof EliteEntity) {
					chance -= 10;
				}
				//村民等级
				if (livingEntity instanceof VillagerDataHolder villagerDataHolder) {
					chance -= villagerDataHolder.getVillagerData().getLevel() * 2;
				}

				//boss和精英
				int count = EntityAndItemFind.isBoss(livingEntity.getType()) ? 10 : livingEntity instanceof EliteEntity eliteEntity ? 3 : 1;
				//村民等级
				if (livingEntity instanceof VillagerDataHolder villagerDataHolder) {
					count += villagerDataHolder.getVillagerData().getLevel();
				}
				//最低4
				int chance2 = Math.max(4, chance);
				int reward = player.getRandom().nextInt(chance2);
				ItemStack itemStack2 = new ItemStack(Items.AIR, 1);
				if (reward <= 4) {
					itemStack2 = new ItemStack(Items.EMERALD, 2 * count);
				}
				else if (reward <= 12) {
					itemStack2 = new ItemStack(Items.EMERALD, count);
				}

				if (reward <= 12) {
					ItemEntity itemEntity = livingEntity.spawnAtLocation(itemStack2, 1);
					if (itemEntity != null) {
						itemEntity.setPos(livingEntity.getX(), livingEntity.getEyeY(), livingEntity.getZ());
					}
				}
			}
		}
	}
}

