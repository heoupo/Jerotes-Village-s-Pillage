package com.jerotes.jvpillage.entity.Shoot.Magic.MagicBeam;

import com.jerotes.jerotes.entity.Shoot.Magic.MagicBeam.BaseMagicBeamEntity;
import com.jerotes.jerotes.init.JerotesDamageTypes;
import com.jerotes.jerotes.util.AttackFind;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class ElectroflashEntity extends BaseMagicBeamEntity {
    public ElectroflashEntity(EntityType<? extends ElectroflashEntity> entityType, Level level) {
        super(entityType, level);
    }
    public ElectroflashEntity(EntityType<? extends ElectroflashEntity> entityType, Level level, int spellLevelDamage) {
        super(entityType, level, spellLevelDamage);
    }

    protected void customHurtMagic(Entity entity) {
        entity.hurt(AttackFind.findDamageType(this, JerotesDamageTypes.BYPASSES_COOLDOWN_LIGHTNING, this, this.getOwner()), 0.35f * spellLevelDamage);
    }
    protected int getMaxTick() {
        return 240;
    }
}