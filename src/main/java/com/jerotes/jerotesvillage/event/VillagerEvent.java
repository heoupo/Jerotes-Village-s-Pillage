package com.jerotes.jerotesvillage.event;

import com.jerotes.jerotes.entity.Mob.AddHandEntity;
import com.jerotes.jerotes.goal.JerotesMeleeAttackGoal;
import com.jerotes.jerotes.goal.JerotesPlayerTargetGoal;
import com.jerotes.jerotes.util.AttackFind;
import com.jerotes.jerotes.util.Main;
import com.jerotes.jerotesvillage.JerotesVillage;
import com.jerotes.jerotesvillage.entity.Animal.RottenDogEntity;
import com.jerotes.jerotesvillage.entity.Boss.OminousBannerProjectionEntity;
import com.jerotes.jerotesvillage.entity.Monster.Hag.BaseHagEntity;
import com.jerotes.jerotesvillage.entity.Monster.IllagerFaction.FirepowerPourerEntity;
import com.jerotes.jerotesvillage.entity.Monster.IllagerFaction.MeleeIllagerEntity;
import com.jerotes.jerotesvillage.entity.Monster.IllagerFaction.SpellIllagerEntity;
import com.jerotes.jerotesvillage.entity.Monster.SpirveEntity;
import com.jerotes.jerotesvillage.util.OtherEntityFactionFind;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerData;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = JerotesVillage.MODID)
public class VillagerEvent {

	@SubscribeEvent
	public static void VillagerGoal(EntityJoinLevelEvent event) {
		Entity entity = event.getEntity();
		if (!(entity.getType() == EntityType.VILLAGER || entity.getType() == EntityType.WANDERING_TRADER))
			return;
        if (entity instanceof Villager villager) {
		 {
				Conscription(villager, villager.getVillagerData());
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
		villager.goalSelector.addGoal(1, new AvoidEntityGoal<>(villager, FirepowerPourerEntity.class, 8.0F, 0.8D, 0.8D));
		villager.goalSelector.addGoal(1, new AvoidEntityGoal<>(villager, OminousBannerProjectionEntity.class, 8.0F, 0.8D, 0.8D));
	}
	public static void VillagerRemoveGoal(AbstractVillager villager) {
		villager.goalSelector.removeAllGoals(goal -> goal instanceof PanicGoal);
		villager.goalSelector.removeAllGoals(goal -> goal instanceof AvoidEntityGoal<?>);

		villager.goalSelector.removeGoal(new AvoidEntityGoal<>(villager, MeleeIllagerEntity.class, 8.0F, 0.6D, 0.6D));
		villager.goalSelector.removeGoal(new AvoidEntityGoal<>(villager, SpellIllagerEntity.class, 8.0F, 0.8D, 0.8D));
		villager.goalSelector.removeGoal(new AvoidEntityGoal<>(villager, SpirveEntity.class, 8.0F, 0.8D, 0.8D));
		villager.goalSelector.removeGoal(new AvoidEntityGoal<>(villager, RottenDogEntity.class, 8.0F, 0.8D, 0.8D));
		villager.goalSelector.removeGoal(new AvoidEntityGoal<>(villager, BaseHagEntity.class, 8.0F, 0.8D, 0.8D));
		villager.goalSelector.removeGoal(new AvoidEntityGoal<>(villager, FirepowerPourerEntity.class, 8.0F, 0.8D, 0.8D));
		villager.goalSelector.removeGoal(new AvoidEntityGoal<>(villager, OminousBannerProjectionEntity.class, 8.0F, 0.8D, 0.8D));
	}

	public static void Conscription(AbstractVillager villager, VillagerData villagerData) {
		villager.goalSelector.addGoal(0, new ConscriptionMeleeAttackGoal(villager));
		villager.goalSelector.addGoal(0, new ConscriptionMoveTowardsTargetGoal(villager));
		villager.targetSelector.addGoal(0, new ConscriptionHurtByTargetGoal(villager));
		villager.targetSelector.addGoal(1, new JerotesPlayerTargetGoal<Mob>(villager, Mob.class, false));
		VillagerRemoveGoal(villager);

		if (villager.getAttributeBaseValue(Attributes.ARMOR) < (4 + villagerData.getLevel() * 2)) {
			Objects.requireNonNull(villager.getAttribute(Attributes.ARMOR)).setBaseValue(4 + villagerData.getLevel() * 2);
		}
		if (villager.getAttributeBaseValue(Attributes.MAX_HEALTH) < (20 + villagerData.getLevel() * 4)) {
			Objects.requireNonNull(villager.getAttribute(Attributes.MAX_HEALTH)).setBaseValue((20 + villagerData.getLevel() * 4));
		}
	}

	public static class ConscriptionMeleeAttackGoal extends JerotesMeleeAttackGoal {
		private final AbstractVillager mob;
		public ConscriptionMeleeAttackGoal(AbstractVillager mob) {
			super(mob, 1.1, true);
			this.mob = mob;
		}
		@Override
		protected void checkAndPerformAttack(LivingEntity livingEntity) {
			if (this.canPerformAttack(livingEntity)) {
				this.resetAttackCooldown();
				this.mob.swing(InteractionHand.MAIN_HAND);
				doHurtTarget(this.mob, livingEntity);
			}
		}
		public boolean doHurtTarget(AbstractVillager villager, Entity entity) {
			if (villager instanceof Villager villager1) {
                AddHandEntity addHandEntity = Main.spawnAddHand(villager, 6, 100);
				float f = villager1.getVillagerData().getLevel() * 2;
				AttackFind.attackBegin(villager, entity);
				boolean bl = AttackFind.attackAfter(villager1, entity, 0, 0.2f, true, f + 6);
				if (bl) {
					if (!villager1.isSilent()) {
						villager1.playSound(SoundEvents.PLAYER_ATTACK_SWEEP, 1.0f, 1.0f);
					}
				}
				if (!entity.isAlive()) {
					villager.setTarget(null);
				}
				return bl;
			}
			return false;
		}
	}
	public static class ConscriptionMoveTowardsTargetGoal extends MoveTowardsTargetGoal {
		private final AbstractVillager mob;
		public ConscriptionMoveTowardsTargetGoal(AbstractVillager mob) {
			super(mob, 1.0, 32.0f);
			this.mob = mob;
		}
	}
	public static class ConscriptionHurtByTargetGoal extends HurtByTargetGoal {
		private final AbstractVillager mob;
		public ConscriptionHurtByTargetGoal(AbstractVillager mob) {
			super(mob);
			this.mob = mob;
		}

		public boolean canUse() {
			if (this.mob.getLastHurtByMob() != null && OtherEntityFactionFind.isCarved(this.mob.getLastHurtByMob().getType()) && this.mob.getTeam() == null && this.mob.getLastHurtByMob().getTeam() == null) {
				return false;
			}
			return super.canUse();
		}
	}
}

