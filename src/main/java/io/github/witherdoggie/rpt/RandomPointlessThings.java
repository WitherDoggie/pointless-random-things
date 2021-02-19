package io.github.witherdoggie.rpt;

import io.github.witherdoggie.rpt.block.BlockRegistry;
import io.github.witherdoggie.rpt.entity.EntityRegistry;
import io.github.witherdoggie.rpt.item.ItemRegistry;
import net.fabricmc.api.ModInitializer;

public class RandomPointlessThings implements ModInitializer {

    public static String MODID = "rpt";

    @Override
    public void onInitialize() {

        BlockRegistry.initializeBlocks();
        ItemRegistry.initializeItems();
        EntityRegistry.registerEntities();
    }
}
