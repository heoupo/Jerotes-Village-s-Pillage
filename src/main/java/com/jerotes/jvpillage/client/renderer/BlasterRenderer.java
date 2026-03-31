package com.jerotes.jvpillage.client.renderer;

import com.jerotes.jvpillage.JVPillage;
import com.jerotes.jvpillage.client.model.Modelblaster;
import com.jerotes.jvpillage.config.OtherMainConfig;
import com.jerotes.jvpillage.entity.Monster.IllagerFaction.BlasterEntity;
import com.jerotes.jvpillage.event.WeatherEvent;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.ZombieVillagerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

public class BlasterRenderer extends HumanoidMobRenderer<BlasterEntity, Modelblaster<BlasterEntity>> {
    private static final ResourceLocation LOCATION = new ResourceLocation(JVPillage.MODID, "textures/entity/blaster.png");
    public BlasterRenderer(EntityRendererProvider.Context context) {
        super(context, new Modelblaster(context.bakeLayer(Modelblaster.LAYER_LOCATION)), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new ZombieVillagerModel(context.bakeLayer(ModelLayers.ZOMBIE_VILLAGER_INNER_ARMOR)), new ZombieVillagerModel(context.bakeLayer(ModelLayers.ZOMBIE_VILLAGER_OUTER_ARMOR)), context.getModelManager()));
        this.model.getHat().visible = true;
    }

    @Override
    protected void scale(BlasterEntity entity, PoseStack poseStack, float f) {
        poseStack.scale(0.9375F, 0.9375F, 0.9375F);
        super.scale(entity, poseStack, f);
    }

    @Override
    public ResourceLocation getTextureLocation(BlasterEntity entity) {
        if (WeatherEvent.isAprilFoolsDay() && OtherMainConfig.SpecialDay) {
            return new ResourceLocation(JVPillage.MODID, "textures/entity/ax_crazy_fake.png");
        }
        return LOCATION;
    }
}
