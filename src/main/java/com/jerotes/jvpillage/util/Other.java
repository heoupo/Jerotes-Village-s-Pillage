package com.jerotes.jvpillage.util;

import com.jerotes.jvpillage.config.OtherMainConfig;
import com.jerotes.jvpillage.item.HagEye;
import com.jerotes.jvpillage.item.PurpleSandHagEye;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public class Other {

	//其他类型观察
	public static boolean isOtherScoping(LivingEntity player) {
		Minecraft minecraft = Minecraft.getInstance();
		return ((player.isUsingItem() &&
				(player.getUseItem().getItem() instanceof HagEye
						|| player.getUseItem().getItem() instanceof PurpleSandHagEye && minecraft.options.getCameraType().isFirstPerson())));
	}
	//袭击Boss数量
	public static int getRaidBossCount(LivingEntity boss) {
		if (OtherMainConfig.RaidBossCanIncreaseSummonCountBasedOnPlayerCount
				&& (OtherMainConfig.RaidBossCanIncreaseSummonCountBasedOnPlayerCountContainAllBoss
				|| OtherMainConfig.RaidBossCanIncreaseSummonCountBasedOnPlayerCountContainBoss.contains(boss.getEncodeId()))) {
			double reach = OtherMainConfig.RaidBossCanIncreaseSummonCountBasedOnPlayerCountFindReach;
			List<Player> listTeam = boss.level().getEntitiesOfClass(Player.class, boss.getBoundingBox().inflate(reach, reach, reach));
			if (listTeam.isEmpty()) {
				return 1;
			}
			else return Math.min(listTeam.size(), OtherMainConfig.RaidBossCanIncreaseSummonCountBasedOnPlayerCountMaxCount);
		}
		return 1;
	}
}