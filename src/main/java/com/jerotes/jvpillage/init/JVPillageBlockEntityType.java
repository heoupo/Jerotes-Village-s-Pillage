package com.jerotes.jvpillage.init;

import com.jerotes.jvpillage.JVPillage;
import com.jerotes.jvpillage.block.BaseBlock.ABaseBlock;
import com.jerotes.jvpillage.block.DamagedRuins.MerorProjectionTableEntity;
import com.jerotes.jvpillage.block.ResurrectSediment.SedimentUrnEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JVPillageBlockEntityType {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, JVPillage.MODID);


	public static final RegistryObject<BlockEntityType<SedimentUrnEntity>> SEDIMENT_URN = REGISTRY.register("sediment_urn",
			() -> BlockEntityType.Builder.of(SedimentUrnEntity::new, JVPillageBlocks.SEDIMENT_URN.get()).build(null));
	public static final RegistryObject<BlockEntityType<ABaseBlock.ABaseSkullBlockEntity>> ABASE_SKULL_BLOCK = REGISTRY.register("abase_skull_block",
			() -> BlockEntityType.Builder.of(ABaseBlock.ABaseSkullBlockEntity::new,
					JVPillageBlocks.SPIRVE_HEAD.get(), JVPillageBlocks.SPIRVE_WALL_HEAD.get()
			).build(null));
	public static final RegistryObject<BlockEntityType<MerorProjectionTableEntity>> MEROR_PROJECTION_TABLE = REGISTRY.register("meror_projection_table",
			() -> BlockEntityType.Builder.of(MerorProjectionTableEntity::new, JVPillageBlocks.MEROR_PROJECTION_TABLE.get()).build(null));
}
