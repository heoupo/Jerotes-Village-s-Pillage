package com.jerotes.jerotesvillage.init;

import com.jerotes.jerotes.init.JerotesMobEffects;
import com.jerotes.jerotesvillage.JerotesVillage;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class JerotesVillagePotions {
    public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, JerotesVillage.MODID);

    public static final RegistryObject<Potion> BIG_WITCH_HEAL = REGISTRY.register("big_witch_heal", () -> new Potion(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 1), new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0), new MobEffectInstance(MobEffects.HEALTH_BOOST, 600, 4), new MobEffectInstance(MobEffects.REGENERATION, 600, 1)));
    public static final RegistryObject<Potion> BIG_WITCH_HURT = REGISTRY.register("big_witch_hurt", () -> new Potion(new MobEffectInstance(MobEffects.POISON, 600, 1), new MobEffectInstance(MobEffects.BLINDNESS, 600, 0), new MobEffectInstance(MobEffects.UNLUCK, 600, 2), new MobEffectInstance(MobEffects.HARM, 1, 1)));
    //鬼婆系列
    public static final RegistryObject<Potion> LOVES_SHAME = REGISTRY.register("loves_shame", () -> new Potion(
            new MobEffectInstance(JerotesMobEffects.CORROSIVE.get(), 12 * 20, 0),
            new MobEffectInstance(MobEffects.REGENERATION, 12 * 20, 1),
            new MobEffectInstance(MobEffects.POISON, 12 * 20, 0),
            new MobEffectInstance(MobEffects.HEAL, 1, 1),
            new MobEffectInstance(JerotesMobEffects.PRURITUS.get(), 12 * 20, 1)
    ));
    public static final RegistryObject<Potion> WITCH_ROT = REGISTRY.register("witch_rot", () -> new Potion(
            new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 30 * 20, 0),
            new MobEffectInstance(MobEffects.DAMAGE_BOOST, 30 * 20, 0),
            new MobEffectInstance(MobEffects.UNLUCK, 60 * 20, 0),
            new MobEffectInstance(JerotesMobEffects.MAGIC_ABSORPTION.get(), 30 * 20, 0),
            new MobEffectInstance(JerotesVillageMobEffects.FRAGRANCE.get(), 12 * 20, 1)
    ));
    public static final RegistryObject<Potion> UNEASY_RABBIT = REGISTRY.register("uneasy_rabbit", () -> new Potion(
            new MobEffectInstance(MobEffects.SLOW_FALLING, 90 * 20, 0),
            new MobEffectInstance(MobEffects.JUMP, 90 * 20, 1),
            new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 90 * 20, 1),
            new MobEffectInstance(MobEffects.WEAKNESS, 90 * 20, 1)
    ));
    public static final RegistryObject<Potion> WITHER_SLEEP = REGISTRY.register("wither_sleep", () -> new Potion(
            new MobEffectInstance(MobEffects.WITHER, 120 * 20, 1),
            new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120 * 20, 0),
            new MobEffectInstance(MobEffects.HARM, 1, 2)
    ));
    public static final RegistryObject<Potion> VOMIT_INDUCER = REGISTRY.register("vomit_inducer", () -> new Potion(
            new MobEffectInstance(MobEffects.CONFUSION, 60 * 20, 0),
            new MobEffectInstance(MobEffects.HUNGER, 60 * 20, 0),
            new MobEffectInstance(MobEffects.WATER_BREATHING, 60 * 20, 0)
    ));
    public static final RegistryObject<Potion> LICH_CURSE = REGISTRY.register("lich_curse", () -> new Potion(
            new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120 * 20, 0),
            new MobEffectInstance(MobEffects.HEAL, 1, 2)
    ));
    public static final RegistryObject<Potion> LAST_STAND = REGISTRY.register("last_stand", () -> new Potion(
            new MobEffectInstance(JerotesVillageMobEffects.LAST_DITCH.get(), 120 * 20, 0)
    ));
    public static final RegistryObject<Potion> TROLL_TONGUE = REGISTRY.register("troll_tongue", () -> new Potion(
            new MobEffectInstance(MobEffects.REGENERATION, 120 * 20, 3),
            new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120 * 20, 3),
            new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 120 * 20, 3)
    ));
    public static final RegistryObject<Potion> HAUNTING_IMP = REGISTRY.register("haunting_imp", () -> new Potion(
            new MobEffectInstance(MobEffects.INVISIBILITY, 120 * 20, 0),
            new MobEffectInstance(MobEffects.NIGHT_VISION, 120 * 20, 0),
            new MobEffectInstance(JerotesVillageMobEffects.RAMPANT.get(), 120 * 20, 0)
    ));
    public static final RegistryObject<Potion> PURPLE_SANDS_SECRET = REGISTRY.register("purple_sands_secret", () -> new Potion(
            new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 1200 * 20, 0),
            new MobEffectInstance(MobEffects.HARM, 1, 4),
            new MobEffectInstance(MobEffects.HEAL, 1, 4)
    ));
    public static final RegistryObject<Potion> SERPENT_SCALE = REGISTRY.register("serpent_scale", () -> new Potion(
            new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 240 * 20, 1),
            new MobEffectInstance(MobEffects.LEVITATION, 24 * 20, 0),
            new MobEffectInstance(JerotesMobEffects.BLEEDING.get(), 24 * 20, 2)
    ));
    public static final RegistryObject<Potion> DESPICABLE_MEROR = REGISTRY.register("despicable_meror", () -> new Potion(
            new MobEffectInstance(JerotesVillageMobEffects.MEROR_STIMULIN.get(), 24 * 20, 1),
            new MobEffectInstance(JerotesVillageMobEffects.WILDERNESS_GIANT_POISON.get(), 24 * 20, 0)
    ));
    public static final RegistryObject<Potion> SEA_MONSTER_WORSHIP = REGISTRY.register("sea_monster_worship", () -> new Potion(
            new MobEffectInstance(JerotesVillageMobEffects.MALIGNASAUR_ASPHYXIA.get(), 24 * 20, 0),
            new MobEffectInstance(JerotesVillageMobEffects.OCEAN_DRAGON_DETERRENCE.get(), 24 * 20, 0)
    ));
    public static final RegistryObject<Potion> DARK_HEART = REGISTRY.register("dark_heart", () -> new Potion(
            new MobEffectInstance(JerotesMobEffects.ABACK.get(), 240 * 20, 1),
            new MobEffectInstance(MobEffects.DARKNESS, 240 * 20, 0)
    ));
    public static final RegistryObject<Potion> BINDING_PACT = REGISTRY.register("binding_pact", () -> new Potion(
            new MobEffectInstance(JerotesVillageMobEffects.FAIRNESS.get(), 5 * 20, 0)
    ));
}
