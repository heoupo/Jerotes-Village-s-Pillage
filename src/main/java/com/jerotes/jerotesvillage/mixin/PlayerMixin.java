package com.jerotes.jerotesvillage.mixin;

import com.jerotes.jerotesvillage.util.Other;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity {
    @Shadow public abstract void attack(Entity p_36347_);

    protected PlayerMixin(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);
    }

//    @Inject(method = "attack", at = @At("HEAD"), cancellable = true)
//    private void attack(Entity entity, CallbackInfo ci) {
//        if (entity instanceof GemstoneMalignasaurPart gemstoneMalignasaurPart && gemstoneMalignasaurPart.getParent() != null) {
//            attack(gemstoneMalignasaurPart.getParent());
//            ci.cancel();
//        }
//    }

    @Inject(method = "isScoping", at = @At("HEAD"), cancellable = true)
    private void isScoping(CallbackInfoReturnable<Boolean> cir) {
        if (Other.isOtherScoping(this)) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }
}