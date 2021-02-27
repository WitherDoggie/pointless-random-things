package io.github.witherdoggie.rpt.entity;

import com.google.common.collect.Sets;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class ChickeneerEntity extends ParrotEntity {

    private static final Set<Item> TAMING_INGREDIENTS;

    public ChickeneerEntity(EntityType<? extends ParrotEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createChickeneerAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 60.0D).add(EntityAttributes.GENERIC_FLYING_SPEED, 06000000059604645D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.40000000298023224D);
    }

    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!this.isTamed() && TAMING_INGREDIENTS.contains(itemStack.getItem())) {
            if (!player.abilities.creativeMode) {
                itemStack.decrement(1);
            }

            if (!this.isSilent()) {
                this.world.playSound((PlayerEntity)null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_PARROT_EAT, this.getSoundCategory(), 1.0F, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F);
            }

            if (!this.world.isClient) {
                if (this.random.nextInt(10) == 0) {
                    this.setOwner(player);
                    this.world.sendEntityStatus(this, (byte)7);
                } else {
                    this.world.sendEntityStatus(this, (byte)6);
                }
            }

            return ActionResult.success(this.world.isClient);

        } else if (!this.isInAir() && this.isTamed() && this.isOwner(player)) {
            if (!this.world.isClient) {
                this.setSitting(!this.isSitting());
            }

            return ActionResult.success(this.world.isClient);
        } else {
            return super.interactMob(player, hand);
        }
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    static {
        TAMING_INGREDIENTS = Sets.newHashSet(new Item[]{Items.BREAD, Items.REPEATER});
    }
}
