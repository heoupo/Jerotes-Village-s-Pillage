package com.jerotes.jerotesvillage.init;

import com.jerotes.jerotesvillage.util.SpawnRules;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JerotesVillageSpawnPlacements {
	public static void init() {
		SpawnPlacements.register(JerotesVillageEntityType.SPEAR_MACHINE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.NeutralSpawn(8, 64, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.UNICYCLE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.NeutralSpawn(8, 64, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.CARVED_IRON_GOLEM.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.CarvedSpawn(8, 64, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.BOUND_ZOMBIE_VILLAGER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.DarkMonsterSpawn(32, 128, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.EXPLORER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(16, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.EXECUTIONER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(8, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.MAPMAKER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(4, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.DEFECTOR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(64, 32, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.BANNER_BEARER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(4, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.BLASTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(64, 32, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.TRUMPETER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(64, 32, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.TELEPORTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(4, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.CYCLONER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(64, 32, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.JAVELIN_THROWER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(64, 32, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.ZOMBIE_KEEPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(64, 32, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.BITTER_COLD_SORCERER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(8, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.BITTER_COLD_ALTAR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.NeutralSpawn(8, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.FIRE_SPITTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(8, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.WILD_FINDER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(8, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.SUBMARINER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(8, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.LAMP_WIZARD.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(8, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.SLAVERY_SUPERVISOR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(1, 128, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.ANIMATED_CHAIN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.NeutralSpawn(8, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.FIREPOWER_POURER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(1, 128, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.NECROMANCY_WARLOCK.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(1, 128, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.UNCLEAN_TENTACLE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.NeutralSpawn(8, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.GAVILER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(1, 128, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.AX_CRAZY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(1, 128, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.OMINOUS_BANNER_PROJECTION.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.BossSpawn(1, 256, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.GIANT_MONSTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.NeutralSpawn(16, 64, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.PURPLE_SAND_RABBIT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.NeutralSpawn(16, 64, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.PURPLE_SAND_WITCH.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.DarkMonsterSpawn(4, 128, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.WITCH_SCHOLAR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.DarkMonsterSpawn(16, 128, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.BIG_WITCH.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.EliteSpawn(1, 128, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.SPIRVE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.DarkMonsterSpawn(32, 128, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.ROTTEN_DOG.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.NeutralSpawn(16, 64, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.COHORT_HAG.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.EliteSpawn(1, 128, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.COVEN_HAG_ONE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.EliteSpawn(1, 128, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.COVEN_HAG_TWO.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.EliteSpawn(1, 128, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.PURPLE_SAND_HAG.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.BossSpawn(1, 256, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.PURPLE_SAND_PHANTOM.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.NeutralSpawn(8, 64, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JerotesVillageEntityType.WILDERNESS_WOLF.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.AnimalSpawn(16, 64, arg_0, arg_1, arg_2, arg_3, arg_4));
	}
}