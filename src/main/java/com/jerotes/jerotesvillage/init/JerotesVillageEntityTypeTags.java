package com.jerotes.jerotesvillage.init;

import com.jerotes.jerotesvillage.JerotesVillage;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class JerotesVillageEntityTypeTags {
    public static final TagKey<EntityType<?>> BAN_OMINOUS_SELECTION = create("ban_ominous_selection");

    private JerotesVillageEntityTypeTags() {
    }

    private static TagKey<EntityType<?>> create(String string) {
        return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(JerotesVillage.MODID,string));
    }
}
