package io.github.witherdoggie.rpt.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
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
    public static final PotatoOre POTATO_ORE = new PotatoOre(FabricBlockSettings.of(Material.STONE, MaterialColor.STONE).sounds(BlockSoundGroup.STONE)
            .requiresTool().strength(3.0f, 3.0f).breakByTool(FabricToolTags.PICKAXES, 0));
    public static final BigWoodenButton BIG_ACACIA_BUTTON = new BigWoodenButton(FabricBlockSettings.of(Material.SUPPORTED).noCollision().strength(0.5f));

    public static void initializeBlocks(){

        Registry.register(Registry.BLOCK, new Identifier("rpt", "squish_block"), SQUISH_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("rpt","squish_block"), new BlockItem(SQUISH_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier("rpt", "potato_ore"), POTATO_ORE);
        Registry.register(Registry.ITEM, new Identifier("rpt","potato_ore"), new BlockItem(POTATO_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier("rpt", "big_acacia_button"), BIG_ACACIA_BUTTON);
        Registry.register(Registry.ITEM, new Identifier("rpt", "big_acacia_button"), new BlockItem(BIG_ACACIA_BUTTON, new Item.Settings().group(ItemGroup.REDSTONE)));
    }
}
