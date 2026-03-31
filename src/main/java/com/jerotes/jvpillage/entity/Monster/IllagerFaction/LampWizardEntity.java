package com.jerotes.jvpillage.entity.Monster.IllagerFaction;

import com.jerotes.jerotes.entity.Mob.HumanEntity;
import com.jerotes.jerotes.entity.Interface.SpellUseEntity;
import com.jerotes.jerotes.util.EntityAndItemFind;
import com.jerotes.jvpillage.entity.Interface.BannerChampionEntity;
import com.jerotes.jvpillage.goal.BigWitchAttackGoal;
import com.jerotes.jvpillage.init.JVPillageBlocks;
import com.jerotes.jvpillage.init.JVPillageSoundEvents;
import com.jerotes.jvpillage.spell.OtherSpellList;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LampWizardEntity extends SpellIllagerEntity implements RangedAttackMob, SpellUseEntity, BannerChampionEntity {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState shoot1AnimationState = new AnimationState();
    public AnimationState shoot2AnimationState = new AnimationState();
    public AnimationState shoot3AnimationState = new AnimationState();
    private static final EntityDataAccessor<Boolean> CHAMPION = SynchedEntityData.defineId(LampWizardEntity.class, EntityDataSerializers.BOOLEAN);

    public LampWizardEntity(EntityType<? extends LampWizardEntity> entityType, Level level) {
        super(entityType, level);
        this.xpReward = 25;
        this.setCanPickUpLoot(false);
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Monster.createMonsterAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.35);
        builder = builder.add(Attributes.MAX_HEALTH, 32);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 2);
        builder = builder.add(Attributes.FOLLOW_RANGE, 32);
        return builder;
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource randomSource, DifficultyInstance difficultyInstance) {
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BigWitchAttackGoal(this, 0.4, 80, 12.0F));
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.6));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 3.0f, 1.0f));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, HumanEntity.class, 3.0f, 1.0f));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Mob.class, 8.0f));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, Raider.class).setAlertOthers(new Class[0]));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<Player>(this, Player.class, false){
            @Override
            public boolean canUse() {
                if (LampWizardEntity.this.level().getDifficulty() == Difficulty.PEACEFUL) {
                    return false;
                }
                return super.canUse();
            }
        });
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<AbstractVillager>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<HumanEntity>(this, HumanEntity.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<IronGolem>(this, IronGolem.class, false));
    }

    @Override
    public void performRangedAttack(LivingEntity livingEntity, float f) {
        int spellLevel = this.getSpellLevel();
        if (this.random.nextFloat() > 0.65f || this.distanceTo(livingEntity) > 24) {
            //技能-奥术光点
            if (!this.level().isClientSide()) {
                this.setSpellTick(20);
                this.setAnimTick(15);
                this.setAnimationState("shoot1");
            }
            //法术列表-奥术光点
            OtherSpellList.ArcaneLightSpot(this.getSpellLevel(), this, livingEntity).spellUse();
        }
       else if (this.random.nextFloat() > 0.75f) {
            //技能-弹力光球
            if (!this.level().isClientSide()) {
                this.setSpellTick(20);
                this.setAnimTick(15);
                this.setAnimationState("shoot2");
            }
            //法术列表-弹力光球
            OtherSpellList.ElasticLightBall(this.getSpellLevel(), this, livingEntity).spellUse();
        }
        else {
            //技能-光芒爆弹
            if (!this.level().isClientSide()) {
                this.setSpellTick(20);
                this.setAnimTick(16);
                this.setAnimationState("shoot3");
            }
            //法术列表-光芒爆弹
            OtherSpellList.RadiantBomb(this.getSpellLevel(), this, livingEntity).spellUse();
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return JVPillageSoundEvents.LAMP_WIZARD_AMBIENT;
    }
    @Override
    protected SoundEvent getDeathSound() {
        return JVPillageSoundEvents.LAMP_WIZARD_DEATH;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return JVPillageSoundEvents.LAMP_WIZARD_HURT;
    }
    @Override
    public SoundEvent getCelebrateSound() {
        return JVPillageSoundEvents.LAMP_WIZARD_CHEER;
    }
    @Override
    protected SoundEvent getCastingSoundEvent() {
        return JVPillageSoundEvents.LAMP_WIZARD_SHOOT_1;
    }
    @Override
    public IllagerSpell customSpell() {
        return IllagerSpell.SUMMON_VEX;
    }
    @Override
    public boolean isOnFire() {
        String string = ChatFormatting.stripFormatting(this.getName().getString());
        if (this.isChampion()) {
            return false;
        }
        return super.isOnFire();
    }

    public int spellLevel = 2;
    @Override
    public int getSpellLevel() {
        return this.spellLevel;
    }
    //动画
    public int getAnimationState(String animation) {
        if (Objects.equals(animation, "shoot1")){
            return 1;
        }
        else if (Objects.equals(animation, "shoot2")){
            return 2;
        }
        else if (Objects.equals(animation, "shoot3")){
            return 3;
        }
        else {
            return 0;
        }
    }
    public List<AnimationState> getAllAnimations(){
        List<AnimationState> list = new ArrayList<>();
        list.add(this.shoot1AnimationState);
        list.add(this.shoot2AnimationState);
        list.add(this.shoot3AnimationState);
        return list;
    }
    //

    //冠军重命名与标签
    @Override
    public boolean isChampion() {
        return this.getEntityData().get(CHAMPION);
    }
    @Override
    public void setChampion(boolean bl) {
        this.getEntityData().set(CHAMPION, bl);
    }

    public void setCustomNameUseNameTag(@Nullable Component component, Entity self, Entity source, InteractionHand interactionHand) {
        String string;
        if (component != null) {
            string = ChatFormatting.stripFormatting(component.getString());
            if ((("Soul Lampologer".equals(string) || "Soullampologer".equals(string) || "Lampologer".equals(string)) && self instanceof LampWizardEntity lampWizardEntity)) {
                lampWizardEntity.setChampion(true);
            }
        }
    }

    @Override
    protected Component getTypeName() {
        if (this.isChampion())
            return Component.translatable("entity.jvpillage.lamp_wizard.champion");
        return Component.translatable(this.getType().getDescriptionId());
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean("IsChampion", this.isChampion());
    }
    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.setChampion(compoundTag.getBoolean("IsChampion"));
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(CHAMPION,false);
    }
    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> entityDataAccessor) {
        if (ANIM_STATE.equals(entityDataAccessor)) {
            if (this.level().isClientSide()) {
                switch (this.entityData.get(ANIM_STATE)){
                    case 0:
                        this.stopAllAnimation();
                        break;
                    case 1:
                        this.shoot1AnimationState.startIfStopped(this.tickCount);
                        this.stopMostAnimation(this.shoot1AnimationState);
                        break;
                    case 2:
                        this.shoot2AnimationState.startIfStopped(this.tickCount);
                        this.stopMostAnimation(this.shoot2AnimationState);
                        break;
                    case 3:
                        this.shoot3AnimationState.startIfStopped(this.tickCount);
                        this.stopMostAnimation(this.shoot3AnimationState);
                        break;
                }
            }
        }
        super.onSyncedDataUpdated(entityDataAccessor);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        String string = ChatFormatting.stripFormatting(this.getName().getString());
        if (this.isChampion()) {
            this.clearFire();
            if (this.level().isClientSide()) {
                this.level().addParticle(ParticleTypes.SOUL_FIRE_FLAME, this.getRandomX(0.5), this.getRandomY(), this.getRandomZ(0.5), 0.0, 0.0, 0.0);
            }
        }
        //闪耀光点
        if (this.tickCount % 20 == 0 && this.deathTime == 0) {
            if (!this.level().isClientSide) {
                if (this.level().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
                    BlockState blockState = JVPillageBlocks.GLOW_SHINE.get().defaultBlockState();
                    BlockPos blockPos = this.getOnPos().above().above();
                    if ((this.level().getBlockState(blockPos).isAir() || this.level().getBlockState(blockPos).getBlock() == JVPillageBlocks.GLOW_SHINE.get()) && blockState.canSurvive(this.level(), blockPos)) {
                        this.level().setBlockAndUpdate(blockPos, blockState);
                        this.level().gameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Context.of(this, blockState));
                    }
                }
            }
        }
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        String string = ChatFormatting.stripFormatting(this.getName().getString());
        if (this.isChampion()) {
            if (damageSource.is(DamageTypes.WITHER)
                    || damageSource.is(DamageTypes.WITHER_SKULL)
                    || damageSource.is(DamageTypeTags.IS_FIRE))
                return true;
        }
        return super.isInvulnerableTo(damageSource);
    }
    @Override
    public boolean hurt(DamageSource damageSource, float amount) {
        if (isInvulnerableTo(damageSource)) {
            return super.hurt(damageSource, amount);
        }
        if (EntityAndItemFind.MagicResistance(damageSource))
            return super.hurt(damageSource, amount / 5);
        return super.hurt(damageSource, amount);
    }

    @Override
    public boolean killedEntity(ServerLevel serverLevel, LivingEntity livingEntity) {
        boolean bl = super.killedEntity(serverLevel, livingEntity);
        if (livingEntity instanceof Villager villager) {
            villager.getInventory().removeAllItems().forEach(this::spawnAtLocation);
            ZombieVillager zombieVillager = villager.convertTo(EntityType.ZOMBIE_VILLAGER, false);
            if (zombieVillager != null) {
                zombieVillager.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(zombieVillager.blockPosition()), MobSpawnType.CONVERSION, new Zombie.ZombieGroupData(false, true), null);
                zombieVillager.setVillagerData(villager.getVillagerData());
                zombieVillager.setGossips(villager.getGossips().store(NbtOps.INSTANCE));
                zombieVillager.setTradeOffers(villager.getOffers().createTag());
                zombieVillager.setVillagerXp(villager.getVillagerXp());
                if (!this.isSilent()) {
                    serverLevel.levelEvent(null, 1026, this.blockPosition(), 0);
                }
                bl = false;
            }
        }
        return bl;
    }
}

