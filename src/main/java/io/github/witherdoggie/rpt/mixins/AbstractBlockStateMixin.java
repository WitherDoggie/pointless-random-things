package io.github.witherdoggie.rpt.mixins;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractBlock.AbstractBlockState.class)
public class AbstractBlockStateMixin {

    @Inject(method = "onEntityCollision", at = @At("TAIL"))
    private void burnPlayer(World world, BlockPos pos, Entity entity, CallbackInfo ci){
        if(entity instanceof PlayerEntity && world.getBlockState(pos).getBlock() == Blocks.GRASS){
            entity.setOnFireFor(2);
        }
    }
}
