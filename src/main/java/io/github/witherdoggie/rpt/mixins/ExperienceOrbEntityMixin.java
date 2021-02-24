package io.github.witherdoggie.rpt.mixins;

import net.minecraft.entity.ExperienceOrbEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ExperienceOrbEntity.class)
public class ExperienceOrbEntityMixin {

    @Inject(method = "getMendingRepairAmount", at = @At("RETURN"), cancellable = true)
    private void getMendingRepairAmount(int experienceAmount, CallbackInfoReturnable cir){
        cir.setReturnValue(experienceAmount * 100);
    }
}
