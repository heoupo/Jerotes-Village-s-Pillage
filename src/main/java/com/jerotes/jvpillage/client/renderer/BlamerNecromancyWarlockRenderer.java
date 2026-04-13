package com.jerotes.jvpillage.client.renderer;

import com.jerotes.jvpillage.JVPillage;
import com.jerotes.jvpillage.client.model.Modelblamer_necromancy_warlock;
import com.jerotes.jvpillage.config.OtherMainConfig;
import com.jerotes.jvpillage.entity.MagicSummoned.BlamerNecromancyWarlock.BlamerNecromancyWarlockEntity;
import com.jerotes.jvpillage.event.WeatherEvent;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.ZombieVillagerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Enemy;

public class BlamerNecromancyWarlockRenderer extends HumanoidMobRenderer<BlamerNecromancyWarlockEntity, Modelblamer_necromancy_warlock<BlamerNecromancyWarlockEntity>> {
    private static final ResourceLocation LOCATION = new ResourceLocation(JVPillage.MODID, "textures/entity/blamer_necromancy_warlock.png");
    private static final ResourceLocation FURY_LOCATION = new ResourceLocation(JVPillage.MODID, "textures/entity/fury_blamer_necromancy_warlock.png");
    public BlamerNecromancyWarlockRenderer(EntityRendererProvider.Context context) {
        super(context, new Modelblamer_necromancy_warlock(context.bakeLayer(Modelblamer_necromancy_warlock.LAYER_LOCATION)), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new ZombieVillagerModel(context.bakeLayer(ModelLayers.ZOMBIE_VILLAGER_INNER_ARMOR)), new ZombieVillagerModel(context.bakeLayer(ModelLayers.ZOMBIE_VILLAGER_OUTER_ARMOR)), context.getModelManager()));
        this.model.getHat().visible = true;
    }

    @Override
    protected void scale(BlamerNecromancyWarlockEntity entity, PoseStack poseStack, float f) {
        poseStack.scale(0.9375F, 0.9375F, 0.9375F);
        super.scale(entity, poseStack, f);
    }

    @Override
    protected float getFlipDegrees(BlamerNecromancyWarlockEntity entity) {
        return 0.0f;
    }

    @Override
    protected boolean isShaking(BlamerNecromancyWarlockEntity entity) {
        return true;
    }

    @Override
    public ResourceLocation getTextureLocation(BlamerNecromancyWarlockEntity t) {
        if (WeatherEvent.isAprilFoolsDay() && OtherMainConfig.SpecialDay) {
            return new ResourceLocation(JVPillage.MODID, "textures/entity/ax_crazy_fake_2.png");
        }
        String string = ChatFormatting.stripFormatting(t.getName().getString());
        if (t instanceof Enemy) {
            return FURY_LOCATION;
        }
        return LOCATION;
    }
}
