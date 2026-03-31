package com.jerotes.jvpillage.util;

import com.jerotes.jerotes.util.EntityFactionFind;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;

public class OtherEntityFactionFind {
	//是否铜刻类型生物
	public static boolean isCarved(EntityType type) {
		return type.is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jerotes:carved")));
	}
	//是否鬼婆
	public static boolean isHag(EntityType type) {
		return type.is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jerotes:hag")));
	}
	//是否奇灵
	public static boolean isWonderlin(EntityType type) {
		return type.is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jerotes:wonderlin")));
	}
	//是否莫厄机械
	public static boolean isMerorMachine(EntityType type) {
		return type.is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jerotes:meror_machine")));
	}
	//是否泽林
	public static boolean isZsiein(EntityType type) {
		return type.is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jerotes:zsiein")));
	}

	//铜刻佣兵团 Copper Carved Company
	public static boolean isFactionCopperCarvedCompany(LivingEntity livingEntity) {
		return EntityFactionFind.getTrueFaction(livingEntity).equals("copper_carved_company");
	}
	//紫沙姐妹会 Purple Sand Sisterhood
	public static boolean isFactionPurpleSandSisterhood(LivingEntity livingEntity) {
		return EntityFactionFind.getTrueFaction(livingEntity).equals("purple_sand_sisterhood");
	}
	//灾厄村民旗帜投影部队 Ominous Banner Raid Force
	public static boolean isFactionOminousBannerRaidForce(LivingEntity livingEntity) {
		return EntityFactionFind.getTrueFaction(livingEntity).equals("ominous_banner_raid_force");
	}
	//猪灵驻团 Piglin Resident Detachment
	public static boolean isFactionPiglinResidentDetachment(LivingEntity livingEntity) {
		return EntityFactionFind.getTrueFaction(livingEntity).equals("piglin_resident_detachment");
	}
}