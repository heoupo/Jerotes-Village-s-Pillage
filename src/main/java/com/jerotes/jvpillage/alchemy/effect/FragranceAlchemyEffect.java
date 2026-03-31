package com.jerotes.jvpillage.alchemy.effect;

import com.jerotes.jerotes.alchemy.effect.AAAAlchemyEffect;
import com.jerotes.jvpillage.init.JVPillageMobEffects;
import net.minecraft.world.effect.MobEffect;

public class FragranceAlchemyEffect extends AAAAlchemyEffect {
    public FragranceAlchemyEffect(int level, int time) {
        super(level, time);
    }

    public MobEffect getMobEffect() {
        return JVPillageMobEffects.FRAGRANCE.get();
    }

    public String getName() {
        return "jerotesvillage_fragrance";
    }
}