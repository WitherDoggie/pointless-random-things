package io.github.witherdoggie.rpt.block;

import io.github.witherdoggie.rpt.util.WoodType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.PaneBlock;

public class WoodPaneBlock extends PaneBlock {

    private WoodType type;

    protected WoodPaneBlock(WoodType type, AbstractBlock.Settings settings) {
        super(settings);
        this.type = type;
        this.setDefaultState((((((this.stateManager.getDefaultState()).with(NORTH, false)).with(EAST, false)).with(SOUTH, false)).with(WEST, false)).with(WATERLOGGED, false));
    }
}
