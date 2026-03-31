package com.jerotes.jvpillage.init;

import com.jerotes.jvpillage.JVPillage;
import com.jerotes.jvpillage.enchantment.ElasticityEnchantment;
import com.jerotes.jvpillage.item.Tool.ItemToolBaseThrowingBall;
import com.jerotes.jvpillage.item.Tool.ItemToolBaseThrowingBallGlove;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JVPillageEnchantments {
	public static final EnchantmentCategory THROWING_BALL_ABOUT = EnchantmentCategory.create("throwing_ball_about", item -> item instanceof ItemToolBaseThrowingBall || item instanceof ItemToolBaseThrowingBallGlove);

	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, JVPillage.MODID);
	public static final RegistryObject<Enchantment> ELASTICITY = REGISTRY.register("elasticity", () -> new ElasticityEnchantment());
}