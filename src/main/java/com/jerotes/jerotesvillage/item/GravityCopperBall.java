package com.jerotes.jerotesvillage.item;

import com.jerotes.jerotes.init.JerotesGameRules;
import com.jerotes.jerotes.item.Interface.MagicItem;
import com.jerotes.jerotes.spell.SpellTypeInterface;
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

public class GravityCopperBall extends Item implements MagicItem {
	public GravityCopperBall() {
		super(new Properties().stacksTo(1).durability(800).rarity(Rarity.UNCOMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemStack) {
		return UseAnim.BLOCK;
	}

	@Override
	public boolean isValidRepairItem(ItemStack itemStack, ItemStack itemStack2) {
		return itemStack2.is(Items.COPPER_INGOT) || super.isValidRepairItem(itemStack, itemStack2);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
		ItemStack itemStack = player.getItemInHand(interactionHand);
		player.swing(interactionHand);
		if (itemStack.getDamageValue() >= itemStack.getMaxDamage() - 1) {
			return InteractionResultHolder.fail(itemStack);
		}
		player.startUsingItem(interactionHand);
		if(!player.isShiftKeyDown()) {
			OtherSpellList.PushForce(3, player, null).spellUse();
			player.getCooldowns().addCooldown(this, 20);
		}
		if(player.isShiftKeyDown()) {
            if (interactionHand == InteractionHand.MAIN_HAND) {
                OtherSpellList.FloatingForce(3, player, null).spellUse();
                player.getCooldowns().addCooldown(this, 160);
            }
            if (interactionHand == InteractionHand.OFF_HAND) {
                OtherSpellList.GravityForce(3, player, null).spellUse();
                player.getCooldowns().addCooldown(this, 160);
            }
		}
		damageMagicItem(player, itemStack);
			return InteractionResultHolder.consume(itemStack);
	}


	@Override
	public void appendHoverText(ItemStack itemStack, Level level, List<Component> list, TooltipFlag tooltipFlag) {
		super.appendHoverText(itemStack, level, list, tooltipFlag);
		list.add(OtherSpellList.PushForce(2, null, null).getSpellName().copy()
				.append(Component.translatable("spell.jerotes.spell_base", trueLevel(itemStack))).withStyle(ChatFormatting.DARK_PURPLE));
		list.add(OtherSpellList.PushForce(2, null, null).getSpellDesc().copy()
				.withStyle(ChatFormatting.LIGHT_PURPLE));
		list.add(Component.translatable("spell.jerotes.spell_max_distance", OtherSpellList.PushForce(3, null, null).getSpellDistance())
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
		return OtherSpellList.PushForce(3, null, null).getSpellLevel();
	}

	@Override
	public List<SpellTypeInterface> getMainSpellType(ItemStack itemStack) {
		List<SpellTypeInterface> spellList = new ArrayList<>();
		spellList.add(OtherSpellType.JEROTESVILLAGE_PUSH_FORCE);
		return spellList;
	}
	@Override
	public List<SpellTypeInterface> getAddSpellType(ItemStack itemStack) {
		return new ArrayList<>();
	}

	@Override
	public int getSpellLevel(ItemStack itemStack) {
		return 3;
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


