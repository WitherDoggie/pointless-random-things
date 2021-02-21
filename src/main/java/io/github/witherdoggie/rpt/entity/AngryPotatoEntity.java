package io.github.witherdoggie.rpt.entity;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class AngryPotatoEntity extends AnimalEntity {

    private static TrackedData<Integer> POTATO_TYPE;

    protected AngryPotatoEntity(EntityType<? extends AngryPotatoEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initGoals() {

        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.8D));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.targetSelector.add(1, new FollowTargetGoal(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new RevengeGoal(this, new Class[0]));
    }

    public static DefaultAttributeContainer.Builder createAngryPotatoAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.40D);
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(POTATO_TYPE, 0);
    }

    @Override
    protected void initEquipment(LocalDifficulty difficulty) {
        System.out.println("TEST");
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable CompoundTag entityTag) {
        int i = this.chooseType();

        if (entityData instanceof AngryPotatoEntity.PotatoData) {
            i = ((AngryPotatoEntity.PotatoData)entityData).type;
        } else {
            entityData = new AngryPotatoEntity.PotatoData(i);
        }

        this.setPotatoType(i);
        this.initEquipment(difficulty);
        return super.initialize(world, difficulty, spawnReason, (EntityData)entityData, entityTag);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    private int chooseType(){
        Random rand = new Random();
        return rand.nextInt(9);
    }

    public void setPotatoType(int potatoType) {
        this.dataTracker.set(POTATO_TYPE, potatoType);
    }

    public int getPotatoType() {
        return this.dataTracker.get(POTATO_TYPE);
    }

    public void writeCustomDataToTag(CompoundTag tag) {
        super.writeCustomDataToTag(tag);
        tag.putInt("PotatoType", this.getPotatoType());
    }

    public void readCustomDataFromTag(CompoundTag tag) {
        super.readCustomDataFromTag(tag);
        this.setPotatoType(tag.getInt("PotatoType"));
    }

    static {
        POTATO_TYPE = DataTracker.registerData(AngryPotatoEntity.class, TrackedDataHandlerRegistry.INTEGER);
    }

    public static class PotatoData extends PassiveEntity.PassiveData {
        public final int type;

        public PotatoData(int type) {
            super(1.0F);
            this.type = type;
        }
    }
}
