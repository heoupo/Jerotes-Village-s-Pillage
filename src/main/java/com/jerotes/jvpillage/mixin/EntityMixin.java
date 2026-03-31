package com.jerotes.jvpillage.mixin;

import com.jerotes.jerotes.util.AttackFind;
import com.jerotes.jvpillage.entity.Interface.GoastEntity;
import com.jerotes.jvpillage.util.OtherEntityFactionFind;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.entity.EntityInLevelCallback;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Shadow private EntityInLevelCallback levelCallback;

    @Inject(method = "isOnFire", at = @At("HEAD"), cancellable = true)
    private void isOnFire(CallbackInfoReturnable<Boolean> cir) {
        if (this instanceof GoastEntity goastEntity && goastEntity.isGoast()) {
            cir.setReturnValue(false);
            cir.cancel();
        }
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        if (((Entity)((Object)this)) instanceof LivingEntity livingEntity) {
            if (!(livingEntity instanceof Player) && !OtherEntityFactionFind.isZsiein(livingEntity.getType())) {
                if (livingEntity.getPersistentData().getDouble("jerotesvillage_variant_zsiein_discard") >= 60000) {
                    DamageSource damageSource = AttackFind.findDamageType(livingEntity, DamageTypes.GENERIC_KILL, livingEntity);
                   livingEntity.hurt(livingEntity.damageSources().genericKill(), Float.MAX_VALUE);
                    livingEntity.hurt(damageSource, Float.MAX_VALUE);
                    levelCallback.onRemove(Entity.RemovalReason.CHANGED_DIMENSION);
                }
            }
        }
    }

    @Inject(method = "getTypeName", at = @At("HEAD"), cancellable = true)
    private void getTypeName(CallbackInfoReturnable<Component> cir) {
        if (this instanceof GoastEntity goastEntity && goastEntity.isGoast())
            cir.setReturnValue(Component.translatable("entity.jvpillage.goast"));

    }
}