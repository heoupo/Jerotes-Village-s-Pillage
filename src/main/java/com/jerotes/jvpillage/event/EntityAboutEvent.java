package com.jerotes.jvpillage.event;

import com.jerotes.jerotes.util.Main;
import com.jerotes.jvpillage.JVPillage;
import com.jerotes.jvpillage.entity.Interface.GoastEntity;
import com.jerotes.jvpillage.entity.Monster.IllagerFaction.MeleeIllagerEntity;
import com.jerotes.jvpillage.entity.Monster.IllagerFaction.SpellIllagerEntity;
import com.jerotes.jvpillage.entity.Monster.SpirveEntity;
import com.jerotes.jvpillage.goal.FollowFragranceGoal;
import com.jerotes.jvpillage.init.JVPillageItems;
import com.jerotes.jvpillage.util.OtherEntityFactionFind;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JVPillage.MODID)
public class EntityAboutEvent {


	//发现
	@SubscribeEvent
	public static void HeadVisibility(LivingEvent.LivingVisibilityEvent event) {
		LivingEntity self = event.getEntity();
		Entity lookingEntity = event.getLookingEntity();
		if (lookingEntity == null || self == null)
			return;
		{
			ItemStack itemstack = self.getItemBySlot(EquipmentSlot.HEAD);
			//EntityType<?> entitytype = lookingEntity.getType();

			if (lookingEntity instanceof SpirveEntity && itemstack.is(JVPillageItems.SPIRVE_HEAD.get())
					|| lookingEntity instanceof LivingEntity livingEntity && OtherEntityFactionFind.isFactionPiglinResidentDetachment(livingEntity) && itemstack.is(Items.PIGLIN_HEAD)
			) {
				event.modifyVisibility(0.5);
			}
		}
	}
	@SubscribeEvent
	public static void OtherVisibility(LivingEvent.LivingVisibilityEvent event) {
		LivingEntity self = event.getEntity();
		Entity lookingEntity = event.getLookingEntity();
		if (lookingEntity == null || self == null)
			return;
		{
			if ((lookingEntity instanceof SpellIllagerEntity spellIllagerEntity && spellIllagerEntity.teleportCooldown > 0
			|| lookingEntity instanceof MeleeIllagerEntity meleeIllagerEntity && meleeIllagerEntity.teleportCooldown > 0) && self.getMainHandItem().is(JVPillageItems.OMINOUS_PROBE.get()))
			 {
				event.modifyVisibility(0.15);
			}
		}
	}



	@SubscribeEvent
	public static void AddGoal(EntityJoinLevelEvent event) {
		Entity entity = event.getEntity();
		if (entity instanceof Animal animal) {
			animal.goalSelector.addGoal(2, new FollowFragranceGoal(animal, 1.2));
		}
	}

	//计时
	@SubscribeEvent
	public static void Tick(LivingEvent.LivingTickEvent event) {
		LivingEntity entity = event.getEntity();
		if (entity == null || !entity.isAlive())
			return;
		if (entity instanceof GoastEntity goastEntity && goastEntity.isGoast()) {
			entity.clearFire();
		}
		if (entity.getPersistentData().getDouble("jerotesvillage_variant_zsiein_discard") > 0) {
			entity.getPersistentData().putDouble("jerotesvillage_variant_zsiein_discard", entity.getPersistentData().getDouble("jerotesvillage_variant_zsiein_discard") - 1);
		}
		if (entity.getPersistentData().getDouble("jerotesvillage_bright_land_heart") > 0) {
			entity.getPersistentData().putDouble("jerotesvillage_bright_land_heart", entity.getPersistentData().getDouble("jerotesvillage_bright_land_heart") - 1);
		}
        //计时
		Main.persistentDataDoubleReduceToZero(entity, "jerotesvillage_mountain_realm_flag_spear", true);
	}
}