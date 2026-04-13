package com.jerotes.jerotesvillage.init;

import com.jerotes.jerotesvillage.client.renderer.*;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class JerotesVillageEntityRenderers {

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(JerotesVillageBlockEntityType.ABASE_SKULL_BLOCK.get(), SkullBlockRenderer::new);
        

        event.registerEntityRenderer(JerotesVillageEntityType.RAIN_EFFECT_CLOUD.get(), NoopRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.OMINOUS_GEAR.get(), OminousGearRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.UNCLEAN_BLOOD_RAIN.get(), NoopRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.ELECTROFLASH.get(), ElectroflashRenderer::new);

        event.registerEntityRenderer(JerotesVillageEntityType.ELASTIC_ICE_ROCK.get(), ElasticIceRockRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.THROWN_VILLAGER_METAL_JAVELIN.get(), ThrownJavelinRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.CARVED_VILLAGER_SPECTRAL_ARROW.get(), JerotesVillageArrowRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.OMINOUS_BOMB.get(), OminousBombRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.OMINOUS_BOMB_FRAGMENT.get(), OminousBombFragmentRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.OMINOUS_JAVALIN.get(), OminousJavelinRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.BITTER_COLD_ICE_SPIKE.get(), BitterColdIceSpikeRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.BITTER_COLD_FROSTBITE.get(), ShootRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.OMINOUS_FLAMES.get(), ShootRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.ARCANE_LIGHT_SPOT.get(), ShootRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.ELASTIC_LIGHT_BALL.get(), ElasticLightBallRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.RADIANT_BOMB.get(), ShootRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.SLAVERY_SUPERVISOR_CHAIN.get(), ShootRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.BLOODY_SCREAM.get(), ShootRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.PUSH_FORCE.get(), ShootRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.FLOATING_FORCE.get(), ShootRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.GRAVITY_FORCE.get(), ShootRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.ICE_ROCK_THROWING_BALL.get(), ShootRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.PURPLE_SAND_ALCHEMY_BOMB.get(), ShootRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.PURPLE_SAND_EXPLOSIVE_ALCHEMY_BOMB.get(), ShootRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.GEMSTONE_THROWING_KNIVES_SHOOT.get(), GemstoneThrowingKnivesShootRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.ROTTEN_BRIGHT_MELON.get(), ShootRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.THROWING_STUBBORN_STONE.get(), ShootRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.VILLAGER_METAL_THROWING_BALL.get(), ShootRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.GLASS_THROWING_BALL.get(), ShootRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.POTION_THROWING_BALL.get(), ShootRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.BRIGHT_BOLA.get(), BrightBolaRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.VIRTUAL_CAVE_CRYSTAL_ARROW.get(), JerotesVillageArrowRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.ANESTHETIC_THROWING_BALL.get(), ShootRenderer::new);

        event.registerEntityRenderer(JerotesVillageEntityType.SPEAR_MACHINE.get(), SpearMachineRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.UNICYCLE.get(), UnicycleRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.CARVED_IRON_GOLEM.get(), CarvedIronGolemRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.BOUND_ZOMBIE_VILLAGER.get(), BoundZombieVillagerRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.EXPLORER.get(), ExplorerRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.EXECUTIONER.get(), ExecutionerRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.MAPMAKER.get(), MapmakerRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.DEFECTOR.get(), DefectorRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.BANNER_BEARER.get(), BannerBearerRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.BLASTER.get(), BlasterRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.TRUMPETER.get(), TrumpeterRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.TELEPORTER.get(), TeleporterRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.CYCLONER.get(), CyclonerRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.JAVELIN_THROWER.get(), JavelinThrowerRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.ZOMBIE_KEEPER.get(), ZombieKeeperRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.BITTER_COLD_SORCERER.get(), BitterColdSorcererRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.BITTER_COLD_ALTAR.get(), BitterColdAltarRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.BITTER_COLD_ALTAR_PART.get(), PartRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.FIRE_SPITTER.get(), FireSpitterRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.WILD_FINDER.get(), WildFinderRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.SUBMARINER.get(), SubmarinerRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.LAMP_WIZARD.get(), LampWizardRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.SLAVERY_SUPERVISOR.get(), SlaverySupervisorRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.ANIMATED_CHAIN.get(), AnimatedChainRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.FIREPOWER_POURER.get(), FirepowerPourerRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.NECROMANCY_WARLOCK.get(), NecromancyWarlockRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.UNCLEAN_TENTACLE.get(), UncleanTentacleRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.GAVILER.get(), GavilerRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.AX_CRAZY.get(), AxCrazyRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.OMINOUS_BANNER_PROJECTION.get(), OminousBannerProjectionRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.GIANT_MONSTER.get(), GiantMonsterRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.PURPLE_SAND_RABBIT.get(), PurpleSandRabbitRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.PURPLE_SAND_WITCH.get(), PurpleSandWitchRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.WITCH_SCHOLAR.get(), WitchScholarRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.BIG_WITCH.get(), BigWitchRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.SPIRVE.get(), SpirveRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.ROTTEN_DOG.get(), RottenDogRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.COHORT_HAG.get(), HagRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.COVEN_HAG_ONE.get(), HagRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.COVEN_HAG_TWO.get(), HagRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.PURPLE_SAND_HAG.get(), HagRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.PURPLE_SAND_PHANTOM.get(), PurpleSandPhantomRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.BOSS_SHOW_ENTITY_PURPLE_SAND_HAG.get(), BossShowEntityPurpleSandHagRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.BOSS_SHOW_ENTITY_OMINOUS_BANNER_PROJECTION.get(), BossShowEntityOminousBannerProjectionRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.WILDERNESS_WOLF.get(), WildernessWolfRenderer::new);

        event.registerEntityRenderer(JerotesVillageEntityType.BLAMER_NECROMANCY_WARLOCK.get(), BlamerNecromancyWarlockRenderer::new);
        event.registerEntityRenderer(JerotesVillageEntityType.FURY_BLAMER_NECROMANCY_WARLOCK.get(), FuryBlamerNecromancyWarlockRenderer::new);

    }
}
