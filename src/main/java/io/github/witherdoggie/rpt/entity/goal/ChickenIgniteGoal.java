package io.github.witherdoggie.rpt.entity.goal;

import io.github.witherdoggie.rpt.accessors.ChickenEntityInterface;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.ChickenEntity;

import java.util.EnumSet;

public class ChickenIgniteGoal extends Goal {
    private ChickenEntity chicken;
    private LivingEntity target;

    public ChickenIgniteGoal(ChickenEntity chicken) {
        this.chicken = chicken;
        this.setControls(EnumSet.of(Goal.Control.MOVE));
    }

    public boolean canStart() {
        LivingEntity livingEntity = this.chicken.getTarget();
        return ((ChickenEntityInterface)this.chicken).getFuseSpeed() > 0 || livingEntity != null && this.chicken.squaredDistanceTo(livingEntity) < 9.0D;
    }

    public void start() {
        this.chicken.getNavigation().stop();
        this.target = this.chicken.getTarget();
    }

    public void stop() {
        this.target = null;
    }

    public void tick() {
        if (this.target == null) {
            ((ChickenEntityInterface)this.chicken).setFuseSpeed(-1);
        } else if (this.chicken.squaredDistanceTo(this.target) > 49.0D) {
            ((ChickenEntityInterface)this.chicken).setFuseSpeed(-1);
        } else if (!this.chicken.getVisibilityCache().canSee(this.target)) {
            ((ChickenEntityInterface)this.chicken).setFuseSpeed(-1);
        } else {
            ((ChickenEntityInterface)this.chicken).setFuseSpeed(1);
        }
    }
}
