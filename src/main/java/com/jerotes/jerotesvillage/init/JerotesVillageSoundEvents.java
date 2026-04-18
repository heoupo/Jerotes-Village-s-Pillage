package com.jerotes.jerotesvillage.init;

import com.jerotes.jerotesvillage.JerotesVillage;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.NewRegistryEvent;

import java.lang.reflect.Field;

@SuppressWarnings("WeakerAccess")
@Mod.EventBusSubscriber(modid = JerotesVillage.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class JerotesVillageSoundEvents {
    public static final SoundEvent SPEAR_MACHINE_ATTACK = createSoundEvent("spear_machine_attack");
    public static final SoundEvent SPEAR_MACHINE_WALK = createSoundEvent("spear_machine_walk");
    public static final SoundEvent SPEAR_MACHINE_DEATH = createSoundEvent("spear_machine_death");
    public static final SoundEvent UNICYCLE_WALK = createSoundEvent("unicycle_walk");
    public static final SoundEvent UNICYCLE_DEATH = createSoundEvent("unicycle_death");
    public static final SoundEvent EXPLORER_AMBIENT = createSoundEvent("explorer_ambient");
    public static final SoundEvent EXPLORER_HURT = createSoundEvent("explorer_hurt");
    public static final SoundEvent EXPLORER_DEATH = createSoundEvent("explorer_death");
    public static final SoundEvent EXPLORER_ATTACK = createSoundEvent("explorer_attack");
    public static final SoundEvent EXPLORER_CHEER = createSoundEvent("explorer_cheer");
    public static final SoundEvent EXPLORER_JUMP = createSoundEvent("explorer_jump");
    public static final SoundEvent EXPLORER_KILL = createSoundEvent("explorer_kill");
    public static final SoundEvent EXPLORER_AOE = createSoundEvent("explorer_aoe");
    public static final SoundEvent EXECUTIONER_AMBIENT = createSoundEvent("executioner_ambient");
    public static final SoundEvent EXECUTIONER_HURT = createSoundEvent("executioner_hurt");
    public static final SoundEvent EXECUTIONER_DEATH = createSoundEvent("executioner_death");
    public static final SoundEvent EXECUTIONER_ATTACK = createSoundEvent("executioner_attack");
    public static final SoundEvent EXECUTIONER_CHEER = createSoundEvent("executioner_cheer");
    public static final SoundEvent MAPMAKER_AMBIENT = createSoundEvent("mapmaker_ambient");
    public static final SoundEvent MAPMAKER_HURT = createSoundEvent("mapmaker_hurt");
    public static final SoundEvent MAPMAKER_DEATH = createSoundEvent("mapmaker_death");
    public static final SoundEvent MAPMAKER_SPELL = createSoundEvent("mapmaker_spell");
    public static final SoundEvent MAPMAKER_CHEER = createSoundEvent("mapmaker_cheer");
    public static final SoundEvent DEFECTOR_AMBIENT = createSoundEvent("defector_ambient");
    public static final SoundEvent DEFECTOR_HURT = createSoundEvent("defector_hurt");
    public static final SoundEvent DEFECTOR_DEATH = createSoundEvent("defector_death");
    public static final SoundEvent BANNER_BEARER_AMBIENT = createSoundEvent("banner_bearer_ambient");
    public static final SoundEvent BANNER_BEARER_HURT = createSoundEvent("banner_bearer_hurt");
    public static final SoundEvent BANNER_BEARER_DEATH = createSoundEvent("banner_bearer_death");
    public static final SoundEvent BANNER_BEARER_ATTACK = createSoundEvent("banner_bearer_attack");
    public static final SoundEvent BANNER_BEARER_CHEER = createSoundEvent("banner_bearer_cheer");
    public static final SoundEvent BANNER_BEARER_ROUND = createSoundEvent("banner_bearer_round");
    public static final SoundEvent TELEPORTER_AMBIENT = createSoundEvent("teleporter_ambient");
    public static final SoundEvent TELEPORTER_HURT = createSoundEvent("teleporter_hurt");
    public static final SoundEvent TELEPORTER_DEATH = createSoundEvent("teleporter_death");
    public static final SoundEvent TELEPORTER_TELEPORT = createSoundEvent("teleporter_teleport");
    public static final SoundEvent TELEPORTER_AWAY = createSoundEvent("teleporter_away");
    public static final SoundEvent TELEPORTER_CHEER = createSoundEvent("teleporter_cheer");
    public static final SoundEvent CYCLONER_AMBIENT = createSoundEvent("cycloner_ambient");
    public static final SoundEvent CYCLONER_HURT = createSoundEvent("cycloner_hurt");
    public static final SoundEvent CYCLONER_DEATH = createSoundEvent("cycloner_death");
    public static final SoundEvent CYCLONER_ATTACK = createSoundEvent("cycloner_attack");
    public static final SoundEvent CYCLONER_CHEER = createSoundEvent("cycloner_cheer");
    public static final SoundEvent CYCLONER_ROLL = createSoundEvent("cycloner_roll");
    public static final SoundEvent JAVELIN_THROWER_AMBIENT = createSoundEvent("javelin_thrower_ambient");
    public static final SoundEvent JAVELIN_THROWER_HURT = createSoundEvent("javelin_thrower_hurt");
    public static final SoundEvent JAVELIN_THROWER_DEATH = createSoundEvent("javelin_thrower_death");
    public static final SoundEvent JAVELIN_THROWER_ATTACK = createSoundEvent("javelin_thrower_attack");
    public static final SoundEvent JAVELIN_THROWER_CHEER = createSoundEvent("javelin_thrower_cheer");
    public static final SoundEvent ZOMBIE_KEEPER_AMBIENT = createSoundEvent("zombie_keeper_ambient");
    public static final SoundEvent ZOMBIE_KEEPER_HURT = createSoundEvent("zombie_keeper_hurt");
    public static final SoundEvent ZOMBIE_KEEPER_DEATH = createSoundEvent("zombie_keeper_death");
    public static final SoundEvent ZOMBIE_KEEPER_ATTACK = createSoundEvent("zombie_keeper_attack");
    public static final SoundEvent ZOMBIE_KEEPER_CHEER = createSoundEvent("zombie_keeper_cheer");
    public static final SoundEvent BLASTER_AMBIENT = createSoundEvent("blaster_ambient");
    public static final SoundEvent BLASTER_HURT = createSoundEvent("blaster_hurt");
    public static final SoundEvent BLASTER_DEATH = createSoundEvent("blaster_death");
    public static final SoundEvent BLASTER_ATTACK = createSoundEvent("blaster_attack");
    public static final SoundEvent BLASTER_CHEER = createSoundEvent("blaster_cheer");
    public static final SoundEvent BLASTER_THROW = createSoundEvent("blaster_throw");
    public static final SoundEvent TRUMPETER_AMBIENT = createSoundEvent("trumpeter_ambient");
    public static final SoundEvent TRUMPETER_HURT = createSoundEvent("trumpeter_hurt");
    public static final SoundEvent TRUMPETER_DEATH = createSoundEvent("trumpeter_death");
    public static final SoundEvent TRUMPETER_ATTACK = createSoundEvent("trumpeter_attack");
    public static final SoundEvent TRUMPETER_CHEER = createSoundEvent("trumpeter_cheer");
    public static final SoundEvent TRUMPETER_BLOW = createSoundEvent("trumpeter_blow");
    public static final SoundEvent BITTER_COLD_SORCERER_AMBIENT = createSoundEvent("bitter_cold_sorcerer_ambient");
    public static final SoundEvent BITTER_COLD_SORCERER_HURT = createSoundEvent("bitter_cold_sorcerer_hurt");
    public static final SoundEvent BITTER_COLD_SORCERER_DEATH = createSoundEvent("bitter_cold_sorcerer_death");
    public static final SoundEvent BITTER_COLD_SORCERER_SHOOT_1 = createSoundEvent("bitter_cold_sorcerer_shoot_1");
    public static final SoundEvent BITTER_COLD_SORCERER_ALTAR = createSoundEvent("bitter_cold_sorcerer_altar");
    public static final SoundEvent BITTER_COLD_SORCERER_ALTAR_USE = createSoundEvent("bitter_cold_sorcerer_altar_use");
    public static final SoundEvent BITTER_COLD_SORCERER_CHEER = createSoundEvent("bitter_cold_sorcerer_cheer");
    public static final SoundEvent FIRE_SPITTER_AMBIENT = createSoundEvent("fire_spitter_ambient");
    public static final SoundEvent FIRE_SPITTER_HURT = createSoundEvent("fire_spitter_hurt");
    public static final SoundEvent FIRE_SPITTER_DEATH = createSoundEvent("fire_spitter_death");
    public static final SoundEvent FIRE_SPITTER_DRINK = createSoundEvent("fire_spitter_drink");
    public static final SoundEvent FIRE_SPITTER_SPITTE = createSoundEvent("fire_spitter_spitte");
    public static final SoundEvent FIRE_SPITTER_CHEER = createSoundEvent("fire_spitter_cheer");
    public static final SoundEvent WILD_FINDER_AMBIENT = createSoundEvent("wild_finder_ambient");
    public static final SoundEvent WILD_FINDER_HURT = createSoundEvent("wild_finder_hurt");
    public static final SoundEvent WILD_FINDER_DEATH = createSoundEvent("wild_finder_death");
    public static final SoundEvent WILD_FINDER_CHEER = createSoundEvent("wild_finder_cheer");
    public static final SoundEvent WILD_FINDER_WAVE = createSoundEvent("wild_finder_wave");
    public static final SoundEvent SUBMARINER_AMBIENT = createSoundEvent("submariner_ambient");
    public static final SoundEvent SUBMARINER_HURT = createSoundEvent("submariner_hurt");
    public static final SoundEvent SUBMARINER_DEATH = createSoundEvent("submariner_death");
    public static final SoundEvent SUBMARINER_ATTACK = createSoundEvent("submariner_attack");
    public static final SoundEvent SUBMARINER_CHEER = createSoundEvent("submariner_cheer");
    public static final SoundEvent LAMP_WIZARD_AMBIENT = createSoundEvent("lamp_wizard_ambient");
    public static final SoundEvent LAMP_WIZARD_HURT = createSoundEvent("lamp_wizard_hurt");
    public static final SoundEvent LAMP_WIZARD_DEATH = createSoundEvent("lamp_wizard_death");
    public static final SoundEvent LAMP_WIZARD_SHOOT_1 = createSoundEvent("lamp_wizard_shoot_1");
    public static final SoundEvent LAMP_WIZARD_CHEER = createSoundEvent("lamp_wizard_cheer");
    public static final SoundEvent SLAVERY_SUPERVISOR_AMBIENT = createSoundEvent("slavery_supervisor_ambient");
    public static final SoundEvent SLAVERY_SUPERVISOR_HURT = createSoundEvent("slavery_supervisor_hurt");
    public static final SoundEvent SLAVERY_SUPERVISOR_DEATH = createSoundEvent("slavery_supervisor_death");
    public static final SoundEvent SLAVERY_SUPERVISOR_ATTACK = createSoundEvent("slavery_supervisor_attack");
    public static final SoundEvent SLAVERY_SUPERVISOR_CHEER = createSoundEvent("slavery_supervisor_cheer");
    public static final SoundEvent SLAVERY_SUPERVISOR_GET = createSoundEvent("slavery_supervisor_get");
    public static final SoundEvent SLAVERY_SUPERVISOR_SET = createSoundEvent("slavery_supervisor_set");
    public static final SoundEvent SLAVERY_SUPERVISOR_LEAD = createSoundEvent("slavery_supervisor_lead");
    public static final SoundEvent FIREPOWER_POURER_AMBIENT = createSoundEvent("firepower_pourer_ambient");
    public static final SoundEvent FIREPOWER_POURER_HURT = createSoundEvent("firepower_pourer_hurt");
    public static final SoundEvent FIREPOWER_POURER_DEATH = createSoundEvent("firepower_pourer_death");
    public static final SoundEvent FIREPOWER_POURER_ATTACK_1 = createSoundEvent("firepower_pourer_attack_1");
    public static final SoundEvent FIREPOWER_POURER_ATTACK_2 = createSoundEvent("firepower_pourer_attack_2");
    public static final SoundEvent FIREPOWER_POURER_WANT_SHOOT = createSoundEvent("firepower_pourer_want_shoot");
    public static final SoundEvent FIREPOWER_POURER_SHOOT = createSoundEvent("firepower_pourer_shoot");
    public static final SoundEvent FIREPOWER_POURER_CHEER = createSoundEvent("firepower_pourer_cheer");
    public static final SoundEvent FIREPOWER_POURER_WALK = createSoundEvent("firepower_pourer_walk");
    public static final SoundEvent FIREPOWER_POURER_COOL = createSoundEvent("firepower_pourer_cool");
    public static final SoundEvent NECROMANCY_WARLOCK_AMBIENT = createSoundEvent("necromancy_warlock_ambient");
    public static final SoundEvent NECROMANCY_WARLOCK_HURT = createSoundEvent("necromancy_warlock_hurt");
    public static final SoundEvent NECROMANCY_WARLOCK_DEATH = createSoundEvent("necromancy_warlock_death");
    public static final SoundEvent NECROMANCY_WARLOCK_GEAR = createSoundEvent("necromancy_warlock_gear");
    public static final SoundEvent NECROMANCY_WARLOCK_SELECTION = createSoundEvent("necromancy_warlock_selection");
    public static final SoundEvent NECROMANCY_WARLOCK_TENTACLE_ATTACK = createSoundEvent("necromancy_warlock_tentacle_attack");
    public static final SoundEvent NECROMANCY_WARLOCK_TENTACLE_HURT = createSoundEvent("necromancy_warlock_tentacle_hurt");
    public static final SoundEvent NECROMANCY_WARLOCK_TENTACLE_DEATH = createSoundEvent("necromancy_warlock_tentacle_death");
    public static final SoundEvent NECROMANCY_WARLOCK_CHEER = createSoundEvent("necromancy_warlock_cheer");
    public static final SoundEvent GAVILER_AMBIENT = createSoundEvent("gaviler_ambient");
    public static final SoundEvent GAVILER_HURT = createSoundEvent("gaviler_hurt");
    public static final SoundEvent GAVILER_DEATH = createSoundEvent("gaviler_death");
    public static final SoundEvent GAVILER_SHOOT = createSoundEvent("gaviler_shoot");
    public static final SoundEvent GAVILER_CHEER = createSoundEvent("gaviler_cheer");
    public static final SoundEvent AX_CRAZY_AMBIENT = createSoundEvent("ax_crazy_ambient");
    public static final SoundEvent AX_CRAZY_HURT = createSoundEvent("ax_crazy_hurt");
    public static final SoundEvent AX_CRAZY_DEATH = createSoundEvent("ax_crazy_death");
    public static final SoundEvent AX_CRAZY_ATTACK = createSoundEvent("ax_crazy_attack");
    public static final SoundEvent AX_CRAZY_CHEER = createSoundEvent("ax_crazy_cheer");
    public static final SoundEvent AX_CRAZY_WALK = createSoundEvent("ax_crazy_walk");
    public static final SoundEvent OMINOUS_BANNER_PROJECTION_AMBIENT = createSoundEvent("ominous_banner_projection_ambient");
    public static final SoundEvent OMINOUS_BANNER_PROJECTION_HURT = createSoundEvent("ominous_banner_projection_hurt");
    public static final SoundEvent OMINOUS_BANNER_PROJECTION_DEATH = createSoundEvent("ominous_banner_projection_death");
    public static final SoundEvent OMINOUS_BANNER_PROJECTION_CHEER = createSoundEvent("ominous_banner_projection_cheer");
    public static final SoundEvent OMINOUS_BANNER_PROJECTION_ROUND = createSoundEvent("ominous_banner_projection_round");
    public static final SoundEvent GIANT_MONSTER_AMBIENT = createSoundEvent("giant_monster_ambient");
    public static final SoundEvent GIANT_MONSTER_HURT = createSoundEvent("giant_monster_hurt");
    public static final SoundEvent GIANT_MONSTER_DEATH = createSoundEvent("giant_monster_death");
    public static final SoundEvent GIANT_MONSTER_ATTACK = createSoundEvent("giant_monster_attack");
    public static final SoundEvent GIANT_MONSTER_WALK = createSoundEvent("giant_monster_walk");
    public static final SoundEvent SPIRVE_AMBIENT = createSoundEvent("spirve_ambient");
    public static final SoundEvent SPIRVE_HURT = createSoundEvent("spirve_hurt");
    public static final SoundEvent SPIRVE_DEATH = createSoundEvent("spirve_death");
    public static final SoundEvent SPIRVE_CHEER = createSoundEvent("spirve_cheer");
    public static final SoundEvent HAG_AMBIENT = createSoundEvent("hag_ambient");
    public static final SoundEvent HAG_HURT = createSoundEvent("hag_hurt");
    public static final SoundEvent HAG_DEATH = createSoundEvent("hag_death");
    public static final SoundEvent HAG_LAUGH_1 = createSoundEvent("hag_laugh_1");
    public static final SoundEvent PURPLE_SAND_HAG_AMBIENT = createSoundEvent("purple_sand_hag_ambient");
    public static final SoundEvent PURPLE_SAND_HAG_HURT = createSoundEvent("purple_sand_hag_hurt");
    public static final SoundEvent PURPLE_SAND_HAG_DEATH = createSoundEvent("purple_sand_hag_death");
    public static final SoundEvent PURPLE_SAND_HAG_LAUGH_1 = createSoundEvent("purple_sand_hag_laugh_1");
    public static final SoundEvent PURPLE_SAND_HAG_COVENS = createSoundEvent("purple_sand_hag_covens");
    public static final SoundEvent PURPLE_SAND_HAG_CONJURE_SPIRVE = createSoundEvent("purple_sand_hag_conjure_spirve");

    public static final SoundEvent MEROR_TOOL_USE = createSoundEvent("meror_tool_use");
    public static final SoundEvent MEROR_TELEPORT = createSoundEvent("meror_teleport");
    public static final SoundEvent CARVED_HORN_USE = createSoundEvent("carved_horn_use");

    public static final SoundEvent MAGIC_BLOODY_SCREAM = createSoundEvent("magic_bloody_scream");
    public static final SoundEvent MAGIC_PURPLE_SAND_PHANTOM = createSoundEvent("magic_purple_sand_phantom");
    public static final SoundEvent MAGIC_BITTER_COLD_ICE_SPIKE = createSoundEvent("magic_bitter_cold_ice_spike");
    public static final SoundEvent MAGIC_ELASTIC_LIGHT_BALL = createSoundEvent("magic_elastic_light_ball");
    public static final SoundEvent MAGIC_RADIANT_BOMB = createSoundEvent("magic_radiant_bomb");
    public static final SoundEvent MAGIC_ARCANE_LIGHT_SPOT = createSoundEvent("magic_arcane_light_spot");
    public static final SoundEvent MAGIC_ELASTIC_ICE_ROCK = createSoundEvent("magic_elastic_ice_rock");
    public static final SoundEvent MAGIC_BLOODY_BLAME_SOUL_ASSIST = createSoundEvent("magic_bloody_blame_soul_assist");
    public static final SoundEvent MAGIC_BITTER_COLD_FROSTBITE = createSoundEvent("magic_bitter_cold_frostbite");
    public static final SoundEvent MAGIC_OMINOUS_FLAMES = createSoundEvent("magic_ominous_flames");
    public static final SoundEvent MAGIC_PUSH_FORCE = createSoundEvent("magic_push_force");
    public static final SoundEvent MAGIC_GEMSTONE_WAVES = createSoundEvent("magic_gemstone_waves");
    public static final SoundEvent MAGIC_ELECTROFLASH = createSoundEvent("magic_electroflash");
    public static final SoundEvent MAGIC_FLOATING_FORCE = createSoundEvent("magic_floating_force");
    public static final SoundEvent MAGIC_GRAVITY_FORCE = createSoundEvent("magic_gravity_force");
    public static final SoundEvent MAGIC_UNCLEAN_BLOOD_RAIN = createSoundEvent("magic_unclean_blood_rain");
    public static final SoundEvent MAGIC_UNCLEAN_BLOOD_FOG = createSoundEvent("magic_unclean_blood_fog");
    public static final SoundEvent MAGIC_WARLOCK_WHISPER = createSoundEvent("magic_warlock_whisper");
    public static final SoundEvent MAGIC_OMINOUS_GEAR = createSoundEvent("magic_ominous_gear");
    public static final SoundEvent MAGIC_EVIL_SUMMONING = createSoundEvent("magic_evil_summoning");
    public static final SoundEvent MAGIC_BITTER_COLD_ALTAR = createSoundEvent("magic_bitter_cold_altar");

    public static final SoundEvent SEDIMENT_URN_OPEN = createSoundEvent("sediment_urn_open");
    public static final SoundEvent SEDIMENT_URN_CLOSE = createSoundEvent("sediment_urn_close");

    public static final SoundEvent NOTE_BLOCK_IMITATE_SPIRVE = createSoundEvent("note_block_imitate_spirve");
    public static final SoundEvent NOTE_BLOCK_IMITATE_TANGLER = createSoundEvent("note_block_imitate_tangler");

    public static final SoundEvent OMINOUS_BANNER_PROJECTION_MUSIC = createSoundEvent("ominous_banner_projection_music");
    public static final SoundEvent PURPLE_SAND_HAG_MUSIC = createSoundEvent("purple_sand_hag_music");

    private static SoundEvent createSoundEvent(final String soundName) {
        final ResourceLocation soundID = new ResourceLocation(JerotesVillage.MODID, soundName);
        return SoundEvent.createVariableRangeEvent(soundID);
    }

    @SubscribeEvent
    public static void registerSoundEvents(final NewRegistryEvent event) {
        try {
            for (Field f : JerotesVillageSoundEvents.class.getFields()) {
                Object obj = f.get(null);
                if (obj instanceof SoundEvent) {
                    ForgeRegistries.SOUND_EVENTS.register(((SoundEvent) obj).getLocation(), (SoundEvent) obj);
                } else if (obj instanceof SoundEvent[]) {
                    for (SoundEvent soundEvent : (SoundEvent[]) obj) {
                        ForgeRegistries.SOUND_EVENTS.register(soundEvent.getLocation(), soundEvent);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

