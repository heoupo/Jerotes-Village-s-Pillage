package com.jerotes.jvpillage.entity.Monster.IllagerFaction;

import com.jerotes.jerotes.entity.Interface.*;
import com.jerotes.jerotes.entity.Mob.HumanEntity;
import com.jerotes.jerotes.event.JerotesBossEvent;
import com.jerotes.jerotes.goal.JerotesHelpAlliesGoal;
import com.jerotes.jerotes.goal.JerotesHelpSameFactionGoal;
import com.jerotes.jerotes.util.AttackFind;
import com.jerotes.jerotes.util.EntityAndItemFind;
import com.jerotes.jerotes.util.EntityFactionFind;
import com.jerotes.jvpillage.config.OtherMainConfig;
import com.jerotes.jvpillage.entity.Boss.OminousBannerProjectionEntity;
import com.jerotes.jvpillage.entity.MagicSummoned.BlamerNecromancyWarlock.BlamerNecromancyWarlockEntity;
import com.jerotes.jvpillage.entity.Other.UncleanTentacleEntity;
import com.jerotes.jvpillage.init.*;
import com.jerotes.jvpillage.spell.OtherSpellList;
import com.jerotes.jvpillage.util.OtherEntityFactionFind;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.VisibleForDebug;
import net.minecraft.world.BossEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.InventoryCarrier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;
import net.minecraftforge.items.wrapper.EntityArmorInvWrapper;
import net.minecraftforge.items.wrapper.EntityHandsInvWrapper;
import net.minecraftforge.items.wrapper.InvWrapper;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.jerotes.jvpillage.event.ArmorEvent.hasCurio;

