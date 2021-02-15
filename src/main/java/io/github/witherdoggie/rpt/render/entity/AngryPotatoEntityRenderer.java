package io.github.witherdoggie.rpt.render.entity;

import io.github.witherdoggie.rpt.entity.AngryPotatoEntity;
import io.github.witherdoggie.rpt.render.entity.model.AngryPotatoEntityModel;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class AngryPotatoEntityRenderer extends MobEntityRenderer<AngryPotatoEntity, AngryPotatoEntityModel> {

    public AngryPotatoEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new AngryPotatoEntityModel(), 0.1f);
    }

    @Override
    public Identifier getTexture(AngryPotatoEntity entity) {
        return new Identifier("rpt", "textures/entity/angrypotato/angry_potato.png");
    }
}
