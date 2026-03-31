package com.jerotes.jvpillage.mixin;

import com.jerotes.jvpillage.JVPillage;
import com.jerotes.jvpillage.block.BaseBlock.ABaseBlock;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SkullBlockRenderer.class)
public abstract class SkullBlockRendererMixin {
    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void injectNewSkullType(CallbackInfo ci) {
        SkullBlockRenderer.SKIN_BY_TYPE.put(ABaseBlock.Types.SECOND_ROUNDER_ZOMBIE, new ResourceLocation(JVPillage.MODID, "textures/entity/second_rounder_zombie.png"));
        SkullBlockRenderer.SKIN_BY_TYPE.put(ABaseBlock.Types.SECOND_ROUNDER_SKELETON, new ResourceLocation(JVPillage.MODID, "textures/entity/second_rounder_skeleton_0.png"));
        SkullBlockRenderer.SKIN_BY_TYPE.put(ABaseBlock.Types.RESURRECTER, new ResourceLocation(JVPillage.MODID, "textures/entity/resurrecter.png"));
        SkullBlockRenderer.SKIN_BY_TYPE.put(ABaseBlock.Types.PURPLE_SAND_CREEPER, new ResourceLocation(JVPillage.MODID, "textures/entity/purple_sand_creeper.png"));
        SkullBlockRenderer.SKIN_BY_TYPE.put(ABaseBlock.Types.SPIRVE, new ResourceLocation(JVPillage.MODID, "textures/entity/spirve.png"));
        SkullBlockRenderer.SKIN_BY_TYPE.put(ABaseBlock.Types.TANGLER, new ResourceLocation(JVPillage.MODID, "textures/entity/tangler_head.png"));
        SkullBlockRenderer.SKIN_BY_TYPE.put(ABaseBlock.Types.BLAMER, new ResourceLocation(JVPillage.MODID, "textures/entity/blamer.png"));
    }
}