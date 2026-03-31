package com.jerotes.jvpillage.client.renderer;

import com.jerotes.jvpillage.JVPillage;
import com.jerotes.jvpillage.client.layer.FirepowerPourerChainsawLayer;
import com.jerotes.jvpillage.client.layer.FirepowerPourerGunLayer;
import com.jerotes.jvpillage.client.model.Modelfirepower_pourer;
import com.jerotes.jvpillage.entity.Monster.IllagerFaction.FirepowerPourerEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

public class FirepowerPourerRenderer extends MobRenderer<FirepowerPourerEntity, Modelfirepower_pourer<FirepowerPourerEntity>> {
	private static final ResourceLocation LOCATION = new ResourceLocation(JVPillage.MODID, "textures/entity/firepower_pourer.png");
	private static final ResourceLocation BREAK_1_LOCATION = new ResourceLocation(JVPillage.MODID, "textures/entity/firepower_pourer_break_1.png");
	private static final ResourceLocation BREAK_2_LOCATION = new ResourceLocation(JVPillage.MODID, "textures/entity/firepower_pourer_break_2.png");
	private static final ResourceLocation BREAK_3_LOCATION = new ResourceLocation(JVPillage.MODID, "textures/entity/firepower_pourer_break_3.png");
	private static final ResourceLocation HELL_MARCHER_LOCATION = new ResourceLocation(JVPillage.MODID, "textures/entity/firepower_pourer_hell_marcher.png");
	public FirepowerPourerRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfirepower_pourer(context.bakeLayer(Modelfirepower_pourer.LAYER_LOCATION)), 1.2f);
		this.addLayer(new FirepowerPourerChainsawLayer(this, new Modelfirepower_pourer(context.bakeLayer(Modelfirepower_pourer.LAYER_LOCATION))));
		this.addLayer(new FirepowerPourerGunLayer(this, new Modelfirepower_pourer(context.bakeLayer(Modelfirepower_pourer.LAYER_LOCATION))));
		this.addLayer(new CustomHeadLayer<FirepowerPourerEntity, Modelfirepower_pourer<FirepowerPourerEntity>>(this, context.getModelSet(), context.getItemInHandRenderer()));
	}

	@Override
	protected int getBlockLightLevel(FirepowerPourerEntity entity, BlockPos blockPos) {
		if (entity.isChampion()) {
			return 15;
		}
		return 9;
	}

	@Override
	protected float getFlipDegrees(FirepowerPourerEntity entity) {
		return 0.0f;
	}

	@Override
	public ResourceLocation getTextureLocation(FirepowerPourerEntity entity) {
		if (entity.isChampion()) {
			return HELL_MARCHER_LOCATION;
		}
		if (entity.getHealth() <= entity.getMaxHealth() / 4)
			return BREAK_3_LOCATION;
		if (entity.getHealth() <= entity.getMaxHealth() * 3 / 4)
			return BREAK_2_LOCATION;
		if (entity.getHealth() <= entity.getMaxHealth() / 2)
			return BREAK_1_LOCATION;
		return LOCATION;
	}
}

