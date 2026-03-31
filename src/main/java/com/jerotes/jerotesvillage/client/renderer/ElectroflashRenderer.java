package com.jerotes.jerotesvillage.client.renderer;

import com.jerotes.jerotes.client.renderer.BaseBeamRenderer;
import com.jerotes.jerotesvillage.JerotesVillage;
import com.jerotes.jerotesvillage.entity.Shoot.Magic.MagicBeam.ElectroflashEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class ElectroflashRenderer<T extends ElectroflashEntity> extends BaseBeamRenderer<T> {
	private static final ResourceLocation LOCATION = new ResourceLocation(JerotesVillage.MODID, "textures/entity/beam/electroflash.png");
	public ElectroflashRenderer(EntityRendererProvider.Context context) {
		super(context);
	}
	@Override
	public ResourceLocation getBeamLocation() {
		return LOCATION;
	}
}

