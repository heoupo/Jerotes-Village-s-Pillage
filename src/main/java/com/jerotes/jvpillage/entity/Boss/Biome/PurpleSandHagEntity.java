package com.jerotes.jvpillage.entity.Boss.Biome;

import com.jerotes.jerotes.client.sound.BossMusicPlayer;
import com.jerotes.jerotes.config.MainConfig;
import com.jerotes.jerotes.entity.Interface.BossEntity;
import com.jerotes.jerotes.entity.Interface.InventoryEntity;
import com.jerotes.jerotes.entity.Interface.SpellUseEntity;
import com.jerotes.jerotes.event.JerotesBossEvent;
import com.jerotes.jerotes.goal.JerotesAddSpellAttackGoal;
import com.jerotes.jerotes.goal.JerotesMainSpellAttackGoal;
import com.jerotes.jerotes.init.JerotesDamageTypes;
import com.jerotes.jerotes.init.JerotesMobEffects;
import com.jerotes.jerotes.spell.SpellList;
import com.jerotes.jerotes.spell.SpellType;
import com.jerotes.jerotes.spell.SpellTypeInterface;
import com.jerotes.jerotes.util.EntityAndItemFind;
import com.jerotes.jerotes.util.EntityFactionFind;
import com.jerotes.jvpillage.config.OtherMainConfig;
import com.jerotes.jvpillage.entity.Monster.Hag.BaseHagEntity;
import com.jerotes.jvpillage.entity.Monster.SpirveEntity;
import com.jerotes.jvpillage.event.BossBarEvent;
import com.jerotes.jvpillage.init.JVPillageEntityType;
import com.jerotes.jvpillage.init.JVPillageSoundEvents;
import com.jerotes.jvpillage.spell.OtherSpellFind;
import com.jerotes.jvpillage.spell.OtherSpellType;
import com.jerotes.jvpillage.util.ParticlesUse;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.BossEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.scores.PlayerTeam;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class PurpleSandHagEntity extends BaseHagEntity implements BossEntity {
	private static final EntityDataAccessor<Boolean> IS_LEGEND = SynchedEntityData.defineId(PurpleSandHagEntity.class, EntityDataSerializers.BOOLEAN);
	private final JerotesBossEvent bossEvent = new JerotesBossEvent(this, this.getUUID(), BossEvent.BossBarColor.PURPLE, false);
	public PurpleSandHagEntity(EntityType<? extends BaseHagEntity> entityType, Level level) {
		super(entityType, level);
		this.xpReward = 400;
		if (OtherMainConfig.BossBaseAttributeCanUseConfig) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(OtherMainConfig.PurpleSandHagMaxHealth);
			this.setHealth(this.getMaxHealth());
			this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(OtherMainConfig.PurpleSandHagMeleeDamage);
			this.getAttribute(Attributes.ARMOR).setBaseValue(OtherMainConfig.PurpleSandHagArmor);
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(OtherMainConfig.PurpleSandHagMovementSpeed);
			this.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue(OtherMainConfig.PurpleSandHagAttackKnockback);
			this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(OtherMainConfig.PurpleSandHagKnockbackResistance);
		}
		if (level.isClientSide) {
			BossBarEvent.BOSSES.add(this);
		}
	}
	//百分比
	public boolean hasPercentageDamage() {
		return MainConfig.HasPercentageDamage.contains(this.getEncodeId())
				|| OtherMainConfig.BossHasPercentageDamage.contains(this.getEncodeId()) || this.isLegend();
	}
	public float PercentageDamage(DamageSource damageSource) {
		if (EntityAndItemFind.MagicResistance(damageSource)) {
			return(float) OtherMainConfig.PurpleSandHagMagicAttackPercentage;
		}
		return (float) OtherMainConfig.PurpleSandHagAttackPercentage;
	}
	//限伤
	public boolean hasDamageCap() {
		return MainConfig.HasDamageCap.contains(this.getEncodeId()) || OtherMainConfig.BossHasDamageCap.contains(this.getEncodeId()) || this.isLegend();
	}
	public float DamageCap(DamageSource damageSource, Entity entity) {
		return (float) OtherMainConfig.PurpleSandHagDamageCap;
	}
	//间隔
	public boolean hasDamageCooldownTick() {
		return MainConfig.HasDamageCooldownTick.contains(this.getEncodeId()) || OtherMainConfig.BossHasDamageCooldownTick.contains(this.getEncodeId()) || this.isLegend();
	}
	public float DamageCooldownTick(DamageSource damageSource, Entity entity) {
		float base = 1.0F;
		if (damageSource.is(DamageTypeTags.BYPASSES_COOLDOWN)) {
			base *= 0.5F;
		}
		return (float)OtherMainConfig.PurpleSandHagDamageCooldownTick * base;
	}

	@Override
	public void startSeenByPlayer(ServerPlayer serverPlayer) {
		super.startSeenByPlayer(serverPlayer);
		this.bossEvent.addPlayer(serverPlayer);
	}

	@Override
	public void stopSeenByPlayer(ServerPlayer serverPlayer) {
		super.stopSeenByPlayer(serverPlayer);
		this.bossEvent.removePlayer(serverPlayer);
	}

	@Override
	public void customServerAiStep() {
		super.customServerAiStep();
		this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MAX_HEALTH, 165);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 13);
		builder = builder.add(Attributes.ARMOR, 15);
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.35);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0);

		builder = builder.add(Attributes.FOLLOW_RANGE, 128);
		return builder;
	}
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new JerotesMainSpellAttackGoal(this, this.getSpellLevel(), 60, 240, 0.5f) {
			@Override
			public void tick() {
				int spellLevels = PurpleSandHagEntity.this.getSpellLevel() - 1;
				if (PurpleSandHagEntity.this.level().getDifficulty() == Difficulty.NORMAL) {
					spellLevels = PurpleSandHagEntity.this.getSpellLevel();
				} else if (PurpleSandHagEntity.this.level().getDifficulty() == Difficulty.HARD) {
					spellLevels = PurpleSandHagEntity.this.getSpellLevel() + 1;
				}
				this.spellLevel = spellLevels;
				super.tick();
			}
		});
		this.goalSelector.addGoal(1, new JerotesAddSpellAttackGoal(this, this.getSpellLevel(), 180, 240, 0.5f) {
			@Override
			public void tick() {
				int spellLevels = PurpleSandHagEntity.this.getSpellLevel() - 1;
				if (PurpleSandHagEntity.this.level().getDifficulty() == Difficulty.NORMAL) {
					spellLevels = PurpleSandHagEntity.this.getSpellLevel();
				} else if (PurpleSandHagEntity.this.level().getDifficulty() == Difficulty.HARD) {
					spellLevels = PurpleSandHagEntity.this.getSpellLevel() + 1;
				}
				this.spellLevel = spellLevels;
				super.tick();
			}
		});
	}

	@Override
	public List<SpellTypeInterface> SelfMainSpellList() {
		List<SpellTypeInterface> spellList = new ArrayList<>();
		if (this.getTarget() != null && EntityFactionFind.isHumanoid(this.getTarget()) && this.distanceTo(this.getTarget()) <= 12) {
			//技能列表-人类定身术
			spellList.add(SpellType.JEROTES_HOLD_PERSON);
		}
		else {
			//技能列表-致病射线
			spellList.add(SpellType.JEROTES_RAY_OF_SICKNESS);
		}
		//技能列表-魅影杀手
		spellList.add(SpellType.JEROTES_PHANTASMAL_KILLER);
		//技能列表-摄心目光
		spellList.add(SpellType.JEROTES_EYEBITE);
		//技能列表-闪电束
		spellList.add(SpellType.JEROTES_LIGHTNING_BOLT);
		//技能列表-恶毒嘲笑
		spellList.add(SpellType.JEROTES_VICIOUS_MOCKERY);
		//技能列表-致病射线
		spellList.add(SpellType.JEROTES_RAY_OF_SICKNESS);
		//技能列表-降咒
		spellList.add(SpellType.JEROTES_BESTOW_CURSE);
		//技能列表-疗伤术
		spellList.add(SpellType.JEROTES_CURE_WOUNDS);
		//技能列表-魔法飞弹
		spellList.add(SpellType.JEROTES_MAGIC_MISSILE);
		//技能列表-衰弱射线
		spellList.add(SpellType.JEROTES_RAY_OF_ENFEEBLEMENT);
		//技能列表-紫沙幻影
		spellList.add(OtherSpellType.JVPILLAGE_PURPLE_SAND_PHANTOM);
		return spellList;
	}
	@Override
	public List<SpellTypeInterface> SelfAddSpellList() {
		List<SpellTypeInterface> spellList = new ArrayList<>();
		//技能列表-镜影术
		spellList.add(SpellType.JEROTES_MIRROR_IMAGE);
		//技能列表-隐形通道
		spellList.add(SpellType.JEROTES_INVISIBLE_PASSAGE);
		if (this.getHealth() <= getMaxHealth() && this.getTarget() != null && this.getTarget() instanceof SpellUseEntity) {
			//技能列表-法术反制
			spellList.add(SpellType.JEROTES_COUNTERSPELL);
		}
		else {
			//技能列表-隐形通道
			spellList.add(SpellType.JEROTES_INVISIBLE_PASSAGE);
		}
		return spellList;
	}
	@Override
	protected float getSoundVolume() {
		return 5.0f;
	}
	@Override
	public SoundEvent getBossMusic() {
		return JVPillageSoundEvents.PURPLE_SAND_HAG_MUSIC;
	}
	@Override
	protected SoundEvent getAmbientSound() {
		return JVPillageSoundEvents.PURPLE_SAND_HAG_AMBIENT;
	}
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSource) {
		return JVPillageSoundEvents.PURPLE_SAND_HAG_HURT;
	}
	@Override
	protected SoundEvent getDeathSound() {
		return JVPillageSoundEvents.PURPLE_SAND_HAG_DEATH;
	}
	@Override
	public SoundEvent getCelebrateSound() {
		return JVPillageSoundEvents.PURPLE_SAND_HAG_LAUGH_1;
	}

	public int spellLevel = OtherMainConfig.PurpleSandHagSpellNormalLevel;
	public int covenSpellLevel = OtherMainConfig.PurpleSandHagSpellNormalLevel + 1;
	@Override
	public int getSpellLevel() {
		if (this.covenSpellLevel > spellLevel && this.isCoven()) {
			return covenSpellLevel;
		}
		return this.spellLevel;
	}
	@Override
	public void setCustomName(@Nullable Component component) {
		super.setCustomName(component);
		this.bossEvent.setName(this.getDisplayName());
	}
	//是否传奇
	public boolean isLegend() {
		return this.getEntityData().get(IS_LEGEND);
	}
	public void setLegend(boolean bl) {
		this.getEntityData().set(IS_LEGEND, bl);
	}
	public boolean isLegendary() {
		return this.isLegend() || hasPercentageDamage() && hasDamageCap() && hasDamageCooldownTick();
	}
	@Override
	public void addAdditionalSaveData(CompoundTag compoundTag) {
		super.addAdditionalSaveData(compoundTag);
		compoundTag.putBoolean("IsLegend", this.isLegend());
		compoundTag.putInt("SpellLevel", this.spellLevel);
		compoundTag.putInt("CovenSpellLevel", this.covenSpellLevel);
	}
	@Override
	public void readAdditionalSaveData(CompoundTag compoundTag) {
		super.readAdditionalSaveData(compoundTag);
		if (this.hasCustomName()) {
			this.bossEvent.setName(this.getDisplayName());
		}
		this.setLegend(compoundTag.getBoolean("IsLegend"));
		this.spellLevel = compoundTag.getInt("SpellLevel");
		this.covenSpellLevel = compoundTag.getInt("CovenSpellLevel");
		this.bossEvent.setId(this.getUUID());
	}
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.getEntityData().define(IS_LEGEND, false);
	}

	@Override
	public void tick() {
		super.tick();
		if (!level().isClientSide && getBossMusic() != null) {
			if (!isSilent() && getTarget() instanceof Player player && player.isAlive()) {
				this.level().broadcastEntityEvent(this, (byte)67);
			}
			else {
				this.level().broadcastEntityEvent(this, (byte)68);
			}
		}
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.bossEvent.update();
		if (this.level().getDifficulty() == Difficulty.HARD) {
			if (!this.level().isClientSide()) {
				this.setConjurSpirve(Math.max(0, this.getConjurSpirve() - 1));
			}
		}

		//技能-法术反制
		if (this.tickCount % 600 == 0 || this.tickCount == 1) {
			if (!this.level().isClientSide()) {
				this.addEffect(new MobEffectInstance(JerotesMobEffects.COUNTERSPELL.get(), 600, spellLevel, false, false), this);
			}
		}
		//技能-鬼婆集会 15
		//技能-召唤灵奴 16
		List<BaseHagEntity> listHag = this.level().getEntitiesOfClass(BaseHagEntity.class, this.getBoundingBox().inflate(64.0, 64.0, 64.0));
		listHag.removeIf(entity -> this.getTarget() == entity || entity.getTarget() == this || !((this.getTeam() == null && entity.getTeam() == null) || (entity.isAlliedTo(this))));
		List<SpirveEntity> listSpirve = this.level().getEntitiesOfClass(SpirveEntity.class, this.getBoundingBox().inflate(64.0, 64.0, 64.0));
		listSpirve.removeIf(entity -> this.getTarget() == entity || entity.getTarget() == this || !((this.getTeam() == null && entity.getTeam() == null) || (entity.isAlliedTo(this))));
		if (getHealth() < (this.getMaxHealth() * 0.6) && this.getTarget() != null && this.deathTime == 0) {
			if (!this.isCovens()) {
				if (this.getConjurSpirve() <= 0) {
					if (!this.level().isClientSide()) {
						this.setConjurSpirve((int) (OtherMainConfig.PurpleSandHagMainSpellCooldown * 20 * 10));
						this.setInvisibility(false);
						this.setCovens(true);
						this.setAnimTick(15);
						this.setAnimationState("spell2");
					}
					OtherSpellFind.HagCoven(this, 3);
					ParticlesUse.ParticleMagic(this);
					if (!this.isSilent()) {
						this.level().playSound(null, this.getX(), this.getY(), this.getZ(), JVPillageSoundEvents.PURPLE_SAND_HAG_COVENS, this.getSoundSource(), 10.0f, 0.8f + this.getRandom().nextFloat() * 0.4f);
					}
				}
			}
			else {
				if (this.getConjurSpirve() <= 0 && listSpirve.size() < listHag.size() * 16) {
					if (!this.level().isClientSide()) {
						this.setConjurSpirve((int) (OtherMainConfig.PurpleSandHagMainSpellCooldown * 20 * 10));
						this.setInvisibility(false);
						this.setCovens(true);
						this.setAnimTick(15);
						this.setAnimationState("spell2");
					}
					OtherSpellFind.ConjureSpirve(this, 3);
					ParticlesUse.ParticleMagic(this);
					if (!this.isSilent()) {
						this.level().playSound(null, this.getX(), this.getY(), this.getZ(), JVPillageSoundEvents.PURPLE_SAND_HAG_CONJURE_SPIRVE, this.getSoundSource(), 10.0f, 0.8f + this.getRandom().nextFloat() * 0.4f);
					}
				}
			}
		}
	}


	@Override
	public boolean killedEntity(ServerLevel serverLevel, LivingEntity livingEntity) {
		PlayerTeam teams = (PlayerTeam) this.getTeam();
		boolean bl = super.killedEntity(serverLevel, livingEntity);
		if (livingEntity instanceof AbstractVillager villager) {
			SimpleContainer simpleContainer = villager.getInventory();
			SpirveEntity spirve = villager.convertTo(JVPillageEntityType.SPIRVE.get(), true);
			if (spirve != null) {
				if (teams != null) {
					serverLevel.getScoreboard().addPlayerToTeam(spirve.getStringUUID(), teams);
				}
				if (!this.isSilent()) {
					serverLevel.levelEvent(null, 1026, this.blockPosition(), 0);
				}
				bl = false;
				net.minecraftforge.event.ForgeEventFactory.onLivingConvert(this, spirve);
				for (int n = 0; n < simpleContainer.getContainerSize(); ++n) {
					ItemStack finds = simpleContainer.getItem(n);
					spirve.mobInventory().addItem(finds);
				}
			}
		}
		else if (livingEntity instanceof AbstractIllager illager) {
			SimpleContainer simpleContainer = new SimpleContainer(0);
			if (illager instanceof InventoryEntity inventoryEntity) {
				simpleContainer = inventoryEntity.mobInventory();
			}
			SpirveEntity spirve = illager.convertTo(JVPillageEntityType.SPIRVE.get(), true);
			if (spirve != null) {
				if (teams != null) {
					serverLevel.getScoreboard().addPlayerToTeam(spirve.getStringUUID(), teams);
				}
				if (!this.isSilent()) {
					serverLevel.levelEvent(null, 1026, this.blockPosition(), 0);
				}
				bl = false;
				net.minecraftforge.event.ForgeEventFactory.onLivingConvert(this, spirve);
				for (int n = 0; n < simpleContainer.getContainerSize(); ++n) {
					ItemStack finds = simpleContainer.getItem(n);
					spirve.mobInventory().addItem(finds);
				}
			}
		}
		else if (livingEntity instanceof Witch witch) {
			SimpleContainer simpleContainer = new SimpleContainer(0);
			if (witch instanceof InventoryEntity inventoryEntity) {
				simpleContainer = inventoryEntity.mobInventory();
			}
			SpirveEntity spirve = witch.convertTo(JVPillageEntityType.SPIRVE.get(), true);
			if (spirve != null) {
				if (teams != null) {
					serverLevel.getScoreboard().addPlayerToTeam(spirve.getStringUUID(), teams);
				}
				if (!this.isSilent()) {
					serverLevel.levelEvent(null, 1026, this.blockPosition(), 0);
				}
				bl = false;
				net.minecraftforge.event.ForgeEventFactory.onLivingConvert(this, spirve);
				for (int n = 0; n < simpleContainer.getContainerSize(); ++n) {
					ItemStack finds = simpleContainer.getItem(n);
					spirve.mobInventory().addItem(finds);
				}
			}
		}
		return bl;
	}

	@Override
	public boolean isInvulnerableTo(DamageSource damageSource) {
		if (damageSource.is(DamageTypes.THORNS)
				|| damageSource.is(DamageTypes.SWEET_BERRY_BUSH)
				|| damageSource.is(DamageTypes.CACTUS)
				|| damageSource.is(DamageTypeTags.IS_FIRE)
				|| damageSource.is(DamageTypeTags.IS_FALL)
				|| damageSource.is(DamageTypeTags.IS_DROWNING)
				|| damageSource.is(DamageTypeTags.IS_LIGHTNING))
			return true;
		if (damageSource.getDirectEntity() instanceof ThrownPotion || damageSource.getDirectEntity() instanceof AreaEffectCloud)
			return true;
		return super.isInvulnerableTo(damageSource);
	}
	@Override
	public boolean hurt(DamageSource damageSource, float amount) {
		if (isInvulnerableTo(damageSource)) {
			return super.hurt(damageSource, amount);
		}
		//魔法抗性
		if (EntityAndItemFind.MagicResistance(damageSource)) {
			int spellLevels = this.getSpellLevel() - 1;
			if (this.level().getDifficulty() == Difficulty.NORMAL) {
				spellLevels = this.getSpellLevel();
			} else if (this.level().getDifficulty() == Difficulty.HARD) {
				spellLevels = this.getSpellLevel() + 1;
			}
			//技能-魔法吸收
			SpellList.MagicAbsorption(spellLevels, this, this).spellUse();
			if (amount <= spellLevels * 5 && !damageSource.is(JerotesDamageTypes.MAGIC_EFFECT)) {
				return false;
			}
			return super.hurt(damageSource, amount / 3);
		}
		return super.hurt(damageSource, amount);
	}

	@Override
	protected float getDamageAfterMagicAbsorb(DamageSource damageSource, float f) {
		f = super.getDamageAfterMagicAbsorb(damageSource, f);
		if (damageSource.getEntity() == this) {
			f = 0.0f;
		}
		if (damageSource.is(DamageTypeTags.WITCH_RESISTANT_TO)) {
			f *= 0.15f;
		}
		return f;
	}

	@Override
	public boolean canBeAffected(MobEffectInstance mobEffectInstance) {
		if (mobEffectInstance.getEffect() == MobEffects.POISON) {
			return false;
		}
		if (mobEffectInstance.getEffect() == JerotesMobEffects.DEADLY_POISON.get()) {
			return false;
		}
		if (mobEffectInstance.getEffect() == MobEffects.BLINDNESS) {
			return false;
		}
		if (mobEffectInstance.getEffect() == MobEffects.WEAKNESS) {
			return false;
		}
		if (mobEffectInstance.getEffect() == MobEffects.MOVEMENT_SLOWDOWN) {
			return false;
		}
		return super.canBeAffected(mobEffectInstance);
	}

	@Override
	public void handleEntityEvent(byte by) {
		if (by == 67) {
			BossMusicPlayer.playBossMusic(this);
		}
		else if (by == 68) {
			BossMusicPlayer.stopBossMusic(this);
		}
		else {
			super.handleEntityEvent(by);
		}
	}

	@Override
	public void tickDeath() {
		if(deathTime <= 0){
			if (!this.level().isClientSide()) {
				this.setAnimTick(40);
				this.setAnimationState("dead");
			}
		}
		++this.deathTime;
		if (this.deathTime >= 40 && !this.level().isClientSide() && !this.isRemoved()) {
			this.remove(RemovalReason.CHANGED_DIMENSION);
		}
	}
}
