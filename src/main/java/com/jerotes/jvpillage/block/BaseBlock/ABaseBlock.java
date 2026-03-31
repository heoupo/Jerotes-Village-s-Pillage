package com.jerotes.jvpillage.block.BaseBlock;

import com.jerotes.jvpillage.init.JVPillageBlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class ABaseBlock{
    public static class ABaseButtonBlock extends ButtonBlock {
        public ABaseButtonBlock(BlockSetType blockSetType, int n, Properties properties) {
            //1.20.4↑//
            //super(blockSetType, n, properties);
            //1.20.1//
            super(properties, blockSetType, n, false);
        }
    }

    public static class ABaseDoorBlock extends DoorBlock {
        public ABaseDoorBlock(BlockSetType blockSetType, Properties properties) {
            //1.20.4↑//
            //super(blockSetType, properties);
            //1.20.1//
            super(properties, blockSetType);
        }
    }

//1.20.4↑
//    public static class ABaseFallingBlock extends ColoredFallingBlock {
//        public ABaseFallingBlock(int colorRGBA, Properties properties) {
//            super(new ColorRGBA(colorRGBA), properties);
//        }
//    }
//1.20.1
   public static class ABaseFallingBlock extends SandBlock {
        public ABaseFallingBlock(int colorRGBA, Properties properties) {
            super(colorRGBA, properties);
        }
    }





    public static class ABasePressurePlateBlock extends PressurePlateBlock {
        public ABasePressurePlateBlock(BlockSetType blockSetType, Properties properties) {
            //1.20.4↑//
            //super(blockSetType, properties);
            //1.20.1//
            super(PressurePlateBlock.Sensitivity.EVERYTHING, properties, blockSetType);
        }
    }

    public static class ABaseSlab extends SlabBlock {
        public ABaseSlab(Properties properties) {
            super(properties);
        }
    }


    public static class ABaseStair extends StairBlock {
        public ABaseStair(BlockState blockState, Properties properties) {
            super(blockState, properties);
        }
    }

    public static class ABaseTorch extends TorchBlock {
        public ABaseTorch(SimpleParticleType simpleParticleType, Properties properties) {
            //1.20.4↑//
            //super(simpleParticleType, properties);
            //1.20.1//
            super(properties, simpleParticleType);
        }
    }

    public static class ABaseTrapDoorBlock extends TrapDoorBlock {
        public ABaseTrapDoorBlock(BlockSetType blockSetType, Properties properties) {
            //1.20.4↑//
            //super(blockSetType, properties);
            //1.20.1//
            super(properties, blockSetType);
        }
    }

    public static class ABaseWallBlock extends WallBlock {
        public ABaseWallBlock(Properties properties) {
            super(properties);
        }
    }

    public static class ABaseWallTorch extends WallTorchBlock {
        public ABaseWallTorch(SimpleParticleType simpleParticleType, Properties properties) {
            //1.20.4↑//
            //super(simpleParticleType, properties);
            //1.20.1//
            super(properties, simpleParticleType);
        }
    }




    public static class ABaseSkullBlock extends SkullBlock {
        private final SoundEvent soundEvent;
        public ABaseSkullBlock(Type type, Properties properties, SoundEvent soundEvent) {
            super(type, properties);
            this.soundEvent = soundEvent;
        }

        @Nullable
        public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
            return new ABaseSkullBlockEntity(blockPos, blockState, soundEvent);
        }
    }
    public static class ABaseWallSkullBlock extends WallSkullBlock {
        public ABaseWallSkullBlock(SkullBlock.Type type, Properties properties) {
            super(type, properties);
        }

        @Nullable
        public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
            return new ABaseSkullBlockEntity(blockPos, blockState);
        }
    }

    public static class ABaseSkullBlockEntity extends SkullBlockEntity {
        private SoundEvent soundEvent;
        public ABaseSkullBlockEntity(BlockPos blockPos, BlockState blockState) {
            super(blockPos, blockState);
        }
        public ABaseSkullBlockEntity(BlockPos blockPos, BlockState blockState, SoundEvent soundEvent) {
            this(blockPos, blockState);
            this.soundEvent = soundEvent;
        }

        @Nullable
        public ResourceLocation getNoteBlockSound() {
            if (soundEvent != null) {
                return soundEvent.getLocation();
            }
            return super.getNoteBlockSound();
        }

        @Override
        public @NotNull BlockEntityType<? extends ABaseSkullBlockEntity> getType(){
            return JVPillageBlockEntityType.ABASE_SKULL_BLOCK.get();
        }
    }

    public static enum Types implements SkullBlock.Type {
        RESURRECTER("resurrecter"),
        SECOND_ROUNDER_ZOMBIE("second_rounder_zombie"),
        SECOND_ROUNDER_SKELETON("second_rounder_skeleton"),
        PURPLE_SAND_CREEPER("purple_sand_creeper"),
        BLAMER("blamer"),
        TANGLER("tangler"),
        SPIRVE("spirve");

        private final String name;

        private Types(String string) {
            this.name = string;
            //1.20.4↑//
            //TYPES.put(string, this);
        }

        public String getSerializedName() {
            return this.name;
        }
    }
}

