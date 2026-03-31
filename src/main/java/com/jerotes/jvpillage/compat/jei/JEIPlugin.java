package com.jerotes.jvpillage.compat.jei;

import com.jerotes.jvpillage.JVPillage;
import com.jerotes.jvpillage.compat.jei.categories.HagReplacementRecipeCategory;
import com.jerotes.jvpillage.init.JVPillageBlocks;
import com.jerotes.jvpillage.init.JVPillageRecipeType;
import com.jerotes.jvpillage.recipes.HagReplacementRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.*;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Objects;

@JeiPlugin
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
@SuppressWarnings("unused")
public class JEIPlugin implements IModPlugin
{
	private static final ResourceLocation ID = new ResourceLocation(JVPillage.MODID, "jei_plugin");

	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		registry.addRecipeCategories(new HagReplacementRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager manager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		//鬼婆置换
		List<HagReplacementRecipe> hagReplacementRecipes = manager.getAllRecipesFor(JVPillageRecipeType.HAG_REPLACEMENT.get())
				.stream()
				//1.20.4↑//
				//.map(RecipeHolder::value)
				.toList();
		registration.addRecipes(HagReplacementRecipeCategory.HAG_REPLACEMENT, hagReplacementRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(JVPillageBlocks.NEW_HAGS_CAULDRON.get()), HagReplacementRecipeCategory.HAG_REPLACEMENT);
	}

	@Override
	public void registerGuiHandlers(IGuiHandlerRegistration registration) {
	}

	@Override
	public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
	}

	@Override
	public ResourceLocation getPluginUid() {
		return ID;
	}
}