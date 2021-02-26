package io.github.witherdoggie.rpt.mixins;

import io.github.witherdoggie.rpt.accessors.ChickenEntityInterface;
import io.github.witherdoggie.rpt.render.entity.goal.ChickenIgniteGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChickenEntity.class)
public class ChickenEntityMixin extends AnimalEntity implements ChickenEntityInterface {

    private static TrackedData<Boolean> IGNITE;
    private static TrackedData<Integer> FUSE;
    private int lastFuseTime;
    private int currentFuseTime;
    private int fuseTime = 30;

    protected ChickenEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    private void explode() {
        if (!this.world.isClient) {
            Explosion.DestructionType destructionType = this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING) ? Explosion.DestructionType.DESTROY : Explosion.DestructionType.NONE;
            this.dead = true;
            this.world.createExplosion(this, this.getX(), this.getY(), this.getZ(), (float)4.0, destructionType);
            this.remove();
        }
    }

    @Override
    public void tick() {
        if (this.isAlive()) {
            this.lastFuseTime = this.currentFuseTime;

            int i = this.getFuseSpeed();
            if (i > 0 && this.currentFuseTime == 0) {
                this.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0F, 0.5F);
            }

            if (this.getIgnited()) {
                this.setFuseSpeed(1);
            }

            this.currentFuseTime += i;
            if (this.currentFuseTime < 0) {
                this.currentFuseTime = 0;
            }

            if (this.currentFuseTime >= this.fuseTime) {
                this.currentFuseTime = this.fuseTime;
                this.explode();
            }
        }

        super.tick();
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(IGNITE, false);
        this.dataTracker.startTracking(FUSE, -1);
    }

    public int getFuseSpeed() {
        return (Integer)this.dataTracker.get(FUSE);
    }

    public void setFuseSpeed(int fuseSpeed) {
        this.dataTracker.set(FUSE, fuseSpeed);
    }

    public boolean getIgnited() {
        return (Boolean)this.dataTracker.get(IGNITE);
    }

    public void ignite() {
        this.dataTracker.set(IGNITE, true);
    }

    @Inject(method = "initGoals", at = @At("HEAD"))
    private void addExplosionGoal(CallbackInfo ci){
        this.goalSelector.add(2, new ChickenIgniteGoal((ChickenEntity)(Object)this));
        this.goalSelector.add(4, new MeleeAttackGoal(this, 1.0D, false));
        this.targetSelector.add(1, new FollowTargetGoal(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new RevengeGoal(this, new Class[0]));
    }

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void injectIntoClientInit(CallbackInfo ci){
        IGNITE = DataTracker.registerData(ChickenEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
        FUSE = DataTracker.registerData(ChickenEntity.class, TrackedDataHandlerRegistry.INTEGER);
    }

    @Inject(method = "writeCustomDataToTag", at = @At("TAIL"))
    private void addToTag(CompoundTag tag, CallbackInfo callbackInfo){
        tag.putBoolean("ignited", this.getIgnited());
        tag.putShort("Fuse", (short)this.fuseTime);
    }

    @Inject(method = "readCustomDataFromTag", at = @At("TAIL"))
    private void readFromTag(CompoundTag tag, CallbackInfo callbackInfo){
        if (tag.contains("Fuse", 99)) {
            this.fuseTime = tag.getShort("Fuse");
        }

        if (tag.getBoolean("ignited")) {
            this.ignite();
        }
    }
}
