package com.jerotes.jerotesvillage.init;

import com.jerotes.jerotesvillage.JerotesVillage;
import com.jerotes.jerotesvillage.block.BaseBlock.ABaseBlock;
import com.jerotes.jerotesvillage.block.DamagedRuins.MerorProjectionTableEntity;
import com.jerotes.jerotesvillage.block.ResurrectSediment.SedimentUrnEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JerotesVillageBlockEntityType {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, JerotesVillage.MODID);


	public static final RegistryObject<BlockEntityType<SedimentUrnEntity>> SEDIMENT_URN = REGISTRY.register("sediment_urn",
			() -> BlockEntityType.Builder.of(SedimentUrnEntity::new, JerotesVillageBlocks.SEDIMENT_URN.get()).build(null));
	public static final RegistryObject<BlockEntityType<ABaseBlock.ABaseSkullBlockEntity>> ABASE_SKULL_BLOCK = REGISTRY.register("abase_skull_block",
			() -> BlockEntityType.Builder.of(ABaseBlock.ABaseSkullBlockEntity::new,
					JerotesVillageBlocks.SPIRVE_HEAD.get(), JerotesVillageBlocks.SPIRVE_WALL_HEAD.get()
			).build(null));
	public static final RegistryObject<BlockEntityType<MerorProjectionTableEntity>> MEROR_PROJECTION_TABLE = REGISTRY.register("meror_projection_table",
			() -> BlockEntityType.Builder.of(MerorProjectionTableEntity::new, JerotesVillageBlocks.MEROR_PROJECTION_TABLE.get()).build(null));
}
