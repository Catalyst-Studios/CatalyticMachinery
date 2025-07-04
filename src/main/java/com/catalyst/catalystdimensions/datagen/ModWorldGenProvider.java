package com.catalyst.catalystdimensions.datagen;

import com.catalyst.catalystdimensions.worldgen.noise.*;
import com.catalyst.catalystdimensions.CatalystDimensions;

import com.catalyst.catalystdimensions.worldgen.spiritworld.*;
import com.catalyst.catalystdimensions.worldgen.spiritworld.biomes.ModBiomeModifiers;
import com.catalyst.catalystdimensions.worldgen.spiritworld.biomes.ModBiomes;
import com.catalyst.catalystdimensions.worldgen.features.ModConfiguredFeatures;
import com.catalyst.catalystdimensions.worldgen.features.ModPlacedFeatures;
import com.catalyst.catalystdimensions.worldgen.carvers.ModConfiguredWorldCarvers;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;

import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import java.util.Set;
import java.util.concurrent.CompletableFuture;



public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.DIMENSION_TYPE, ModDim::bootstrapType)
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)
            .add(Registries.BIOME, ModBiomes::bootstrap)
            .add(Registries.LEVEL_STEM, ModDim::bootstrapStem)
            .add(Registries.NOISE, ModNoiseParameters::bootstrap)
            .add(Registries.NOISE_SETTINGS, ModNoiseGen::bootstrap)
            .add(Registries.CONFIGURED_CARVER, ModConfiguredWorldCarvers::bootstrap);











    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(CatalystDimensions.MODID));
    }
}

