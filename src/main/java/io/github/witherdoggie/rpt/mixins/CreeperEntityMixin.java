package io.github.witherdoggie.rpt.mixins;


import io.github.witherdoggie.rpt.accessors.CreeperEntityInterface;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(CreeperEntity.class)
public class CreeperEntityMixin extends MobEntity implements CreeperEntityInterface {

    private static TrackedData<Boolean> FROM_EGG;

    protected CreeperEntityMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void addFlight(EntityType<? extends CreeperEntity> entityType, World world, CallbackInfo ci){

        this.moveControl = new FlightMoveControl(this, 20, true);
        this.navigation = new BirdNavigation(this, world);
    }

    @Inject(method = "createCreeperAttributes", at = @At("RETURN"))
    private static void createCreeperAttributes(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) {
        cir.getReturnValue().add(EntityAttributes.GENERIC_FLYING_SPEED, 30.0);
    }

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void addToStatic(CallbackInfo callbackInfo){
        FROM_EGG = DataTracker.registerData(CreeperEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    }

    @Inject(method = "initDataTracker", at = @At("TAIL"))
    private void addFromEgg(CallbackInfo callbackInfo){
        this.dataTracker.startTracking(FROM_EGG, false);
    }

    @Inject(method = "writeCustomDataToTag", at = @At("TAIL"))
    private void addToTag(CompoundTag tag, CallbackInfo callbackInfo){
        tag.putBoolean("fromEgg", this.getFromEgg());
    }

    @Inject(method = "readCustomDataFromTag", at = @At("TAIL"))
    private void readFromTag(CompoundTag tag, CallbackInfo callbackInfo){
        this.dataTracker.set(FROM_EGG, tag.getBoolean("fromEgg"));
    }

    @ModifyArgs(method = "explode", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;createExplosion(Lnet/minecraft/entity/Entity;DDDFLnet/minecraft/world/explosion/Explosion$DestructionType;)Lnet/minecraft/world/explosion/Explosion;"))
    private void modifyBlockDamage(Args args){
        Explosion.DestructionType type = this.getFromEgg() ? Explosion.DestructionType.NONE : Explosion.DestructionType.DESTROY;
        args.set(5, type);
    }

    public boolean getFromEgg() {
        return this.dataTracker.get(FROM_EGG);
    }

    @Override
    public void setFromEgg(boolean fromEgg) {
        this.dataTracker.set(FROM_EGG, fromEgg);
    }
}
