package com.jerotes.jvpillage.init;

import com.jerotes.jvpillage.client.model.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class JVPillageModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {

		event.registerLayerDefinition(Modelhumanoid.LAYER_LOCATION, Modelhumanoid::createBodyLayer);
		event.registerLayerDefinition(Modelhumanoid_wide_or_slim.LAYER_LOCATION, Modelhumanoid_wide_or_slim::createBodyLayer);
		event.registerLayerDefinition(Modelbanner_bearer.LAYER_LOCATION, Modelbanner_bearer::createBodyLayer);
		event.registerLayerDefinition(Modelblaster.LAYER_LOCATION, Modelblaster::createBodyLayer);
		event.registerLayerDefinition(Modeltrumpeter.LAYER_LOCATION, Modeltrumpeter::createBodyLayer);
		event.registerLayerDefinition(Modelhorned_armor.LAYER_LOCATION, Modelhorned_armor::createBodyLayer);
		event.registerLayerDefinition(Modelcycloner.LAYER_LOCATION, Modelcycloner::createBodyLayer);
		event.registerLayerDefinition(Modelominous_bomb.LAYER_LOCATION, Modelominous_bomb::createBodyLayer);
		event.registerLayerDefinition(Modeljavelin.LAYER_LOCATION, Modeljavelin::createBodyLayer);
		event.registerLayerDefinition(Modeljavelin_thrower.LAYER_LOCATION, Modeljavelin_thrower::createBodyLayer);
		event.registerLayerDefinition(Modelbitter_cold_sorcerer.LAYER_LOCATION, Modelbitter_cold_sorcerer::createBodyLayer);
		event.registerLayerDefinition(Modelice_spike.LAYER_LOCATION, Modelice_spike::createBodyLayer);
		event.registerLayerDefinition(Modelbitter_cold_altar.LAYER_LOCATION, Modelbitter_cold_altar::createBodyLayer);
		event.registerLayerDefinition(Modelfire_spitter.LAYER_LOCATION, Modelfire_spitter::createBodyLayer);
		event.registerLayerDefinition(Modelwild_finder.LAYER_LOCATION, Modelwild_finder::createBodyLayer);
		event.registerLayerDefinition(Modelsubmariner.LAYER_LOCATION, Modelsubmariner::createBodyLayer);
		event.registerLayerDefinition(Modellamp_wizard.LAYER_LOCATION, Modellamp_wizard::createBodyLayer);
		event.registerLayerDefinition(Modelslavery_supervisor.LAYER_LOCATION, Modelslavery_supervisor::createBodyLayer);
		event.registerLayerDefinition(Modelanimated_chain.LAYER_LOCATION, Modelanimated_chain::createBodyLayer);
		event.registerLayerDefinition(Modelfirepower_pourer.LAYER_LOCATION, Modelfirepower_pourer::createBodyLayer);
		event.registerLayerDefinition(Modelnecromancy_warlock.LAYER_LOCATION, Modelnecromancy_warlock::createBodyLayer);
		event.registerLayerDefinition(Modelominous_gear.LAYER_LOCATION, Modelominous_gear::createBodyLayer);
		event.registerLayerDefinition(Modelunclean_tentacle.LAYER_LOCATION, Modelunclean_tentacle::createBodyLayer);
		event.registerLayerDefinition(Modelgaviler.LAYER_LOCATION, Modelgaviler::createBodyLayer);
		event.registerLayerDefinition(Modelax_crazy.LAYER_LOCATION, Modelax_crazy::createBodyLayer);
		event.registerLayerDefinition(Modelominous_banner_projection.LAYER_LOCATION, Modelominous_banner_projection::createBodyLayer);
		event.registerLayerDefinition(Modelgiant_monster.LAYER_LOCATION, Modelgiant_monster::createBodyLayer);
		event.registerLayerDefinition(Modelgiant_monster_armor.LAYER_LOCATION, Modelgiant_monster_armor::createBodyLayer);
		event.registerLayerDefinition(Modelblock.LAYER_LOCATION, Modelblock::createBodyLayer);
		event.registerLayerDefinition(Modelbig_witchs_hat.LAYER_LOCATION, Modelbig_witchs_hat::createBodyLayer);
		event.registerLayerDefinition(Modelrotten_dog.LAYER_LOCATION, Modelrotten_dog::createBodyLayer);
		event.registerLayerDefinition(Modelhag.LAYER_LOCATION, Modelhag::createBodyLayer);
		event.registerLayerDefinition(Modelgemstone_throwing_knives.LAYER_LOCATION, Modelgemstone_throwing_knives::createBodyLayer);
		event.registerLayerDefinition(Modelillager.LAYER_LOCATION, Modelillager::createBodyLayer);
		event.registerLayerDefinition(Modelexecutioner.LAYER_LOCATION, Modelexecutioner::createBodyLayer);
	}
}
