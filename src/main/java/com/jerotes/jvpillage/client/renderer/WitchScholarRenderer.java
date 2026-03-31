package com.jerotes.jvpillage.client.renderer;

import com.jerotes.jvpillage.JVPillage;
import com.jerotes.jvpillage.config.OtherMainConfig;
import com.jerotes.jvpillage.entity.Monster.WitchScholarEntity;
import com.jerotes.jvpillage.event.WeatherEvent;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.WitchModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.WitchItemLayer;
import net.minecraft.resources.ResourceLocation;

public class WitchScholarRenderer extends MobRenderer<WitchScholarEntity, WitchModel<WitchScholarEntity>> {
    private static final ResourceLocation LOCATION = new ResourceLocation(JVPillage.MODID, "textures/entity/witch_scholar.png");
    public WitchScholarRenderer(EntityRendererProvider.Context context) {
        super(context, new WitchModel(context.bakeLayer(ModelLayers.WITCH)), 0.5f);
        this.addLayer(new WitchItemLayer<WitchScholarEntity>(this, context.getItemInHandRenderer()));
    }

    @Override
    public void render(WitchScholarEntity witch, float f, float f2, PoseStack poseStack, MultiBufferSource multiBufferSource, int n) {
        ((WitchModel)this.model).setHoldingItem(!witch.getMainHandItem().isEmpty());
        super.render(witch, f, f2, poseStack, multiBufferSource, n);
    }

    @Override
    protected void scale(WitchScholarEntity entity, PoseStack poseStack, float f) {
        poseStack.scale(0.9375f, 0.9375f, 0.9375f);
        super.scale(entity, poseStack, f);
    }

    @Override
    public ResourceLocation getTextureLocation(WitchScholarEntity entity) {
        if (WeatherEvent.isAprilFoolsDay() && OtherMainConfig.SpecialDay) {
            return new ResourceLocation(JVPillage.MODID, "textures/entity/ax_crazy_fake_3.png");
        }
        return LOCATION;
    }
}
