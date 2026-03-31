package com.jerotes.jerotesvillage.event;

import com.jerotes.jerotesvillage.JerotesVillage;
import com.jerotes.jerotesvillage.item.BrightGoldenMelonHammer;
import com.jerotes.jerotesvillage.item.HagEye;
import com.jerotes.jerotesvillage.item.PurpleSandHagEye;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class CameraEvent {
	private static final ResourceLocation NAUSEA_LOCATION = new ResourceLocation("textures/misc/nausea.png");
	private static final ResourceLocation DARK_LOCATION = new ResourceLocation(JerotesVillage.MODID, "textures/gui/dark.png");

	@SubscribeEvent
	public static void FOV(ComputeFovModifierEvent event) {
		Player player = event.getPlayer();
		if (player.isUsingItem()) {
			Item useItem = player.getUseItem().getItem();
			if (useItem instanceof HagEye || useItem instanceof PurpleSandHagEye) {
				float f = player.getTicksUsingItem() / 20.0F;
				f = f > 1.0F ? 1.0F : f * f;
				event.setNewFovModifier((float) Mth.lerp(Minecraft.getInstance().options.fovEffectScale().get(), 1.0F, (event.getFovModifier() * (1.0F - f * 0.8F))));
			}
			else if (useItem instanceof BrightGoldenMelonHammer) {
				float f = player.getTicksUsingItem() / 25.0F;
				f = f > 1.0F ? 1.0F : f * f;
				event.setNewFovModifier((float) Mth.lerp(Minecraft.getInstance().options.fovEffectScale().get(), 1.0F, (event.getFovModifier() * (1.0F - f * 0.15F))));
			}
		}
	}


	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void InPortal(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Player player = Minecraft.getInstance().player;
		if (player == null) {
			return;
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		boolean bl = player.getPersistentData().getDouble("jerotesvillage_second_rounder_portal") > 0;
		if (bl) {
			RenderSystem.setShaderColor(1, 1, 1, (float) (player.getPersistentData().getDouble("jerotesvillage_second_rounder_portal") / 30));
			event.getGuiGraphics().blit(new ResourceLocation(JerotesVillage.MODID, "textures/gui/second_round_world_portal.png"), 0, 0, -90, 0.0F, 0.0F, event.getGuiGraphics().guiWidth(), event.getGuiGraphics().guiHeight(), event.getGuiGraphics().guiWidth(), event.getGuiGraphics().guiHeight());
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void BrightLandBeastWalk(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Player player = Minecraft.getInstance().player;
		if (player == null) {
			return;
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		Item item = player.getMainHandItem().getItem();
		if (false) {
			int n = player.tickCount % 100;
			ResourceLocation resourceLocation = new ResourceLocation(JerotesVillage.MODID, "textures/bright_land_beast_walk/bright_land_beast_walk_"+ n + ".png");
			event.getGuiGraphics().blit(resourceLocation, w / 2 - 6, h / 2 - 17, 0, 0, 837/4, 576/4, 837/4, 576/4);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
