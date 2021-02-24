package io.github.witherdoggie.rpt.mixins;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BeeEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BeeEntityModel.class)
public class BeeEntityModelMixin extends AnimalModelMixin{

    @Override
    protected void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha, CallbackInfo ci){
        matrices.scale(10.0f, 10.0f, 10.0f);
        matrices.translate(0.0D, -5.0D, 0.0D);
    }
}
