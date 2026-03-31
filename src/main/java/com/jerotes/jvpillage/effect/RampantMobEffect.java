package com.jerotes.jvpillage.effect;

import com.jerotes.jerotes.effect.*;
import net.minecraft.world.effect.MobEffectCategory;

public class RampantMobEffect extends BaseMobEffect {
	public RampantMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -2101265);
	}

	@Override
	public String getDescriptionId() {
		return "effect.jvpillage.rampant";
	}
}
