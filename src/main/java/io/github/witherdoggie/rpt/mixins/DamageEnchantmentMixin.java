package io.github.witherdoggie.rpt.mixins;

import net.minecraft.enchantment.DamageEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DamageEnchantment.class)
public class DamageEnchantmentMixin {

    @Inject(method = "getMaxLevel", at = @At("RETURN"), cancellable = true)
    private void maxLevel(CallbackInfoReturnable<Integer> cir){
         cir.setReturnValue(10);
    }
}
