package com.jerotes.jvpillage.enchantment;

import com.jerotes.jvpillage.init.JVPillageEnchantments;
import com.jerotes.jvpillage.item.Tool.ItemToolBaseThrowingBall;
import com.jerotes.jvpillage.item.Tool.ItemToolBaseThrowingBallGlove;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;


public class ElasticityEnchantment extends Enchantment {
	public ElasticityEnchantment(EquipmentSlot... slots) {
		super(Rarity.COMMON, JVPillageEnchantments.THROWING_BALL_ABOUT, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public int getMinCost(int n) {
		return 1 + (n - 1) * 10;
	}

	@Override
	public int getMaxCost(int n) {
		return 50;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack itemstack) {
		return itemstack.getItem() instanceof ItemToolBaseThrowingBall || itemstack.getItem() instanceof ItemToolBaseThrowingBallGlove;
	}
}
