package com.jerotes.jerotesvillage.spell;

import com.jerotes.jerotes.spell.MagicSpell;
import com.jerotes.jerotes.spell.SpellTypeInterface;
import com.jerotes.jerotes.util.Main;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public enum OtherSpellType implements SpellTypeInterface {
	JEROTESVILLAGE_BLOODY_SCREAM("jerotesvillage_bloody_scream"),
	JEROTESVILLAGE_PURPLE_SAND_PHANTOM("jerotesvillage_purple_sand_phantom"),
	JEROTESVILLAGE_ELASTIC_ICE_ROCK("jerotesvillage_elastic_ice_rock"),
	JEROTESVILLAGE_BLOODY_BLAME_SOUL_ASSIST("jerotesvillage_bloody_blame_soul_assist"),
	JEROTESVILLAGE_BITTER_COLD_ICE_SPIKE("jerotesvillage_bitter_cold_ice_spike"),
	JEROTESVILLAGE_ELASTIC_LIGHT_BALL("jerotesvillage_elastic_light_ball"),
	JEROTESVILLAGE_RADIANT_BOMB("jerotesvillage_radiant_bomb"),
	JEROTESVILLAGE_ARCANE_LIGHT_SPOT("jerotesvillage_arcane_light_spot"),
	JEROTESVILLAGE_BITTER_COLD_FROSTBITE("jerotesvillage_bitter_cold_frostbite"),
	JEROTESVILLAGE_OMINOUS_FLAMES("jerotesvillage_ominous_flames"),
	JEROTESVILLAGE_PUSH_FORCE("jerotesvillage_push_force"),
	JEROTESVILLAGE_GEMSTONE_WAVES("jerotesvillage_gemstone_waves"),
	JEROTESVILLAGE_ELECTROFLASH("jerotesvillage_electroflash"),
	JEROTESVILLAGE_FLOATING_FORCE("jerotesvillage_floating_force"),
	JEROTESVILLAGE_GRAVITY_FORCE("jerotesvillage_gravity_force"),
	JEROTESVILLAGE_UNCLEAN_BLOOD_RAIN("jerotesvillage_unclean_blood_rain"),
	JEROTESVILLAGE_UNCLEAN_BLOOD_FOG("jerotesvillage_unclean_blood_fog"),
	JEROTESVILLAGE_WARLOCK_WHISPER("jerotesvillage_warlock_whisper"),
	JEROTESVILLAGE_OMINOUS_GEAR("jerotesvillage_ominous_gear"),
	JEROTESVILLAGE_EVIL_SUMMONING("jerotesvillage_evil_summoning"),
	JEROTESVILLAGE_BITTER_COLD_ALTAR("jerotesvillage_bitter_cold_altar");

	private final String id;

	private OtherSpellType(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public MagicSpell magicSpellGet(int level, LivingEntity caster, Entity target) {
		return switch (this) {
			case JEROTESVILLAGE_BLOODY_SCREAM -> OtherSpellList.BloodyScream(level, caster, target);
			case JEROTESVILLAGE_PURPLE_SAND_PHANTOM -> OtherSpellList.PurpleSandPhantom(level, caster, target);
			case JEROTESVILLAGE_ELASTIC_ICE_ROCK -> OtherSpellList.ElasticIceRock(level, caster, target);
			case JEROTESVILLAGE_BLOODY_BLAME_SOUL_ASSIST -> OtherSpellList.BloodyBlameSoulAssist(level, caster, target);
			case JEROTESVILLAGE_BITTER_COLD_ICE_SPIKE -> OtherSpellList.BitterColdIceSpike(level, caster, target);
			case JEROTESVILLAGE_ELASTIC_LIGHT_BALL -> OtherSpellList.ElasticLightBall(level, caster, target);
			case JEROTESVILLAGE_RADIANT_BOMB -> OtherSpellList.RadiantBomb(level, caster, target);
			case JEROTESVILLAGE_ARCANE_LIGHT_SPOT -> OtherSpellList.ArcaneLightSpot(level, caster, target);
			case JEROTESVILLAGE_BITTER_COLD_FROSTBITE -> OtherSpellList.BitterColdFrostbite(level, caster, target);
			case JEROTESVILLAGE_OMINOUS_FLAMES -> OtherSpellList.OminousFlames(level, caster, target);
			case JEROTESVILLAGE_PUSH_FORCE -> OtherSpellList.PushForce(level, caster, target);
			case JEROTESVILLAGE_GEMSTONE_WAVES -> OtherSpellList.GemstoneWaves(level, caster, target);
			case JEROTESVILLAGE_ELECTROFLASH -> OtherSpellList.Electroflash(level, caster, target);
			case JEROTESVILLAGE_FLOATING_FORCE -> OtherSpellList.FloatingForce(level, caster, target);
			case JEROTESVILLAGE_GRAVITY_FORCE -> OtherSpellList.GravityForce(level, caster, target);
			case JEROTESVILLAGE_UNCLEAN_BLOOD_RAIN -> OtherSpellList.UncleanBloodRain(level, caster, target);
			case JEROTESVILLAGE_UNCLEAN_BLOOD_FOG -> OtherSpellList.UncleanBloodFog(level, caster, target);
			case JEROTESVILLAGE_WARLOCK_WHISPER -> OtherSpellList.WarlockWhisper(level, caster, target);
			case JEROTESVILLAGE_OMINOUS_GEAR -> OtherSpellList.OminousGear(level, caster, target);
			case JEROTESVILLAGE_EVIL_SUMMONING -> OtherSpellList.EvilSummoning(level, caster, target);
			case JEROTESVILLAGE_BITTER_COLD_ALTAR -> OtherSpellList.BitterColdAltar(level, caster, target);
		};
	}

	public void stop(LivingEntity caster, int level, boolean must) {
		stops(caster, level, must);
	}
	public static void stops(LivingEntity caster, int level, boolean must) {
		//不祥火舌
		if (must || level > caster.getPersistentData().getInt("jerotesvillage_ominous_flames_spellLevelDamage")) {
			Main.persistentDataRemove(caster, "jerotesvillage_ominous_flames");
			Main.persistentDataRemove(caster, "jerotesvillage_ominous_flames_spellLevelDamage");
			Main.persistentDataRemove(caster, "jerotesvillage_ominous_flames_spellLevelFireTime");
			Main.persistentDataRemove(caster, "jerotesvillage_ominous_flames_spellLevelAccuracy");
			Main.persistentDataRemove(caster, "jerotesvillage_ominous_flames_count");
			Main.persistentDataRemove(caster, "jerotesvillage_ominous_flames_distance");
		}
		//苦寒冰霜
		if (must || level > caster.getPersistentData().getInt("jerotesvillage_bitter_cold_frostbite_spellLevelDamage")) {
			Main.persistentDataRemove(caster, "jerotesvillage_bitter_cold_frostbite");
			Main.persistentDataRemove(caster, "jerotesvillage_bitter_cold_frostbite_spellLevelDamage");
			Main.persistentDataRemove(caster, "jerotesvillage_bitter_cold_frostbite_spellLevelFreezeTime");
			Main.persistentDataRemove(caster, "jerotesvillage_bitter_cold_frostbite_spellLevelAccuracy");
			Main.persistentDataRemove(caster, "jerotesvillage_bitter_cold_frostbite_count");
			Main.persistentDataRemove(caster, "jerotesvillage_bitter_cold_frostbite_distance");
		}
		//奥术光点
		if (must || level > caster.getPersistentData().getInt("jerotesvillage_arcane_light_spot_spellLevelDamage")) {
			Main.persistentDataRemove(caster, "jerotesvillage_arcane_light_spot");
			Main.persistentDataRemove(caster, "jerotesvillage_arcane_light_spot_spellLevelDamage");
			Main.persistentDataRemove(caster, "jerotesvillage_arcane_light_spot_target");
			Main.persistentDataRemove(caster, "jerotesvillage_arcane_light_spot_spellLevelMainEffectTime");
			Main.persistentDataRemove(caster, "jerotesvillage_arcane_light_spot_spellLevelMainEffectLevel");
			Main.persistentDataRemove(caster, "jerotesvillage_arcane_light_spot_spellLevelAccuracy");
			Main.persistentDataRemove(caster, "jerotesvillage_arcane_light_spot_count");
			Main.persistentDataRemove(caster, "jerotesvillage_arcane_light_spot_distance");
		}
	}
}