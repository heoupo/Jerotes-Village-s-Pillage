package com.jerotes.jerotesvillage.client.renderer;

import com.jerotes.blackgoldalliance.client.layer.GlowOtherBodyLayer;
import com.jerotes.jerotesvillage.JerotesVillage;
import com.jerotes.jerotesvillage.client.model.Modelfury_slider_ax_crazy;
import com.jerotes.jerotesvillage.config.OtherMainConfig;
import com.jerotes.jerotesvillage.entity.Monster.IllagerFaction.FurySliderAxCrazyEntity;
import com.jerotes.jerotesvillage.event.WeatherEvent;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.ZombieVillagerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

public class FurySliderAxCrazyRenderer extends HumanoidMobRenderer<FurySliderAxCrazyEntity, Modelfury_slider_ax_crazy<FurySliderAxCrazyEntity>> {
    private static final ResourceLocation LOCATION = new ResourceLocation(JerotesVillage.MODID, "textures/entity/illager/fury_slider_ax_crazy.png");
    private static final ResourceLocation GLOW_LOCATION = new ResourceLocation(JerotesVillage.MODID, "textures/entity/illager/fury_slider_ax_crazy_glow.png");
    public FurySliderAxCrazyRenderer(EntityRendererProvider.Context context) {
        super(context, new Modelfury_slider_ax_crazy(context.bakeLayer(Modelfury_slider_ax_crazy.LAYER_LOCATION)), 0.5f);
        this.addLayer(new GlowOtherBodyLayer<>(this, new Modelfury_slider_ax_crazy(context.bakeLayer(Modelfury_slider_ax_crazy.LAYER_LOCATION)), GLOW_LOCATION));
        this.addLayer(new HumanoidArmorLayer(this, new ZombieVillagerModel(context.bakeLayer(ModelLayers.ZOMBIE_VILLAGER_INNER_ARMOR)), new ZombieVillagerModel(context.bakeLayer(ModelLayers.ZOMBIE_VILLAGER_OUTER_ARMOR)), context.getModelManager()));
        this.model.getHat().visible = true;
    }

    @Override
    protected void scale(FurySliderAxCrazyEntity entity, PoseStack poseStack, float f) {
        poseStack.scale(0.9375F, 0.9375F, 0.9375F);
        super.scale(entity, poseStack, f);
    }

    @Override
    protected float getFlipDegrees(FurySliderAxCrazyEntity entity) {
        return 0.0f;
    }

    @Override
    protected boolean isShaking(FurySliderAxCrazyEntity entity) {
        String string = ChatFormatting.stripFormatting(entity.getName().getString());
        return entity.isAggressive() && super.isShaking(entity);
    }

    @Override
    public ResourceLocation getTextureLocation(FurySliderAxCrazyEntity t) {
        if (WeatherEvent.isAprilFoolsDay() && OtherMainConfig.SpecialDay) {
            return new ResourceLocation(JerotesVillage.MODID, "textures/entity/ax_crazy_fake_2.png");
        }
        String string = ChatFormatting.stripFormatting(t.getName().getString());
        return LOCATION;
    }

    @Override
    protected void setupRotations(FurySliderAxCrazyEntity entity, PoseStack poseStack, float f, float f2, float f3) {
        super.setupRotations(entity, poseStack, f, f2, f3);
        String string = ChatFormatting.stripFormatting(entity.getName().getString());
        if ((double)entity.walkAnimation.speed() < 0.01) {
            return;
        }
        float f5 = entity.walkAnimation.position(f3) + 6.0f;
        float f6 = (Math.abs(f5 % 13.0f - 6.5f) - 3.25f) / 3.25f;
        poseStack.mulPose(Axis.ZP.rotationDegrees(2.5f * f6));
    }
}
