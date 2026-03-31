package com.jerotes.jvpillage.entity.Shoot.Magic.MagicThrow;

import com.jerotes.jerotes.entity.Shoot.Magic.MagicAboutThrowEntity;
import com.jerotes.jerotes.init.JerotesDamageTypes;
import com.jerotes.jerotes.util.AttackFind;
import com.jerotes.jvpillage.init.JVPillageEntityType;
import com.jerotes.jvpillage.init.JVPillageItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class ElasticIceRockEntity extends MagicAboutThrowEntity {
    public ElasticIceRockEntity(EntityType<? extends ElasticIceRockEntity> entityType, Level level) {
        super(entityType, level);
    }

    public ElasticIceRockEntity(int spellLevelDamage, int spellLevelFreezeTime, Level level, LivingEntity livingEntity) {
        super(JVPillageEntityType.ELASTIC_ICE_ROCK.get(), livingEntity, level);
        this.spellLevelDamage = spellLevelDamage;
        this.spellLevelFreezeTime = spellLevelFreezeTime;
    }

    public ElasticIceRockEntity(int spellLevelDamage, int spellLevelFreezeTime, Level level, double d, double d2, double d3) {
        super(JVPillageEntityType.ELASTIC_ICE_ROCK.get(), d, d2, d3, level);
        this.spellLevelDamage = spellLevelDamage;
        this.spellLevelFreezeTime = spellLevelFreezeTime;
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        if (this.level().isClientSide) {
            return;
        }
        Entity entity = entityHitResult.getEntity();

        if (entity instanceof LivingEntity livingEntity) {
            DamageSource damageSource = AttackFind.findDamageType(this, JerotesDamageTypes.FREEZE_MAGIC, this, this.getOwner());
            livingEntity.hurt(damageSource, 20 + this.spellLevelDamage * 10);
            if (livingEntity.getTicksFrozen() < 140 + 20 * spellLevelFreezeTime) {
                livingEntity.setTicksFrozen(140 + 20 * spellLevelFreezeTime);
            }
            this.playSound(SoundEvents.STONE_BREAK, 1.0f, 1.0f);
        }
    }


    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);
            BlockPos blockPos = this.getOnPos();
            if (hitResult instanceof BlockHitResult blockHit) {
                Direction face = blockHit.getDirection();
                Vec3 motion = this.getDeltaMovement();
                double damping = 0.85;
                double yDamping = 0.75;

                switch (face) {
                    case UP, DOWN:
                        this.setDeltaMovement(motion.x, -motion.y * yDamping, motion.z);
                        break;
                    case EAST, WEST:
                        this.setDeltaMovement(-motion.x * damping, motion.y, motion.z);
                        break;
                    case NORTH, SOUTH:
                        this.setDeltaMovement(motion.x, motion.y, -motion.z * damping);
                        break;
                    default:
                        this.setDeltaMovement(motion.multiply(0.85, -0.75, 0.85));
                }
            } else {
                this.setDeltaMovement(this.getDeltaMovement().multiply(0.85, -0.75, 0.85));
            }
        }
    }


    @Override
    public int getMaxLife() {
        return 240;
    }

    @Override
    protected Item getDefaultItem() {
        return JVPillageItems.ICE_ROCK.get();
    }

    @Override
    public boolean canCollideWith(Entity entity) {
        return this.isAlive();
    }

    @Override
    public boolean canBeCollidedWith() {
        return this.isAlive();
    }

    @Override
    protected float getGravity() {
        return 0.03F;
    }
}
