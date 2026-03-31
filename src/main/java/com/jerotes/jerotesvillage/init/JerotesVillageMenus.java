package com.jerotes.jerotesvillage.init;

import com.jerotes.jerotesvillage.JerotesVillage;
import com.jerotes.jerotesvillage.world.inventory.CarvedFactionMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class JerotesVillageMenus {
    public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, JerotesVillage.MODID);
    public static final RegistryObject<MenuType<CarvedFactionMenu>> CARVED_FACTION = REGISTRY.register("carved_faction", () -> new MenuType<>(CarvedFactionMenu::new, FeatureFlags.VANILLA_SET));

}