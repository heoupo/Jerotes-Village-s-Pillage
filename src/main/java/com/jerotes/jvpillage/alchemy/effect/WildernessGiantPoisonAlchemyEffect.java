package com.jerotes.jvpillage.alchemy.effect;

import com.jerotes.jerotes.alchemy.effect.AAAAlchemyEffect;
import com.jerotes.jvpillage.init.JVPillageMobEffects;
import net.minecraft.world.effect.MobEffect;

public class WildernessGiantPoisonAlchemyEffect extends AAAAlchemyEffect {
    public WildernessGiantPoisonAlchemyEffect(int level, int time) {
        super(level, time);
    }

    public MobEffect getMobEffect() {
        return JVPillageMobEffects.WILDERNESS_GIANT_POISON.get();
    }

    public String getName() {
        return "jerotesvillage_wilderness_giant_poison";
    }
}