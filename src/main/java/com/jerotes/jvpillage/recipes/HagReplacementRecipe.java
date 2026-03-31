//1.20.4↑//
// package com.jerotes.jvpillage.recipes;
//
//import com.jerotes.jvpillage.init.JVPillageItems;
//import com.jerotes.jvpillage.init.JVPillageRecipeSerializers;
//import com.jerotes.jvpillage.init.JVPillageRecipeType;
//import com.mojang.serialization.Codec;
//import com.mojang.serialization.DataResult;
//import com.mojang.serialization.codecs.RecordCodecBuilder;
//import net.minecraft.core.NonNullList;
//import net.minecraft.core.RegistryAccess;
//import net.minecraft.network.FriendlyByteBuf;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.Container;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.crafting.Ingredient;
//import net.minecraft.world.item.crafting.Recipe;
//import net.minecraft.world.item.crafting.RecipeSerializer;
//import net.minecraft.world.item.crafting.RecipeType;
//import net.minecraft.world.level.Level;
//
//public class HagReplacementRecipe implements Recipe<Container> {
//	private final NonNullList<Ingredient> base;
//	private final NonNullList<Ingredient> result;
//
//	public HagReplacementRecipe(NonNullList<Ingredient> base, NonNullList<Ingredient> result) {
//		this.base = base;
//		this.result = result;
//	}
//
//	public NonNullList<Ingredient> getBase() {
//		return base;
//	}
//	public NonNullList<Ingredient> getResult() {
//		return result;
//	}
//
//	@Override
//	public boolean matches(Container container, Level level) {
//		return false;
//	}
//
//	@Override
//	public ItemStack assemble(Container container, RegistryAccess registryAccess) {
//		return result.get(0).getItems()[0];
//	}
//
//	@Override
//	public boolean canCraftInDimensions(int width, int height) {
//		return true;
//	}
//
//	@Override
//	public ItemStack getResultItem(RegistryAccess registryAccess) {
//		return result.get(0).getItems()[0];
//	}
//
//	@Override
//	public RecipeSerializer<?> getSerializer() {
//		return JVPillageRecipeSerializers.HAG_REPLACEMENT.get();
//	}
//
//	@Override
//	public RecipeType<?> getType() {
//		return JVPillageRecipeType.HAG_REPLACEMENT.get();
//	}
//
//	@Override
//	public ItemStack getToastSymbol() {
//		return new ItemStack(JVPillageItems.NEW_HAGS_CAULDRON.get());
//	}
//
//	public static class HagReplacementSerializer implements RecipeSerializer<HagReplacementRecipe> {
//		private final Codec<HagReplacementRecipe> codec;
//
//		public HagReplacementSerializer() {
//			this.codec = RecordCodecBuilder.create(instance ->
//					instance.group(
//							Ingredient.CODEC_NONEMPTY.listOf().fieldOf("base").flatXmap((ingredients) -> {
//								Ingredient[] aingredient = ingredients.stream().filter((ingredient) -> !ingredient.isEmpty()).toArray(Ingredient[]::new);
//								if (aingredient.length == 0) {
//									return DataResult.error(() -> "No ingredients for recipe");
//								} else {
//									return DataResult.success(NonNullList.of(Ingredient.EMPTY, aingredient));
//								}
//							}, DataResult::success).forGetter(HagReplacementRecipe::getBase),
//
//							Ingredient.CODEC_NONEMPTY.listOf().fieldOf("result").flatXmap((ingredients) -> {
//								Ingredient[] aingredient = ingredients.stream().filter((ingredient) -> !ingredient.isEmpty()).toArray(Ingredient[]::new);
//								if (aingredient.length == 0) {
//									return DataResult.error(() -> "No ingredients for recipe");
//								} else {
//									return DataResult.success(NonNullList.of(Ingredient.EMPTY, aingredient));
//								}
//							}, DataResult::success).forGetter(HagReplacementRecipe::getResult)
//					).apply(instance, HagReplacementRecipe::new)
//			);
//		}
//		@Override
//		public Codec<HagReplacementRecipe> codec() {
//			return this.codec;
//		}
//
//		// 修复网络序列化/反序列化
//		@Override
//		public HagReplacementRecipe fromNetwork(FriendlyByteBuf friendlyByteBuf) {
//			// 读取base列表
//			int baseSize = friendlyByteBuf.readVarInt();
//			NonNullList<Ingredient> base = NonNullList.withSize(baseSize, Ingredient.EMPTY);
//			for (int j = 0; j < baseSize; ++j) {
//				base.set(j, Ingredient.fromNetwork(friendlyByteBuf));
//			}
//
//			// 读取result列表
//			int resultSize = friendlyByteBuf.readVarInt();
//			NonNullList<Ingredient> result = NonNullList.withSize(resultSize, Ingredient.EMPTY);
//			for (int j = 0; j < resultSize; ++j) {
//				result.set(j, Ingredient.fromNetwork(friendlyByteBuf));
//			}
//			return new HagReplacementRecipe(base, result);
//		}
//
//		@Override
//		public void toNetwork(FriendlyByteBuf friendlyByteBuf, HagReplacementRecipe recipe) {
//			// 写入base列表大小和内容
//			friendlyByteBuf.writeVarInt(recipe.base.size());
//			for (Ingredient ingredient : recipe.base) {
//				ingredient.toNetwork(friendlyByteBuf);
//			}
//
//			// 写入result列表大小和内容
//			friendlyByteBuf.writeVarInt(recipe.result.size());
//			for (Ingredient ingredient : recipe.result) {
//				ingredient.toNetwork(friendlyByteBuf);
//			}
//		}
//	}
//}

