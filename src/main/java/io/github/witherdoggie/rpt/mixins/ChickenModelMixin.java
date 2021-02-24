package io.github.witherdoggie.rpt.mixins;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.ChickenEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChickenEntityModel.class)
public class ChickenModelMixin extends AnimalModelMixin{

    @Override
    protected void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha, CallbackInfo callbackInfo){
        //matrices.translate(0.0, -12.5, 0.0);
        matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(90));
        matrices.scale(10.0f, 10.0f, 10.0f);
    }
}
