package com.jerotes.jvpillage.init;

import com.jerotes.jerotes.init.JerotesMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class JVPillageFoods {
    public static final FoodProperties SECOND_ROUND_NIGRUM = new FoodProperties.Builder().nutrition(2).saturationMod(0.1f).effect(new MobEffectInstance(MobEffects.POISON, 200, 0), 0.1f).build();
    public static final FoodProperties COOKED_SECOND_ROUND_NIGRUM = new FoodProperties.Builder().nutrition(4).saturationMod(0.4f).build();
    public static final FoodProperties SECOND_ROUND_NIGRUM_SOUP = new FoodProperties.Builder().nutrition(8).saturationMod(2.4f).build();
    public static final FoodProperties BRIGHT_MELON = new FoodProperties.Builder().nutrition(4).saturationMod(0.3f).build();
    public static final FoodProperties GOLDEN_BRIGHT_MELON = new FoodProperties.Builder().nutrition(8).saturationMod(1.2f).alwaysEat().effect(new MobEffectInstance(JerotesMobEffects.MAGIC_ABSORPTION.get(), 2400, 0), 1.0f).effect(new MobEffectInstance(MobEffects.SATURATION, 10, 0), 1.0f).build();
    public static final FoodProperties HERO_SOUP = new FoodProperties.Builder().nutrition(8).saturationMod(2.4f).alwaysEat().effect(new MobEffectInstance(JVPillageMobEffects.ABUNDANT_COURAGE.get(), 18000, 0), 1.0f).build();
    public static final FoodProperties PURPLE_SANDWICH = new FoodProperties.Builder().nutrition(6).saturationMod(1.2f).build();
    public static final FoodProperties IMMORTAL_BREW = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).alwaysEat().build();
}
