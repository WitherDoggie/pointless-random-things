package io.github.witherdoggie.rpt.render.entity.model;

import io.github.witherdoggie.rpt.entity.AngryPotatoEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class AngryPotatoEntityModel extends EntityModel<AngryPotatoEntity> {

    private final ModelPart body;

    public AngryPotatoEntityModel() {
        textureWidth = 64;
        textureHeight = 64;
        body = new ModelPart(this, 0, 0);
        body.setTextureOffset(0, 0).addCuboid(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 6.0F, 0.0F, false);
    }

    @Override
    public void setAngles(AngryPotatoEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        matrices.translate(0, 1.4, 0);
        body.render(matrices, vertices, light, overlay);
    }
}
