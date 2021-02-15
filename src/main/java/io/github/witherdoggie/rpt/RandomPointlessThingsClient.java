package io.github.witherdoggie.rpt;

import io.github.witherdoggie.rpt.render.EntityRenderRegisters;
import net.fabricmc.api.ClientModInitializer;

public class RandomPointlessThingsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        EntityRenderRegisters.initializeRenderers();
    }
}
