package com.jerotes.jvpillage.client.renderer;

import com.jerotes.jerotes.entity.Part.BasePartEntity;
import com.jerotes.jvpillage.JVPillage;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class PartRenderer<T extends BasePartEntity> extends EntityRenderer<T> {
	private static final ResourceLocation LOCATION = new ResourceLocation(JVPillage.MODID, "textures/entity/gemstone_malignasaur.png");
	public PartRenderer(EntityRendererProvider.Context context) {
		super(context);
	}

	@Override
	public ResourceLocation getTextureLocation(T t) {
		return LOCATION;
	}

}
