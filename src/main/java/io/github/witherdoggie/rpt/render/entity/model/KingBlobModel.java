package io.github.witherdoggie.rpt.render.entity.model;

import io.github.witherdoggie.rpt.RandomPointlessThings;
import io.github.witherdoggie.rpt.entity.KingBlobEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class KingBlobModel extends AnimatedGeoModel<KingBlobEntity> {

    @Override
    public Identifier getModelLocation(KingBlobEntity kingBlobEntity) {
        return new Identifier(RandomPointlessThings.MODID, "geo/kingblob.geo.json");
    }

    @Override
    public Identifier getTextureLocation(KingBlobEntity kingBlobEntity) {
        return new Identifier(RandomPointlessThings.MODID, "textures/entity/king_blob/king_blob.png");
    }

    @Override
    public Identifier getAnimationFileLocation(KingBlobEntity kingBlobEntity) {
        return new Identifier(RandomPointlessThings.MODID, "animations/blob_walk.json");
    }
}
