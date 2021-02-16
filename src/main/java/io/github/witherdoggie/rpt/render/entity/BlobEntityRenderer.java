package io.github.witherdoggie.rpt.render.entity;

import io.github.witherdoggie.rpt.entity.BlobEntity;
import io.github.witherdoggie.rpt.render.entity.model.BlobEntityModel;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class BlobEntityRenderer extends MobEntityRenderer<BlobEntity, BlobEntityModel> {

    public BlobEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new BlobEntityModel(), 0.5f);
    }

    @Override
    public Identifier getTexture(BlobEntity entity) {
        return new Identifier("rpt", "textures/entity/blob/blob.png");
    }
}
