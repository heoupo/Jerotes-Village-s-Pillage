package com.jerotes.jvpillage.event;

import com.jerotes.jvpillage.JVPillage;
import com.jerotes.jvpillage.block.BaseBlock.ABaseBlock;
import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JVPillage.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class HeadModelEvent {
    @SubscribeEvent
    public static void onCreateSkullModel(EntityRenderersEvent.CreateSkullModels event) {
        registerSkullModelSafe(event, ABaseBlock.Types.SPIRVE, ModelLayers.PLAYER_HEAD);
    }

    private static void registerSkullModelSafe(EntityRenderersEvent.CreateSkullModels event, SkullBlock.Type skullType, ModelLayerLocation modelLayer) {
        try {
            ModelPart modelPart = event.getEntityModelSet().bakeLayer(modelLayer);
            if (modelPart == null) {
                JVPillage.LOGGER.error("Failed to bake model layer for skull type: {}", skullType);
                return;
            }
            event.registerSkullModel(skullType, new SkullModel(modelPart));
        } catch (Exception e) {
            JVPillage.LOGGER.error("Failed to register skull model for type: {}", skullType, e);
        }
    }
}