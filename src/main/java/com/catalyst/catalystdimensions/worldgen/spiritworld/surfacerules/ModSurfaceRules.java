package com.catalyst.catalystdimensions.worldgen.spiritworld.surfacerules;

import com.catalyst.catalystdimensions.worldgen.spiritworld.biomes.ModBiomes;
import com.catalyst.catalystdimensions.worldgen.spiritworld.surfacerules.SurfaceRulesHelper;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

import java.util.List;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);





 // or YOffset if that's how your version wraps it

    public static SurfaceRules.RuleSource makeSpiritWorldRules() {
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(
                SurfaceRules.isBiome(Biomes.PLAINS),
                // Step 1: Replace the top 3 stone layers with dirt (starting from terrain surface)
                SurfaceRulesHelper.surface(0, true, 2, Blocks.GRASS_BLOCK, Blocks.DIRT)
        ),
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(ModBiomes.CRYSTAL_FIELDS_BIOME),
                        // Step 1: Replace the top 3 stone layers with dirt (starting from terrain surface)
                        SurfaceRulesHelper.surface(0, true, 2, Blocks.GRASS_BLOCK, Blocks.DIRT)
                ));
    }







    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
