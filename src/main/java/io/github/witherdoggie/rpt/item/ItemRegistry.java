package io.github.witherdoggie.rpt.item;

import io.github.witherdoggie.rpt.RandomPointlessThings;
import io.github.witherdoggie.rpt.entity.BlobEntity;
import io.github.witherdoggie.rpt.entity.EntityRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {

    private static final Item  WAFFLE = new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(10).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0), 1.0F).build()).group(ItemGroup.FOOD));
    public static final Item RANDOM_POTATO = new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(10).saturationModifier(0.4F).build()).group(ItemGroup.FOOD));

    public static final Item BLOB_SPAWN_EGG = new SpawnEggItem(EntityRegistry.BLOB, 0x0d00ff, 0xFFFFFF, new Item.Settings().group(ItemGroup.MISC));

    public static void initializeItems(){

        Registry.register(Registry.ITEM, new Identifier(RandomPointlessThings.MODID, "waffle"), WAFFLE);
        Registry.register(Registry.ITEM, new Identifier(RandomPointlessThings.MODID, "random_potato"), RANDOM_POTATO);
        Registry.register(Registry.ITEM, new Identifier(RandomPointlessThings.MODID, "blob_spawn_egg"), BLOB_SPAWN_EGG);
    }
}
