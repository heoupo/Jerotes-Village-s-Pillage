package com.jerotes.jvpillage.util;

import com.jerotes.jvpillage.event.AdvancementEvent;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

public class BossSpawn {
	//中期boss限制
	public static boolean ChallengeMiddleBoss(ServerPlayer player) {
		boolean purpleSandHag = AdvancementEvent.AdvancementDone(player, "jvpillage:want_to_escape");
		return  purpleSandHag;
	}

	public static void OminousBannerProjection(Player player) {
		player.sendSystemMessage(Component.translatable("boss.jvpillage.ominous_banner_projection", player.getDisplayName()).withStyle(ChatFormatting.DARK_RED));
	}
	public static void PurpleSandHag(Player player) {
		player.sendSystemMessage(Component.translatable("boss.jvpillage.purple_sand_hag", player.getDisplayName()).withStyle(ChatFormatting.LIGHT_PURPLE));
	}

}
