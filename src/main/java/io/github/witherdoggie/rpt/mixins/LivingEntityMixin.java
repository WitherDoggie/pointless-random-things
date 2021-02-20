package io.github.witherdoggie.rpt.mixins;

import io.github.witherdoggie.rpt.item.ItemRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "applyFoodEffects", at=@At("HEAD"))
    public void newList(ItemStack stack, World world, LivingEntity targetEntity, CallbackInfo ci){
        Random rand = new Random();
        if(!world.isClient()) {
            if (stack.getItem().equals(ItemRegistry.RANDOM_POTATO)) {
                targetEntity.addStatusEffect(new StatusEffectInstance(StatusEffect.byRawId(rand.nextInt(31) + 1), 100, 0));
            }
        }
    }
}
