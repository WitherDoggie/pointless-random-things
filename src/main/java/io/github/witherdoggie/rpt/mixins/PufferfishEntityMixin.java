package io.github.witherdoggie.rpt.mixins;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PufferfishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PufferfishEntity.class)
public class PufferfishEntityMixin extends MobEntity {
    protected PufferfishEntityMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "onPlayerCollision", at = @At("TAIL"))
    private void sting(PlayerEntity player, CallbackInfo ci){
        player.damage(DamageSource.sting(this), 100.0f);
    }
}
