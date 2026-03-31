package com.jerotes.jvpillage.client.renderer;

import com.jerotes.jerotes.entity.Shoot.Arrow.BaseArrowEntity;
import com.jerotes.jvpillage.JVPillage;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class JerotesVillageArrowRenderer extends ArrowRenderer<BaseArrowEntity> {
    public static final ResourceLocation VIRTUAL_CAVE_CRYSTAL_ARROW = new ResourceLocation(JVPillage.MODID, "textures/entity/projectiles/virtual_cave_crystal_arrow.png");
    public JerotesVillageArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(BaseArrowEntity arrow) {
            return VIRTUAL_CAVE_CRYSTAL_ARROW;
    }
}

