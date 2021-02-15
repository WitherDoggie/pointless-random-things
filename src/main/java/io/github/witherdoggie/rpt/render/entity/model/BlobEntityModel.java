package io.github.witherdoggie.rpt.render.entity.model;

import io.github.witherdoggie.rpt.entity.BlobEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class BlobEntityModel extends EntityModel<BlobEntity> {
    private final ModelPart bb_main;

    public BlobEntityModel() {
		    textureWidth = 64;
		    textureHeight = 64;
		    bb_main = new ModelPart(this);
		    bb_main.setPivot(0.0F, 24.0F, 0.0F);
		    bb_main.setTextureOffset(0, 0).addCuboid(-2.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		    bb_main.setTextureOffset(0, 0).addCuboid(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		    bb_main.setTextureOffset(0, 0).addCuboid(-2.0F, -4.0F, -1.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
    }

    @Override
    public void setAngles(BlobEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){

    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

        matrixStack.scale(2.0F, 2.0F, 2.0F);
        matrixStack.translate(0, -0.75F, 0);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
    }
}