package com.jerotes.jerotesvillage.spell;

import com.jerotes.jerotes.entity.Other.SpellCloud.RainSpellCloudEntity;
import com.jerotes.jerotes.entity.Other.SpellCloud.SpellCloudEntity;
import com.jerotes.jerotes.forge.JerotesStopSpellEvent;
import com.jerotes.jerotes.init.JerotesDamageTypes;
import com.jerotes.jerotes.util.AttackFind;
import com.jerotes.jerotes.util.EntityFactionFind;
import com.jerotes.jerotes.util.Main;
import com.jerotes.jerotes.util.ParticlesUse;
import com.jerotes.jerotesvillage.entity.Animal.WildernessWolfEntity;
import com.jerotes.jerotesvillage.entity.MagicSummoned.IllagerLike.BlamerNecromancyWarlockEntity;
import com.jerotes.jerotesvillage.entity.MagicSummoned.IllagerLike.SliderAxCrazyEntity;
import com.jerotes.jerotesvillage.entity.Monster.Hag.CovenHagEntity;
import com.jerotes.jerotesvillage.entity.Monster.IllagerFaction.DefectorEntity;
import com.jerotes.jerotesvillage.entity.Monster.SpirveEntity;
import com.jerotes.jerotesvillage.entity.Other.BitterColdAltarEntity;
import com.jerotes.jerotesvillage.entity.Other.OminousGearEntity;
import com.jerotes.jerotesvillage.entity.Other.PurpleSandPhantomEntity;
import com.jerotes.jerotesvillage.entity.Other.UncleanTentacleEntity;
import com.jerotes.jerotesvillage.entity.Shoot.Magic.Breath.BloodyScreamEntity;
import com.jerotes.jerotesvillage.entity.Shoot.Magic.Cloud.UncleanBloodRainEntity;
import com.jerotes.jerotesvillage.entity.Shoot.Magic.MagicMissile.ArcaneLightSpotEntity;
import com.jerotes.jerotesvillage.entity.Shoot.Magic.MagicShoot.BitterColdFrostbiteEntity;
import com.jerotes.jerotesvillage.entity.Shoot.Magic.MagicShoot.OminousFlamesEntity;
import com.jerotes.jerotesvillage.entity.Shoot.Magic.MagicShoot.RadiantBombEntity;
import com.jerotes.jerotesvillage.entity.Shoot.Magic.MagicThrow.BitterColdIceSpikeEntity;
import com.jerotes.jerotesvillage.entity.Shoot.Magic.MagicThrow.ElasticIceRockEntity;
import com.jerotes.jerotesvillage.entity.Shoot.Magic.MagicThrow.ElasticLightBallEntity;
import com.jerotes.jerotesvillage.entity.Shoot.Magic.Ray.PushForceEntity;
import com.jerotes.jerotesvillage.entity.Shoot.Magic.Ray.SlaverySupervisorChainEntity;
import com.jerotes.jerotesvillage.entity.Shoot.Magic.Target.FloatingForceEntity;
import com.jerotes.jerotesvillage.entity.Shoot.Magic.Target.GravityForceEntity;
import com.jerotes.jerotesvillage.init.JerotesVillageEntityType;
import com.jerotes.jerotesvillage.init.JerotesVillageItems;
import com.jerotes.jerotesvillage.init.JerotesVillageMobEffects;
import com.jerotes.jerotesvillage.init.JerotesVillageParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraftforge.common.MinecraftForge;

import java.util.List;

