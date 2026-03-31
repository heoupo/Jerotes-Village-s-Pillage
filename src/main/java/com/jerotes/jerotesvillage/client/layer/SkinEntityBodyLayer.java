package com.jerotes.jerotesvillage.client.layer;

import com.jerotes.jerotes.entity.Interface.SkinEntity;
import com.jerotes.jerotes.util.Color;
import com.jerotes.jerotesvillage.JerotesVillage;
import com.jerotes.jerotesvillage.entity.Monster.Hag.BaseHagEntity;
import com.jerotes.jerotesvillage.entity.Monster.SpirveEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;

public class SkinEntityBodyLayer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {
    private final EntityModel<T> model;
    private final String string;

    public SkinEntityBodyLayer(RenderLayerParent<T, M> renderLayerParent, M m, String string) {
        super(renderLayerParent);
        this.model = m;
        this.string = string;
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int n, T t, float f, float f2, float f3, float f4, float f5, float f6) {
        boolean bl;
        Minecraft minecraft = Minecraft.getInstance();
        boolean bl2 = bl = minecraft.shouldEntityAppearGlowing(t) && t.isInvisible();
        if (t.isInvisible() && !bl) {
            return;
        }
        if (!(t instanceof SkinEntity skinEntity)) {
            return;
        }
        if (!skinEntity.isTrueUse()) {
            return;
        }
        this.getParentModel().copyPropertiesTo(this.model);
        this.model.prepareMobModel(t, f, f2, f3);
        this.model.setupAnim(t, f, f2, f4, f5, f6);
        String sexual = "male";
        if (((SkinEntity)t).IsFemale() || t instanceof BaseHagEntity) {
            sexual = "female";
        }
        String SkinColorHave = "null";
        String ClothesColorHave = "null";
        //皮肤
        ResourceLocation bodyLocation = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/base.png");
        //眼睛
        ResourceLocation eyeBaseLocation = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/eye_base.png");
        ResourceLocation leftEyeLocation = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/eye/eye_left.png");
        ResourceLocation rightEyeLocation = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/eye/eye_right.png");
        //头发
        ResourceLocation hairLocation = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/hair/hair_" + ((SkinEntity)t).HairType() + ".png");
        if (t.isBaby()) {
            hairLocation = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/baby_hair/hair_" + ((SkinEntity)t).HairType() + ".png");
        }
        //附件
        ResourceLocation addLocation_1 = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/add/add_" + ((SkinEntity)t).AddType_1() + ".png");
        ResourceLocation addBaseLocation_1 = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/add/add_base_" + ((SkinEntity)t).AddType_1() + ".png");
        ResourceLocation addLocation_2 = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/add/add_" + ((SkinEntity)t).AddType_2() + ".png");
        ResourceLocation addBaseLocation_2 = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/add/add_base_" + ((SkinEntity)t).AddType_2() + ".png");
        ResourceLocation addLocation_3 = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/add/add_" + ((SkinEntity)t).AddType_3() + ".png");
        ResourceLocation addBaseLocation_3 = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/add/add_base_" + ((SkinEntity)t).AddType_3() + ".png");
        //上衣
        ResourceLocation jacketLocation = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/clothes/jacket_" + ((SkinEntity)t).JacketType() + ".png");
        ResourceLocation jacketBaseLocation = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/clothes/jacket_base_" + ((SkinEntity)t).JacketType() + ".png");
        //裤子
        ResourceLocation pantsLocation = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/clothes/pants_" + ((SkinEntity)t).PantsType() + ".png");
        ResourceLocation pantsBaseLocation = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/clothes/pants_base_" + ((SkinEntity)t).PantsType() + ".png");
        //手套
        ResourceLocation glovesLocation = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/clothes/gloves_" + ((SkinEntity)t).GlovesType() + ".png");
        ResourceLocation glovesBaseLocation = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/clothes/gloves_base_" + ((SkinEntity)t).GlovesType() + ".png");
        //饰品
        ResourceLocation baubleLocation_1 = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/bauble/bauble_" + ((SkinEntity)t).BaubleType_1() + ".png");
        ResourceLocation baubleBaseLocation_1 = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/bauble/bauble_base_" + ((SkinEntity)t).BaubleType_1() + ".png");
        ResourceLocation baubleLocation_2 = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/bauble/bauble_" + ((SkinEntity)t).BaubleType_2() + ".png");
        ResourceLocation baubleBaseLocation_2 = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/bauble/bauble_base_" + ((SkinEntity)t).BaubleType_2() + ".png");
        ResourceLocation baubleLocation_3 = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/bauble/bauble_" + ((SkinEntity)t).BaubleType_3() + ".png");
        ResourceLocation baubleBaseLocation_3 = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/bauble/bauble_base_" + ((SkinEntity)t).BaubleType_3() + ".png");
        //鞋子
        ResourceLocation shoesLocation = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/clothes/shoes_" + ((SkinEntity)t).ShoesType() + ".png");
        ResourceLocation shoesBaseLocation = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/clothes/shoes_base_" + ((SkinEntity)t).ShoesType() + ".png");
        //帽子
        ResourceLocation hatLocation = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/clothes/hat_" + ((SkinEntity)t).HatType() + ".png");
        ResourceLocation hatBaseLocation = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/clothes/hat_base_" + ((SkinEntity)t).HatType() + ".png");
        //外套
        ResourceLocation overcoatLocation = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/clothes/overcoat_" + ((SkinEntity)t).OvercoatType() + ".png");
        ResourceLocation overcoatBaseLocation = new ResourceLocation(JerotesVillage.MODID, "textures/entity/skin/" + this.string + "/" + sexual + "/clothes/overcoat_base_" + ((SkinEntity)t).OvercoatType() + ".png");

        //皮肤
        if (((SkinEntity)t).SkinType() > 0 && ((SkinEntity)t).SkinColor() > 0) {
            String SkinColor;
            //肤色
            if (t instanceof BaseHagEntity) {
                if (((SkinEntity) t).SkinColor() == 1) {
                    SkinColor = "9e9451";
                } else if (((SkinEntity) t).SkinColor() == 2) {
                    SkinColor = "898444";
                } else if (((SkinEntity) t).SkinColor() == 3) {
                    SkinColor = "878239";
                } else if (((SkinEntity) t).SkinColor() == 4) {
                    SkinColor = "828e3c";
                } else if (((SkinEntity) t).SkinColor() == 5) {
                    SkinColor = "88852e";
                } else if (((SkinEntity) t).SkinColor() == 6) {
                    SkinColor = "7c7a39";
                } else if (((SkinEntity) t).SkinColor() == 7) {
                    SkinColor = "78842f";
                } else if (((SkinEntity) t).SkinColor() == 8) {
                    SkinColor = "6b7025";
                }
                else {
                    SkinColor = "988449";
                }
            }
            else if (t instanceof SpirveEntity) {
                SkinColor = "988449";
            }
            else {
                SkinColor = "ffffff";
            }
            int[] arrf = Color.colorStringToRGBInt(SkinColor);
            float r = arrf[0] / 255f;
            float g = arrf[1] / 255f;
            float b = arrf[2] / 255f;
            SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, bodyLocation, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r, g, b);
            SkinColorHave = SkinColor;
        }
        //眼睛
        if (((SkinEntity)t).EyeType() > 0) {
            //眼睛基础
            String EyeBaseColor;
            if (t instanceof BaseHagEntity) {
                EyeBaseColor = "eeb900";
            }
            else if (t instanceof SpirveEntity) {
                EyeBaseColor = "888888";
            }
            else {
                EyeBaseColor = "ffffff";
            }
            int[] arrf = Color.colorStringToRGBInt(EyeBaseColor);
            float r = arrf[0] / 255f;
            float g = arrf[1] / 255f;
            float b = arrf[2] / 255f;
            if (!SkinColorHave.equals("null") && t.hurtTime > 0) {
                EyeBaseColor = SkinColorHave;
                arrf = Color.colorStringToRGBInt(EyeBaseColor);
                int addColor = 20;

                r = Mth.clamp((arrf[0] - addColor), 0, 255) / 255f;
                g = Mth.clamp((arrf[1] - addColor), 0, 255) / 255f;
                b = Mth.clamp((arrf[2] - addColor), 0, 255) / 255f;
            }
            SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, eyeBaseLocation, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r, g, b);
            //眼睛具体
            if (((SkinEntity)t).EyeColor() > 0 && t.hurtTime <= 0) {
                String LeftEyeColor = "000000";
                String RightEyeColor = LeftEyeColor;

                if (t instanceof BaseHagEntity) {
                    if (((SkinEntity) t).EyeColor() >= 1 && ((SkinEntity) t).EyeColor() <= 8) {
                        LeftEyeColor = "8d6d00";
                        RightEyeColor = LeftEyeColor;
                    }
                }
                else {
                    LeftEyeColor = "000000";
                    RightEyeColor = LeftEyeColor;
                }
                int[] left_arrf = Color.colorStringToRGBInt(LeftEyeColor);
                float left_r = left_arrf[0] / 255f;
                float left_g = left_arrf[1] / 255f;
                float left_b = left_arrf[2] / 255f;
                int[] right_arrf = Color.colorStringToRGBInt(RightEyeColor);
                float right_r = right_arrf[0] / 255f;
                float right_g = right_arrf[1] / 255f;
                float right_b = right_arrf[2] / 255f;
                if (((SkinEntity) t).EyeType() == 1 || ((SkinEntity) t).EyeType() == 2) {
                    SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, leftEyeLocation, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, left_r, left_g, left_b);
                }
                if (((SkinEntity) t).EyeType() == 1 || ((SkinEntity) t).EyeType() == 3) {
                    SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, rightEyeLocation, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, right_r, right_g, right_b);
                }
            }
        }
        //附加
        if (!SkinColorHave.equals("null")) {
            //附加_1
            if (((SkinEntity)t).AddType_1() > 0) {
                //附加基础
                int[] arrf_base_1 = Color.colorStringToRGBInt("ffffff");
                float r_base_1 = arrf_base_1[0] / 255f;
                float g_base_1 = arrf_base_1[1] / 255f;
                float b_base_1 = arrf_base_1[2] / 255f;
                SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, addBaseLocation_1, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r_base_1, g_base_1, b_base_1);
                int[] arrf_1 = Color.colorStringToRGBInt(SkinColorHave);
                float r_1 = arrf_1[0] / 255f;
                float g_1 = arrf_1[1] / 255f;
                float b_1 = arrf_1[2] / 255f;
                SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, addLocation_1, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r_1, g_1, b_1);
            }
            //附加_2
            if (((SkinEntity)t).AddType_2() > 0) {
                //附加基础
                int[] arrf_base_2 = Color.colorStringToRGBInt("ffffff");
                float r_base_2 = arrf_base_2[0] / 255f;
                float g_base_2 = arrf_base_2[1] / 255f;
                float b_base_2 = arrf_base_2[2] / 255f;
                SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, addBaseLocation_2, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r_base_2, g_base_2, b_base_2);
                int[] arrf_2 = Color.colorStringToRGBInt(SkinColorHave);
                float r_2 = arrf_2[0] / 255f;
                float g_2 = arrf_2[1] / 255f;
                float b_2 = arrf_2[2] / 255f;
                SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, addLocation_2, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r_2, g_2, b_2);
            }
            //附加_3
            if (((SkinEntity)t).AddType_3() > 0) {
                //附加基础
                int[] arrf_base_3 = Color.colorStringToRGBInt("ffffff");
                float r_base_3 = arrf_base_3[0] / 255f;
                float g_base_3 = arrf_base_3[1] / 255f;
                float b_base_3 = arrf_base_3[2] / 255f;
                SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, addBaseLocation_3, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r_base_3, g_base_3, b_base_3);
                int[] arrf_3 = Color.colorStringToRGBInt(SkinColorHave);
                float r_3 = arrf_3[0] / 255f;
                float g_3 = arrf_3[1] / 255f;
                float b_3 = arrf_3[2] / 255f;
                SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, addLocation_3, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r_3, g_3, b_3);
            }
        }
        //上衣
        if (((SkinEntity)t).JacketType() > 0 && ((SkinEntity)t).JacketColor() > 0) {
            String ClothesColor;
            int colors = ((SkinEntity)t).JacketColor();
            if (t instanceof BaseHagEntity) {
                if (colors == 1) {
                    ClothesColor = "d0d0d0";
                } else if (colors == 2) {
                    ClothesColor = "777777";
                } else if (colors == 3) {
                    ClothesColor = "4b4c4a";
                } else if (colors == 4) {
                    ClothesColor = "202020";
                } else if (colors == 5) {
                    ClothesColor = "92a990";
                } else if (colors == 6) {
                    ClothesColor = "60755f";
                } else if (colors == 7) {
                    ClothesColor = "2f402e";
                } else if (colors == 8) {
                    ClothesColor = "132511";
                } else if (colors == 9) {
                    ClothesColor = "746b63";
                } else if (colors == 10) {
                    ClothesColor = "4a4642";
                } else if (colors == 11) {
                    ClothesColor = "2f2d2a";
                } else if (colors == 12) {
                    ClothesColor = "221f1c";
                } else if (colors == 13) {
                    ClothesColor = "7d6b5c";
                } else if (colors == 14) {
                    ClothesColor = "4e3d2f";
                } else if (colors == 15) {
                    ClothesColor = "3c2715";
                } else if (colors == 16) {
                    ClothesColor = "180e06";
                } else {
                    ClothesColor = "352227";
                }
            }
            else if (t instanceof SpirveEntity) {
                ClothesColor = "361b0f";
            }
            else {
                ClothesColor = "ffffff";
            }
            ClothesColorHave = ClothesColor;
            int[] arrf_base_1 = Color.colorStringToRGBInt("ffffff");
            float r_base_1 = arrf_base_1[0] / 255f;
            float g_base_1 = arrf_base_1[1] / 255f;
            float b_base_1 = arrf_base_1[2] / 255f;
            SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, jacketBaseLocation, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r_base_1, g_base_1, b_base_1);
            int[] arrf_1 = Color.colorStringToRGBInt(ClothesColor);
            float r_1 = arrf_1[0] / 255f;
            float g_1 = arrf_1[1] / 255f;
            float b_1 = arrf_1[2] / 255f;
            SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, jacketLocation, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r_1, g_1, b_1);
        }
        //裤子
        if (((SkinEntity)t).PantsType() > 0 && ((SkinEntity)t).PantsColor() > 0) {
            String ClothesColor;
            int colors = ((SkinEntity)t).PantsColor();
            if (t instanceof BaseHagEntity) {
                if (colors == 1) {
                    ClothesColor = "d0d0d0";
                } else if (colors == 2) {
                    ClothesColor = "777777";
                } else if (colors == 3) {
                    ClothesColor = "4b4c4a";
                } else if (colors == 4) {
                    ClothesColor = "202020";
                } else if (colors == 5) {
                    ClothesColor = "92a990";
                } else if (colors == 6) {
                    ClothesColor = "60755f";
                } else if (colors == 7) {
                    ClothesColor = "2f402e";
                } else if (colors == 8) {
                    ClothesColor = "132511";
                } else if (colors == 9) {
                    ClothesColor = "746b63";
                } else if (colors == 10) {
                    ClothesColor = "4a4642";
                } else if (colors == 11) {
                    ClothesColor = "2f2d2a";
                } else if (colors == 12) {
                    ClothesColor = "221f1c";
                } else if (colors == 13) {
                    ClothesColor = "7d6b5c";
                } else if (colors == 14) {
                    ClothesColor = "4e3d2f";
                } else if (colors == 15) {
                    ClothesColor = "3c2715";
                } else if (colors == 16) {
                    ClothesColor = "180e06";
                } else {
                    ClothesColor = "352227";
                }
            }
            else if (t instanceof SpirveEntity) {
                ClothesColor = "361b0f";
            }
            else {
                ClothesColor = "ffffff";
            }
            int[] arrf_base_1 = Color.colorStringToRGBInt("ffffff");
            float r_base_1 = arrf_base_1[0] / 255f;
            float g_base_1 = arrf_base_1[1] / 255f;
            float b_base_1 = arrf_base_1[2] / 255f;
            SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, pantsBaseLocation, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r_base_1, g_base_1, b_base_1);
            int[] arrf_1 = Color.colorStringToRGBInt(ClothesColor);
            float r_1 = arrf_1[0] / 255f;
            float g_1 = arrf_1[1] / 255f;
            float b_1 = arrf_1[2] / 255f;
            SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, pantsLocation, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r_1, g_1, b_1);
        }
        //手套
        if (((SkinEntity)t).GlovesType() > 0 && ((SkinEntity)t).GlovesColor() > 0) {
            String ClothesColor;
            int colors = ((SkinEntity)t).GlovesColor();
            if (t instanceof BaseHagEntity) {
                if (colors == 1) {
                    ClothesColor = "d0d0d0";
                } else if (colors == 2) {
                    ClothesColor = "777777";
                } else if (colors == 3) {
                    ClothesColor = "4b4c4a";
                } else if (colors == 4) {
                    ClothesColor = "202020";
                } else if (colors == 5) {
                    ClothesColor = "92a990";
                } else if (colors == 6) {
                    ClothesColor = "60755f";
                } else if (colors == 7) {
                    ClothesColor = "2f402e";
                } else if (colors == 8) {
                    ClothesColor = "132511";
                } else if (colors == 9) {
                    ClothesColor = "746b63";
                } else if (colors == 10) {
                    ClothesColor = "4a4642";
                } else if (colors == 11) {
                    ClothesColor = "2f2d2a";
                } else if (colors == 12) {
                    ClothesColor = "221f1c";
                } else if (colors == 13) {
                    ClothesColor = "7d6b5c";
                } else if (colors == 14) {
                    ClothesColor = "4e3d2f";
                } else if (colors == 15) {
                    ClothesColor = "3c2715";
                } else if (colors == 16) {
                    ClothesColor = "180e06";
                } else {
                    ClothesColor = "352227";
                }
            }
            else if (t instanceof SpirveEntity) {
                ClothesColor = "361b0f";
            }
            else {
                ClothesColor = "ffffff";
            }
            int[] arrf_base_1 = Color.colorStringToRGBInt("ffffff");
            float r_base_1 = arrf_base_1[0] / 255f;
            float g_base_1 = arrf_base_1[1] / 255f;
            float b_base_1 = arrf_base_1[2] / 255f;
            SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, glovesBaseLocation, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r_base_1, g_base_1, b_base_1);
            int[] arrf_1 = Color.colorStringToRGBInt(ClothesColor);
            float r_1 = arrf_1[0] / 255f;
            float g_1 = arrf_1[1] / 255f;
            float b_1 = arrf_1[2] / 255f;
            SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, glovesLocation, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r_1, g_1, b_1);
        }
        //头发
        if (((SkinEntity)t).HairType() > 0 && ((SkinEntity)t).HairColor() > 0) {
            String HairColor;
            //发色
            if (t instanceof BaseHagEntity) {
                if (((SkinEntity) t).HairColor() == 1) {
                    HairColor = "ffffff";
                } else if (((SkinEntity) t).HairColor() == 2) {
                    HairColor = "f4f4f4";
                } else if (((SkinEntity) t).HairColor() == 3) {
                    HairColor = "e3e3e3";
                } else if (((SkinEntity) t).HairColor() == 4) {
                    HairColor = "d1d1d1";
                } else if (((SkinEntity) t).HairColor() == 5) {
                    HairColor = "c8c8c8";
                } else if (((SkinEntity) t).HairColor() == 6) {
                    HairColor = "c1c1c1";
                } else if (((SkinEntity) t).HairColor() == 7) {
                    HairColor = "b8b8b8";
                } else if (((SkinEntity) t).HairColor() == 8) {
                    HairColor = "aaaaaa";
                } else if (((SkinEntity) t).HairColor() == 9) {
                    HairColor = "a4a4a4";
                } else if (((SkinEntity) t).HairColor() == 10) {
                    HairColor = "9e9e9e";
                } else if (((SkinEntity) t).HairColor() == 11) {
                    HairColor = "959595";
                } else if (((SkinEntity) t).HairColor() == 12) {
                    HairColor = "8a8a8a";
                } else if (((SkinEntity) t).HairColor() == 13) {
                    HairColor = "6a6a6a";
                } else if (((SkinEntity) t).HairColor() == 14) {
                    HairColor = "555555";
                } else if (((SkinEntity) t).HairColor() == 15) {
                    HairColor = "3b3b3b";
                } else if (((SkinEntity) t).HairColor() == 16) {
                    HairColor = "0e0e0e";
                } else {
                    HairColor = "352227";
                }
            }
            else if (t instanceof SpirveEntity) {
                HairColor = "1c1c1c";
            }
            else {
                HairColor = "000000";
            }
            int[] arrf = Color.colorStringToRGBInt(HairColor);
            float r = arrf[0] / 255f;
            float g = arrf[1] / 255f;
            float b = arrf[2] / 255f;
            SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, hairLocation, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r, g, b);
        }
        //饰品
        if (!SkinColorHave.equals("null")) {
        //饰品_1
            if (((SkinEntity)t).BaubleType_1() > 0) {
                //饰品基础
                int[] arrf_base_1 = Color.colorStringToRGBInt("ffffff");
                float r_base_1 = arrf_base_1[0] / 255f;
                float g_base_1 = arrf_base_1[1] / 255f;
                float b_base_1 = arrf_base_1[2] / 255f;
                SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, baubleBaseLocation_1, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r_base_1, g_base_1, b_base_1);
                int[] arrf_1 = Color.colorStringToRGBInt(ClothesColorHave);
                float r_1 = arrf_1[0] / 255f;
                float g_1 = arrf_1[1] / 255f;
                float b_1 = arrf_1[2] / 255f;
                SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, baubleLocation_1, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r_1, g_1, b_1);
            }
            //饰品_2
            if (((SkinEntity)t).BaubleType_2() > 0) {
                //饰品基础
                int[] arrf_base_2 = Color.colorStringToRGBInt("ffffff");
                float r_base_2 = arrf_base_2[0] / 255f;
                float g_base_2 = arrf_base_2[1] / 255f;
                float b_base_2 = arrf_base_2[2] / 255f;
                SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, baubleBaseLocation_2, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r_base_2, g_base_2, b_base_2);
                int[] arrf_2 = Color.colorStringToRGBInt(ClothesColorHave);
                float r_2 = arrf_2[0] / 255f;
                float g_2 = arrf_2[1] / 255f;
                float b_2 = arrf_2[2] / 255f;
                SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, baubleLocation_2, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r_2, g_2, b_2);
            }
            //饰品_3
            if (((SkinEntity)t).BaubleType_3() > 0) {
                //饰品基础
                int[] arrf_base_3 = Color.colorStringToRGBInt("ffffff");
                float r_base_3 = arrf_base_3[0] / 255f;
                float g_base_3 = arrf_base_3[1] / 255f;
                float b_base_3 = arrf_base_3[2] / 255f;
                SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, baubleBaseLocation_3, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r_base_3, g_base_3, b_base_3);
                int[] arrf_3 = Color.colorStringToRGBInt(ClothesColorHave);
                float r_3 = arrf_3[0] / 255f;
                float g_3 = arrf_3[1] / 255f;
                float b_3 = arrf_3[2] / 255f;
                SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, baubleLocation_3, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r_3, g_3, b_3);
            }
        }
        //鞋子
        if (((SkinEntity)t).ShoesType() > 0 && ((SkinEntity)t).ShoesColor() > 0) {
            String ClothesColor;
            int colors = ((SkinEntity)t).ShoesColor();
            if (t instanceof BaseHagEntity) {
                if (colors == 1) {
                    ClothesColor = "d0d0d0";
                } else if (colors == 2) {
                    ClothesColor = "777777";
                } else if (colors == 3) {
                    ClothesColor = "4b4c4a";
                } else if (colors == 4) {
                    ClothesColor = "202020";
                } else if (colors == 5) {
                    ClothesColor = "92a990";
                } else if (colors == 6) {
                    ClothesColor = "60755f";
                } else if (colors == 7) {
                    ClothesColor = "2f402e";
                } else if (colors == 8) {
                    ClothesColor = "132511";
                } else if (colors == 9) {
                    ClothesColor = "746b63";
                } else if (colors == 10) {
                    ClothesColor = "4a4642";
                } else if (colors == 11) {
                    ClothesColor = "2f2d2a";
                } else if (colors == 12) {
                    ClothesColor = "221f1c";
                } else if (colors == 13) {
                    ClothesColor = "7d6b5c";
                } else if (colors == 14) {
                    ClothesColor = "4e3d2f";
                } else if (colors == 15) {
                    ClothesColor = "3c2715";
                } else if (colors == 16) {
                    ClothesColor = "180e06";
                } else {
                    ClothesColor = "352227";
                }
            }
            else if (t instanceof SpirveEntity) {
                ClothesColor = "361b0f";
            }
            else {
                ClothesColor = "ffffff";
            }
            int[] arrf_base_1 = Color.colorStringToRGBInt("ffffff");
            float r_base_1 = arrf_base_1[0] / 255f;
            float g_base_1 = arrf_base_1[1] / 255f;
            float b_base_1 = arrf_base_1[2] / 255f;
            SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, shoesBaseLocation, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r_base_1, g_base_1, b_base_1);
            int[] arrf_1 = Color.colorStringToRGBInt(ClothesColor);
            float r_1 = arrf_1[0] / 255f;
            float g_1 = arrf_1[1] / 255f;
            float b_1 = arrf_1[2] / 255f;
            SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, shoesLocation, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r_1, g_1, b_1);
        }
        //帽子
        if (((SkinEntity)t).HatType() > 0 && ((SkinEntity)t).HatColor() > 0 && !t.hasItemInSlot(EquipmentSlot.HEAD)) {
            String ClothesColor;
            int colors = ((SkinEntity)t).HatColor();
            if (t instanceof BaseHagEntity) {
                if (colors == 1) {
                    ClothesColor = "d0d0d0";
                } else if (colors == 2) {
                    ClothesColor = "777777";
                } else if (colors == 3) {
                    ClothesColor = "4b4c4a";
                } else if (colors == 4) {
                    ClothesColor = "202020";
                } else if (colors == 5) {
                    ClothesColor = "92a990";
                } else if (colors == 6) {
                    ClothesColor = "60755f";
                } else if (colors == 7) {
                    ClothesColor = "2f402e";
                } else if (colors == 8) {
                    ClothesColor = "132511";
                } else if (colors == 9) {
                    ClothesColor = "746b63";
                } else if (colors == 10) {
                    ClothesColor = "4a4642";
                } else if (colors == 11) {
                    ClothesColor = "2f2d2a";
                } else if (colors == 12) {
                    ClothesColor = "221f1c";
                } else if (colors == 13) {
                    ClothesColor = "7d6b5c";
                } else if (colors == 14) {
                    ClothesColor = "4e3d2f";
                } else if (colors == 15) {
                    ClothesColor = "3c2715";
                } else if (colors == 16) {
                    ClothesColor = "180e06";
                } else {
                    ClothesColor = "352227";
                }
            }
            else {
                ClothesColor = "ffffff";
            }
            int[] arrf_base_1 = Color.colorStringToRGBInt("ffffff");
            float r_base_1 = arrf_base_1[0] / 255f;
            float g_base_1 = arrf_base_1[1] / 255f;
            float b_base_1 = arrf_base_1[2] / 255f;
            SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, hatBaseLocation, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r_base_1, g_base_1, b_base_1);
            int[] arrf_1 = Color.colorStringToRGBInt(ClothesColor);
            float r_1 = arrf_1[0] / 255f;
            float g_1 = arrf_1[1] / 255f;
            float b_1 = arrf_1[2] / 255f;
            SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, hatLocation, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r_1, g_1, b_1);
        }
        //大衣
        if (((SkinEntity)t).OvercoatType() > 0 && ((SkinEntity)t).OvercoatColor() > 0) {
            String ClothesColor;
            int colors = ((SkinEntity)t).OvercoatColor();
            if (t instanceof BaseHagEntity) {
                if (colors == 1) {
                    ClothesColor = "d0d0d0";
                } else if (colors == 2) {
                    ClothesColor = "777777";
                } else if (colors == 3) {
                    ClothesColor = "4b4c4a";
                } else if (colors == 4) {
                    ClothesColor = "202020";
                } else if (colors == 5) {
                    ClothesColor = "92a990";
                } else if (colors == 6) {
                    ClothesColor = "60755f";
                } else if (colors == 7) {
                    ClothesColor = "2f402e";
                } else if (colors == 8) {
                    ClothesColor = "132511";
                } else if (colors == 9) {
                    ClothesColor = "746b63";
                } else if (colors == 10) {
                    ClothesColor = "4a4642";
                } else if (colors == 11) {
                    ClothesColor = "2f2d2a";
                } else if (colors == 12) {
                    ClothesColor = "221f1c";
                } else if (colors == 13) {
                    ClothesColor = "7d6b5c";
                } else if (colors == 14) {
                    ClothesColor = "4e3d2f";
                } else if (colors == 15) {
                    ClothesColor = "3c2715";
                } else if (colors == 16) {
                    ClothesColor = "180e06";
                } else {
                    ClothesColor = "352227";
                }
            }
            else if (t instanceof SpirveEntity) {
                ClothesColor = "361b0f";
            }
            else {
                ClothesColor = "ffffff";
            }
            int[] arrf_base_1 = Color.colorStringToRGBInt("ffffff");
            float r_base_1 = arrf_base_1[0] / 255f;
            float g_base_1 = arrf_base_1[1] / 255f;
            float b_base_1 = arrf_base_1[2] / 255f;
            SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, overcoatBaseLocation, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r_base_1, g_base_1, b_base_1);
            int[] arrf_1 = Color.colorStringToRGBInt(ClothesColor);
            float r_1 = arrf_1[0] / 255f;
            float g_1 = arrf_1[1] / 255f;
            float b_1 = arrf_1[2] / 255f;
            SkinEntityBodyLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, overcoatLocation, poseStack, multiBufferSource, n, t, f, f2, f4, f5, f6, f3, r_1, g_1, b_1);
        }
    }
}

