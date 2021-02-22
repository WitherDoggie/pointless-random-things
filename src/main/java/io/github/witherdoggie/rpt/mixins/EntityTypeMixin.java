package io.github.witherdoggie.rpt.mixins;

import io.github.witherdoggie.rpt.accessors.CreeperEntityInterface;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(EntityType.class)
public abstract class EntityTypeMixin {

    @ModifyArgs(
            method = "<clinit>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/EntityType$Builder;setDimensions(FF)Lnet/minecraft/entity/EntityType$Builder;"
            ),
            slice = @Slice(
            from = @At(
                    value = "CONSTANT",
                    args = "stringValue=pig"
            ),
            to = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/entity/EntityType;PIG:Lnet/minecraft/entity/EntityType;",
                    opcode = Opcodes.PUTSTATIC
            )
        )
    )
    private static void dimensions(Args args){

        args.set(0, 10.0f);
        args.set(1, 10.0f);
    }

    @Inject(method = "spawnFromItemStack", at = @At("RETURN"))
    public void spawnFromItemStack(ServerWorld serverWorld, ItemStack stack, PlayerEntity player, BlockPos pos, SpawnReason spawnReason, boolean alignPosition, boolean invertY, CallbackInfoReturnable<Entity> cir) {
        Entity entity = cir.getReturnValue();
        if(entity instanceof CreeperEntity){
            ((CreeperEntityInterface)entity).setFromEgg(true);
        };
    }
}
