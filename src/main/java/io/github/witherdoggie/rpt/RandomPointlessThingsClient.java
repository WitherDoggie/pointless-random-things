package io.github.witherdoggie.rpt;

import io.github.witherdoggie.rpt.render.EntityRenderRegisters;
import net.fabricmc.api.ClientModInitializer;
import software.bernie.geckolib3.GeckoLib;

public class RandomPointlessThingsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        GeckoLib.initialize();
        EntityRenderRegisters.initializeRenderers();
    }
}
