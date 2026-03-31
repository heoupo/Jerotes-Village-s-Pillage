package com.jerotes.jvpillage.init;

import com.jerotes.jvpillage.JVPillage;
import com.jerotes.jvpillage.block.BaseBlock.ABaseBlock;
import com.jerotes.jvpillage.block.BrightGrassland.BrightMelons;
import com.jerotes.jvpillage.block.BrightGrassland.GlowShine;
import com.jerotes.jvpillage.block.BrightGrassland.SecondRoundNigrums;
import com.jerotes.jvpillage.block.DamagedRuins.MerorProjectionTable;
import com.jerotes.jvpillage.block.Other.*;
import com.jerotes.jvpillage.block.PurpleDesert.EnchantedStone;
import com.jerotes.jvpillage.block.PurpleDesert.HagsCauldron;
import com.jerotes.jvpillage.block.PurpleDesert.NewHagsCauldron;
import com.jerotes.jvpillage.block.PurpleDesert.UnstableHagsCauldron;
import com.jerotes.jvpillage.block.ResurrectSediment.MoistureProofPaste;
import com.jerotes.jvpillage.block.ResurrectSediment.SedimentUrn;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JVPillageBlocks {
	//1.20.4↑//
	//ofLegacyCopy
	//1。20.1//
	//copy
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, JVPillage.MODID);
	public static final RegistryObject<Block> AASTRONG_GRASS_BLOCK = REGISTRY.register("aastrong_grass_block", () -> new AAStrongGrassBlock());
	public static final RegistryObject<Block> AASTRONG_DIRT = REGISTRY.register("aastrong_dirt", () -> new AAStrongDirt());

	public static final RegistryObject<Block> SECOND_ROUND_ANCHOR_CORE = REGISTRY.register("second_round_anchor_core", () -> new SecondRounderAnchorCore());
	//沉降
	public static final RegistryObject<Block> SEDIMENT_MUD_BRICKS = REGISTRY.register("sediment_mud_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5f, 3.0f)));
	public static final RegistryObject<Block> SEDIMENT_MUD_BRICK_STAIRS = REGISTRY.register("sediment_mud_brick_stairs", () ->  new ABaseBlock.ABaseStair(SEDIMENT_MUD_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SEDIMENT_MUD_BRICKS.get())));
	public static final RegistryObject<Block> SEDIMENT_MUD_BRICK_SLAB = REGISTRY.register("sediment_mud_brick_slab", () -> new ABaseBlock.ABaseSlab(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0f, 6.0f)));
	public static final RegistryObject<Block> SEDIMENT_MUD_BRICK_WALL = REGISTRY.register("sediment_mud_brick_wall", () -> new ABaseBlock.ABaseWallBlock(BlockBehaviour.Properties.copy(JVPillageBlocks.SEDIMENT_MUD_BRICKS.get()).forceSolidOn()));
	public static final RegistryObject<Block> SEDIMENT_MOISTURE_PROOF_PASTE = REGISTRY.register("sediment_moisture_proof_paste", () -> new MoistureProofPaste());
	public static final RegistryObject<Block> SEDIMENT_COFFIN = REGISTRY.register("sediment_coffin", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.STONE).strength(1.5f, 3.0f).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> SEDIMENT_URN = REGISTRY.register("sediment_urn", () -> new SedimentUrn());
	//灾厄
	public static final RegistryObject<Block> OMINOUS_TORCH = REGISTRY.register("ominous_torch", () -> new OminousTorch(ParticleTypes.FLAME, BlockBehaviour.Properties.of().noCollission().lightLevel(blockState -> 15).strength(0.2f, 2.0f).sound(SoundType.METAL).pushReaction(PushReaction.DESTROY)));
	public static final RegistryObject<Block> OMINOUS_WALL_TORCH = REGISTRY.register("ominous_wall_torch", () -> new OminousWallTorch(ParticleTypes.FLAME, BlockBehaviour.Properties.of().noCollission().lightLevel(blockState -> 15).strength(0.2f, 2.0f).sound(SoundType.METAL).dropsLike(OMINOUS_TORCH.get()).pushReaction(PushReaction.DESTROY)));
	///Bitter Cold 苦寒群系
	public static final RegistryObject<Block> SNOW_FROZEN_SOIL = REGISTRY.register("snow_frozen_soil", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).strength(0.5f)));
	public static final RegistryObject<Block> ICE_ROCK = REGISTRY.register("ice_rock", () -> new IceBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(2.8f, 0.5f).requiresCorrectToolForDrops()));
	//Purple Desert 紫沙群系
	public static final RegistryObject<Block> PURPLE_SAND = REGISTRY.register("purple_sand", () -> new ABaseBlock.ABaseFallingBlock(11689178, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
	public static final RegistryObject<Block> PURPLE_SANDSTONE = REGISTRY.register("purple_sandstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
	public static final RegistryObject<Block> PURPLE_SANDSTONE_STAIRS = REGISTRY.register("purple_sandstone_stairs", () -> new ABaseBlock.ABaseStair(PURPLE_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(PURPLE_SANDSTONE.get())));
	public static final RegistryObject<Block> PURPLE_SANDSTONE_SLAB = REGISTRY.register("purple_sandstone_slab", () -> new ABaseBlock.ABaseSlab(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0f, 6.0f)));
	public static final RegistryObject<Block> PURPLE_SANDSTONE_WALL = REGISTRY.register("purple_sandstone_wall", () -> new ABaseBlock.ABaseWallBlock(BlockBehaviour.Properties.copy(PURPLE_SANDSTONE.get()).forceSolidOn()));
	public static final RegistryObject<Block> CHISELED_PURPLE_SANDSTONE = REGISTRY.register("chiseled_purple_sandstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
	public static final RegistryObject<Block> SMOOTH_PURPLE_SANDSTONE = REGISTRY.register("smooth_purple_sandstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0f, 6.0f)));
	public static final RegistryObject<Block> SMOOTH_PURPLE_SANDSTONE_STAIRS = REGISTRY.register("smooth_purple_sandstone_stairs", () -> new ABaseBlock.ABaseStair(SMOOTH_PURPLE_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(PURPLE_SANDSTONE.get())));
	public static final RegistryObject<Block> SMOOTH_PURPLE_SANDSTONE_SLAB = REGISTRY.register("smooth_purple_sandstone_slab", () -> new ABaseBlock.ABaseSlab(BlockBehaviour.Properties.copy(SMOOTH_PURPLE_SANDSTONE.get())));
	public static final RegistryObject<Block> CUT_PURPLE_SANDSTONE = REGISTRY.register("cut_purple_sandstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
	public static final RegistryObject<Block> CUT_PURPLE_SANDSTONE_SLAB = REGISTRY.register("cut_purple_sandstone_slab", () -> new ABaseBlock.ABaseSlab(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0f, 6.0f)));
	public static final RegistryObject<Block> ENCHANTED_STONE = REGISTRY.register("enchanted_stone", () -> new EnchantedStone());
	public static final RegistryObject<Block> SPIRVE_HEAD = REGISTRY.register("spirve_head", () -> new ABaseBlock.ABaseSkullBlock(ABaseBlock.Types.SPIRVE, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.CUSTOM_HEAD).strength(1.0f).pushReaction(PushReaction.DESTROY), JVPillageSoundEvents.NOTE_BLOCK_IMITATE_SPIRVE));
	public static final RegistryObject<Block> SPIRVE_WALL_HEAD = REGISTRY.register("spirve_wall_head", () -> new ABaseBlock.ABaseWallSkullBlock(ABaseBlock.Types.SPIRVE, BlockBehaviour.Properties.of().strength(1.0f).dropsLike(SPIRVE_HEAD.get()).pushReaction(PushReaction.DESTROY)));
	public static final RegistryObject<Block> HAGS_CAULDRON = REGISTRY.register("hags_cauldron", () -> new HagsCauldron(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(50f, 10000f).pushReaction(PushReaction.BLOCK).noOcclusion()));
	public static final RegistryObject<Block> UNSTABLE_HAGS_CAULDRON = REGISTRY.register("unstable_hags_cauldron", () -> new UnstableHagsCauldron());
	public static final RegistryObject<Block> DIRTY_HAGS_CAULDRON = REGISTRY.register("dirty_hags_cauldron", () -> new HagsCauldron(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(50f, 10000f).pushReaction(PushReaction.BLOCK).noOcclusion()));
	public static final RegistryObject<Block> NEW_HAGS_CAULDRON = REGISTRY.register("new_hags_cauldron", () -> new NewHagsCauldron());
	//Endless Ocean 海洋群系
	public static final RegistryObject<Block> GEMSTONE_GRAVEL = REGISTRY.register("gemstone_gravel", () -> new ABaseBlock.ABaseFallingBlock(7242892, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.SNARE).strength(0.6f).sound(SoundType.GRAVEL)));
	public static final RegistryObject<Block> GLITTER_SAND = REGISTRY.register("glitter_sand", () -> new ABaseBlock.ABaseFallingBlock(15267318, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
	public static final RegistryObject<Block> GLITTER_SANDSTONE = REGISTRY.register("glitter_sandstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
	public static final RegistryObject<Block> GLITTER_SANDSTONE_STAIRS = REGISTRY.register("glitter_sandstone_stairs", () -> new ABaseBlock.ABaseStair(GLITTER_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(GLITTER_SANDSTONE.get())));
	public static final RegistryObject<Block> GLITTER_SANDSTONE_SLAB = REGISTRY.register("glitter_sandstone_slab", () -> new ABaseBlock.ABaseSlab(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0f, 6.0f)));
	public static final RegistryObject<Block> GLITTER_SANDSTONE_WALL = REGISTRY.register("glitter_sandstone_wall", () -> new ABaseBlock.ABaseWallBlock(BlockBehaviour.Properties.copy(GLITTER_SANDSTONE.get()).forceSolidOn()));
	public static final RegistryObject<Block> CHISELED_GLITTER_SANDSTONE = REGISTRY.register("chiseled_glitter_sandstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
	public static final RegistryObject<Block> SMOOTH_GLITTER_SANDSTONE = REGISTRY.register("smooth_glitter_sandstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0f, 6.0f)));
	public static final RegistryObject<Block> SMOOTH_GLITTER_SANDSTONE_STAIRS = REGISTRY.register("smooth_glitter_sandstone_stairs", () -> new ABaseBlock.ABaseStair(SMOOTH_GLITTER_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(GLITTER_SANDSTONE.get())));
	public static final RegistryObject<Block> SMOOTH_GLITTER_SANDSTONE_SLAB = REGISTRY.register("smooth_glitter_sandstone_slab", () -> new ABaseBlock.ABaseSlab(BlockBehaviour.Properties.copy(SMOOTH_GLITTER_SANDSTONE.get())));
	public static final RegistryObject<Block> CUT_GLITTER_SANDSTONE = REGISTRY.register("cut_glitter_sandstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
	public static final RegistryObject<Block> CUT_GLITTER_SANDSTONE_SLAB = REGISTRY.register("cut_glitter_sandstone_slab", () -> new ABaseBlock.ABaseSlab(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0f, 6.0f)));
	public static final RegistryObject<Block> OCEAN_GEMSTONE_BLOCK = REGISTRY.register("ocean_gemstone_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.METAL).strength(5.0f, 6.0f).requiresCorrectToolForDrops()));
	//Bright Grassland 明草群系
	public static final RegistryObject<Block> BRIGHT_COBBLESTONE = REGISTRY.register("bright_cobblestone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0f, 6.0f).lightLevel(s -> 9)));
	public static final RegistryObject<Block> BRIGHT_COBBLESTONE_STAIRS = REGISTRY.register("bright_cobblestone_stairs", () -> new ABaseBlock.ABaseStair(BRIGHT_COBBLESTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(BRIGHT_COBBLESTONE.get()).lightLevel(s -> 9)));
	public static final RegistryObject<Block> BRIGHT_COBBLESTONE_SLAB = REGISTRY.register("bright_cobblestone_slab", () -> new ABaseBlock.ABaseSlab(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0f, 6.0f).lightLevel(s -> 9)));
	public static final RegistryObject<Block> BRIGHT_COBBLESTONE_WALL = REGISTRY.register("bright_cobblestone_wall", () -> new ABaseBlock.ABaseWallBlock(BlockBehaviour.Properties.copy(BRIGHT_COBBLESTONE.get()).forceSolidOn().lightLevel(s -> 9)));
	public static final RegistryObject<Block> TANGLER_HEAD = REGISTRY.register("tangler_head", () -> new ABaseBlock.ABaseSkullBlock(ABaseBlock.Types.TANGLER, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.CUSTOM_HEAD).strength(1.0f).pushReaction(PushReaction.DESTROY), JVPillageSoundEvents.NOTE_BLOCK_IMITATE_TANGLER));
	public static final RegistryObject<Block> TANGLER_WALL_HEAD = REGISTRY.register("tangler_wall_head", () -> new ABaseBlock.ABaseWallSkullBlock(ABaseBlock.Types.TANGLER, BlockBehaviour.Properties.of().strength(1.0f).dropsLike(TANGLER_HEAD.get()).pushReaction(PushReaction.DESTROY)));
	public static final RegistryObject<Block> SECOND_ROUND_NIGRUMS = REGISTRY.register("second_round_nigrums", () -> new SecondRoundNigrums());
	public static final RegistryObject<Block> SECOND_ROUND_NIGRUM_CRATE = REGISTRY.register("second_round_nigrum_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.5f).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> BRIGHT_MELONS = REGISTRY.register("bright_melons", () -> new BrightMelons());
	public static final RegistryObject<Block> BRIGHT_MELON_CRATE = REGISTRY.register("bright_melon_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.5f).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> GOLDEN_BRIGHT_MELON_CRATE = REGISTRY.register("golden_bright_melon_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.5f).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> GLOW_SHINE = REGISTRY.register("glow_shine", () -> new GlowShine());
	//Drought Fire 旱火群系
	public static final RegistryObject<Block> DROUGHT_FIRE_STONE = REGISTRY.register("drought_fire_stone", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(5.0f, 6.0f)));
	public static final RegistryObject<Block> DROUGHT_FIRE_BRICKS = REGISTRY.register("drought_fire_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0f, 6.0f)));
	public static final RegistryObject<Block> DROUGHT_FIRE_BRICK_STAIRS = REGISTRY.register("drought_fire_brick_stairs", () ->  new ABaseBlock.ABaseStair(DROUGHT_FIRE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(DROUGHT_FIRE_BRICKS.get())));
	public static final RegistryObject<Block> DROUGHT_FIRE_BRICK_SLAB = REGISTRY.register("drought_fire_brick_slab", () -> new ABaseBlock.ABaseSlab(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0f, 6.0f)));
	public static final RegistryObject<Block> DROUGHT_FIRE_BRICK_WALL = REGISTRY.register("drought_fire_brick_wall", () -> new ABaseBlock.ABaseWallBlock(BlockBehaviour.Properties.copy(JVPillageBlocks.DROUGHT_FIRE_BRICKS.get()).forceSolidOn()));
	public static final RegistryObject<Block> DROUGHT_FIRE_MUD = REGISTRY.register("drought_fire_mud", () -> new MudBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).lightLevel(blockState -> 12).isValidSpawn(JVPillageBlocks::always).isRedstoneConductor(JVPillageBlocks::always).isViewBlocking(JVPillageBlocks::always).isSuffocating(JVPillageBlocks::always).sound(SoundType.MUD)));
	public static final RegistryObject<Block> FIRELIGHT_STONE = REGISTRY.register("firelight_stone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.PLING).strength(0.3f).sound(SoundType.STONE).lightLevel(blockState -> 15).isRedstoneConductor((arg_0, arg_1, arg_2) -> false)));

	//Sand Beach 沙屿群系
	public static final RegistryObject<Block> SUN_SAND = REGISTRY.register("sun_sand", () -> new ABaseBlock.ABaseFallingBlock(-5729, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
	public static final RegistryObject<Block> SUN_SANDSTONE = REGISTRY.register("sun_sandstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
	public static final RegistryObject<Block> SUN_SANDSTONE_STAIRS = REGISTRY.register("sun_sandstone_stairs", () -> new ABaseBlock.ABaseStair(SUN_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(SUN_SANDSTONE.get())));
	public static final RegistryObject<Block> SUN_SANDSTONE_SLAB = REGISTRY.register("sun_sandstone_slab", () -> new ABaseBlock.ABaseSlab(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0f, 6.0f)));
	public static final RegistryObject<Block> SUN_SANDSTONE_WALL = REGISTRY.register("sun_sandstone_wall", () -> new ABaseBlock.ABaseWallBlock(BlockBehaviour.Properties.copy(SUN_SANDSTONE.get()).forceSolidOn()));
	public static final RegistryObject<Block> CHISELED_SUN_SANDSTONE = REGISTRY.register("chiseled_sun_sandstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
	public static final RegistryObject<Block> SMOOTH_SUN_SANDSTONE = REGISTRY.register("smooth_sun_sandstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0f, 6.0f)));
	public static final RegistryObject<Block> SMOOTH_SUN_SANDSTONE_STAIRS = REGISTRY.register("smooth_sun_sandstone_stairs", () -> new ABaseBlock.ABaseStair(SMOOTH_SUN_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(SUN_SANDSTONE.get())));
	public static final RegistryObject<Block> SMOOTH_SUN_SANDSTONE_SLAB = REGISTRY.register("smooth_sun_sandstone_slab", () -> new ABaseBlock.ABaseSlab(BlockBehaviour.Properties.copy(SMOOTH_SUN_SANDSTONE.get())));
	public static final RegistryObject<Block> CUT_SUN_SANDSTONE = REGISTRY.register("cut_sun_sandstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
	public static final RegistryObject<Block> CUT_SUN_SANDSTONE_SLAB = REGISTRY.register("cut_sun_sandstone_slab", () -> new ABaseBlock.ABaseSlab(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0f, 6.0f)));
	//Damaged Ruins 遗迹群系
	public static final RegistryObject<Block> INDUSTRIAL_RESIDUAL_SOIL = REGISTRY.register("industrial_residual_soil", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(1.0f, 12f).sound(SoundType.GRAVEL)));
	public static final RegistryObject<Block> MEROR_PROJECTION_TABLE = REGISTRY.register("meror_projection_table", () -> new MerorProjectionTable());

	private static Boolean always(BlockState p_50810_, BlockGetter p_50811_, BlockPos p_50812_, EntityType<?> p_50813_) {
		return true;
	}
	private static boolean always(BlockState p_50775_, BlockGetter p_50776_, BlockPos p_50777_) {
		return true;
	}
}
