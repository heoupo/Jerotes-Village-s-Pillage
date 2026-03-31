package com.jerotes.jvpillage.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber
public interface JVPillageDamageTypeTags {
	private static TagKey<DamageType> create(String string) {
		return TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(string));
	}
}
