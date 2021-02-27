package io.github.witherdoggie.rpt.render.entity;

import io.github.witherdoggie.rpt.entity.ChickeneerEntity;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

public class ChickeneerEntityRenderer extends LivingEntityRenderer<ChickeneerEntity, PlayerEntityModel<ChickeneerEntity>> {

    public ChickeneerEntityRenderer(EntityRenderDispatcher entityRenderDispatcher, boolean arms) {
        super(entityRenderDispatcher, new PlayerEntityModel(0.0f, true), 0.5f);
    }

    public void render(ChickeneerEntity entity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(entity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(ChickeneerEntity entity) {
        return new Identifier("rpt", "textures/entity/chickeneer/chickeneer.png");
    }
}