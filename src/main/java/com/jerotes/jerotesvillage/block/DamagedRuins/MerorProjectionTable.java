package com.jerotes.jerotesvillage.block.DamagedRuins;

import com.jerotes.jerotesvillage.init.JerotesVillageBlockEntityType;
import com.jerotes.jerotesvillage.init.JerotesVillageItems;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MerorProjectionTable extends Block implements EntityBlock {
	protected static final VoxelShape SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 1.0, 15.0);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final IntegerProperty BOSS_MAIN = BlockStateProperties.AGE_25;
	public static final IntegerProperty BOSS_OTHER = BlockStateProperties.LAYERS;
	public MerorProjectionTable() {
		super(Properties.of().sound(SoundType.METAL).strength(65f, 1800f).pushReaction(PushReaction.NORMAL)
				.hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(BOSS_MAIN,BOSS_OTHER,FACING);
	}

	@Override
	public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		return SHAPE;
	}

	@Override
	public void onPlace(BlockState blockState, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockState, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 30);
	}


	@javax.annotation.Nullable
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
		return MerorProjectionTableEntity.createTableTicker(level, blockEntityType, JerotesVillageBlockEntityType.MEROR_PROJECTION_TABLE.get());
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	public static int getBossMainType(BlockState blockState) {
		return blockState.getValue(BOSS_MAIN);
	}
	public static int getBossOtherType(BlockState blockState) {
		return blockState.getValue(BOSS_OTHER);
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 5;
	}

	@Override
	public InteractionResult use(BlockState blockState, Level level, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockState, level, pos, entity, hand, hit);
		ItemStack itemstack = entity.getItemInHand(hand);
		if (level.isClientSide) {
			return InteractionResult.SUCCESS;
		}
		change(level, blockState, pos, entity, itemstack);
		return InteractionResult.CONSUME;
	}

	public static void change(Level level, BlockState blockState, BlockPos blockPos, LivingEntity livingEntity, ItemStack itemStack) {
		if (getBossMainType(blockState) != 0){
			if (livingEntity != null && livingEntity.isShiftKeyDown() || itemStack.is(JerotesVillageItems.MEROR_PROJECTION_TABLE.get())){
				dropItem(level, blockPos, blockState);
				level.setBlock(blockPos, blockState.setValue(BOSS_MAIN, 0).setValue(BOSS_OTHER, 1), 2);
			}
		}
		else{
			int boss_main = getBossMainType(blockState);
			int boss_other = getBossOtherType(blockState);
			//紫沙鬼婆
			if (itemStack.getItem() == JerotesVillageItems.PURPLE_SAND_HAG_HAIR.get()){
				boss_main = 2;
				boss_other = 1;
			}
			//灾厄旗帜投影
			if (itemStack.getItem() == JerotesVillageItems.OMINOUS_BANNER_PROJECTION_EMERALD_FRAGMENT.get()){
				boss_main = 3;
				boss_other = 2;
			}
			if (boss_main != getBossMainType(blockState) || boss_other != getBossOtherType(blockState)) {
				level.setBlock(blockPos, blockState.setValue(BOSS_MAIN, boss_main).setValue(BOSS_OTHER, boss_other), 2);
				if (livingEntity instanceof Player player) {
					if (!player.getAbilities().instabuild)
						itemStack.shrink(1);
				}
				else {
					itemStack.shrink(1);
				}
			}
		}
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new MerorProjectionTableEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void playerDestroy(Level level, Player player, BlockPos pos, BlockState blockState, @Nullable BlockEntity blockEntity, ItemStack itemStack) {
		super.playerDestroy(level, player, pos, blockState, blockEntity, itemStack);
		dropItem(level, pos, blockState);
	}

	static void dropItem(Level level, BlockPos pos, BlockState blockState) {
		ItemEntity drop = new ItemEntity(level, pos.getX()+0.5, pos.getY()+0.5, pos.getZ()+0.5, new ItemStack(Items.AIR));
		if (getBossOtherType(blockState) == 1) {
			if (getBossMainType(blockState) == 2) {
				drop = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(JerotesVillageItems.PURPLE_SAND_HAG_HAIR.get()));
			}
		}
		else if (getBossOtherType(blockState) == 2) {
			if (getBossMainType(blockState) == 3) {
				drop = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(JerotesVillageItems.OMINOUS_BANNER_PROJECTION_EMERALD_FRAGMENT.get()));
			}
		}
		drop.setPickUpDelay(10);
		drop.setUnlimitedLifetime();
		level.addFreshEntity(drop);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof MerorProjectionTableEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof MerorProjectionTableEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}

	@Override
	public void appendHoverText(ItemStack itemStack, @javax.annotation.Nullable BlockGetter blockGetter, List<Component> list, TooltipFlag tooltipFlag) {
		list.add(this.getDisplayName().withStyle(ChatFormatting.GRAY));
		super.appendHoverText(itemStack, blockGetter, list, tooltipFlag);
	}

	public MutableComponent getDisplayName() {
		return Component.translatable(this.getDescriptionId() + ".desc");
	}

}