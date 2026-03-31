package com.jerotes.jvpillage.event;

import com.google.common.collect.Sets;
import com.jerotes.jvpillage.JVPillage;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

import java.util.Set;

public final class ModBlockLayer {
    public static ResourceLocation location(String path) {
        return new ResourceLocation(JVPillage.MODID, path);
    }
    private static final Set<ModelLayerLocation> ALL_MODELS = Sets.newHashSet();
    public static final ModelLayerLocation ABASE_SKULL_BLOCK = register("abase_skull_block");

    private static ModelLayerLocation register(String string) {
        return register(string, "main");
    }

    private static ModelLayerLocation register(String string, String string2) {
        ModelLayerLocation modellayerlocation = createLocation(string, string2);
        if (!ALL_MODELS.add(modellayerlocation)) {
            throw new IllegalStateException("Duplicate registration for " + modellayerlocation);
        } else {
            return modellayerlocation;
        }
    }
    private static ModelLayerLocation createLocation(String string, String string2) {
        return new ModelLayerLocation(location(string), string2);
    }

}
