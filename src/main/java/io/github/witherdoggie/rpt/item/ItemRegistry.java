package io.github.witherdoggie.rpt.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {

    private static final Item  WAFFLE = new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(10).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0), 1.0F).build()).group(ItemGroup.FOOD));

    public static void initializeItems(){

        Registry.register(Registry.ITEM, new Identifier("rpt", "waffle"), WAFFLE);
    }
}
