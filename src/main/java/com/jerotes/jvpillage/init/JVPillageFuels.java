package com.jerotes.jvpillage.init;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber

public class JVPillageFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == JVPillageBlocks.DROUGHT_FIRE_MUD.get().asItem())
			event.setBurnTime(800);
		else if (itemstack.getItem() == JVPillageItems.GIANT_MONSTER_HAIR.get().asItem())
			event.setBurnTime(200);
		else if (itemstack.getItem() == JVPillageItems.SPIRVE_STUB.get().asItem())
			event.setBurnTime(200);
		else if (itemstack.getItem() == JVPillageItems.SPIRVE_BROOM.get().asItem())
			event.setBurnTime(200);
		else if (itemstack.getItem() == JVPillageItems.SPIRVE_MOP.get().asItem())
			event.setBurnTime(200);
		else if (itemstack.getItem() == JVPillageItems.SPIRVE_INSECT_NET.get().asItem())
			event.setBurnTime(200);
		else if (itemstack.getItem() == JVPillageItems.SPIRVE_LID.get().asItem())
			event.setBurnTime(200);
		else if (itemstack.getItem() == JVPillageItems.SPIRVE_RULER.get().asItem())
			event.setBurnTime(200);
		else if (itemstack.getItem() == JVPillageItems.SPIRVE_WOODEN_BACK_SCRATCHER.get().asItem())
			event.setBurnTime(200);
	}
}