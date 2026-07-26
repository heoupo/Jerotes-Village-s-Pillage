package com.jerotes.jvpillage.util;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class OtherParticlesUse {
    //魔法粒子
    public static void ParticleMagic(LivingEntity livingEntity){
        if (livingEntity.level() instanceof ServerLevel serverLevel) {
            Vec3 position = livingEntity.position().add(0, 0.1, 0);
            for (int i = 0; i < 36; i++) {
                double angle = (i / 36.0) * Math.PI * 2;
                double radius = 2.0 + livingEntity.getRandom().nextDouble() * 2.5;
                double x = position.x + Math.cos(angle) * radius;
                double y = position.y + 0.2 + (livingEntity.getRandom().nextDouble() * 0.3);
                double z = position.z + Math.sin(angle) * radius;
                serverLevel.sendParticles(ParticleTypes.WITCH, x, y, z, 2, 0, 0, 0, 0.02);
                serverLevel.sendParticles(ParticleTypes.ENCHANT, x, y, z, 2, 0, 0, 0, 0.05);
            }
            for (int i = 0; i < 60; i++) {
                double angle = (i / 60.0) * Math.PI * 2;
                double radius = 6 + livingEntity.getRandom().nextDouble() * 2;
                double x = position.x + Math.cos(angle) * radius;
                double y = position.y + livingEntity.getRandom().nextDouble() * 1.5;
                double z = position.z + Math.sin(angle) * radius;
                serverLevel.sendParticles(ParticleTypes.WITCH, x, y, z, 3, 0.1, 1.0, 0.1, 0.1);
            }
            for (int i = 0; i < 20; i++) {
                double x = position.x + (livingEntity.getRandom().nextDouble() - 0.5) * 4;
                double y = position.y + livingEntity.getRandom().nextDouble() * 1.5;
                double z = position.z + (livingEntity.getRandom().nextDouble() - 0.5) * 4;
                serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 3, 0, 0, 0, 0.05);
            }
        }
    }

    //粒子
    public static void sendBallParticles(LivingEntity entity, SimpleParticleType simpleParticleType) {
        sendBallParticles(entity, simpleParticleType, false, 3.0f, 0.15f);
    }
    public static void sendBallParticles(LivingEntity entity, SimpleParticleType simpleParticleType, boolean bl, float radius, float speed) {
        if (entity.level() instanceof ServerLevel serverLevel) {
            Vec3 playerPos = entity.position().add(0, entity.getY(0.5) - entity.getY(), 0);
            int particleCount = 40;

            for (int i = 0; i < particleCount; i++) {
                double angle = entity.getRandom().nextDouble() * Math.PI * 2;
                double inclination = entity.getRandom().nextDouble() * Math.PI;
                double offsetX = radius * Math.sin(inclination) * Math.cos(angle);
                double offsetY = radius * Math.cos(inclination);
                double offsetZ = radius * Math.sin(inclination) * Math.sin(angle);

                Vec3 particlePos;
                Vec3 velocity;

                if (bl) {
                    particlePos = playerPos;
                    Vec3 direction = new Vec3(offsetX, offsetY, offsetZ).normalize();
                    velocity = direction.scale(speed);
                } else {
                    particlePos = playerPos.add(offsetX, offsetY, offsetZ);
                    Vec3 direction = playerPos.subtract(particlePos).normalize();
                    velocity = direction.scale(speed);
                }

                serverLevel.sendParticles(simpleParticleType,
                        particlePos.x, particlePos.y, particlePos.z,
                        0, velocity.x, velocity.y, velocity.z, 1.0f);
            }
        }
    }
}

