package com.jerotes.jvpillage.init;

import com.jerotes.jvpillage.config.OtherMainConfig;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.entity.raid.Raider;

import java.util.ArrayList;
import java.util.List;

public class JVPillageRaider {
    public static final List<Raid.RaiderType> NEW_RAID_MEMBERS = new ArrayList<>();

    public static void addRaiders() {
        //探险者
        if (OtherMainConfig.RaidSpawnExplorer) {
            addWaves("EXPLORER", JVPillageEntityType.EXPLORER.get(), OtherMainConfig.RaidSpawnExplorerCount);
        }
        //行刑者
        if (OtherMainConfig.RaidSpawnExecutioner) {
            addWaves("EXECUTIONER", JVPillageEntityType.EXECUTIONER.get(), OtherMainConfig.RaidSpawnExecutionerCount);
        }
        //绘图者
        if (OtherMainConfig.RaidSpawnMapmaker) {
            addWaves("MAPMAKER", JVPillageEntityType.MAPMAKER.get(), OtherMainConfig.RaidSpawnMapmakerCount);
        }
        //背叛者
        if (OtherMainConfig.RaidSpawnDefector) {
            addWaves("DEFECTOR", JVPillageEntityType.DEFECTOR.get(), OtherMainConfig.RaidSpawnDefectorCount);
        }
        //执旗者
        if (OtherMainConfig.RaidSpawnBannerBearer) {
            addWaves("BANNER_BEARER", JVPillageEntityType.BANNER_BEARER.get(), OtherMainConfig.RaidSpawnBannerBearerCount);
        }
        //爆破者
        if (OtherMainConfig.RaidSpawnBlaster) {
            addWaves("BLASTER", JVPillageEntityType.BLASTER.get(), OtherMainConfig.RaidSpawnBlasterCount);
        }
        //吹号者
        if (OtherMainConfig.RaidSpawnTrumpeter) {
            addWaves("TRUMPETER", JVPillageEntityType.TRUMPETER.get(), OtherMainConfig.RaidSpawnTrumpeterCount);
        }
        //传送者
        if (OtherMainConfig.RaidSpawnTeleporter) {
            addWaves("TELEPORTER", JVPillageEntityType.TELEPORTER.get(), OtherMainConfig.RaidSpawnTeleporterCount);
        }
        //旋风者
        if (OtherMainConfig.RaidSpawnCycloner) {
            addWaves("CYCLONER", JVPillageEntityType.CYCLONER.get(), OtherMainConfig.RaidSpawnCyclonerCount);
        }
        //掷枪者
        if (OtherMainConfig.RaidSpawnJavelinThrower) {
            addWaves("JAVELIN_THROWER", JVPillageEntityType.JAVELIN_THROWER.get(), OtherMainConfig.RaidSpawnJavelinThrowerCount);
        }
        //养尸人
        if (OtherMainConfig.RaidSpawnZombieKeeper) {
            addWaves("ZOMBIE_KEEPER", JVPillageEntityType.ZOMBIE_KEEPER.get(), OtherMainConfig.RaidSpawnZombieKeeperCount);
        }
        //苦寒术士
        if (OtherMainConfig.RaidSpawnBitterColdSorcerer) {
            addWaves("BITTER_COLD_SORCERER", JVPillageEntityType.BITTER_COLD_SORCERER.get(), OtherMainConfig.RaidSpawnBitterColdSorcererCount);
        }
        //吐火者
        if (OtherMainConfig.RaidSpawnFireSpitter) {
            addWaves("FIRE_SPITTER", JVPillageEntityType.FIRE_SPITTER.get(), OtherMainConfig.RaidSpawnFireSpitterCount);
        }
        //野探客
        if (OtherMainConfig.RaidSpawnWildFinder) {
            addWaves("WILD_FINDER", JVPillageEntityType.WILD_FINDER.get(), OtherMainConfig.RaidSpawnWildFinderCount);
        }
        //潜海者
        if (OtherMainConfig.RaidSpawnSubmariner) {
            addWaves("SUBMARINER", JVPillageEntityType.SUBMARINER.get(), OtherMainConfig.RaidSpawnSubmarinerCount);
        }
        //灯术师
        if (OtherMainConfig.RaidSpawnLampWizard) {
            addWaves("LAMP_WIZARD", JVPillageEntityType.LAMP_WIZARD.get(), OtherMainConfig.RaidSpawnLampWizardCount);
        }
        //奴制监督者
        if (OtherMainConfig.RaidSpawnSlaverySupervisor) {
            addWaves("SLAVERY_SUPERVISOR", JVPillageEntityType.SLAVERY_SUPERVISOR.get(), OtherMainConfig.RaidSpawnSlaverySupervisorCount);
        }
        //火力倾泻者
        if (OtherMainConfig.RaidSpawnFirepowerPourer) {
            addWaves("FIREPOWER_POURER", JVPillageEntityType.FIREPOWER_POURER.get(), OtherMainConfig.RaidSpawnFirepowerPourerCount);
        }
        //巫神汉
        if (OtherMainConfig.RaidSpawnNecromancyWarlock) {
            addWaves("NECROMANCY_WARLOCK", JVPillageEntityType.NECROMANCY_WARLOCK.get(), OtherMainConfig.RaidSpawnNecromancyWarlockCount);
        }
        //引力师
        if (OtherMainConfig.RaidSpawnGaviler) {
            addWaves("GAVILER", JVPillageEntityType.GAVILER.get(), OtherMainConfig.RaidSpawnGavilerCount);
        }
        //斧头杀人狂
        if (OtherMainConfig.RaidSpawnAxCrazy) {
            addWaves("AX_CRAZY", JVPillageEntityType.AX_CRAZY.get(), OtherMainConfig.RaidSpawnAxCrazyCount);
        }
        //鬼婆
        if (OtherMainConfig.RaidSpawnHag) {
            addWaves("HAG", JVPillageEntityType.COHORT_HAG.get(), OtherMainConfig.RaidSpawnHagCount);
        }
        //女巫学者
        if (OtherMainConfig.RaidSpawnWitchScholar) {
            addWaves("WITCH_SCHOLAR", JVPillageEntityType.WITCH_SCHOLAR.get(), OtherMainConfig.RaidSpawnWitchScholarCount);
        }
        //紫沙女巫
        if (OtherMainConfig.RaidSpawnPurpleSandWitch) {
            addWaves("PURPLE_SAND_WITCH", JVPillageEntityType.PURPLE_SAND_WITCH.get(), OtherMainConfig.RaidSpawnPurpleSandWitchCount);
        }
        //灵奴
        if (OtherMainConfig.RaidSpawnSpirve) {
            addWaves("SPIRVE", JVPillageEntityType.SPIRVE.get(), OtherMainConfig.RaidSpawnSpirveCount);
        }
        //大巫婆
        if (OtherMainConfig.RaidSpawnBigWitch) {
            addWaves("BIG_WITCH", JVPillageEntityType.BIG_WITCH.get(), OtherMainConfig.RaidSpawnBigWitchCount);
        }
        //黑集会鬼婆
        if (OtherMainConfig.RaidSpawnCovenHagOne) {
            addWaves("COVEN_HAG_ONE", JVPillageEntityType.COVEN_HAG_ONE.get(), OtherMainConfig.RaidSpawnCovenHagOneCount);
        }
        //白集会鬼婆
        if (OtherMainConfig.RaidSpawnCovenHagTwo) {
            addWaves("COVEN_HAG_TWO", JVPillageEntityType.COVEN_HAG_TWO.get(), OtherMainConfig.RaidSpawnCovenHagTwoCount);
        }
        //灾厄旗帜投影
        if (OtherMainConfig.RaidSpawnOminousBannerProjection) {
            addWaves("OMINOUS_BANNER_PROJECTION", JVPillageEntityType.OMINOUS_BANNER_PROJECTION.get(), OtherMainConfig.RaidSpawnOminousBannerProjectionCount);
        }
        //紫沙鬼婆
        if (OtherMainConfig.RaidSpawnPurpleSandHag) {
            addWaves("PURPLE_SAND_HAG", JVPillageEntityType.PURPLE_SAND_HAG.get(), OtherMainConfig.RaidSpawnPurpleSandHagCount);
        }
    }

    private static Raid.RaiderType addWaves(String name, EntityType<? extends Raider> type, List<? extends Integer> list) {
        Raid.RaiderType member = Raid.RaiderType.create(name, type, new int[]{list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6), list.get(7)});
        NEW_RAID_MEMBERS.add(member);
        return member;
    }
}

