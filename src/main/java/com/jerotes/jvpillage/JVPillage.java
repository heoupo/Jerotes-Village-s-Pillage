package com.jerotes.jvpillage;

import com.jerotes.jerotes.spell.SpellRegistry;
import com.jerotes.jvpillage.client.CilentInit;
import com.jerotes.jvpillage.config.OtherMainConfig;
import com.jerotes.jvpillage.init.*;
import com.jerotes.jvpillage.network.OtherPacketHandler;
import com.jerotes.jvpillage.spell.OtherSpellType;
import com.jerotes.jvpillage.world.features.StructureFeature;
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

@Mod(JVPillage.MODID)
public class JVPillage {
    public static final String MODID = "jvpillage";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final RecipeBookType TABLET_PRESS_MACHINE = RecipeBookType.create("TABLET_PRESS_MACHINE");

    public JVPillage() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        JVPillageItems.REGISTRY.register(modEventBus);
        JVPillageBlocks.REGISTRY.register(modEventBus);
        JVPillageBlockEntityType.REGISTRY.register(modEventBus);
        JVPillageEntityType.REGISTRY.register(modEventBus);
        JVPillageTabs.REGISTRY.register(modEventBus);
        JVPillageMobEffects.REGISTRY.register(modEventBus);
        JVPillageParticleTypes.REGISTRY.register(modEventBus);
        JVPillagePotions.REGISTRY.register(modEventBus);
        JVPillageEnchantments.REGISTRY.register(modEventBus);
        JVPillageRecipeType.REGISTRY.register(modEventBus);
        JVPillageRecipeSerializers.REGISTRY.register(modEventBus);
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
        event.enqueueWork(JVPillageItems::setup);
        event.enqueueWork(JVPillageSpawnPlacements::init);
        event.enqueueWork(JVPillageRaider::addRaiders);
    }

    private void initClient(final FMLClientSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        event.enqueueWork(CilentInit::clientInit);
        event.enqueueWork(() -> {
        });
    }
}