package io.github.witherdoggie.rpt.mixins;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Arm;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void adamantiteArmourSpeed(CallbackInfo ci){

        Item helmet = getEquippedStack(EquipmentSlot.HEAD).getItem();
        Item chest = getEquippedStack(EquipmentSlot.CHEST).getItem();
        Item legs = getEquippedStack(EquipmentSlot.LEGS).getItem();
        Item boots = getEquippedStack(EquipmentSlot.FEET).getItem();

        if(helmet == Items.DIAMOND_HELMET && chest == Items.DIAMOND_CHESTPLATE && legs == Items.DIAMOND_LEGGINGS && boots == Items.DIAMOND_BOOTS){
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 42, 3, false, false));
        }
    }

    @ModifyVariable(method = "attack", name = "bl4", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/EnchantmentHelper;getFireAspect(Lnet/minecraft/entity/LivingEntity;)I"))
    private boolean sweepingIfEnchant(boolean bl4) {
        return bl4 && (EnchantmentHelper.getSweepingMultiplier((PlayerEntity)(Object)this) > 0);
    }
}