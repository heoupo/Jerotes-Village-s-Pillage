package com.jerotes.jvpillage.init;

import com.jerotes.jvpillage.client.renderer.*;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class JVPillageEntityRenderers {

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(JVPillageBlockEntityType.ABASE_SKULL_BLOCK.get(), SkullBlockRenderer::new);
        

        event.registerEntityRenderer(JVPillageEntityType.RAIN_EFFECT_CLOUD.get(), NoopRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.OMINOUS_GEAR.get(), OminousGearRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.UNCLEAN_BLOOD_RAIN.get(), NoopRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.ELECTROFLASH.get(), ElectroflashRenderer::new);

        event.registerEntityRenderer(JVPillageEntityType.ELASTIC_ICE_ROCK.get(), ElasticIceRockRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.OMINOUS_BOMB.get(), OminousBombRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.OMINOUS_BOMB_FRAGMENT.get(), OminousBombFragmentRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.OMINOUS_JAVALIN.get(), OminousJavelinRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.BITTER_COLD_ICE_SPIKE.get(), BitterColdIceSpikeRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.BITTER_COLD_FROSTBITE.get(), ShootRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.OMINOUS_FLAMES.get(), ShootRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.ARCANE_LIGHT_SPOT.get(), ShootRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.ELASTIC_LIGHT_BALL.get(), ElasticLightBallRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.RADIANT_BOMB.get(), ShootRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.SLAVERY_SUPERVISOR_CHAIN.get(), ShootRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.BLOODY_SCREAM.get(), ShootRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.PUSH_FORCE.get(), ShootRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.FLOATING_FORCE.get(), ShootRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.GRAVITY_FORCE.get(), ShootRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.ICE_ROCK_THROWING_BALL.get(), ShootRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.PURPLE_SAND_ALCHEMY_BOMB.get(), ShootRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.PURPLE_SAND_EXPLOSIVE_ALCHEMY_BOMB.get(), ShootRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.GEMSTONE_THROWING_KNIVES_SHOOT.get(), GemstoneThrowingKnivesShootRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.ROTTEN_BRIGHT_MELON.get(), ShootRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.THROWING_STUBBORN_STONE.get(), ShootRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.GLASS_THROWING_BALL.get(), ShootRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.POTION_THROWING_BALL.get(), ShootRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.BRIGHT_BOLA.get(), BrightBolaRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.VIRTUAL_CAVE_CRYSTAL_ARROW.get(), JerotesVillageArrowRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.ANESTHETIC_THROWING_BALL.get(), ShootRenderer::new);

        event.registerEntityRenderer(JVPillageEntityType.BOUND_ZOMBIE_VILLAGER.get(), BoundZombieVillagerRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.EXPLORER.get(), ExplorerRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.EXECUTIONER.get(), ExecutionerRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.MAPMAKER.get(), MapmakerRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.DEFECTOR.get(), DefectorRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.BANNER_BEARER.get(), BannerBearerRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.BLASTER.get(), BlasterRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.TRUMPETER.get(), TrumpeterRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.TELEPORTER.get(), TeleporterRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.CYCLONER.get(), CyclonerRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.JAVELIN_THROWER.get(), JavelinThrowerRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.ZOMBIE_KEEPER.get(), ZombieKeeperRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.BITTER_COLD_SORCERER.get(), BitterColdSorcererRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.BITTER_COLD_ALTAR.get(), BitterColdAltarRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.BITTER_COLD_ALTAR_PART.get(), PartRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.FIRE_SPITTER.get(), FireSpitterRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.WILD_FINDER.get(), WildFinderRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.SUBMARINER.get(), SubmarinerRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.LAMP_WIZARD.get(), LampWizardRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.SLAVERY_SUPERVISOR.get(), SlaverySupervisorRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.ANIMATED_CHAIN.get(), AnimatedChainRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.FIREPOWER_POURER.get(), FirepowerPourerRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.NECROMANCY_WARLOCK.get(), NecromancyWarlockRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.UNCLEAN_TENTACLE.get(), UncleanTentacleRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.GAVILER.get(), GavilerRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.AX_CRAZY.get(), AxCrazyRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.OMINOUS_BANNER_PROJECTION.get(), OminousBannerProjectionRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.GIANT_MONSTER.get(), GiantMonsterRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.PURPLE_SAND_RABBIT.get(), PurpleSandRabbitRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.PURPLE_SAND_WITCH.get(), PurpleSandWitchRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.WITCH_SCHOLAR.get(), WitchScholarRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.BIG_WITCH.get(), BigWitchRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.SPIRVE.get(), SpirveRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.ROTTEN_DOG.get(), RottenDogRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.COHORT_HAG.get(), HagRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.COVEN_HAG_ONE.get(), HagRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.COVEN_HAG_TWO.get(), HagRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.PURPLE_SAND_HAG.get(), HagRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.PURPLE_SAND_PHANTOM.get(), PurpleSandPhantomRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.BOSS_SHOW_ENTITY_PURPLE_SAND_HAG.get(), BossShowEntityPurpleSandHagRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.BOSS_SHOW_ENTITY_OMINOUS_BANNER_PROJECTION.get(), BossShowEntityOminousBannerProjectionRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.WILDERNESS_WOLF.get(), WildernessWolfRenderer::new);

        event.registerEntityRenderer(JVPillageEntityType.BLAMER_NECROMANCY_WARLOCK.get(), BlamerNecromancyWarlockRenderer::new);
        event.registerEntityRenderer(JVPillageEntityType.FURY_BLAMER_NECROMANCY_WARLOCK.get(), FuryBlamerNecromancyWarlockRenderer::new);
    }
}
