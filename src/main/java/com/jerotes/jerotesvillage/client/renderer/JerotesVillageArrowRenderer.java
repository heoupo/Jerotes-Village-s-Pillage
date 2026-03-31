package com.jerotes.jerotesvillage.client.renderer;

import com.jerotes.jerotes.entity.Shoot.Arrow.BaseArrowEntity;
import com.jerotes.jerotesvillage.JerotesVillage;
import com.jerotes.jerotesvillage.entity.Shoot.Arrow.CarvedVillagerSpectralArrowEntity;
import com.jerotes.jerotesvillage.entity.Shoot.Arrow.VirtualCaveCrystalArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class JerotesVillageArrowRenderer extends ArrowRenderer<BaseArrowEntity> {
    public static final ResourceLocation CARVED_VILLAGER_SPECTRAL_ARROW = new ResourceLocation(JerotesVillage.MODID, "textures/entity/projectiles/carved_villager_spectral_arrow.png");
    public static final ResourceLocation VIRTUAL_CAVE_CRYSTAL_ARROW = new ResourceLocation(JerotesVillage.MODID, "textures/entity/projectiles/virtual_cave_crystal_arrow.png");
    public JerotesVillageArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(BaseArrowEntity arrow) {
        if (arrow instanceof CarvedVillagerSpectralArrowEntity)
            return CARVED_VILLAGER_SPECTRAL_ARROW;
        if (arrow instanceof VirtualCaveCrystalArrowEntity)
            return VIRTUAL_CAVE_CRYSTAL_ARROW;
        return CARVED_VILLAGER_SPECTRAL_ARROW;
    }
}