//1.20.1/
package com.jerotes.jvpillage.recipes;

import com.google.gson.JsonArray;
import com.jerotes.jvpillage.init.JVPillageItems;
import com.jerotes.jvpillage.init.JVPillageRecipeSerializers;
import com.jerotes.jvpillage.init.JVPillageRecipeType;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
		import net.minecraft.world.level.Level;

public class HagReplacementRecipe implements Recipe<Container> {
	private final ResourceLocation id;
	@Override
	public ResourceLocation getId() {
		return id;
	}
	private final NonNullList<Ingredient> base;
	private final NonNullList<Ingredient> result;

	public HagReplacementRecipe(ResourceLocation id, NonNullList<Ingredient> base, NonNullList<Ingredient> result) {
		this.id = id;
		this.base = base;
		this.result = result;
	}

	public NonNullList<Ingredient> getBase() {
		return base;
	}
	public NonNullList<Ingredient> getResult() {
		return result;
	}

	@Override
	public boolean matches(Container container, Level level) {
		return false;
	}

	@Override
	public ItemStack assemble(Container container, RegistryAccess registryAccess) {
		return result.get(0).getItems()[0];
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return true;
	}

	@Override
	public ItemStack getResultItem(RegistryAccess registryAccess) {
		return result.get(0).getItems()[0];
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return JVPillageRecipeSerializers.HAG_REPLACEMENT.get();
	}

	@Override
	public RecipeType<?> getType() {
		return JVPillageRecipeType.HAG_REPLACEMENT.get();
	}

	@Override
	public ItemStack getToastSymbol() {
		return new ItemStack(JVPillageItems.NEW_HAGS_CAULDRON.get());
	}

	public static class HagReplacementSerializer implements RecipeSerializer<HagReplacementRecipe> {

		public HagReplacementSerializer() {

		}

		@Override
		public HagReplacementRecipe fromJson(ResourceLocation resourceLocation, com.google.gson.JsonObject jsonObject) {
			final NonNullList<Ingredient> baseIn = readIngredients(GsonHelper.getAsJsonArray(jsonObject, "base"));
			final NonNullList<Ingredient> resultIn = readIngredients(GsonHelper.getAsJsonArray(jsonObject, "result"));
			return new HagReplacementRecipe(resourceLocation, baseIn, resultIn);
		}
		private static NonNullList<Ingredient> readIngredients(JsonArray ingredientArray) {
			NonNullList<Ingredient> nonnulllist = NonNullList.create();
			for (int i = 0; i < ingredientArray.size(); ++i) {
				Ingredient ingredient = Ingredient.fromJson(ingredientArray.get(i));
				if (!ingredient.isEmpty()) {
					nonnulllist.add(ingredient);
				}
			}
			return nonnulllist;
		}

		// 修复网络序列化/反序列化
		@Override
		public HagReplacementRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
			// 读取base列表
			int baseSize = friendlyByteBuf.readVarInt();
			NonNullList<Ingredient> base = NonNullList.withSize(baseSize, Ingredient.EMPTY);
			for (int j = 0; j < baseSize; ++j) {
				base.set(j, Ingredient.fromNetwork(friendlyByteBuf));
			}

			// 读取result列表
			int resultSize = friendlyByteBuf.readVarInt();
			NonNullList<Ingredient> result = NonNullList.withSize(resultSize, Ingredient.EMPTY);
			for (int j = 0; j < resultSize; ++j) {
				result.set(j, Ingredient.fromNetwork(friendlyByteBuf));
			}
			return new HagReplacementRecipe(resourceLocation, base, result);
		}

		@Override
		public void toNetwork(FriendlyByteBuf friendlyByteBuf, HagReplacementRecipe recipe) {
			// 写入base列表大小和内容
			friendlyByteBuf.writeVarInt(recipe.base.size());
			for (Ingredient ingredient : recipe.base) {
				ingredient.toNetwork(friendlyByteBuf);
			}

			// 写入result列表大小和内容
			friendlyByteBuf.writeVarInt(recipe.result.size());
			for (Ingredient ingredient : recipe.result) {
				ingredient.toNetwork(friendlyByteBuf);
			}
		}
	}
}