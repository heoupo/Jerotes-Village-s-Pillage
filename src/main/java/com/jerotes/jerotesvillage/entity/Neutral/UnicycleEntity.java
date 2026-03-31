package com.jerotes.jerotesvillage.entity.Neutral;

import com.jerotes.jerotes.entity.Interface.JerotesEntity;
import com.jerotes.jerotes.init.JerotesMobEffects;
import com.jerotes.jerotesvillage.init.JerotesVillageSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

public class UnicycleEntity extends PathfinderMob implements JerotesEntity, Saddleable, PlayerRideableJumping {
	private static final EntityDataAccessor<Integer> RUSH_TICK = SynchedEntityData.defineId(UnicycleEntity.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> RUSH_STRENGTH = SynchedEntityData.defineId(UnicycleEntity.class, EntityDataSerializers.INT);

	public UnicycleEntity(EntityType<? extends UnicycleEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(1.6f);
		xpReward = 0;
		setPersistenceRequired();
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.25);
		builder = builder.add(Attributes.MAX_HEALTH, 5);
		builder = builder.add(Attributes.ARMOR, 10);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.7);
		return builder;
	}

	@Override
	public SoundEvent getDeathSound() {
		return JerotesVillageSoundEvents.UNICYCLE_DEATH;
	}
	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return JerotesVillageSoundEvents.UNICYCLE_DEATH;
	}
	@Override
	protected Vec3 getRiddenInput(Player player, Vec3 vec3) {
		return new Vec3(0.0, 0.0, 1.0);
	}
	@Override
	public boolean isSaddleable() {
		return this.isAlive();
	}
	@Override
	public void equipSaddle(@Nullable SoundSource p_21748_) {
	}
	@Override
	public boolean isSaddled() {
		return true;
	}
	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}
	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(JerotesVillageSoundEvents.UNICYCLE_WALK, 0.15f, 1);
	}
	@Override
	public boolean canDrownInFluidType(FluidType type) {
		if (type == ForgeMod.WATER_TYPE.get())
			return false;
		return super.canDrownInFluidType(type);
	}
	//
	protected void positionRider(Entity entity, MoveFunction moveFunction) {
		Vec3 vec3 = this.getPassengerRidingPosition(entity);
		moveFunction.accept(entity, vec3.x, vec3.y + getMyRidingOffset(this), vec3.z);
	}
	public float getMyRidingOffset(Entity entity) {
		return this.ridingOffset(entity) * this.getScale();
	}
	protected float ridingOffset(Entity entity) {
		return -0.6F;
	}
	public Vec3 getPassengerRidingPosition(Entity entity) {
		return (new Vec3(this.getPassengerAttachmentPoint(entity, this.getDimensions(this.getPose()), this.getScale()).rotateY(-this.yBodyRot * ((float)Math.PI / 180F)))).add(this.position());
	}
	protected Vector3f getPassengerAttachmentPoint(Entity entity, EntityDimensions entityDimensions, float f) {
		return new Vector3f(0.0F, entityDimensions.height, 0.0F);
	}
	//
	@Override
	public void travel(Vec3 dir) {
		Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
		if (this.isVehicle() && this.getFirstPassenger() instanceof Player) {
			this.setYRot(entity.getYRot());
			this.yRotO = this.getYRot();
			this.setXRot(entity.getXRot() * 0.5F);
			this.setRot(this.getYRot(), this.getXRot());
			this.yBodyRot = entity.getYRot();
			this.yHeadRot = entity.getYRot();
			if (entity instanceof LivingEntity passenger) {
				this.setSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));
				float forward = passenger.zza;
				float strafe = 0;
				super.travel(new Vec3(strafe, 0, forward));
			}
			double d1 = this.getX() - this.xo;
			double d0 = this.getZ() - this.zo;
			float f1 = (float) Math.sqrt(d1 * d1 + d0 * d0) * 4;
			if (f1 > 1.0F)
				f1 = 1.0F;
			this.walkAnimation.setSpeed(this.walkAnimation.speed() + (f1 - this.walkAnimation.speed()) * 0.4F);
			this.walkAnimation.position(this.walkAnimation.position() + this.walkAnimation.speed());
			this.calculateEntityAnimation(true);
			return;
		}
		super.travel(dir);
	}

	public void setRushTick(int n){
		this.getEntityData().set(RUSH_TICK, n);
	}
	public int getRushTick(){
		return this.getEntityData().get(RUSH_TICK);
	}
	public void setRushStrength(int n){
		this.getEntityData().set(RUSH_STRENGTH, n);
	}
	public int getRushStrength(){
		return this.getEntityData().get(RUSH_STRENGTH);
	}
	@Override
	public void addAdditionalSaveData(CompoundTag compoundTag) {
		super.addAdditionalSaveData(compoundTag);
		compoundTag.putInt("RushTick", this.getRushTick());
		compoundTag.putInt("RushStrength", this.getRushStrength());
	}
	@Override
	public void readAdditionalSaveData(CompoundTag compoundTag) {
		super.readAdditionalSaveData(compoundTag);
		this.setRushTick(compoundTag.getInt("RushTick"));
		this.setRushStrength(compoundTag.getInt("RushStrength"));
	}
	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.getEntityData().define(RUSH_TICK, 0);
		this.getEntityData().define(RUSH_STRENGTH, 0);
	}

	@Override
	public boolean isInvulnerableTo(DamageSource damageSource) {
		if (damageSource.is(DamageTypes.CACTUS)
				|| damageSource.is(DamageTypes.SWEET_BERRY_BUSH)
				|| damageSource.is(DamageTypes.THORNS)
				|| damageSource.is(DamageTypeTags.IS_FALL)
				|| damageSource.is(DamageTypeTags.IS_DROWNING)
				|| damageSource.is(DamageTypes.DRY_OUT)
				|| damageSource.is(DamageTypes.IN_WALL)
				|| damageSource.is(DamageTypes.WITHER)
				|| damageSource.is(DamageTypes.WITHER_SKULL))
			return true;
		return super.isInvulnerableTo(damageSource);
	}

	@Override
	public boolean canBeAffected(MobEffectInstance mobEffectInstance) {
		if (mobEffectInstance.getEffect() == MobEffects.POISON) {
			return false;
		}
		if (mobEffectInstance.getEffect() == JerotesMobEffects.DEADLY_POISON.get()) {
			return false;
		}
		return super.canBeAffected(mobEffectInstance);
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.random.nextInt(900) == 1 && this.deathTime == 0) {
			this.heal(1.0f);
		}
		if (this.getControllingPassenger() != null && this.getRushTick() == 60) {
			this.RushAttack(getRushStrength() / 300f);
			this.setRushStrength(0);
		}
		if (!this.level().isClientSide()) {
			this.setRushTick(Math.max(0, this.getRushTick() - 1));
		}
	}

	@Override
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		if (!player.isShiftKeyDown()) {
			if (!this.level().isClientSide) {
				player.startRiding(this);
			}
			return InteractionResult.SUCCESS;
		}
		return super.mobInteract(player, hand);
	}
	@Nullable
	@Override
	public LivingEntity getControllingPassenger() {
		Entity entity;
		if (this.isSaddled() && (entity = this.getFirstPassenger()) instanceof Player player) {
			return player;
		}
		return super.getControllingPassenger();
	}
	@Override
	public void onPlayerJump(int i) {
	}
	@Override
	public boolean canJump() {
		return this.onGround() && this.getRushTick() <= 0;
	}
	@Override
	public int getJumpCooldown() {
		return this.getRushTick();
	}
	@Override
	public void handleStartJump(int i) {
		if (this.getControllingPassenger() != null) {
			if (!this.level().isClientSide()) {
				this.setRushTick(60);
				this.setRushStrength(i);
			}
		}
	}
	@Override
	public void handleStopJump() {
	}
	public boolean RushAttack(float f7) {
		this.setOnGround(false);
		this.push(0, 0.5f, 0);
		return true;
	}
}