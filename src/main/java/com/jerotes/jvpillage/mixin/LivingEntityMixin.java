package com.jerotes.jvpillage.mixin;

import com.jerotes.jvpillage.entity.Interface.GoastEntity;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    protected LivingEntityMixin(EntityType<? extends Entity> entityType, Level level) {
        super(entityType, level);
    }


    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    public void hurt(DamageSource damageSource, float p_21017_, CallbackInfoReturnable<Boolean> cir) {
        if (this instanceof GoastEntity goastEntity && goastEntity.isGoast() && damageSource.is(DamageTypeTags.IS_FIRE)) {
           cir.setReturnValue(false);
           cir.cancel();
        }
    }

    @Shadow
    public abstract ItemStack getItemBySlot(EquipmentSlot equipmentSlot);

    @Shadow public abstract boolean hasEffect(MobEffect p_21024_);

    @Shadow @Nullable public abstract MobEffectInstance getEffect(MobEffect p_21125_);

}