package com.jerotes.jerotesvillage.item;

import com.jerotes.jerotes.item.Tool.ItemToolBaseDagger;
import com.jerotes.jerotesvillage.init.JerotesVillageItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class VillagerMetalDagger extends ItemToolBaseDagger {
	public VillagerMetalDagger() {
		super(new Tier() {
			public int getUses() {
				return 450;
			}

			public float getSpeed() {
				return 6f;
			}

			public float getAttackDamageBonus() {
				return 4.5f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 17;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(JerotesVillageItems.VILLAGER_METAL_INGOT.get()));
			}
		}, -1, 2.4f - 4f, new Properties());
	}
}
