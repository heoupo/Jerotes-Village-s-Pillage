package com.jerotes.jvpillage.entity.Shoot.Arrow;

import com.jerotes.jerotes.entity.Shoot.Arrow.BaseJavelinEntity;
import com.jerotes.jvpillage.init.JVPillageItems;
import com.jerotes.jvpillage.init.JVPillageEntityType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ThrownOminousJavalinEntity extends BaseJavelinEntity {
	private static final ItemStack item = new ItemStack(JVPillageItems.OMINOUS_JAVELIN.get());
	private static final EntityType<ThrownOminousJavalinEntity> type = JVPillageEntityType.OMINOUS_JAVALIN.get();
	public ThrownOminousJavalinEntity(EntityType<? extends ThrownOminousJavalinEntity> entityType, Level level) {
		super(entityType, level, item, 9.0f);
	}
	public ThrownOminousJavalinEntity(Level level, LivingEntity livingEntity, ItemStack itemStack) {
		super(level, livingEntity, itemStack, type, 9.0f);
	}

	@Override
	public boolean breakShield() {
		return true;
	}
	@Override
	public int basePierce() {
		return 1;
	}
}
