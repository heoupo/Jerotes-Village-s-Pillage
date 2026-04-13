package com.jerotes.jvpillage.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.google.common.collect.Lists;
import com.jerotes.jvpillage.JVPillage;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Mod.EventBusSubscriber(modid = JVPillage.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class OtherMainConfig {
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final CommonConfig COMMON;
    public static final ForgeConfigSpec CLIENT_SPEC;
    public static final ClientConfig CLIENT;

    public static boolean SpecialDay;


    public static boolean CarvedObligation;
    public static boolean CarvedActiveAttackCreeper;
    public static List<String> CarvedGonnaActiveAttackList;
    public static List<String> CarvedNeverGonnaActiveAttack;
    public static List<String> CarvedCanNotAttackList;

    public static boolean RandomSkinMobHasUnderTexture;
    public static boolean PurpleSandEyeProtectionMode;
    public static boolean PurpleSandCustomColor;
    public static int PurpleSandCustomColorUse;
    public static boolean SomeEliteHasBossBarBaseInGameRule;
    public static boolean EliteBossBarOnlyCombat;
    public static List<String> EliteCanHasBossBar;
    public static boolean DefectorMustAttack;

    public static boolean SameTypeBossOnlyOne;
    public static boolean BossOnlyOne;
    public static double BossSpawnRestrictionRange;
    public static boolean SameTypeEliteOnlyOne;
    public static boolean EliteOnlyOne;
    public static double EliteSpawnRestrictionRange;
    public static boolean EliteAndBossOnlyOne;


    //探险者
    public static boolean RaidSpawnExplorer;
    public static List<? extends Integer> RaidSpawnExplorerCount;
    //行刑者
    public static boolean RaidSpawnExecutioner;
    public static List<? extends Integer> RaidSpawnExecutionerCount;
    //绘图者
    public static boolean RaidSpawnMapmaker;
    public static List<? extends Integer> RaidSpawnMapmakerCount;
    //背叛者
    public static boolean RaidSpawnDefector;
    public static List<? extends Integer> RaidSpawnDefectorCount;
    //执旗者
    public static boolean RaidSpawnBannerBearer;
    public static List<? extends Integer> RaidSpawnBannerBearerCount;
    //爆破者
    public static boolean RaidSpawnBlaster;
    public static List<? extends Integer> RaidSpawnBlasterCount;
    //吹号者
    public static boolean RaidSpawnTrumpeter;
    public static List<? extends Integer> RaidSpawnTrumpeterCount;
    //传送者
    public static boolean RaidSpawnTeleporter;
    public static List<? extends Integer> RaidSpawnTeleporterCount;
    //旋风者
    public static boolean RaidSpawnCycloner;
    public static List<? extends Integer> RaidSpawnCyclonerCount;
    //掷枪者
    public static boolean RaidSpawnJavelinThrower;
    public static List<? extends Integer> RaidSpawnJavelinThrowerCount;
    //养尸人
    public static boolean RaidSpawnZombieKeeper;
    public static List<? extends Integer> RaidSpawnZombieKeeperCount;
    //苦寒术士
    public static boolean RaidSpawnBitterColdSorcerer;
    public static List<? extends Integer> RaidSpawnBitterColdSorcererCount;
    //吐火者
    public static boolean RaidSpawnFireSpitter;
    public static List<? extends Integer> RaidSpawnFireSpitterCount;
    //野探客
    public static boolean RaidSpawnWildFinder;
    public static List<? extends Integer> RaidSpawnWildFinderCount;
    //潜海者
    public static boolean RaidSpawnSubmariner;
    public static List<? extends Integer> RaidSpawnSubmarinerCount;
    //灯术师
    public static boolean RaidSpawnLampWizard;
    public static List<? extends Integer> RaidSpawnLampWizardCount;
    //奴制监督者
    public static boolean RaidSpawnSlaverySupervisor;
    public static List<? extends Integer> RaidSpawnSlaverySupervisorCount;
    //火力倾泻者
    public static boolean RaidSpawnFirepowerPourer;
    public static List<? extends Integer> RaidSpawnFirepowerPourerCount;
    //巫神汉
    public static boolean RaidSpawnNecromancyWarlock;
    public static List<? extends Integer> RaidSpawnNecromancyWarlockCount;
    //引力师
    public static boolean RaidSpawnGaviler;
    public static List<? extends Integer> RaidSpawnGavilerCount;
    //斧头杀人狂
    public static boolean RaidSpawnAxCrazy;
    public static List<? extends Integer> RaidSpawnAxCrazyCount;
    //鬼婆
    public static boolean RaidSpawnHag;
    public static List<? extends Integer> RaidSpawnHagCount;
    //女巫学者
    public static boolean RaidSpawnWitchScholar;
    public static List<? extends Integer> RaidSpawnWitchScholarCount;
    //紫沙女巫
    public static boolean RaidSpawnPurpleSandWitch;
    public static List<? extends Integer> RaidSpawnPurpleSandWitchCount;
    //灵奴
    public static boolean RaidSpawnSpirve;
    public static List<? extends Integer> RaidSpawnSpirveCount;
    //怒化恶怨巫神汉
    public static boolean RaidSpawnFuryBlamerNecromancyWarlock;
    public static List<? extends Integer> RaidSpawnFuryBlamerNecromancyWarlockCount;
    //大巫婆
    public static boolean RaidSpawnBigWitch;
    public static List<? extends Integer> RaidSpawnBigWitchCount;
    //黑集会鬼婆
    public static boolean RaidSpawnCovenHagOne;
    public static List<? extends Integer> RaidSpawnCovenHagOneCount;
    //白集会鬼婆
    public static boolean RaidSpawnCovenHagTwo;
    public static List<? extends Integer> RaidSpawnCovenHagTwoCount;
    //灾厄旗帜投影
    public static boolean RaidSpawnOminousBannerProjection;
    public static List<? extends Integer> RaidSpawnOminousBannerProjectionCount;
    //紫沙鬼婆
    public static boolean RaidSpawnPurpleSandHag;
    public static List<? extends Integer> RaidSpawnPurpleSandHagCount;

    //Boss
    public static boolean BossBaseAttributeCanUseConfig;
    public static boolean RaidBossCanIncreaseSummonCountBasedOnPlayerCount;
    public static double RaidBossCanIncreaseSummonCountBasedOnPlayerCountFindReach;
    public static int RaidBossCanIncreaseSummonCountBasedOnPlayerCountMaxCount;
    public static boolean RaidBossCanIncreaseSummonCountBasedOnPlayerCountContainAllBoss;
    public static List<String> RaidBossCanIncreaseSummonCountBasedOnPlayerCountContainBoss;
    public static List<String> BossHasPercentageDamage;
    public static List<String> BossHasDamageCap;
    public static List<String> BossHasDamageCooldownTick;
    //灾厄旗帜投影
    public static int OminousBannerProjectionBossBarColor;
    public static int OminousBannerProjectionBossBarNameColor;
    public static double OminousBannerProjectionMaxHealth;
    public static double OminousBannerProjectionMeleeDamage;
    public static double OminousBannerProjectionArmor;
    public static double OminousBannerProjectionMovementSpeed;
    public static double OminousBannerProjectionAttackKnockback;
    public static double OminousBannerProjectionKnockbackResistance;
    public static double OminousBannerProjectionRoundTimeMin;
    public static double OminousBannerProjectionRoundTimeMax;
    public static int OminousBannerProjectionMaxRound;
    public static double OminousBannerProjectionPointsBase;
    public static double OminousBannerProjectionPointsRoundGrowthMultiple;
    public static boolean OminousBannerProjectionAXCrazyCanAppear;
    public static boolean OminousBannerProjectionBiomeIllagerCanAppearInOtherBiome;
    public static int OminousBannerProjectionEliteCount;
    public static double OminousBannerProjectionAttackPercentage;
    public static double OminousBannerProjectionMagicAttackPercentage;
    public static double OminousBannerProjectionDamageCap;
    public static double OminousBannerProjectionDamageCooldownTick;
    //紫沙鬼婆
    public static int PurpleSandHagBossBarColor;
    public static int PurpleSandHagBossBarNameColor;
    public static double PurpleSandHagMaxHealth;
    public static double PurpleSandHagMeleeDamage;
    public static double PurpleSandHagArmor;
    public static double PurpleSandHagMovementSpeed;
    public static double PurpleSandHagAttackKnockback;
    public static double PurpleSandHagKnockbackResistance;
    public static double PurpleSandHagMainSpellCooldown;
    public static double PurpleSandHagOtherSpellCooldown;
    public static int PurpleSandHagSpellNormalLevel;
    public static double PurpleSandHagAttackPercentage;
    public static double PurpleSandHagMagicAttackPercentage;
    public static double PurpleSandHagDamageCap;
    public static double PurpleSandHagDamageCooldownTick;

    static {
        final Pair<CommonConfig, ForgeConfigSpec> pair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        COMMON = pair.getLeft();
        COMMON_SPEC = pair.getRight();
        final Pair<ClientConfig, ForgeConfigSpec> pair1 = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
        CLIENT = pair1.getLeft();
        CLIENT_SPEC = pair1.getRight();
    }

    public static void loadConfig(ForgeConfigSpec config, String path) {
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave()
                .writingMode(WritingMode.REPLACE).build();
        file.load();
        config.setConfig(file);
    }

    public static void bakeCommonConfig() {
        SpecialDay = COMMON.SpecialDay.get();

        CarvedObligation = COMMON.CarvedObligation.get();
        CarvedActiveAttackCreeper = COMMON.CarvedActiveAttackCreeper.get();
        CarvedGonnaActiveAttackList = COMMON.CarvedGonnaActiveAttackList.get();
        CarvedNeverGonnaActiveAttack = COMMON.CarvedNeverGonnaActiveAttackList.get();
        CarvedCanNotAttackList = COMMON.CarvedCanNotAttackList.get();

        RandomSkinMobHasUnderTexture = COMMON.RandomSkinMobHasUnderTexture.get();
        PurpleSandEyeProtectionMode = COMMON.PurpleSandEyeProtectionMode.get();
        PurpleSandCustomColor = COMMON.PurpleSandCustomColor.get();
        PurpleSandCustomColorUse = COMMON.PurpleSandCustomColorUse.get();
        SomeEliteHasBossBarBaseInGameRule = COMMON.SomeEliteHasBossBarBaseInGameRule.get();
        EliteBossBarOnlyCombat = COMMON.EliteBossBarOnlyCombat.get();
        EliteCanHasBossBar = COMMON.EliteCanHasBossBar.get();
        DefectorMustAttack = COMMON.DefectorMustAttack.get();

        SameTypeBossOnlyOne = COMMON.SameTypeBossOnlyOne.get();
        BossOnlyOne = COMMON.BossOnlyOne.get();
        BossSpawnRestrictionRange = COMMON.BossSpawnRestrictionRange.get();
        SameTypeEliteOnlyOne = COMMON.SameTypeEliteOnlyOne.get();
        EliteOnlyOne = COMMON.EliteOnlyOne.get();
        EliteSpawnRestrictionRange = COMMON.EliteSpawnRestrictionRange.get();
        EliteAndBossOnlyOne = COMMON.EliteAndBossOnlyOne.get();


        //探险者
        RaidSpawnExplorer = COMMON.RaidSpawnExplorer.get();
        RaidSpawnExplorerCount = COMMON.RaidSpawnExplorerCount.get();
        //行刑者
        RaidSpawnExecutioner = COMMON.RaidSpawnExecutioner.get();
        RaidSpawnExecutionerCount = COMMON.RaidSpawnExecutionerCount.get();
        //绘图者
        RaidSpawnMapmaker = COMMON.RaidSpawnMapmaker.get();
        RaidSpawnMapmakerCount = COMMON.RaidSpawnMapmakerCount.get();
        //背叛者
        RaidSpawnDefector = COMMON.RaidSpawnDefector.get();
        RaidSpawnDefectorCount = COMMON.RaidSpawnDefectorCount.get();
        //执旗者
        RaidSpawnBannerBearer = COMMON.RaidSpawnBannerBearer.get();
        RaidSpawnBannerBearerCount = COMMON.RaidSpawnBannerBearerCount.get();
        //爆破者
        RaidSpawnBlaster = COMMON.RaidSpawnBlaster.get();
        RaidSpawnBlasterCount = COMMON.RaidSpawnBlasterCount.get();
        //吹号者
        RaidSpawnTrumpeter = COMMON.RaidSpawnTrumpeter.get();
        RaidSpawnTrumpeterCount = COMMON.RaidSpawnTrumpeterCount.get();
        //传送者
        RaidSpawnTeleporter = COMMON.RaidSpawnTeleporter.get();
        RaidSpawnTeleporterCount = COMMON.RaidSpawnTeleporterCount.get();
        //旋风者
        RaidSpawnCycloner = COMMON.RaidSpawnCycloner.get();
        RaidSpawnCyclonerCount = COMMON.RaidSpawnCyclonerCount.get();
        //掷枪者
        RaidSpawnJavelinThrower = COMMON.RaidSpawnJavelinThrower.get();
        RaidSpawnJavelinThrowerCount = COMMON.RaidSpawnJavelinThrowerCount.get();
        //养尸人
        RaidSpawnZombieKeeper = COMMON.RaidSpawnZombieKeeper.get();
        RaidSpawnZombieKeeperCount = COMMON.RaidSpawnZombieKeeperCount.get();
        //苦寒术士
        RaidSpawnBitterColdSorcerer = COMMON.RaidSpawnBitterColdSorcerer.get();
        RaidSpawnBitterColdSorcererCount = COMMON.RaidSpawnBitterColdSorcererCount.get();
        //吐火者
        RaidSpawnFireSpitter = COMMON.RaidSpawnFireSpitter.get();
        RaidSpawnFireSpitterCount = COMMON.RaidSpawnFireSpitterCount.get();
        //野探客
        RaidSpawnWildFinder = COMMON.RaidSpawnWildFinder.get();
        RaidSpawnWildFinderCount = COMMON.RaidSpawnWildFinderCount.get();
        //潜海者
        RaidSpawnSubmariner = COMMON.RaidSpawnSubmariner.get();
        RaidSpawnSubmarinerCount = COMMON.RaidSpawnSubmarinerCount.get();
        //灯术师
        RaidSpawnLampWizard = COMMON.RaidSpawnLampWizard.get();
        RaidSpawnLampWizardCount = COMMON.RaidSpawnLampWizardCount.get();
        //奴制监督者
        RaidSpawnSlaverySupervisor = COMMON.RaidSpawnSlaverySupervisor.get();
        RaidSpawnSlaverySupervisorCount = COMMON.RaidSpawnSlaverySupervisorCount.get();
        //火力倾泻者
        RaidSpawnFirepowerPourer = COMMON.RaidSpawnFirepowerPourer.get();
        RaidSpawnFirepowerPourerCount = COMMON.RaidSpawnFirepowerPourerCount.get();
        //巫神汉
        RaidSpawnNecromancyWarlock = COMMON.RaidSpawnNecromancyWarlock.get();
        RaidSpawnNecromancyWarlockCount = COMMON.RaidSpawnNecromancyWarlockCount.get();
        //引力师
        RaidSpawnGaviler = COMMON.RaidSpawnGaviler.get();
        RaidSpawnGavilerCount = COMMON.RaidSpawnGavilerCount.get();
        //斧头杀人狂
        RaidSpawnAxCrazy = COMMON.RaidSpawnAxCrazy.get();
        RaidSpawnAxCrazyCount = COMMON.RaidSpawnAxCrazyCount.get();
        //鬼婆
        RaidSpawnHag = COMMON.RaidSpawnHag.get();
        RaidSpawnHagCount = COMMON.RaidSpawnHagCount.get();
        //女巫学者
        RaidSpawnWitchScholar = COMMON.RaidSpawnWitchScholar.get();
        RaidSpawnWitchScholarCount = COMMON.RaidSpawnWitchScholarCount.get();
        //紫沙女巫
        RaidSpawnPurpleSandWitch = COMMON.RaidSpawnPurpleSandWitch.get();
        RaidSpawnPurpleSandWitchCount = COMMON.RaidSpawnPurpleSandWitchCount.get();
        //灵奴
        RaidSpawnSpirve = COMMON.RaidSpawnSpirve.get();
        RaidSpawnSpirveCount = COMMON.RaidSpawnSpirveCount.get();
        //怒化恶怨巫神汉
        RaidSpawnFuryBlamerNecromancyWarlock = COMMON.RaidSpawnFuryBlamerNecromancyWarlock.get();
        RaidSpawnFuryBlamerNecromancyWarlockCount = COMMON.RaidSpawnFuryBlamerNecromancyWarlockCount.get();
        //大巫婆
        RaidSpawnBigWitch = COMMON.RaidSpawnBigWitch.get();
        RaidSpawnBigWitchCount = COMMON.RaidSpawnBigWitchCount.get();
        //黑集会鬼婆
        RaidSpawnCovenHagOne = COMMON.RaidSpawnCovenHagOne.get();
        RaidSpawnCovenHagOneCount = COMMON.RaidSpawnCovenHagOneCount.get();
        //白集会鬼婆
        RaidSpawnCovenHagTwo = COMMON.RaidSpawnCovenHagTwo.get();
        RaidSpawnCovenHagTwoCount = COMMON.RaidSpawnCovenHagTwoCount.get();
        //灾厄旗帜投影
        RaidSpawnOminousBannerProjection = COMMON.RaidSpawnOminousBannerProjection.get();
        RaidSpawnOminousBannerProjectionCount = COMMON.RaidSpawnOminousBannerProjectionCount.get();
        //紫沙鬼婆
        RaidSpawnPurpleSandHag = COMMON.RaidSpawnPurpleSandHag.get();
        RaidSpawnPurpleSandHagCount = COMMON.RaidSpawnPurpleSandHagCount.get();

        BossBaseAttributeCanUseConfig = COMMON.BossBaseAttributeCanUseConfig.get();
        RaidBossCanIncreaseSummonCountBasedOnPlayerCount = COMMON.RaidBossCanIncreaseSummonCountBasedOnPlayerCount.get();
        RaidBossCanIncreaseSummonCountBasedOnPlayerCountFindReach = COMMON.RaidBossCanIncreaseSummonCountBasedOnPlayerCountFindReach.get();
        RaidBossCanIncreaseSummonCountBasedOnPlayerCountMaxCount = COMMON.RaidBossCanIncreaseSummonCountBasedOnPlayerCountMaxCount.get();
        RaidBossCanIncreaseSummonCountBasedOnPlayerCountContainAllBoss = COMMON.RaidBossCanIncreaseSummonCountBasedOnPlayerCountContainAllBoss.get();
        RaidBossCanIncreaseSummonCountBasedOnPlayerCountContainBoss = COMMON.RaidBossCanIncreaseSummonCountBasedOnPlayerCountContainBoss.get();
        BossHasPercentageDamage = COMMON.BossHasPercentageDamage.get();
        BossHasDamageCap = COMMON.BossHasDamageCap.get();
        BossHasDamageCooldownTick = COMMON.BossHasDamageCooldownTick.get();
        //灾厄旗帜投影
        OminousBannerProjectionBossBarColor = COMMON.OminousBannerProjectionBossBarColor.get();
        OminousBannerProjectionBossBarNameColor = COMMON.OminousBannerProjectionBossBarNameColor.get();
        OminousBannerProjectionMaxHealth = COMMON.OminousBannerProjectionMaxHealth.get();
        OminousBannerProjectionMeleeDamage = COMMON.OminousBannerProjectionMeleeDamage.get();
        OminousBannerProjectionArmor = COMMON.OminousBannerProjectionArmor.get();
        OminousBannerProjectionMovementSpeed = COMMON.OminousBannerProjectionMovementSpeed.get();
        OminousBannerProjectionAttackKnockback = COMMON.OminousBannerProjectionAttackKnockback.get();
        OminousBannerProjectionKnockbackResistance = COMMON.OminousBannerProjectionKnockbackResistance.get();
        OminousBannerProjectionRoundTimeMin = COMMON.OminousBannerProjectionRoundTimeMin.get();
        OminousBannerProjectionRoundTimeMax = COMMON.OminousBannerProjectionRoundTimeMax.get();
        OminousBannerProjectionMaxRound = COMMON.OminousBannerProjectionMaxRound.get();
        OminousBannerProjectionPointsBase = COMMON.OminousBannerProjectionPointsBase.get();
        OminousBannerProjectionPointsRoundGrowthMultiple = COMMON.OminousBannerProjectionPointsRoundGrowthMultiple.get();
        OminousBannerProjectionAXCrazyCanAppear = COMMON.OminousBannerProjectionAXCrazyCanAppear.get();
        OminousBannerProjectionBiomeIllagerCanAppearInOtherBiome = COMMON.OminousBannerProjectionBiomeIllagerCanAppearInOtherBiome.get();
        OminousBannerProjectionEliteCount = COMMON.OminousBannerProjectionEliteCount.get();
        OminousBannerProjectionAttackPercentage = COMMON.OminousBannerProjectionAttackPercentage.get();
        OminousBannerProjectionMagicAttackPercentage = COMMON.OminousBannerProjectionMagicAttackPercentage.get();
        OminousBannerProjectionDamageCap = COMMON.OminousBannerProjectionDamageCap.get();
        OminousBannerProjectionDamageCooldownTick = COMMON.OminousBannerProjectionDamageCooldownTick.get();
        //紫沙鬼婆
        PurpleSandHagBossBarColor = COMMON.PurpleSandHagBossBarColor.get();
        PurpleSandHagBossBarNameColor = COMMON.PurpleSandHagBossBarNameColor.get();
        PurpleSandHagMaxHealth = COMMON.PurpleSandHagMaxHealth.get();
        PurpleSandHagMeleeDamage = COMMON.PurpleSandHagMeleeDamage.get();
        PurpleSandHagArmor = COMMON.PurpleSandHagArmor.get();
        PurpleSandHagMovementSpeed = COMMON.PurpleSandHagMovementSpeed.get();
        PurpleSandHagAttackKnockback = COMMON.PurpleSandHagAttackKnockback.get();
        PurpleSandHagKnockbackResistance = COMMON.PurpleSandHagKnockbackResistance.get();
        PurpleSandHagMainSpellCooldown = COMMON.PurpleSandHagMainSpellCooldown.get();
        PurpleSandHagOtherSpellCooldown = COMMON.PurpleSandHagOtherSpellCooldown.get();
        PurpleSandHagSpellNormalLevel = COMMON.PurpleSandHagSpellNormalLevel.get();
        PurpleSandHagAttackPercentage = COMMON.PurpleSandHagAttackPercentage.get();
        PurpleSandHagMagicAttackPercentage = COMMON.PurpleSandHagMagicAttackPercentage.get();
        PurpleSandHagDamageCap = COMMON.PurpleSandHagDamageCap.get();
        PurpleSandHagDamageCooldownTick = COMMON.PurpleSandHagDamageCooldownTick.get();
    }

    public static void bakeClientConfig() {
    }

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfigEvent.Loading configEvent) {
        if (configEvent.getConfig().getSpec() == OtherMainConfig.COMMON_SPEC) {
            bakeCommonConfig();
        } else if (configEvent.getConfig().getSpec() == OtherMainConfig.CLIENT_SPEC) {
            bakeClientConfig();
        }
    }

    public static class CommonConfig {
        public final ForgeConfigSpec.BooleanValue SpecialDay;

        public final ForgeConfigSpec.BooleanValue CarvedObligation;
        public final ForgeConfigSpec.BooleanValue CarvedActiveAttackCreeper;
        public final ForgeConfigSpec.ConfigValue<List<String>> CarvedGonnaActiveAttackList;
        public final ForgeConfigSpec.ConfigValue<List<String>> CarvedNeverGonnaActiveAttackList;
        public final ForgeConfigSpec.ConfigValue<List<String>> CarvedCanNotAttackList;

        public final ForgeConfigSpec.BooleanValue RandomSkinMobHasUnderTexture;
        public final ForgeConfigSpec.BooleanValue PurpleSandEyeProtectionMode;
        public final ForgeConfigSpec.BooleanValue PurpleSandCustomColor;
        public final ForgeConfigSpec.IntValue PurpleSandCustomColorUse;
        public final ForgeConfigSpec.BooleanValue SomeEliteHasBossBarBaseInGameRule;
        public final ForgeConfigSpec.BooleanValue EliteBossBarOnlyCombat;
        public final ForgeConfigSpec.ConfigValue<List<String>> EliteCanHasBossBar;
        public final ForgeConfigSpec.BooleanValue DefectorMustAttack;

        public final ForgeConfigSpec.BooleanValue SameTypeBossOnlyOne;
        public final ForgeConfigSpec.BooleanValue BossOnlyOne;
        public final ForgeConfigSpec.DoubleValue BossSpawnRestrictionRange;
        public final ForgeConfigSpec.BooleanValue SameTypeEliteOnlyOne;
        public final ForgeConfigSpec.BooleanValue EliteOnlyOne;
        public final ForgeConfigSpec.DoubleValue EliteSpawnRestrictionRange;
        public final ForgeConfigSpec.BooleanValue EliteAndBossOnlyOne;

        //探险者
        public final ForgeConfigSpec.BooleanValue RaidSpawnExplorer;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnExplorerCount;
        //行刑者
        public final ForgeConfigSpec.BooleanValue RaidSpawnExecutioner;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnExecutionerCount;
        //绘图者
        public final ForgeConfigSpec.BooleanValue RaidSpawnMapmaker;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnMapmakerCount;
        //背叛者
        public final ForgeConfigSpec.BooleanValue RaidSpawnDefector;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnDefectorCount;
        //执旗者
        public final ForgeConfigSpec.BooleanValue RaidSpawnBannerBearer;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnBannerBearerCount;
        //爆破者
        public final ForgeConfigSpec.BooleanValue RaidSpawnBlaster;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnBlasterCount;
        //吹号者
        public final ForgeConfigSpec.BooleanValue RaidSpawnTrumpeter;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnTrumpeterCount;
        //传送者
        public final ForgeConfigSpec.BooleanValue RaidSpawnTeleporter;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnTeleporterCount;
        //旋风者
        public final ForgeConfigSpec.BooleanValue RaidSpawnCycloner;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnCyclonerCount;
        //掷枪者
        public final ForgeConfigSpec.BooleanValue RaidSpawnJavelinThrower;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnJavelinThrowerCount;
        //养尸人
        public final ForgeConfigSpec.BooleanValue RaidSpawnZombieKeeper;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnZombieKeeperCount;
        //苦寒术士
        public final ForgeConfigSpec.BooleanValue RaidSpawnBitterColdSorcerer;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnBitterColdSorcererCount;
        //吐火者
        public final ForgeConfigSpec.BooleanValue RaidSpawnFireSpitter;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnFireSpitterCount;
        //野探客
        public final ForgeConfigSpec.BooleanValue RaidSpawnWildFinder;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnWildFinderCount;
        //潜海者
        public final ForgeConfigSpec.BooleanValue RaidSpawnSubmariner;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnSubmarinerCount;
        //灯术师
        public final ForgeConfigSpec.BooleanValue RaidSpawnLampWizard;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnLampWizardCount;
        //奴制监督者
        public final ForgeConfigSpec.BooleanValue RaidSpawnSlaverySupervisor;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnSlaverySupervisorCount;
        //火力倾泻者
        public final ForgeConfigSpec.BooleanValue RaidSpawnFirepowerPourer;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnFirepowerPourerCount;
        //巫神汉
        public final ForgeConfigSpec.BooleanValue RaidSpawnNecromancyWarlock;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnNecromancyWarlockCount;
        //引力师
        public final ForgeConfigSpec.BooleanValue RaidSpawnGaviler;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnGavilerCount;
        //斧头杀人狂
        public final ForgeConfigSpec.BooleanValue RaidSpawnAxCrazy;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnAxCrazyCount;
        //鬼婆
        public final ForgeConfigSpec.BooleanValue RaidSpawnHag;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnHagCount;
        //女巫学者
        public final ForgeConfigSpec.BooleanValue RaidSpawnWitchScholar;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnWitchScholarCount;
        //紫沙女巫
        public final ForgeConfigSpec.BooleanValue RaidSpawnPurpleSandWitch;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnPurpleSandWitchCount;
        //灵奴
        public final ForgeConfigSpec.BooleanValue RaidSpawnSpirve;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnSpirveCount;
        //怒化恶怨巫神汉
        public final ForgeConfigSpec.BooleanValue RaidSpawnFuryBlamerNecromancyWarlock;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnFuryBlamerNecromancyWarlockCount;
        //大巫婆
        public final ForgeConfigSpec.BooleanValue RaidSpawnBigWitch;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnBigWitchCount;
        //黑集会鬼婆
        public final ForgeConfigSpec.BooleanValue RaidSpawnCovenHagOne;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnCovenHagOneCount;
        //白集会鬼婆
        public final ForgeConfigSpec.BooleanValue RaidSpawnCovenHagTwo;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnCovenHagTwoCount;
        //灾厄旗帜投影
        public final ForgeConfigSpec.BooleanValue RaidSpawnOminousBannerProjection;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnOminousBannerProjectionCount;
        //紫沙鬼婆
        public final ForgeConfigSpec.BooleanValue RaidSpawnPurpleSandHag;
        public final ForgeConfigSpec.ConfigValue<List<? extends Integer>> RaidSpawnPurpleSandHagCount;

        public final ForgeConfigSpec.BooleanValue BossBaseAttributeCanUseConfig;
        public final ForgeConfigSpec.BooleanValue RaidBossCanIncreaseSummonCountBasedOnPlayerCount;
        public final ForgeConfigSpec.DoubleValue RaidBossCanIncreaseSummonCountBasedOnPlayerCountFindReach;
        public final ForgeConfigSpec.IntValue RaidBossCanIncreaseSummonCountBasedOnPlayerCountMaxCount;
        public final ForgeConfigSpec.BooleanValue RaidBossCanIncreaseSummonCountBasedOnPlayerCountContainAllBoss;
        public final ForgeConfigSpec.ConfigValue<List<String>> RaidBossCanIncreaseSummonCountBasedOnPlayerCountContainBoss;
        public final ForgeConfigSpec.ConfigValue<List<String>> BossHasPercentageDamage;
        public final ForgeConfigSpec.ConfigValue<List<String>> BossHasDamageCap;
        public final ForgeConfigSpec.ConfigValue<List<String>> BossHasDamageCooldownTick;
    //灾厄旗帜投影
        public final ForgeConfigSpec.IntValue OminousBannerProjectionBossBarColor;
        public final ForgeConfigSpec.IntValue OminousBannerProjectionBossBarNameColor;
        public final ForgeConfigSpec.DoubleValue OminousBannerProjectionMaxHealth;
        public final ForgeConfigSpec.DoubleValue OminousBannerProjectionMeleeDamage;
        public final ForgeConfigSpec.DoubleValue OminousBannerProjectionArmor;
        public final ForgeConfigSpec.DoubleValue OminousBannerProjectionMovementSpeed;
        public final ForgeConfigSpec.DoubleValue OminousBannerProjectionAttackKnockback;
        public final ForgeConfigSpec.DoubleValue OminousBannerProjectionKnockbackResistance;
        public final ForgeConfigSpec.DoubleValue OminousBannerProjectionRoundTimeMin;
        public final ForgeConfigSpec.DoubleValue OminousBannerProjectionRoundTimeMax;
        public final ForgeConfigSpec.IntValue OminousBannerProjectionMaxRound;
        public final ForgeConfigSpec.DoubleValue OminousBannerProjectionPointsBase;
        public final ForgeConfigSpec.DoubleValue OminousBannerProjectionPointsRoundGrowthMultiple;
        public final ForgeConfigSpec.BooleanValue OminousBannerProjectionAXCrazyCanAppear;
        public final ForgeConfigSpec.BooleanValue OminousBannerProjectionBiomeIllagerCanAppearInOtherBiome;
        public final ForgeConfigSpec.IntValue OminousBannerProjectionEliteCount;
        public final ForgeConfigSpec.DoubleValue OminousBannerProjectionAttackPercentage;
        public final ForgeConfigSpec.DoubleValue OminousBannerProjectionMagicAttackPercentage;
        public final ForgeConfigSpec.DoubleValue OminousBannerProjectionDamageCap;
        public final ForgeConfigSpec.DoubleValue OminousBannerProjectionDamageCooldownTick;
    //紫沙鬼婆
        public final ForgeConfigSpec.IntValue PurpleSandHagBossBarColor;
        public final ForgeConfigSpec.IntValue PurpleSandHagBossBarNameColor;
        public final ForgeConfigSpec.DoubleValue PurpleSandHagMaxHealth;
        public final ForgeConfigSpec.DoubleValue PurpleSandHagMeleeDamage;
        public final ForgeConfigSpec.DoubleValue PurpleSandHagArmor;
        public final ForgeConfigSpec.DoubleValue PurpleSandHagMovementSpeed;
        public final ForgeConfigSpec.DoubleValue PurpleSandHagAttackKnockback;
        public final ForgeConfigSpec.DoubleValue PurpleSandHagKnockbackResistance;
        public final ForgeConfigSpec.DoubleValue PurpleSandHagMainSpellCooldown;
        public final ForgeConfigSpec.DoubleValue PurpleSandHagOtherSpellCooldown;
        public final ForgeConfigSpec.IntValue PurpleSandHagSpellNormalLevel;
        public final ForgeConfigSpec.DoubleValue PurpleSandHagAttackPercentage;
        public final ForgeConfigSpec.DoubleValue PurpleSandHagMagicAttackPercentage;
        public final ForgeConfigSpec.DoubleValue PurpleSandHagDamageCap;
        public final ForgeConfigSpec.DoubleValue PurpleSandHagDamageCooldownTick;

        public CommonConfig(ForgeConfigSpec.Builder builder) {
            builder.push(" ");
            builder.pop();
            builder.push("Others");
            SpecialDay = builder.comment("Special Day")
                    .define("特殊日期", true);
            builder.pop();

            builder.push("Carved Faction");
            CarvedObligation = builder.comment("Carved Obligation")
                    .define("铜刻佣兵团是否主动攻击僵尸类[Zombies]、袭击类生物[Raiders]以外[other than]的敌对生物", true);
            CarvedActiveAttackCreeper = builder.comment("Carved Active Attack Creeper")
                    .define("铜刻佣兵团主动攻击苦力怕[Creeper]", false);
            CarvedGonnaActiveAttackList = builder.comment("Carved Gonna Active Attack List")
                    .define("铜刻佣兵团 会主动攻击生物", Lists.newArrayList("minecraft:zombie"));
            CarvedNeverGonnaActiveAttackList = builder.comment("Carved Never Gonna Active Attack List")
                    .define("铜刻佣兵团 不会主动攻击生物", Lists.newArrayList("minecraft:villager", "minecraft:iron_golem", "minecraft:wandering_trader"));
            CarvedCanNotAttackList = builder.comment("Carved Can Not Attack List")
                    .define("铜刻佣兵团 无法攻击生物", Lists.newArrayList("minecraft:villager", "minecraft:wandering_trader"));

            builder.push("Other");
            RandomSkinMobHasUnderTexture = builder.comment("Random Skin Mob Has Under Texture")
                    .define("随机纹理生物拥有底层纹理", false);
            PurpleSandEyeProtectionMode = builder.comment("Purple Sand Eye Protection Mode")
                    .define("紫沙护眼模式", true);
            PurpleSandCustomColor = builder.comment("Purple Sand Custom Color")
                    .define("紫沙自定义颜色", true);
            PurpleSandCustomColorUse = builder.comment("Purple Sand Custom Color Use")
                    .defineInRange("紫沙自定义颜色选择", 0x703c9d, 0, Integer.MAX_VALUE);
            SomeEliteHasBossBarBaseInGameRule = builder.comment("Some Elite Has Boss Bar Base In Game Rule")
                    .define("基础游戏规则部分精英拥有血条", true);
            EliteBossBarOnlyCombat = builder.comment("Elite Boss Bar Only Combat")
                    .define("精英血条战斗开启", true);
            EliteCanHasBossBar = builder.comment("Elite Can Has Boss Bar")
                    .define("可以拥有血条的精英", Lists.newArrayList(
                            "jvpillage:big_witch", "jvpillage:fury_blamer_necromancy_warlock"));
            DefectorMustAttack = builder.comment("Defector Must Attack")
                    .define("背弃者强制迎战", false);

            SameTypeBossOnlyOne = builder.comment("Same Type Boss Only One")
                    .define("同类型Boss仅同时存在一个", true);
            BossOnlyOne = builder.comment("Boss Only One")
                    .define("Boss仅同时存在一个", false);
            BossSpawnRestrictionRange = builder.comment("Boss Spawn Restriction Range")
                    .defineInRange("Boss生成限制距离", 256.0, 0.0, Double.MAX_VALUE);
            SameTypeEliteOnlyOne = builder.comment("Same Type Elite Only One")
                    .define("同类型精英仅同时存在一个", true);
            EliteOnlyOne = builder.comment("Elite Only One")
                    .define("精英仅同时存在一个（×）", false);
            EliteSpawnRestrictionRange = builder.comment("Elite Spawn Restriction Range")
                    .defineInRange("精英生成限制距离", 128.0, 0.0, Double.MAX_VALUE);
            EliteAndBossOnlyOne = builder.comment("Elite And Boss Only One")
                    .define("精英和Boss仅同时存在一个（×）", false);
            builder.pop();

            builder.push("Raid");
            //探险者
            RaidSpawnExplorer = builder.comment("Raid Spawn Explorer")
                    .define("探险者袭击中生成", true);
            RaidSpawnExplorerCount = builder.comment("Raid Spawn Explorer Count")
                    .worldRestart()
                    .defineList("探险者袭击中生成数量",
                            Arrays.asList(0, 0, 0, 1, 1, 2, 2, 3), (i) -> i instanceof Integer);
            //行刑者
            RaidSpawnExecutioner = builder.comment("Raid Spawn Executioner")
                    .define("行刑者袭击中生成", true);
            RaidSpawnExecutionerCount = builder.comment("Raid Spawn Executioner Count")
                    .worldRestart()
                    .defineList("行刑者袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 1, 1, 1, 1), (i) -> i instanceof Integer);
            //绘图者
            RaidSpawnMapmaker = builder.comment("Raid Spawn Mapmaker")
                    .define("绘图者袭击中生成", true);
            RaidSpawnMapmakerCount = builder.comment("Raid Spawn Mapmaker Count")
                    .worldRestart()
                    .defineList("绘图者袭击中生成数量",
                            Arrays.asList(0, 0, 1, 0, 0, 0, 1, 1), (i) -> i instanceof Integer);
            //背叛者
            RaidSpawnDefector = builder.comment("Raid Spawn Defector")
                    .define("背叛者袭击中生成", true);
            RaidSpawnDefectorCount = builder.comment("Raid Spawn Defector Count")
                    .worldRestart()
                    .defineList("背叛者袭击中生成数量",
                            Arrays.asList(0, 1, 1, 2, 2, 2, 2, 3), (i) -> i instanceof Integer);
            //执旗者
            RaidSpawnBannerBearer = builder.comment("Raid Spawn Banner Bearer")
                    .define("执旗者袭击中生成", true);
            RaidSpawnBannerBearerCount = builder.comment("Raid Spawn Banner Bearer Count")
                    .worldRestart()
                    .defineList("执旗者袭击中生成数量",
                            Arrays.asList(0, 0, 0, 1, 0, 0, 1, 1), (i) -> i instanceof Integer);
            //爆破者
            RaidSpawnBlaster = builder.comment("Raid Spawn Blaster")
                    .define("爆破者袭击中生成", true);
            RaidSpawnBlasterCount = builder.comment("Raid Spawn Blaster Count")
                    .worldRestart()
                    .defineList("爆破者袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 1, 1, 1, 1), (i) -> i instanceof Integer);
            //吹号者
            RaidSpawnTrumpeter = builder.comment("Raid Spawn Trumpeter")
                    .define("吹号者袭击中生成", true);
            RaidSpawnTrumpeterCount = builder.comment("Raid Spawn Trumpeter Count")
                    .worldRestart()
                    .defineList("吹号者袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 0, 1, 1, 1), (i) -> i instanceof Integer);
            //传送者
            RaidSpawnTeleporter = builder.comment("Raid Spawn Teleporter")
                    .define("传送者袭击中生成", true);
            RaidSpawnTeleporterCount = builder.comment("Raid Spawn Teleporter Count")
                    .worldRestart()
                    .defineList("传送者袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 0, 0, 1, 1), (i) -> i instanceof Integer);
            //旋风者
            RaidSpawnCycloner = builder.comment("Raid Spawn Cycloner")
                    .define("旋风者袭击中生成", true);
            RaidSpawnCyclonerCount = builder.comment("Raid Spawn Cycloner Count")
                    .worldRestart()
                    .defineList("旋风者袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 0, 1, 1, 1), (i) -> i instanceof Integer);
            //掷枪者
            RaidSpawnJavelinThrower = builder.comment("Raid Spawn Javelin Thrower")
                    .define("掷枪者袭击中生成", true);
            RaidSpawnJavelinThrowerCount = builder.comment("Raid Spawn Javelin Thrower Count")
                    .worldRestart()
                    .defineList("掷枪者袭击中生成数量",
                            Arrays.asList(0, 0, 0, 1, 1, 1, 2, 2), (i) -> i instanceof Integer);
            //养尸人
            RaidSpawnZombieKeeper = builder.comment("Raid Spawn Zombie Keeper")
                    .define("养尸人袭击中生成", true);
            RaidSpawnZombieKeeperCount = builder.comment("Raid Spawn Zombie Keeper Count")
                    .worldRestart()
                    .defineList("养尸人袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 1, 1, 1, 1), (i) -> i instanceof Integer);
            //苦寒术士
            RaidSpawnBitterColdSorcerer = builder.comment("Raid Spawn Bitter Cold Sorcerer")
                    .define("苦寒术士袭击中生成", false);
            RaidSpawnBitterColdSorcererCount = builder.comment("Raid Spawn Bitter Cold Sorcerer Count")
                    .worldRestart()
                    .defineList("苦寒术士袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 0, 1, 1, 1), (i) -> i instanceof Integer);
            //吐火者
            RaidSpawnFireSpitter = builder.comment("Raid Spawn Fire Spitter")
                    .define("吐火者袭击中生成", false);
            RaidSpawnFireSpitterCount = builder.comment("Raid Spawn Fire Spitter Count")
                    .worldRestart()
                    .defineList("吐火者袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 0, 1, 1, 1), (i) -> i instanceof Integer);
            //野探客
            RaidSpawnWildFinder = builder.comment("Raid Spawn Wild Finder")
                    .define("野探客袭击中生成", false);
            RaidSpawnWildFinderCount = builder.comment("Raid Spawn Wild Finder Count")
                    .worldRestart()
                    .defineList("野探客袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 0, 1, 1, 1), (i) -> i instanceof Integer);
            //潜海者
            RaidSpawnSubmariner = builder.comment("Raid Spawn Submariner")
                    .define("潜海者袭击中生成", false);
            RaidSpawnSubmarinerCount = builder.comment("Raid Spawn Submariner Count")
                    .worldRestart()
                    .defineList("潜海者袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 1, 1, 1, 1), (i) -> i instanceof Integer);
            //灯术师
            RaidSpawnLampWizard = builder.comment("Raid Spawn Lamp Wizard")
                    .define("灯术师袭击中生成", false);
            RaidSpawnLampWizardCount = builder.comment("Raid Spawn Lamp Wizard Count")
                    .worldRestart()
                    .defineList("灯术师袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 0, 1, 1, 1), (i) -> i instanceof Integer);
            //奴制监督者
            RaidSpawnSlaverySupervisor = builder.comment("Raid Spawn Slavery Supervisor")
                    .define("奴制监督者袭击中生成", false);
            RaidSpawnSlaverySupervisorCount = builder.comment("Raid Spawn Slavery Supervisor Count")
                    .worldRestart()
                    .defineList("奴制监督者袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1), (i) -> i instanceof Integer);
            //火力倾泻者
            RaidSpawnFirepowerPourer = builder.comment("Raid Spawn Firepower Pourer")
                    .define("火力倾泻者袭击中生成", false);
            RaidSpawnFirepowerPourerCount = builder.comment("Raid Spawn Firepower Pourer Count")
                    .worldRestart()
                    .defineList("火力倾泻者袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1), (i) -> i instanceof Integer);
            //巫神汉
            RaidSpawnNecromancyWarlock = builder.comment("Raid Spawn Necromancy Warlock")
                    .define("巫神汉袭击中生成", false);
            RaidSpawnNecromancyWarlockCount = builder.comment("Raid Spawn Necromancy Warlock Count")
                    .worldRestart()
                    .defineList("巫神汉袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1), (i) -> i instanceof Integer);
            //引力师
            RaidSpawnGaviler = builder.comment("Raid Spawn Gaviler")
                    .define("引力师袭击中生成", false);
            RaidSpawnGavilerCount = builder.comment("Raid Spawn Gaviler Count")
                    .worldRestart()
                    .defineList("引力师袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1), (i) -> i instanceof Integer);
            //斧头杀人狂
            RaidSpawnAxCrazy = builder.comment("Raid Spawn Ax-Crazy")
                    .define("斧头杀人狂袭击中生成", false);
            RaidSpawnAxCrazyCount = builder.comment("Raid Spawn Ax-Crazy Count")
                    .worldRestart()
                    .defineList("斧头杀人狂袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1), (i) -> i instanceof Integer);
            //鬼婆
            RaidSpawnHag = builder.comment("Raid Spawn Hag")
                    .define("鬼婆袭击中生成", true);
            RaidSpawnHagCount = builder.comment("Raid Spawn Hag Count")
                    .worldRestart()
                    .defineList("鬼婆袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 0, 0, 1, 1), (i) -> i instanceof Integer);
            //女巫学者
            RaidSpawnWitchScholar = builder.comment("Raid Spawn Witch Scholar")
                    .define("女巫学者袭击中生成", true);
            RaidSpawnWitchScholarCount = builder.comment("Raid Spawn Witch Scholar Count")
                    .worldRestart()
                    .defineList("女巫学者袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 1, 1, 1, 1), (i) -> i instanceof Integer);
            //紫沙女巫
            RaidSpawnPurpleSandWitch = builder.comment("Raid Spawn Purple Sand Witch")
                    .define("紫沙女巫袭击中生成", false);
            RaidSpawnPurpleSandWitchCount = builder.comment("Raid Spawn Purple Sand Witch Count")
                    .worldRestart()
                    .defineList("紫沙女巫袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 0, 1, 1, 1), (i) -> i instanceof Integer);
            //灵奴
            RaidSpawnSpirve = builder.comment("Raid Spawn Spirve")
                    .define("灵奴袭击中生成", true);
            RaidSpawnSpirveCount = builder.comment("Raid Spawn Spirve Count")
                    .worldRestart()
                    .defineList("灵奴袭击中生成数量",
                            Arrays.asList(0, 1, 1, 2, 2, 2, 2, 3), (i) -> i instanceof Integer);
            //怒化恶怨巫神汉
            RaidSpawnFuryBlamerNecromancyWarlock = builder.comment("Raid Spawn Fury Blamer Necromancy Warlock")
                    .define("怒化恶怨巫神汉袭击中生成", false);
            RaidSpawnFuryBlamerNecromancyWarlockCount = builder.comment("Raid Spawn Fury Blamer Necromancy Warlock Count")
                    .worldRestart()
                    .defineList("怒化恶怨巫神汉袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1), (i) -> i instanceof Integer);
            //大巫婆
            RaidSpawnBigWitch = builder.comment("Raid Spawn Big Witch")
                    .define("大巫婆袭击中生成", false);
            RaidSpawnBigWitchCount = builder.comment("Raid Spawn Big Witch Count")
                    .worldRestart()
                    .defineList("大巫婆袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1), (i) -> i instanceof Integer);
            //黑集会鬼婆
            RaidSpawnCovenHagOne = builder.comment("Raid Spawn Coven Hag One")
                    .define("黑集会鬼婆袭击中生成", true);
            RaidSpawnCovenHagOneCount = builder.comment("Raid Spawn Coven Hag One Count")
                    .worldRestart()
                    .defineList("黑集会鬼婆袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1), (i) -> i instanceof Integer);
            //白集会鬼婆
            RaidSpawnCovenHagTwo = builder.comment("Raid Spawn Coven Hag Two")
                    .define("白集会鬼婆袭击中生成", true);
            RaidSpawnCovenHagTwoCount = builder.comment("Raid Spawn Big Witch Count")
                    .worldRestart()
                    .defineList("白集会鬼婆袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1), (i) -> i instanceof Integer);
            //灾厄旗帜投影
            RaidSpawnOminousBannerProjection = builder.comment("Raid Spawn Ominous Banner Projection")
                    .define("灾厄旗帜投影袭击中生成", false);
            RaidSpawnOminousBannerProjectionCount = builder.comment("Raid Spawn Ominous Banner Projection Count")
                    .worldRestart()
                    .defineList("灾厄旗帜投影袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1), (i) -> i instanceof Integer);
            //紫沙鬼婆
            RaidSpawnPurpleSandHag = builder.comment("Raid Spawn Purple Sand Hag")
                    .define("紫沙鬼婆袭击中生成", false);
            RaidSpawnPurpleSandHagCount = builder.comment("Raid Spawn Purple Sand Hag Count")
                    .worldRestart()
                    .defineList("紫沙鬼婆袭击中生成数量",
                            Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1), (i) -> i instanceof Integer);
            builder.pop();

            builder.push("Attributes");
            builder.push("Boss");

            BossBaseAttributeCanUseConfig = builder.comment("Boss Base Attribute Can Use Config")
                    .define("Boss基础属性可以被配置影响", true);
            RaidBossCanIncreaseSummonCountBasedOnPlayerCount = builder.comment("Raid Boss Can Increase Summon Count Based On Player Count")
                    .define("袭击类boss可以依靠玩家数量提升生成数量", false);
            RaidBossCanIncreaseSummonCountBasedOnPlayerCountFindReach = builder.comment("Raid Boss Can Increase Summon Count Based On Player Count Find Reach")
                    .defineInRange("袭击类boss可以依靠玩家数量提升生成数量依照范围", 128.0, 0.0, Double.MAX_VALUE);
            RaidBossCanIncreaseSummonCountBasedOnPlayerCountMaxCount = builder.comment("Raid Boss Can Increase Summon Count Based On Player Count Max Count")
                    .defineInRange("袭击类boss可以依靠玩家数量提升生成数量最大数量", 6, 0, Integer.MAX_VALUE);
            RaidBossCanIncreaseSummonCountBasedOnPlayerCountContainAllBoss = builder.comment("Raid Boss Can Increase Summon Count Based On Player Count Contain All Boss")
                    .define("袭击类boss可以依靠玩家数量提升生成数量包含所有boss", true);
            RaidBossCanIncreaseSummonCountBasedOnPlayerCountContainBoss = builder.comment("Raid Boss Can Increase Summon Count Based On Player Count Contain Boss")
                    .define("袭击类boss可以依靠玩家数量提升生成数量包含boss", Lists.newArrayList("jvpillage:ominous_banner_projection"));
            BossHasPercentageDamage = builder.comment("Boss Has Percentage Damage")
                    .define("Boss拥有百分比伤害", Lists.newArrayList( ));
            BossHasDamageCap = builder.comment("Boss Has Damage Cap")
                    .define("Boss拥有限伤", Lists.newArrayList( ));
            BossHasDamageCooldownTick = builder.comment("Boss Has Damage Cooldown Tick")
                    .define("Boss拥有无敌帧", Lists.newArrayList( ));
            //灾厄旗帜投影
            builder.push("Ominous Banner Projection");
            OminousBannerProjectionBossBarColor = builder.comment("Ominous Banner Projection Boss Bar Color")
                    .defineInRange("灾厄旗帜投影Boss血条颜色", 2, 0, 6);
            OminousBannerProjectionBossBarNameColor = builder.comment("Ominous Banner Projection Boss Bar Name Color")
                    .defineInRange("灾厄旗帜投影Boss血条名字颜色", 0x262626, 0, Integer.MAX_VALUE);
            OminousBannerProjectionMaxHealth = builder.comment("[Boss] Max Health : 200.0")
                    .defineInRange("Ominous Banner Projection Max Health", 200, 0.0, Double.MAX_VALUE);
            OminousBannerProjectionMeleeDamage = builder.comment("[Boss] Melee Damage : 2.0")
                    .defineInRange("Ominous Banner Projection Melee Damage", 2.0, 0.0, Double.MAX_VALUE);
            OminousBannerProjectionArmor = builder.comment("[Boss] Armor : 0.0")
                    .defineInRange("Ominous Banner Projection Armor", 0.0, 0.0, Double.MAX_VALUE);
            OminousBannerProjectionMovementSpeed = builder.comment("[Boss] Movement Speed : 0.0")
                    .defineInRange("Ominous Banner Projection Movement Speed", 0.0, 0.0, Double.MAX_VALUE);
            OminousBannerProjectionAttackKnockback = builder.comment("[Boss] Attack Knockback : 0.0")
                    .defineInRange("Ominous Banner Projection Attack Knockback", 0.0, 0.0, Double.MAX_VALUE);
            OminousBannerProjectionKnockbackResistance = builder.comment("[Boss] Knockback Resistance : 1.0")
                    .defineInRange("Ominous Banner Projection Knockback Resistance", 1.0, 0.0, Double.MAX_VALUE);
            OminousBannerProjectionRoundTimeMin = builder.comment("[Boss] Round Time Min : 60.0")
                    .defineInRange("Ominous Banner Projection Round Time Min", 60.0, 0.0, Double.MAX_VALUE);
            OminousBannerProjectionRoundTimeMax = builder.comment("[Boss] Round Time Max : 270.0")
                    .defineInRange("Ominous Banner Projection Round Time Max", 270.0, 0.0, Double.MAX_VALUE);
            OminousBannerProjectionMaxRound = builder.comment("[Boss] Max Round : 7")
                    .defineInRange("Ominous Banner Projection Max Round", 7, 0, Integer.MAX_VALUE);
            OminousBannerProjectionPointsBase = builder.comment("[Boss] Points Base : 20.0")
                    .defineInRange("Ominous Banner Projection Points Base", 20.0, 0.0, Double.MAX_VALUE);
            OminousBannerProjectionPointsRoundGrowthMultiple = builder.comment("[Boss] Points Round Growth Multiple : 1.5")
                    .defineInRange("Ominous Banner Projection Points Round Growth Multiple", 1.5, 0.0, Double.MAX_VALUE);
            OminousBannerProjectionAXCrazyCanAppear = builder.comment("[Boss] AX-Crazy Can Appear : false")
                    .define("Ominous Banner Projection AX-Crazy Can Appear", false);
            OminousBannerProjectionBiomeIllagerCanAppearInOtherBiome = builder.comment("[Boss] Biome Illager Can Appear In Other Biome : false")
                    .define("Ominous Banner Projection Biome Illager Can Appear In Other Biome", false);
            OminousBannerProjectionEliteCount = builder.comment("[Boss] Elite Count : 2")
                    .defineInRange("Ominous Banner Projection Elite Count", 2, 0, Integer.MAX_VALUE);
            OminousBannerProjectionAttackPercentage = builder.comment("[Boss] Attack Percentage : 5.0")
                    .defineInRange("Ominous Banner Projection Attack Percentage", 5.0, 0.0, Double.MAX_VALUE);
            OminousBannerProjectionMagicAttackPercentage = builder.comment("[Boss] Magic Attack Percentage : 5.0")
                    .defineInRange("Ominous Banner Projection Magic Attack Percentage", 5.0, 0.0, Double.MAX_VALUE);
            OminousBannerProjectionDamageCap = builder.comment("[Boss] Damage Cap : 20")
                    .defineInRange("Ominous Banner Projection Damage Cap", 20, 0.0, Double.MAX_VALUE);
            OminousBannerProjectionDamageCooldownTick = builder.comment("[Boss] Damage Cooldown Tick : 20")
                    .defineInRange("Ominous Banner Projection Damage Cooldown Tick", 20, 0.0, Double.MAX_VALUE);
            builder.pop();
            //紫沙鬼婆
            builder.push("Purple Sand Hag");
            PurpleSandHagBossBarColor = builder.comment("Purple Sand Hag Boss Bar Color")
                    .defineInRange("紫沙鬼婆Boss血条颜色", 5, 0, 6);
            PurpleSandHagBossBarNameColor = builder.comment("Purple Sand Hag Boss Bar Name Color")
                    .defineInRange("紫沙鬼婆Boss血条名字颜色", 0x1b003a, 0, Integer.MAX_VALUE);
            PurpleSandHagMaxHealth = builder.comment("[Boss] Max Health : 165.0")
                    .defineInRange("Purple Sand Hag Max Health", 165.0, 0.0, Double.MAX_VALUE);
            PurpleSandHagMeleeDamage = builder.comment("[Boss] Melee Damage : 13.0")
                    .defineInRange("Purple Sand Hag Melee Damage", 13.0, 0.0, Double.MAX_VALUE);
            PurpleSandHagArmor = builder.comment("[Boss] Armor : 15.0")
                    .defineInRange("Purple Sand Hag Armor", 15.0, 0.0, Double.MAX_VALUE);
            PurpleSandHagMovementSpeed = builder.comment("[Boss] Movement Speed : 0.4")
                    .defineInRange("Purple Sand Hag Movement Speed", 0.4, 0.0, Double.MAX_VALUE);
            PurpleSandHagAttackKnockback = builder.comment("[Boss] Attack Knockback : 0.0")
                    .defineInRange("Purple Sand Hag Attack Knockback", 0.0, 0.0, Double.MAX_VALUE);
            PurpleSandHagKnockbackResistance = builder.comment("[Boss] Knockback Resistance : 0.0")
                    .defineInRange("Purple Sand Hag Knockback Resistance", 0.0, 0.0, Double.MAX_VALUE);
            PurpleSandHagMainSpellCooldown = builder.comment("[Boss] Main Spell Cooldown : 6.0")
                    .defineInRange("Purple Sand Hag Main Spell Cooldown", 6.0, 0.0, Double.MAX_VALUE);
            PurpleSandHagOtherSpellCooldown = builder.comment("[Boss] Other Spell Cooldown : 6.0")
                    .defineInRange("Purple Sand Hag Other Spell Cooldown", 6.0, 0.0, Double.MAX_VALUE);
            PurpleSandHagSpellNormalLevel = builder.comment("[Boss] Spell Normal Level : 4")
                    .defineInRange("Purple Sand Hag Spell Normal Level", 4, 0, Integer.MAX_VALUE);
            PurpleSandHagAttackPercentage = builder.comment("[Boss] Attack Percentage : 5.0")
                    .defineInRange("Purple Sand Hag Attack Percentage", 5.0, 0.0, Double.MAX_VALUE);
            PurpleSandHagMagicAttackPercentage = builder.comment("[Boss] Magic Attack Percentage : 10.0")
                    .defineInRange("Purple Sand Hag Magic Attack Percentage", 10.0, 0.0, Double.MAX_VALUE);
            PurpleSandHagDamageCap = builder.comment("[Boss] Damage Cap : 18")
                    .defineInRange("Purple Sand Hag Damage Cap", 18, 0.0, Double.MAX_VALUE);
            PurpleSandHagDamageCooldownTick = builder.comment("[Boss] Damage Cooldown Tick : 20")
                    .defineInRange("Purple Sand Hag Damage Cooldown Tick", 20, 0.0, Double.MAX_VALUE);
            builder.pop();
            //泽林变体
            builder.push("Variant Zsiein");
            builder.pop();
            builder.pop();
            builder.pop();
        }
    }

    public static class ClientConfig {
        public ClientConfig(ForgeConfigSpec.Builder builder) {
        }
    }
}