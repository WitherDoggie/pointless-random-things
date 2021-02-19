package io.github.witherdoggie.rpt.render;

import io.github.witherdoggie.rpt.entity.EntityRegistry;
import io.github.witherdoggie.rpt.render.entity.AngryPotatoEntityRenderer;
import io.github.witherdoggie.rpt.render.entity.BlobEntityRenderer;
import io.github.witherdoggie.rpt.render.entity.KingBlobEntityRenderer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public class EntityRenderRegisters {

    public static void initializeRenderers(){

        EntityRendererRegistry.INSTANCE.register(EntityRegistry.BLOB, (dispatcher, context) -> {
            return new BlobEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(EntityRegistry.ANGRY_POTATO, (dispatcher, context) -> {
            return new AngryPotatoEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(EntityRegistry.KING_BLOB, (dispatcher, context) -> {
            return new KingBlobEntityRenderer(dispatcher);
        });
    }
}