public class FuryBlamerNecromancyWarlockEntity extends Raider implements RangedAttackMob, SpellUseEntity, EliteEntity, InventoryCarrier, InventoryEntity , PurpleSandSisterhoodEntity , JerotesEntity {
    private static final EntityDataAccessor<Integer> COMBAT_STYLE = SynchedEntityData.defineId(FuryBlamerNecromancyWarlockEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> USE_SELF_NOT_SPELL_LIST = SynchedEntityData.defineId(FuryBlamerNecromancyWarlockEntity.class, EntityDataSerializers.BOOLEAN);
    protected static final EntityDataAccessor<Integer> ANIM_STATE = SynchedEntityData.defineId(FuryBlamerNecromancyWarlockEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> ANIM_TICK = SynchedEntityData.defineId(FuryBlamerNecromancyWarlockEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> SPELL_TICK = SynchedEntityData.defineId(FuryBlamerNecromancyWarlockEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> SPELL_ONE_TICK = SynchedEntityData.defineId(FuryBlamerNecromancyWarlockEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> SPELL_TWO_TICK = SynchedEntityData.defineId(FuryBlamerNecromancyWarlockEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> SPELL_THREE_TICK = SynchedEntityData.defineId(FuryBlamerNecromancyWarlockEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> CAN_CHANGE_INVENTORY = SynchedEntityData.defineId(FuryBlamerNecromancyWarlockEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> CAN_CHANGE_MELEE_OR_RANGE = SynchedEntityData.defineId(FuryBlamerNecromancyWarlockEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> NO_COMBAT_EMPTY_WEAPON = SynchedEntityData.defineId(FuryBlamerNecromancyWarlockEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> NO_COMBAT_EMPTY_SHIELD = SynchedEntityData.defineId(FuryBlamerNecromancyWarlockEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> CHANGE_INVENTORY_COOLDOWN_TICK = SynchedEntityData.defineId(FuryBlamerNecromancyWarlockEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Byte> DATA_SPELL_CASTING_ID = SynchedEntityData.defineId(FuryBlamerNecromancyWarlockEntity.class, EntityDataSerializers.BYTE);;
    public final SimpleContainer inventory = new SimpleContainer(inventoryCount());
    private LazyOptional<?> itemHandler = null;


    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState gearAnimationState = new AnimationState();
    public AnimationState screamAnimationState = new AnimationState();
    public AnimationState whisperAnimationState = new AnimationState();
    public AnimationState rainAnimationState = new AnimationState();
    public AnimationState fogAnimationState = new AnimationState();
    public AnimationState summonAnimationState = new AnimationState();
    public AnimationState deadAnimationState = new AnimationState();
    private final JerotesBossEvent bossEvent = new JerotesBossEvent(this, this.getUUID(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.NOTCHED_6, false);

    public FuryBlamerNecromancyWarlockEntity(EntityType<? extends FuryBlamerNecromancyWarlockEntity> entityType, Level level) {
        super(entityType, level);
        this.xpReward = 80;
        this.setCanPickUpLoot(false);
//他处代码↓
        this.entityData.define(DATA_SPELL_CASTING_ID, (byte)0);

        this.setPathfindingMalus(BlockPathTypes.DOOR_WOOD_CLOSED, 0.0f);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0f);
        this.itemHandler = LazyOptional.of(this::createCombinedHandler);

//他处代码↑
    }
//他处代码↓
    public boolean isCastingSpell() {
        return this.getSpellTick() > 0;
    }
    public IllagerArmPose getArmPose() {
    if (this.getSpellTick() > 0 || this.isCastingSpell()) {
        return IllagerArmPose.SPELLCASTING;
    }
    return IllagerArmPose.CROSSED;
    }
    public enum IllagerArmPose {
        CROSSED,
        ATTACKING,
        SPELLCASTING,
        BOW_AND_ARROW,
        CROSSBOW_HOLD,
        CROSSBOW_CHARGE,
        CELEBRATING,
        NEUTRAL;

        IllagerArmPose() {
        }
    }
    private IItemHandler createCombinedHandler() {
        IItemHandlerModifiable handsHandler = new EntityHandsInvWrapper(this);
        IItemHandlerModifiable armorHandler = new EntityArmorInvWrapper(this);
        IItemHandlerModifiable customHandler = new InvWrapper(this.inventory);
        return new CombinedInvWrapper(
                armorHandler,
                handsHandler,
                customHandler
        );
    }

    @Override
    public SimpleContainer mobInventory() {
        return inventory;
    }
    @Override
    public int inventoryCount() {
        return 8;
    }
    @Override
    public boolean isCanChangeInventory() {
        return this.getEntityData().get(CAN_CHANGE_INVENTORY);
    }
    @Override
    public void setCanChangeInventory(boolean bl) {
        this.getEntityData().set(CAN_CHANGE_INVENTORY, bl);
    }
    @Override
    public boolean isCanChangeMeleeOrRange() {
        return this.getEntityData().get(CAN_CHANGE_MELEE_OR_RANGE);
    }
    @Override
    public void setCanChangeMeleeOrRange(boolean bl) {
        this.getEntityData().set(CAN_CHANGE_MELEE_OR_RANGE, bl);
    }
    @VisibleForDebug
    @Override
    public SimpleContainer getInventory() {
        return this.inventory;
    }
    @Override
    public void applyRaidBuffs(int p_37844_, boolean p_37845_) {
    }
    public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
        return capability == ForgeCapabilities.ITEM_HANDLER && itemHandler != null &&
                this.isAlive() ? itemHandler.cast() : super.getCapability(capability, facing);
    }
    public void invalidateCaps() {
        super.invalidateCaps();
        if (this.itemHandler != null) {
            LazyOptional<?> oldHandler = this.itemHandler;
            this.itemHandler = null;
            oldHandler.invalidate();
        }
    }

    public void setSpellTick(int n){
        this.getEntityData().set(SPELL_TICK, n);
    }
    public int getSpellTick(){
        return this.getEntityData().get(SPELL_TICK);
    }
    public void setSpellOneTick(int n){
        this.getEntityData().set(SPELL_ONE_TICK, n);
    }
    public int getSpellOneTick(){
        return this.getEntityData().get(SPELL_ONE_TICK);
    }
    public void setSpellTwoTick(int n){
        this.getEntityData().set(SPELL_TWO_TICK, n);
    }
    public int getSpellTwoTick(){
        return this.getEntityData().get(SPELL_TWO_TICK);
    }
    public void setSpellThreeTick(int n){
        this.getEntityData().set(SPELL_THREE_TICK, n);
    }
    public int getSpellThreeTick(){
        return this.getEntityData().get(SPELL_THREE_TICK);
    }
    //动画
    public void setAnimTick(int n){
        this.getEntityData().set(ANIM_TICK, n);
    }
    public int getAnimTick(){
        return this.getEntityData().get(ANIM_TICK);
    }
    public void setAnimationState(String input) {
        this.setAnimationState(this.getAnimationState(input));
    }
    public void setAnimationState(int id) {
        this.entityData.set(ANIM_STATE, id);
    }

    public void stopMostAnimation(AnimationState exception){
        for (AnimationState state : this.getAllAnimations()){
            if (state != exception) {
                state.stop();
            }
        }
    }
    public void stopAllAnimation(){
        for (AnimationState state : this.getAllAnimations()){
            state.stop();
        }
    }
//他处代码↑

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
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.35);
        builder = builder.add(Attributes.MAX_HEALTH, 127);
        builder = builder.add(Attributes.ARMOR, 8);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.2);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 4);
        builder = builder.add(Attributes.FOLLOW_RANGE, 64);
        builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.3);
        return builder;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 0.4, 120, 12.0F));
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.6));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 3.0f, 1.0f));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, HumanEntity.class, 3.0f, 1.0f));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Mob.class, 8.0f));
        this.goalSelector.addGoal(0, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, AbstractIllager.class, 3.0f, 1.0f));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, new Class[0]).setAlertOthers(new Class[0]));
        this.targetSelector.addGoal(1, new JerotesHelpSameFactionGoal(this, LivingEntity.class, false, false, livingEntity -> livingEntity instanceof LivingEntity));
        this.targetSelector.addGoal(1, new JerotesHelpAlliesGoal(this, LivingEntity.class, false, false, livingEntity -> livingEntity instanceof LivingEntity));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<Player>(this, Player.class, false){
            @Override
            public boolean canUse() {
                if (FuryBlamerNecromancyWarlockEntity.this.level().getDifficulty() == Difficulty.PEACEFUL) {
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
        if (this.getSpellTick() > 0) {
            return;
        }
        List<Mob> listRaider = this.level().getEntitiesOfClass(Mob.class, this.getBoundingBox().inflate(32.0, 32.0, 32.0));
        listRaider.removeIf(entity -> this.getTarget() == entity || entity == this || entity.getTarget() == this || !((EntityFactionFind.isRaider(entity) && this.getTeam() == null && entity.getTeam() == null) || (entity.isAlliedTo(this))));
        listRaider.removeIf(entity -> entity instanceof FuryBlamerNecromancyWarlockEntity);
        //增强
        int spellLevel = this.getSpellLevel();
        String string = ChatFormatting.stripFormatting(this.getName().getString());


        List<UncleanTentacleEntity> listTentacle = this.level().getEntitiesOfClass(UncleanTentacleEntity.class, this.getBoundingBox().inflate(64.0, 64.0, 64.0));
        listRaider.removeIf(entity -> this.getTarget() == entity || entity.getTarget() == this || !((this.getTeam() == null && entity.getTeam() == null) || (entity.isAlliedTo(this))));
        List<FuryBlamerNecromancyWarlockEntity> ListWarlock = this.level().getEntitiesOfClass(FuryBlamerNecromancyWarlockEntity.class, this.getBoundingBox().inflate(64.0, 64.0, 64.0));
        ListWarlock.removeIf(entity -> this.getTarget() == entity || entity.getTarget() == this || !((this.getTeam() == null && entity.getTeam() == null) || (entity.isAlliedTo(this))));

        //技能-邪祟召唤
        if (this.random.nextFloat() < 0.8f && listRaider.isEmpty() && listTentacle.size() <= ListWarlock.size() * 4){
            if (!this.level().isClientSide()) {
                this.setSpellTick(40);
                this.setAnimTick(20);
                this.setAnimationState("summon");
            }
            //法术列表-邪祟召唤
            OtherSpellList.EvilSummoning(spellLevel, this, livingEntity).spellUse();
        }
        //技能-不祥齿轮
        else if (this.random.nextFloat() < 0.2f && this.distanceTo(livingEntity) < 12 && livingEntity.onGround()) {
            if (!this.level().isClientSide()) {
                this.setSpellTick(90);
                this.setSpellOneTick(90);
                this.setAnimTick(90);
                this.setAnimationState("gear");
            }
            if (!this.isSilent()) {
                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), JVPillageSoundEvents.NECROMANCY_WARLOCK_GEAR, this.getSoundSource(), 5.0f, 0.8f + this.getRandom().nextFloat() * 0.4f);
            }
        }
        //技能-血腥尖啸
        else if (this.random.nextFloat() < 0.2f){
            if (!this.level().isClientSide()) {
                this.setSpellTick(20);
                this.setAnimTick(20);
                this.setAnimationState("scream");
            }
            //法术列表-血腥尖啸
            OtherSpellList.BloodyScream(spellLevel, this, livingEntity).spellUse();
        }
        //技能-神汉低语
        else if (this.random.nextFloat() < 0.15f && !(livingEntity.hasEffect(MobEffects.DARKNESS))){
            if (!this.level().isClientSide()) {
                this.setSpellTick(25);
                this.setAnimTick(25);
                this.setAnimationState("whisper");
            }
            //法术列表-血腥尖啸
            OtherSpellList.WarlockWhisper(spellLevel, this, livingEntity).spellUse();
        }
        //技能-不洁血雨
        else if (this.random.nextFloat() < 0.4f){
            if (!this.level().isClientSide()) {
                this.setSpellTick(15);
                this.setSpellTwoTick(15);
                this.setAnimTick(15);
                this.setAnimationState("rain");
            }
        }
        //技能-邪祟召唤
        else if (this.random.nextFloat() < 0.2f && listTentacle.size() <= ListWarlock.size() * 4){
            if (!this.level().isClientSide()) {
                this.setSpellTick(40);
                this.setAnimTick(20);
                this.setAnimationState("summon");
            }
            //法术列表-邪祟召唤
            OtherSpellList.EvilSummoning(spellLevel, this, livingEntity).spellUse();
        }
        //技能-不洁血雾
        else {
            if (!this.level().isClientSide()) {
                this.setSpellTick(15);
                this.setSpellThreeTick(15);
                this.setAnimTick(15);
                this.setAnimationState("fog");
            }
        }

    }

    @Override
    protected SoundEvent getAmbientSound() {
        return JVPillageSoundEvents.NECROMANCY_WARLOCK_AMBIENT;
    }
    @Override
    protected SoundEvent getDeathSound() {
        return JVPillageSoundEvents.NECROMANCY_WARLOCK_DEATH;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return JVPillageSoundEvents.NECROMANCY_WARLOCK_HURT;
    }
    public SoundEvent getCelebrateSound() {
        return JVPillageSoundEvents.NECROMANCY_WARLOCK_CHEER;
    }

    protected SoundEvent getCastingSoundEvent() {
        return JVPillageSoundEvents.NECROMANCY_WARLOCK_GEAR;
    }

    @Override
    protected float getSoundVolume() {
        return 2.0f;
    }
    @Override
    public boolean canDrownInFluidType(FluidType type) {
        if (type == ForgeMod.WATER_TYPE.get())
            return false;
        return super.canDrownInFluidType(type);
    }

    public int spellLevel = 3;
    @Override
    public int getSpellLevel() {
        return this.spellLevel;
    }
    //动画
    public int getAnimationState(String animation) {
        if (Objects.equals(animation, "gear")){
            return 1;
        }
        else if (Objects.equals(animation, "scream")){
            return 2;
        }
        else if (Objects.equals(animation, "whisper")){
            return 3;
        }
        else if (Objects.equals(animation, "rain")){
            return 4;
        }
        else if (Objects.equals(animation, "fog")){
            return 5;
        }
        else if (Objects.equals(animation, "summon")){
            return 6;
        }
        else if (Objects.equals(animation, "dead")){
            return 7;
        }
        else {
            return 0;
        }
    }
    public List<AnimationState> getAllAnimations(){
        List<AnimationState> list = new ArrayList<>();
        list.add(this.gearAnimationState);
        list.add(this.screamAnimationState);
        list.add(this.whisperAnimationState);
        list.add(this.rainAnimationState);
        list.add(this.fogAnimationState);
        list.add(this.summonAnimationState);
        list.add(this.deadAnimationState);
        return list;
    }
    //
    @Override
    public void setCustomName(@Nullable Component component) {
        super.setCustomName(component);
        this.bossEvent.setName(this.getDisplayName());
    }
    //冠军重命名与标签


    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);


        compoundTag.putBoolean("IsCanChangeInventory", this.isCanChangeInventory());
        compoundTag.putBoolean("IsCanChangeMeleeOrRange", this.isCanChangeMeleeOrRange());
        compoundTag.putInt("SpellLevel", this.spellLevel);
        compoundTag.putInt("AnimTick", this.getAnimTick());
        compoundTag.putInt("SpellTick", this.getSpellTick());
        compoundTag.putInt("SpellOneTick", this.getSpellOneTick());
        compoundTag.putInt("SpellTwoTick", this.getSpellTwoTick());
        compoundTag.putInt("SpellThreeTick", this.getSpellThreeTick());
    }
    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);


        this.setCanChangeInventory(compoundTag.getBoolean("IsCanChangeInventory"));
        this.setCanChangeMeleeOrRange(compoundTag.getBoolean("IsCanChangeMeleeOrRange"));
        this.spellLevel = compoundTag.getInt("SpellLevel");
        this.setAnimTick(compoundTag.getInt("AnimTick"));
        this.setSpellTick(compoundTag.getInt("SpellTick"));
        this.setSpellOneTick(compoundTag.getInt("SpellOneTick"));
        this.setSpellTwoTick(compoundTag.getInt("SpellTwoTick"));
        this.setSpellThreeTick(compoundTag.getInt("SpellThreeTick"));
        if (this.hasCustomName()) {
            this.bossEvent.setName(this.getDisplayName());
        }
        this.bossEvent.setId(this.getUUID());
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();

        this.getEntityData().define(USE_SELF_NOT_SPELL_LIST, true);
        this.getEntityData().define(COMBAT_STYLE, 1);
        this.getEntityData().define(ANIM_STATE, 0);
        this.getEntityData().define(ANIM_TICK, 0);
        this.getEntityData().define(SPELL_TICK, 0);
        this.getEntityData().define(SPELL_ONE_TICK, 0);
        this.getEntityData().define(SPELL_TWO_TICK, 0);
        this.getEntityData().define(SPELL_THREE_TICK, 0);
        this.getEntityData().define(CAN_CHANGE_INVENTORY, false);
        this.getEntityData().define(CAN_CHANGE_MELEE_OR_RANGE, false);
        this.getEntityData().define(NO_COMBAT_EMPTY_WEAPON, false);
        this.getEntityData().define(NO_COMBAT_EMPTY_SHIELD, false);
        this.getEntityData().define(CHANGE_INVENTORY_COOLDOWN_TICK, 50);
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
                        this.gearAnimationState.startIfStopped(this.tickCount);
                        this.stopMostAnimation(this.gearAnimationState);
                        break;
                    case 2:
                        this.screamAnimationState.startIfStopped(this.tickCount);
                        this.stopMostAnimation(this.screamAnimationState);
                        break;
                    case 3:
                        this.whisperAnimationState.startIfStopped(this.tickCount);
                        this.stopMostAnimation(this.whisperAnimationState);
                        break;
                    case 4:
                        this.rainAnimationState.startIfStopped(this.tickCount);
                        this.stopMostAnimation(this.rainAnimationState);
                        break;
                    case 5:
                        this.fogAnimationState.startIfStopped(this.tickCount);
                        this.stopMostAnimation(this.fogAnimationState);
                        break;
                    case 6:
                        this.summonAnimationState.startIfStopped(this.tickCount);
                        this.stopMostAnimation(this.summonAnimationState);
                        break;
                    case 7:
                        this.deadAnimationState.startIfStopped(this.tickCount);
                        this.stopMostAnimation(this.deadAnimationState);
                        break;
                }
            }
        }
        super.onSyncedDataUpdated(entityDataAccessor);
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEAD;
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (JVPillageGameRules.JVPILLAGE_SOME_ELITE_HAS_BOSS_BAR != null && this.level().getLevelData().getGameRules().getBoolean(JVPillageGameRules.JVPILLAGE_SOME_ELITE_HAS_BOSS_BAR) && OtherMainConfig.EliteCanHasBossBar.contains(this.getEncodeId())) {
            this.bossEvent.update();
            if (OtherMainConfig.EliteBossBarOnlyCombat) {
                this.bossEvent.setVisible(this.getTarget() != null);
            }
        }


        //
        if (this.getSpellTick() > 0){
            if (!this.level().isClientSide()) {
                this.setSpellTick(this.getSpellTick() - 1);
            }
        }
        if (!this.level().isClientSide()) {
            this.setSpellOneTick(Math.max(0, this.getSpellOneTick() - 1));
            this.setSpellTwoTick(Math.max(0, this.getSpellTwoTick() - 1));
            this.setSpellThreeTick(Math.max(0, this.getSpellThreeTick() - 1));
        }
        //站立
        if (this.isAlive()){
            this.idleAnimationState.startIfStopped((this.tickCount));
        }
        //增强
        int spellLevel = this.getSpellLevel();
        String string = ChatFormatting.stripFormatting(this.getName().getString());
        if (this.isAlive()) {
            //技能-不祥齿轮
            if (this.getSpellOneTick() > 0 && this.getSpellOneTick() % 10 == 0) {
                //法术列表-不祥齿轮
                OtherSpellList.OminousGear(spellLevel, this, this.getTarget()).spellUse();
            }
            //技能-不洁血雨
            if (this.getSpellTwoTick() == 5 && this.getTarget() != null) {
                //法术列表-不洁血雨
                OtherSpellList.UncleanBloodRain(spellLevel, this, this.getTarget()).spellUse();
            }
            //技能-不洁血雾
            if (this.getSpellThreeTick() == 5 && this.getTarget() != null) {
                //法术列表-不洁血雨
                OtherSpellList.UncleanBloodFog(spellLevel, this, this.getTarget()).spellUse();
            }
            //清除不洁
            if (this.tickCount % 5 == 0) {
                List<Mob> listRaider = this.level().getEntitiesOfClass(Mob.class, this.getBoundingBox().inflate(32.0, 32.0, 32.0));

                listRaider.stream()
                        .filter(entity -> AttackFind.FindCanNotAttack(this, entity))
                        .filter(entity -> !(entity instanceof FuryBlamerNecromancyWarlockEntity))
                        .forEach(raider -> {
                            if (raider.hasEffect(JVPillageMobEffects.UNCLEAN_BODY.get())) {
                                raider.removeEffect(JVPillageMobEffects.UNCLEAN_BODY.get());
                            }
                            if (raider.hasEffect(MobEffects.CONFUSION)) {
                                raider.removeEffect(MobEffects.CONFUSION);
                            }
                        });
            }
            if (this.level().isClientSide()) {
                this.level().addParticle(JVPillageParticleTypes.BLAMER_SOUL.get(), this.getRandomX(0.5), this.getRandomY(), this.getRandomZ(0.5), 0.0, 0.0, 0.0);
            }
        }
    }
    //来自恶怨的免疫
    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        if (damageSource.is(DamageTypeTags.IS_DROWNING)
                || damageSource.is(DamageTypeTags.IS_FALL)
                || damageSource.is(DamageTypes.CACTUS)
                || damageSource.is(DamageTypes.SWEET_BERRY_BUSH))
            return true;
        return super.isInvulnerableTo(damageSource);
    }

    @Override
    public boolean hurt(DamageSource damageSource, float amount) {
        if (isInvulnerableTo(damageSource)) {
            return super.hurt(damageSource, amount);
        }
        if (!damageSource.is(DamageTypeTags.BYPASSES_INVULNERABILITY) && amount <= this.getMaxHealth() * 20) {
            //技能-不祥天选
            List<Mob> listRaider = this.level().getEntitiesOfClass(Mob.class, this.getBoundingBox().inflate(32.0, 32.0, 32.0));
            listRaider.removeIf(entity -> this.getTarget() == entity || entity == this || entity.getTarget() == this || !((EntityFactionFind.isRaider(entity) && this.getTeam() == null && entity.getTeam() == null) || (entity.isAlliedTo(this))));
            listRaider.removeIf(entity -> entity instanceof NecromancyWarlockEntity
                    || entity instanceof BlamerNecromancyWarlockEntity
                    || entity instanceof FuryBlamerNecromancyWarlockEntity
                    || entity instanceof OminousBannerProjectionEntity
                    || entity.getItemBySlot(EquipmentSlot.HEAD).getItem() == JVPillageItems.WARLOCK_TIARA.get()
                    || hasCurio(entity, JVPillageItems.WARLOCK_TIARA.get())
                    || entity.getItemBySlot(EquipmentSlot.HEAD).getItem() == JVPillageItems.WARLOCK_FAKE_TIARA.get()
                    || hasCurio(entity, JVPillageItems.WARLOCK_FAKE_TIARA.get()));
            if (!listRaider.isEmpty() && this.level().getRandom().nextFloat() < 0.5f + (listRaider.size() * 0.05f) && !damageSource.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                for (LivingEntity hurt : listRaider) {
                    if (hurt == null) continue;
                    if (!hurt.isAlive()) continue;
                    //原地粒子
                    if (this.level() instanceof ServerLevel serverLevel) {
                        for (int i = 0; i < 24; ++i) {
                            serverLevel.sendParticles(ParticleTypes.DAMAGE_INDICATOR, this.getRandomX(0.5f), this.getRandomY(), this.getRandomZ(0.5f), 0, 0, 0.0, 0, 0.0);
                        }
                    }
                    this.teleportTo(hurt.getX(), hurt.getY(), hurt.getZ());
                    //瞬移后粒子
                    if (this.level() instanceof ServerLevel serverLevel) {
                        for (int i = 0; i < 24; ++i) {
                            serverLevel.sendParticles(ParticleTypes.DAMAGE_INDICATOR, this.getRandomX(0.5f), this.getRandomY(), this.getRandomZ(0.5f), 0, 0, 0.0, 0, 0.0);
                        }
                    }
                    if (this.level() instanceof ServerLevel serverLevel) {
                        if (!this.isInvisible()) {
                            serverLevel.sendParticles(JVPillageParticleTypes.OMINOUS_SELECTION_DISPLAY.get(), this.getX(), this.getBoundingBox().maxY + 0.5, this.getZ(), 0, 0.0, 0.0, 0.0, 0);
                        }
                    }
                    if (!this.isSilent() && this.random.nextFloat() < 0.5f) {
                        this.level().playSound(null, this.getX(), this.getY(), this.getZ(), JVPillageSoundEvents.NECROMANCY_WARLOCK_SELECTION, this.getSoundSource(), 5.0f, 0.8f + this.random.nextFloat() * 0.4f);
                    }
                    hurt.hurt(damageSource, amount * 0.8f);
                    return false;
                }
            }
        }
        if (EntityAndItemFind.MagicResistance(damageSource))
            return super.hurt(damageSource, amount/5);
        if (damageSource.is(DamageTypeTags.IS_FIRE))
            return super.hurt(damageSource, amount);
        if (damageSource.is(DamageTypeTags.IS_EXPLOSION))
            return super.hurt(damageSource, amount);
        return super.hurt(damageSource, amount/4);
    }

    @Override
    public boolean canBeAffected(MobEffectInstance mobEffectInstance) {
        if (mobEffectInstance.getEffect() == JVPillageMobEffects.UNCLEAN_BODY.get()) {
            return false;
        }
        if (mobEffectInstance.getEffect() == MobEffects.CONFUSION) {
            return false;
        }
        return super.canBeAffected(mobEffectInstance);
    }

    @Override
    public void tickDeath() {
        if(deathTime <= 0){
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

    @Override
    public boolean isFactionWith(Entity entity) {
        return entity instanceof LivingEntity livingEntity && OtherEntityFactionFind.isFactionPurpleSandSisterhood(livingEntity);
    }

    @Override
    public String getFactionTypeName() {
        return "purple_sand_sisterhood";
    }
}

