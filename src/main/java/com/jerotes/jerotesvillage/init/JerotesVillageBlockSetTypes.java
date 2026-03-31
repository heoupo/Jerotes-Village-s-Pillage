package com.jerotes.jerotesvillage.init;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class JerotesVillageBlockSetTypes {
	//1.20.4↑//
	//public static final BlockSetType VILLAGER_METAL = BlockSetType.register(new BlockSetType("villager_metal", true, false, false, BlockSetType.PressurePlateSensitivity.MOBS, SoundType.METAL, SoundEvents.IRON_DOOR_CLOSE, SoundEvents.IRON_DOOR_OPEN, SoundEvents.IRON_TRAPDOOR_CLOSE, SoundEvents.IRON_TRAPDOOR_OPEN, SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF, SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON));
	//1.20.1//
	public static final BlockSetType VILLAGER_METAL = BlockSetType.register(new BlockSetType("villager_metal", true, SoundType.METAL, SoundEvents.IRON_DOOR_CLOSE, SoundEvents.IRON_DOOR_OPEN, SoundEvents.IRON_TRAPDOOR_CLOSE, SoundEvents.IRON_TRAPDOOR_OPEN, SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF, SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON));
	public static final BlockSetType BITTER_COLD = BlockSetType.register(new BlockSetType("bitter_cold"));
	public static final BlockSetType BLACK_YELLOW = BlockSetType.register(new BlockSetType("black_yellow"));
	public static final BlockSetType SEDIMENT = BlockSetType.register(new BlockSetType("sediment"));
	public static void init() {
	}
}
