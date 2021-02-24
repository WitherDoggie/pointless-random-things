package io.github.witherdoggie.rpt.mixins;

import net.minecraft.block.BlockState;
import net.minecraft.block.CactusBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CactusBlock.class)
public class CactusBlockMixin {

    @Inject(method = "onEntityCollision", at = @At("TAIL"))
    private void killPlayer(BlockState state, World world, BlockPos pos, Entity entity, CallbackInfo ci){
        entity.damage(DamageSource.CACTUS, 100.0f);
    }
}
