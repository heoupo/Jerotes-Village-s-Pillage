package com.jerotes.jvpillage.control;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.control.BodyRotationControl;

public class NoRotationControl extends BodyRotationControl {

    public NoRotationControl(Mob mob) {
        super(mob);
    }

    @Override
    public void clientTick() {
    }
}
