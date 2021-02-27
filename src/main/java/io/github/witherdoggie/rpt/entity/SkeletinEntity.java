package io.github.witherdoggie.rpt.entity;

import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SkeletinEntity extends SkeletonEntity {

    public SkeletinEntity(EntityType<? extends SkeletonEntity> entityType, World world) {
        super(entityType, world);

    }

    public static DefaultAttributeContainer.Builder createSkeletinAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35D);
    }

    @Override
    protected boolean isAffectedByDaylight() {
        return false;
    }
}
