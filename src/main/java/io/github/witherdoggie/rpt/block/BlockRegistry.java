package io.github.witherdoggie.rpt.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegistry {

    public static final SquishBlock SQUISH_BLOCK = new SquishBlock(AbstractBlock.Settings.of(Material.ORGANIC_PRODUCT, MaterialColor.LIME).sounds(BlockSoundGroup.SLIME));

    public static void initializeBlocks(){

        Registry.register(Registry.BLOCK, new Identifier("rpt", "squish_block"), SQUISH_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("rpt","squish_block"), new BlockItem(SQUISH_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
    }
}
