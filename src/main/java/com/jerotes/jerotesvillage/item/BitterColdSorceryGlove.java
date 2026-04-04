package com.jerotes.jerotesvillage.item;

import com.jerotes.jerotes.init.JerotesGameRules;
import com.jerotes.jerotes.item.Interface.MagicItem;
import com.jerotes.jerotes.spell.SpellTypeInterface;
import com.jerotes.jerotesvillage.entity.Other.BitterColdAltarEntity;
import com.jerotes.jerotesvillage.init.JerotesVillageItems;
import com.jerotes.jerotesvillage.spell.OtherSpellList;
import com.jerotes.jerotesvillage.spell.OtherSpellType;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;

public class BitterColdSorceryGlove extends Item implements MagicItem {
	public BitterColdSorceryGlove() {
		super(new Properties().stacksTo(1).durability(800).rarity(Rarity.UNCOMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemStack) {
		return UseAnim.BLOCK;
	}

	@Override
	public boolean isValidRepairItem(ItemStack itemStack, ItemStack itemStack2) {
		return itemStack2.is(JerotesVillageItems.GIANT_MONSTER_HAIR.get()) || super.isValidRepairItem(itemStack, itemStack2);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
		ItemStack itemStack = player.getItemInHand(interactionHand);
		player.swing(interactionHand);
		//苦寒祭坛的法术等级控制
		int spelllevel = 2 ;
		List<BitterColdAltarEntity> listAltar = player.level().getEntitiesOfClass(BitterColdAltarEntity.class, player.getBoundingBox().inflate(32.0, 32.0, 32.0));
		listAltar.removeIf(entity -> entity.getTarget() == player || !((player.getTeam() == null && entity.getTeam() == null) || (entity.isAlliedTo(player))));
		if (!listAltar.isEmpty()) {
			spelllevel = 3;
		}
		if (itemStack.getDamageValue() >= itemStack.getMaxDamage() - 1) {
			return InteractionResultHolder.fail(itemStack);
		}
		player.startUsingItem(interactionHand);
		if(player.isShiftKeyDown()) {
			OtherSpellList.BitterColdAltar(spelllevel, player, null).spellUse();
			player.getCooldowns().addCooldown(this, 100);
		}
		if(!player.isShiftKeyDown()) {
			if (interactionHand == InteractionHand.MAIN_HAND) {
				OtherSpellList.BitterColdIceSpike(spelllevel, player, null).spellUse();
				player.getCooldowns().addCooldown(this, 20);
			}
			if (interactionHand == InteractionHand.OFF_HAND) {
				OtherSpellList.BitterColdFrostbite(spelllevel, player, null).spellUse();
				player.getCooldowns().addCooldown(this, 20);
			}
		}
		damageMagicItem(player, itemStack);
			return InteractionResultHolder.consume(itemStack);
	}


	@Override
	public void appendHoverText(ItemStack itemStack, Level level, List<Component> list, TooltipFlag tooltipFlag) {
		super.appendHoverText(itemStack, level, list, tooltipFlag);
		list.add(OtherSpellList.BitterColdIceSpike(2, null, null).getSpellName().copy()
				.append(Component.translatable("spell.jerotes.spell_base", trueLevel(itemStack))).withStyle(ChatFormatting.DARK_PURPLE));
		list.add(OtherSpellList.BitterColdIceSpike(2, null, null).getSpellDesc().copy()
				.withStyle(ChatFormatting.LIGHT_PURPLE));
		list.add(Component.translatable("spell.jerotes.spell_max_distance", OtherSpellList.BitterColdIceSpike(3, null, null).getSpellDistance())
				.withStyle(ChatFormatting.LIGHT_PURPLE));
		list.add(this.getDisplayName().withStyle(ChatFormatting.GRAY));
	}

	public MutableComponent getDisplayName() {
		return Component.translatable(this.getDescriptionId() + ".desc");
	}

	@Override
	public int getEnchantmentValue() {
		return 15;
	}

	public int trueLevel(ItemStack itemStack) {
		return OtherSpellList.GemstoneWaves(2, null, null).getSpellLevel();
	}

	@Override
	public List<SpellTypeInterface> getMainSpellType(ItemStack itemStack) {
		List<SpellTypeInterface> spellList = new ArrayList<>();
		spellList.add(OtherSpellType.JEROTESVILLAGE_BITTER_COLD_ICE_SPIKE);
		return spellList;
	}
	@Override
	public List<SpellTypeInterface> getAddSpellType(ItemStack itemStack) {
		return new ArrayList<>();
	}

	@Override
	public int getSpellLevel(ItemStack itemStack) {
		return 2;
	}

	@Override
	public boolean isMelee(ItemStack itemStack) {
		return true;
	}
	@Override
	public boolean isHelp(ItemStack itemStack) {
		return false;
	}

	@Override
	public void damageMagicItem(LivingEntity livingEntity, ItemStack itemStack) {
		if (livingEntity instanceof Player player) {
			itemStack.hurtAndBreak(1, player, player2 -> player2.broadcastBreakEvent(livingEntity.getUsedItemHand()));
		}
		else if (JerotesGameRules.JEROTES_MAGIC_CAN_BREAK != null && livingEntity.level().getLevelData().getGameRules().getBoolean(JerotesGameRules.JEROTES_MAGIC_CAN_BREAK)) {
			itemStack.hurtAndBreak(1, livingEntity, player2 -> player2.broadcastBreakEvent(EquipmentSlot.MAINHAND));
		}
	}

	@Override
	public float getSpellDistance(ItemStack itemStack) {
		return OtherSpellList.BitterColdIceSpike(3, null, null).getSpellDistance();
	}
}


