package io.github.witherdoggie.rpt.mixins;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.PigEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(PigEntityModel.class)
public class PigModelMixin extends AnimalModelMixin{

    /*@ModifyArgs(method = "<init>(F)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/entity/model/QuadrupedEntityModel;<init>(IFZFFFFI)V"))
    private static void changeBody(Args args){
        args.set(0, 10);
        args.set(1, 50.0f);
        args.set(2, true);
    }*/

    @Override
    protected void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha, CallbackInfo callbackInfo){
        matrices.translate(0.0, -12.5, 0.0);
        matrices.scale(10.0f, 10.0f, 10.0f);
    }
}
