package com.jerotes.jvpillage.item;

import com.jerotes.jvpillage.entity.Shoot.ThrowingBall.BaseThrowingBallEntity;
import com.jerotes.jvpillage.entity.Shoot.ThrowingBall.RottenBrightMelonEntity;
import com.jerotes.jvpillage.item.Tool.ItemToolBaseThrowingBall;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class RottenBrightMelon extends ItemToolBaseThrowingBall {
	public RottenBrightMelon() {
		super(new Properties().stacksTo(64).rarity(Rarity.COMMON), 1, 1, 2);
	}

	@Override
	public BaseThrowingBallEntity throwingBall(Level level, LivingEntity livingEntity) {
		return new RottenBrightMelonEntity(level, livingEntity);
	}
}
