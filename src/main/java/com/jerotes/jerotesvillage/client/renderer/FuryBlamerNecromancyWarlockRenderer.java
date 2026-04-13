package com.jerotes.jerotesvillage.client.renderer;

import com.jerotes.jerotesvillage.JerotesVillage;
import com.jerotes.jerotesvillage.client.model.Modelfury_blamer_necromancy_warlock;
import com.jerotes.jerotesvillage.config.OtherMainConfig;
import com.jerotes.jerotesvillage.entity.Monster.IllagerFaction.FuryBlamerNecromancyWarlockEntity;
import com.jerotes.jerotesvillage.event.WeatherEvent;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.ZombieVillagerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

public class FuryBlamerNecromancyWarlockRenderer extends HumanoidMobRenderer<FuryBlamerNecromancyWarlockEntity, Modelfury_blamer_necromancy_warlock<FuryBlamerNecromancyWarlockEntity>> {
    private static final ResourceLocation LOCATION = new ResourceLocation(JerotesVillage.MODID, "textures/entity/fury_blamer_necromancy_warlock.png");
    public FuryBlamerNecromancyWarlockRenderer(EntityRendererProvider.Context context) {
        super(context, new Modelfury_blamer_necromancy_warlock(context.bakeLayer(Modelfury_blamer_necromancy_warlock.LAYER_LOCATION)), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new ZombieVillagerModel(context.bakeLayer(ModelLayers.ZOMBIE_VILLAGER_INNER_ARMOR)), new ZombieVillagerModel(context.bakeLayer(ModelLayers.ZOMBIE_VILLAGER_OUTER_ARMOR)), context.getModelManager()));
        this.model.getHat().visible = true;
    }

    @Override
    protected void scale(FuryBlamerNecromancyWarlockEntity entity, PoseStack poseStack, float f) {
        poseStack.scale(0.9375F, 0.9375F, 0.9375F);
        super.scale(entity, poseStack, f);
    }

    @Override
    protected float getFlipDegrees(FuryBlamerNecromancyWarlockEntity entity) {
        return 0.0f;
    }

    @Override
    protected boolean isShaking(FuryBlamerNecromancyWarlockEntity entity) {
        return true;
    }

    @Override
    public ResourceLocation getTextureLocation(FuryBlamerNecromancyWarlockEntity t) {
        if (WeatherEvent.isAprilFoolsDay() && OtherMainConfig.SpecialDay) {
            return new ResourceLocation(JerotesVillage.MODID, "textures/entity/ax_crazy_fake_2.png");
        }
        String string = ChatFormatting.stripFormatting(t.getName().getString());
        return LOCATION;
    }
}
