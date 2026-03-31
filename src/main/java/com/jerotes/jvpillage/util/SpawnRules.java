package com.jerotes.jvpillage.util;

import com.jerotes.jerotes.entity.Interface.BossEntity;
import com.jerotes.jerotes.entity.Interface.EliteEntity;
import com.jerotes.jvpillage.config.OtherMainConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Objects;

public class SpawnRules {
	//生成
	//方块
	public static boolean BlockSpawn(int num, Block block, LevelAccessor levelAccessor, MobSpawnType mobSpawnType, BlockPos blockPos, RandomSource randomSource) {
		AABB aabb = AABB.ofSize(new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ()), num, num, num);
		for (BlockPos blockPoss : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
			if (!levelAccessor.hasChunkAt(blockPoss.getX(), blockPoss.getZ())) continue;
			if (!levelAccessor.getBlockState(blockPoss).is(block)) continue;
			return true;
		}
		return false;
	}
	//正常
	public static boolean NeutralSpawn(int num, double area, EntityType<? extends Mob> entityType, LevelAccessor levelAccessor, MobSpawnType mobSpawnType, BlockPos blockPos, RandomSource randomSource) {
		List<Mob> list = levelAccessor.getEntitiesOfClass(Mob.class, AABB.ofSize(new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ()), area, area, area));
		list.removeIf(entity -> entity.getType() != entityType);
		return list.size() < num && Mob.checkMobSpawnRules(entityType, levelAccessor, mobSpawnType, blockPos, randomSource);
	}
	//铜刻类型生物
	public static boolean CarvedSpawn(int num, double area, EntityType<? extends Mob> entityType, LevelAccessor levelAccessor, MobSpawnType mobSpawnType, BlockPos blockPos, RandomSource randomSource) {
		List<Mob> list = levelAccessor.getEntitiesOfClass(Mob.class, AABB.ofSize(new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ()), area, area, area));
		list.removeIf(entity -> entity.getType() != entityType);
		return list.size() < num && Mob.checkMobSpawnRules(entityType, levelAccessor, mobSpawnType, blockPos, randomSource);
	}
	//动物
	public static boolean AnimalSpawn(int num, double area, EntityType<? extends Animal> entityType, LevelAccessor levelAccessor, MobSpawnType mobSpawnType, BlockPos blockPos, RandomSource randomSource) {
		List<Mob> list = levelAccessor.getEntitiesOfClass(Mob.class, AABB.ofSize(new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ()), area, area, area));
		list.removeIf(entity -> entity.getType() != entityType);
		return list.size() < num && Animal.checkAnimalSpawnRules(entityType, levelAccessor, mobSpawnType, blockPos, randomSource);
	}
	//黑暗怪物
	public static boolean DarkMonsterSpawn(int num, double area, EntityType<? extends Monster> entityType, ServerLevelAccessor serverLevelAccessor, MobSpawnType mobSpawnType, BlockPos blockPos, RandomSource randomSource) {
		List<LivingEntity> list = serverLevelAccessor.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ()), area, area, area));
		list.removeIf(entity -> entity.getType() != entityType);
		return list.size() < num && Monster.checkMonsterSpawnRules(entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource);
	}
	//阳光怪物
	public static boolean LightMonsterSpawn(int num, double area, EntityType<? extends Monster> entityType, LevelAccessor levelAccessor, MobSpawnType mobSpawnType, BlockPos blockPos, RandomSource randomSource) {
		List<Mob> list = levelAccessor.getEntitiesOfClass(Mob.class, AABB.ofSize(new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ()), area, area, area));
		list.removeIf(entity -> entity.getType() != entityType);
		return list.size() < num && Monster.checkAnyLightMonsterSpawnRules(entityType, levelAccessor, mobSpawnType, blockPos, randomSource);
	}
	//精英
	public static boolean EliteSpawn(int num, double area, EntityType<? extends Mob> entityType, LevelAccessor levelAccessor, MobSpawnType mobSpawnType, BlockPos blockPos, RandomSource randomSource) {
		if (area != OtherMainConfig.EliteSpawnRestrictionRange) {
			area = OtherMainConfig.EliteSpawnRestrictionRange;
		}
		List<Mob> list = levelAccessor.getEntitiesOfClass(Mob.class, AABB.ofSize(new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ()), area, area, area));
		if (!(OtherMainConfig.EliteOnlyOne || OtherMainConfig.EliteAndBossOnlyOne || OtherMainConfig.SameTypeEliteOnlyOne)) {
			num = num * 8;
		}
		//不影响的情况
		list.removeIf(entity -> entity.getType() != entityType
				&& !(OtherMainConfig.EliteOnlyOne && entity instanceof EliteEntity && !isSameMod(entityType, entity.getType()))
				&& !(OtherMainConfig.EliteAndBossOnlyOne && (entity instanceof BossEntity || entity instanceof EliteEntity) && !isSameMod(entityType, entity.getType()))
		);
		return list.size() < num && Mob.checkMobSpawnRules(entityType, levelAccessor, mobSpawnType, blockPos, randomSource);
	}
	//Boss
	public static boolean BossSpawn(int num, double area, EntityType<? extends Mob> entityType, LevelAccessor levelAccessor, MobSpawnType mobSpawnType, BlockPos blockPos, RandomSource randomSource) {
		if (area != OtherMainConfig.BossSpawnRestrictionRange) {
			area = OtherMainConfig.BossSpawnRestrictionRange;
		}
		List<Mob> list = levelAccessor.getEntitiesOfClass(Mob.class, AABB.ofSize(new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ()), area, area, area));
		if (!(OtherMainConfig.BossOnlyOne || OtherMainConfig.EliteAndBossOnlyOne || OtherMainConfig.SameTypeBossOnlyOne)) {
			num = num * 4;
		}
		//不影响的情况
		list.removeIf(entity -> entity.getType() != entityType
				&& !(OtherMainConfig.BossOnlyOne && entity instanceof BossEntity && !isSameMod(entityType, entity.getType()))
				&& !(OtherMainConfig.EliteAndBossOnlyOne && (entity instanceof BossEntity || entity instanceof EliteEntity) && !isSameMod(entityType, entity.getType()))
		);
		return list.size() < num && Mob.checkMobSpawnRules(entityType, levelAccessor, mobSpawnType, blockPos, randomSource);
	}

	//Boss生成时的检测
	public static boolean BossSpawnFind(EntityType<? extends BossEntity> entityType, Entity posEntity) {
		double area = OtherMainConfig.BossSpawnRestrictionRange;
		List<Mob> list = posEntity.level().getEntitiesOfClass(Mob.class, posEntity.getBoundingBox().inflate(area, area, area));
		//不影响的情况
		list.removeIf(entity ->
				!(OtherMainConfig.SameTypeBossOnlyOne && entity.getType() == entityType)
						&& !(OtherMainConfig.BossOnlyOne && entity instanceof BossEntity && !isSameMod(entityType, entity.getType()))
						&& !(OtherMainConfig.EliteAndBossOnlyOne && (entity instanceof BossEntity || entity instanceof EliteEntity) && !isSameMod(entityType, entity.getType()))
		);
		if (!list.isEmpty() && posEntity.level() instanceof ServerLevel) {
			posEntity.sendSystemMessage(Component.translatable("boss.jerotes.can_not_spawn").withStyle(ChatFormatting.BLUE));
		}
		return list.isEmpty();
	}

	public static boolean isSameMod(EntityType<?> entityType, EntityType<?> entityType2) {
		return Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entityType)).getNamespace().equals(Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entityType2)).getNamespace());
	}
}