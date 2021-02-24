package io.github.witherdoggie.rpt.item.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class OkhoArmorMaterial implements ArmorMaterial {

    private static final int [] BASE_DURABILITY = new int [] {20, 20, 20, 20};
    private static final int [] BASE_PROTECTION = new int [] {4, 7, 9, 4};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * 37;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return BASE_PROTECTION[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.CACTUS);
    }

    @Override
    public String getName() {
        return "okho";
    }

    @Override
    public float getToughness() {
        return 3.0F;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.8F;
    }
}

