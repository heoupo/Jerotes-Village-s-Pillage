package com.jerotes.jerotesvillage.client.model;

import com.jerotes.jerotesvillage.JerotesVillage;
import com.jerotes.jerotesvillage.client.animation.LampWizardAnimation;
import com.jerotes.jerotesvillage.entity.Interface.AlwaysShowArmIllagerEntity;
import com.jerotes.jerotesvillage.entity.Monster.IllagerFaction.LampWizardEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.AbstractIllager;


public class Modellamp_wizard<T extends LampWizardEntity> extends Modelillager<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(JerotesVillage.MODID, "lamp_wizard"), "main");
	private final ModelPart head;

	public Modellamp_wizard(ModelPart root) {
		super(root);
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("ear", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("cloak", CubeListBuilder.create(), PartPose.ZERO);

		partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("left_sleeve", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("right_sleeve", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("jacket", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("left_pants", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("right_pants", CubeListBuilder.create(), PartPose.ZERO);

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition hat = head.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 11.0F, 8.0F, new CubeDeformation(0.45F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition hat_r1 = hat.addOrReplaceChild("hat_r1", CubeListBuilder.create().texOffs(65, 1).addBox(-8.0F, -8.0F, -0.5F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.5F, 0.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition hat2 = hat.addOrReplaceChild("hat2", CubeListBuilder.create(), PartPose.offset(0.0F, -11.989F, 1.2091F));
		PartDefinition hat2_r1 = hat2.addOrReplaceChild("hat2_r1", CubeListBuilder.create().texOffs(98, 0).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.989F, -0.2091F, -0.1047F, 0.0F, 0.0F));
		PartDefinition hat3 = hat2.addOrReplaceChild("hat3", CubeListBuilder.create(), PartPose.offset(0.0F, -2.8564F, 1.2665F));
		PartDefinition hat3_r1 = hat3.addOrReplaceChild("hat3_r1", CubeListBuilder.create().texOffs(98, 8).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3142F, 0.0F, 0.0F));
		head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(0.0F, -2.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F).texOffs(0, 38).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 20.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create().texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F).texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 3.0F, -1.0F, -0.75F, 0.0F, 0.0F));
		arms.addOrReplaceChild("left_shoulder", CubeListBuilder.create().texOffs(44, 22).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F), PartPose.ZERO);
		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(-2.0F, 12.0F, 0.0F));
		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(2.0F, 12.0F, 0.0F));
		partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 46).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(-5.0F, 2.0F, 0.0F));
		partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 46).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(5.0F, 2.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(T t, float f, float f2, float f3, float f4, float f5) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.head.yRot = f4 * ((float)Math.PI / 180F);
		this.head.xRot = f5 * ((float)Math.PI / 180F);
		this.animateWalk(LampWizardAnimation.WALK, f, f2, 2.0f, 2.0f);
		this.animate(t.shoot1AnimationState, LampWizardAnimation.SHOOT1, f3);
		this.animate(t.shoot2AnimationState, LampWizardAnimation.SHOOT2, f3);
		this.animate(t.shoot3AnimationState, LampWizardAnimation.SHOOT3, f3);

		AbstractIllager.IllagerArmPose abstractillager$illagerarmpose = t.getArmPose();
		boolean flag = abstractillager$illagerarmpose == AbstractIllager.IllagerArmPose.CROSSED && !(t instanceof AlwaysShowArmIllagerEntity);
		this.arms.visible = flag;
		this.leftArm.visible = !flag;
		this.rightArm.visible = !flag;

		if (!flag) {
			arms.xScale = 0;
			arms.yScale = 0;
			arms.zScale = 0;
		} else {
			leftArm.xScale = 0;
			leftArm.yScale = 0;
			leftArm.zScale = 0;
			rightArm.xScale = 0;
			rightArm.yScale = 0;
			rightArm.zScale = 0;
		}
		this.hatOld.copyFrom(this.head);
		this.jacket.copyFrom(this.body);
		this.left_sleeve.copyFrom(this.left_arm);
		this.right_sleeve.copyFrom(this.right_arm);
		this.left_pants.copyFrom(this.left_leg);
		this.right_pants.copyFrom(this.right_leg);
	}
}