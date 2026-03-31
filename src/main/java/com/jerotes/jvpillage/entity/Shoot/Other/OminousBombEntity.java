package com.jerotes.jvpillage.entity.Shoot.Other;

import com.jerotes.jvpillage.entity.Shoot.Arrow.OminousBombFragmentEntity;
import com.jerotes.jvpillage.init.JVPillageEntityType;
import com.jerotes.jvpillage.init.JVPillageItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class OminousBombEntity extends ThrowableItemProjectile {
    public OminousBombEntity(EntityType<? extends OminousBombEntity> entityType, Level level) {
        super(entityType, level);
    }

    public OminousBombEntity(Level level, LivingEntity livingEntity) {
        super(JVPillageEntityType.OMINOUS_BOMB.get(), livingEntity, level);
    }

    public OminousBombEntity(Level level, double d, double d2, double d3) {
        super(JVPillageEntityType.OMINOUS_BOMB.get(), d, d2, d3, level);
    }

    public int boom = 0;
    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.boom = compoundTag.getInt("Boom");
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("Boom", this.boom);
    }

    @Override
    public void handleEntityEvent(byte by) {
        if (by == 3) {
            ParticleOptions particleOptions = this.getParticle();
            for (int i = 0; i < 8; ++i) {
                this.level().addParticle(particleOptions, this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5) * 0.08, ((double)this.random.nextFloat() - 0.5) * 0.08, ((double)this.random.nextFloat() - 0.5) * 0.08);
            }
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        super.onHitEntity(hitResult);
        if (!this.level().isClientSide) {
            this.boom += 30;
            this.setDeltaMovement(0d, 0d, 0d);
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult hitResult) {
        super.onHitBlock(hitResult);
        if (!this.level().isClientSide) {
            this.boom += 30;
            this.setDeltaMovement(0d, 0d, 0d);
            this.setNoGravity(true);
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.boom >= 40) {
            if (!this.level().isClientSide) {
                this.level().broadcastEntityEvent(this, (byte)3);
                this.level().explode(this, this.getX(), this.getY(), this.getZ(), 2.5f, Level.ExplosionInteraction.NONE);
                for (int i = 0; i < 12; ++i) {
                    OminousBombFragmentEntity abstractArrow = new OminousBombFragmentEntity(JVPillageEntityType.OMINOUS_BOMB_FRAGMENT.get(), this.level());
                    abstractArrow.setPos(this.getX(), this.getY(), this.getZ());
                    abstractArrow.setDeltaMovement(abstractArrow.getDeltaMovement().add((this.random.nextFloat() * 2 - 1)/4,0.75f, (this.random.nextFloat() * 2 - 1)/4));
                    if (this.getOwner() != null) {
                        abstractArrow.setOwner(this.getOwner());
                    }
                    this.level().addFreshEntity(abstractArrow);
                }
                this.discard();
            }
        }
        else {
            this.boom += 1;
        }
    }

    @Override
    protected Item getDefaultItem() {
        return JVPillageItems.PURPLE_SAND_ALCHEMY_BOMB.get();
    }

    private ParticleOptions getParticle() {
        ItemStack itemStack = this.getItemRaw();
        return itemStack.isEmpty() ? ParticleTypes.FLAME : new ItemParticleOption(ParticleTypes.ITEM, itemStack);
    }
}
