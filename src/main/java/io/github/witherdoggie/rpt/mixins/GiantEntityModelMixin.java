package io.github.witherdoggie.rpt.mixins;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.GiantEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(GiantEntityModel.class)
public class GiantEntityModelMixin extends AnimalModelMixin{

    @Override
    protected void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha, CallbackInfo callbackInfo){
        matrices.translate(0.0, -12.5, 0.0);
        matrices.scale(10.0f, 10.0f, 10.0f);
    }
}
