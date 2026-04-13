package com.jerotes.jerotesvillage.event;

import com.jerotes.jerotesvillage.JerotesVillage;
import com.jerotes.jerotesvillage.entity.Animal.RottenDogEntity;
import com.jerotes.jerotesvillage.entity.Boss.OminousBannerProjectionEntity;
import com.jerotes.jerotesvillage.entity.Monster.Hag.BaseHagEntity;
import com.jerotes.jerotesvillage.entity.Monster.IllagerFaction.FirepowerPourerEntity;
import com.jerotes.jerotesvillage.entity.Monster.IllagerFaction.FuryBlamerNecromancyWarlockEntity;
import com.jerotes.jerotesvillage.entity.Monster.IllagerFaction.MeleeIllagerEntity;
import com.jerotes.jerotesvillage.entity.Monster.IllagerFaction.SpellIllagerEntity;
import com.jerotes.jerotesvillage.entity.Monster.SpirveEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JerotesVillage.MODID)
public class VillagerEvent {

	@SubscribeEvent
	public static void VillagerGoal(EntityJoinLevelEvent event) {
		Entity entity = event.getEntity();
		if (!(entity.getType() == EntityType.VILLAGER || entity.getType() == EntityType.WANDERING_TRADER))
			return;
        if (entity instanceof Villager villager) {
		 {
			 VillagerAddGoal(villager);
			}
        }
        if (entity instanceof WanderingTrader villager) {
			VillagerAddGoal(villager);
        }
	}


	public static void VillagerAddGoal(AbstractVillager villager) {
		villager.goalSelector.addGoal(1, new AvoidEntityGoal<>(villager, MeleeIllagerEntity.class, 8.0F, 0.6D, 0.6D));
		villager.goalSelector.addGoal(1, new AvoidEntityGoal<>(villager, SpellIllagerEntity.class, 8.0F, 0.8D, 0.8D));
		villager.goalSelector.addGoal(1, new AvoidEntityGoal<>(villager, SpirveEntity.class, 8.0F, 0.8D, 0.8D));
		villager.goalSelector.addGoal(1, new AvoidEntityGoal<>(villager, RottenDogEntity.class, 8.0F, 0.8D, 0.8D));
		villager.goalSelector.addGoal(1, new AvoidEntityGoal<>(villager, BaseHagEntity.class, 8.0F, 0.8D, 0.8D));
		villager.goalSelector.addGoal(1, new AvoidEntityGoal<>(villager, FuryBlamerNecromancyWarlockEntity.class, 8.0F, 0.8D, 0.8D));
		villager.goalSelector.addGoal(1, new AvoidEntityGoal<>(villager, FirepowerPourerEntity.class, 8.0F, 0.8D, 0.8D));
		villager.goalSelector.addGoal(1, new AvoidEntityGoal<>(villager, OminousBannerProjectionEntity.class, 8.0F, 0.8D, 0.8D));
	}
}

