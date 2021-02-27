package io.github.witherdoggie.rpt.render.entity;

import io.github.witherdoggie.rpt.entity.SkeletinEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.util.Identifier;

public class SkeletinEntityRenderer extends LivingEntityRenderer<SkeletinEntity, PlayerEntityModel<SkeletinEntity>> {

    public SkeletinEntityRenderer(EntityRenderDispatcher dispatcher, boolean arms) {
        super(dispatcher, new PlayerEntityModel(0.0f, true), 0.5f);
    }

    @Override
    public Identifier getTexture(SkeletinEntity entity) {
        return new Identifier("rpt", "textures/entity/skeletin/skeletin.png");
    }
}
