package io.github.witherdoggie.rpt.entity;

import io.github.witherdoggie.rpt.RandomPointlessThings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityRegistry{

    public static EntityType<BlobEntity> BLOB = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BlobEntity:: new).dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build();
    public static EntityType<AngryPotatoEntity> ANGRY_POTATO = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, AngryPotatoEntity:: new).dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build();
    public static EntityType<KingBlobEntity> KING_BLOB = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, KingBlobEntity:: new).dimensions(EntityDimensions.fixed(1.0f, 1.0f)).build();

    public static void registerEntities(){

        Registry.register(Registry.ENTITY_TYPE, new Identifier(RandomPointlessThings.MODID, "blob"), BLOB);
        FabricDefaultAttributeRegistry.register(BLOB, BlobEntity.createBlobAttributes());

        Registry.register(Registry.ENTITY_TYPE, new Identifier(RandomPointlessThings.MODID, "angry_potato"), ANGRY_POTATO);
        FabricDefaultAttributeRegistry.register(ANGRY_POTATO, AngryPotatoEntity.createAngryPotatoAttributes());

        Registry.register(Registry.ENTITY_TYPE, new Identifier(RandomPointlessThings.MODID, "king_blob"), KING_BLOB);
        FabricDefaultAttributeRegistry.register(KING_BLOB, KingBlobEntity.createKingBlobAttributes());

    }
}
