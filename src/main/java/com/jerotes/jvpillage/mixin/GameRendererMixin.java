package com.jerotes.jvpillage.mixin;

import com.jerotes.jvpillage.item.BaseHagEye;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {
    @Inject(method = "getNightVisionScale", at = @At("HEAD"), cancellable = true)
    private static void getNightVisionScale(LivingEntity living, float f, CallbackInfoReturnable<Float> cir) {
        if (living.isUsingItem() && living.getUseItem().getItem() instanceof BaseHagEye) {
            cir.setReturnValue(1.0f);
        }
        if (living.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof BaseHagEye) {
            cir.setReturnValue(1.0f);
        }
    }
}