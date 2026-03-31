package com.jerotes.jvpillage.client.renderer;

import com.jerotes.jvpillage.JVPillage;
import com.jerotes.jvpillage.client.model.Modelominous_gear;
import com.jerotes.jvpillage.entity.Other.OminousGearEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

public class OminousGearRenderer extends EntityRenderer<OminousGearEntity> {
    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(JVPillage.MODID, "textures/entity/ominous_gear.png");
    private final Modelominous_gear<OminousGearEntity> model;

    public OminousGearRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new Modelominous_gear(context.bakeLayer(Modelominous_gear.LAYER_LOCATION));
    }

    @Override
    protected int getBlockLightLevel(OminousGearEntity entity, BlockPos blockPos) {
        return 15;
    }

    @Override
    public void render(OminousGearEntity entity, float f, float f2, PoseStack poseStack, MultiBufferSource multiBufferSource, int n) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(90.0f - entity.getYRot()));
        poseStack.scale(-2, -2, 2);
        poseStack.translate(0.0, -1.4f, 0.0);
        this.model.setupAnim(entity, 0.0f, 0.0f, entity.tickCount + f, entity.getYRot(), entity.getXRot());
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(this.model.renderType(TEXTURE_LOCATION));
        this.model.renderToBuffer(poseStack, vertexConsumer, n, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);
        poseStack.popPose();
        super.render(entity, f, f2, poseStack, multiBufferSource, n);
    }

    @Override
    public ResourceLocation getTextureLocation(OminousGearEntity entity) {
        return TEXTURE_LOCATION;
    }
}

