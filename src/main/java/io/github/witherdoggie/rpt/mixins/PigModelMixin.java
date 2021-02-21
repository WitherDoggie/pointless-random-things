package io.github.witherdoggie.rpt.mixins;

import net.minecraft.client.render.entity.model.PigEntityModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(PigEntityModel.class)
public class PigModelMixin {

    @ModifyArgs(method = "<init>(F)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/entity/model/QuadrupedEntityModel;<init>(IFZFFFFI)V"))
    private static void changeBody(Args args){
        args.set(0, 10);
        args.set(1, 50.0f);
        args.set(2, true);

    }
}
