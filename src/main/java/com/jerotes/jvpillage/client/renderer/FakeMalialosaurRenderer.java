package com.jerotes.jvpillage.client.renderer;

import com.jerotes.jerotes.client.layer.TameLayer;
import com.jerotes.jvpillage.JVPillage;
import com.jerotes.jvpillage.client.model.Modelfake_malialosaur;
import com.jerotes.jvpillage.entity.Animal.FakeMalialosaurEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SaddleLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class FakeMalialosaurRenderer extends MobRenderer<FakeMalialosaurEntity, Modelfake_malialosaur<FakeMalialosaurEntity>> {
	private static final ResourceLocation LOCATION = new ResourceLocation(JVPillage.MODID, "textures/entity/fake_malialosaur.png");
	private static final ResourceLocation TAME_LOCATION = new ResourceLocation(JVPillage.MODID, "textures/entity/fake_malialosaur_tame.png");
	private static final ResourceLocation SADDLE_LOCATION = new ResourceLocation(JVPillage.MODID, "textures/entity/fake_malialosaur_saddle.png");
	public FakeMalialosaurRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfake_malialosaur(context.bakeLayer(Modelfake_malialosaur.LAYER_LOCATION)), 1.3f);
		this.addLayer(new TameLayer(this, new Modelfake_malialosaur(context.bakeLayer(Modelfake_malialosaur.LAYER_LOCATION)), TAME_LOCATION));
		this.addLayer(new SaddleLayer(this, new Modelfake_malialosaur(context.bakeLayer(Modelfake_malialosaur.LAYER_LOCATION)), SADDLE_LOCATION));
	}

	@Override
	public void render(FakeMalialosaurEntity t, float f, float f2, PoseStack poseStack, MultiBufferSource multiBufferSource, int n) {
		t.thisTickRenderTime += 1;
		float waterAnim = t.getWaterAnim();
		float fs = t.lastTickRenderTime + 1;
		float smoothFactor = 1f / fs;
		t.waterAnimProgress = Mth.lerp(smoothFactor, t.waterAnimProgress, waterAnim);
		super.render(t, f, f2, poseStack, multiBufferSource, n);
	}
	
	@Override
	protected void scale(FakeMalialosaurEntity t, PoseStack poseStack, float f) {
		if (t.getChangeTick() > 0) {
			float xMax = 1.5f;
			float yMax = 1.5f;
			float zMax = 1.5f;
			float xMin = 0.25f;
			float yMin = 0.25f;
			float zMin = 0.25f;
			int maxTick = 20;
			int tickX = t.tickCount % maxTick;
			int tickY = (t.tickCount + (maxTick / 4)) % maxTick;
			int tickZ = (t.tickCount + (maxTick / 8)) % maxTick;
			float x;
			float y;
			float z;

			if (tickX > maxTick / 2f) {
				x = xMin + tickX * ((xMax - xMin) / (maxTick));
			} else {
				x = xMax - tickX * ((xMax - xMin) / (maxTick));
			}
			if (tickY > maxTick / 2f) {
				y = yMin + tickY * ((yMax - yMin) / (maxTick));
			} else {
				y = yMax - tickY * ((yMax - yMin) / (maxTick));
			}
			if (tickZ > maxTick / 2f) {
				z = zMin + tickZ * ((zMax - zMin) / (maxTick));
			} else {
				z = zMax - tickZ * ((zMax - zMin) / (maxTick));
			}
			poseStack.scale(x, y, z);
		}
		super.scale(t, poseStack, f);
	}

	protected float getWhiteOverlayProgress(FakeMalialosaurEntity t, float f) {
		if (t.getChangeTick() > 0) {
			float xMax = 1f;
			float yMax = 1f;
			float zMax = 1f;
			float xMin = 0f;
			float yMin = 0f;
			float zMin = 0f;
			int maxTick = 10;
			int tickX = t.tickCount % maxTick;
			int tickY = (t.tickCount + (maxTick/4)) % maxTick;
			int tickZ = (t.tickCount + (maxTick/8)) % maxTick;
			float x;
			float y;
			float z;

			if (tickX > maxTick / 2f) {
				x = xMin + tickX * ((xMax - xMin) / (maxTick));
			} else {
				x = xMax - tickX * ((xMax - xMin) / (maxTick));
			}
			if (tickY > maxTick / 2f) {
				y = yMin + tickY * ((yMax - yMin) / (maxTick));
			} else {
				y = yMax - tickY * ((yMax - yMin) / (maxTick));
			}
			if (tickZ > maxTick / 2f) {
				z = zMin + tickZ * ((zMax - zMin) / (maxTick));
			} else {
				z = zMax - tickZ * ((zMax - zMin) / (maxTick));
			}
			return Mth.clamp(x, y, z);
		}
		return super.getWhiteOverlayProgress(t, f);
	}
	@Override
	public ResourceLocation getTextureLocation(FakeMalialosaurEntity entity) {
		return LOCATION;
	}

	@Override
	protected void setupRotations(FakeMalialosaurEntity entity, PoseStack poseStack, float f, float f2, float f3) {
		super.setupRotations(entity, poseStack, f, f2, f3);
		float pitch = entity.getXRot() * entity.getWaterAnim() / 40f;
		poseStack.mulPose(Axis.XP.rotationDegrees(-pitch));
	}
}

