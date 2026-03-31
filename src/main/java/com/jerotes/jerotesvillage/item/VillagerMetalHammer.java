package com.jerotes.jerotesvillage.item;

import com.jerotes.jerotes.item.Tool.ItemToolBaseHammer;
import com.jerotes.jerotesvillage.init.JerotesVillageItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class VillagerMetalHammer extends ItemToolBaseHammer {
	public VillagerMetalHammer() {
		super(new Tier() {
			public int getUses() {
				return 450;
			}

			public float getSpeed() {
				return 6f;
			}

			public float getAttackDamageBonus() {
				return 11.5f;
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
		}, -1, 0.9f - 4f, new Properties());
	}
}
