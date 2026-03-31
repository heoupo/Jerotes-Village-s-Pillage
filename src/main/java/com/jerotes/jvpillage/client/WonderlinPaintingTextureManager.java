/*
 * Decompiled with CFR 0.146.
 * 
 * Could not load the following classes:
 *  org.joml.Matrix3f
 *  org.joml.Matrix4f
 *  org.joml.Quaternionf
 */
package com.jerotes.jvpillage.client;

import com.jerotes.jvpillage.JVPillage;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.PaintingTextureManager;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;

public class WonderlinPaintingTextureManager extends PaintingTextureManager {
    private static final ResourceLocation BACK_SPRITE_LOCATION = new ResourceLocation(JVPillage.MODID, "back");
    public WonderlinPaintingTextureManager(TextureManager textureManager) {
        super(textureManager);
    }
    public TextureAtlasSprite get(PaintingVariant paintingVariant) {
        return this.getSprite(BuiltInRegistries.PAINTING_VARIANT.getKey(paintingVariant));
    }

    public TextureAtlasSprite getBackSprite() {
        return this.getSprite(BACK_SPRITE_LOCATION);
    }
}

