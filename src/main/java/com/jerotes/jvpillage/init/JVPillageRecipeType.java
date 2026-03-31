package com.jerotes.jvpillage.init;

import com.jerotes.jvpillage.JVPillage;
import com.jerotes.jvpillage.recipes.HagReplacementRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JVPillageRecipeType {
    public static final DeferredRegister<RecipeType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, JVPillage.MODID);
    public static final RegistryObject<RecipeType<HagReplacementRecipe>> HAG_REPLACEMENT = REGISTRY.register("hag_replacement", () -> registerRecipeType("hag_replacement"));

    public static <T extends Recipe<?>> RecipeType<T> registerRecipeType(final String identifier) {
        RecipeType<T> type = new RecipeType<>() {
            public String toString() {
                return JVPillage.MODID + ":" + identifier;
            }
        };
        System.out.println("Registered RecipeType: " + type);
        return type;
    }

}
