package com.jerotes.jvpillage.item;

import com.jerotes.jvpillage.entity.Boss.OminousBannerProjectionEntity;
import com.jerotes.jvpillage.init.JVPillageEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.ForgeSpawnEggItem;

import java.util.Objects;

public class GloryBannerProjectSpawnEgg extends ForgeSpawnEggItem {
    public GloryBannerProjectSpawnEgg() {
        super(JVPillageEntityType.OMINOUS_BANNER_PROJECTION, 0xffffff, 0xffffff, new Properties().rarity(Rarity.EPIC));
    }
    public InteractionResult useOn(UseOnContext p_43223_) {
        Level level = p_43223_.getLevel();
        if (!(level instanceof ServerLevel)) {
            return InteractionResult.SUCCESS;
        } else {
            ItemStack itemstack = p_43223_.getItemInHand();
            BlockPos blockpos = p_43223_.getClickedPos();
            Direction direction = p_43223_.getClickedFace();
            BlockState blockstate = level.getBlockState(blockpos);
            if (blockstate.is(Blocks.SPAWNER)) {
                BlockEntity blockentity = level.getBlockEntity(blockpos);
                if (blockentity instanceof SpawnerBlockEntity) {
                    SpawnerBlockEntity spawnerblockentity = (SpawnerBlockEntity)blockentity;
                    EntityType<?> entitytype1 = this.getType(itemstack.getTag());
                    spawnerblockentity.setEntityId(entitytype1, level.getRandom());
                    blockentity.setChanged();
                    level.sendBlockUpdated(blockpos, blockstate, blockstate, 3);
                    level.gameEvent(p_43223_.getPlayer(), GameEvent.BLOCK_CHANGE, blockpos);
                    itemstack.shrink(1);
                    return InteractionResult.CONSUME;
                }
            }

            BlockPos blockpos1;
            if (blockstate.getCollisionShape(level, blockpos).isEmpty()) {
                blockpos1 = blockpos;
            } else {
                blockpos1 = blockpos.relative(direction);
            }


            EntityType<?> entitytype = this.getType(itemstack.getTag());
            Entity mob = entitytype.spawn((ServerLevel)level, null, p_43223_.getPlayer(), blockpos1,
                    MobSpawnType.SPAWN_EGG, true, !Objects.equals(blockpos, blockpos1) && direction == Direction.UP);
            if (mob instanceof OminousBannerProjectionEntity ominousBannerProjectionEntity) {
                if (itemstack.getItem() instanceof GloryBannerProjectSpawnEgg) {
                    ominousBannerProjectionEntity.setChampion(true);
                    ominousBannerProjectionEntity.setLegend(true);
                }
                itemstack.shrink(1);
                level.gameEvent(p_43223_.getPlayer(), GameEvent.ENTITY_PLACE, blockpos);
            }
        }
        return InteractionResult.CONSUME;
}
}
