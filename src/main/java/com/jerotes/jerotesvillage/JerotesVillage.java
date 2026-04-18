package com.jerotes.jerotesvillage;

import com.jerotes.jerotes.spell.SpellRegistry;
import com.jerotes.jerotesvillage.client.CilentInit;
import com.jerotes.jerotesvillage.config.OtherMainConfig;
import com.jerotes.jerotesvillage.init.*;
import com.jerotes.jerotesvillage.network.OtherPacketHandler;
import com.jerotes.jerotesvillage.spell.OtherSpellType;
import com.jerotes.jerotesvillage.world.features.StructureFeature;
import com.mojang.logging.LogUtils;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(JerotesVillage.MODID)
public class JerotesVillage {
    public static final String MODID = "jerotesvillage";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final RecipeBookType TABLET_PRESS_MACHINE = RecipeBookType.create("TABLET_PRESS_MACHINE");

    public JerotesVillage() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        JerotesVillageItems.REGISTRY.register(modEventBus);
        JerotesVillageBlocks.REGISTRY.register(modEventBus);
        JerotesVillageBlockEntityType.REGISTRY.register(modEventBus);
        JerotesVillageEntityType.REGISTRY.register(modEventBus);
        JerotesVillageTabs.REGISTRY.register(modEventBus);
        JerotesVillageMobEffects.REGISTRY.register(modEventBus);
        JerotesVillageParticleTypes.REGISTRY.register(modEventBus);
        JerotesVillagePotions.REGISTRY.register(modEventBus);
        JerotesVillageEnchantments.REGISTRY.register(modEventBus);
        JerotesVillageRecipeType.REGISTRY.register(modEventBus);
        JerotesVillageRecipeSerializers.REGISTRY.register(modEventBus);
        JerotesVillageMenus.REGISTRY.register(modEventBus);
        StructureFeature.REGISTRY.register(modEventBus);
        modEventBus.addListener(this::initClient);
        modEventBus.addListener(this::commonSetup);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, OtherMainConfig.COMMON_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, OtherMainConfig.CLIENT_SPEC);
        for (OtherSpellType type : OtherSpellType.values()) {
            SpellRegistry.register(type);
        }
        MinecraftForge.EVENT_BUS.register(this);
    }


    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(OtherPacketHandler::register);
        event.enqueueWork(JerotesVillageItems::setup);
        event.enqueueWork(JerotesVillageSpawnPlacements::init);
        event.enqueueWork(JerotesVillageRaider::addRaiders);
    }

    private void initClient(final FMLClientSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        event.enqueueWork(CilentInit::clientInit);
        event.enqueueWork(() -> {
        });
    }
}