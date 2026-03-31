package com.jerotes.jvpillage.block.DamagedRuins;

import com.jerotes.jvpillage.entity.Other.BossShowEntity;
import com.jerotes.jvpillage.init.JVPillageBlockEntityType;
import com.jerotes.jvpillage.init.JVPillageEntityType;
import com.jerotes.jvpillage.init.JVPillageSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.IntStream;

public class MerorProjectionTableEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {
	private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(9, ItemStack.EMPTY);
	private final LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.values());

	public MerorProjectionTableEntity(BlockPos position, BlockState state) {
		super(JVPillageBlockEntityType.MEROR_PROJECTION_TABLE.get(), position, state);
	}

	public static void summonBoss(BlockPos pos, int bossMain, int bossOther, float facing, ServerLevel serverLevel) {
		if (bossMain == 0) {
			return;
		}
		BossShowEntity shows = new BossShowEntity(JVPillageEntityType.BOSS_SHOW_ENTITY_PURPLE_SAND_HAG.get(), serverLevel);
		if (bossOther == 1) {
			if (bossMain == 2) {
				shows = new BossShowEntity(JVPillageEntityType.BOSS_SHOW_ENTITY_PURPLE_SAND_HAG.get(), serverLevel);
			}
		}
		else if (bossOther == 2) {
			if (bossMain == 3) {
				shows = new BossShowEntity(JVPillageEntityType.BOSS_SHOW_ENTITY_OMINOUS_BANNER_PROJECTION.get(), serverLevel);
			}
		}
		shows.mainx = pos.getX();
		shows.mainy = pos.getY();
		shows.mainz = pos.getZ();
		shows.facing = facing;
		shows.setPosRaw(shows.mainx + 0.5, shows.mainy + 1/16f + 0.05f, shows.mainz + 0.5);
		shows.setYRot(facing);
		shows.setYHeadRot(facing);
		shows.setYBodyRot(facing);
		serverLevel.addFreshEntityWithPassengers(shows);
		serverLevel.playSound(null, shows.getX(), shows.getY(), shows.getZ(), JVPillageSoundEvents.MEROR_TOOL_USE, SoundSource.BLOCKS, 0.75f, 0.8f);

	}

	@Nullable
	protected static <T extends BlockEntity> BlockEntityTicker<T> createTableTicker(Level level, BlockEntityType<T> blockEntityType, BlockEntityType<? extends MerorProjectionTableEntity> blockEntityType2) {
		return level.isClientSide ? null : createTickerHelper(blockEntityType, blockEntityType2, (arg_0, arg_1, arg_2, arg_3) -> MerorProjectionTableEntity.serverTick(arg_0, arg_1, arg_2, arg_3));
	}

	@Nullable
	protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> blockEntityType, BlockEntityType<E> blockEntityType2, BlockEntityTicker<? super E> blockEntityTicker) {
		return blockEntityType2 == blockEntityType ? (BlockEntityTicker<A>)blockEntityTicker : null;
	}

	public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, MerorProjectionTableEntity merorProjectionTable) {
		if (show > 0) {
			show -= 1;
		}
		else {
			show = 10;
		}
		if (level instanceof ServerLevel serverLevel) {
			List<BossShowEntity> listShow = level.getEntitiesOfClass(BossShowEntity.class, AABB.ofSize(new Vec3(blockPos.getX()+0.5, blockPos.getY()+1, blockPos.getZ()+0.5), 1, 1, 1));
			if (listShow.isEmpty() && MerorProjectionTable.getBossMainType(blockState) != 0) {
				if (show <= 0) {
					float facing = 0f;
					if (blockState.getValue(MerorProjectionTable.FACING) == Direction.EAST) {
						facing = 270f;
					} else if (blockState.getValue(MerorProjectionTable.FACING) == Direction.NORTH) {
						facing = 180f;
					} else if (blockState.getValue(MerorProjectionTable.FACING) == Direction.WEST) {
						facing = 90f;
					} else if (blockState.getValue(MerorProjectionTable.FACING) == Direction.SOUTH) {
						facing = 0f;
					}
					summonBoss(blockPos, MerorProjectionTable.getBossMainType(blockState), MerorProjectionTable.getBossOtherType(blockState), facing, serverLevel);
				}
			} else if (!listShow.isEmpty() && MerorProjectionTable.getBossMainType(blockState) == 0) {
				for (BossShowEntity bossShow : listShow) {
					bossShow.discard();
				}
			}
			if (listShow.size() > 1) {
				for (BossShowEntity bossShow : listShow) {
					bossShow.discard();
				}
			}
		}
	}

	public static int show = 0;
	@Override
	public void load(CompoundTag compound) {
		super.load(compound);
		if (!this.tryLoadLootTable(compound))
			this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ContainerHelper.loadAllItems(compound, this.stacks);
		show = compound.getInt("Show");
		show = compound.getInt("ShowEntity");
	}
	@Override
	public void saveAdditional(CompoundTag compound) {
		super.saveAdditional(compound);
		if (!this.trySaveLootTable(compound)) {
			ContainerHelper.saveAllItems(compound, this.stacks);
		}
		compound.putInt("Show", show);
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public CompoundTag getUpdateTag() {
		return this.saveWithFullMetadata();
	}

	@Override
	public int getContainerSize() {
		return stacks.size();
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack itemstack : this.stacks)
			if (!itemstack.isEmpty())
				return false;
		return true;
	}

	@Override
	public Component getDefaultName() {
		return Component.translatable("block.jvpillage.meror_projection_table");
	}

	@Override
	public int getMaxStackSize() {
		return 64;
	}

	@Override
	public AbstractContainerMenu createMenu(int id, Inventory inventory) {
		return ChestMenu.threeRows(id, inventory);
	}

	@Override
	public Component getDisplayName() {
		return Component.literal("meror_projection_table");
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		return this.stacks;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> stacks) {
		this.stacks = stacks;
	}

	@Override
	public boolean canPlaceItem(int index, ItemStack stack) {
		return false;
	}

	@Override
	public int[] getSlotsForFace(Direction side) {
		return IntStream.range(0, this.getContainerSize()).toArray();
	}

	@Override
	public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction) {
		return this.canPlaceItem(index, stack);
	}

	@Override
	public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
		return true;
	}

	@Override
	public void setRemoved() {
		show = 0;
		super.setRemoved();
		for (LazyOptional<? extends IItemHandler> handler : handlers)
			handler.invalidate();
	}
}
