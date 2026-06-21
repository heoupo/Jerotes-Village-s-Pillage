package com.jerotes.jvpillage.client.model;


import com.jerotes.jvpillage.JVPillage;
import com.jerotes.jvpillage.client.animation.FakeMalialosaurAnimation;
import com.jerotes.jvpillage.entity.Animal.FakeMalialosaurEntity;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.AgeableHierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.joml.Vector3f;

public class Modelfake_malialosaur<T extends FakeMalialosaurEntity> extends AgeableHierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(JVPillage.MODID, "fake_malialosaur"), "main");
	private final ModelPart root;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart body;
	private final ModelPart body_front;
	private final ModelPart body_middle;
	private final ModelPart body_hind_1;
	private final ModelPart body_hind_2;
	private final ModelPart body_hind_3;
	private final ModelPart tail;
	private final ModelPart left_front_leg;
	private final ModelPart left_front_foot;
	private final ModelPart right_front_leg;
	private final ModelPart right_front_foot;
	private final ModelPart right_hind_leg;
	private final ModelPart right_hind_foot;
	private final ModelPart left_hind_leg;
	private final ModelPart left_hind_foot;

	public Modelfake_malialosaur(ModelPart root) {
		super(0.5f, 24.0f);
		this.root = root;
		this.head = root.getChild("head");
		this.jaw = this.head.getChild("jaw");
		this.body = root.getChild("body");
		this.body_front = this.body.getChild("body_front");
		this.body_middle = this.body.getChild("body_middle");
		this.body_hind_1 = this.body.getChild("body_hind_1");
		this.body_hind_2 = this.body_hind_1.getChild("body_hind_2");
		this.body_hind_3 = this.body_hind_2.getChild("body_hind_3");
		this.tail = this.body_hind_3.getChild("tail");
		this.left_front_leg = root.getChild("left_front_leg");
		this.left_front_foot = this.left_front_leg.getChild("left_front_foot");
		this.right_front_leg = root.getChild("right_front_leg");
		this.right_front_foot = this.right_front_leg.getChild("right_front_foot");
		this.right_hind_leg = root.getChild("right_hind_leg");
		this.right_hind_foot = this.right_hind_leg.getChild("right_hind_foot");
		this.left_hind_leg = root.getChild("left_hind_leg");
		this.left_hind_foot = this.left_hind_leg.getChild("left_hind_foot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(217, 18).addBox(-5.0F, -1.0F, -7.0F, 10.0F, 6.0F, 8.0F, new CubeDeformation(0.0125F))
				.texOffs(0, 0).addBox(-3.5F, -3.0F, -7.0F, 7.0F, 2.0F, 10.0F, new CubeDeformation(0.05F))
				.texOffs(78, 0).addBox(-4.0F, -1.0F, -19.0F, 8.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-4.0F, 1.5F, -19.0F, 8.0F, 1.0F, 10.0F, new CubeDeformation(-0.15F)), PartPose.offset(0.0F, 6.0F, -40.0F));

		PartDefinition head_r1 = head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(40, 0).addBox(-3.5F, -1.0F, -6.0F, 7.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9339F, -12.7667F, 0.1309F, 0.0F, 0.0F));

		PartDefinition head_r2 = head.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(196, 0).addBox(-1.0F, -2.0F, -6.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(-3.5897F, 1.0687F, -13.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition head_r3 = head.addOrReplaceChild("head_r3", CubeListBuilder.create().texOffs(196, 0).mirror().addBox(-1.0F, -2.0F, -6.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(3.5897F, 1.0687F, -13.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition head_r4 = head.addOrReplaceChild("head_r4", CubeListBuilder.create().texOffs(227, 3).mirror().addBox(-1.0F, -2.0F, -8.0F, 2.0F, 3.0F, 9.0F, new CubeDeformation(-0.225F)).mirror(false), PartPose.offsetAndRotation(3.5F, -1.0F, 1.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition head_r5 = head.addOrReplaceChild("head_r5", CubeListBuilder.create().texOffs(227, 3).addBox(-1.0F, -2.0F, -8.0F, 2.0F, 3.0F, 9.0F, new CubeDeformation(-0.225F)), PartPose.offsetAndRotation(-3.5F, -1.0F, 1.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition head_r6 = head.addOrReplaceChild("head_r6", CubeListBuilder.create().texOffs(82, 61).addBox(-3.5F, -1.0F, -3.0F, 7.0F, 2.0F, 9.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 4.6945F, -3.0651F, -0.1745F, 0.0F, 0.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 23).addBox(-4.0F, -0.25F, -9.0F, 8.0F, 1.0F, 10.0F, new CubeDeformation(-0.125F))
				.texOffs(118, 0).addBox(-4.0F, 0.5F, -10.0F, 8.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, -9.0F));

		PartDefinition jaw_r1 = jaw.addOrReplaceChild("jaw_r1", CubeListBuilder.create().texOffs(158, 0).addBox(-3.5F, -0.5F, -6.0F, 7.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.5035F, -3.8865F, -0.0436F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 5.3495F, -19.4574F));

		PartDefinition body_front = body.addOrReplaceChild("body_front", CubeListBuilder.create().texOffs(0, 105).addBox(-3.5F, -4.2F, -9.0F, 7.0F, 9.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.6505F, -11.5426F));

		PartDefinition body_front_r1 = body_front.addOrReplaceChild("body_front_r1", CubeListBuilder.create().texOffs(0, 68).addBox(-3.5F, -1.0F, -6.0F, 7.0F, 2.0F, 12.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 5.018F, -0.5341F, -0.0436F, 0.0F, 0.0F));

		PartDefinition body_middle = body.addOrReplaceChild("body_middle", CubeListBuilder.create().texOffs(42, 95).addBox(-6.0F, -5.8495F, -17.5426F, 12.0F, 12.0F, 21.0F, new CubeDeformation(0.05F)), PartPose.offset(0.0F, 2.0F, 7.0F));

		PartDefinition body_r1 = body_middle.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(87, 91).addBox(-6.5F, -4.0F, -9.0F, 12.0F, 4.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 7.598F, -8.7442F, -0.1527F, 0.0F, 0.0F));

		PartDefinition body_hind_1 = body.addOrReplaceChild("body_hind_1", CubeListBuilder.create().texOffs(154, 59).addBox(-5.5F, -4.5F, 1.0F, 11.0F, 13.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.6505F, 9.4574F));

		PartDefinition body_hind_1_r1 = body_hind_1.addOrReplaceChild("body_hind_1_r1", CubeListBuilder.create().texOffs(132, 91).addBox(-5.5F, -1.0F, -7.0F, 11.0F, 2.0F, 19.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 8.12F, 7.4352F, 0.0654F, 0.0F, 0.0F));

		PartDefinition body_hind_2 = body_hind_1.addOrReplaceChild("body_hind_2", CubeListBuilder.create().texOffs(0, 82).addBox(-4.5F, -4.5F, 0.0F, 9.0F, 11.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.2F, 20.0F));

		PartDefinition body_hind_2_r1 = body_hind_2.addOrReplaceChild("body_hind_2_r1", CubeListBuilder.create().texOffs(37, 58).addBox(-4.5F, -0.5F, -6.5F, 9.0F, 2.0F, 12.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 5.7449F, 6.0138F, 0.1745F, 0.0F, 0.0F));

		PartDefinition body_hind_3 = body_hind_2.addOrReplaceChild("body_hind_3", CubeListBuilder.create().texOffs(90, 56).addBox(-2.5F, -3.5F, -1.0F, 5.0F, 8.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 12.0F));

		PartDefinition body_hind_3_r1 = body_hind_3.addOrReplaceChild("body_hind_3_r1", CubeListBuilder.create().texOffs(42, 72).addBox(-2.5F, -1.5F, -10.5F, 5.0F, 3.0F, 20.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 4.1224F, 9.2053F, 0.0873F, 0.0F, 0.0F));

		PartDefinition tail = body_hind_3.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(108, 76).addBox(0.0F, -0.5F, 0.0F, 0.0F, 5.0F, 47.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 26.0F));

		PartDefinition left_front_leg = partdefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create(), PartPose.offset(6.5F, 10.0F, -23.0F));

		PartDefinition left_arm_r1 = left_front_leg.addOrReplaceChild("left_arm_r1", CubeListBuilder.create().texOffs(91, 18).mirror().addBox(-1.5F, -8.5F, -2.0F, 3.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.1136F, 4.3249F, 3.2106F, 0.5612F, 0.0393F, -0.5648F));

		PartDefinition left_front_foot = left_front_leg.addOrReplaceChild("left_front_foot", CubeListBuilder.create(), PartPose.offset(2.0F, 5.5F, 3.5F));

		PartDefinition left_front_foot_r1 = left_front_foot.addOrReplaceChild("left_front_foot_r1", CubeListBuilder.create().texOffs(91, 31).mirror().addBox(-1.5F, -5.5F, -2.0F, 3.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 4.0057F, 0.1307F, -0.0873F, 0.0F, 0.0F));

		PartDefinition right_front_leg = partdefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create(), PartPose.offset(-6.5F, 10.0F, -23.0F));

		PartDefinition right_arm_r1 = right_front_leg.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(91, 18).addBox(-1.5F, -8.5F, -2.0F, 3.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1197F, 4.3479F, 2.6262F, 0.6865F, -0.0779F, 0.5574F));

		PartDefinition right_front_foot = right_front_leg.addOrReplaceChild("right_front_foot", CubeListBuilder.create(), PartPose.offset(-3.0F, 5.5F, 3.5F));

		PartDefinition right_front_foot_r1 = right_front_foot.addOrReplaceChild("right_front_foot_r1", CubeListBuilder.create().texOffs(91, 31).addBox(-1.5F, -5.5F, -2.0F, 3.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 4.0057F, 0.1307F, -0.0873F, 0.0F, 0.0F));

		PartDefinition right_hind_leg = partdefinition.addOrReplaceChild("right_hind_leg", CubeListBuilder.create(), PartPose.offset(-5.5F, 8.0F, 21.0F));

		PartDefinition right_leg_r1 = right_hind_leg.addOrReplaceChild("right_leg_r1", CubeListBuilder.create().texOffs(105, 18).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3029F, 2.4594F, -0.3135F, -0.2333F, 0.1198F, 0.4659F));

		PartDefinition right_hind_foot = right_hind_leg.addOrReplaceChild("right_hind_foot", CubeListBuilder.create(), PartPose.offset(-3.5F, 6.5979F, -1.8941F));

		PartDefinition right_hind_foot_r1 = right_hind_foot.addOrReplaceChild("right_hind_foot_r1", CubeListBuilder.create().texOffs(105, 31).addBox(-1.5F, -3.5F, -3.0F, 3.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3F, 2.9021F, 1.3941F, 0.0873F, 0.0F, 0.0F));

		PartDefinition left_hind_leg = partdefinition.addOrReplaceChild("left_hind_leg", CubeListBuilder.create(), PartPose.offset(5.5F, 8.0F, 21.0F));

		PartDefinition left_leg_r1 = left_hind_leg.addOrReplaceChild("left_leg_r1", CubeListBuilder.create().texOffs(105, 18).mirror().addBox(-2.0F, -4.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.3029F, 2.4424F, -0.4429F, -0.2333F, -0.1198F, -0.4659F));

		PartDefinition left_hind_foot = left_hind_leg.addOrReplaceChild("left_hind_foot", CubeListBuilder.create(), PartPose.offset(3.5F, 6.5861F, -1.7859F));

		PartDefinition left_hind_foot_r1 = left_hind_foot.addOrReplaceChild("left_hind_foot_r1", CubeListBuilder.create().texOffs(105, 31).mirror().addBox(-1.5F, -3.5F, -3.0F, 3.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.3F, 2.9139F, 1.2859F, 0.0873F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}
	private float currentTailYaw = 0f;
	@Override
	public void setupAnim(T t, float f, float f2, float f3, float f4, float f5) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		if (t.isBaby()) {
			this.head.xScale = 1.3f;
			this.head.yScale = 1.3f;
			this.head.zScale = 1.3f;
		}
		else {
			this.head.xScale = 1f;
			this.head.yScale = 1f;
			this.head.zScale = 1f;
		}

		this.head.yRot = f4 * ((float) Math.PI / 180F);
		this.head.xRot = f5 * ((float) Math.PI / 180F) * (0.5f + 0.5f * (1 - t.waterAnimProgress / 40f));

		if (!t.isInSittingPose()) {
			float targetTailYaw = -f4 * 1.2f * ((float) Math.PI / 180F);
			currentTailYaw += (targetTailYaw - currentTailYaw) * 0.1f;
		}
		else {
			currentTailYaw = 0;
		}
		body_hind_2.yRot += Mth.clamp(currentTailYaw * 0.2f, -1.0f, 1.0f);
		body_hind_3.yRot += Mth.clamp(currentTailYaw * 0.6f, -1.0f, 1.0f);
		tail.yRot += Mth.clamp(currentTailYaw, -1.0f, 1.0f);

		KeyframeAnimations.animate(this, FakeMalialosaurAnimation.LAND, 0L, (1 - t.waterAnimProgress / 40f), new Vector3f());
		KeyframeAnimations.animate(this, FakeMalialosaurAnimation.WATER, 0L, (t.waterAnimProgress / 40f), new Vector3f());

		//水
		if (t.isVehicle() && t.getControllingPassenger() == t.getOwner()){
			this.animateWalk(FakeMalialosaurAnimation.SWIMRIDE, f, f2 * t.waterAnimProgress / 40, 2.0f, 2.0f);
		}
		else {
			this.animateWalk(FakeMalialosaurAnimation.SWIM, f, f2 * t.waterAnimProgress / 40, 2.0f, 2.0f);
		}
		//陆地
		if (t.isVehicle() && t.getControllingPassenger() == t.getOwner()){
			this.animateWalk(FakeMalialosaurAnimation.RUSHRIDE, f, f2 * (1 - t.waterAnimProgress / 40f), 2.0f, 2.0f);
		}
		if (t.isAggressive()) {
			this.animateWalk(FakeMalialosaurAnimation.RUSH, f, f2 * (1 - t.waterAnimProgress / 40f), 2.0f, 2.0f);
		}
		else {
			this.animateWalk(FakeMalialosaurAnimation.WALK, f, f2 * (1 - t.waterAnimProgress / 40f), 2.0f, 2.0f);
		}
		this.animate(t.idleAnimationState, FakeMalialosaurAnimation.IDLE, f3);
		this.animate(t.attack1AnimationState, FakeMalialosaurAnimation.ATTACK1, f3);
		this.animate(t.attack2AnimationState, FakeMalialosaurAnimation.ATTACK2, f3);
		this.animate(t.attack3AnimationState, FakeMalialosaurAnimation.ATTACK3, f3);
		this.animate(t.attack4AnimationState, FakeMalialosaurAnimation.ATTACK4, f3);
		this.animate(t.sitAnimationState, FakeMalialosaurAnimation.SIT, f3);
		this.animate(t.toSitAnimationState, FakeMalialosaurAnimation.TOSIT, f3);
		this.animate(t.stopSitAnimationState, FakeMalialosaurAnimation.STOPSIT, f3);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}