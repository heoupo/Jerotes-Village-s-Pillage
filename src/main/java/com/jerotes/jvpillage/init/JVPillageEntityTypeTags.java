package com.jerotes.jvpillage.init;

import com.jerotes.jvpillage.JVPillage;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class JVPillageEntityTypeTags {
    public static final TagKey<EntityType<?>> BAN_OMINOUS_SELECTION = create("ban_ominous_selection");

    private JVPillageEntityTypeTags() {
    }

    private static TagKey<EntityType<?>> create(String string) {
        return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(JVPillage.MODID,string));
    }
}
