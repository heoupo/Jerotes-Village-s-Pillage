package com.jerotes.jerotesvillage.spell;

import com.jerotes.jerotes.spell.MagicSpell;
import com.jerotes.jerotes.spell.MagicType;
import com.jerotes.jerotes.util.Main;
import com.jerotes.jerotesvillage.JerotesVillage;
import com.jerotes.jerotesvillage.entity.MagicSummoned.BlamerNecromancyWarlock.BlamerNecromancyWarlockEntity;
import com.jerotes.jerotesvillage.entity.Other.BitterColdAltarEntity;
import com.jerotes.jerotesvillage.entity.Other.PurpleSandPhantomEntity;
import com.jerotes.jerotesvillage.entity.Other.UncleanTentacleEntity;
import com.jerotes.jerotesvillage.init.JerotesVillageParticleTypes;
import com.jerotes.jerotesvillage.init.JerotesVillageSoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public class OtherSpellList {

	//血腥尖啸
	public static MagicSpell BloodyScream(int n, LivingEntity caster, Entity target) {
		return new MagicSpell(n, caster, target, MagicType.SHOOT, MagicType.MAIN, "bloody_scream", JerotesVillageParticleTypes.BLOODY_SCREAM_DISPLAY.get(), JerotesVillageSoundEvents.MAGIC_BLOODY_SCREAM){
			public boolean spellFindUse() {
				return OtherSpellFind.BloodyScream(getCaster(), getTarget(), getSpellLevel(), getSpellLevel() * 6, getSpellLevel() - 1, getSpellAccuracy(), getSpellLevel() + 1, 5, getCaster() instanceof Player);
			}
			public String getSpellModId() {
				return JerotesVillage.MODID;
			}
		};
	}
	//紫沙幻影
	public static MagicSpell PurpleSandPhantom(int n, LivingEntity caster, Entity target) {
		return new MagicSpell(n, caster, target, MagicType.TARGET, MagicType.MAIN, "purple_sand_phantom", JerotesVillageParticleTypes.PURPLE_SAND_PHANTOM_DISPLAY.get(), JerotesVillageSoundEvents.MAGIC_PURPLE_SAND_PHANTOM){
			public boolean spellFindUse() {
				return OtherSpellFind.PurpleSandPhantom(getCaster(), getTarget(), getSpellLevel() * 2, getSpellLevel() * 3, 12, getSpellLevel());
			}
			public int baseSpellLevel() {
				return 4;
			}
			public float getSpellDistance() {
				return 32;
			}
			public String getSpellModId() {
				return JerotesVillage.MODID;
			}
			public boolean canUse() {
				if (getCaster() != null) {
					List<PurpleSandPhantomEntity> list = getCaster().level().getEntitiesOfClass(PurpleSandPhantomEntity.class, getCaster().getBoundingBox().inflate(32.0, 32.0, 32.0));
					list.removeIf(purpleSandPhantomEntity -> purpleSandPhantomEntity.getOwner() != getCaster());
					return super.canUse() && list.size() <= getSpellLevel() * 4;
				}
				return super.canUse();
			}
			public boolean canUseTargetNone() {
				return true;
			}
		};
	}
	//苦寒冰锥
	public static MagicSpell BitterColdIceSpike(int n, LivingEntity caster, Entity target) {
		return new MagicSpell(n, caster, target, MagicType.SHOOT, MagicType.MAIN, "bitter_cold_ice_spike", JerotesVillageParticleTypes.BITTER_COLD_ICE_SPIKE_DISPLAY.get(), JerotesVillageSoundEvents.MAGIC_BITTER_COLD_ICE_SPIKE){
			public boolean spellFindUse() {
				return OtherSpellFind.BitterColdIceSpike(getCaster(), getTarget(), getSpellLevel(), 7 + getSpellLevel() * 3, 2.25f, getSpellAccuracy(), 1, 5, getCaster() instanceof Player);
			}
			public String getSpellModId() {
				return JerotesVillage.MODID;
			}
		};
	}
	//弹力光球
	public static MagicSpell ElasticLightBall(int n, LivingEntity caster, Entity target) {
		return new MagicSpell(n, caster, target, MagicType.SHOOT, MagicType.MAIN, "elastic_light_ball", JerotesVillageParticleTypes.ELASTIC_LIGHT_BALL_DISPLAY.get(), JerotesVillageSoundEvents.MAGIC_ELASTIC_LIGHT_BALL){
			public boolean spellFindUse() {
				return OtherSpellFind.ElasticLightBall(getCaster(), getTarget(), getSpellLevel(), getSpellLevel() * 6, 1, 1.6f, getSpellAccuracy(), getSpellLevel(), 5, getCaster() instanceof Player);
			}
			public String getSpellModId() {
				return JerotesVillage.MODID;
			}
		};
	}
	//光芒爆弹
	public static MagicSpell RadiantBomb(int n, LivingEntity caster, Entity target) {
		return new MagicSpell(n, caster, target, MagicType.SHOOT, MagicType.MAIN, "radiant_bomb", JerotesVillageParticleTypes.RADIANT_BOMB_DISPLAY.get(), JerotesVillageSoundEvents.MAGIC_RADIANT_BOMB){
			public boolean spellFindUse() {
				return OtherSpellFind.RadiantBomb(getCaster(), getTarget(), getSpellLevel(), 0.5f + getSpellLevel() * 0.25f, spellLevel * 6, 1, getSpellAccuracy(), 1, 5, getCaster() instanceof Player);
			}
			public String getSpellModId() {
				return JerotesVillage.MODID;
			}
			public int baseSpellLevel() {
				return 2;
			}
		};
	}
	//奥术光点
	public static MagicSpell ArcaneLightSpot(int n, LivingEntity caster, Entity target) {
		return new MagicSpell(n, caster, target, MagicType.TARGET, MagicType.MAIN, "arcane_light_spot", JerotesVillageParticleTypes.ARCANE_LIGHT_SPOT_DISPLAY.get(), JerotesVillageSoundEvents.MAGIC_ARCANE_LIGHT_SPOT){
			public boolean spellFindUse() {
				return OtherSpellFind.ArcaneLightSpot(getCaster(), (getTarget() instanceof LivingEntity livingEntity) ? livingEntity : getCaster(), getSpellLevel(), getSpellLevel() * 6, 1, getSpellAccuracy(), 1, 1, 3 + getSpellLevel(), getCaster() instanceof Player);
			}
			public String getSpellModId() {
				return JerotesVillage.MODID;
			}
			public boolean canUseTargetNone() {
				return true;
			}
		};
	}
	//弹力冰岩
	public static MagicSpell ElasticIceRock(int n, LivingEntity caster, Entity target) {
		return new MagicSpell(n, caster, target, MagicType.SHOOT, MagicType.MAIN, "elastic_ice_rock", JerotesVillageParticleTypes.ELASTIC_ICE_ROCK_DISPLAY.get(), JerotesVillageSoundEvents.MAGIC_ELASTIC_ICE_ROCK){
			public boolean spellFindUse() {
				return OtherSpellFind.ElasticIceRock(getCaster(), getTarget(), getSpellLevel(), 7 + getSpellLevel() * 3, 1.6f, getSpellAccuracy(), 1, 5, getCaster() instanceof Player);
			}
			public String getSpellModId() {
				return JerotesVillage.MODID;
			}
		};
	}
	//血怨魂援
	public static MagicSpell BloodyBlameSoulAssist(int n, LivingEntity caster, Entity target) {
		return new MagicSpell(n, caster, target, MagicType.SELF, MagicType.MAIN, "bloody_blame_soul_assist", JerotesVillageParticleTypes.BLOODY_BLAME_SOUL_ASSIST_DISPLAY.get(), JerotesVillageSoundEvents.MAGIC_BLOODY_BLAME_SOUL_ASSIST){
			public boolean spellFindUse() {
				return OtherSpellFind.BloodyBlameSoulAssist(getCaster(), 1, 1, 16);
			}
			public String getSpellModId() {
				return JerotesVillage.MODID;
			}
			public int baseSpellLevel() {
				return 4;
			}
			public float getSpellDistance() {
				return 16;
			}
			public boolean canUse() {
				if (getCaster() != null) {
					List<BlamerNecromancyWarlockEntity> list = getCaster().level().getEntitiesOfClass(BlamerNecromancyWarlockEntity.class, getCaster().getBoundingBox().inflate(24.0, 24.0, 24.0));
					list.removeIf(summon -> summon.getOwner() != getCaster());
					return super.canUse() && list.size() < getSpellLevel();
				}
				return super.canUse();
			}
		};
	}
	//苦寒冰霜
	public static MagicSpell BitterColdFrostbite(int n, LivingEntity caster, Entity target) {
		return new MagicSpell(n, caster, target, MagicType.SHOOT, MagicType.MAIN, "bitter_cold_frostbite", JerotesVillageParticleTypes.BITTER_COLD_FROSTBITE_DISPLAY.get(), JerotesVillageSoundEvents.MAGIC_BITTER_COLD_FROSTBITE){
			public boolean spellFindUse() {
				return OtherSpellFind.BitterColdFrostbite(getCaster(), getTarget(), getSpellLevel(), 7 + getSpellLevel() * 3, getSpellAccuracy(), getSpellLevel(), 2, 20 + this.getSpellLevel() * 5, getCaster() instanceof Player);
			}
			public String getSpellModId() {
				return JerotesVillage.MODID;
			}
		};
	}
	//不祥火舌
	public static MagicSpell OminousFlames(int n, LivingEntity caster, Entity target) {
		return new MagicSpell(n, caster, target, MagicType.SHOOT, MagicType.MAIN, "ominous_flames", JerotesVillageParticleTypes.OMINOUS_FLAMES_DISPLAY.get(), JerotesVillageSoundEvents.MAGIC_OMINOUS_FLAMES){
			public boolean spellFindUse() {
				return OtherSpellFind.OminousFlames(getCaster(), getTarget(), getSpellLevel(), 6 + getSpellLevel() * 3, getSpellAccuracy(), getSpellLevel(), 2, 20 + this.getSpellLevel() * 5, getCaster() instanceof Player);
			}
			public String getSpellModId() {
				return JerotesVillage.MODID;
			}
		};
	}
	//推动力场
	public static MagicSpell PushForce(int n, LivingEntity caster, Entity target) {
		return new MagicSpell(n, caster, target, MagicType.SHOOT, MagicType.MAIN, "push_force", JerotesVillageParticleTypes.PUSH_FORCE_DISPLAY.get(), JerotesVillageSoundEvents.MAGIC_PUSH_FORCE){
			public boolean spellFindUse() {
				return OtherSpellFind.PushForce(getCaster(), getTarget(), getSpellLevel(), getSpellLevel(), 1.0f + getSpellLevel() * 0.2f, getSpellLevel(), 1.0f + getSpellLevel() * 0.2f, getSpellAccuracy(), 1, 5, getCaster() instanceof Player);
			}
			public String getSpellModId() {
				return JerotesVillage.MODID;
			}
			public int baseSpellLevel() {
				return 3;
			}
		};
	}
	//宝石海浪
	public static MagicSpell GemstoneWaves(int n, LivingEntity caster, Entity target) {
		return new MagicSpell(n, caster, target, MagicType.SHOOT, MagicType.MAIN, "gemstone_waves", JerotesVillageParticleTypes.GEMSTONE_WAVES_DISPLAY.get(), JerotesVillageSoundEvents.MAGIC_GEMSTONE_WAVES){
			public boolean spellFindUse() {
				return OtherSpellFind.GemstoneWaves(getCaster(), getSpellLevel(), getSpellLevel() * 3, getSpellLevel(), 8, 30, this.getSpellLevel() * 5);
			}
			public String getSpellModId() {
				return JerotesVillage.MODID;
			}
			public int baseSpellLevel() {
				return 2;
			}
			public float getSpellDistance() {
				return 8;
			}
		};
	}
	//迅电流光
	public static MagicSpell Electroflash(int n, LivingEntity caster, Entity target) {
		return new MagicSpell(n, caster, target, MagicType.SHOOT, MagicType.MAIN, "electroflash", JerotesVillageParticleTypes.ELECTROFLASH_DISPLAY.get(), JerotesVillageSoundEvents.MAGIC_ELECTROFLASH){
			public boolean spellFindUse() {
				return OtherSpellFind.Electroflash(getCaster(), getSpellLevel());
			}
			public String getSpellModId() {
				return JerotesVillage.MODID;
			}
			public int baseSpellLevel() {
				return 3;
			}
			public float getSpellDistance() {
				return 8;
			}
		};
	}
	//漂浮力场
	public static MagicSpell FloatingForce(int n, LivingEntity caster, Entity target) {
		return new MagicSpell(n, caster, target, MagicType.SELF, MagicType.MAIN, "floating_force", JerotesVillageParticleTypes.FLOATING_FORCE_DISPLAY.get(), JerotesVillageSoundEvents.MAGIC_FLOATING_FORCE){
			public boolean spellFindUse() {
				return OtherSpellFind.FloatingForce(getCaster(), getSpellLevel(), getSpellLevel() * 8, getSpellLevel() * 5);
			}
			public String getSpellModId() {
				return JerotesVillage.MODID;
			}
			public int baseSpellLevel() {
				return 2;
			}
			public float getSpellDistance() {
				return getSpellLevel() * 8;
			}
		};
	}
	//地吸力场
	public static MagicSpell GravityForce(int n, LivingEntity caster, Entity target) {
		return new MagicSpell(n, caster, target, MagicType.SELF, MagicType.MAIN, "gravity_force", JerotesVillageParticleTypes.GRAVITY_FORCE_DISPLAY.get(), JerotesVillageSoundEvents.MAGIC_GRAVITY_FORCE){
			public boolean spellFindUse() {
				return OtherSpellFind.GravityForce(getCaster(), getSpellLevel(), getSpellLevel() * 8, getSpellLevel() * 5);
			}
			public String getSpellModId() {
				return JerotesVillage.MODID;
			}
			public int baseSpellLevel() {
				return 2;
			}
			public float getSpellDistance() {
				return getSpellLevel() * 8;
			}
		};
	}
	//不洁血雨
	public static MagicSpell UncleanBloodRain(int n, LivingEntity caster, Entity target) {
		return new MagicSpell(n, caster, target, MagicType.TARGET, MagicType.MAIN, "unclean_blood_rain", JerotesVillageParticleTypes.UNCLEAN_BLOOD_RAIN_DISPLAY.get(), JerotesVillageSoundEvents.MAGIC_UNCLEAN_BLOOD_RAIN){
			public boolean spellFindUse() {
				return OtherSpellFind.UncleanBloodRain(getCaster(), (getTarget() instanceof LivingEntity livingEntity) ? livingEntity : getCaster(), getSpellLevel() * 6, getSpellLevel() * 6, getSpellLevel(), 1, Main.mobHeight(getTarget()) + 2);
			}
			public String getSpellModId() {
				return JerotesVillage.MODID;
			}
			public float getSpellDistance() {
				return 32;
			}
			public boolean canUseTargetNone() {
				return true;
			}
		};
	}
	//不洁血雾
	public static MagicSpell UncleanBloodFog(int n, LivingEntity caster, Entity target) {
		return new MagicSpell(n, caster, target, MagicType.TARGET, MagicType.MAIN, "unclean_blood_fog", JerotesVillageParticleTypes.UNCLEAN_BLOOD_FOG_DISPLAY.get(), JerotesVillageSoundEvents.MAGIC_UNCLEAN_BLOOD_FOG){
			public boolean spellFindUse() {
				return OtherSpellFind.UncleanBloodFog(getCaster(), (getTarget() instanceof LivingEntity livingEntity) ? livingEntity : getCaster(), getSpellLevel() * 6, getSpellLevel() * 6, getSpellLevel(), getSpellLevel() * 6, getSpellLevel(),  5 + getSpellLevel());
			}
			public String getSpellModId() {
				return JerotesVillage.MODID;
			}
			public float getSpellDistance() {
				return 32;
			}
			public boolean canUseTargetNone() {
				return true;
			}
		};
	}
	//神汉低语
	public static MagicSpell WarlockWhisper(int n, LivingEntity caster, Entity target) {
		return new MagicSpell(n, caster, target, MagicType.SHOOT, MagicType.MAIN, "warlock_whisper", JerotesVillageParticleTypes.WARLOCK_WHISPER_DISPLAY.get(), JerotesVillageSoundEvents.MAGIC_WARLOCK_WHISPER){
			public boolean spellFindUse() {
				return OtherSpellFind.WarlockWhisper(getCaster(), getSpellLevel() + 1, getSpellLevel() * 15, getSpellLevel() - 1, getSpellLevel() * 15, 1, 16 + getSpellLevel() * 2, 12 + getSpellLevel() * 2, 1.0d + getSpellLevel() * 0.1f, 32);
			}
			public String getSpellModId() {
				return JerotesVillage.MODID;
			}
			public int baseSpellLevel() {
				return 2;
			}
			public float getSpellDistance() {
				return 32;
			}
		};
	}
	//不祥齿轮
	public static MagicSpell OminousGear(int n, LivingEntity caster, Entity target) {
		return new MagicSpell(n, caster, target, MagicType.SELF, MagicType.MAIN, "ominous_gear", JerotesVillageParticleTypes.OMINOUS_GEAR_DISPLAY.get(), JerotesVillageSoundEvents.MAGIC_OMINOUS_GEAR){
			public boolean spellFindUse() {
				return OtherSpellFind.OminousGear(getCaster(), getSpellLevel() * 2, getSpellLevel() * 4, 12);
			}
			public String getSpellModId() {
				return JerotesVillage.MODID;
			}
			public int baseSpellLevel() {
				return 2;
			}
			public float getSpellDistance() {
				return 12;
			}
		};
	}
	//邪祟召唤
	public static MagicSpell EvilSummoning(int n, LivingEntity caster, Entity target) {
		return new MagicSpell(n, caster, target, MagicType.TARGET, MagicType.MAIN, "evil_summoning", JerotesVillageParticleTypes.EVIL_SUMMONING_DISPLAY.get(), JerotesVillageSoundEvents.MAGIC_EVIL_SUMMONING){
			public boolean spellFindUse() {
				return OtherSpellFind.EvilSummoning(getCaster(), (getTarget() instanceof LivingEntity livingEntity) ? livingEntity : getCaster(), getSpellLevel() * 2, getSpellLevel() * 4, 4);
			}
			public String getSpellModId() {
				return JerotesVillage.MODID;
			}
			public int baseSpellLevel() {
				return 2;
			}
			public float getSpellDistance() {
				return 32;
			}
			public boolean canUseTargetNone() {
				return true;
			}
			public boolean canUse() {
				if (getCaster() != null) {
					List<UncleanTentacleEntity> list = getCaster().level().getEntitiesOfClass(UncleanTentacleEntity.class, getCaster().getBoundingBox().inflate(32.0, 32.0, 32.0));
					list.removeIf(summon -> summon.getOwner() != getCaster());
					return super.canUse() && list.size() <= getSpellLevel() * 2;
				}
				return super.canUse();
			}
		};
	}
	//苦寒祭坛
	public static MagicSpell BitterColdAltar(int n, LivingEntity caster, Entity target) {
		return new MagicSpell(n, caster, target, MagicType.SELF, MagicType.MAIN, "bitter_cold_altar", JerotesVillageParticleTypes.BITTER_COLD_ALTAR_DISPLAY.get(), JerotesVillageSoundEvents.MAGIC_BITTER_COLD_ALTAR){
			public boolean spellFindUse() {
				return OtherSpellFind.BitterColdAltar(getCaster(), 1, 1, 16);
			}
			public String getSpellModId() {
				return JerotesVillage.MODID;
			}
			public float getSpellDistance() {
				return 16;
			}
			public boolean canUse() {
				if (getCaster() != null) {
					List<BitterColdAltarEntity> list = getCaster().level().getEntitiesOfClass(BitterColdAltarEntity.class, getCaster().getBoundingBox().inflate(24.0, 24.0, 24.0));
					list.removeIf(summon -> summon.getOwner() != getCaster());
					return super.canUse() && list.isEmpty();
				}
				return super.canUse();
			}
		};
	}
}