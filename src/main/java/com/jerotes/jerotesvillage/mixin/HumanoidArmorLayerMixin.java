package com.jerotes.jerotesvillage.mixin;

import com.jerotes.jerotesvillage.entity.Monster.IllagerFaction.ExplorerEntity;
import com.jerotes.jerotesvillage.entity.Monster.IllagerFaction.SlaverySupervisorEntity;
import com.jerotes.jerotesvillage.init.JerotesVillageItems;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.armortrim.ArmorTrim;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(HumanoidArmorLayer.class)
public abstract class HumanoidArmorLayerMixin<T extends LivingEntity, M extends HumanoidModel<T>, A extends HumanoidModel<T>> extends RenderLayer<T, M> {

    public HumanoidArmorLayerMixin(RenderLayerParent<T, M> renderLayerParent) {
        super(renderLayerParent);
    }

    @Inject(method = "renderArmorPiece*", at = @At("HEAD"), cancellable = true)
    public void renderArmorPiece(PoseStack poseStack, MultiBufferSource multiBufferSource, T t, EquipmentSlot equipmentSlot, int n, A a, CallbackInfo ci) {
        ItemStack itemstack = t.getItemBySlot(equipmentSlot);
        Item item = itemstack.getItem();
        if (t instanceof ExplorerEntity) {
            if (item == JerotesVillageItems.EXPLORER_HELMET.get()) {
                ci.cancel();
            }
            if (item == JerotesVillageItems.EXPLORER_CHESTPLATE.get()) {
                ci.cancel();
            }
            if (item == JerotesVillageItems.EXPLORER_LEGGINGS.get()) {
                ci.cancel();
            }
            if (item == JerotesVillageItems.EXPLORER_BOOTS.get()) {
                ci.cancel();
            }
        }
        if (t instanceof SlaverySupervisorEntity) {
            if (item == JerotesVillageItems.SLAVERY_SUPERVISOR_HELMET.get()) {
                ci.cancel();
            }
            if (item == JerotesVillageItems.SLAVERY_SUPERVISOR_CHESTPLATE.get()) {
                ci.cancel();
            }
            if (item == JerotesVillageItems.SLAVERY_SUPERVISOR_LEGGINGS.get()) {
                ci.cancel();
            }
            if (item == JerotesVillageItems.SLAVERY_SUPERVISOR_BOOTS.get()) {
                ci.cancel();
            }
        }
    }
    @Inject(method = "renderTrim*", at = @At("HEAD"), cancellable = true)
    public void renderTrim1(ArmorMaterial armorMaterial, PoseStack poseStack, MultiBufferSource multiBufferSource, int n, ArmorTrim armorTrim, A model, boolean bl, CallbackInfo ci) {
        if (specialArmor().contains(armorMaterial.getName())) {
            ci.cancel();
        }
    }

    public List<String> specialArmor() {
        List<String> list = new ArrayList<>();
        list.add("meror_metal_armor");
        list.add("meror_standard_armor");
        list.add("mountain_realm_armor");
        list.add("ancient_second_rounder_armor");
        list.add("magicka_scale_armor");
        list.add("blamer_robe");
        list.add("horned_armor");
        list.add("giant_monster_horned_armor");
        list.add("big_witch_armor");
        list.add("woodland_heart_guardian_mask");
        return list;
    }
}