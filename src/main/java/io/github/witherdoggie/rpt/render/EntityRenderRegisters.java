package io.github.witherdoggie.rpt.render;

import io.github.witherdoggie.rpt.entity.EntityRegistry;
import io.github.witherdoggie.rpt.render.entity.BlobEntityRenderer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public class EntityRenderRegisters {

    public static void initializeRenderers(){

        EntityRendererRegistry.INSTANCE.register(EntityRegistry.BLOB, (dispatcher, context) -> {
            return new BlobEntityRenderer(dispatcher);
        });
    }
}
