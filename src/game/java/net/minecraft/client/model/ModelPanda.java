package net.minecraft.client.model;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper; // 1.8 equivalent of Mth

//used ai maybe i'll become better at writing code for mobs.
public class PandaModel extends ModelBase { 
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer rightHindLeg;
    public ModelRenderer leftHindLeg;
    public ModelRenderer rightFrontLeg;
    public ModelRenderer leftFrontLeg;

    public ModelPanda() {
        this.textureWidth = 64;
        this.textureHeight = 64;

        // Head setup
        this.head = new ModelRenderer(this, 0, 6);
        this.head.addBox(-6.5F, -5.0F, -4.0F, 13, 10, 9);
        this.head.setRotationPoint(0.0F, 11.5F, -17.0F);
        this.head.setTextureOffset(45, 16).addBox("nose", -3.5F, 0.0F, -6.0F, 7, 5, 2);
        this.head.setTextureOffset(52, 25).addBox("left_ear", 3.5F, -8.0F, -1.0F, 5, 4, 1);
        this.head.setTextureOffset(52, 25).addBox("right_ear", -8.5F, -8.0F, -1.0F, 5, 4, 1);
        
        // Body setup
        this.body = new ModelRenderer(this, 0, 25);
        this.body.addBox(-9.5F, -13.0F, -6.5F, 19, 26, 13);
        this.body.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.body.rotateAngleX = (float) (Math.PI / 2);

        // Legs setup (adjust points as needed for 1.8 coordinates)
        // In 1.8, leg models usually have the rotation point at the connection to the body/ground
        this.rightHindLeg = new ModelRenderer(this, 40, 0);
        this.rightHindLeg.addBox(-3.0F, 0.0F, -3.0F, 6, 9, 6);
        this.rightHindLeg.setRotationPoint(-5.5F, 15.0F, 9.0F);

        this.leftHindLeg = new ModelRenderer(this, 40, 0);
        this.leftHindLeg.addBox(-3.0F, 0.0F, -3.0F, 6, 9, 6);
        this.leftHindLeg.setRotationPoint(5.5F, 15.0F, 9.0F);

        this.rightFrontLeg = new ModelRenderer(this, 40, 0);
        this.rightFrontLeg.addBox(-3.0F, 0.0F, -3.0F, 6, 9, 6);
        this.rightFrontLeg.setRotationPoint(-5.5F, 15.0F, -9.0F);

        this.leftFrontLeg = new ModelRenderer(this, 40, 0);
        this.leftFrontLeg.addBox(-3.0F, 0.0F, -3.0F, 6, 9, 6);
        this.leftFrontLeg.setRotationPoint(5.5F, 15.0F, -9.0F);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        // Reset rotations for standard movement
        this.head.rotateAngleZ = 0.0F;
        this.rightFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightHindLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leftHindLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

    }

    @Override
    // The 1.8 method to render the model
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        this.head.render(scale);
        this.body.render(scale);
        this.rightHindLeg.render(scale);
        this.leftHindLeg.render(scale);
        this.rightFrontLeg.render(scale);
        this.leftFrontLeg.render(scale);
    }
}

