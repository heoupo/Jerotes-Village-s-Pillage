package com.jerotes.jvpillage.entity.Other;

import com.jerotes.jvpillage.block.DamagedRuins.MerorProjectionTable;
import com.jerotes.jvpillage.init.JVPillageEntityType;
import com.jerotes.jvpillage.init.JVPillageSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class BossShowEntity extends LivingEntity {
	private final NonNullList<ItemStack> handItems = NonNullList.withSize(2, ItemStack.EMPTY);
	private final NonNullList<ItemStack> armorItems = NonNullList.withSize(4, ItemStack.EMPTY);
	public BossShowEntity(EntityType<? extends BossShowEntity> entityType, Level level) {
		super(entityType, level);
		this.setMaxUpStep(0.0f);
	}

	@Override
	public void tick() {
		super.tick();
		BlockPos base = new BlockPos(mainx, mainy, mainz);
		if (this.start < 40) {
			this.start += 1;
		}
		if (!this.level().isClientSide) {
			if (this.start >= 40) {
				if (!(this.level().getBlockState(base).getBlock() instanceof MerorProjectionTable) || this.distanceToSqr(base.getCenter()) > 2) {
					this.discard();
				}
			}
		}
		List<BossShowEntity> listShow = this.level().getEntitiesOfClass(BossShowEntity.class, this.getBoundingBox());
		if (listShow.size() > 1) {
			this.discard();
		}
	}

	@Override
	public InteractionResult interactAt(Player player, Vec3 vec3, InteractionHand interactionHand) {
		SoundEvent soundEvent = SoundEvents.GENERIC_HURT;
		//灾厄旗帜投影
		if (this.getType() == JVPillageEntityType.BOSS_SHOW_ENTITY_OMINOUS_BANNER_PROJECTION.get())
			soundEvent = JVPillageSoundEvents.OMINOUS_BANNER_PROJECTION_AMBIENT;
		//紫沙鬼婆
		if (this.getType() == JVPillageEntityType.BOSS_SHOW_ENTITY_PURPLE_SAND_HAG.get())
			soundEvent = JVPillageSoundEvents.PURPLE_SAND_HAG_AMBIENT;
		this.playSound(soundEvent, 2.0f, 1.0f);
		return super.interactAt(player, vec3, interactionHand);
	}


	@Override
	public HumanoidArm getMainArm() {
		return HumanoidArm.RIGHT;
	}

	@Override
	public Iterable<ItemStack> getHandSlots() {
		return this.handItems;
	}

	@Override
	public Iterable<ItemStack> getArmorSlots() {
		return this.armorItems;
	}

	@Override
	public ItemStack getItemBySlot(EquipmentSlot equipmentSlot) {
		switch (equipmentSlot.getType()) {
			case HAND: {
				return this.handItems.get(equipmentSlot.getIndex());
			}
			case ARMOR: {
				return this.armorItems.get(equipmentSlot.getIndex());
			}
		}
		return ItemStack.EMPTY;
	}

	@Override
	public void setItemSlot(EquipmentSlot equipmentSlot, ItemStack itemStack) {
		this.verifyEquippedItem(itemStack);
		switch (equipmentSlot.getType()) {
			case HAND: {
				this.onEquipItem(equipmentSlot, this.handItems.set(equipmentSlot.getIndex(), itemStack), itemStack);
				break;
			}
			case ARMOR: {
				this.onEquipItem(equipmentSlot, this.armorItems.set(equipmentSlot.getIndex(), itemStack), itemStack);
			}
		}
	}

	private int start;
	public int mainx;
	public int mainy;
	public int mainz;
	public float facing;

	@Override
	public void addAdditionalSaveData(CompoundTag compoundTag) {
		super.addAdditionalSaveData(compoundTag);
		compoundTag.putInt("Start", this.start);
		compoundTag.putInt("MainX", this.mainx);
		compoundTag.putInt("MainY", this.mainy);
		compoundTag.putInt("MainZ", this.mainz);
		compoundTag.putFloat("Facing", this.facing);
	}
	@Override
	public void readAdditionalSaveData(CompoundTag compoundTag) {
		super.readAdditionalSaveData(compoundTag);
		this.start = compoundTag.getInt("Start");
		this.mainx = compoundTag.getInt("MainX");
		this.mainy = compoundTag.getInt("MainY");
		this.mainz = compoundTag.getInt("MainZ");
		this.facing = compoundTag.getFloat("Facing");
	}
	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	protected void doPush(Entity entity) {
	}

	@Override
	protected void pushEntities() {
	}

	@Override
	public boolean hurt(DamageSource damageSource, float f) {
		if (isInvulnerableTo(damageSource)) {
			return super.hurt(damageSource, f);
		}
		return false;
	}

	@Override
	public boolean isBaby() {
		return false;
	}

	@Override
	public void setDeltaMovement(double d, double d2, double d3) {
		if (this.start >= 40) {
			super.setDeltaMovement(0, 0, 0);
		}
		super.setDeltaMovement(d, d2, d3);
	}
	@Override
	public boolean canFreeze() {
		return false;
	}
	@Override
	public boolean isFreezing() {
		return false;
	}

	@Override
	public boolean isOnFire() {
		return false;
	}


	@Override
	public void setYBodyRot(float f) {
		this.yBodyRotO = this.yRotO = f;
		this.yHeadRotO = this.yHeadRot = f;
	}

	@Override
	public void setYHeadRot(float f) {
		this.yBodyRotO = this.yRotO = f;
		this.yHeadRotO = this.yHeadRot = f;
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.clearFire();
		//清除冻结
		if (this.getTicksFrozen() > 0) {
			this.setTicksFrozen(0);
		}
	}

	@Override
	public void kill() {
		this.remove(Entity.RemovalReason.KILLED);
		this.gameEvent(GameEvent.ENTITY_DIE);
	}

	@Override
	public boolean canBeSeenByAnyone() {
		return true;
	}
	@Override
	public boolean canBeSeenAsEnemy() {
		return false;
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
		return builder;
	}
}