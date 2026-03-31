package com.jerotes.jvpillage.client.renderer;

import com.jerotes.jvpillage.JVPillage;
import com.jerotes.jvpillage.client.model.Modelillager;
import com.jerotes.jvpillage.config.OtherMainConfig;
import com.jerotes.jvpillage.entity.Monster.IllagerFaction.ExplorerEntity;
import com.jerotes.jvpillage.event.WeatherEvent;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.ZombieVillagerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

public class ExplorerRenderer extends HumanoidMobRenderer<ExplorerEntity, Modelillager<ExplorerEntity>> {
    private static final ResourceLocation EXPLORER_LOCATION = new ResourceLocation(JVPillage.MODID, "textures/entity/explorer.png");
    private static final ResourceLocation KILLER_LOCATION = new ResourceLocation(JVPillage.MODID, "textures/entity/explorer_killer.png");
    public ExplorerRenderer(EntityRendererProvider.Context context) {
        super(context, new Modelillager(context.bakeLayer(Modelillager.LAYER_LOCATION)), 0.5f);
        this.addLayer(new HumanoidArmorLayer<>(this, new ZombieVillagerModel(context.bakeLayer(ModelLayers.ZOMBIE_VILLAGER_INNER_ARMOR)), new ZombieVillagerModel(context.bakeLayer(ModelLayers.ZOMBIE_VILLAGER_OUTER_ARMOR)), context.getModelManager()));
        this.model.getHat().visible = true;
    }

    @Override
    protected void scale(ExplorerEntity entity, PoseStack poseStack, float f) {
        poseStack.scale(0.9375F, 0.9375F, 0.9375F);
        super.scale(entity, poseStack, f);
    }

    @Override
    public ResourceLocation getTextureLocation(ExplorerEntity entity) {
        if (WeatherEvent.isAprilFoolsDay() && OtherMainConfig.SpecialDay) {
            return new ResourceLocation(JVPillage.MODID, "textures/entity/ax_crazy_fake.png");
        }
        String string = ChatFormatting.stripFormatting(entity.getName().getString());
        if (entity.isChampion()) {
            return KILLER_LOCATION;
        }
        return EXPLORER_LOCATION;
    }
}
