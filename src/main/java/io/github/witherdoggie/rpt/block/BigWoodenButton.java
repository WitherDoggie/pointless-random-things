package io.github.witherdoggie.rpt.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class BigWoodenButton extends AbstractBigButtonBlock{

    public BigWoodenButton(AbstractBlock.Settings settings) {
        super(true, settings);
    }

    @Override
    protected SoundEvent getClickSound(boolean powered) {
        return powered ? SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON : SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF;
    }
}
