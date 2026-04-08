package com.jerotes.jerotesvillage.event;

import com.jerotes.jerotes.entity.Interface.EliteEntity;
import com.jerotes.jerotes.spell.SpellList;
import com.jerotes.jerotes.util.EntityAndItemFind;
import com.jerotes.jerotes.util.EntityFactionFind;
import com.jerotes.jerotesvillage.JerotesVillage;
import com.jerotes.jerotesvillage.entity.Boss.OminousBannerProjectionEntity;
import com.jerotes.jerotesvillage.entity.Monster.IllagerFaction.NecromancyWarlockEntity;
import com.jerotes.jerotesvillage.init.JerotesVillageItems;
import com.jerotes.jerotesvillage.init.JerotesVillageParticleTypes;
import com.jerotes.jerotesvillage.init.JerotesVillageSoundEvents;
import com.jerotes.jerotesvillage.item.BaseHagEye;
import com.jerotes.jerotesvillage.spell.OtherSpellList;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.VillagerDataHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.armortrim.ArmorTrim;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.util.List;
import java.util.Optional;


@Mod.EventBusSubscriber
public class ArmorEvent {
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

	//神汉天冠
	@SubscribeEvent
	public static boolean WarlockTiara(LivingHurtEvent event) {
		if (event == null || event.getEntity() == null || event.getSource() == null) {return false;}
		LivingEntity living = event.getEntity();
		DamageSource source = event.getSource();
		float originalAmount = event.getAmount();
		float maxHealth = living.getMaxHealth();
		if (living.level().isClientSide()) return false;
		if (source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) return false;
		if (originalAmount > maxHealth * 20) return false;
		boolean hasTiara = living.getItemBySlot(EquipmentSlot.HEAD).getItem() == JerotesVillageItems.WARLOCK_TIARA.get() || hasCurio(living, JerotesVillageItems.WARLOCK_TIARA.get());
		if (hasTiara) {
			if (EntityAndItemFind.MagicResistance(source)) {
				float newAmount = originalAmount * 0.8f;
				if (!Float.isNaN(newAmount) && !Float.isInfinite(newAmount)) {
					event.setAmount(newAmount);
				}
			}
			if (living.getRandom().nextFloat() < 0.2f) {
				OtherSpellList.EvilSummoning(3, living, living).spellUse();
			}
		}
		List<Mob> enemies = living.level().getEntitiesOfClass(Mob.class, living.getBoundingBox().inflate(32.0, 32.0, 32.0));
		enemies.removeIf(entity -> entity == living || entity.getTarget() == living || !((EntityFactionFind.isRaider(entity) && living.getTeam() == null && entity.getTeam() == null) || entity.isAlliedTo(living)));
		enemies.removeIf(entity -> entity instanceof NecromancyWarlockEntity || entity instanceof OminousBannerProjectionEntity || entity.getItemBySlot(EquipmentSlot.HEAD).getItem() == JerotesVillageItems.WARLOCK_TIARA.get() || hasCurio(entity, JerotesVillageItems.WARLOCK_TIARA.get()));
		float chance = 0.5f + enemies.size() * 0.05f;
		if (!enemies.isEmpty() && hasTiara && living.level().getRandom().nextFloat() < chance) {
			Mob target = enemies.stream().filter(e -> e != null && e.isAlive()).findFirst().orElse(null);
			if (target != null) {
				ServerLevel serverLevel = living.level() instanceof ServerLevel sl ? sl : null;
				spawnDamageIndicatorParticles(serverLevel, living);
				living.teleportTo(target.getX(), target.getY(), target.getZ());
				spawnDamageIndicatorParticles(serverLevel, living);
				if (serverLevel != null && !living.isInvisible()) {
					serverLevel.sendParticles(JerotesVillageParticleTypes.OMINOUS_SELECTION_DISPLAY.get(),
							living.getX(), living.getBoundingBox().maxY + 0.5, living.getZ(), 0, 0.0, 0.0, 0.0, 0);
				}
				if (!living.isSilent() && living.getRandom().nextFloat() < 0.5f) {
					living.level().playSound(null, living.getX(), living.getY(), living.getZ(),
							JerotesVillageSoundEvents.NECROMANCY_WARLOCK_SELECTION, living.getSoundSource(),
							5.0f, 0.8f + living.getRandom().nextFloat() * 0.4f);
				}
				target.hurt(source, originalAmount * 0.8f);
				event.setCanceled(true);
				return false;
			}
		}
		return false;
	}
	private static void spawnDamageIndicatorParticles(ServerLevel level, LivingEntity entity) {
		if (level == null) return;
		for (int i = 0; i < 24; i++) {
			level.sendParticles(ParticleTypes.DAMAGE_INDICATOR, entity.getRandomX(0.5f), entity.getRandomY(), entity.getRandomZ(0.5f), 0, 0, 0.0, 0, 0.0);
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

