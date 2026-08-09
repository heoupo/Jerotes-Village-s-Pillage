package com.jerotes.jvpillage.item;

import com.jerotes.jerotes.util.Main;
import com.jerotes.jvpillage.init.JVPillageSoundEvents;
import com.jerotes.jvpillage.spell.OtherSpellList;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class DevouringAxeAliveColloid extends Item {
    public DevouringAxeAliveColloid() {
        super(new Properties().stacksTo(1).rarity(Rarity.RARE));
    }
    @Override
    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.BLOCK;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        player.swing(interactionHand);
        LivingEntity target;
        Entity hitEntity = Main.getTargetedEntity(player, OtherSpellList.CohesionSlideAxe(9, null, null).getSpellDistance());
        if (hitEntity instanceof LivingEntity) {
            target = (LivingEntity) hitEntity;
        } else {
            target = player;
        }
        player.startUsingItem(interactionHand);
        boolean spell = OtherSpellList.CohesionSlideAxe(9, player, target).spellUse();
        if (spell) {
        player.getCooldowns().addCooldown(this, 3600);
        player.level().playSound(null, player, JVPillageSoundEvents.SLIDER_AMBIENT, player.getSoundSource(), 1.0f, 1.0f);
        if (!player.getAbilities().instabuild) {
            itemStack.shrink(1);
        }
        }
        return InteractionResultHolder.consume(itemStack);
    }
    @Override
    public void appendHoverText(ItemStack itemStack, Level level, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, level, list, tooltipFlag);
        list.add(OtherSpellList.CohesionSlideAxe(9, null, null).getSpellName().copy()
                .append(Component.translatable("spell.jerotes.spell_base", trueLevel(itemStack))).withStyle(ChatFormatting.DARK_PURPLE));
        list.add(OtherSpellList.CohesionSlideAxe(9, null, null).getSpellDesc().copy()
                .withStyle(ChatFormatting.LIGHT_PURPLE));
        list.add(Component.translatable("spell.jerotes.spell_max_distance", OtherSpellList.CohesionSlideAxe(9, null, null).getSpellDistance())
                .withStyle(ChatFormatting.LIGHT_PURPLE));
        list.add(this.getDisplayName().withStyle(ChatFormatting.GRAY));
    }

    public int trueLevel(ItemStack itemStack) {
        return OtherSpellList.CohesionSlideAxe(9, null, null).getSpellLevel();
    }

    public MutableComponent getDisplayName() {
        return Component.translatable(this.getDescriptionId() + ".desc");
    }
}
