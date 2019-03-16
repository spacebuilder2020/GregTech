package gregtech.integration.cubicchunks;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import gregtech.common.worldgen.WorldGenRubberTree;
import io.github.opencubicchunks.cubicchunks.api.util.CubePos;
import io.github.opencubicchunks.cubicchunks.api.worldgen.populator.ICubicPopulator;

public class WorldGenRubberTree_CubicPopulator implements ICubicPopulator {
    private static WorldGenRubberTree tree = new WorldGenRubberTree();

    @Override public void generate(World world, Random random, CubePos cubePos, Biome biome) {
        int minY = cubePos.getMinBlockY();
        int maxY = cubePos.getMaxBlockY();
        int mH = world.getHeight(cubePos.getXCenter(), cubePos.getZCenter());
        if (minY <= mH && maxY >= mH) {
            tree.generate(random, cubePos.getX(), cubePos.getZ(), world, null, null);
        }
    }
}
