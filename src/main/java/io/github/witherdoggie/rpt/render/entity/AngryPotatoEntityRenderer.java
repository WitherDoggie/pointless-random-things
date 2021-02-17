package io.github.witherdoggie.rpt.render.entity;

import io.github.witherdoggie.rpt.entity.AngryPotatoEntity;
import io.github.witherdoggie.rpt.render.entity.model.AngryPotatoEntityModel;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

import java.util.Random;

public class AngryPotatoEntityRenderer extends MobEntityRenderer<AngryPotatoEntity, AngryPotatoEntityModel> {

    private static final Identifier BROWN = new Identifier("rpt", "textures/entity/angrypotato/angry_potato.png");
    private static final Identifier AQUA = new Identifier("rpt", "textures/entity/angrypotato/angry_potato_aqua.png");
    private static final Identifier NEON_GREEN = new Identifier("rpt", "textures/entity/angrypotato/angry_potato_neon_green.png");
    private static final Identifier BLUE = new Identifier("rpt", "textures/entity/angrypotato/angry_potato_blue.png");
    private static final Identifier PURPLE = new Identifier("rpt", "textures/entity/angrypotato/angry_potato_purple.png");
    private static final Identifier RED = new Identifier("rpt", "textures/entity/angrypotato/angry_potato_red.png");
    private static final Identifier GREEN = new Identifier("rpt", "textures/entity/angrypotato/angry_potato_green.png");
    private static final Identifier YELLOW = new Identifier("rpt", "textures/entity/angrypotato/angry_potato_yellow.png");
    private static final Identifier ORANGE = new Identifier("rpt", "textures/entity/angrypotato/angry_potato_orange.png");
   // private static final Identifier NEON_GREEN = new Identifier("rpt", "textures/entity/angrypotato/angry_potato_neon_green.png");


    public AngryPotatoEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new AngryPotatoEntityModel(), 0.1f);
    }

    @Override
    public Identifier getTexture(AngryPotatoEntity entity) {
        switch (entity.getPotatoType()){
            case 0:
            default:
                return BROWN;
            case 1:
                return AQUA;
            case 2:
                return NEON_GREEN;
            case 3:
                return BLUE;
            case 4:
                return PURPLE;
            case 5:
                return GREEN;
            case 6:
                return YELLOW;
            case 7:
                return ORANGE;
            case 8:
                return RED;
        }
    }
}
