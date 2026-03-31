package com.jerotes.jvpillage.init;

import com.jerotes.jvpillage.JVPillage;
import com.jerotes.jvpillage.recipes.HagReplacementRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JVPillageRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, JVPillage.MODID);
    public static final RegistryObject<RecipeSerializer<HagReplacementRecipe>> HAG_REPLACEMENT =
            REGISTRY.register("hag_replacement", HagReplacementRecipe.HagReplacementSerializer::new);
}