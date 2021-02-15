package io.github.witherdoggie.rpt.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityRegistry{

    public static EntityType<BlobEntity> BLOB;
    public static EntityType<AngryPotatoEntity> ANGRY_POTATO;

    public static void registerEntities(){

        BLOB = Registry.register(Registry.ENTITY_TYPE, new Identifier("rpt", "blob"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BlobEntity:: new).dimensions(EntityDimensions.fixed(1.0f, 1.0f)).build());
        FabricDefaultAttributeRegistry.register(BLOB, BlobEntity.createBlobAttributes());

        ANGRY_POTATO = Registry.register(Registry.ENTITY_TYPE, new Identifier("rpt", "angry_potato"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, AngryPotatoEntity:: new).dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());
        FabricDefaultAttributeRegistry.register(ANGRY_POTATO, AngryPotatoEntity.createAngryPotatoAttributes());

    }
}
