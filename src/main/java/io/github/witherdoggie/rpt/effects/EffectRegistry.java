package io.github.witherdoggie.rpt.effects;

import io.github.witherdoggie.rpt.RandomPointlessThings;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EffectRegistry {


    public static final StepHeightEffect STEP = new StepHeightEffect();

    public static void initializeEffects(){

        Registry.register(Registry.STATUS_EFFECT, new Identifier(RandomPointlessThings.MODID, "step"), STEP);
    }
}
