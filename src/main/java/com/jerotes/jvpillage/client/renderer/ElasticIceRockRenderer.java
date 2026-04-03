package com.jerotes.jvpillage.client.renderer;

import com.jerotes.jvpillage.JVPillage;
import com.jerotes.jvpillage.client.model.Modelrolling_block;
import com.jerotes.jvpillage.entity.Shoot.Magic.MagicThrow.ElasticIceRockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class ElasticIceRockRenderer extends EntityRenderer<ElasticIceRockEntity> {
	private final Modelrolling_block model;
	private static final ResourceLocation LOCATION = new ResourceLocation(JVPillage.MODID, "textures/entity/elastic_ice_rock.png");

	public ElasticIceRockRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelrolling_block(context.bakeLayer(Modelrolling_block.LAYER_LOCATION));
	}

	@Override
	public void render(ElasticIceRockEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		if (entityIn.getDeltaMovement().lengthSqr() > 0) {
			double velocity = entityIn.getDeltaMovement().length(); // 运动速度
			// 旋转角度与速度成正比，速度越大角度增量越快
			float spinAngle = (entityIn.tickCount + partialTicks) * 10.0f * (float) velocity;
			poseStack.mulPose(Axis.YP.rotationDegrees(spinAngle));
		}
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(ElasticIceRockEntity entity) {
		return LOCATION;
	}
}
