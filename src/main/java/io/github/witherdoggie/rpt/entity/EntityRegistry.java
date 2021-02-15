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

    public static void registerEntities(){

        BLOB = Registry.register(Registry.ENTITY_TYPE, new Identifier("entityblob", "blob"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BlobEntity:: new).dimensions(EntityDimensions.fixed(2.0f, 2.0f)).build());
        FabricDefaultAttributeRegistry.register(BLOB, BlobEntity.createBlobAttributes());
    }
}
