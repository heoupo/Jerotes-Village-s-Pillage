package com.jerotes.jvpillage.entity.MagicSummoned.IllagerLike;

import com.jerotes.jerotes.entity.Interface.EliteEntity;
import com.jerotes.jerotes.entity.Mob.HumanEntity;
import com.jerotes.jerotes.event.JerotesBossEvent;
import com.jerotes.jerotes.init.JerotesDamageTypes;
import com.jerotes.jerotes.init.JerotesMobEffects;
import com.jerotes.jerotes.util.AttackFind;
import com.jerotes.jerotes.util.EntityAndItemFind;
import com.jerotes.jerotes.util.Main;
import com.jerotes.jvpillage.config.OtherMainConfig;
import com.jerotes.jvpillage.entity.MagicSummoned.IllagerLikeEntity;
import com.jerotes.jvpillage.goal.AxCrazyMeleeAttackGoal;
import com.jerotes.jvpillage.init.*;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SliderAxCrazyEntity extends IllagerLikeEntity implements  EliteEntity {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState attackAnimationState = new AnimationState();
    public AnimationState itemAttack1AnimationState = new AnimationState();
    public AnimationState itemAttack2AnimationState = new AnimationState();
    public AnimationState itemAttack3AnimationState = new AnimationState();
    public AnimationState angryAnimationState = new AnimationState();
    public AnimationState deadAnimationState = new AnimationState();
    private final JerotesBossEvent bossEvent = new JerotesBossEvent(this, this.getUUID(), BossEvent.BossBarColor.GREEN, BossEvent.BossBarOverlay.NOTCHED_6, false);
    private static final EntityDataAccessor<Float> ANGRY_TICK = SynchedEntityData.defineId(SliderAxCrazyEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> STOP_TICK = SynchedEntityData.defineId(SliderAxCrazyEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> NEED_STOP_TICK = SynchedEntityData.defineId(SliderAxCrazyEntity.class, EntityDataSerializers.INT);

    public SliderAxCrazyEntity(EntityType<? extends SliderAxCrazyEntity> entityType, Level level) {
        super(entityType, level);
        setMaxUpStep(1.6f);
        this.handDropChances[EquipmentSlot.MAINHAND.getIndex()] = 1.0F;
        this.xpReward = 80;
        this.setCanPickUpLoot(false);
        this.setPathfindingMalus(BlockPathTypes.LEAVES, 4.0f);
        this.setPathfindingMalus(BlockPathTypes.DOOR_IRON_CLOSED, 4.0f);
        this.setPathfindingMalus(BlockPathTypes.FENCE, 4.0f);
        this.setPathfindingMalus(BlockPathTypes.BLOCKED, 4.0f);
    }

    @Override
    public void startSeenByPlayer(ServerPlayer serverPlayer) {
        super.startSeenByPlayer(serverPlayer);
        if (JVPillageGameRules.JVPILLAGE_SOME_ELITE_HAS_BOSS_BAR != null && this.level().getLevelData().getGameRules().getBoolean(JVPillageGameRules.JVPILLAGE_SOME_ELITE_HAS_BOSS_BAR) && OtherMainConfig.EliteCanHasBossBar.contains(this.getEncodeId()))
            this.bossEvent.addPlayer(serverPlayer);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer serverPlayer) {
        super.stopSeenByPlayer(serverPlayer);
        if (JVPillageGameRules.JVPILLAGE_SOME_ELITE_HAS_BOSS_BAR != null && this.level().getLevelData().getGameRules().getBoolean(JVPillageGameRules.JVPILLAGE_SOME_ELITE_HAS_BOSS_BAR) && OtherMainConfig.EliteCanHasBossBar.contains(this.getEncodeId()))
            this.bossEvent.removePlayer(serverPlayer);
    }

    @Override
    public void customServerAiStep() {
        super.customServerAiStep();
        if (JVPillageGameRules.JVPILLAGE_SOME_ELITE_HAS_BOSS_BAR != null && this.level().getLevelData().getGameRules().getBoolean(JVPillageGameRules.JVPILLAGE_SOME_ELITE_HAS_BOSS_BAR) && OtherMainConfig.EliteCanHasBossBar.contains(this.getEncodeId()))
            this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }


    @Override
    protected void populateDefaultEquipmentSlots(RandomSource randomSource, DifficultyInstance difficultyInstance) {
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Monster.createMonsterAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.30);
        builder = builder.add(Attributes.MAX_HEALTH, 138);
        builder = builder.add(Attributes.ARMOR, 14);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 15);
        builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.95);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 1.0);
        builder = builder.add(Attributes.FOLLOW_RANGE, 64);
        return builder;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new AxCrazyMeleeAttackGoal(SliderAxCrazyEntity.this, 1.35, true));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.9));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 3.0f, 1.0f));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, HumanEntity.class, 3.0f, 1.0f));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Mob.class, 8.0f));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, Raider.class).setAlertOthers(new Class[0]));
        this.targetSelector.addGoal(4, new SliderAxCrazyEntity.AngryAttackGoal(this));
    }
    @Override
    public IllagerArmPose getArmPose() {
        if (this.isAggressive()) {
            return IllagerArmPose.ATTACKING;
        }
        return IllagerArmPose.CROSSED;
    }

    static class AngryAttackGoal extends NearestAttackableTargetGoal<LivingEntity> {
        public AngryAttackGoal(SliderAxCrazyEntity axCrazy) {
            super(axCrazy, LivingEntity.class, 0, true, true, LivingEntity::attackable);
        }

        @Override
        public boolean canUse() {
            return ((SliderAxCrazyEntity)this.mob).getAngryTick() > 160 && super.canUse();
        }

        @Override
        public void start() {
            super.start();
            this.mob.setNoActionTime(0);
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        String string = ChatFormatting.stripFormatting(this.getName().getString());
        return JVPillageSoundEvents.AX_CRAZY_AMBIENT;
    }
    @Override
    public int getAmbientSoundInterval() {
        return 20;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        if (this.isDamageSourceBlocked(damageSource)) {
            return SoundEvents.SHIELD_BLOCK;
        }
        if (damageSource.is(DamageTypeTags.BYPASSES_SHIELD) && this.isBlocking()) {
            return SoundEvents.SHIELD_BLOCK;
        }
        String string = ChatFormatting.stripFormatting(this.getName().getString());
        return JVPillageSoundEvents.AX_CRAZY_HURT;
    }
    @Override
    protected SoundEvent getDeathSound() {
        String string = ChatFormatting.stripFormatting(this.getName().getString());
        return JVPillageSoundEvents.AX_CRAZY_DEATH;
    }
    @Override
    protected void playStepSound(BlockPos blockPos, BlockState blockState) {
        this.playSound(JVPillageSoundEvents.AX_CRAZY_WALK, 0.35f, 1.0f);
    }
    public AABB getAttackBoundingBox() {
        Entity entity = this.getVehicle();
        AABB aabb;
        if (entity != null) {
            AABB aabb1 = entity.getBoundingBox();
            AABB aabb2 = this.getBoundingBox();
            aabb = new AABB(Math.min(aabb2.minX, aabb1.minX), aabb2.minY, Math.min(aabb2.minZ, aabb1.minZ), Math.max(aabb2.maxX, aabb1.maxX), aabb2.maxY, Math.max(aabb2.maxZ, aabb1.maxZ));
        } else {
            aabb = this.getBoundingBox();
        }
        AABB aabb1 = aabb.inflate(Math.sqrt((double)2.04F) - (double)0.6F, 0.0D, Math.sqrt((double)2.04F) - (double)0.6F);
        if (!this.getMainHandItem().isEmpty())
            return aabb1.inflate(0.75d, 0.75d, 0.75d);
        return aabb1.inflate(0.5d, 0.5d, 0.5d);
    }
    @Override
    public boolean isWithinMeleeAttackRange(LivingEntity livingEntity) {
        return this.getAttackBoundingBox().intersects(livingEntity.getBoundingBox());
    }
    @Override
    public void travel(Vec3 vec3) {
        super.travel(vec3);
        if (this.getStopTick() > 0) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(0.05d, 1d, 0.05d));
            this.getNavigation().stop();
        }
    }
    @Override
    protected void doPush(Entity entity) {
        if (!this.isAggressive() && this.getAngryTick() <= 160 || !AttackFind.FindCanNotAttack(this, entity)) {
            super.doPush(entity);
            return;
        }
        float angryAbout = 1;
        String string = ChatFormatting.stripFormatting(this.getName().getString());
        if (this.getStopTick() <= 0 && this.getAttackTick() <= this.getMinAttack()) {
            //群攻
            List<LivingEntity> list = this.level().getEntitiesOfClass(LivingEntity.class, this.getAttackBoundingBox().inflate(1.5, 1.0, 1.5));
            if (!this.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()) {
                for (LivingEntity hurt : list) {
                    if (hurt == null) continue;
                    if (AttackFind.FindCanNotAttack(this, hurt)) continue;
                    if (!this.hasLineOfSight(hurt)) continue;
                    double healthOld = hurt.getHealth();
                    AttackFind.attackBegin(this, hurt);
                    boolean bl4 = AttackFind.attackAfter(this, hurt, 1.0f, 0.25f, false, 0f);
                    if (bl4) {
                        if (!this.level().isClientSide()) {
                            this.setAngryTick(Math.min(240, this.getAngryTick() + angryAbout * 2));
                        }
                        double healthNew = hurt.getHealth();
                        if ((float) (healthOld - healthNew)/3 > 0) {
                            this.heal((float) (healthOld - healthNew) / 3);
                        }
                        if (this.level() instanceof ServerLevel serverLevel) {
                            for (int i = 0; i < (healthOld - healthNew)/6; ++i) {
                                serverLevel.sendParticles(ParticleTypes.HEART, this.getRandomX(1f), this.getRandomY(), this.getRandomZ(1f), 0, 0, 0.0, 0, 0.0);
                                serverLevel.sendParticles(ParticleTypes.ANGRY_VILLAGER, this.getRandomX(1f), this.getRandomY(), this.getRandomZ(1f), 0, 0, 0.0, 0, 0.0);
                            }
                        }
                    }
                }
                //横扫效果
                Main.sweepAttack(this);
            }
        }
        super.doPush(entity);
    }

    public int getMinAttack(){
        return (int) -((int) (240 - this.getAngryTick()) / 8f);
    }
    private double blockDestroyTick;
    public void setAngryTick(float f){
        this.getEntityData().set(ANGRY_TICK, f);
    }
    public float getAngryTick(){
        return this.getEntityData().get(ANGRY_TICK);
    }
    public void setStopTick(int n){
        this.getEntityData().set(STOP_TICK, n);
    }
    public int getStopTick(){
        return this.getEntityData().get(STOP_TICK);
    }
    public void setNeedStopTick(int n){
        this.getEntityData().set(NEED_STOP_TICK, n);
    }
    public int getNeedStopTick(){
        return this.getEntityData().get(NEED_STOP_TICK);
    }

    //动画
    public int getAnimationState(String animation) {
        if (Objects.equals(animation, "angry")){
            return 1;
        }
        else if (Objects.equals(animation, "dead")){
            return 2;
        }
        else {
            return 0;
        }
    }
    public List<AnimationState> getAllAnimations(){
        List<AnimationState> list = new ArrayList<>();
        list.add(this.angryAnimationState);
        list.add(this.deadAnimationState);
        return list;
    }
    //
    @Override
    public void setCustomName(@Nullable Component component) {
        super.setCustomName(component);
        this.bossEvent.setName(this.getDisplayName());
    }


    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putFloat("AngryTick", this.getAngryTick());
        compoundTag.putInt("NeedStopTick", this.getNeedStopTick());
        compoundTag.putInt("StopTick", this.getStopTick());
        compoundTag.putDouble("BlockDestroyTick", this.blockDestroyTick);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (this.hasCustomName()) {
            this.bossEvent.setName(this.getDisplayName());
        }
        this.setAngryTick(compoundTag.getFloat("AngryTick"));
        this.setNeedStopTick(compoundTag.getInt("NeedStopTick"));
        this.setStopTick(compoundTag.getInt("StopTick"));
        this.blockDestroyTick = compoundTag.getDouble("BlockDestroyTick");
        this.bossEvent.setId(this.getUUID());
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(ANGRY_TICK, 0f);
        this.getEntityData().define(STOP_TICK, 0);
        this.getEntityData().define(NEED_STOP_TICK, 0);
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
                        this.angryAnimationState.startIfStopped(this.tickCount);
                        this.stopMostAnimation(this.angryAnimationState);
                        break;
                    case 2:
                        this.deadAnimationState.startIfStopped(this.tickCount);
                        this.stopMostAnimation(this.deadAnimationState);
                        break;
                }
            }
        }
        super.onSyncedDataUpdated(entityDataAccessor);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.updateSwingTime();
        if (this.random.nextInt	(900) == 1 && this.deathTime == 0) {
            this.heal(3.0f);
        }
        if (teleportCooldown > 0) {
            teleportCooldown--;
        }
        //停止战斗
        if (this.getTarget() != null && (!this.getTarget().isAlive() || this.getTarget() instanceof Player player && (player.isCreative() || player.isSpectator()))){
            this.setTarget(null);
        }
        //
        if (this.shieldCoolDown > 0){
            this.shieldCoolDown -= 1;
            this.shieldCanUse = 0;
        }
        if (this.shieldCoolDown <= 0){
            this.shieldCanUse = 1;
        }
        if (!this.level().isClientSide()) {
            this.setAttackTick(Math.max(this.getMinAttack(), this.getAttackTick() - 1));
            this.setThrowTick(Math.max(0, this.getThrowTick() - 1));
            this.setSpellTick(Math.max(0, this.getSpellTick() - 1));
        }
        //清除动画
        if (!this.level().isClientSide()) {
            this.setAnimTick(Math.max(-1, this.getAnimTick() - 1));
        }
        if (this.getAnimTick() == 0) {
            if (!this.level().isClientSide()) {
                this.setAnimationState(0);
            }
        }
        //战斗
        if (this.getAttackTick() > this.getMinAttack()) {
            if (!this.level().isClientSide()) {
                this.setAttackAnim(Math.min(this.getAttackAnim() + 1, 10));
            }
        }
        else {
            if (!this.level().isClientSide()) {
                this.setAttackAnim(Math.max(this.getAttackAnim() - 2, 0));
            }
        }
        //摧毁骑乘物
        Main.destroyRides(this);
        //使用盾牌和双手武器
        useBlockingItem(this);
        //替换自己的物品
        changeInventory(this);

        if (this.isAggressive() && this.shieldCanUse() && this.isUsingItem() && this.getUseItem().getItem() instanceof ShieldItem) {
            if (this.getOffhandItem().getItem() instanceof ShieldItem) {
                this.shieldUseOffhandAnimationState.start(this.tickCount);
            }
            else {
                this.shieldUseOffhandAnimationState.stop();
                if (this.getMainHandItem().getItem() instanceof ShieldItem) {
                    this.shieldUseMainhandAnimationState.start(this.tickCount);
                }
                else {
                    this.shieldUseMainhandAnimationState.stop();
                }
            }
        }
        else {
            this.shieldUseOffhandAnimationState.stop();
            this.shieldUseMainhandAnimationState.stop();
        }
        if (JVPillageGameRules.JVPILLAGE_SOME_ELITE_HAS_BOSS_BAR != null && this.level().getLevelData().getGameRules().getBoolean(JVPillageGameRules.JVPILLAGE_SOME_ELITE_HAS_BOSS_BAR) && OtherMainConfig.EliteCanHasBossBar.contains(this.getEncodeId())) {
            this.bossEvent.update();
            if (OtherMainConfig.EliteBossBarOnlyCombat) {
                this.bossEvent.setVisible(this.getTarget() != null);
            }
        }
        if (!this.level().isClientSide()) {
            //痕迹
            if (this.level().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
                BlockState blockState = JVPillageBlocks.SLIDER_MARK.get().defaultBlockState();
                for (int i = 0; i < 4; ++i) {
                    int n = Mth.floor(this.getX() + (double)((float)(i % 2 * 2 - 1) * 0.25f));
                    int n2 = Mth.floor(this.getY());
                    int n3 = Mth.floor(this.getZ() + (double)((float)(i / 2 % 2 * 2 - 1) * 0.25f));
                    BlockPos blockPos = new BlockPos(n, n2, n3);
                    if (!this.level().getBlockState(blockPos).isAir() || !blockState.canSurvive(this.level(), blockPos)) continue;
                    this.level().setBlockAndUpdate(blockPos, blockState);
                    this.level().gameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Context.of(this, blockState));
                }
            }
        }
        float angryAbout = 1;
        String string = ChatFormatting.stripFormatting(this.getName().getString());
        if ("Use".equals(string)) {
            if (this.getMainHandItem().is(JVPillageItems.CRAZY_AXE.get())) {
                if (this.isAggressive()) {
                    this.startUsingItem(InteractionHand.MAIN_HAND);
                    if (!this.level().isClientSide()) {
                        this.setAttackTick(0);
                        this.level().broadcastEntityEvent(this, (byte) 101);
                    }
                    if (this.getTarget() != null) {
                        this.lookAt(this.getTarget(), 360f, 360f);
                    }
                    this.getNavigation().stop();
                }
                else {
                    this.stopUsingItem();
                }
            }
        }
        //愤怒
        if (this.getAngryTick() > 0) {
            if (!this.isAggressive()) {
                if (!this.level().isClientSide()) {
                    this.setAngryTick(Math.max(0, this.getAngryTick() - angryAbout));
                }
            }
            else {
                if (!this.level().isClientSide()) {
                    this.setAngryTick(Math.max(0, this.getAngryTick() - angryAbout * 0.1f));
                }
            }
        }
        //站立动画
        if (this.isAlive()) {
            this.idleAnimationState.startIfStopped((int) (this.tickCount + getAngryTick()));
        }
        //休息
        if (!this.level().isClientSide()) {
            this.setStopTick(Math.max(0, this.getStopTick() - 1));
        }
        if (this.getNeedStopTick() > 0 && this.getStopTick() <= 0) {
            if (!this.level().isClientSide()) {
                this.setNeedStopTick(this.getNeedStopTick() - 1);
            }
        }
        if (this.getTarget() == null) {
            if (!this.level().isClientSide()) {
                this.setNeedStopTick(180);
            }
        }
        //酝酿怒气
            if (this.getNeedStopTick() <= 0 && this.getRandom().nextInt(8 * 20) == 1 && this.isAlive()) {
                if (!this.level().isClientSide()) {
                    this.setAngryTick(Math.min(240, this.getAngryTick() + 80));
                }
                if (!this.isSilent()) {
                    this.playSound(JVPillageSoundEvents.AX_CRAZY_ANGRY, 5.0f, 1.0f);
                }
                if (!this.level().isClientSide()) {
                    this.setStopTick(90);
                    this.setNeedStopTick(180);
                    this.setAnimTick(90);
                    this.setAnimationState("angry");
                }

        }
        //破坏方块
        if (this.blockDestroyTick > 0) {
            this.blockDestroyTick -= 1;
        }
        if (this.blockDestroyTick <= 0 && (this.horizontalCollision || this.getTarget() != null && this.getTarget().getY() > this.getY() && this.verticalCollision) && this.level().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
            boolean canBlockDestroy = this.level().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING);
            boolean blockDestroy = Main.BlockDestroy(this, 10f);
            if (blockDestroy) {
                if (this.getStopTick() <= 0 && this.getAttackTick() <= this.getMinAttack()) {
                    //群攻
                    List<LivingEntity> list = this.level().getEntitiesOfClass(LivingEntity.class, this.getAttackBoundingBox().inflate(1.5, 1.0, 1.5));
                    if (!this.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()) {
                        for (LivingEntity hurt : list) {
                            if (hurt == null) continue;
                            if (AttackFind.FindCanNotAttack(this, hurt)) continue;
                            if (!this.hasLineOfSight(hurt)) continue;
                            double healthOld = hurt.getHealth();
                            AttackFind.attackBegin(this, hurt);
                            boolean bl4 = AttackFind.attackAfter(this, hurt, 1.0f, 0.25f, false, 0f);
                            if (bl4) {
                                if (!this.level().isClientSide()) {
                                    this.setAngryTick(Math.min(240, this.getAngryTick() + angryAbout * 2));
                                }
                                double healthNew = hurt.getHealth();
                                if ((float) (healthOld - healthNew)/3 > 0) {
                                    this.heal((float) (healthOld - healthNew) / 3);
                                }
                                if (this.level() instanceof ServerLevel serverLevel) {
                                    for (int i = 0; i < (healthOld - healthNew)/6; ++i) {
                                        serverLevel.sendParticles(ParticleTypes.HEART, this.getRandomX(1f), this.getRandomY(), this.getRandomZ(1f), 0, 0, 0.0, 0, 0.0);
                                        serverLevel.sendParticles(ParticleTypes.ANGRY_VILLAGER, this.getRandomX(1f), this.getRandomY(), this.getRandomZ(1f), 0, 0, 0.0, 0, 0.0);
                                    }
                                }
                            }
                        }
                        //横扫效果
                        Main.sweepAttack(this);
                    }
                }
                this.blockDestroyTick = 40;
            }
            if (!this.level().isClientSide) {
                if (!canBlockDestroy && this.onGround()) {
                    this.jumpFromGround();
                }
            }
        }
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (this.getStopTick() > 0) {
            return false;
        }
        if (this.getAttackTick() > this.getMinAttack()) {
            return false;
        }
        float angryAbout = 1;
        String string = ChatFormatting.stripFormatting(this.getName().getString());
        if (!this.level().isClientSide()) {
            this.setAttackTick(0);
            this.level().broadcastEntityEvent(this, (byte) 101);
        }
        double healthOldMain = 0;
        if (entity instanceof LivingEntity livingEntity) {
            healthOldMain = livingEntity.getHealth();
        }
        int base = 3;
        boolean bl = super.doHurtTarget(entity);
        if (bl) {
            //常规
            if (entity instanceof LivingEntity livingEntity) {
                if (!livingEntity.level().isClientSide) {
                    livingEntity.addEffect(new MobEffectInstance(JerotesMobEffects.CORROSIVE.get(), 60, 0), this);
                }
            }
            if (!this.isSilent() && (this.getAngryTick() < 120)) {
                    this.playSound(JVPillageSoundEvents.AX_CRAZY_ATTACK, 5.0f, 1.0f);

            }
            else {
                this.playSound(SoundEvents.PLAYER_ATTACK_CRIT, 2.0f, 1.0f);
            }
            if (!this.level().isClientSide()) {
                this.setAngryTick(Math.min(240, this.getAngryTick() + angryAbout * 2));
            }
            if (entity instanceof LivingEntity livingEntity) {
                double healthNewMain = livingEntity.getHealth();
                if ((float) (healthOldMain - healthNewMain) / 3 > 0) {
                    this.heal((float) (healthOldMain - healthNewMain) / 3);
                }
                if (this.level() instanceof ServerLevel serverLevel) {
                    for (int i = 0; i < (healthOldMain - healthNewMain) / 6; ++i) {
                        serverLevel.sendParticles(ParticleTypes.HEART, this.getRandomX(1f), this.getRandomY(), this.getRandomZ(1f), 0, 0, 0.0, 0, 0.0);
                        serverLevel.sendParticles(ParticleTypes.ANGRY_VILLAGER, this.getRandomX(1f), this.getRandomY(), this.getRandomZ(1f), 0, 0, 0.0, 0, 0.0);
                    }
                }
            }
            //群攻
            List<LivingEntity> list = this.level().getEntitiesOfClass(LivingEntity.class, entity.getBoundingBox().inflate(1.5, 1.0, 1.5));
            if (!this.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()) {
                for (LivingEntity hurt : list) {
                    if (hurt == null) continue;
                    if (AttackFind.FindCanNotAttack(this, hurt, entity)) continue;
                    if (AttackFind.FindCanNotAttack(this, hurt)) continue;
                    if (!this.hasLineOfSight(hurt)) continue;
                    double healthOld = hurt.getHealth();
                    AttackFind.attackBegin(this, hurt);
                    boolean bl2 = AttackFind.attackAfter(this, hurt, 1.0f, 0.25f, false, 0f);
                    if (bl2) {
                        if (!this.level().isClientSide()) {
                            this.setAngryTick(Math.min(240, this.getAngryTick() + angryAbout * 2));
                        }
                        double healthNew = hurt.getHealth();
                        if ((float) (healthOld - healthNew)/base > 0) {
                            this.heal((float) (healthOld - healthNew) / base);
                        }
                        if (this.level() instanceof ServerLevel serverLevel) {
                            for (int i = 0; i < (healthOld - healthNew)/6; ++i) {
                                serverLevel.sendParticles(ParticleTypes.HEART, this.getRandomX(1f), this.getRandomY(), this.getRandomZ(1f), 0, 0, 0.0, 0, 0.0);
                                serverLevel.sendParticles(ParticleTypes.ANGRY_VILLAGER, this.getRandomX(1f), this.getRandomY(), this.getRandomZ(1f), 0, 0, 0.0, 0, 0.0);
                            }
                        }
                    }
                }
                //横扫效果
                Main.sweepAttack(this);
            }
        }
        else {
            DamageSource damageSource = AttackFind.findDamageType(this, JVPillageDamageTypes.AX_CRAZY_ATTACK, this);
            AttackFind.attackBegin(this, entity);
            boolean bl3 = AttackFind.attackAfterCustomDamage(this, entity, damageSource, 1.0f, 1.0f, false, 0f);
            if (bl3) {
                //常规
                if (!this.isSilent() && (this.getAngryTick() < 120 || this.getRandom().nextFloat() > 0.85f)) {
                        this.playSound(JVPillageSoundEvents.AX_CRAZY_ATTACK, 5.0f, 1.0f);

                }
                if (!this.level().isClientSide()) {
                    this.setAngryTick(Math.min(240, this.getAngryTick() + angryAbout * 2));
                }
                if (entity instanceof LivingEntity livingEntity) {
                    double healthNewMain = livingEntity.getHealth();
                    if ((float) (healthOldMain - healthNewMain) / 3 > 0) {
                        this.heal((float) (healthOldMain - healthNewMain) / 3);
                    }
                    if (this.level() instanceof ServerLevel serverLevel) {
                        for (int i = 0; i < (healthOldMain - healthNewMain) / 6; ++i) {
                            serverLevel.sendParticles(ParticleTypes.HEART, this.getRandomX(1f), this.getRandomY(), this.getRandomZ(1f), 0, 0, 0.0, 0, 0.0);
                            serverLevel.sendParticles(ParticleTypes.ANGRY_VILLAGER, this.getRandomX(1f), this.getRandomY(), this.getRandomZ(1f), 0, 0, 0.0, 0, 0.0);
                        }
                    }
                }
                //群攻
                List<LivingEntity> list = this.level().getEntitiesOfClass(LivingEntity.class, entity.getBoundingBox().inflate(1.5, 1.0, 1.5));
                if (!this.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()) {
                    for (LivingEntity hurt : list) {
                        if (hurt == null) continue;
                        if (AttackFind.FindCanNotAttack(this, hurt, entity)) continue;
                        if (AttackFind.FindCanNotAttack(this, hurt)) continue;
                        if (!this.hasLineOfSight(hurt)) continue;
                        double healthOld = hurt.getHealth();
                        AttackFind.attackBegin(this, hurt);
                        boolean bl4 = AttackFind.attackAfter(this, hurt, 1.0f, 0.25f, false, 0f);
                        if (bl4) {
                            if (!this.level().isClientSide()) {
                                this.setAngryTick(Math.min(240, this.getAngryTick() + angryAbout * 2));
                            }
                            double healthNew = hurt.getHealth();
                            if ((float) (healthOld - healthNew)/3 > 0) {
                                this.heal((float) (healthOld - healthNew) / 3);
                            }
                            if (this.level() instanceof ServerLevel serverLevel) {
                                for (int i = 0; i < (healthOld - healthNew)/6; ++i) {
                                    serverLevel.sendParticles(ParticleTypes.HEART, this.getRandomX(1f), this.getRandomY(), this.getRandomZ(1f), 0, 0, 0.0, 0, 0.0);
                                    serverLevel.sendParticles(ParticleTypes.ANGRY_VILLAGER, this.getRandomX(1f), this.getRandomY(), this.getRandomZ(1f), 0, 0, 0.0, 0, 0.0);
                                }
                            }
                        }
                    }
                    //横扫效果
                    Main.sweepAttack(this);
                }
            }
        }
        return true;
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        if (damageSource.is(DamageTypes.CACTUS)
                || damageSource.is(DamageTypes.SWEET_BERRY_BUSH)
                || damageSource.is(JerotesDamageTypes.BLEED)
                || damageSource.is(DamageTypeTags.IS_FALL))
            return true;
        return super.isInvulnerableTo(damageSource);
    }

    @Override
    public boolean hurt(DamageSource damageSource, float amount) {
        if (isInvulnerableTo(damageSource)) {
            return super.hurt(damageSource, amount);
        }
        if (!EntityAndItemFind.MagicResistance(damageSource) && !damageSource.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            //光滑
            if (amount < this.getAttributeValue(Attributes.MAX_HEALTH) * 0.75f) {
                if (this.random.nextFloat() < 0.75) {
                    return false;
                }
            }
            else if (amount < this.getAttributeValue(Attributes.MAX_HEALTH) * 1.5f) {
                if (this.random.nextFloat() < 0.5) {
                    return false;
                }
            }
        }
        float angryAbout = 1;
        String string = ChatFormatting.stripFormatting(this.getName().getString());
        if (this.isAggressive() && this.getStopTick() <= 0) {
            if (!this.level().isClientSide()) {
                this.setAngryTick(Math.min(240, this.getAngryTick() + angryAbout * 3));
            }
        }
        float angryAmount = (float) (amount - (getAngryTick()/240 * amount) * 3/4);
        if (this.getStopTick() > 0) {
            angryAmount = amount * 1.5f;
            if (damageSource.is(JerotesDamageTypes.SYRINGE)) {
                if (!this.level().isClientSide()) {
                    this.setAngryTick(Math.max(0, this.getAngryTick() - amount * 120f));
                }
            }
            else {
                if (!this.level().isClientSide()) {
                    this.setAngryTick(Math.max(0, this.getAngryTick() - amount * 5f));
                }
            }
            if (!this.level().isClientSide()) {
                this.setStopTick(0);
            }
            this.angryAnimationState.stop();
        }
        if (damageSource.is(JerotesDamageTypes.SYRINGE)) {
            return super.hurt(damageSource, angryAmount * 60);
        }
        return super.hurt(damageSource, angryAmount);
    }

    @Override
    public ItemStack createSpawnWeapon(float weaponRandom) {
        return new ItemStack(JVPillageItems.CRAZY_AXE.get());
    }

    @Override
    public void handleEntityEvent(byte by) {
        if (by == 101) {
            String string = ChatFormatting.stripFormatting(this.getName().getString());
            if (this.getMainHandItem().isEmpty()) {
                this.attackAnimationState.start(this.tickCount);
            }
            else {
                int attackRandom = this.getRandom().nextInt(30);
                if (attackRandom > 20) {
                    this.itemAttack1AnimationState.start(this.tickCount);
                } else if (attackRandom > 10) {
                    this.itemAttack2AnimationState.start(this.tickCount);
                } else {
                    this.itemAttack3AnimationState.start(this.tickCount);
                }
            }
        }
        else {
            super.handleEntityEvent(by);
        }
    }
    @Override
    public void tickDeath() {
        String string = ChatFormatting.stripFormatting(this.getName().getString());
        if(deathTime <= 0 ){
            if (!this.level().isClientSide()) {
                this.setAnimTick(20);
                this.setAnimationState("dead");
            }
        }
        ++this.deathTime;
        if (this.deathTime >= 20 && !this.level().isClientSide() && !this.isRemoved()) {
            this.level().broadcastEntityEvent(this, (byte) 60);
            this.remove(RemovalReason.KILLED);
        }
    }
}
