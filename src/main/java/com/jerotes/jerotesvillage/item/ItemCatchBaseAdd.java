package com.jerotes.jerotesvillage.item;

import com.jerotes.jerotes.item.ItemCatchBase;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class ItemCatchBaseAdd extends ItemCatchBase {
	private final Supplier<? extends EntityType<?>> entityTypeSupplier;

	public ItemCatchBaseAdd(Supplier<? extends EntityType<?>> entitySupplier, Item.Properties properties) {
		super(entitySupplier, properties);
		this.entityTypeSupplier = entitySupplier;
	}

	@Override
	public String getDescriptionId(ItemStack itemStack) {
		return isQueen(itemStack) ? "item.jerotesvillage.captured_dust_moth_queen" : super.getDescriptionId(itemStack);
	}

	public static boolean isQueen(ItemStack itemStack) {
		CompoundTag compoundtag = itemStack.getTag();
		return compoundtag != null && (compoundtag.contains("IsQueen") && compoundtag.getBoolean("IsQueen"));
	}

	public static boolean isPupa(ItemStack itemStack) {
		CompoundTag compoundtag = itemStack.getTag();
		return compoundtag != null && (compoundtag.contains("IsPupa") && compoundtag.getBoolean("IsPupa"));
	}
}
