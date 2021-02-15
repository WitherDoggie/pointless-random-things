package io.github.witherdoggie.rpt;

import io.github.witherdoggie.rpt.entity.EntityRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class RandomPointlessThings implements ModInitializer {

    @Override
    public void onInitialize() {

        EntityRegistry.registerEntities();
    }
}
