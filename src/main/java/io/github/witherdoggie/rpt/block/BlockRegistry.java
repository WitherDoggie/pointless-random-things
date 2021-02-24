package io.github.witherdoggie.rpt.block;

import io.github.witherdoggie.rpt.RandomPointlessThings;
import io.github.witherdoggie.rpt.util.WoodType;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
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
    public static final PillarBlock LOG = new PillarBlock(AbstractBlock.Settings.of(Material.AGGREGATE, MaterialColor.LIME).sounds(BlockSoundGroup.WOOD));
    public static final BigWoodenButton BIG_ACACIA_BUTTON = new BigWoodenButton(FabricBlockSettings.of(Material.SUPPORTED).noCollision().strength(0.5f));
    public static final WoodPaneBlock OAK_PANE = new WoodPaneBlock(WoodType.OAK, AbstractBlock.Settings.of(Material.WOOD).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final WoodPaneBlock BIRCH_PANE = new WoodPaneBlock(WoodType.BIRCH, AbstractBlock.Settings.of(Material.WOOD).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final WoodPaneBlock SPRUCE_PANE = new WoodPaneBlock(WoodType.SPRUCE, AbstractBlock.Settings.of(Material.WOOD).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final WoodPaneBlock DARK_OAK_PANE = new WoodPaneBlock(WoodType.DARK_OAK, AbstractBlock.Settings.of(Material.WOOD).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final WoodPaneBlock ACACIA_PANE = new WoodPaneBlock(WoodType.ACACIA, AbstractBlock.Settings.of(Material.WOOD).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final WoodPaneBlock JUNGLE_PANE = new WoodPaneBlock(WoodType.JUNGLE, AbstractBlock.Settings.of(Material.WOOD).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final WoodPaneBlock WARPED_PANE = new WoodPaneBlock(WoodType.WARPED, AbstractBlock.Settings.of(Material.WOOD).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final WoodPaneBlock CRIMSON_PANE = new WoodPaneBlock(WoodType.CRIMSON, AbstractBlock.Settings.of(Material.WOOD).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));

    public static final SlabBlock DIRT_SLAB = new SlabBlock(AbstractBlock.Settings.of(Material.SOIL, MaterialColor.DIRT).strength(0.5f).sounds(BlockSoundGroup.GRAVEL));

    public static void initializeBlocks(){

        Registry.register(Registry.BLOCK, new Identifier(RandomPointlessThings.MODID, "log"), LOG);
        Registry.register(Registry.ITEM, new Identifier(RandomPointlessThings.MODID,"log"), new BlockItem(LOG, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier(RandomPointlessThings.MODID, "squish_block"), SQUISH_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(RandomPointlessThings.MODID,"squish_block"), new BlockItem(SQUISH_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier(RandomPointlessThings.MODID, "potato_ore"), POTATO_ORE);
        Registry.register(Registry.ITEM, new Identifier(RandomPointlessThings.MODID,"potato_ore"), new BlockItem(POTATO_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier(RandomPointlessThings.MODID, "big_acacia_button"), BIG_ACACIA_BUTTON);
        Registry.register(Registry.ITEM, new Identifier(RandomPointlessThings.MODID, "big_acacia_button"), new BlockItem(BIG_ACACIA_BUTTON, new Item.Settings().group(ItemGroup.REDSTONE)));

        Registry.register(Registry.BLOCK, new Identifier(RandomPointlessThings.MODID, "oak_wood_pane"), OAK_PANE);
        Registry.register(Registry.BLOCK, new Identifier(RandomPointlessThings.MODID, "birch_wood_pane"), BIRCH_PANE);
        Registry.register(Registry.BLOCK, new Identifier(RandomPointlessThings.MODID, "spruce_wood_pane"), SPRUCE_PANE);
        Registry.register(Registry.BLOCK, new Identifier(RandomPointlessThings.MODID, "dark_oak_wood_pane"), DARK_OAK_PANE);
        Registry.register(Registry.BLOCK, new Identifier(RandomPointlessThings.MODID, "acacia_wood_pane"), ACACIA_PANE);
        Registry.register(Registry.BLOCK, new Identifier(RandomPointlessThings.MODID, "jungle_wood_pane"), JUNGLE_PANE);
        Registry.register(Registry.BLOCK, new Identifier(RandomPointlessThings.MODID, "warped_wood_pane"), WARPED_PANE);
        Registry.register(Registry.BLOCK, new Identifier(RandomPointlessThings.MODID, "crimson_wood_pane"), CRIMSON_PANE);

        Registry.register(Registry.ITEM, new Identifier(RandomPointlessThings.MODID, "oak_wood_pane"), new BlockItem(OAK_PANE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(RandomPointlessThings.MODID, "birch_wood_pane"), new BlockItem(BIRCH_PANE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(RandomPointlessThings.MODID, "spruce_wood_pane"), new BlockItem(SPRUCE_PANE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(RandomPointlessThings.MODID, "dark_oak_wood_pane"), new BlockItem(DARK_OAK_PANE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(RandomPointlessThings.MODID, "acacia_wood_pane"), new BlockItem(ACACIA_PANE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(RandomPointlessThings.MODID, "jungle_wood_pane"), new BlockItem(JUNGLE_PANE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(RandomPointlessThings.MODID, "warped_wood_pane"), new BlockItem(WARPED_PANE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(RandomPointlessThings.MODID, "crimson_wood_pane"), new BlockItem(CRIMSON_PANE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier(RandomPointlessThings.MODID, "dirt_slab"), DIRT_SLAB);
        Registry.register(Registry.ITEM, new Identifier(RandomPointlessThings.MODID, "dirt_slab"), new BlockItem(DIRT_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

    }
}
