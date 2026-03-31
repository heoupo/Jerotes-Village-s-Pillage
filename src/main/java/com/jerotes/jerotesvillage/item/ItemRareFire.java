package com.jerotes.jerotesvillage.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class ItemRareFire extends Item {
	public ItemRareFire() {
		super(new Properties().stacksTo(64).fireResistant().rarity(Rarity.RARE));
	}
}
