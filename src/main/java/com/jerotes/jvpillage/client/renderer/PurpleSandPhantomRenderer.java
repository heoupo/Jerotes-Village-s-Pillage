package com.jerotes.jvpillage.client.renderer;

import com.jerotes.jvpillage.JVPillage;
import com.jerotes.jvpillage.client.layer.PurpleSandHagSkinLayer;
import com.jerotes.jvpillage.client.layer.PurpleSandPhantomPowerLayer;
import com.jerotes.jvpillage.client.model.Modelhag;
import com.jerotes.jvpillage.entity.Other.PurpleSandPhantomEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PurpleSandPhantomRenderer extends HumanoidMobRenderer<PurpleSandPhantomEntity, Modelhag<PurpleSandPhantomEntity>> {
    private static final ResourceLocation LOCATION = new ResourceLocation(JVPillage.MODID, "textures/entity/hag.png");
    public PurpleSandPhantomRenderer(EntityRendererProvider.Context context) {
        super(context, new Modelhag(context.bakeLayer(Modelhag.LAYER_LOCATION)), 0f);
        this.addLayer(new PurpleSandHagSkinLayer<>(this, new Modelhag(context.bakeLayer(Modelhag.LAYER_LOCATION))));
        this.addLayer(new PurpleSandPhantomPowerLayer(this, new Modelhag(context.bakeLayer(Modelhag.LAYER_LOCATION))));
    }

    @Override
    protected float getFlipDegrees(PurpleSandPhantomEntity entity) {
        return 0.0f;
    }

    @Override
    public ResourceLocation getTextureLocation(PurpleSandPhantomEntity entity) {
        return LOCATION;
    }

}