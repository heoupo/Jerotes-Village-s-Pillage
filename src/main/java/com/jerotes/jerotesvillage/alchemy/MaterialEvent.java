package com.jerotes.jerotesvillage.alchemy;

import com.jerotes.jerotes.alchemy.effect.*;
import com.jerotes.jerotes.alchemy.forge.JerotesAlchemyMaterialEffectEvent;
import com.jerotes.jerotesvillage.JerotesVillage;
import com.jerotes.jerotesvillage.init.JerotesVillageItems;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JerotesVillage.MODID)
public class MaterialEvent {

	@SubscribeEvent
	public static void Material(JerotesAlchemyMaterialEffectEvent event) {
		ItemStack itemStack = event.getMaterial();
		if (itemStack == null)
			return;
		//明路脆瓜
		if (itemStack.is(JerotesVillageItems.BRIGHT_MELON.get())) {
			event.setEffectCount(3);
			event.setEffect1(new MagicAbsorptionAlchemyEffect(1, 1));
			event.setEffect2(new SaturationAlchemyEffect(1, 1));
			event.setEffect3(new SpeedAlchemyEffect(1, 1));
		}
		//金明路脆瓜
		if (itemStack.is(JerotesVillageItems.GOLDEN_BRIGHT_MELON.get())) {
			event.setEffectCount(3);
			event.setEffect1(new MagicAbsorptionAlchemyEffect(2, 2));
			event.setEffect2(new SaturationAlchemyEffect(2, 1));
			event.setEffect3(new AbsorptionAlchemyEffect(1, 1));
		}
		//二轮龙葵
		if (itemStack.is(JerotesVillageItems.SECOND_ROUND_NIGRUM.get())) {
			event.setEffectCount(3);
			event.setEffect1(new PoisonAlchemyEffect(1, 1));
			event.setEffect2(new BlindnessAlchemyEffect(1, 2));
			event.setEffect3(new HasteAlchemyEffect(2, 1));
		}
		//冰岩
		if (itemStack.is(JerotesVillageItems.ICE_ROCK.get())) {
			event.setEffectCount(3);
			event.setEffect1(new SlownessAlchemyEffect(2, 1));
			event.setEffect2(new FreezeAbsorptionAlchemyEffect(2, 1));
			event.setEffect3(new MiningFatigueAlchemyEffect(2, 2));
		}
		//鳞熊毛 巨怪毛 巨怪角
		if (itemStack.is(JerotesVillageItems.GIANT_MONSTER_HAIR.get())  || itemStack.is(JerotesVillageItems.GIANT_MONSTER_HORN.get())) {
			event.setEffectCount(3);
			event.setEffect1(new FreezeAbsorptionAlchemyEffect(1, 2));
			event.setEffect2(new WeaknessAlchemyEffect(2, 2));
			event.setEffect3(new NauseaAlchemyEffect(1, 1));
		}
		//恶鳞鳞片 恶鳞牙齿
		if (itemStack.is(JerotesVillageItems.MALIGNASAUR_TEETH.get())) {
			event.setEffectCount(3);
			event.setEffect1(new WaterBreathingAlchemyEffect(1, 2));
			event.setEffect2(new DolphinsGraceAlchemyEffect(2, 1));
			event.setEffect3(new SpeedAlchemyEffect(1, 2));
		}
	}
}