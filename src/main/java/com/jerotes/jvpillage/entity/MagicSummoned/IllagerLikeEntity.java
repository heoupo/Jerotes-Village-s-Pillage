package com.jerotes.jvpillage.entity.MagicSummoned;

import com.jerotes.jerotes.entity.Interface.InventoryEntity;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.VisibleForDebug;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.InventoryCarrier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;
import net.minecraftforge.items.wrapper.EntityArmorInvWrapper;
import net.minecraftforge.items.wrapper.EntityHandsInvWrapper;
import net.minecraftforge.items.wrapper.InvWrapper;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public abstract class IllagerLikeEntity extends MagicSummonedEntity implements  InventoryCarrier, InventoryEntity {
    protected static final EntityDataAccessor<Integer> ANIM_STATE = SynchedEntityData.defineId(IllagerLikeEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> ANIM_TICK = SynchedEntityData.defineId(IllagerLikeEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> SPELL_TICK = SynchedEntityData.defineId(IllagerLikeEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> SPELL_ONE_TICK = SynchedEntityData.defineId(IllagerLikeEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> SPELL_TWO_TICK = SynchedEntityData.defineId(IllagerLikeEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> SPELL_THREE_TICK = SynchedEntityData.defineId(IllagerLikeEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> CAN_CHANGE_INVENTORY = SynchedEntityData.defineId(IllagerLikeEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> CAN_CHANGE_MELEE_OR_RANGE = SynchedEntityData.defineId(IllagerLikeEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Byte> DATA_SPELL_CASTING_ID = SynchedEntityData.defineId(IllagerLikeEntity.class, EntityDataSerializers.BYTE);;
    public final SimpleContainer inventory = new SimpleContainer(inventoryCount());
    private LazyOptional<?> itemHandler = null;

    public IllagerLikeEntity(EntityType<? extends IllagerLikeEntity> entityType, Level level) {
        super(entityType, level);
        this.entityData.define(DATA_SPELL_CASTING_ID, (byte)0);

        this.setPathfindingMalus(BlockPathTypes.DOOR_WOOD_CLOSED, 0.0f);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0f);
        this.itemHandler = LazyOptional.of(this::createCombinedHandler);
    }
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
    public List<AnimationState> getAllAnimations(){
        List<AnimationState> list = new ArrayList<>();
        return list;
    }
    public int getAnimationState(String animation) {
        return 0;
    }
    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);


        compoundTag.putBoolean("IsCanChangeInventory", this.isCanChangeInventory());
        compoundTag.putBoolean("IsCanChangeMeleeOrRange", this.isCanChangeMeleeOrRange());
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
        this.setAnimTick(compoundTag.getInt("AnimTick"));
        this.setSpellTick(compoundTag.getInt("SpellTick"));
        this.setSpellOneTick(compoundTag.getInt("SpellOneTick"));
        this.setSpellTwoTick(compoundTag.getInt("SpellTwoTick"));
        this.setSpellThreeTick(compoundTag.getInt("SpellThreeTick"));
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();

        this.getEntityData().define(ANIM_STATE, 0);
        this.getEntityData().define(ANIM_TICK, 0);
        this.getEntityData().define(SPELL_TICK, 0);
        this.getEntityData().define(SPELL_ONE_TICK, 0);
        this.getEntityData().define(SPELL_TWO_TICK, 0);
        this.getEntityData().define(SPELL_THREE_TICK, 0);
        this.getEntityData().define(CAN_CHANGE_INVENTORY, false);
        this.getEntityData().define(CAN_CHANGE_MELEE_OR_RANGE, false);
    }
}
