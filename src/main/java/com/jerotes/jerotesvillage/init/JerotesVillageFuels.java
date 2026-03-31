package com.jerotes.jerotesvillage.init;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber

public class JerotesVillageFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == JerotesVillageBlocks.DROUGHT_FIRE_MUD.get().asItem())
			event.setBurnTime(800);
		else if (itemstack.getItem() == JerotesVillageItems.GIANT_MONSTER_HAIR.get().asItem())
			event.setBurnTime(200);
		else if (itemstack.getItem() == JerotesVillageItems.SPIRVE_STUB.get().asItem())
			event.setBurnTime(200);
		else if (itemstack.getItem() == JerotesVillageItems.SPIRVE_BROOM.get().asItem())
			event.setBurnTime(200);
		else if (itemstack.getItem() == JerotesVillageItems.SPIRVE_MOP.get().asItem())
			event.setBurnTime(200);
		else if (itemstack.getItem() == JerotesVillageItems.SPIRVE_INSECT_NET.get().asItem())
			event.setBurnTime(200);
		else if (itemstack.getItem() == JerotesVillageItems.SPIRVE_LID.get().asItem())
			event.setBurnTime(200);
		else if (itemstack.getItem() == JerotesVillageItems.SPIRVE_RULER.get().asItem())
			event.setBurnTime(200);
		else if (itemstack.getItem() == JerotesVillageItems.SPIRVE_WOODEN_BACK_SCRATCHER.get().asItem())
			event.setBurnTime(200);
	}
}