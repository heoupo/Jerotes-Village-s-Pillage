package com.jerotes.jvpillage.init;

import com.jerotes.jvpillage.util.SpawnRules;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JVPillageSpawnPlacements {
	public static void init() {
		SpawnPlacements.register(JVPillageEntityType.BOUND_ZOMBIE_VILLAGER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.DarkMonsterSpawn(32, 128, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.EXPLORER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(16, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.EXECUTIONER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(8, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.MAPMAKER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(4, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.DEFECTOR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(64, 32, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.BANNER_BEARER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(4, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.BLASTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(64, 32, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.TRUMPETER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(64, 32, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.TELEPORTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(4, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.CYCLONER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(64, 32, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.JAVELIN_THROWER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(64, 32, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.ZOMBIE_KEEPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(64, 32, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.BITTER_COLD_SORCERER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(8, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.BITTER_COLD_ALTAR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.NeutralSpawn(8, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.FIRE_SPITTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(8, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.WILD_FINDER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(8, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.SUBMARINER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(8, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.LAMP_WIZARD.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(8, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.SLAVERY_SUPERVISOR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(1, 128, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.ANIMATED_CHAIN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.NeutralSpawn(8, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.FIREPOWER_POURER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(1, 128, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.NECROMANCY_WARLOCK.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(1, 128, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.UNCLEAN_TENTACLE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.NeutralSpawn(8, 64, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.GAVILER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(1, 128, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.AX_CRAZY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.LightMonsterSpawn(1, 128, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.OMINOUS_BANNER_PROJECTION.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.BossSpawn(1, 256, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.GIANT_MONSTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.NeutralSpawn(16, 64, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.PURPLE_SAND_RABBIT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.NeutralSpawn(16, 64, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.PURPLE_SAND_WITCH.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.DarkMonsterSpawn(4, 128, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.WITCH_SCHOLAR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.DarkMonsterSpawn(16, 128, arg_0, arg_1, arg_2, arg_3, arg_4) &&
						SpawnRules.BlockSpawn(64, JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE.get(), arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.BIG_WITCH.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.EliteSpawn(1, 128, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.SPIRVE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.DarkMonsterSpawn(32, 128, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.ROTTEN_DOG.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.NeutralSpawn(16, 64, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.COHORT_HAG.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.EliteSpawn(1, 128, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.COVEN_HAG_ONE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.EliteSpawn(1, 128, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.COVEN_HAG_TWO.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.EliteSpawn(1, 128, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.PURPLE_SAND_HAG.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.BossSpawn(1, 256, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.PURPLE_SAND_PHANTOM.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.NeutralSpawn(8, 64, arg_0, arg_1, arg_2, arg_3, arg_4));
		SpawnPlacements.register(JVPillageEntityType.WILDERNESS_WOLF.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (arg_0, arg_1, arg_2, arg_3, arg_4) ->
				SpawnRules.AnimalSpawn(16, 64, arg_0, arg_1, arg_2, arg_3, arg_4));
	}
}