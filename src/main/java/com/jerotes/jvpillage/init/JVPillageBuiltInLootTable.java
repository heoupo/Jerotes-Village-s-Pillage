package com.jerotes.jvpillage.init;

import com.google.common.collect.Sets;
import com.jerotes.jvpillage.JVPillage;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.Set;

public class JVPillageBuiltInLootTable {
	private static final Set<ResourceLocation> LOCATIONS = Sets.newHashSet();
	private static final Set<ResourceLocation> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);
	public static final ResourceLocation EMPTY = new ResourceLocation("empty");

	private static ResourceLocation register(String string) {
		return register(new ResourceLocation(JVPillage.MODID, string));
	}

	private static ResourceLocation register(ResourceLocation p_78770_) {
		if (LOCATIONS.add(p_78770_)) {
			return p_78770_;
		} else {
			throw new IllegalArgumentException(p_78770_ + " is already a registered built-in loot table");
		}
	}

	public static Set<ResourceLocation> all() {
		return IMMUTABLE_LOCATIONS;
	}
}