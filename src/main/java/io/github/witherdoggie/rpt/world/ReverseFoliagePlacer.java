package io.github.witherdoggie.rpt.world;

import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

import java.util.Random;
import java.util.Set;

public abstract class ReverseFoliagePlacer extends FoliagePlacer {

    public ReverseFoliagePlacer(UniformIntDistribution radius, UniformIntDistribution offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return null;
    }

    @Override
    protected void generate(ModifiableTestableWorld world, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, Set<BlockPos> leaves, int offset, BlockBox box) {

    }

    @Override
    public abstract int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config);

    @Override
    protected boolean isInvalidForLeaves(Random random, int baseHeight, int dx, int y, int dz, boolean giantTrunk) {
        return false;
    }

    @Override
    protected void generateSquare(ModifiableTestableWorld world, Random random, TreeFeatureConfig config, BlockPos pos, int radius, Set<BlockPos> leaves, int y, boolean giantTrunk, BlockBox box) {
        int i = giantTrunk ? 1 : 0;
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (int j = -radius; j <= radius + i; ++j) {
            for (int k = -radius; k <= radius + i; ++k) {
                if (!this.isPositionInvalid(random, j, y, k, radius, giantTrunk)) {
                    mutable.set((Vec3i) pos, j, y, k);
                    if (TreeFeature.canReplace(world, mutable)) {
                        world.setBlockState(mutable, config.leavesProvider.getBlockState(random, mutable), 19);
                        box.encompass(new BlockBox(mutable, mutable));
                        leaves.add(mutable.toImmutable());
                    }
                }
            }
        }
    }
}
