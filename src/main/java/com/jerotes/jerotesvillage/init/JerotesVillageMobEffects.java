package com.jerotes.jerotesvillage.init;

import com.jerotes.jerotesvillage.JerotesVillage;
import com.jerotes.jerotesvillage.effect.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JerotesVillageMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, JerotesVillage.MODID);
	public static final RegistryObject<MobEffect> WILDERNESS_GIANT_POISON = REGISTRY.register("wilderness_giant_poison", () -> new WildernessGiantPoisonMobEffect());
	public static final RegistryObject<MobEffect> CARVED_VILLAGER_ARROW = REGISTRY.register("carved_villager_arrow", () -> new CarvedVillagerArrowMobEffect());
	public static final RegistryObject<MobEffect> UNCLEAN_BODY = REGISTRY.register("unclean_body", () -> new UncleanBodyMobEffect()
			.addAttributeModifier(Attributes.MOVEMENT_SPEED, "04f832e7-5274-43c4-8301-784e3198b2ca", -0.1, AttributeModifier.Operation.MULTIPLY_TOTAL)
			.addAttributeModifier(Attributes.ATTACK_DAMAGE, "4f71afdc-7499-494e-93ac-b1e7a5e3192f", -3.0, AttributeModifier.Operation.ADDITION));
	public static final RegistryObject<MobEffect> THROWING_STUBBORN_STONE = REGISTRY.register("throwing_stubborn_stone", () -> new ThrowingStubbornStoneMobEffect()
			.addAttributeModifier(Attributes.MOVEMENT_SPEED, "86FC816D-3A26-9DA2-F0AF-230BAB60CA54", 0.2, AttributeModifier.Operation.MULTIPLY_TOTAL));
	public static final RegistryObject<MobEffect> MALIGNASAUR_ASPHYXIA = REGISTRY.register("malignasaur_asphyxia", () -> new MalignasaurAsphyxiaMobEffect());
	public static final RegistryObject<MobEffect> OCEAN_DRAGON_DETERRENCE = REGISTRY.register("ocean_dragon_deterrence", () -> new OceanDragonDeterrenceMobEffect());
	public static final RegistryObject<MobEffect> FAIRNESS = REGISTRY.register("fairness", () -> new FairnessMobEffect());
	public static final RegistryObject<MobEffect> MEROR_STIMULIN = REGISTRY.register("meror_stimulin", () -> new MerorStimulinEffect()
			.addAttributeModifier(Attributes.MOVEMENT_SPEED, "3833DD1A-6D95-7B23-0BA2-F039960B90B8", 0.2, AttributeModifier.Operation.MULTIPLY_TOTAL)
			.addAttributeModifier(Attributes.ATTACK_DAMAGE, "F2DF9D77-78EA-EC1F-26A9-28710C376641", 3.0, AttributeModifier.Operation.ADDITION)
			.addAttributeModifier(Attributes.ATTACK_SPEED, "ECB297BB-456A-60A5-5141-02D01F006671", 0.2, AttributeModifier.Operation.MULTIPLY_TOTAL));
	public static final RegistryObject<MobEffect> RAMPANT = REGISTRY.register("rampant", () -> new RampantMobEffect()
			.addAttributeModifier(Attributes.MOVEMENT_SPEED, "0251C21C-A83D-5055-EADE-968E382FCADA", 0.1, AttributeModifier.Operation.MULTIPLY_TOTAL)
			.addAttributeModifier(Attributes.ATTACK_DAMAGE, "77800DA2-F0E6-7992-C1AD-47D1989DA844", 6.0, AttributeModifier.Operation.ADDITION));
	public static final RegistryObject<MobEffect> FRAGRANCE = REGISTRY.register("fragrance", () -> new FragranceMobEffect());
	public static final RegistryObject<MobEffect> ABUNDANT_COURAGE = REGISTRY.register("abundant_courage", () -> new AbundantCourageMobEffect()
			.addAttributeModifier(Attributes.ATTACK_DAMAGE, "71972839-F515-6CC9-4988-6A9D96B99093", 3.0, AttributeModifier.Operation.ADDITION));
	public static final RegistryObject<MobEffect> LAST_DITCH = REGISTRY.register("last_ditch", () -> new LastDitchMobEffect()
			.addAttributeModifier(Attributes.MAX_HEALTH, "2893EDE1-D03A-3499-77F6-74806DDE82A7", 2.0, AttributeModifier.Operation.MULTIPLY_TOTAL));
}