public class OtherSpellFind {
	//血腥尖啸$法术
	public static boolean BloodyScream(LivingEntity caster, Entity target, int spellLevelDamage, int spellLevelMainEffectTime, int spellLevelMainEffectLevel, float spellLevelAccuracy, int count, float distance, boolean isPlayer) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			BloodyScreamEntity breath;
			for (int i = 0; i < count; ++i) {
				if (!isPlayer && target != caster && caster instanceof Mob mob && target != null) {
					mob.getLookControl().setLookAt(target, 360.0f, 360.0f);
					mob.lookAt(target, 360.0f, 360.0f);
				}
				breath = new BloodyScreamEntity(spellLevelDamage, spellLevelMainEffectTime, spellLevelMainEffectLevel, serverLevel, caster, caster.getLookAngle().x, caster.getLookAngle().y, caster.getLookAngle().z);
				breath.setPos(caster.getX(), caster.getY(0.7), caster.getZ());
				breath.shootFromRotation(caster, caster.getXRot(), (caster.getYRot() - ((count - 1) * distance) / 2 + i * distance), 0f, 1f, spellLevelAccuracy);
				breath.setOwner(caster);
				serverLevel.addFreshEntity(breath);
			}
		}
		return true;
	}
	//弹力冰岩$法术
	public static boolean ElasticIceRock(LivingEntity caster, Entity target, int spellLevelDamage, int spellLevelFreezeTime, float spellLevelSpeed, float spellLevelAccuracy, int count, float distance, boolean isPlayer) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			ElasticIceRockEntity iceRock;
			for (int i = 0; i < count; ++i) {
				if (!isPlayer && target != caster && caster instanceof Mob mob && target != null) {
					mob.getLookControl().setLookAt(target, 360.0f, 360.0f);
					mob.lookAt(target, 360.0f, 360.0f);
				}
				iceRock = new ElasticIceRockEntity(spellLevelDamage, spellLevelFreezeTime, serverLevel, caster);
				iceRock.shootFromRotation(caster, caster.getXRot(), (caster.getYRot() - ((count - 1) * distance) / 2 + i * distance), 0.0f, spellLevelSpeed, spellLevelAccuracy);
				iceRock.setOwner(caster);
				serverLevel.addFreshEntity(iceRock);
			}
		}
		return true;
	}
	//血怨魂援$法术
	public static boolean BloodyBlameSoulAssist(LivingEntity caster, int countMin, int countMax, int summonDistance) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			PlayerTeam teams = (PlayerTeam) caster.getTeam();
			int count = countMin;
			if (countMin < countMax) {
				count = caster.getRandom().nextInt(countMin, countMax);
			}
			for (int i = 0; i < count; ++i) {
				BlockPos summonPos = Main.findSpawnPositionNearFillOnBlock(caster, summonDistance);
				if (caster instanceof Player) {
					Vec3 startPos = caster.getEyePosition(1.0f);
					Vec3 viewVector = caster.getViewVector(1.0f);
					Vec3 endPos = startPos.add(viewVector.scale(summonDistance));

					BlockHitResult hitResult = serverLevel.clip(new ClipContext(
							startPos, endPos,
							ClipContext.Block.COLLIDER,
							ClipContext.Fluid.ANY,
							caster
					));
					Vec3 targetPos = Main.adjustPositionForSolidHit(hitResult, startPos, viewVector, summonDistance);
					BlockPos playerSummonPos = Main.findSafePosition(serverLevel, targetPos);
					if (playerSummonPos != null && serverLevel.getBlockState(playerSummonPos).isAir()) {
						summonPos = playerSummonPos;
					}
				}
				BlamerNecromancyWarlockEntity blamerNecromancyWarlockEntity = JerotesVillageEntityType.BLAMER_NECROMANCY_WARLOCK.get().spawn(serverLevel, BlockPos.containing(summonPos.getX(), summonPos.getY(), summonPos.getZ()), MobSpawnType.MOB_SUMMONED);
				if (blamerNecromancyWarlockEntity != null) {
					blamerNecromancyWarlockEntity.setTame(true);
					blamerNecromancyWarlockEntity.setOwnerUUID(caster.getUUID());
					if (caster instanceof Player player) {
						blamerNecromancyWarlockEntity.setChangeType(2, player);
					}
					else {
						blamerNecromancyWarlockEntity.setChangeType(2);
						if (caster instanceof Mob mob && mob.getTarget() != null) {
							blamerNecromancyWarlockEntity.setTarget(mob);
						}
					}
					if (caster instanceof Mob mob && mob.getTarget() != null) {
						blamerNecromancyWarlockEntity.setTarget(mob.getTarget());
					}
					//buff集群
					blamerNecromancyWarlockEntity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0, false, true), blamerNecromancyWarlockEntity);
					blamerNecromancyWarlockEntity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1, false, true), blamerNecromancyWarlockEntity);
					//粒子效果
					Item totemItem = JerotesVillageItems.TOTEM_OF_FILTHINESS_GOD.get();
					ItemStack itemStack = new ItemStack(totemItem);
					for (int n2 = 0; n2 < 128; ++n2) {
						serverLevel.sendParticles(ParticleTypes.TOTEM_OF_UNDYING,
								blamerNecromancyWarlockEntity.getRandomX(3), blamerNecromancyWarlockEntity.getRandomY(), blamerNecromancyWarlockEntity.getRandomZ(3),
								0, 0.0, 0.0, 0.0,
								0);
					}
					for(int n = 0; n < 16; ++n) {
						serverLevel.sendParticles(new ItemParticleOption(ParticleTypes.ITEM, itemStack),
								blamerNecromancyWarlockEntity.getRandomX((double)0.5F),
								blamerNecromancyWarlockEntity.getRandomY(), blamerNecromancyWarlockEntity.getRandomZ((double)0.5F),
								0, (double)0.0F, (double)0.0F, (double)0.0F, (double)0.0F);
					}
					serverLevel.sendParticles(JerotesVillageParticleTypes.TARGET.get(), blamerNecromancyWarlockEntity.getX(), blamerNecromancyWarlockEntity.getY() + 0.1, blamerNecromancyWarlockEntity.getZ(), 0, 0.0, 0.0, 0.0, 0.0);
				}
			}
			serverLevel.gameEvent(GameEvent.ENTITY_PLACE, new BlockPos((int) caster.getX(), (int) caster.getY(), (int) caster.getZ()), GameEvent.Context.of(caster));
		}
		return true;
	}
	//斧相滑壳$法术
	public static boolean CohesionSlideAxe(LivingEntity caster, int countMin, int countMax, int summonDistance) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			PlayerTeam teams = (PlayerTeam) caster.getTeam();
			int count = countMin;
			if (countMin < countMax) {
				count = caster.getRandom().nextInt(countMin, countMax);
			}
			for (int i = 0; i < count; ++i) {
				BlockPos summonPos = Main.findSpawnPositionNearFillOnBlock(caster, summonDistance);
				if (caster instanceof Player) {
					Vec3 startPos = caster.getEyePosition(1.0f);
					Vec3 viewVector = caster.getViewVector(1.0f);
					Vec3 endPos = startPos.add(viewVector.scale(summonDistance));

					BlockHitResult hitResult = serverLevel.clip(new ClipContext(
							startPos, endPos,
							ClipContext.Block.COLLIDER,
							ClipContext.Fluid.ANY,
							caster
					));
					Vec3 targetPos = Main.adjustPositionForSolidHit(hitResult, startPos, viewVector, summonDistance);
					BlockPos playerSummonPos = Main.findSafePosition(serverLevel, targetPos);
					if (playerSummonPos != null && serverLevel.getBlockState(playerSummonPos).isAir()) {
						summonPos = playerSummonPos;
					}
				}
				SliderAxCrazyEntity sliderAxCrazyEntity = JerotesVillageEntityType.SLIDER_AX_CRAZY.get().spawn(serverLevel, BlockPos.containing(summonPos.getX(), summonPos.getY(), summonPos.getZ()), MobSpawnType.MOB_SUMMONED);
				if (sliderAxCrazyEntity != null) {
					sliderAxCrazyEntity.setTame(true);
					sliderAxCrazyEntity.setOwnerUUID(caster.getUUID());
					if (caster instanceof Player player) {
						sliderAxCrazyEntity.setChangeType(2, player);
					}
					else {
						sliderAxCrazyEntity.setChangeType(2);
						if (caster instanceof Mob mob && mob.getTarget() != null) {
							sliderAxCrazyEntity.setTarget(mob);
						}
					}
					if (caster instanceof Mob mob && mob.getTarget() != null) {
						sliderAxCrazyEntity.setTarget(mob.getTarget());
					}
					//粒子效果
					Item totemItem = JerotesVillageItems.DEVOURING_AXE_ALIVE_COLLOID.get();
					ItemStack itemStack = new ItemStack(totemItem);
					for(int n = 0; n < 16; ++n) {
						serverLevel.sendParticles(new ItemParticleOption(ParticleTypes.ITEM, itemStack),
								sliderAxCrazyEntity.getRandomX((double)0.5F),
								sliderAxCrazyEntity.getRandomY(), sliderAxCrazyEntity.getRandomZ((double)0.5F),
								0, (double)0.0F, (double)0.0F, (double)0.0F, (double)0.0F);
					}
					serverLevel.sendParticles(JerotesVillageParticleTypes.TARGET.get(), sliderAxCrazyEntity.getX(), sliderAxCrazyEntity.getY() + 0.1, sliderAxCrazyEntity.getZ(), 0, 0.0, 0.0, 0.0, 0.0);
				}
			}
			serverLevel.gameEvent(GameEvent.ENTITY_PLACE, new BlockPos((int) caster.getX(), (int) caster.getY(), (int) caster.getZ()), GameEvent.Context.of(caster));
		}
		return true;
	}
	//苦寒冰锥$法术
	public static boolean BitterColdIceSpike(LivingEntity caster, Entity target, int spellLevelDamage, int spellLevelFreezeTime, float spellLevelSpeed, float spellLevelAccuracy, int count, float distance, boolean isPlayer) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			BitterColdIceSpikeEntity iceSpike;
			for (int i = 0; i < count; ++i) {
				if (!isPlayer && target != caster && caster instanceof Mob mob && target != null) {
					mob.getLookControl().setLookAt(target, 360.0f, 360.0f);
					mob.lookAt(target, 360.0f, 360.0f);
				}
				iceSpike = new BitterColdIceSpikeEntity(spellLevelDamage, spellLevelFreezeTime, serverLevel, caster);
				iceSpike.shootFromRotation(caster, caster.getXRot(), (caster.getYRot() - ((count - 1) * distance) / 2 + i * distance), 0.0f, spellLevelSpeed, spellLevelAccuracy);
				iceSpike.setOwner(caster);
				serverLevel.addFreshEntity(iceSpike);
			}
		}
		return true;
	}
	//苦寒冰霜$法术
	public static boolean BitterColdFrostbite(LivingEntity caster, Entity target, int spellLevelDamage, int spellLevelFreezeTime, float spellLevelAccuracy, int count, float distance, int tickCount, boolean isPlayer) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			BitterColdFrostbiteEntity spell;
			for (int i = 0; i < count; ++i) {
				if (!isPlayer && target != caster && caster instanceof Mob mob && target != null) {
					mob.getLookControl().setLookAt(target, 360.0f, 360.0f);
					mob.lookAt(target, 360.0f, 360.0f);
				}
				double d2 = caster.getLookAngle().x;
				double d3 = caster.getLookAngle().y;
				double d4 = caster.getLookAngle().z;
				spell = new BitterColdFrostbiteEntity(spellLevelDamage, spellLevelFreezeTime, serverLevel, caster, d2, d3, d4);
				spell.setPos(caster.getX(), caster.getY(0.7) - spell.getBbHeight()/2, caster.getZ());
				spell.shootFromRotation(caster, caster.getXRot(), (caster.getYRot() - ((count - 1) * distance) / 2 + i * distance), 0f, 1f, spellLevelAccuracy);
				spell.setOwner(caster);
				serverLevel.addFreshEntity(spell);
			}
		}
		return true;
	}
	//弹力光球$法术
	public static boolean ElasticLightBall(LivingEntity caster, Entity target, int spellLevelDamage, int spellLevelMainEffectTime, int spellLevelMainEffectLevel, float spellLevelSpeed, float spellLevelAccuracy, int count, float distance, boolean isPlayer) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			ElasticLightBallEntity elasticLightBall;
			for (int i = 0; i < count; ++i) {
				if (!isPlayer && target != caster && caster instanceof Mob mob && target != null) {
					mob.getLookControl().setLookAt(target, 360.0f, 360.0f);
					mob.lookAt(target, 360.0f, 360.0f);
				}
				elasticLightBall = new ElasticLightBallEntity(spellLevelDamage, spellLevelMainEffectTime, spellLevelMainEffectLevel, serverLevel, caster);
				elasticLightBall.shootFromRotation(caster, caster.getXRot(), (caster.getYRot() - ((count - 1) * distance) / 2 + i * distance), 0.0f, spellLevelSpeed, spellLevelAccuracy);
				elasticLightBall.setOwner(caster);
				serverLevel.addFreshEntity(elasticLightBall);
			}
		}
		return true;
	}
	//不祥火舌$法术
	public static boolean OminousFlames(LivingEntity caster, Entity target, int spellLevelDamage, int spellLevelFireTime, float spellLevelAccuracy, int count, float distance, int tickCount, boolean isPlayer) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			OminousFlamesEntity spell;
			for (int i = 0; i < count; ++i) {
				if (!isPlayer && target != caster && caster instanceof Mob mob && target != null) {
					mob.getLookControl().setLookAt(target, 360.0f, 360.0f);
					mob.lookAt(target, 360.0f, 360.0f);
				}
				double d2 = caster.getLookAngle().x;
				double d3 = caster.getLookAngle().y;
				double d4 = caster.getLookAngle().z;
				spell = new OminousFlamesEntity(spellLevelDamage, spellLevelFireTime, serverLevel, caster, d2, d3, d4);
				spell.setPos(caster.getX(), caster.getY(0.7) - spell.getBbHeight()/2, caster.getZ());
				spell.shootFromRotation(caster, caster.getXRot(), (caster.getYRot() - ((count - 1) * distance) / 2 + i * distance), 0f, 1f, spellLevelAccuracy);
				spell.setOwner(caster);
				serverLevel.addFreshEntity(spell);
			}
		}
		return true;
	}
	//缴械牵扯
	public static boolean DisarmDrag(LivingEntity caster, Entity target, int spellLevelDamage, float spellLevelAccuracy, int count, float distance, boolean isPlayer) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			SlaverySupervisorChainEntity spell;
			for (int i = 0; i < count; ++i) {
				if (!isPlayer && target != caster && caster instanceof Mob mob && target != null) {
					mob.getLookControl().setLookAt(target, 360.0f, 360.0f);
					mob.lookAt(target, 360.0f, 360.0f);
				}
				spell = new SlaverySupervisorChainEntity(spellLevelDamage, serverLevel, caster, caster.getLookAngle().x, caster.getLookAngle().y, caster.getLookAngle().z);
				spell.setPos(caster.getX(), caster.getY(0.7) - spell.getBbHeight()/2, caster.getZ());
				spell.shootFromRotation(caster, caster.getXRot(), (caster.getYRot() - ((count - 1) * distance) / 2 + i * distance), 0f, 1f, spellLevelAccuracy);
				spell.setOwner(caster);
				serverLevel.addFreshEntity(spell);
			}
			if (!caster.isInvisible()) {
				serverLevel.sendParticles(JerotesVillageParticleTypes.DISARM_DRAG_DISPLAY.get(), caster.getX(), caster.getBoundingBox().maxY + 0.5, caster.getZ(), 0, 0.0, 0.0, 0.0, 0.0);
			}
		}
		return true;
	}
	//推动力场$法术
	public static boolean PushForce(LivingEntity caster, Entity target, int spellLevelDamage, float spellLevelXZPush, float spellLevelXZPushBase, float spellLevelYPush, float spellLevelYPushBase, float spellLevelAccuracy, int count, float distance, boolean isPlayer) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			PushForceEntity spell;
			for (int i = 0; i < count; ++i) {
				if (!isPlayer && target != caster && caster instanceof Mob mob && target != null) {
					mob.getLookControl().setLookAt(target, 360.0f, 360.0f);
					mob.lookAt(target, 360.0f, 360.0f);
				}
				double d2 = caster.getLookAngle().x;
				double d3 = caster.getLookAngle().y;
				double d4 = caster.getLookAngle().z;
				spell = new PushForceEntity(spellLevelDamage, spellLevelXZPush, spellLevelXZPushBase, spellLevelYPush, spellLevelYPushBase, serverLevel, caster, d2, d3, d4);
				spell.setPos(caster.getX(), caster.getY(0.7) - spell.getBbHeight()/2, caster.getZ());
				spell.shootFromRotation(caster, caster.getXRot(), (caster.getYRot() - ((count - 1) * distance) / 2 + i * distance), 0f, 1f, spellLevelAccuracy);
				spell.setOwner(caster);
				serverLevel.addFreshEntity(spell);
			}
		}
		return true;
	}
	//光芒爆弹$法术
	public static boolean RadiantBomb(LivingEntity caster, Entity target, int spellLevelDamage, float spellLevelExplode, int spellLevelMainEffectTime, int spellLevelMainEffectLevel, float spellLevelAccuracy, int count, float distance, boolean isPlayer) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			RadiantBombEntity spell;
			for (int i = 0; i < count; ++i) {
				if (!isPlayer && target != caster && caster instanceof Mob mob && target != null) {
					mob.getLookControl().setLookAt(target, 360.0f, 360.0f);
					mob.lookAt(target, 360.0f, 360.0f);
				}
				spell = new RadiantBombEntity(spellLevelDamage, spellLevelExplode, spellLevelMainEffectTime, spellLevelMainEffectLevel, serverLevel, caster, caster.getLookAngle().x, caster.getLookAngle().y, caster.getLookAngle().z);
				spell.setPos(caster.getX(), caster.getY(0.7), caster.getZ());
				spell.shootFromRotation(caster, caster.getXRot(), (caster.getYRot() - ((count - 1) * distance) / 2 + i * distance), 0f, 1f, spellLevelAccuracy);
				spell.setOwner(caster);
				serverLevel.addFreshEntity(spell);

				Vec3 pos = spell.position();
				for (int i2 = 0; i2 < 40; i2++) {
					double dx = (caster.getRandom().nextDouble() - 0.5) * 2.0;
					double dy = (caster.getRandom().nextDouble() - 0.5) * 2.0;
					double dz = (caster.getRandom().nextDouble() - 0.5) * 2.0;
					serverLevel.sendParticles(JerotesVillageParticleTypes.RADIANT_BOMB.get(),
							pos.x, pos.y, pos.z,
							1, dx, dy, dz, 0.05);
				}
			}
		}
		return true;
	}
	//奥术光点$法术
	public static boolean ArcaneLightSpot(LivingEntity caster, Entity target, int spellLevelDamage, int spellLevelMainEffectTime, int spellLevelMainEffectLevel, float spellLevelAccuracy, int count, float distance, int tickCount, boolean isPlayer) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			ArcaneLightSpotEntity spell;
			for (int i = 0; i < count; ++i) {
				if (!isPlayer && target != caster && caster instanceof Mob mob && target != null) {
					mob.getLookControl().setLookAt(target, 360.0f, 360.0f);
					mob.lookAt(target, 360.0f, 360.0f);
				}
				double d2 = caster.getLookAngle().x;
				double d3 = caster.getLookAngle().y;
				double d4 = caster.getLookAngle().z;
				spell = new ArcaneLightSpotEntity(spellLevelDamage, spellLevelMainEffectTime, spellLevelMainEffectLevel, serverLevel, caster, d2, d3, d4);
				spell.setPos(caster.getX(), caster.getY(0.7) - spell.getBbHeight()/2, caster.getZ());
				spell.shootFromRotation(caster, caster.getXRot(), (caster.getYRot() - ((count - 1) * distance) / 2 + i * distance), 0f, 1f, spellLevelAccuracy);
				spell.setOwner(caster);
				if (target != null && target != caster) {
					spell.setTarget(target);
				}
				serverLevel.addFreshEntity(spell);
			}
		}
		return true;
	}
	//宝石海浪$法术
	public static boolean GemstoneWaves(LivingEntity caster, int spellLevelDamage, int spellLevelMainEffectTime, int spellLevelMainEffectLevel, int spellLevelDistance, float spellLevelAngleReach, int spellLevelCount) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			caster.clearFire();
			int count = spellLevelCount;
			for (int i = 0; i < spellLevelCount * 20; ++i) {
				float f = (caster.getRandom().nextFloat() - 0.5f) * spellLevelDistance;
				float f2 = (caster.getRandom().nextFloat() - 0.5f) * spellLevelDistance;
				float f3 = (caster.getRandom().nextFloat() - 0.5f) * spellLevelDistance;
				for (int i2 = 0; i2 < 6; ++i2) {
					f = (caster.getRandom().nextFloat() - 0.5f) * spellLevelDistance;
					f2 = (caster.getRandom().nextFloat() - 0.5f) * spellLevelDistance;
					f3 = (caster.getRandom().nextFloat() - 0.5f) * spellLevelDistance;
					BlockState blockState = serverLevel.getBlockState(new BlockPos((int) (caster.getX() + f), (int) (caster.getEyeY() + f2 / 2f), (int) (caster.getZ(0.8) + f3)));
					FluidState fluidState = serverLevel.getFluidState(new BlockPos((int) (caster.getX() + f), (int) (caster.getEyeY() + f2 / 2f), (int) (caster.getZ(0.8) + f3)));
					if (Main.hasLineOfSightPos(new Vec3(caster.getX() + f, caster.getEyeY() + f2 / 2f, caster.getZ(0.8) + f3), caster)) {
						if (blockState.isAir() || !fluidState.isEmpty()) {
							if (Main.canSeeAngle(caster, new Vec3(caster.getX() + f, caster.getEyeY() + f2 / 2f, caster.getZ(0.8) + f3), spellLevelAngleReach)) {
								break;
							}
						}
					}
				}
				BlockState blockState = serverLevel.getBlockState(new BlockPos((int) (caster.getX() + f), (int) (caster.getEyeY() + f2 / 2f), (int) (caster.getZ(0.8) + f3)));
				FluidState fluidState = serverLevel.getFluidState(new BlockPos((int) (caster.getX() + f), (int) (caster.getEyeY() + f2 / 2f), (int) (caster.getZ(0.8) + f3)));
				if (Main.hasLineOfSightPos(new Vec3(caster.getX() + f, caster.getEyeY() + f2 / 2f, caster.getZ(0.8) + f3), caster)) {
					if (blockState.isAir() || !fluidState.isEmpty()) {
						if (Main.canSeeAngle(caster, new Vec3(caster.getX() + f, caster.getEyeY() + f2 / 2f, caster.getZ(0.8) + f3), spellLevelAngleReach)) {
							if (caster.getRandom().nextFloat() > 0.5f) {
								serverLevel.sendParticles(JerotesVillageParticleTypes.GEMSTONE_BUBBLE.get(), caster.getX() + f, caster.getEyeY() + f2 / 2f, caster.getZ(0.8) + f3, 0, f, f2, f3, 0.25f);
							} else if (caster.getRandom().nextFloat() < 0.25f) {
								serverLevel.sendParticles(ParticleTypes.BUBBLE_POP, caster.getX() + f, caster.getEyeY() + f2 / 2f, caster.getZ(0.8) + f3, 0, f, f2, f3, 0.25f);
							} else {
								serverLevel.sendParticles(ParticleTypes.FISHING, caster.getX() + f, caster.getEyeY() + f2 / 2f, caster.getZ(0.8) + f3, 0, f, f2, f3, 0.25f);
							}
						}
					}
				}
			}
			List<LivingEntity> list = serverLevel.getEntitiesOfClass(LivingEntity.class, caster.getBoundingBox().inflate(spellLevelDistance, spellLevelDistance / 2f, spellLevelDistance));
			for (LivingEntity livingEntityControl : list) {
				if (livingEntityControl == null) continue;
				if (count <= 0) break;
				if ((caster.distanceTo(livingEntityControl)) > spellLevelDistance * 2) continue;
				if (!Main.canSeeAngle(caster, livingEntityControl.getPosition(0.5f), spellLevelAngleReach)) continue;
				if (AttackFind.FindCanNotAttack(caster, livingEntityControl)) continue;
				if (!Main.hasLineOfSightEntity(livingEntityControl, caster)) continue;
				DamageSource damageSource = AttackFind.findDamageType(caster, JerotesDamageTypes.DROWN_MAGIC, caster);
				if (livingEntityControl.isSensitiveToWater()) {
					spellLevelDamage *= 5;
				}
				JerotesStopSpellEvent event = new JerotesStopSpellEvent(caster, null, null, livingEntityControl, 1, spellLevelDamage);
				MinecraftForge.EVENT_BUS.post(event);
				if (event.isCanceled()) {
					count -= 1;
					continue;
				}
				else {
					boolean bl = livingEntityControl.hurt(damageSource, spellLevelDamage * 3);
					if (bl) {
						if (!livingEntityControl.level().isClientSide) {
							livingEntityControl.addEffect(new MobEffectInstance(MobEffects.CONFUSION, spellLevelMainEffectTime * 20, spellLevelMainEffectLevel - 1), caster);
						}
					}
					if (bl) {
						livingEntityControl.clearFire();
						if (caster.isInWater()) {
							for (int i = 0; i < 5; ++i) {
								serverLevel.sendParticles(JerotesVillageParticleTypes.GEMSTONE_BUBBLE.get(), livingEntityControl.getRandomX(0.8), livingEntityControl.getRandomY(), livingEntityControl.getRandomZ(0.8), 0, 0.0, 0.0, 0.0, 0.0);
								serverLevel.sendParticles(JerotesVillageParticleTypes.GEMSTONE_BUBBLE_LAND.get(), livingEntityControl.getRandomX(0.8), livingEntityControl.getRandomY(), livingEntityControl.getRandomZ(0.8), 0, 0.0, 0.0, 0.0, 0.0);
							}
						}
						double d2 = livingEntityControl.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE);
						double d3 = Math.max(0, 1.0 - d2);
						livingEntityControl.push(-(caster.getX() - livingEntityControl.getX()) * 0.1 * d3, -(caster.getY() - livingEntityControl.getY()) * 0.02 * d3, -(caster.getZ() - livingEntityControl.getZ()) * 0.1 * d3);
					}
				}
				count -= 1;
			}
		}
		return true;
	}
	//漂浮力场$法术
	public static boolean FloatingForce(LivingEntity caster, int spellLevelDamage, int spellLevelDistance, int spellLevelCount) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			int count = spellLevelCount;
			//目标
			if (caster instanceof Mob mob && mob.getTarget() != null && count > 0 && !(caster.distanceTo(mob.getTarget()) > spellLevelDistance * 2) && !AttackFind.FindCanNotAttack(caster, mob.getTarget())) {
				FloatingForceEntity spell = new FloatingForceEntity(spellLevelDamage, serverLevel, caster, 0, 0, 0);
				spell.setPos(mob.getTarget().getX(), mob.getTarget().getEyeY(), mob.getTarget().getZ());
				spell.setOwner(caster);
				spell.setTarget(mob.getTarget());
				serverLevel.addFreshEntity(spell);
				count -= 1;
			}
			//其他
			List<LivingEntity> list = serverLevel.getEntitiesOfClass(LivingEntity.class, caster.getBoundingBox().inflate(spellLevelDistance, spellLevelDistance, spellLevelDistance));
			list.removeIf(livingEntity -> caster instanceof Mob mob && mob.getTarget() != null && livingEntity == mob.getTarget());
			for (LivingEntity livingEntity : list) {
				if (livingEntity == null) continue;
				if (count <= 0) break;
				if (AttackFind.FindCanNotAttack(caster, livingEntity)) continue;
//				boolean bl2 = (livingEntity instanceof Mob mob && mob.getTarget() == caster || caster instanceof Mob mob1 && mob1.getTarget() == livingEntity)
//						|| (livingEntity instanceof Player && caster instanceof Enemy)
//						|| (livingEntity.getTeam() != null && caster.getTeam() != null && !livingEntity.isAlliedTo(caster))
//						|| (caster instanceof Player player && Main.getTargetedEntity(player, spellLevelDistance) == livingEntity)
//						|| caster instanceof Mob mob && mob.getTarget() != null && (livingEntity.isAlliedTo( mob.getTarget()) && !livingEntity.isAlliedTo(caster));
//				boolean bl3 = caster.getTeam() == null && livingEntity.getTeam() == null && EntityFactionFind.isRaider(caster) && (livingEntity instanceof AbstractVillager || livingEntity instanceof IronGolem);
//				if (!bl2 && !bl3) continue;
				FloatingForceEntity spell = new FloatingForceEntity(spellLevelDamage, serverLevel, caster, 0, 0, 0);
				spell.setPos(livingEntity.getX(), livingEntity.getEyeY(), livingEntity.getZ());
				spell.setOwner(caster);
				spell.setTarget(livingEntity);
				serverLevel.addFreshEntity(spell);
				count -= 1;
			}
		}
		return true;
	}
	//地吸力场$法术
	public static boolean GravityForce(LivingEntity caster, int spellLevelDamage, int spellLevelDistance, int spellLevelCount) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			int count = spellLevelCount;
			//目标
			if (caster instanceof Mob mob && mob.getTarget() != null && count > 0 && !(caster.distanceTo(mob.getTarget()) > spellLevelDistance * 2) && !AttackFind.FindCanNotAttack(caster, mob.getTarget())) {
				GravityForceEntity spell = new GravityForceEntity(spellLevelDamage, serverLevel, caster, 0, 0, 0);
				spell.setPos(mob.getTarget().getX(), mob.getTarget().getEyeY(), mob.getTarget().getZ());
				spell.setOwner(caster);
				spell.setTarget(mob.getTarget());
				serverLevel.addFreshEntity(spell);
				count -= 1;
			}
			//其他
			List<LivingEntity> list = serverLevel.getEntitiesOfClass(LivingEntity.class, caster.getBoundingBox().inflate(spellLevelDistance, spellLevelDistance, spellLevelDistance));
			list.removeIf(livingEntity -> caster instanceof Mob mob && mob.getTarget() != null && livingEntity == mob.getTarget());
			for (LivingEntity livingEntity : list) {
				if (livingEntity == null) continue;
				if (count <= 0) break;
				if (AttackFind.FindCanNotAttack(caster, livingEntity)) continue;
//				boolean bl2 = (livingEntity instanceof Mob mob && mob.getTarget() == caster || caster instanceof Mob mob1 && mob1.getTarget() == livingEntity)
//						|| (livingEntity instanceof Player && caster instanceof Enemy)
//						|| (livingEntity.getTeam() != null && caster.getTeam() != null && !livingEntity.isAlliedTo(caster))
//						|| (caster instanceof Player player && Main.getTargetedEntity(player, spellLevelDistance) == livingEntity)
//						|| caster instanceof Mob mob && mob.getTarget() != null && (livingEntity.isAlliedTo( mob.getTarget()) && !livingEntity.isAlliedTo(caster));
//				boolean bl3 = caster.getTeam() == null && livingEntity.getTeam() == null && EntityFactionFind.isRaider(caster) && (livingEntity instanceof AbstractVillager || livingEntity instanceof IronGolem);
//				if (!bl2 && !bl3) continue;
				GravityForceEntity spell = new GravityForceEntity(spellLevelDamage, serverLevel, caster, 0, 0, 0);
				spell.setPos(livingEntity.getX(), livingEntity.getEyeY(), livingEntity.getZ());
				spell.setOwner(caster);
				spell.setTarget(livingEntity);
				serverLevel.addFreshEntity(spell);
			}
		}
		return true;
	}

	//战斗指示
	public static boolean CombatInstruction(LivingEntity caster, LivingEntity target, int spellLevelDistance) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			PlayerTeam teams = (PlayerTeam) caster.getTeam();
			List<Mob> list = serverLevel.getEntitiesOfClass(Mob.class, caster.getBoundingBox().inflate(spellLevelDistance, spellLevelDistance, spellLevelDistance));
			for (Mob mobFind : list) {
				if (mobFind == null) continue;
				if ((caster.distanceTo(mobFind)) > spellLevelDistance * 2) continue;
				if (!AttackFind.SameFactionAvoidDamage(caster, mobFind, false)) continue;
				if (caster instanceof Mob mobCaster) {
					if (mobFind == target) continue;
					if (mobCaster == mobFind.getTarget()) continue;
					if (target == null) continue;
					if (mobCaster.canAttack(target) && mobCaster.canAttackType(target.getType()) && !AttackFind.FindCanNotAttack(mobCaster, target)) {
						if (mobFind.canAttack(target) && mobFind.canAttackType(target.getType()) && !AttackFind.FindCanNotAttack(mobFind, target)) {
							mobFind.setTarget(target);
						}
					}
				}
				else if (caster instanceof Player player) {
					if (player == target) continue;
					if (player == mobFind.getTarget()) continue;
					if (target == null) continue;
					if (player.canAttack(target) && player.canAttackType(target.getType()) && !AttackFind.FindCanNotAttack(player, target)) {
						if (mobFind.canAttack(target) && mobFind.canAttackType(target.getType()) && !AttackFind.FindCanNotAttack(mobFind, target)) {
							mobFind.setTarget(target);
						}
					}
				}
			}
			if (!caster.isInvisible()) {
				serverLevel.sendParticles(JerotesVillageParticleTypes.COMBAT_INSTRUCTION_DISPLAY.get(), caster.getX(), caster.getBoundingBox().maxY + 0.5, caster.getZ(), 0, 0.0, 0.0, 0.0, 0.0);
			}
		}
		return true;
	}
	//地图推断
	public static boolean MapInference(LivingEntity caster, int spellLevelMainEffectTime, int spellLevelMainEffectLevel, int spellLevelOtherEffectTime, int spellLevelOtherEffectLevel, int spellLevelDistance) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			PlayerTeam teams = (PlayerTeam) caster.getTeam();
			List<LivingEntity> list = serverLevel.getEntitiesOfClass(LivingEntity.class, caster.getBoundingBox().inflate(spellLevelDistance, spellLevelDistance, spellLevelDistance));
			for (LivingEntity livingEntityEffect : list) {
				if (livingEntityEffect == null) continue;
				if (livingEntityEffect == caster) continue;
				if ((caster.distanceTo(livingEntityEffect)) > spellLevelDistance * 2) continue;
				if (!AttackFind.SameFactionAvoidDamage(caster, livingEntityEffect, false)) continue;
				if (caster instanceof Mob mob && livingEntityEffect == mob.getTarget()) continue;
				if (livingEntityEffect instanceof Mob mob && caster == mob.getTarget()) continue;
				if (!livingEntityEffect.level().isClientSide) {
					livingEntityEffect.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, spellLevelMainEffectTime * 20, spellLevelMainEffectLevel - 1), caster);
					livingEntityEffect.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, spellLevelOtherEffectTime * 20, spellLevelOtherEffectLevel - 1), caster);
				}
			}
			if (!caster.isInvisible()) {
				serverLevel.sendParticles(JerotesVillageParticleTypes.MAP_INFERENCE_DISPLAY.get(), caster.getX(), caster.getBoundingBox().maxY + 0.5, caster.getZ(), 0, 0.0, 0.0, 0.0, 0.0);
			}
		}
		return true;
	}
	//不祥号角
	public static boolean OminousHorn(LivingEntity caster, int spellLevelMainEffectTime, int spellLevelMainEffectLevel, int spellLevelOtherEffectTime, int spellLevelOtherEffectLevel, int spellLevelDistance) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			PlayerTeam teams = (PlayerTeam) caster.getTeam();
			List<LivingEntity> list = serverLevel.getEntitiesOfClass(LivingEntity.class, caster.getBoundingBox().inflate(spellLevelDistance, spellLevelDistance, spellLevelDistance));
			for (LivingEntity livingEntityEffect : list) {
				if (livingEntityEffect == null) continue;
				if ((caster.distanceTo(livingEntityEffect)) > spellLevelDistance * 2) continue;
				if (!AttackFind.SameFactionAvoidDamage(caster, livingEntityEffect, false)) continue;
				if (caster instanceof Mob mob && livingEntityEffect == mob.getTarget()) continue;
				if (livingEntityEffect instanceof Mob mob && caster == mob.getTarget()) continue;
				if (!livingEntityEffect.level().isClientSide) {
					livingEntityEffect.addEffect(new MobEffectInstance(MobEffects.REGENERATION, spellLevelMainEffectTime * 20, spellLevelMainEffectLevel - 1), caster);
					livingEntityEffect.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, spellLevelOtherEffectTime * 20, spellLevelOtherEffectLevel - 1), caster);
				}
			}
			if (!caster.isInvisible()) {
				serverLevel.sendParticles(JerotesVillageParticleTypes.OMINOUS_HORN_DISPLAY.get(), caster.getX(), caster.getBoundingBox().maxY + 0.5, caster.getZ(), 0, 0.0, 0.0, 0.0, 0.0);
			}
		}
		return true;
	}
	//传送石传送
	public static boolean TeleportStoneTeleport(LivingEntity caster, Entity target, Entity findUse, float spellLevelDistance, boolean exchange, boolean near) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			if (!target.isShiftKeyDown()) {
				//位置交换
				if (exchange) {
					double x = target.getX();
					double y = target.getY();
					double z = target.getZ();
					target.teleportTo(caster.getX(), caster.getY(), caster.getZ());
					caster.teleportTo(x, y, z);
				}
				else {
					BlockPos summonPos;
					//靠近
					if (near) {
						summonPos = Main.findSpawnPositionNearFillOnBlock(caster, (int) (spellLevelDistance / 2));
						for (int find = 0; find < 16; ++find) {
							if ((summonPos.distToCenterSqr(findUse.position()) > target.distanceToSqr(findUse))) {
								summonPos = Main.findSpawnPositionNearFillOnBlock(caster, (int) (spellLevelDistance / 2));
							}
							else {
								break;
							}
						}
					}
					//远离
					else {
						summonPos = Main.findSpawnPositionNearFillOnBlock(caster, (int) (spellLevelDistance * 2));
						for (int find = 0; find < 16; ++find) {
							if ((summonPos.distToCenterSqr(findUse.position()) < target.distanceToSqr(findUse))) {
								summonPos = Main.findSpawnPositionNearFillOnBlock(caster, (int) (spellLevelDistance * 2));
							}
							else {
								break;
							}
						}
					}
					target.teleportTo(summonPos.getX(), summonPos.getY(), summonPos.getZ());
				}
			}
			if (!caster.isInvisible()) {
				serverLevel.sendParticles(JerotesVillageParticleTypes.TELEPORT_STONE_TELEPORT_DISPLAY.get(), caster.getX(), caster.getBoundingBox().maxY + 0.5, caster.getZ(), 0, 0.0, 0.0, 0.0, 0.0);
			}
		}
		return true;
	}
	//不洁血雨$法术
	public static boolean UncleanBloodRain(LivingEntity caster, LivingEntity target, int spellLevelDuration, int spellLevelMainEffectTime, int spellLevelMainEffectLevel, int count, float summonHeight) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			for (int i = 0; i < count; ++i) {
				Vec3 targetPos = caster.getPosition(0);
				if (target != null) {
					targetPos = new Vec3(target.getX() + 0.5D, (double)(target.getY() + summonHeight), target.getZ() + 0.5D);
				}
				if (caster instanceof Player && (target == null || target == caster)) {
					Vec3 startPos = caster.getEyePosition(1.0f);
					Vec3 viewVector = caster.getViewVector(1.0f);
					Vec3 endPos = startPos.add(viewVector.scale(36));

					BlockHitResult hitResult = serverLevel.clip(new ClipContext(
							startPos, endPos,
							ClipContext.Block.OUTLINE,
							ClipContext.Fluid.NONE,
							caster
					));
					targetPos = Main.adjustPositionForSolidHit(hitResult, startPos, viewVector, 36);
				}
				//目标位置
				RainSpellCloudEntity cloud = new UncleanBloodRainEntity(spellLevelMainEffectTime, spellLevelMainEffectLevel, serverLevel, targetPos.x, targetPos.y, targetPos.z);
				cloud.setOwner(caster);
				cloud.spellLevelDamage = spellLevelMainEffectLevel;
				cloud.setParticle(JerotesVillageParticleTypes.UNCLEAN_BLOOD_RAIN_FOG.get());
				cloud.setRainParticle(JerotesVillageParticleTypes.UNCLEAN_BLOOD_RAIN.get());
				cloud.setRadius(1.5f);
				cloud.setDuration(20 * spellLevelDuration);
				cloud.setRadiusPerTick((3f - cloud.getRadius()) / (float)cloud.getDuration());
				cloud.setSpellUsefulHeight(24);
				cloud.addEffect(new MobEffectInstance(JerotesVillageMobEffects.UNCLEAN_BODY.get(), 20 * spellLevelMainEffectTime, spellLevelMainEffectLevel-1));
				serverLevel.addFreshEntity(cloud);
			}
			serverLevel.gameEvent(GameEvent.ENTITY_PLACE, new BlockPos((int) caster.getX(), (int) caster.getY(), (int) caster.getZ()), GameEvent.Context.of(caster));
		}
		return true;
	}
	//不洁血雾$法术
	public static boolean UncleanBloodFog(LivingEntity caster, LivingEntity target, int spellLevelDuration, int spellLevelMainEffectTime, int spellLevelMainEffectLevel, int spellLevelOffEffectTime, int spellLevelOffEffectLevel, int count) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			for (int i = 0; i < count; ++i) {
				Vec3 targetPos = caster.getPosition(0);
				if (target != null) {
					targetPos = new Vec3(target.getX() + 0.5D, target.getY() + i * 0.5f, target.getZ() + 0.5D);
				}
				if (caster instanceof Player && (target == null || target == caster)) {
					Vec3 startPos = caster.getEyePosition(1.0f);
					Vec3 viewVector = caster.getViewVector(1.0f);
					Vec3 endPos = startPos.add(viewVector.scale(36));

					BlockHitResult hitResult = serverLevel.clip(new ClipContext(
							startPos, endPos,
							ClipContext.Block.OUTLINE,
							ClipContext.Fluid.NONE,
							caster
					));
					targetPos = Main.adjustPositionForSolidHit(hitResult, startPos, viewVector, 36);
				}
				//目标位置
				SpellCloudEntity cloud = new SpellCloudEntity(serverLevel, targetPos.x, targetPos.y, targetPos.z);
				cloud.setOwner(caster);
				cloud.spellLevelDamage = spellLevelMainEffectLevel;
				cloud.setParticle(JerotesVillageParticleTypes.UNCLEAN_BLOOD_FOG.get());
				cloud.setParticleScaleMultiple(0.5f);
				cloud.setRadius(1.5f);
				cloud.setDuration(20 * spellLevelDuration);
				cloud.setRadiusPerTick((3f - cloud.getRadius()) / (float)cloud.getDuration());
				cloud.addEffect(new MobEffectInstance(JerotesVillageMobEffects.UNCLEAN_BODY.get(), 20 * spellLevelMainEffectTime, spellLevelMainEffectLevel-1));
				cloud.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 20 * spellLevelOffEffectTime, spellLevelOffEffectLevel-1));
				serverLevel.addFreshEntity(cloud);
			}
			serverLevel.gameEvent(GameEvent.ENTITY_PLACE, new BlockPos((int) caster.getX(), (int) caster.getY(), (int) caster.getZ()), GameEvent.Context.of(caster));
		}
		return true;
	}
	//神汉低语$法术
	public static boolean WarlockWhisper(LivingEntity caster, int spellLevelUseHealthMultiplier, int spellLevelMainEffectTime, int spellLevelMainEffectLevel, int spellLevelOtherEffectTime, int spellLevelOtherEffectLevel, int spellLevelAwayX, int spellLevelAwayY, double spellLevelAwaySpeedMultiple, int spellLevelDistance) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			List<LivingEntity> list = serverLevel.getEntitiesOfClass(LivingEntity.class, caster.getBoundingBox().inflate(spellLevelDistance, spellLevelDistance, spellLevelDistance));
			for (LivingEntity livingEntityControl : list) {
				if (livingEntityControl == null) continue;
				if ((caster.distanceTo(livingEntityControl)) > spellLevelDistance * 2) continue;
				if (AttackFind.FindCanNotAttack(caster, livingEntityControl)) continue;
				if (!Main.canSee(livingEntityControl, caster) || !caster.hasLineOfSight(livingEntityControl)) continue;
				if (!livingEntityControl.level().isClientSide) {
					livingEntityControl.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 20 * spellLevelMainEffectTime, spellLevelMainEffectLevel - 1), caster);
					livingEntityControl.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20 * spellLevelOtherEffectTime * 6, spellLevelOtherEffectLevel - 1), caster);
				}
				if (livingEntityControl instanceof PathfinderMob mob && mob.getHealth() < caster.getHealth() * spellLevelUseHealthMultiplier) {
					if (mob.onGround()) {
						Vec3 randomShake = new Vec3(mob.getRandom().nextFloat() - 0.5F, 0, mob.getRandom().nextFloat() - 0.5F).scale(0.1F);
						mob.setDeltaMovement(mob.getDeltaMovement().multiply(0.7F, 1, 0.7F).add(randomShake));
					}
					Vec3 vec = LandRandomPos.getPosAway(mob, spellLevelAwayX, spellLevelAwayY, caster.position());
					if (vec != null) {
						mob.getNavigation().moveTo(vec.x, vec.y, vec.z, spellLevelAwaySpeedMultiple);
					}
				}
			}
		}
		return true;
	}
	//不祥齿轮
	public static boolean OminousGear(LivingEntity caster, int spellLevel, int countMin, int countMax, int summonDistance) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			int count = countMin;
			if (countMin < countMax) {
				count = Main.randomReach(caster.getRandom(), countMin, countMax);
			}
			for (int i = 0; i < count; ++i) {
				//自身位置
				BlockPos summonPos = Main.findSpawnPositionNearFillOnBlock(caster, summonDistance);
				OminousGearEntity gear = JerotesVillageEntityType.OMINOUS_GEAR.get().spawn(serverLevel, BlockPos.containing(summonPos.getX(), summonPos.getY(), summonPos.getZ()), MobSpawnType.MOB_SUMMONED);
				if (gear != null) {
					gear.setOwner(caster);
					gear.setSpellLevelDamage(spellLevel);
				}
			}
			serverLevel.gameEvent(GameEvent.ENTITY_PLACE, new BlockPos((int) caster.getX(), (int) caster.getY(), (int) caster.getZ()), GameEvent.Context.of(caster));
			if (!caster.isInvisible()) {
				serverLevel.sendParticles(JerotesVillageParticleTypes.OMINOUS_GEAR_DISPLAY.get(), caster.getX(), caster.getBoundingBox().maxY + 0.5, caster.getZ(), 0, 0.0, 0.0, 0.0, 0.0);
			}
		}
		return true;
	}
	//邪祟召唤$法术
	public static boolean EvilSummoning(LivingEntity caster, LivingEntity target, int spellLevel, int countMin, int countMax, int summonDistance) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			PlayerTeam teams = (PlayerTeam) caster.getTeam();
			int count = countMin;
			if (countMin < countMax) {
				count = Main.randomReach(caster.getRandom(), countMin, countMax);
			}
			for (int i = 0; i < count; ++i) {
				//自身位置
				BlockPos summonPos = Main.findSpawnPositionNearFillOnBlock(target, summonDistance);
				UncleanTentacleEntity uncleanTentacle = JerotesVillageEntityType.UNCLEAN_TENTACLE.get().spawn(serverLevel, BlockPos.containing(summonPos.getX(), summonPos.getY(), summonPos.getZ()), MobSpawnType.MOB_SUMMONED);
				//目标位置
				if (uncleanTentacle != null) {
					uncleanTentacle.setOwner(caster);
					uncleanTentacle.setSpellLevelDamage(spellLevel);
					if (teams != null) {
						serverLevel.getScoreboard().addPlayerToTeam(uncleanTentacle.getStringUUID(), teams);
					}
					if (target != null && target != caster) {
						uncleanTentacle.setTarget(target);
					}
					ParticlesUse.summonParticle(serverLevel, uncleanTentacle, uncleanTentacle.getX(), uncleanTentacle.getY(), uncleanTentacle.getZ(),
							0xb8003c, 0xff0055);
				}
			}
			serverLevel.gameEvent(GameEvent.ENTITY_PLACE, new BlockPos((int) caster.getX(), (int) caster.getY(), (int) caster.getZ()), GameEvent.Context.of(caster));
		}
		return true;
	}
	//苦寒祭坛$法术
	public static boolean BitterColdAltar(LivingEntity caster, int spellLevel, int countMin, int countMax, int summonDistance) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			PlayerTeam teams = (PlayerTeam) caster.getTeam();
			int count = countMin;
			if (countMin < countMax) {
				count = caster.getRandom().nextInt(countMin, countMax);
			}
			for (int i = 0; i < count; ++i) {
				BlockPos summonPos = Main.findSpawnPositionNearFillOnBlock(caster, summonDistance);
				if (caster instanceof Player) {
					Vec3 startPos = caster.getEyePosition(1.0f);
					Vec3 viewVector = caster.getViewVector(1.0f);
					Vec3 endPos = startPos.add(viewVector.scale(summonDistance));

					BlockHitResult hitResult = serverLevel.clip(new ClipContext(
							startPos, endPos,
							ClipContext.Block.OUTLINE,
							ClipContext.Fluid.NONE,
							caster
					));
					Vec3 targetPos = Main.adjustPositionForSolidHit(hitResult, startPos, viewVector, summonDistance);
					summonPos = Main.findSafePosition(serverLevel, targetPos);
				}
				BitterColdAltarEntity bitterColdAltar = JerotesVillageEntityType.BITTER_COLD_ALTAR.get().spawn(serverLevel, BlockPos.containing(summonPos.getX(), summonPos.getY(), summonPos.getZ()), MobSpawnType.MOB_SUMMONED);
				if (bitterColdAltar != null) {
					bitterColdAltar.setOwner(caster);
					bitterColdAltar.setSpellLevelDamage(spellLevel);
					if (teams != null) {
						serverLevel.getScoreboard().addPlayerToTeam(bitterColdAltar.getStringUUID(), teams);
					}
					if (caster instanceof Mob mob && mob.getTarget() != null) {
						bitterColdAltar.setTarget(mob.getTarget());
					}
//					ParticlesUse.summonParticle(serverLevel, bitterColdAltar, bitterColdAltar.getX(), bitterColdAltar.getY(), bitterColdAltar.getZ(),
//							0x006bcd, 0x8bc6fb);
				}
			}
			serverLevel.gameEvent(GameEvent.ENTITY_PLACE, new BlockPos((int) caster.getX(), (int) caster.getY(), (int) caster.getZ()), GameEvent.Context.of(caster));
		}
		return true;
	}
	//荒野驱使
	//荒野驱使
	public static boolean WildernessDriven(LivingEntity caster, int countMin, int countMax, int summonDistance) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			PlayerTeam teams = (PlayerTeam) caster.getTeam();
			int count = countMin;
			if (countMin < countMax) {
				count = caster.getRandom().nextInt(countMin, countMax);
			}
			for (int i = 0; i < count; ++i) {
				BlockPos summonPos = Main.findSpawnPositionNearFillOnBlock(caster, summonDistance);
				WildernessWolfEntity wildernessWolf = JerotesVillageEntityType.WILDERNESS_WOLF.get().spawn(serverLevel, BlockPos.containing(summonPos.getX(), summonPos.getY(), summonPos.getZ()), MobSpawnType.MOB_SUMMONED);
				if (wildernessWolf != null) {
					wildernessWolf.setTame(true);
					wildernessWolf.setOwnerUUID(caster.getUUID());
					wildernessWolf.setOrderedToSit(false);
					wildernessWolf.setInSittingPose(false);
					if (EntityFactionFind.isRaider(caster)) {
						wildernessWolf.setIllagerFaction(true);
					}
					if (teams != null) {
						serverLevel.getScoreboard().addPlayerToTeam(wildernessWolf.getStringUUID(), teams);
					}
					if (caster instanceof Mob mob && mob.getTarget() != null) {
						wildernessWolf.setTarget(mob.getTarget());
					}
					ParticlesUse.summonParticle(serverLevel, wildernessWolf, wildernessWolf.getX(), wildernessWolf.getY(), wildernessWolf.getZ(),
							0x423a30, 0x625d52);
				}
			}
			serverLevel.gameEvent(GameEvent.ENTITY_PLACE, new BlockPos((int) caster.getX(), (int) caster.getY(), (int) caster.getZ()), GameEvent.Context.of(caster));
			if (!caster.isInvisible()) {
				serverLevel.sendParticles(JerotesVillageParticleTypes.WILDERNESS_DRIVEN_DISPLAY.get(), caster.getX(), caster.getBoundingBox().maxY + 0.5, caster.getZ(), 0, 0.0, 0.0, 0.0, 0.0);
			}
		}
		return true;
	}
	//赎罪抵抗
	public static boolean AtonementResistance(LivingEntity caster) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			PlayerTeam teams = (PlayerTeam) caster.getTeam();
			BlockPos summonPos = caster.getOnPos().above();
			DefectorEntity defector = JerotesVillageEntityType.DEFECTOR.get().spawn(serverLevel, BlockPos.containing(summonPos.getX(), summonPos.getY(), summonPos.getZ()), MobSpawnType.MOB_SUMMONED);
			if (defector != null) {
				if (teams != null) {
					serverLevel.getScoreboard().addPlayerToTeam(defector.getStringUUID(), teams);
				}
				if (caster instanceof Mob mob && mob.getTarget() != null) {
					defector.setTarget(mob.getTarget());
				}
				ParticlesUse.summonParticle(serverLevel, defector, defector.getX(), defector.getY(), defector.getZ(),
						0x525858, 0x909696);
			}
			serverLevel.gameEvent(GameEvent.ENTITY_PLACE, new BlockPos((int) caster.getX(), (int) caster.getY(), (int) caster.getZ()), GameEvent.Context.of(caster));
			if (!caster.isInvisible()) {
				serverLevel.sendParticles(JerotesVillageParticleTypes.ATONEMENT_RESISTANCE_DISPLAY.get(), caster.getX(), caster.getBoundingBox().maxY + 0.5, caster.getZ(), 0, 0.0, 0.0, 0.0, 0.0);
			}
		}
		return true;
	}
	//鬼婆集会
	//鬼婆集会
	public static boolean HagCoven(LivingEntity caster, int summonDistance) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			PlayerTeam teams = (PlayerTeam) caster.getTeam();
			BlockPos summonPos = Main.findSpawnPositionNearFillOnBlock(caster, summonDistance);
			CovenHagEntity hag1 = JerotesVillageEntityType.COVEN_HAG_ONE.get().spawn(serverLevel, BlockPos.containing(summonPos.getX(), summonPos.getY(), summonPos.getZ()), MobSpawnType.MOB_SUMMONED);
			summonPos = Main.findSpawnPositionNearFillOnBlock(caster, summonDistance);
			CovenHagEntity hag2 = JerotesVillageEntityType.COVEN_HAG_TWO.get().spawn(serverLevel, BlockPos.containing(summonPos.getX(), summonPos.getY(), summonPos.getZ()), MobSpawnType.MOB_SUMMONED);
			if (hag1 != null) {
				if (teams != null) {
					serverLevel.getScoreboard().addPlayerToTeam(hag1.getStringUUID(), teams);
				}
				if (caster instanceof Mob mob && mob.getTarget() != null) {
					hag1.setTarget(mob.getTarget());
				}
				ParticlesUse.summonParticle(serverLevel, hag1, hag1.getX(), hag1.getY(), hag1.getZ(),
						0x374200, 0x7b853d);
				serverLevel.sendParticles(ParticleTypes.WITCH, hag1.getRandomX(0.5), hag1.getRandomY(), hag1.getRandomZ(0.5), 20, 0, 0, 0, 0);
			}
			if (hag2 != null) {
				if (teams != null) {
					serverLevel.getScoreboard().addPlayerToTeam(hag2.getStringUUID(), teams);
				}
				if (caster instanceof Mob mob && mob.getTarget() != null) {
					hag2.setTarget(mob.getTarget());
				}
				ParticlesUse.summonParticle(serverLevel, hag2, hag2.getX(), hag2.getY(), hag2.getZ(),
						0x374200, 0x7b853d);
				serverLevel.sendParticles(ParticleTypes.WITCH, hag2.getRandomX(0.5), hag2.getRandomY(), hag2.getRandomZ(0.5), 20, 0, 0, 0, 0);
			}
			serverLevel.gameEvent(GameEvent.ENTITY_PLACE, new BlockPos((int) caster.getX(), (int) caster.getY(), (int) caster.getZ()), GameEvent.Context.of(caster));
			if (!caster.isInvisible()) {
				serverLevel.sendParticles(JerotesVillageParticleTypes.HAG_COVENS_DISPLAY.get(), caster.getX(), caster.getBoundingBox().maxY + 0.5, caster.getZ(), 0, 0.0, 0.0, 0.0, 0.0);
			}
		}
		return true;
	}
	//紫沙幻影$法术
	public static boolean PurpleSandPhantom(LivingEntity caster, Entity target, int countMin, int countMax, int summonDistance, int spellLevelDamage) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			PlayerTeam teams = (PlayerTeam) caster.getTeam();
			int count = countMin;
			if (countMin < countMax) {
				count = Main.randomReach(caster.getRandom(), countMin, countMax);
			}
			for (int i = 0; i < count; ++i) {
				BlockPos summonPos = Main.findSpawnPositionNearFillOnBlock(caster, summonDistance);
				PurpleSandPhantomEntity purpleSandPhantom = JerotesVillageEntityType.PURPLE_SAND_PHANTOM.get().spawn(serverLevel, BlockPos.containing(summonPos.getX(), summonPos.getY(), summonPos.getZ()), MobSpawnType.MOB_SUMMONED);
				if (purpleSandPhantom != null) {
					purpleSandPhantom.setOwner(caster);
					purpleSandPhantom.setSpellLevelDamage(spellLevelDamage);
					if (target instanceof LivingEntity livingEntity) {
						purpleSandPhantom.setTarget(livingEntity);
					}
					purpleSandPhantom.lookAt(target, 360.0f, 360.0f);
					if (target instanceof Mob mob) {
						mob.setTarget(purpleSandPhantom);
					}
					if (teams != null) {
						serverLevel.getScoreboard().addPlayerToTeam(purpleSandPhantom.getStringUUID(), teams);
					}
					ParticlesUse.summonParticle(serverLevel, purpleSandPhantom, purpleSandPhantom.getX(), purpleSandPhantom.getY(), purpleSandPhantom.getZ(),
							0x4e275a, 0xb19cb7);
					serverLevel.sendParticles(ParticleTypes.WITCH, purpleSandPhantom.getRandomX(0.5), purpleSandPhantom.getRandomY(), purpleSandPhantom.getRandomZ(0.5), 20, 0, 0, 0, 0);
				}
			}
			serverLevel.gameEvent(GameEvent.ENTITY_PLACE, new BlockPos((int) caster.getX(), (int) caster.getY(), (int) caster.getZ()), GameEvent.Context.of(caster));
		}
		return true;
	}
	//召唤灵奴
	public static boolean ConjureSpirve(LivingEntity caster, int summonDistance) {
		if (caster.level() instanceof ServerLevel serverLevel) {
			PlayerTeam teams = (PlayerTeam) caster.getTeam();
			BlockPos summonPos = Main.findSpawnPositionNearFillOnBlock(caster, summonDistance);
			SpirveEntity spirve1 = JerotesVillageEntityType.SPIRVE.get().spawn(serverLevel, BlockPos.containing(summonPos.getX(), summonPos.getY(), summonPos.getZ()), MobSpawnType.MOB_SUMMONED);
			summonPos = Main.findSpawnPositionNearFillOnBlock(caster, summonDistance);
			SpirveEntity spirve2 = JerotesVillageEntityType.SPIRVE.get().spawn(serverLevel, BlockPos.containing(summonPos.getX(), summonPos.getY(), summonPos.getZ()), MobSpawnType.MOB_SUMMONED);
			summonPos = Main.findSpawnPositionNearFillOnBlock(caster, summonDistance);
			SpirveEntity spirve3 = JerotesVillageEntityType.SPIRVE.get().spawn(serverLevel, BlockPos.containing(summonPos.getX(), summonPos.getY(), summonPos.getZ()), MobSpawnType.MOB_SUMMONED);
			if (spirve1 != null) {
				if (teams != null) {
					serverLevel.getScoreboard().addPlayerToTeam(spirve1.getStringUUID(), teams);
				}
				if (caster instanceof Mob mob && mob.getTarget() != null) {
					spirve1.setTarget(mob.getTarget());
				}
				ParticlesUse.summonParticle(serverLevel, spirve1, spirve1.getX(), spirve1.getY(), spirve1.getZ(),
						0x2e2e2e, 0x605c57);
				serverLevel.sendParticles(ParticleTypes.WITCH, spirve1.getRandomX(0.5), spirve1.getRandomY(), spirve1.getRandomZ(0.5), 20, 0, 0, 0, 0);
			}
			if (spirve2 != null) {
				if (teams != null) {
					serverLevel.getScoreboard().addPlayerToTeam(spirve2.getStringUUID(), teams);
				}
				if (caster instanceof Mob mob && mob.getTarget() != null) {
					spirve2.setTarget(mob.getTarget());
				}
				ParticlesUse.summonParticle(serverLevel, spirve2, spirve2.getX(), spirve2.getY(), spirve2.getZ(),
						0x2e2e2e, 0x605c57);
				serverLevel.sendParticles(ParticleTypes.WITCH, spirve2.getRandomX(0.5), spirve2.getRandomY(), spirve2.getRandomZ(0.5), 20, 0, 0, 0, 0);
			}
			if (spirve3 != null) {
				if (teams != null) {
					serverLevel.getScoreboard().addPlayerToTeam(spirve3.getStringUUID(), teams);
				}
				if (caster instanceof Mob mob && mob.getTarget() != null) {
					spirve3.setTarget(mob.getTarget());
				}
				ParticlesUse.summonParticle(serverLevel, spirve3, spirve3.getX(), spirve3.getY(), spirve3.getZ(),
						0x2e2e2e, 0x605c57);
				serverLevel.sendParticles(ParticleTypes.WITCH, spirve3.getRandomX(0.5), spirve3.getRandomY(), spirve3.getRandomZ(0.5), 20, 0, 0, 0, 0);
			}
			serverLevel.gameEvent(GameEvent.ENTITY_PLACE, new BlockPos((int) caster.getX(), (int) caster.getY(), (int) caster.getZ()), GameEvent.Context.of(caster));
			if (!caster.isInvisible()) {
				serverLevel.sendParticles(JerotesVillageParticleTypes.CONJURE_SPIRVE_DISPLAY.get(), caster.getX(), caster.getBoundingBox().maxY + 0.5, caster.getZ(), 0, 0.0, 0.0, 0.0, 0.0);
			}
		}
		return true;
	}
}
