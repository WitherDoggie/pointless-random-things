package io.github.witherdoggie.rpt.item;

import io.github.witherdoggie.rpt.RandomPointlessThings;
import io.github.witherdoggie.rpt.entity.EntityRegistry;
import io.github.witherdoggie.rpt.item.armor.OkhoArmorMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {

    private static final Item  WAFFLE = new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(10).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0), 1.0F).build()).group(ItemGroup.FOOD));
    public static final Item RANDOM_POTATO = new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(10).saturationModifier(0.4F).build()).group(ItemGroup.FOOD));

    public static final Item BLOB_SPAWN_EGG = new SpawnEggItem(EntityRegistry.BLOB, 0x0d00ff, 0xFFFFFF, new Item.Settings().group(ItemGroup.MISC));

    public static final ArmorMaterial okhoArmorMaterial = new OkhoArmorMaterial();
    public static final Item OKHO_HELMET = new ArmorItem(okhoArmorMaterial, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item OKHO_CHESTPLATE = new ArmorItem(okhoArmorMaterial, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item OKHO_LEGGINGS = new ArmorItem(okhoArmorMaterial, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item OKHO_BOOTS = new ArmorItem(okhoArmorMaterial, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));


    public static void initializeItems(){

        Registry.register(Registry.ITEM, new Identifier(RandomPointlessThings.MODID, "waffle"), WAFFLE);
        Registry.register(Registry.ITEM, new Identifier(RandomPointlessThings.MODID, "random_potato"), RANDOM_POTATO);
        Registry.register(Registry.ITEM, new Identifier(RandomPointlessThings.MODID, "blob_spawn_egg"), BLOB_SPAWN_EGG);

        Registry.register(Registry.ITEM, new Identifier(RandomPointlessThings.MODID, "okho_helmet"), OKHO_HELMET);
        Registry.register(Registry.ITEM, new Identifier(RandomPointlessThings.MODID, "okho_chestplate"), OKHO_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(RandomPointlessThings.MODID, "okho_leggings"), OKHO_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(RandomPointlessThings.MODID, "okho_boots"), OKHO_BOOTS);
    }
}
