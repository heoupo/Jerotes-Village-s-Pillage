package com.jerotes.jerotesvillage.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;


public class JerotesVillageStructures {
    public static final ResourceKey<Structure> WITCH_RESIDENCE = JerotesVillageStructures.createKey("witch_residence");

    private static ResourceKey<Structure> createKey(String string) {
        return ResourceKey.create(Registries.STRUCTURE, new ResourceLocation(string));
    }
}
