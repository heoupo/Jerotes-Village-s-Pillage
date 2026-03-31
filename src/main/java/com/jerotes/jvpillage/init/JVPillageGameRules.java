package com.jerotes.jvpillage.init;

import com.jerotes.jvpillage.config.OtherMainConfig;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JVPillageGameRules {
	public static GameRules.Key<GameRules.BooleanValue> JVPILLAGE_SOME_ELITE_HAS_BOSS_BAR;
	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		JVPILLAGE_SOME_ELITE_HAS_BOSS_BAR = GameRules.register("JVPillageSomeEliteHasBossBar", GameRules.Category.MOBS, GameRules.BooleanValue.create(OtherMainConfig.SomeEliteHasBossBarBaseInGameRule));
	}
}
