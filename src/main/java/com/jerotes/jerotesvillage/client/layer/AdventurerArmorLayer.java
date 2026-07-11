package com.jerotes.jerotesvillage.client.layer;

import com.jerotes.jerotes.util.EntityAndItemFind;
import com.jerotes.jerotesvillage.JerotesVillage;
import com.jerotes.jerotesvillage.config.OtherMainConfig;
import com.jerotes.jerotesvillage.entity.Monster.IllagerFaction.AdventurerEntity;
import com.jerotes.jerotesvillage.event.WeatherEvent;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class AdventurerArmorLayer<T extends AdventurerEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {
    private final ResourceLocation textureLocation;
    private final M model;
    private static final ResourceLocation EX1_ARMOR_LOCATION = new ResourceLocation(JerotesVillage.MODID, "textures/entity/illager/adventurer/adventurer_armor_ex1_by_heoupo.png");
    private static final ResourceLocation EX2_ARMOR_LOCATION = new ResourceLocation(JerotesVillage.MODID, "textures/entity/illager/adventurer/adventurer_armor_ex2_by_heoupo.png");
    private static final ResourceLocation COMMANDER_ARMOR_LOCATION = new ResourceLocation(JerotesVillage.MODID, "textures/entity/illager/adventurer/commander_armor.png");

    public AdventurerArmorLayer(RenderLayerParent<T, M> renderLayerParent, M m, ResourceLocation resourceLocation) {
        super(renderLayerParent);
        this.model = m;
        this.textureLocation = resourceLocation;
    }

    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int n, T t, float f, float f2, float f3, float f4, float f5, float f6) {
        if (!EntityAndItemFind.isTrueInvisible(t)) {
            if (WeatherEvent.isAprilFoolsDay() && OtherMainConfig.SpecialDay) {
                return;
            }
            ResourceLocation resourceLocation = this.textureLocation;
            String string = ChatFormatting.stripFormatting(t.getName().getString());
            if ("Commander".equals(string) || "指挥官".equals(string)) {
                resourceLocation = COMMANDER_ARMOR_LOCATION;
            }
            else if (t.isChampion()) {
                if("Vaardigheid".equals(string) || "至高之术".equals(string)) {
                    resourceLocation =  EX2_ARMOR_LOCATION;}
                else {
                    resourceLocation =  EX1_ARMOR_LOCATION;}
            }
            this.getParentModel().copyPropertiesTo(this.model);
            this.model.prepareMobModel(t, f, f2, f3);
            this.model.setupAnim(t, f, f2, f4, f5, f6);
            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(resourceLocation));
            this.model.renderToBuffer(poseStack, vertexConsumer, n, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}
