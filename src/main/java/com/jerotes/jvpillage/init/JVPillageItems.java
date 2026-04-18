package com.jerotes.jvpillage.init;

import com.jerotes.jerotes.entity.Interface.ArmorEntity;
import com.jerotes.jerotes.init.JerotesItemsAdd;
import com.jerotes.jerotes.item.ItemGiantBeastArmor;
import com.jerotes.jerotes.item.ItemWarBeastArmor;
import com.jerotes.jerotes.item.Tool.ItemToolBaseShield;
import com.jerotes.jvpillage.JVPillage;
import com.jerotes.jvpillage.block.DamagedRuins.MerorProjectionTable;
import com.jerotes.jvpillage.entity.Shoot.Arrow.VirtualCaveCrystalArrowEntity;
import com.jerotes.jvpillage.entity.Shoot.Other.OminousBombEntity;
import com.jerotes.jvpillage.entity.Shoot.Other.PurpleSandAlchemyBombEntity;
import com.jerotes.jvpillage.entity.Shoot.Other.PurpleSandExplosiveAlchemyBombEntity;
import com.jerotes.jvpillage.entity.Shoot.ThrowingBall.*;
import com.jerotes.jvpillage.item.*;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class JVPillageItems implements JerotesItemsAdd {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, JVPillage.MODID);

	public static final RegistryObject<Item> JEROTESVILLAGE = REGISTRY.register("jerotesvillage", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> SECOND_ROUND_ANCHOR_CORE = uncommonBlock(JVPillageBlocks.SECOND_ROUND_ANCHOR_CORE);

	public static final RegistryObject<Item> AASTRONG_GRASS_BLOCK = fireResistanceEpicBlock(JVPillageBlocks.AASTRONG_GRASS_BLOCK);
	public static final RegistryObject<Item> AASTRONG_DIRT = fireResistanceEpicBlock(JVPillageBlocks.AASTRONG_DIRT);

	//额外地图-主世界
	public static final RegistryObject<Item> ANCIENT_CITY_MAP = REGISTRY.register("ancient_city_map", () -> new ItemOverworldMagicMap(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON), "ancient_city"));
	public static final RegistryObject<Item> STRONGHOLD_MAP = REGISTRY.register("stronghold_map", () -> new ItemOverworldMagicMap(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON), "stronghold"));
	public static final RegistryObject<Item> DESERT_PYRAMID_MAP = REGISTRY.register("desert_pyramid_map", () -> new ItemOverworldMagicMap(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON), "desert_pyramid"));
	public static final RegistryObject<Item> JUNGLE_PYRAMID_MAP = REGISTRY.register("jungle_pyramid_map", () -> new ItemOverworldMagicMap(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON), "jungle_pyramid"));
	public static final RegistryObject<Item> WOODLAND_MANSION_MAP = REGISTRY.register("woodland_mansion_map", () -> new ItemOverworldMagicMap(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON), "woodland_mansion"));
	public static final RegistryObject<Item> OCEAN_MONUMENT_MAP = REGISTRY.register("ocean_monument_map", () -> new ItemOverworldMagicMap(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON), "ocean_monument"));
	//额外地图-下界/末地
	public static final RegistryObject<Item> BASTION_REMNANT_MAP = REGISTRY.register("bastion_remnant_map", () -> new ItemNetherMagicMap(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON), "bastion_remnant"));
	public static final RegistryObject<Item> NETHER_FORTRESS_MAP = REGISTRY.register("nether_fortress_map", () -> new ItemNetherMagicMap(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON), "nether_fortress"));
	public static final RegistryObject<Item> RUINED_PORTAL_NETHER_MAP = REGISTRY.register("ruined_portal_nether_map", () -> new ItemNetherMagicMap(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON), "ruined_portal_nether"));
	public static final RegistryObject<Item> END_CITY_MAP = REGISTRY.register("end_city_map", () -> new ItemEndMagicMap(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON), "end_city"));

	//沉降
	public static final RegistryObject<Item> SEDIMENT_MUD_BRICKS = block(JVPillageBlocks.SEDIMENT_MUD_BRICKS);
	public static final RegistryObject<Item> SEDIMENT_MUD_BRICK_STAIRS = block(JVPillageBlocks.SEDIMENT_MUD_BRICK_STAIRS);
	public static final RegistryObject<Item> SEDIMENT_MUD_BRICK_SLAB = block(JVPillageBlocks.SEDIMENT_MUD_BRICK_SLAB);
	public static final RegistryObject<Item> SEDIMENT_MUD_BRICK_WALL = block(JVPillageBlocks.SEDIMENT_MUD_BRICK_WALL);
	public static final RegistryObject<Item> SEDIMENT_MOISTURE_PROOF_PASTE = block(JVPillageBlocks.SEDIMENT_MOISTURE_PROOF_PASTE);
	public static final RegistryObject<Item> SEDIMENT_COFFIN = block(JVPillageBlocks.SEDIMENT_COFFIN);
	public static final RegistryObject<Item> SEDIMENT_URN = block(JVPillageBlocks.SEDIMENT_URN);
	//灾厄
	public static final RegistryObject<Item> ILLAGER_SIGNAL_LIGHT = REGISTRY.register("illager_signal_light", () -> new IllagerSignalLight());
	public static final RegistryObject<Item> ILLAGER_SIGNAL_LIGHT_USE = REGISTRY.register("illager_signal_light_use", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));
	public static final RegistryObject<Item> GLOW_SHINE = block(JVPillageBlocks.GLOW_SHINE);
	public static final RegistryObject<Item> OMINOUS_TORCH = REGISTRY.register("ominous_torch", () -> new OminousTorch());
	public static final RegistryObject<Item> EXPLORER_TRACKED_ROCORD = REGISTRY.register("explorer_tracked_rocord", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));
	public static final RegistryObject<Item> SECOND_ROUNDER_MAP = REGISTRY.register("second_rounder_map", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));
	public static final RegistryObject<Item> GUIDELINES_FOR_THE_CRAFT_OF_THE_SECONDER_ROUND_GEM = REGISTRY.register("guidelines_for_the_craft_of_the_second_rounder_gem", () -> new ItemDesc(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON), 1));
	public static final RegistryObject<Item> SECOND_ROUNDER_GEM = REGISTRY.register("second_rounder_gem", () -> new ItemDesc(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON), 1));
	public static final RegistryObject<Item> SECOND_ROUND_WORLD_TELEPORT_STONE = REGISTRY.register("second_round_world_teleport_stone", () -> new ItemDesc(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON), 1));
	public static final RegistryObject<Item> OMINOUS_BANNER_RAID_TAG_DEPLOYER = REGISTRY.register("ominous_banner_raid_tag_deployer", () -> new OminousBannerRaidTagDeployer());
	public static final RegistryObject<Item> GLORY_BANNER_RAID_TAG_DEPLOYER = REGISTRY.register("glory_banner_raid_tag_deployer", () -> new GloryBannerRaidTagDeployer());
	public static final RegistryObject<Item> EXPLORER_CAMP_MAP = REGISTRY.register("explorer_camp_map", () -> new ItemOverworldMagicMap(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON), "explorer_camp"));
	public static final RegistryObject<Item> ILLAGER_TOWER_MAP = REGISTRY.register("illager_tower_map", () -> new ItemOverworldMagicMap(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON), "illager_tower"));
	public static final RegistryObject<Item> EXECUTIONERS_AXE = REGISTRY.register("executioners_axe", () -> new ExecutionersAxe());
	public static final RegistryObject<Item> EXECUTIONERS_HAMMER = REGISTRY.register("executioners_hammer", () -> new ExecutionersHammer());
	public static final RegistryObject<Item> EXECUTIONERS_HALBERD = REGISTRY.register("executioners_halberd", () -> new ExecutionersHalberd());
	public static final RegistryObject<Item> OMINOUS_BOMB = REGISTRY.register("ominous_bomb", () -> new OminousBomb());
	public static final RegistryObject<Item> OMINOUS_CUTLASS = REGISTRY.register("ominous_cutlass", () -> new OminousCutlass());
	public static final RegistryObject<Item> OMINOUS_DAGGER = REGISTRY.register("ominous_dagger", () -> new OminousDagger());
	public static final RegistryObject<Item> OMINOUS_MACE = REGISTRY.register("ominous_mace", () -> new OminousMace());
	public static final RegistryObject<Item> OMINOUS_BOW = REGISTRY.register("ominous_bow", () -> new OminousBow());
	public static final RegistryObject<Item> OMINOUS_JAVELIN = REGISTRY.register("ominous_javelin", () -> new OminousJavelin());
	public static final RegistryObject<Item> BITTER_COLD_SORCERY_GLOVE = REGISTRY.register("bitter_cold_sorcery_glove", () -> new BitterColdSorceryGlove());
	public static final RegistryObject<Item> GRAVITY_COPPER_BALL = REGISTRY.register("gravity_copper_ball", () -> new GravityCopperBall());
	public static final RegistryObject<Item> SLAVERY_SUPERVISOR_HAMMER_WHIP = REGISTRY.register("slavery_supervisor_hammer_whip", () -> new SlaverySupervisorHammerWhip());
	public static final RegistryObject<Item> FIREPOWER_POURER_CHAINSAW = REGISTRY.register("firepower_pourer_chainsaw", () -> new FirepowerPourerChainsaw());
	public static final RegistryObject<Item> FIREPOWER_POURER_CROSSBOW = REGISTRY.register("firepower_pourer_crossbow", () -> new FirepowerPourerCrossbow());
	public static final RegistryObject<Item> CRAZY_AXE = REGISTRY.register("crazy_axe", () -> new CrazyAxe());
	public static final RegistryObject<Item> OMINOUS_WAR_BEAST_ARMOR = REGISTRY.register("ominous_war_beast_armor", () -> new ItemWarBeastArmor(11, 0x668785, JVPillage.MODID,"ominous", new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));
	public static final RegistryObject<Item> OMINOUS_GIANT_BEAST_ARMOR = REGISTRY.register("ominous_giant_beast_armor", () -> new ItemGiantBeastArmor(13, 0x668785, JVPillage.MODID, "ominous", new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));
	public static final RegistryObject<Item> EXPLORER_IRON_UPGRADE_SMITHING_TEMPLATE = REGISTRY.register("explorer_iron_upgrade_smithing_template", () -> new ExplorerIronUpgradeSmithingTemplate());
	public static final RegistryObject<Item> EXPLORER_IRON_HELMET = REGISTRY.register("explorer_iron_helmet", () -> new ExplorerIronArmor.Helmet());
	public static final RegistryObject<Item> EXPLORER_IRON_CHESTPLATE = REGISTRY.register("explorer_iron_chestplate", () -> new ExplorerIronArmor.Chestplate());
	public static final RegistryObject<Item> EXPLORER_IRON_LEGGINGS = REGISTRY.register("explorer_iron_leggings", () -> new ExplorerIronArmor.Leggings());
	public static final RegistryObject<Item> EXPLORER_IRON_BOOTS = REGISTRY.register("explorer_iron_boots", () -> new ExplorerIronArmor.Boots());
	public static final RegistryObject<Item> EXPLORER_UPGRADE_SMITHING_TEMPLATE = REGISTRY.register("explorer_upgrade_smithing_template", () -> new ExplorerUpgradeSmithingTemplate());
	public static final RegistryObject<Item> EXPLORER_HELMET = REGISTRY.register("explorer_helmet", () -> new ExplorerArmor.Helmet());
	public static final RegistryObject<Item> EXPLORER_CHESTPLATE = REGISTRY.register("explorer_chestplate", () -> new ExplorerArmor.Chestplate());
	public static final RegistryObject<Item> EXPLORER_LEGGINGS = REGISTRY.register("explorer_leggings", () -> new ExplorerArmor.Leggings());
	public static final RegistryObject<Item> EXPLORER_BOOTS = REGISTRY.register("explorer_boots", () -> new ExplorerArmor.Boots());
	public static final RegistryObject<Item> HORNED_HELMET = REGISTRY.register("horned_helmet", () -> new HornedArmor.Helmet());
	public static final RegistryObject<Item> WARLOCK_TIARA = REGISTRY.register("warlock_tiara", () -> new WarlockArmor.Helmet());
	public static final RegistryObject<Item> WARLOCK_CASSOCK = REGISTRY.register("warlock_cassock", () -> new WarlockArmor.Chestplate());
	public static final RegistryObject<Item> WARLOCK_FAKE_TIARA = REGISTRY.register("warlock_fake_tiara", () -> new WarlockFakeArmor.Helmet());
	public static final RegistryObject<Item> TOTEM_OF_FILTHINESS_GOD = REGISTRY.register("totem_of_filthiness_god", () -> new TotemOfFilthinessGod());
	public static final RegistryObject<Item> SLAVERY_SUPERVISOR_UPGRADE_SMITHING_TEMPLATE = REGISTRY.register("slavery_supervisor_upgrade_smithing_template", () -> new SlaverySupervisorUpgradeSmithingTemplate());
	public static final RegistryObject<Item> SLAVERY_SUPERVISOR_HELMET = REGISTRY.register("slavery_supervisor_helmet", () -> new SlaverySupervisorArmor.Helmet());
	public static final RegistryObject<Item> SLAVERY_SUPERVISOR_CHESTPLATE = REGISTRY.register("slavery_supervisor_chestplate", () -> new SlaverySupervisorArmor.Chestplate());
	public static final RegistryObject<Item> SLAVERY_SUPERVISOR_LEGGINGS = REGISTRY.register("slavery_supervisor_leggings", () -> new SlaverySupervisorArmor.Leggings());
	public static final RegistryObject<Item> SLAVERY_SUPERVISOR_BOOTS = REGISTRY.register("slavery_supervisor_boots", () -> new SlaverySupervisorArmor.Boots());
	public static final RegistryObject<Item> OMINOUS_PROBE = REGISTRY.register("ominous_probe", () -> new OminousProbe());
	public static final RegistryObject<Item> OMINOUS_BANNER_PROJECTION_EMERALD_FRAGMENT = REGISTRY.register("ominous_banner_projection_emerald_fragment", () -> new ItemBossDrop());
	public static final RegistryObject<Item> MUSIC_DISC_OMINOUS_BANNER_PROJECTION = REGISTRY.register("music_disc_ominous_banner_projection", () -> new RecordItem(1, JVPillageSoundEvents.OMINOUS_BANNER_PROJECTION_MUSIC, new Item.Properties().fireResistant().stacksTo(1).rarity(Rarity.EPIC), 363));
	public static final RegistryObject<Item> BOUND_ZOMBIE_VILLAGER_SPAWN_EGG = REGISTRY.register("bound_zombie_villager_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.BOUND_ZOMBIE_VILLAGER, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistryObject<Item> EXPLORER_SPAWN_EGG = REGISTRY.register("explorer_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.EXPLORER, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistryObject<Item> EXECUTIONER_SPAWN_EGG = REGISTRY.register("executioner_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.EXECUTIONER, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistryObject<Item> MAPMAKER_SPAWN_EGG = REGISTRY.register("mapmaker_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.MAPMAKER, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistryObject<Item> DEFECTOR_SPAWN_EGG = REGISTRY.register("defector_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.DEFECTOR, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistryObject<Item> BANNER_BEARER_SPAWN_EGG = REGISTRY.register("banner_bearer_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.BANNER_BEARER, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistryObject<Item> BLASTER_SPAWN_EGG = REGISTRY.register("blaster_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.BLASTER, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistryObject<Item> TRUMPETER_SPAWN_EGG = REGISTRY.register("trumpeter_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.TRUMPETER, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistryObject<Item> TELEPORTER_SPAWN_EGG = REGISTRY.register("teleporter_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.TELEPORTER, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistryObject<Item> CYCLONER_SPAWN_EGG = REGISTRY.register("cycloner_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.CYCLONER, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistryObject<Item> JAVELIN_THROWER_SPAWN_EGG = REGISTRY.register("javelin_thrower_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.JAVELIN_THROWER, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistryObject<Item> ZOMBIE_KEEPER_SPAWN_EGG = REGISTRY.register("zombie_keeper_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.ZOMBIE_KEEPER, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistryObject<Item> BITTER_COLD_SORCERER_SPAWN_EGG = REGISTRY.register("bitter_cold_sorcerer_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.BITTER_COLD_SORCERER, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistryObject<Item> FIRE_SPITTER_SPAWN_EGG = REGISTRY.register("fire_spitter_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.FIRE_SPITTER, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistryObject<Item> WILD_FINDER_SPAWN_EGG = REGISTRY.register("wild_finder_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.WILD_FINDER, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistryObject<Item> SUBMARINER_SPAWN_EGG = REGISTRY.register("submariner_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.SUBMARINER, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistryObject<Item> LAMP_WIZARD_SPAWN_EGG = REGISTRY.register("lamp_wizard_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.LAMP_WIZARD, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistryObject<Item> PURPLE_SAND_WITCH_SPAWN_EGG = REGISTRY.register("purple_sand_witch_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.PURPLE_SAND_WITCH, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistryObject<Item> SLAVERY_SUPERVISOR_SPAWN_EGG = REGISTRY.register("slavery_supervisor_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.SLAVERY_SUPERVISOR, 0xffffff, 0xffffff, new Item.Properties().rarity(Rarity.RARE)));
	public static final RegistryObject<Item> FIREPOWER_POURER_SPAWN_EGG = REGISTRY.register("firepower_pourer_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.FIREPOWER_POURER, 0xffffff, 0xffffff, new Item.Properties().rarity(Rarity.RARE)));
	public static final RegistryObject<Item> NECROMANCY_WARLOCK_SPAWN_EGG = REGISTRY.register("necromancy_warlock_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.NECROMANCY_WARLOCK, 0xffffff, 0xffffff, new Item.Properties().rarity(Rarity.RARE)));
	public static final RegistryObject<Item> GAVILER_SPAWN_EGG = REGISTRY.register("gaviler_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.GAVILER, 0xffffff, 0xffffff, new Item.Properties().rarity(Rarity.RARE)));
	public static final RegistryObject<Item> AX_CRAZY_SPAWN_EGG = REGISTRY.register("ax_crazy_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.AX_CRAZY, 0xffffff, 0xffffff, new Item.Properties().rarity(Rarity.RARE)));
	public static final RegistryObject<Item> OMINOUS_BANNER_PROJECTION_SPAWN_EGG = REGISTRY.register("ominous_banner_projection_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.OMINOUS_BANNER_PROJECTION, 0xffffff, 0xffffff, new Item.Properties().rarity(Rarity.EPIC)));
	//苦寒
	public static final RegistryObject<Item> SNOW_FROZEN_SOIL = block(JVPillageBlocks.SNOW_FROZEN_SOIL);
	public static final RegistryObject<Item> ICE_ROCK = block(JVPillageBlocks.ICE_ROCK);
	public static final RegistryObject<Item> GIANT_MONSTER_HELMET = REGISTRY.register("giant_monster_helmet", () -> new GiantMonsterArmor.Helmet());
	public static final RegistryObject<Item> GIANT_MONSTER_HORNED_HELMET = REGISTRY.register("giant_monster_horned_helmet", () -> new GiantMonsterArmor.HornedHelmet());
	public static final RegistryObject<Item> GIANT_MONSTER_CHESTPLATE = REGISTRY.register("giant_monster_chestplate", () -> new GiantMonsterArmor.Chestplate());
	public static final RegistryObject<Item> GIANT_MONSTER_LEGGINGS = REGISTRY.register("giant_monster_leggings", () -> new GiantMonsterArmor.Leggings());
	public static final RegistryObject<Item> GIANT_MONSTER_BOOTS = REGISTRY.register("giant_monster_boots", () -> new GiantMonsterArmor.Boots());

	public static final RegistryObject<Item> GIANT_MONSTER_HAIR = REGISTRY.register("giant_monster_hair", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));
	public static final RegistryObject<Item> GIANT_MONSTER_HORN = REGISTRY.register("giant_monster_horn", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));
	public static final RegistryObject<Item> ICE_ROCK_THROWING_BALL = REGISTRY.register("ice_rock_throwing_ball", () -> new IceRockThrowingBall());

	public static final RegistryObject<Item> GIANT_MONSTER_SPAWN_EGG = REGISTRY.register("giant_monster_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.GIANT_MONSTER, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistryObject<Item> WILDERNESS_WOLF_SPAWN_EGG = REGISTRY.register("wilderness_wolf_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.WILDERNESS_WOLF, 0xffffff, 0xffffff, new Item.Properties()));
	//紫沙
	public static final RegistryObject<Item> PURPLE_SAND = block(JVPillageBlocks.PURPLE_SAND);
	public static final RegistryObject<Item> PURPLE_SANDSTONE = block(JVPillageBlocks.PURPLE_SANDSTONE);
	public static final RegistryObject<Item> PURPLE_SANDSTONE_STAIRS = block(JVPillageBlocks.PURPLE_SANDSTONE_STAIRS);
	public static final RegistryObject<Item> PURPLE_SANDSTONE_SLAB = block(JVPillageBlocks.PURPLE_SANDSTONE_SLAB);
	public static final RegistryObject<Item> PURPLE_SANDSTONE_WALL = block(JVPillageBlocks.PURPLE_SANDSTONE_WALL);
	public static final RegistryObject<Item> CHISELED_PURPLE_SANDSTONE = block(JVPillageBlocks.CHISELED_PURPLE_SANDSTONE);
	public static final RegistryObject<Item> SMOOTH_PURPLE_SANDSTONE = block(JVPillageBlocks.SMOOTH_PURPLE_SANDSTONE);
	public static final RegistryObject<Item> SMOOTH_PURPLE_SANDSTONE_STAIRS = block(JVPillageBlocks.SMOOTH_PURPLE_SANDSTONE_STAIRS);
	public static final RegistryObject<Item> SMOOTH_PURPLE_SANDSTONE_SLAB = block(JVPillageBlocks.SMOOTH_PURPLE_SANDSTONE_SLAB);
	public static final RegistryObject<Item> CUT_PURPLE_SANDSTONE = block(JVPillageBlocks.CUT_PURPLE_SANDSTONE);
	public static final RegistryObject<Item> CUT_PURPLE_SANDSTONE_SLAB = block(JVPillageBlocks.CUT_PURPLE_SANDSTONE_SLAB);
	public static final RegistryObject<Item> ENCHANTED_STONE = block(JVPillageBlocks.ENCHANTED_STONE);
	public static final RegistryObject<Item> BLAMER_SOUL_TORCH = REGISTRY.register("blamer_soul_torch", () -> new StandingAndWallBlockItem(JVPillageBlocks.BLAMER_SOUL_TORCH.get(), JVPillageBlocks.BLAMER_SOUL_WALL_TORCH.get(), new Item.Properties().fireResistant(), Direction.DOWN));
	public static final RegistryObject<Item> BLAMER_SOUL_LANTERN = block(JVPillageBlocks.BLAMER_SOUL_LANTERN);
	public static final RegistryObject<Item> SPIRVE_HEAD = REGISTRY.register("spirve_head", () -> new StandingAndWallBlockItem(JVPillageBlocks.SPIRVE_HEAD.get(), JVPillageBlocks.SPIRVE_WALL_HEAD.get(), new Item.Properties().rarity(Rarity.UNCOMMON), Direction.DOWN));
	public static final RegistryObject<Item> HAGS_CAULDRON = fireResistanceRareBlock(JVPillageBlocks.HAGS_CAULDRON);
	public static final RegistryObject<Item> UNSTABLE_HAGS_CAULDRON = fireResistanceRareBlock(JVPillageBlocks.UNSTABLE_HAGS_CAULDRON);
	public static final RegistryObject<Item> DIRTY_HAGS_CAULDRON = fireResistanceRareBlock(JVPillageBlocks.DIRTY_HAGS_CAULDRON);
	public static final RegistryObject<Item> NEW_HAGS_CAULDRON = fireResistanceEpicBlock(JVPillageBlocks.NEW_HAGS_CAULDRON);
	public static final RegistryObject<Item> BLAMER_SOUL = REGISTRY.register("blamer_soul", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));
	public static final RegistryObject<Item> BLAMER_ROBE = REGISTRY.register("blamer_robe", () -> new BlamerRobeArmor.Chestplate());
	public static final RegistryObject<Item> PURPLE_SANDWICH = REGISTRY.register("purple_sandwich", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(JVPillageFoods.PURPLE_SANDWICH)));
	public static final RegistryObject<Item> WITCH_COVEN_MAP = REGISTRY.register("witch_coven_map", () -> new ItemOverworldMagicMap(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON), "witch_coven"));
	public static final RegistryObject<Item> WITCH_RESIDENCE_MAP = REGISTRY.register("witch_residence_map", () -> new ItemOverworldMagicMap(new Item.Properties().stacksTo(1).rarity(Rarity.RARE), "witch_residence"));
	public static final RegistryObject<Item> SPIRVE_HELMET = REGISTRY.register("spirve_helmet", () -> new SpirveArmor.Helmet());
	public static final RegistryObject<Item> SPIRVE_CHESTPLATE = REGISTRY.register("spirve_chestplate", () -> new SpirveArmor.Chestplate());
	public static final RegistryObject<Item> SPIRVE_LEGGINGS = REGISTRY.register("spirve_leggings", () -> new SpirveArmor.Leggings());
	public static final RegistryObject<Item> SPIRVE_BOOTS = REGISTRY.register("spirve_boots", () -> new SpirveArmor.Boots());
	public static final RegistryObject<Item> SPIRVE_BROOM = REGISTRY.register("spirve_broom", () -> new SpirveBroom());
	public static final RegistryObject<Item> SPIRVE_DUSTPAN = REGISTRY.register("spirve_dustpan", () -> new SpirveWeaponIronShovel());
	public static final RegistryObject<Item> SPIRVE_INSECT_NET = REGISTRY.register("spirve_insect_net", () -> new SpirveInsectNet());
	public static final RegistryObject<Item> SPIRVE_MOP = REGISTRY.register("spirve_mop", () -> new SpirveMop());
	public static final RegistryObject<Item> SPIRVE_KITCHEN_KNIFE = REGISTRY.register("spirve_kitchen_knife", () -> new SpirveKitchenKnife());
	public static final RegistryObject<Item> SPIRVE_SPATULA = REGISTRY.register("spirve_spatula", () -> new SpirveWeaponIronShovel());
	public static final RegistryObject<Item> SPIRVE_PAN = REGISTRY.register("spirve_pan", () -> new SpirveWeaponIron());
	public static final RegistryObject<Item> SPIRVE_GOURD_LADLE = REGISTRY.register("spirve_gourd_ladle", () -> new SpirveWeaponIron());
	public static final RegistryObject<Item> SPIRVE_SAW = REGISTRY.register("spirve_saw", () -> new SpirveSaw());
	public static final RegistryObject<Item> SPIRVE_FRAME_SAW = REGISTRY.register("spirve_frame_saw", () -> new SpirveSaw());
	public static final RegistryObject<Item> SPIRVE_PINCER = REGISTRY.register("spirve_pincer", () -> new SpirvePincer());
	public static final RegistryObject<Item> SPIRVE_SISSORS = REGISTRY.register("spirve_scissors", () -> new SpirveScissors());
	public static final RegistryObject<Item> SPIRVE_RAZOR = REGISTRY.register("spirve_razor", () -> new SpirveScissors());
	public static final RegistryObject<Item> SPIRVE_DUSTER = REGISTRY.register("spirve_duster", () -> new SpirveDuster());
	public static final RegistryObject<Item> SPIRVE_BROKEN_BOOTLE = REGISTRY.register("spirve_broken_bottle", () -> new SpirveBrokenBottle());
	public static final RegistryObject<Item> SPIRVE_FORK = REGISTRY.register("spirve_fork", () -> new SpirveFork());
	public static final RegistryObject<Item> SPIRVE_STUB = REGISTRY.register("spirve_stub", () -> new SpirveStub());
	public static final RegistryObject<Item> SPIRVE_CHOPPER = REGISTRY.register("spirve_chopper", () -> new SpirveWeaponIronAxe());
	public static final RegistryObject<Item> SPIRVE_MORNING_STAR = REGISTRY.register("spirve_morning_star", () -> new SpirveHammer());
	public static final RegistryObject<Item> SPIRVE_HAMMER = REGISTRY.register("spirve_hammer", () -> new SpirveHammer());
	public static final RegistryObject<Item> SPIRVE_FLAIL = REGISTRY.register("spirve_flail", () -> new SpirveFlail());
	public static final RegistryObject<Item> SPIRVE_HORSEWHIP = REGISTRY.register("spirve_horsewhip", () -> new SpirveHorseWhip());
	public static final RegistryObject<Item> SPIRVE_HOOK = REGISTRY.register("spirve_hook", () -> new SpirveWeaponIron());
	public static final RegistryObject<Item> SPIRVE_RULER = REGISTRY.register("spirve_ruler", () -> new SpirveWeaponWood());
	public static final RegistryObject<Item> SPIRVE_WOODEN_BACK_SCRATCHER = REGISTRY.register("spirve_wooden_back_scratcher", () -> new SpirveWoodenBackScratcher());
	public static final RegistryObject<Item> SPIRVE_LADLE = REGISTRY.register("spirve_ladle", () -> new SpirveWeaponIronShovel());
	public static final RegistryObject<Item> SPIRVE_FIRESTICK = REGISTRY.register("spirve_firestick", () -> new SpirveWeaponIron());
	public static final RegistryObject<Item> SPIRVE_SICKLE = REGISTRY.register("spirve_sickle", () -> new SpirveSickle());
	public static final RegistryObject<Item> SPIRVE_WRENCH = REGISTRY.register("spirve_wrench", () -> new SpirveWeaponIron());
	public static final RegistryObject<Item> SPIRVE_LID = REGISTRY.register("spirve_lid", () -> new ItemToolBaseShield(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).durability(32 * 3), 2f, 1.2f, 15, Ingredient.of(ItemTags.PLANKS)));
	public static final RegistryObject<Item> EVIL_POTION = REGISTRY.register("evil_potion", () -> new EvilPotion());
	public static final RegistryObject<Item> BIG_WITCHS_HAT = REGISTRY.register("big_witchs_hat", () -> new BigWitchArmor.Helmet());
	public static final RegistryObject<Item> HAG_EYE = REGISTRY.register("hag_eye", () -> new HagEye());
	public static final RegistryObject<Item> HAGS_BRUSH = REGISTRY.register("hags_brush", () -> new HagsBrush());
	public static final RegistryObject<Item> PURPLE_SAND_HAG_EYE = REGISTRY.register("purple_sand_hag_eye", () -> new PurpleSandHagEye());
	public static final RegistryObject<Item> PURPLE_SAND_HAG_HAIR = REGISTRY.register("purple_sand_hag_hair", () -> new ItemBossDrop());
	public static final RegistryObject<Item> MUSIC_DISC_PURPLE_SAND_HAG = REGISTRY.register("music_disc_purple_sand_hag", () -> new RecordItem(1, JVPillageSoundEvents.PURPLE_SAND_HAG_MUSIC, new Item.Properties().fireResistant().stacksTo(1).rarity(Rarity.EPIC), 258));
	public static final RegistryObject<Item> PURPLE_SAND_ALCHEMY_BOMB = REGISTRY.register("purple_sand_alchemy_bomb", () -> new PurpleSandAlchemyBomb());
	public static final RegistryObject<Item> PURPLE_SAND_EXPLOSIVE_ALCHEMY_BOMB = REGISTRY.register("purple_sand_explosive_alchemy_bomb", () -> new PurpleSandExplosiveAlchemyBomb());
	public static final RegistryObject<Item> PURPLE_SAND_RABBIT_SPAWN_EGG = REGISTRY.register("purple_sand_rabbit_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.PURPLE_SAND_RABBIT, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistryObject<Item> WITCH_SCHOLAR_SPAWN_EGG = REGISTRY.register("witch_scholar_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.WITCH_SCHOLAR, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistryObject<Item> SPIRVE_SPAWN_EGG = REGISTRY.register("spirve_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.SPIRVE, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistryObject<Item> ROTTEN_DOG_SPAWN_EGG = REGISTRY.register("rotten_dog_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.ROTTEN_DOG, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistryObject<Item> BLAMER_NECROMANCY_WARLOCK_SPAWN_EGG = REGISTRY.register("blamer_necromancy_warlock_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.BLAMER_NECROMANCY_WARLOCK, 0xffffff, 0xffffff, new Item.Properties().rarity(Rarity.RARE)));
	public static final RegistryObject<Item> FURY_BLAMER_NECROMANCY_WARLOCK_SPAWN_EGG = REGISTRY.register("fury_blamer_necromancy_warlock_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.FURY_BLAMER_NECROMANCY_WARLOCK, 0xffffff, 0xffffff, new Item.Properties().rarity(Rarity.RARE)));
	public static final RegistryObject<Item> BIG_WITCH_SPAWN_EGG = REGISTRY.register("big_witch_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.BIG_WITCH, 0xffffff, 0xffffff, new Item.Properties().rarity(Rarity.RARE)));
	public static final RegistryObject<Item> COHORT_HAG_SPAWN_EGG = REGISTRY.register("cohort_hag_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.COHORT_HAG, 0xffffff, 0xffffff, new Item.Properties().rarity(Rarity.RARE)));
	public static final RegistryObject<Item> COVEN_HAG_ONE_SPAWN_EGG = REGISTRY.register("coven_hag_one_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.COVEN_HAG_ONE, 0xffffff, 0xffffff, new Item.Properties().rarity(Rarity.RARE)));
	public static final RegistryObject<Item> COVEN_HAG_TWO_SPAWN_EGG = REGISTRY.register("coven_hag_two_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.COVEN_HAG_TWO, 0xffffff, 0xffffff, new Item.Properties().rarity(Rarity.RARE)));
	public static final RegistryObject<Item> PURPLE_SAND_HAG_SPAWN_EGG = REGISTRY.register("purple_sand_hag_spawn_egg", () -> new ForgeSpawnEggItem(JVPillageEntityType.PURPLE_SAND_HAG, 0xffffff, 0xffffff, new Item.Properties().rarity(Rarity.EPIC)));
	//海洋
	public static final RegistryObject<Item> GEMSTONE_GRAVEL = block(JVPillageBlocks.GEMSTONE_GRAVEL);
	public static final RegistryObject<Item> GLITTER_SAND = block(JVPillageBlocks.GLITTER_SAND);
	public static final RegistryObject<Item> GLITTER_SANDSTONE = block(JVPillageBlocks.GLITTER_SANDSTONE);
	public static final RegistryObject<Item> GLITTER_SANDSTONE_STAIRS = block(JVPillageBlocks.GLITTER_SANDSTONE_STAIRS);
	public static final RegistryObject<Item> GLITTER_SANDSTONE_SLAB = block(JVPillageBlocks.GLITTER_SANDSTONE_SLAB);
	public static final RegistryObject<Item> GLITTER_SANDSTONE_WALL = block(JVPillageBlocks.GLITTER_SANDSTONE_WALL);
	public static final RegistryObject<Item> CHISELED_GLITTER_SANDSTONE = block(JVPillageBlocks.CHISELED_GLITTER_SANDSTONE);
	public static final RegistryObject<Item> SMOOTH_GLITTER_SANDSTONE = block(JVPillageBlocks.SMOOTH_GLITTER_SANDSTONE);
	public static final RegistryObject<Item> SMOOTH_GLITTER_SANDSTONE_STAIRS = block(JVPillageBlocks.SMOOTH_GLITTER_SANDSTONE_STAIRS);
	public static final RegistryObject<Item> SMOOTH_GLITTER_SANDSTONE_SLAB = block(JVPillageBlocks.SMOOTH_GLITTER_SANDSTONE_SLAB);
	public static final RegistryObject<Item> CUT_GLITTER_SANDSTONE = block(JVPillageBlocks.CUT_GLITTER_SANDSTONE);
	public static final RegistryObject<Item> CUT_GLITTER_SANDSTONE_SLAB = block(JVPillageBlocks.CUT_GLITTER_SANDSTONE_SLAB);
	public static final RegistryObject<Item> OCEAN_GEMSTONE_BLOCK = block(JVPillageBlocks.OCEAN_GEMSTONE_BLOCK);
	public static final RegistryObject<Item> OCEAN_GEMSTONE = REGISTRY.register("ocean_gemstone", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));
	public static final RegistryObject<Item> OCEAN_GEMSTONE_FRAGMENTS = REGISTRY.register("ocean_gemstone_fragments", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));
	public static final RegistryObject<Item> GEMSTONE_THROWING_KNIVES = REGISTRY.register("gemstone_throwing_knives", () -> new GemstoneThrowingKnives());
	public static final RegistryObject<Item> MALIGNASAUR_TEETH = REGISTRY.register("malignasaur_teeth", () -> new ItemDesc(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON), 1));
	//明草
	public static final RegistryObject<Item> BRIGHT_COBBLESTONE = block(JVPillageBlocks.BRIGHT_COBBLESTONE);
	public static final RegistryObject<Item> BRIGHT_COBBLESTONE_STAIRS = block(JVPillageBlocks.BRIGHT_COBBLESTONE_STAIRS);
	public static final RegistryObject<Item> BRIGHT_COBBLESTONE_SLAB = block(JVPillageBlocks.BRIGHT_COBBLESTONE_SLAB);
	public static final RegistryObject<Item> BRIGHT_COBBLESTONE_WALL = block(JVPillageBlocks.BRIGHT_COBBLESTONE_WALL);
	public static final RegistryObject<Item> SECOND_ROUND_NIGRUM_CRATE = block(JVPillageBlocks.SECOND_ROUND_NIGRUM_CRATE);
	public static final RegistryObject<Item> BRIGHT_MELON_CRATE = block(JVPillageBlocks.BRIGHT_MELON_CRATE);
	public static final RegistryObject<Item> GOLDEN_BRIGHT_MELON_CRATE = rareBlock(JVPillageBlocks.GOLDEN_BRIGHT_MELON_CRATE);
	public static final RegistryObject<Item> SECOND_ROUND_NIGRUM = REGISTRY.register("second_round_nigrum", () -> new ItemNameBlockItem(JVPillageBlocks.SECOND_ROUND_NIGRUMS.get(), new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(JVPillageFoods.SECOND_ROUND_NIGRUM)));
	public static final RegistryObject<Item> COOKED_SECOND_ROUND_NIGRUM = REGISTRY.register("cooked_second_round_nigrum", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(JVPillageFoods.COOKED_SECOND_ROUND_NIGRUM)));
	public static final RegistryObject<Item> SECOND_ROUND_NIGRUM_SOUP = REGISTRY.register("second_round_nigrum_soup", () -> new BowlFoodItem(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food(JVPillageFoods.SECOND_ROUND_NIGRUM_SOUP)));
	public static final RegistryObject<Item> BRIGHT_MELON = REGISTRY.register("bright_melon", () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(JVPillageFoods.BRIGHT_MELON)));
	public static final RegistryObject<Item> BRIGHT_MELON_SEEDS = REGISTRY.register("bright_melon_seeds", () -> new ItemNameBlockItem(JVPillageBlocks.BRIGHT_MELONS.get(), new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));
	public static final RegistryObject<Item> ROTTEN_BRIGHT_MELON = REGISTRY.register("rotten_bright_melon", () -> new RottenBrightMelon());
	public static final RegistryObject<Item> GOLDEN_BRIGHT_MELON = REGISTRY.register("golden_bright_melon", () ->  new ItemDesc(new Item.Properties().stacksTo(64).rarity(Rarity.RARE).food(JVPillageFoods.GOLDEN_BRIGHT_MELON), 1));
	public static final RegistryObject<Item> BRIGHT_GOLDEN_MELON_HAMMER = REGISTRY.register("bright_golden_melon_hammer", () -> new BrightGoldenMelonHammer());
	public static final RegistryObject<Item> HERO_SOUP = REGISTRY.register("hero_soup", () -> new HeroSoup());
	public static final RegistryObject<Item> THROWING_STUBBORN_STONE = REGISTRY.register("throwing_stubborn_stone", () -> new ThrowingStubbornStone());
	public static final RegistryObject<Item> GLASS_THROWING_BALL = REGISTRY.register("glass_throwing_ball", () -> new GlassThrowingBall());
	public static final RegistryObject<Item> POTION_THROWING_BALL = REGISTRY.register("potion_throwing_ball", () -> new PotionThrowingBall());
	public static final RegistryObject<Item> ANESTHETIC_THROWING_BALL = REGISTRY.register("anesthetic_throwing_ball", () -> new AnestheticThrowingBall());
	public static final RegistryObject<Item> LEATHER_SLING = REGISTRY.register("leather_sling", () -> new LeatherSling());
	public static final RegistryObject<Item> WOODEN_SLINGSHOT = REGISTRY.register("wooden_slingshot", () -> new WoodenSlingshot());
	public static final RegistryObject<Item> BRIGHT_BOLA = REGISTRY.register("bright_bola", () -> new BrightBola());
	//旱火
	public static final RegistryObject<Item> DROUGHT_FIRE_STONE = fireResistanceBlock(JVPillageBlocks.DROUGHT_FIRE_STONE);
	public static final RegistryObject<Item> DROUGHT_FIRE_BRICKS = fireResistanceBlock(JVPillageBlocks.DROUGHT_FIRE_BRICKS);
	public static final RegistryObject<Item> DROUGHT_FIRE_BRICK_STAIRS = fireResistanceBlock(JVPillageBlocks.DROUGHT_FIRE_BRICK_STAIRS);
	public static final RegistryObject<Item> DROUGHT_FIRE_BRICK_SLAB = fireResistanceBlock(JVPillageBlocks.DROUGHT_FIRE_BRICK_SLAB);
	public static final RegistryObject<Item> DROUGHT_FIRE_BRICK_WALL = fireResistanceBlock(JVPillageBlocks.DROUGHT_FIRE_BRICK_WALL);
	public static final RegistryObject<Item> DROUGHT_FIRE_MUD = fireResistanceBlock(JVPillageBlocks.DROUGHT_FIRE_MUD);
	public static final RegistryObject<Item> FIRELIGHT_STONE = fireResistanceBlock(JVPillageBlocks.FIRELIGHT_STONE);
	//沙屿
	public static final RegistryObject<Item> SUN_SAND = block(JVPillageBlocks.SUN_SAND);
	public static final RegistryObject<Item> SUN_SANDSTONE = block(JVPillageBlocks.SUN_SANDSTONE);
	public static final RegistryObject<Item> SUN_SANDSTONE_STAIRS = block(JVPillageBlocks.SUN_SANDSTONE_STAIRS);
	public static final RegistryObject<Item> SUN_SANDSTONE_SLAB = block(JVPillageBlocks.SUN_SANDSTONE_SLAB);
	public static final RegistryObject<Item> SUN_SANDSTONE_WALL = block(JVPillageBlocks.SUN_SANDSTONE_WALL);
	public static final RegistryObject<Item> CHISELED_SUN_SANDSTONE = block(JVPillageBlocks.CHISELED_SUN_SANDSTONE);
	public static final RegistryObject<Item> SMOOTH_SUN_SANDSTONE = block(JVPillageBlocks.SMOOTH_SUN_SANDSTONE);
	public static final RegistryObject<Item> SMOOTH_SUN_SANDSTONE_STAIRS = block(JVPillageBlocks.SMOOTH_SUN_SANDSTONE_STAIRS);
	public static final RegistryObject<Item> SMOOTH_SUN_SANDSTONE_SLAB = block(JVPillageBlocks.SMOOTH_SUN_SANDSTONE_SLAB);
	public static final RegistryObject<Item> CUT_SUN_SANDSTONE = block(JVPillageBlocks.CUT_SUN_SANDSTONE);
	public static final RegistryObject<Item> CUT_SUN_SANDSTONE_SLAB = block(JVPillageBlocks.CUT_SUN_SANDSTONE_SLAB);
	//遗迹
	public static final RegistryObject<Item> INDUSTRIAL_RESIDUAL_SOIL = fireResistanceBlock(JVPillageBlocks.INDUSTRIAL_RESIDUAL_SOIL);
	public static final RegistryObject<Item> MEROR_PROJECTION_TABLE = fireResistanceEpicBlock(JVPillageBlocks.MEROR_PROJECTION_TABLE);
	//虚洞
	public static final RegistryObject<Item> VIRTUAL_CAVE_CRYSTAL_ARROW = REGISTRY.register("virtual_cave_crystal_arrow", () -> new VirtualCaveCrystalArrow());
	//发射物
	public static final RegistryObject<Item> BITTER_COLD_FROSTBITE = REGISTRY.register("bitter_cold_frostbite", () -> new Shoot());
	public static final RegistryObject<Item> OMINOUS_FLAMES = REGISTRY.register("ominous_flames", () -> new Shoot());
	public static final RegistryObject<Item> ARCANE_LIGHT_SPOT = REGISTRY.register("arcane_light_spot", () -> new Shoot());
	public static final RegistryObject<Item> RADIANT_BOMB = REGISTRY.register("radiant_bomb", () -> new Shoot());
	public static final RegistryObject<Item> SLAVERY_SUPERVISOR_CHAIN = REGISTRY.register("slavery_supervisor_chain", () -> new Shoot());
	public static final RegistryObject<Item> BLOODY_SCREAM = REGISTRY.register("bloody_scream", () -> new Shoot());
	public static final RegistryObject<Item> OMINOUS_FORCE = REGISTRY.register("ominous_force", () -> new Shoot());
	public static final RegistryObject<Item> ABUNDANT_COURAGE = REGISTRY.register("abundant_courage", () -> new Shoot());

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
	private static RegistryObject<Item> fireResistanceBlock(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().fireResistant()));
	}
	private static RegistryObject<Item> fireResistanceRareBlock(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().fireResistant().rarity(Rarity.RARE)));
	}
	private static RegistryObject<Item> uncommonBlock(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
	}
	private static RegistryObject<Item> rareBlock(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().fireResistant().rarity(Rarity.RARE)));
	}
	private static RegistryObject<Item> fireResistanceEpicBlock(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
	}
	private static RegistryObject<Item> highBlock(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties()));
	}

	public static void setup() {
		//作物
		ComposterBlock.COMPOSTABLES.put(JVPillageItems.SECOND_ROUND_NIGRUM.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(JVPillageItems.COOKED_SECOND_ROUND_NIGRUM.get().asItem(), 0.85F);
		ComposterBlock.COMPOSTABLES.put(JVPillageItems.BRIGHT_MELON.get().asItem(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(JVPillageItems.GOLDEN_BRIGHT_MELON.get().asItem(), 1.0F);
		ComposterBlock.COMPOSTABLES.put(JVPillageItems.BRIGHT_MELON_SEEDS.get().asItem(), 0.30F);
		ComposterBlock.COMPOSTABLES.put(JVPillageItems.ROTTEN_BRIGHT_MELON.get().asItem(), 1.0F);

		//虚洞水晶箭
		DispenserBlock.registerBehavior(JVPillageItems.VIRTUAL_CAVE_CRYSTAL_ARROW.get(), new AbstractProjectileDispenseBehavior(){
			@Override
			protected Projectile getProjectile(Level level, Position position, ItemStack itemStack) {
				VirtualCaveCrystalArrowEntity arrow = new VirtualCaveCrystalArrowEntity(level, position.x(), position.y(), position.z(), itemStack.copyWithCount(1));
				arrow.pickup = AbstractArrow.Pickup.ALLOWED;
				return arrow;
			}
		});
		//灾厄炸弹
		DispenserBlock.registerBehavior(JVPillageItems.OMINOUS_BOMB.get(), new AbstractProjectileDispenseBehavior(){
			@Override
			protected Projectile getProjectile(Level level, Position position, ItemStack itemStack) {
				return Util.make(new OminousBombEntity(level, position.x(), position.y(), position.z()), thrown -> thrown.setItem(itemStack));
			}
		});
		//紫沙炼金炸弹
		DispenserBlock.registerBehavior(JVPillageItems.PURPLE_SAND_ALCHEMY_BOMB.get(), new AbstractProjectileDispenseBehavior(){
			@Override
			protected Projectile getProjectile(Level level, Position position, ItemStack itemStack) {
				return Util.make(new PurpleSandAlchemyBombEntity(level, position.x(), position.y(), position.z()), thrown -> thrown.setItem(itemStack));
			}
		});
		//易爆形紫沙炼金炸弹
		DispenserBlock.registerBehavior(JVPillageItems.PURPLE_SAND_EXPLOSIVE_ALCHEMY_BOMB.get(), new AbstractProjectileDispenseBehavior(){
			@Override
			protected Projectile getProjectile(Level level, Position position, ItemStack itemStack) {
				return Util.make(new PurpleSandExplosiveAlchemyBombEntity(level, position.x(), position.y(), position.z()), thrown -> thrown.setItem(itemStack));
			}
		});
		//投掷顽石
		DispenserBlock.registerBehavior(JVPillageItems.THROWING_STUBBORN_STONE.get(), new AbstractProjectileDispenseBehavior(){
			@Override
			protected Projectile getProjectile(Level level, Position position, ItemStack itemStack) {
				return Util.make(new ThrowingStubbornStoneEntity(level, position.x(), position.y(), position.z()), thrown -> thrown.setItem(itemStack));
			}
		});

		//玻璃投团
		DispenserBlock.registerBehavior(JVPillageItems.GLASS_THROWING_BALL.get(), new AbstractProjectileDispenseBehavior(){
			@Override
			protected Projectile getProjectile(Level level, Position position, ItemStack itemStack) {
				return Util.make(new GlassThrowingBallEntity(level, position.x(), position.y(), position.z()), thrown -> thrown.setItem(itemStack));
			}
		});
		//药水投团
		DispenserBlock.registerBehavior(JVPillageItems.POTION_THROWING_BALL.get(), new AbstractProjectileDispenseBehavior(){
			@Override
			protected Projectile getProjectile(Level level, Position position, ItemStack itemStack) {
				return Util.make(new PotionThrowingBallEntity(level, position.x(), position.y(), position.z()), thrown -> thrown.setItem(itemStack));
			}
		});
		//烂明路脆瓜
		DispenserBlock.registerBehavior(JVPillageItems.ROTTEN_BRIGHT_MELON.get(), new AbstractProjectileDispenseBehavior(){
			@Override
			protected Projectile getProjectile(Level level, Position position, ItemStack itemStack) {
				return Util.make(new RottenBrightMelonEntity(level, position.x(), position.y(), position.z()), thrown -> thrown.setItem(itemStack));
			}
		});
		//冰岩投团
		DispenserBlock.registerBehavior(JVPillageItems.ICE_ROCK_THROWING_BALL.get(), new AbstractProjectileDispenseBehavior(){
			@Override
			protected Projectile getProjectile(Level level, Position position, ItemStack itemStack) {
				return Util.make(new IceRockThrowingBallEntity(level, position.x(), position.y(), position.z()), thrown -> thrown.setItem(itemStack));
			}
		});
		//麻醉投团
		DispenserBlock.registerBehavior(JVPillageItems.ANESTHETIC_THROWING_BALL.get(), new AbstractProjectileDispenseBehavior(){
			@Override
			protected Projectile getProjectile(Level level, Position position, ItemStack itemStack) {
				return Util.make(new AnestheticThrowingBallEntity(level, position.x(), position.y(), position.z()), thrown -> thrown.setItem(itemStack));
			}
		});
		//肮脏的鬼婆之锅
		DispenserBlock.registerBehavior(JVPillageItems.HAGS_BRUSH.get(), new OptionalDispenseItemBehavior(){
			@Override
			public ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
				Direction direction = JerotesItemsAdd.getBlockState(blockSource).getValue(DispenserBlock.FACING);
				BlockPos blockPos = JerotesItemsAdd.getPos(blockSource).relative(direction);
				ServerLevel serverLevel = JerotesItemsAdd.getLevel(blockSource);
				BlockState blockState = serverLevel.getBlockState(blockPos);
				this.setSuccess(true);
				if (blockState.is(JVPillageBlocks.DIRTY_HAGS_CAULDRON.get())) {
					serverLevel.setBlock(blockPos, JVPillageBlocks.NEW_HAGS_CAULDRON.get().defaultBlockState(), 2);
					serverLevel.playSound(null, blockPos, SoundEvents.BRUSH_GENERIC, SoundSource.NEUTRAL, 1.0f, 1.0f / (serverLevel.getRandom().nextFloat() * 0.4f + 1.2f) + 1 * 0.5f);
					return itemStack;
				}
				return super.execute(blockSource, itemStack);
			}
		});
		//战兽铠
		OptionalDispenseItemBehavior optionalDispenseItemBehaviorHorseArmor = new OptionalDispenseItemBehavior(){
			@Override
			protected ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
				BlockPos blockPos = JerotesItemsAdd.getPos(blockSource).relative(JerotesItemsAdd.getBlockState(blockSource).getValue(DispenserBlock.FACING));
				List<AbstractHorse> listHorse = JerotesItemsAdd.getLevel(blockSource).getEntitiesOfClass(AbstractHorse.class, new AABB(blockPos), abstractHorse -> abstractHorse.isAlive() && abstractHorse.canWearArmor());
				for (AbstractHorse abstractHorse2 : listHorse) {
					if (!abstractHorse2.isArmor(itemStack) || abstractHorse2.isWearingArmor() || !abstractHorse2.isTamed()) continue;
					abstractHorse2.getSlot(401).set(itemStack.split(1));
					this.setSuccess(true);
					return itemStack;
				}
				List<Mob> list = JerotesItemsAdd.getLevel(blockSource).getEntitiesOfClass(Mob.class, new AABB(blockPos), abstractHorse -> abstractHorse.isAlive());
				for (Mob abstractHorse : list) {
					if (!(abstractHorse instanceof ArmorEntity abstractHorse2)) continue;
					if (!abstractHorse2.isWarBeastArmor() || !abstractHorse2.canWearArmor() || !abstractHorse2.isArmor(itemStack) || abstractHorse2.isWearingArmor() || (abstractHorse2 instanceof OwnableEntity ownable && ownable.getOwner() == null)) continue;
					Mob mob = (Mob) abstractHorse2;
					mob.getSlot(abstractHorse2.getAddNumber() + 1).set(itemStack.split(1));
					this.setSuccess(true);
					return itemStack;
				}
				return super.execute(blockSource, itemStack);
			}
		};
		DispenserBlock.registerBehavior(JVPillageItems.OMINOUS_WAR_BEAST_ARMOR.get(), optionalDispenseItemBehaviorHorseArmor);
		//巨兽铠
		OptionalDispenseItemBehavior optionalDispenseItemBehaviorGiantBeastArmor = new OptionalDispenseItemBehavior(){
			@Override
			protected ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
				BlockPos blockPos = JerotesItemsAdd.getPos(blockSource).relative(JerotesItemsAdd.getBlockState(blockSource).getValue(DispenserBlock.FACING));
				List<Mob> list = JerotesItemsAdd.getLevel(blockSource).getEntitiesOfClass(Mob.class, new AABB(blockPos), abstractHorse -> abstractHorse.isAlive());
				for (Mob abstractHorse : list) {
					if (!(abstractHorse instanceof ArmorEntity abstractHorse2)) continue;
					if (!abstractHorse2.isGiantBeastArmor() || !abstractHorse2.canWearArmor() || !abstractHorse2.isArmor(itemStack) || abstractHorse2.isWearingArmor() || (abstractHorse2 instanceof OwnableEntity ownable && ownable.getOwner() == null)) continue;
					Mob mob = (Mob) abstractHorse2;
					mob.getSlot(abstractHorse2.getAddNumber() + 1).set(itemStack.split(1));
					this.setSuccess(true);
					return itemStack;
				}
				return super.execute(blockSource, itemStack);
			}
		};
		DispenserBlock.registerBehavior(JVPillageItems.OMINOUS_GIANT_BEAST_ARMOR.get(), optionalDispenseItemBehaviorGiantBeastArmor);
		//头颅
		OptionalDispenseItemBehavior optionalDispenseItemBehaviorHead = new OptionalDispenseItemBehavior(){

			@Override
			protected ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
				this.setSuccess(ArmorItem.dispenseArmor(blockSource, itemStack));
				return itemStack;
			}
		};
		DispenserBlock.registerBehavior(JVPillageItems.SPIRVE_HEAD.get(), optionalDispenseItemBehaviorHead);
		//boss掉落物
		OptionalDispenseItemBehavior optionalDispenseItemBehaviorBossDrop = new OptionalDispenseItemBehavior(){
			@Override
			public ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
				Direction direction = JerotesItemsAdd.getBlockState(blockSource).getValue(DispenserBlock.FACING);
				BlockPos blockPos = JerotesItemsAdd.getPos(blockSource).relative(direction);
				ServerLevel serverLevel = JerotesItemsAdd.getLevel(blockSource);
				BlockState blockState = serverLevel.getBlockState(blockPos);
				this.setSuccess(true);
				if (blockState.is(JVPillageBlocks.MEROR_PROJECTION_TABLE.get())) {
					MerorProjectionTable.change(serverLevel, blockState, blockPos, null, itemStack);
					return itemStack;
				}
				return super.execute(blockSource, itemStack);
			}
		};
		DispenserBlock.registerBehavior(JVPillageItems.MEROR_PROJECTION_TABLE.get(), optionalDispenseItemBehaviorBossDrop);
		DispenserBlock.registerBehavior(JVPillageItems.PURPLE_SAND_HAG_HAIR.get(), optionalDispenseItemBehaviorBossDrop);
		DispenserBlock.registerBehavior(JVPillageItems.OMINOUS_BANNER_PROJECTION_EMERALD_FRAGMENT.get(), optionalDispenseItemBehaviorBossDrop);
	}



	public static class SpawnMobDispenseItemBehavior extends DefaultDispenseItemBehavior {
	   private final EntityType type;

	   public SpawnMobDispenseItemBehavior(EntityType type) {
		  this.type = type;
	   }

	}
}
