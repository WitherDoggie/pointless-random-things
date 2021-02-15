package io.github.witherdoggie.rpt;

import io.github.witherdoggie.rpt.block.BlockRegistry;
import io.github.witherdoggie.rpt.entity.EntityRegistry;
import net.fabricmc.api.ModInitializer;

public class RandomPointlessThings implements ModInitializer {

    @Override
    public void onInitialize() {

        BlockRegistry.initializeBlocks();
        EntityRegistry.registerEntities();
    }
}
