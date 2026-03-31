package com.jerotes.jvpillage.client.renderer;

import com.jerotes.jvpillage.JVPillage;
import com.jerotes.jvpillage.client.model.Modelslavery_supervisor;
import com.jerotes.jvpillage.config.OtherMainConfig;
import com.jerotes.jvpillage.entity.Monster.IllagerFaction.SlaverySupervisorEntity;
import com.jerotes.jvpillage.event.WeatherEvent;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.ZombieVillagerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

public class SlaverySupervisorRenderer extends HumanoidMobRenderer<SlaverySupervisorEntity, Modelslavery_supervisor<SlaverySupervisorEntity>> {
    private static final ResourceLocation LOCATION = new ResourceLocation(JVPillage.MODID, "textures/entity/slavery_supervisor.png");
    private static final ResourceLocation ILLAGER_WITHER_LOCATION = new ResourceLocation(JVPillage.MODID, "textures/entity/slavery_supervisor_noble_by_illager_wither.png");
    public SlaverySupervisorRenderer(EntityRendererProvider.Context context) {
        super(context, new Modelslavery_supervisor(context.bakeLayer(Modelslavery_supervisor.LAYER_LOCATION)), 0.5f);
        this.addLayer(new HumanoidArmorLayer<>(this, new ZombieVillagerModel(context.bakeLayer(ModelLayers.ZOMBIE_VILLAGER_INNER_ARMOR)), new ZombieVillagerModel(context.bakeLayer(ModelLayers.ZOMBIE_VILLAGER_OUTER_ARMOR)), context.getModelManager()));
        this.model.getHat().visible = true;
    }

    @Override
    protected void scale(SlaverySupervisorEntity entity, PoseStack poseStack, float f) {
        poseStack.scale(0.9375F, 0.9375F, 0.9375F);
        super.scale(entity, poseStack, f);
    }

    @Override
    protected float getFlipDegrees(SlaverySupervisorEntity entity) {
        return 0.0f;
    }

    @Override
    public ResourceLocation getTextureLocation(SlaverySupervisorEntity entity) {
        if (WeatherEvent.isAprilFoolsDay() && OtherMainConfig.SpecialDay) {
            return new ResourceLocation(JVPillage.MODID, "textures/entity/ax_crazy_fake_2.png");
        }
        String string = ChatFormatting.stripFormatting(entity.getName().getString());
        if (entity.isChampion()) {
            return ILLAGER_WITHER_LOCATION;
        }
        return LOCATION;
    }
}
