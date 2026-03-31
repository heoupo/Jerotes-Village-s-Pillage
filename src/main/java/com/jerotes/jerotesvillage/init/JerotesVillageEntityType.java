package com.jerotes.jerotesvillage.init;

import com.jerotes.jerotesvillage.JerotesVillage;
import com.jerotes.jerotesvillage.entity.Animal.GiantMonsterEntity;
import com.jerotes.jerotesvillage.entity.Animal.PurpleSandRabbitEntity;
import com.jerotes.jerotesvillage.entity.Animal.RottenDogEntity;
import com.jerotes.jerotesvillage.entity.Animal.WildernessWolfEntity;
import com.jerotes.jerotesvillage.entity.Boss.Biome.PurpleSandHagEntity;
import com.jerotes.jerotesvillage.entity.Boss.OminousBannerProjectionEntity;
import com.jerotes.jerotesvillage.entity.Monster.BoundZombieVillagerEntity;
import com.jerotes.jerotesvillage.entity.Monster.Elite.BigWitchEntity;
import com.jerotes.jerotesvillage.entity.Monster.Hag.CohortHagEntity;
import com.jerotes.jerotesvillage.entity.Monster.Hag.CovenHagEntity;
import com.jerotes.jerotesvillage.entity.Monster.IllagerFaction.*;
import com.jerotes.jerotesvillage.entity.Monster.PurpleSandWitchEntity;
import com.jerotes.jerotesvillage.entity.Monster.SpirveEntity;
import com.jerotes.jerotesvillage.entity.Monster.WitchScholarEntity;
import com.jerotes.jerotesvillage.entity.Neutral.CarvedIronGolemEntity;
import com.jerotes.jerotesvillage.entity.Neutral.SpearMachineEntity;
import com.jerotes.jerotesvillage.entity.Neutral.UnicycleEntity;
import com.jerotes.jerotesvillage.entity.Other.*;
import com.jerotes.jerotesvillage.entity.Part.BitterColdAltarPart;
import com.jerotes.jerotesvillage.entity.Shoot.Arrow.*;
import com.jerotes.jerotesvillage.entity.Shoot.Magic.Breath.BloodyScreamEntity;
import com.jerotes.jerotesvillage.entity.Shoot.Magic.Cloud.RainEffectCloudEntity;
import com.jerotes.jerotesvillage.entity.Shoot.Magic.Cloud.UncleanBloodRainEntity;
import com.jerotes.jerotesvillage.entity.Shoot.Magic.MagicBeam.ElectroflashEntity;
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
import com.jerotes.jerotesvillage.entity.Shoot.Other.OminousBombEntity;
import com.jerotes.jerotesvillage.entity.Shoot.Other.PurpleSandAlchemyBombEntity;
import com.jerotes.jerotesvillage.entity.Shoot.Other.PurpleSandExplosiveAlchemyBombEntity;
import com.jerotes.jerotesvillage.entity.Shoot.ThrowingBall.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JerotesVillageEntityType {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, JerotesVillage.MODID);
	public static final RegistryObject<EntityType<SpearMachineEntity>> SPEAR_MACHINE = register("spear_machine",
			EntityType.Builder.of(SpearMachineEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).immuneTo(Blocks.POWDER_SNOW)
					.sized(0.6f, 1.1f));
	public static final RegistryObject<EntityType<UnicycleEntity>> UNICYCLE = register("unicycle",
			EntityType.Builder.of(UnicycleEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).immuneTo(Blocks.POWDER_SNOW)
					.sized(0.6f, 1.7f));
	public static final RegistryObject<EntityType<CarvedIronGolemEntity>> CARVED_IRON_GOLEM = register("carved_iron_golem",
			EntityType.Builder.of(CarvedIronGolemEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(32)
					.sized(1.4f, 2.7f));
	public static final RegistryObject<EntityType<BoundZombieVillagerEntity>> BOUND_ZOMBIE_VILLAGER = register("bound_zombie_villager",
			EntityType.Builder.of(BoundZombieVillagerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(8)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<ExplorerEntity>> EXPLORER = register("explorer",
			EntityType.Builder.of(ExplorerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<ExecutionerEntity>> EXECUTIONER = register("executioner",
			EntityType.Builder.of(ExecutionerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<MapmakerEntity>> MAPMAKER = register("mapmaker",
			EntityType.Builder.of(MapmakerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<DefectorEntity>> DEFECTOR = register("defector",
			EntityType.Builder.of(DefectorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<BannerBearerEntity>> BANNER_BEARER = register("banner_bearer",
			EntityType.Builder.of(BannerBearerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<BlasterEntity>> BLASTER = register("blaster",
			EntityType.Builder.of(BlasterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<TrumpeterEntity>> TRUMPETER = register("trumpeter",
			EntityType.Builder.of(TrumpeterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<TeleporterEntity>> TELEPORTER = register("teleporter",
			EntityType.Builder.of(TeleporterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<CyclonerEntity>> CYCLONER = register("cycloner",
			EntityType.Builder.of(CyclonerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<JavelinThrowerEntity>> JAVELIN_THROWER = register("javelin_thrower",
			EntityType.Builder.of(JavelinThrowerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<ZombieKeeperEntity>> ZOMBIE_KEEPER = register("zombie_keeper",
			EntityType.Builder.of(ZombieKeeperEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<BitterColdSorcererEntity>> BITTER_COLD_SORCERER = register("bitter_cold_sorcerer",
			EntityType.Builder.of(BitterColdSorcererEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).immuneTo(Blocks.POWDER_SNOW)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<BitterColdAltarEntity>> BITTER_COLD_ALTAR = register("bitter_cold_altar",
			EntityType.Builder.of(BitterColdAltarEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(10).immuneTo(Blocks.POWDER_SNOW)
					.sized(6, 0.5f));
	public static final RegistryObject<EntityType<BitterColdAltarPart>> BITTER_COLD_ALTAR_PART = register("bitter_cold_altar_part",
			EntityType.Builder.<BitterColdAltarPart>of(BitterColdAltarPart::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(32)
					.sized(1f, 3.5f));
	public static final RegistryObject<EntityType<FireSpitterEntity>> FIRE_SPITTER = register("fire_spitter",
			EntityType.Builder.of(FireSpitterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<WildFinderEntity>> WILD_FINDER = register("wild_finder",
			EntityType.Builder.of(WildFinderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<SubmarinerEntity>> SUBMARINER = register("submariner",
			EntityType.Builder.of(SubmarinerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<LampWizardEntity>> LAMP_WIZARD = register("lamp_wizard",
			EntityType.Builder.of(LampWizardEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<SlaverySupervisorEntity>> SLAVERY_SUPERVISOR = register("slavery_supervisor",
			EntityType.Builder.of(SlaverySupervisorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<AnimatedChainEntity>> ANIMATED_CHAIN = register("animated_chain",
			EntityType.Builder.of(AnimatedChainEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(10).immuneTo(Blocks.POWDER_SNOW)
					.sized(6, 0.5f));
	public static final RegistryObject<EntityType<FirepowerPourerEntity>> FIREPOWER_POURER = register("firepower_pourer",
			EntityType.Builder.of(FirepowerPourerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).immuneTo(Blocks.POWDER_SNOW)
					.sized(2f, 3.8f));
	public static final RegistryObject<EntityType<NecromancyWarlockEntity>> NECROMANCY_WARLOCK = register("necromancy_warlock",
			EntityType.Builder.of(NecromancyWarlockEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<UncleanTentacleEntity>> UNCLEAN_TENTACLE = register("unclean_tentacle",
			EntityType.Builder.of(UncleanTentacleEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(10)
					.sized(0.5f, 3f));
	public static final RegistryObject<EntityType<GavilerEntity>> GAVILER = register("gaviler",
			EntityType.Builder.of(GavilerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<AxCrazyEntity>> AX_CRAZY = register("ax_crazy",
			EntityType.Builder.of(AxCrazyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<OminousBannerProjectionEntity>> OMINOUS_BANNER_PROJECTION = register("ominous_banner_projection",
			EntityType.Builder.of(OminousBannerProjectionEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).immuneTo(Blocks.POWDER_SNOW)
					.sized(0.75f, 5.2f));
	public static final RegistryObject<EntityType<GiantMonsterEntity>> GIANT_MONSTER = register("giant_monster",
			EntityType.Builder.of(GiantMonsterEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).immuneTo(Blocks.POWDER_SNOW)
					.sized(2.95f, 3.1f));
	public static final RegistryObject<EntityType<PurpleSandRabbitEntity>> PURPLE_SAND_RABBIT = register("purple_sand_rabbit",
			EntityType.Builder.of(PurpleSandRabbitEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(8)
					.sized(0.6f, 0.75f));
	public static final RegistryObject<EntityType<PurpleSandWitchEntity>> PURPLE_SAND_WITCH = register("purple_sand_witch",
			EntityType.Builder.of(PurpleSandWitchEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(16)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<WitchScholarEntity>> WITCH_SCHOLAR = register("witch_scholar",
			EntityType.Builder.of(WitchScholarEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(16)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<SpirveEntity>> SPIRVE = register("spirve",
			EntityType.Builder.of(SpirveEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(16)
					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<RottenDogEntity>> ROTTEN_DOG = register("rotten_dog",
			EntityType.Builder.of(RottenDogEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(16)
					.sized(1.1f, 1.2f));
	public static final RegistryObject<EntityType<BigWitchEntity>> BIG_WITCH = register("big_witch",
			EntityType.Builder.of(BigWitchEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(16).immuneTo(Blocks.POWDER_SNOW)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<CohortHagEntity>> COHORT_HAG = register("cohort_hag",
			EntityType.Builder.of(CohortHagEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(16)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<CovenHagEntity>> COVEN_HAG_ONE = register("coven_hag_one",
			EntityType.Builder.of(CovenHagEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(16)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<CovenHagEntity>> COVEN_HAG_TWO = register("coven_hag_two",
			EntityType.Builder.of(CovenHagEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(16)
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<PurpleSandHagEntity>> PURPLE_SAND_HAG = register("purple_sand_hag",
			EntityType.Builder.of(PurpleSandHagEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).fireImmune()
					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<PurpleSandPhantomEntity>> PURPLE_SAND_PHANTOM = register("purple_sand_phantom",
			EntityType.Builder.of(PurpleSandPhantomEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(10)
					.sized(0.6f, 1.895f));
	public static final RegistryObject<EntityType<WildernessWolfEntity>> WILDERNESS_WOLF = register("wilderness_wolf",
			EntityType.Builder.of(WildernessWolfEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(16).immuneTo(Blocks.POWDER_SNOW)
					.sized(0.85f, 1.2f));
	//发射物
	public static final RegistryObject<EntityType<ThrownJavelinVillagerMetalEntity>> THROWN_VILLAGER_METAL_JAVELIN = register("projectile_throw_villager_metal_javelin",
			EntityType.Builder.<ThrownJavelinVillagerMetalEntity>of(ThrownJavelinVillagerMetalEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<CarvedVillagerSpectralArrowEntity>> CARVED_VILLAGER_SPECTRAL_ARROW = register("projectile_carved_villager_spectral_arrow",
			EntityType.Builder.<CarvedVillagerSpectralArrowEntity>of(CarvedVillagerSpectralArrowEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<OminousBombEntity>> OMINOUS_BOMB = register("ominous_bomb",
			EntityType.Builder.<OminousBombEntity>of(OminousBombEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(10)
					.sized(0.4f, 0.4f));
	public static final RegistryObject<EntityType<OminousBombFragmentEntity>> OMINOUS_BOMB_FRAGMENT = register("ominous_bomb_fragment",
			EntityType.Builder.<OminousBombFragmentEntity>of(OminousBombFragmentEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ThrownOminousJavalinEntity>> OMINOUS_JAVALIN = register("projectile_ominous_javelin",
			EntityType.Builder.<ThrownOminousJavalinEntity>of(ThrownOminousJavalinEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BitterColdIceSpikeEntity>> BITTER_COLD_ICE_SPIKE = register("bitter_cold_ice_spike",
			EntityType.Builder.<BitterColdIceSpikeEntity>of(BitterColdIceSpikeEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(4)
					.sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BitterColdFrostbiteEntity>> BITTER_COLD_FROSTBITE = register("bitter_cold_frostbite",
			EntityType.Builder.<BitterColdFrostbiteEntity>of(BitterColdFrostbiteEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(16)
					.sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<OminousFlamesEntity>> OMINOUS_FLAMES = register("ominous_flames",
			EntityType.Builder.<OminousFlamesEntity>of(OminousFlamesEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(16)
					.sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ArcaneLightSpotEntity>> ARCANE_LIGHT_SPOT = register("arcane_light_spot",
			EntityType.Builder.<ArcaneLightSpotEntity>of(ArcaneLightSpotEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(4)
					.sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<ElasticLightBallEntity>> ELASTIC_LIGHT_BALL = register("elastic_light_ball",
			EntityType.Builder.<ElasticLightBallEntity>of(ElasticLightBallEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(4)
					.sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ElasticIceRockEntity>> ELASTIC_ICE_ROCK = register("elastic_ice_rock",
			EntityType.Builder.<ElasticIceRockEntity>of(ElasticIceRockEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(4)
					.sized(1f, 1f));
	public static final RegistryObject<EntityType<RadiantBombEntity>> RADIANT_BOMB = register("radiant_bomb",
			EntityType.Builder.<RadiantBombEntity>of(RadiantBombEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(4)
					.sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<BloodyScreamEntity>> BLOODY_SCREAM = register("bloody_scream",
			EntityType.Builder.<BloodyScreamEntity>of(BloodyScreamEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(4)
					.sized(1.6f, 1.6f));
	public static final RegistryObject<EntityType<PushForceEntity>> PUSH_FORCE = register("push_force",
			EntityType.Builder.<PushForceEntity>of(PushForceEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(4)
					.sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<FloatingForceEntity>> FLOATING_FORCE = register("floating_force",
			EntityType.Builder.<FloatingForceEntity>of(FloatingForceEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(4)
					.sized(1.5f, 1.5f));
	public static final RegistryObject<EntityType<GravityForceEntity>> GRAVITY_FORCE = register("gravity_force",
			EntityType.Builder.<GravityForceEntity>of(GravityForceEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(4)
					.sized(1.5f, 1.5f));
	public static final RegistryObject<EntityType<PurpleSandAlchemyBombEntity>> PURPLE_SAND_ALCHEMY_BOMB = register("purple_sand_alchemy_bomb",
			EntityType.Builder.<PurpleSandAlchemyBombEntity>of(PurpleSandAlchemyBombEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(10)
					.sized(0.25f, 0.25f));
	public static final RegistryObject<EntityType<PurpleSandExplosiveAlchemyBombEntity>> PURPLE_SAND_EXPLOSIVE_ALCHEMY_BOMB = register("purple_sand_explosive_alchemy_bomb",
			EntityType.Builder.<PurpleSandExplosiveAlchemyBombEntity>of(PurpleSandExplosiveAlchemyBombEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(10)
					.sized(0.25f, 0.25f));
	public static final RegistryObject<EntityType<GemstoneThrowingKnivesShootEntity>> GEMSTONE_THROWING_KNIVES_SHOOT = register("gemstone_throwing_knives_shoot",
			EntityType.Builder.<GemstoneThrowingKnivesShootEntity>of(GemstoneThrowingKnivesShootEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(4)
					.sized(0.4f, 0.4f));
	public static final RegistryObject<EntityType<ThrowingStubbornStoneEntity>> THROWING_STUBBORN_STONE = register("throwing_stubborn_stone",
			EntityType.Builder.<ThrowingStubbornStoneEntity>of(ThrowingStubbornStoneEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(4)
					.sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<RottenBrightMelonEntity>> ROTTEN_BRIGHT_MELON = register("rotten_bright_melon",
			EntityType.Builder.<RottenBrightMelonEntity>of(RottenBrightMelonEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(4)
					.sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<VillagerMetalThrowingBallEntity>> VILLAGER_METAL_THROWING_BALL = register("villager_metal_throwing_ball",
			EntityType.Builder.<VillagerMetalThrowingBallEntity>of(VillagerMetalThrowingBallEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(4)
					.sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<GlassThrowingBallEntity>> GLASS_THROWING_BALL = register("glass_throwing_ball",
			EntityType.Builder.<GlassThrowingBallEntity>of(GlassThrowingBallEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(4)
					.sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<PotionThrowingBallEntity>> POTION_THROWING_BALL = register("potion_throwing_ball",
			EntityType.Builder.<PotionThrowingBallEntity>of(PotionThrowingBallEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(4)
					.sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<IceRockThrowingBallEntity>> ICE_ROCK_THROWING_BALL = register("ice_rock_throwing_ball",
			EntityType.Builder.<IceRockThrowingBallEntity>of(IceRockThrowingBallEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(4)
					.sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<BrightBolaEntity>> BRIGHT_BOLA = register("bright_bola",
			EntityType.Builder.<BrightBolaEntity>of(BrightBolaEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<VirtualCaveCrystalArrowEntity>> VIRTUAL_CAVE_CRYSTAL_ARROW = register("projectile_virtual_cave_crystal_arrow",
			EntityType.Builder.<VirtualCaveCrystalArrowEntity>of(VirtualCaveCrystalArrowEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AnestheticThrowingBallEntity>> ANESTHETIC_THROWING_BALL = register("anesthetic_throwing_ball",
			EntityType.Builder.<AnestheticThrowingBallEntity>of(AnestheticThrowingBallEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(4)
					.sized(0.3f, 0.3f));
	//技术性
	public static final RegistryObject<EntityType<RainEffectCloudEntity>> RAIN_EFFECT_CLOUD = register("rain_effect_cloud",
			EntityType.Builder.<RainEffectCloudEntity>of(RainEffectCloudEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(10)
					.sized(6.0f, 0.5f));
	public static final RegistryObject<EntityType<SlaverySupervisorChainEntity>> SLAVERY_SUPERVISOR_CHAIN = register("slavery_supervisor_chain",
			EntityType.Builder.<SlaverySupervisorChainEntity>of(SlaverySupervisorChainEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(4)
					.sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<OminousGearEntity>> OMINOUS_GEAR = register("ominous_gear",
			EntityType.Builder.<OminousGearEntity>of(OminousGearEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(10)
					.sized(1.0f, 0.5f));
	public static final RegistryObject<EntityType<UncleanBloodRainEntity>> UNCLEAN_BLOOD_RAIN = register("unclean_blood_rain",
			EntityType.Builder.<UncleanBloodRainEntity>of(UncleanBloodRainEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(10)
					.sized(6.0f, 0.5f));
	public static final RegistryObject<EntityType<ElectroflashEntity>> ELECTROFLASH = register("electroflash",
			EntityType.Builder.<ElectroflashEntity>of(ElectroflashEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(4)
					.sized(0.6f, 0.6f));
	//投影
	public static final RegistryObject<EntityType<BossShowEntity>> BOSS_SHOW_ENTITY_PURPLE_SAND_HAG = register("boss_show_entity_purple_sand_hag",
			EntityType.Builder.of(BossShowEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.sized(0.75f, 1.9375f));
	public static final RegistryObject<EntityType<BossShowEntity>> BOSS_SHOW_ENTITY_OMINOUS_BANNER_PROJECTION = register("boss_show_entity_ominous_banner_projection",
			EntityType.Builder.of(BossShowEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.sized(0.75f, 1.9375f));


	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> entityTypeBuilder.build(registryname));
	}
	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(UNICYCLE.get(), UnicycleEntity.createAttributes().build());
		event.put(SPEAR_MACHINE.get(), SpearMachineEntity.createAttributes().build());
		event.put(CARVED_IRON_GOLEM.get(), CarvedIronGolemEntity.createAttributes().build());
		event.put(BOUND_ZOMBIE_VILLAGER.get(), BoundZombieVillagerEntity.createAttributes().build());
		event.put(EXPLORER.get(), ExplorerEntity.createAttributes().build());
		event.put(EXECUTIONER.get(), ExecutionerEntity.createAttributes().build());
		event.put(MAPMAKER.get(), MapmakerEntity.createAttributes().build());
		event.put(DEFECTOR.get(), DefectorEntity.createAttributes().build());
		event.put(BANNER_BEARER.get(), BannerBearerEntity.createAttributes().build());
		event.put(BLASTER.get(), BlasterEntity.createAttributes().build());
		event.put(TRUMPETER.get(), TrumpeterEntity.createAttributes().build());
		event.put(TELEPORTER.get(), TeleporterEntity.createAttributes().build());
		event.put(CYCLONER.get(), CyclonerEntity.createAttributes().build());
		event.put(JAVELIN_THROWER.get(), JavelinThrowerEntity.createAttributes().build());
		event.put(ZOMBIE_KEEPER.get(), ZombieKeeperEntity.createAttributes().build());
		event.put(BITTER_COLD_SORCERER.get(), BitterColdSorcererEntity.createAttributes().build());
		event.put(BITTER_COLD_ALTAR.get(), BitterColdAltarEntity.createAttributes().build());
		event.put(FIRE_SPITTER.get(), FireSpitterEntity.createAttributes().build());
		event.put(WILD_FINDER.get(), WildFinderEntity.createAttributes().build());
		event.put(SUBMARINER.get(), SubmarinerEntity.createAttributes().build());
		event.put(LAMP_WIZARD.get(), LampWizardEntity.createAttributes().build());
		event.put(SLAVERY_SUPERVISOR.get(), SlaverySupervisorEntity.createAttributes().build());
		event.put(ANIMATED_CHAIN.get(), AnimatedChainEntity.createAttributes().build());
		event.put(FIREPOWER_POURER.get(), FirepowerPourerEntity.createAttributes().build());
		event.put(NECROMANCY_WARLOCK.get(), NecromancyWarlockEntity.createAttributes().build());
		event.put(UNCLEAN_TENTACLE.get(), UncleanTentacleEntity.createAttributes().build());
		event.put(GAVILER.get(), GavilerEntity.createAttributes().build());
		event.put(AX_CRAZY.get(), AxCrazyEntity.createAttributes().build());
		event.put(OMINOUS_BANNER_PROJECTION.get(), OminousBannerProjectionEntity.createAttributes().build());
		event.put(GIANT_MONSTER.get(), GiantMonsterEntity.createAttributes().build());
		event.put(PURPLE_SAND_RABBIT.get(), PurpleSandRabbitEntity.createAttributes().build());
		event.put(PURPLE_SAND_WITCH.get(), PurpleSandWitchEntity.createAttributes().build());
		event.put(WITCH_SCHOLAR.get(), WitchScholarEntity.createAttributes().build());
		event.put(BIG_WITCH.get(), BigWitchEntity.createAttributes().build());
		event.put(SPIRVE.get(), SpirveEntity.createAttributes().build());
		event.put(ROTTEN_DOG.get(), RottenDogEntity.createAttributes().build());
		event.put(COHORT_HAG.get(), CohortHagEntity.createAttributes().build());
		event.put(COVEN_HAG_ONE.get(), CovenHagEntity.createAttributes().build());
		event.put(COVEN_HAG_TWO.get(), CovenHagEntity.createAttributes().build());
		event.put(PURPLE_SAND_HAG.get(), PurpleSandHagEntity.createAttributes().build());
		event.put(PURPLE_SAND_PHANTOM.get(), PurpleSandPhantomEntity.createAttributes().build());
		event.put(WILDERNESS_WOLF.get(), WildernessWolfEntity.createAttributes().build());


		event.put(BOSS_SHOW_ENTITY_PURPLE_SAND_HAG.get(), BossShowEntity.createAttributes().build());
		event.put(BOSS_SHOW_ENTITY_OMINOUS_BANNER_PROJECTION.get(), BossShowEntity.createAttributes().build());
	}
}