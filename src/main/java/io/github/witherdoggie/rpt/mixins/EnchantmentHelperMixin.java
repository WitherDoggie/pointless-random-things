package io.github.witherdoggie.rpt.mixins;


import net.minecraft.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {

    @Inject(method = "getLevel", at = @At("RETURN"), cancellable = true)
    private static void maxLevel(CallbackInfoReturnable<Integer> cir){
        cir.setReturnValue(320000000);
    }
}
