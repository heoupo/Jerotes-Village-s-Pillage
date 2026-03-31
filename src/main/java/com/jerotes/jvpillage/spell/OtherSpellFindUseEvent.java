package com.jerotes.jvpillage.spell;

import com.jerotes.jerotes.init.JerotesMobEffects;
import com.jerotes.jerotes.util.Main;
import com.jerotes.jvpillage.JVPillage;
import com.jerotes.jvpillage.entity.Shoot.Magic.MagicMissile.ArcaneLightSpotEntity;
import com.jerotes.jvpillage.entity.Shoot.Magic.MagicShoot.BitterColdFrostbiteEntity;
import com.jerotes.jvpillage.entity.Shoot.Magic.MagicShoot.OminousFlamesEntity;
import com.jerotes.jvpillage.init.JVPillageSoundEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.UUID;

@Mod.EventBusSubscriber(modid = JVPillage.MODID)
public class OtherSpellFindUseEvent {
    @SubscribeEvent
    public static void SpellTick(LivingEvent.LivingTickEvent event) {
        LivingEntity caster = event.getEntity();
        if (caster == null)
            return;
        //不祥火舌
        if (caster.getPersistentData().getDouble("jvpillage_ominous_flames") > 0) {
            caster.getPersistentData().putDouble("jvpillage_ominous_flames", caster.getPersistentData().getDouble("jvpillage_ominous_flames") - 1);
            caster.getPersistentData().putDouble("jerotes_spell_cooldown", Math.max(2, caster.getPersistentData().getDouble("jerotes_spell_cooldown")));
            if (caster.getPersistentData().getDouble("jvpillage_ominous_flames") % 3 == 0) {
                if (caster.level() instanceof ServerLevel serverLevel) {
                    int spellLevelDamage = caster.getPersistentData().getInt("jvpillage_ominous_flames_spellLevelDamage");
                    int spellLevelFireTime = caster.getPersistentData().getInt("jvpillage_ominous_flames_spellLevelFireTime");
                    float spellLevelAccuracy = caster.getPersistentData().getFloat("jvpillage_ominous_flames_spellLevelAccuracy");
                    int count = caster.getPersistentData().getInt("jvpillage_ominous_flames_count");
                    float distance = caster.getPersistentData().getFloat("jvpillage_ominous_flames_distance");
                    OminousFlamesEntity spell;
                    for (int i = 0; i < count; ++i) {
                        if (caster instanceof Mob mob && mob.getTarget() != null) {
                            mob.lookAt(mob.getTarget(), 360.0f, 360.0f);
                        }
                        double d2 = caster.getLookAngle().x;
                        double d3 = caster.getLookAngle().y;
                        double d4 = caster.getLookAngle().z;
                        spell = new OminousFlamesEntity(spellLevelDamage, spellLevelFireTime, serverLevel, caster, d2, d3, d4);
                        spell.setPos(caster.getX(), caster.getY(0.7), caster.getZ());
                        spell.shootFromRotation(caster, caster.getXRot(), (float) (caster.getYRot() - ((count - 1) * distance) / 2 + i * distance), 0f, 1.0f, spellLevelAccuracy);
                        spell.setOwner(caster);
                        serverLevel.addFreshEntity(spell);
                    }
                    if (!caster.isSilent()) {
                        caster.playSound(JVPillageSoundEvents.MAGIC_OMINOUS_FLAMES,
                               1.0f, 1.0F);
                    }
                }
            }
        }
        else {
            Main.persistentDataRemove(caster, "jvpillage_ominous_flames");
            Main.persistentDataRemove(caster, "jvpillage_ominous_flames_spellLevelDamage");
            Main.persistentDataRemove(caster, "jvpillage_ominous_flames_spellLevelFireTime");
            Main.persistentDataRemove(caster, "jvpillage_ominous_flames_spellLevelAccuracy");
            Main.persistentDataRemove(caster, "jvpillage_ominous_flames_count");
            Main.persistentDataRemove(caster, "jvpillage_ominous_flames_distance");
        }
        //苦寒冰霜
        if (caster.getPersistentData().getDouble("jvpillage_bitter_cold_frostbite") > 0) {
            caster.getPersistentData().putDouble("jvpillage_bitter_cold_frostbite", caster.getPersistentData().getDouble("jvpillage_bitter_cold_frostbite") - 1);
            caster.getPersistentData().putDouble("jerotes_spell_cooldown", Math.max(2, caster.getPersistentData().getDouble("jerotes_spell_cooldown")));
            if (caster.getPersistentData().getDouble("jvpillage_bitter_cold_frostbite") % 3 == 0) {
                if (caster.level() instanceof ServerLevel serverLevel) {
                    int spellLevelDamage = caster.getPersistentData().getInt("jvpillage_bitter_cold_frostbite_spellLevelDamage");
                    int spellLevelFireTime = caster.getPersistentData().getInt("jvpillage_bitter_cold_frostbite_spellLevelFreezeTime");
                    float spellLevelAccuracy = caster.getPersistentData().getFloat("jvpillage_bitter_cold_frostbite_spellLevelAccuracy");
                    int count = caster.getPersistentData().getInt("jvpillage_bitter_cold_frostbite_count");
                    float distance = caster.getPersistentData().getFloat("jvpillage_bitter_cold_frostbite_distance");
                    BitterColdFrostbiteEntity spell;
                    for (int i = 0; i < count; ++i) {
                        if (caster instanceof Mob mob && mob.getTarget() != null) {
                            mob.lookAt(mob.getTarget(), 360.0f, 360.0f);
                        }
                        double d2 = caster.getLookAngle().x;
                        double d3 = caster.getLookAngle().y;
                        double d4 = caster.getLookAngle().z;
                        spell = new BitterColdFrostbiteEntity(spellLevelDamage, spellLevelFireTime, serverLevel, caster, d2, d3, d4);
                        spell.setPos(caster.getX(), caster.getY(0.7), caster.getZ());
                        spell.shootFromRotation(caster, caster.getXRot(), (float) (caster.getYRot() - ((count - 1) * distance) / 2 + i * distance), 0f, 1.0f, spellLevelAccuracy);
                        spell.setOwner(caster);
                        serverLevel.addFreshEntity(spell);
                    }
                    if (!caster.isSilent()) {
                        caster.playSound(JVPillageSoundEvents.MAGIC_BITTER_COLD_FROSTBITE,
                               1.0f, 1.0F);
                    }
                }
            }
        }
        else {
            Main.persistentDataRemove(caster, "jvpillage_bitter_cold_frostbite");
            Main.persistentDataRemove(caster, "jvpillage_bitter_cold_frostbite_spellLevelDamage");
            Main.persistentDataRemove(caster, "jvpillage_bitter_cold_frostbite_spellLevelFreezeTime");
            Main.persistentDataRemove(caster, "jvpillage_bitter_cold_frostbite_spellLevelAccuracy");
            Main.persistentDataRemove(caster, "jvpillage_bitter_cold_frostbite_count");
            Main.persistentDataRemove(caster, "jvpillage_bitter_cold_frostbite_distance");
        }
        //奥术光点
        if (caster.getPersistentData().getDouble("jvpillage_arcane_light_spot") > 0) {
            caster.getPersistentData().putDouble("jvpillage_arcane_light_spot", caster.getPersistentData().getDouble("jvpillage_arcane_light_spot") - 1);
            caster.getPersistentData().putDouble("jerotes_spell_cooldown", Math.max(2, caster.getPersistentData().getDouble("jerotes_spell_cooldown")));
            if (caster.getPersistentData().getDouble("jvpillage_arcane_light_spot") % 3 == 0) {
                if (caster.level() instanceof ServerLevel serverLevel) {
                    UUID targetUUID = caster.getPersistentData().getUUID("jvpillage_arcane_light_spot_target");
                    int spellLevelDamage = caster.getPersistentData().getInt("jvpillage_arcane_light_spot_spellLevelDamage");
                    if (!(serverLevel.getEntity(targetUUID) instanceof LivingEntity livingEntity && livingEntity.hasEffect(JerotesMobEffects.COUNTERSPELL.get()) && livingEntity.getEffect(JerotesMobEffects.COUNTERSPELL.get()).getAmplifier() + 1 >= spellLevelDamage)) {
                        int spellLevelMainEffectTime = caster.getPersistentData().getInt("jvpillage_arcane_light_spot_spellLevelMainEffectTime");
                        int spellLevelMainEffectLevel = caster.getPersistentData().getInt("jvpillage_arcane_light_spot_spellLevelMainEffectLevel");
                        float spellLevelAccuracy = caster.getPersistentData().getFloat("jvpillage_arcane_light_spot_spellLevelAccuracy");
                        int count = caster.getPersistentData().getInt("jvpillage_arcane_light_spot_count");
                        float distance = caster.getPersistentData().getFloat("jvpillage_arcane_light_spot_distance");
                        ArcaneLightSpotEntity spell;
                        for (int i = 0; i < count; ++i) {
                            if (caster instanceof Mob mob && mob.getTarget() != null) {
                                mob.lookAt(mob.getTarget(), 360.0f, 360.0f);
                            }
                            double d2 = caster.getLookAngle().x;
                            double d3 = caster.getLookAngle().y;
                            double d4 = caster.getLookAngle().z;
                            spell = new ArcaneLightSpotEntity(spellLevelDamage, spellLevelMainEffectTime, spellLevelMainEffectLevel, serverLevel, caster, d2, d3, d4);
                            spell.setPos(caster.getX(), caster.getY(0.7), caster.getZ());
                            spell.shootFromRotation(caster, caster.getXRot(), (float) (caster.getYRot() - ((count - 1) * distance) / 2 + i * distance), 0f, 1.0f, spellLevelAccuracy);
                            spell.setOwner(caster);
                            if (serverLevel.getEntity(targetUUID) != null && serverLevel.getEntity(targetUUID) != caster) {
                                spell.setTarget(serverLevel.getEntity(targetUUID));
                            }
                            serverLevel.addFreshEntity(spell);
                        }
                        if (!caster.isSilent()) {
                            caster.playSound(JVPillageSoundEvents.MAGIC_ARCANE_LIGHT_SPOT,
                                    1.0f, 1.0F);
                        }
                    }
                }
            }
        }
        else {
            Main.persistentDataRemove(caster, "jvpillage_arcane_light_spot");
            Main.persistentDataRemove(caster, "jvpillage_arcane_light_spot_spellLevelDamage");
            Main.persistentDataRemove(caster, "jvpillage_arcane_light_spot_target");
            Main.persistentDataRemove(caster, "jvpillage_arcane_light_spot_spellLevelMainEffectTime");
            Main.persistentDataRemove(caster, "jvpillage_arcane_light_spot_spellLevelMainEffectLevel");
            Main.persistentDataRemove(caster, "jvpillage_arcane_light_spot_spellLevelAccuracy");
            Main.persistentDataRemove(caster, "jvpillage_arcane_light_spot_count");
            Main.persistentDataRemove(caster, "jvpillage_arcane_light_spot_distance");
        }
    }
    @SubscribeEvent
    public static void CasterDeath(LivingDeathEvent event) {
        LivingEntity caster = event.getEntity();
        if (caster == null)
            return;
        OtherSpellType.stops(caster, 10, true);
    }
}