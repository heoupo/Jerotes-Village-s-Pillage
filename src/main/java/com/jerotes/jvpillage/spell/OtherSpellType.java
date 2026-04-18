package com.jerotes.jvpillage.spell;

import com.jerotes.jerotes.spell.MagicSpell;
import com.jerotes.jerotes.spell.SpellTypeInterface;
import com.jerotes.jerotes.util.Main;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public enum OtherSpellType implements SpellTypeInterface {
	JVPILLAGE_BLOODY_SCREAM("jvpillage_bloody_scream"),
	JVPILLAGE_PURPLE_SAND_PHANTOM("jvpillage_purple_sand_phantom"),
	JVPILLAGE_ELASTIC_ICE_ROCK("jvpillage_elastic_ice_rock"),
	JVPILLAGE_BLOODY_BLAME_SOUL_ASSIST("jvpillage_bloody_blame_soul_assist"),
	JVPILLAGE_BITTER_COLD_ICE_SPIKE("jvpillage_bitter_cold_ice_spike"),
	JVPILLAGE_ELASTIC_LIGHT_BALL("jvpillage_elastic_light_ball"),
	JVPILLAGE_RADIANT_BOMB("jvpillage_radiant_bomb"),
	JVPILLAGE_ARCANE_LIGHT_SPOT("jvpillage_arcane_light_spot"),
	JVPILLAGE_BITTER_COLD_FROSTBITE("jvpillage_bitter_cold_frostbite"),
	JVPILLAGE_OMINOUS_FLAMES("jvpillage_ominous_flames"),
	JVPILLAGE_PUSH_FORCE("jvpillage_push_force"),
	JVPILLAGE_GEMSTONE_WAVES("jvpillage_gemstone_waves"),
	JVPILLAGE_ELECTROFLASH("jvpillage_electroflash"),
	JVPILLAGE_FLOATING_FORCE("jvpillage_floating_force"),
	JVPILLAGE_GRAVITY_FORCE("jvpillage_gravity_force"),
	JVPILLAGE_UNCLEAN_BLOOD_RAIN("jvpillage_unclean_blood_rain"),
	JVPILLAGE_UNCLEAN_BLOOD_FOG("jvpillage_unclean_blood_fog"),
	JVPILLAGE_WARLOCK_WHISPER("jvpillage_warlock_whisper"),
	JVPILLAGE_OMINOUS_GEAR("jvpillage_ominous_gear"),
	JVPILLAGE_EVIL_SUMMONING("jvpillage_evil_summoning"),
	JVPILLAGE_BITTER_COLD_ALTAR("jvpillage_bitter_cold_altar");

	private final String id;

	private OtherSpellType(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public MagicSpell magicSpellGet(int level, LivingEntity caster, Entity target) {
		return switch (this) {
			case JVPILLAGE_BLOODY_SCREAM -> OtherSpellList.BloodyScream(level, caster, target);
			case JVPILLAGE_PURPLE_SAND_PHANTOM -> OtherSpellList.PurpleSandPhantom(level, caster, target);
			case JVPILLAGE_ELASTIC_ICE_ROCK -> OtherSpellList.ElasticIceRock(level, caster, target);
			case JVPILLAGE_BLOODY_BLAME_SOUL_ASSIST -> OtherSpellList.BloodyBlameSoulAssist(level, caster, target);
			case JVPILLAGE_BITTER_COLD_ICE_SPIKE -> OtherSpellList.BitterColdIceSpike(level, caster, target);
			case JVPILLAGE_ELASTIC_LIGHT_BALL -> OtherSpellList.ElasticLightBall(level, caster, target);
			case JVPILLAGE_RADIANT_BOMB -> OtherSpellList.RadiantBomb(level, caster, target);
			case JVPILLAGE_ARCANE_LIGHT_SPOT -> OtherSpellList.ArcaneLightSpot(level, caster, target);
			case JVPILLAGE_BITTER_COLD_FROSTBITE -> OtherSpellList.BitterColdFrostbite(level, caster, target);
			case JVPILLAGE_OMINOUS_FLAMES -> OtherSpellList.OminousFlames(level, caster, target);
			case JVPILLAGE_PUSH_FORCE -> OtherSpellList.PushForce(level, caster, target);
			case JVPILLAGE_GEMSTONE_WAVES -> OtherSpellList.GemstoneWaves(level, caster, target);
			case JVPILLAGE_ELECTROFLASH -> OtherSpellList.Electroflash(level, caster, target);
			case JVPILLAGE_FLOATING_FORCE -> OtherSpellList.FloatingForce(level, caster, target);
			case JVPILLAGE_GRAVITY_FORCE -> OtherSpellList.GravityForce(level, caster, target);
			case JVPILLAGE_UNCLEAN_BLOOD_RAIN -> OtherSpellList.UncleanBloodRain(level, caster, target);
			case JVPILLAGE_UNCLEAN_BLOOD_FOG -> OtherSpellList.UncleanBloodFog(level, caster, target);
			case JVPILLAGE_WARLOCK_WHISPER -> OtherSpellList.WarlockWhisper(level, caster, target);
			case JVPILLAGE_OMINOUS_GEAR -> OtherSpellList.OminousGear(level, caster, target);
			case JVPILLAGE_EVIL_SUMMONING -> OtherSpellList.EvilSummoning(level, caster, target);
			case JVPILLAGE_BITTER_COLD_ALTAR -> OtherSpellList.BitterColdAltar(level, caster, target);
		};
	}

	public void stop(LivingEntity caster, int level, boolean must) {
		stops(caster, level, must);
	}
	public static void stops(LivingEntity caster, int level, boolean must) {
		//不祥火舌
		if (must || level > caster.getPersistentData().getInt("JVPILLAGE_ominous_flames_spellLevelDamage")) {
			Main.persistentDataRemove(caster, "JVPILLAGE_ominous_flames");
			Main.persistentDataRemove(caster, "JVPILLAGE_ominous_flames_spellLevelDamage");
			Main.persistentDataRemove(caster, "JVPILLAGE_ominous_flames_spellLevelFireTime");
			Main.persistentDataRemove(caster, "JVPILLAGE_ominous_flames_spellLevelAccuracy");
			Main.persistentDataRemove(caster, "JVPILLAGE_ominous_flames_count");
			Main.persistentDataRemove(caster, "JVPILLAGE_ominous_flames_distance");
		}
		//苦寒冰霜
		if (must || level > caster.getPersistentData().getInt("JVPILLAGE_bitter_cold_frostbite_spellLevelDamage")) {
			Main.persistentDataRemove(caster, "JVPILLAGE_bitter_cold_frostbite");
			Main.persistentDataRemove(caster, "JVPILLAGE_bitter_cold_frostbite_spellLevelDamage");
			Main.persistentDataRemove(caster, "JVPILLAGE_bitter_cold_frostbite_spellLevelFreezeTime");
			Main.persistentDataRemove(caster, "JVPILLAGE_bitter_cold_frostbite_spellLevelAccuracy");
			Main.persistentDataRemove(caster, "JVPILLAGE_bitter_cold_frostbite_count");
			Main.persistentDataRemove(caster, "JVPILLAGE_bitter_cold_frostbite_distance");
		}
		//奥术光点
		if (must || level > caster.getPersistentData().getInt("JVPILLAGE_arcane_light_spot_spellLevelDamage")) {
			Main.persistentDataRemove(caster, "JVPILLAGE_arcane_light_spot");
			Main.persistentDataRemove(caster, "JVPILLAGE_arcane_light_spot_spellLevelDamage");
			Main.persistentDataRemove(caster, "JVPILLAGE_arcane_light_spot_target");
			Main.persistentDataRemove(caster, "JVPILLAGE_arcane_light_spot_spellLevelMainEffectTime");
			Main.persistentDataRemove(caster, "JVPILLAGE_arcane_light_spot_spellLevelMainEffectLevel");
			Main.persistentDataRemove(caster, "JVPILLAGE_arcane_light_spot_spellLevelAccuracy");
			Main.persistentDataRemove(caster, "JVPILLAGE_arcane_light_spot_count");
			Main.persistentDataRemove(caster, "JVPILLAGE_arcane_light_spot_distance");
		}
	}
}