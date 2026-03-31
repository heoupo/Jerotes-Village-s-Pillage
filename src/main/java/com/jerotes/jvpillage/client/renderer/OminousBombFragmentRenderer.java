package com.jerotes.jvpillage.client.renderer;

import com.jerotes.jvpillage.JVPillage;
import com.jerotes.jvpillage.entity.Shoot.Arrow.OminousBombFragmentEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class OminousBombFragmentRenderer extends ArrowRenderer<OminousBombFragmentEntity> {
    public static final ResourceLocation ARROW_LOCATION = new ResourceLocation(JVPillage.MODID, "textures/entity/ominous_bomb_fragment.png");

    public OminousBombFragmentRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(OminousBombFragmentEntity arrow) {
        return ARROW_LOCATION;
    }
}

