package io.github.witherdoggie.rpt.mixins;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.mob.ShulkerEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ShulkerEntity.class)
public class ShulkerEntityMixin extends GolemEntity {

    protected ShulkerEntityMixin(EntityType<? extends GolemEntity> entityType, World world) {
        super(entityType, world);
    }


}
