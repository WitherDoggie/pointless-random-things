package io.github.witherdoggie.rpt.render.entity;

import io.github.witherdoggie.rpt.entity.KingBlobEntity;
import io.github.witherdoggie.rpt.render.entity.model.KingBlobModel;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

public class KingBlobEntityRenderer extends GeoEntityRenderer<KingBlobEntity> {


    public KingBlobEntityRenderer(EntityRenderDispatcher dispatcher){
        super(dispatcher, new KingBlobModel());
        this.shadowRadius = 0.5f;
    }
}
