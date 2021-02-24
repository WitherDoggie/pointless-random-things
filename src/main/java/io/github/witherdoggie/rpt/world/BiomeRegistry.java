package io.github.witherdoggie.rpt.world;

import io.github.witherdoggie.rpt.RandomPointlessThings;
import io.github.witherdoggie.rpt.world.biome.HotBiome;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public class BiomeRegistry {

    public static final RegistryKey<Biome> HOT_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(RandomPointlessThings.MODID, "hot"));

    public static void initializeBiomes(){
        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier(RandomPointlessThings.MODID, "hot"), HotBiome.HOT_SURFACE_BUILDER);
        Registry.register(BuiltinRegistries.BIOME, HOT_KEY.getValue(), HotBiome.HOT);


        OverworldBiomes.addContinentalBiome(HOT_KEY, OverworldClimate.TEMPERATE, 2D);
        OverworldBiomes.addContinentalBiome(HOT_KEY, OverworldClimate.DRY, 2D);
    }
}
