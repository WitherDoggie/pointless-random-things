package io.github.witherdoggie.rpt.mixins;

import net.minecraft.client.render.entity.model.EndermanEntityModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(EndermanEntityModel.class)
public class EndermanEntityModelMixin {

    @ModifyArgs(method = "<init>(F)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/entity/model/BipedEntityModel;<init>(FFII)V"))
    private static void changeBody(Args args){
        args.set(0, 10.0f);
    }
}
