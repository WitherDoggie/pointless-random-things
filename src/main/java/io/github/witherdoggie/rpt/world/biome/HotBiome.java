package io.github.witherdoggie.rpt.world.biome;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class HotBiome {

    public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> HOT_SURFACE_BUILDER = SurfaceBuilder.DEFAULT
            .withConfig(new TernarySurfaceConfig(
                    Blocks.LAVA.getDefaultState(),
                    Blocks.LAVA.getDefaultState(),
                    Blocks.LAVA.getDefaultState()));

    public static final Biome HOT = createHotBiome();

    private static Biome createHotBiome() {

        SpawnSettings.Builder spawns = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addMonsters(spawns, 50, 50, 100);

        GenerationSettings.Builder genSettings = new GenerationSettings.Builder();
        genSettings.surfaceBuilder(HOT_SURFACE_BUILDER);

        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.SNOW)
                .category(Biome.Category.NONE)
                .depth(0.125F)
                .scale(0.05F)
                .temperature(0.2F)
                .downfall(0.4F)
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x3f76e4)
                        .waterFogColor(0x050533)
                        .fogColor(0xc0d8ff)
                        .skyColor(0x77adff)
                        .build())
                .spawnSettings(spawns.build())
                .generationSettings(genSettings.build())
                .build();
    }
}
