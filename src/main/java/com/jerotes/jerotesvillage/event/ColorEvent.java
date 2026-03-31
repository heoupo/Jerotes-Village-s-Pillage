package com.jerotes.jerotesvillage.event;

import com.jerotes.jerotesvillage.JerotesVillage;
import com.jerotes.jerotesvillage.config.OtherMainConfig;
import com.jerotes.jerotesvillage.init.JerotesVillageBlocks;
import com.jerotes.jerotesvillage.init.JerotesVillageItems;
import com.jerotes.jerotesvillage.item.PotionThrowingBall;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JerotesVillage.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ColorEvent {

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        BlockColors blockColors = event.getBlockColors();


        //药水投团
        event.register((itemStack, n) -> n > 0 ? -1:
                        itemStack.getItem() instanceof PotionThrowingBall potionThrowingBall
                                ? PotionUtils.getColor(PotionUtils.getMobEffects(itemStack))
                                : 0xFFFFFF,
                JerotesVillageItems.POTION_THROWING_BALL.get());

        //强硬草方块
        event.register((itemStack, n) -> {
            BlockState blockState = ((BlockItem)itemStack.getItem()).getBlock().defaultBlockState();
            return blockColors.getColor(blockState, null, null, n);
        }, JerotesVillageBlocks.AASTRONG_GRASS_BLOCK.get());

        //二轮锚定核心
        event.register((itemStack, n) -> {
            BlockState blockState = ((BlockItem)itemStack.getItem()).getBlock().defaultBlockState();
            return blockColors.getColor(blockState, null, null, n);
        }, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get());

        //紫沙
        event.register((itemStack, n) -> !OtherMainConfig.PurpleSandEyeProtectionMode ? (!OtherMainConfig.PurpleSandCustomColor ? 0x703c9d : OtherMainConfig.PurpleSandCustomColorUse) :
                0xcaa4c7, JerotesVillageItems.PURPLE_SAND.get());


    }

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        //强硬草方块
        event.register((blockState, blockAndTintGetter, blockPos, n) -> {
            if (blockAndTintGetter == null || blockPos == null) {
                return GrassColor.getDefaultColor();
            }
            return BiomeColors.getAverageGrassColor(blockAndTintGetter, blockPos);
        }, JerotesVillageBlocks.AASTRONG_GRASS_BLOCK.get());

        //二轮锚定核心
        event.register((blockState, blockAndTintGetter, blockPos, n) -> {
            if (blockAndTintGetter == null || blockPos == null) {
                return GrassColor.getDefaultColor();
            }
            return BiomeColors.getAverageGrassColor(blockAndTintGetter, blockPos);
        }, JerotesVillageBlocks.SECOND_ROUND_ANCHOR_CORE.get());

        //强硬草方块
        event.register((blockState, blockAndTintGetter, blockPos, n) -> {
            if (blockAndTintGetter == null || blockPos == null) {
                return GrassColor.getDefaultColor();
            }
            return BiomeColors.getAverageGrassColor(blockAndTintGetter, blockPos);
        }, JerotesVillageBlocks.AASTRONG_GRASS_BLOCK.get());
        //紫沙
        event.register((blockState, blockAndTintGetter, blockPos, n) -> !OtherMainConfig.PurpleSandEyeProtectionMode ? 0x703c9d :
                0xcc98c8, JerotesVillageBlocks.PURPLE_SAND.get());

    }
}
