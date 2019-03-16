package gregtech.integration.cubicchunks;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import gregtech.api.worldgen.generator.CachedGridEntry;
import io.github.opencubicchunks.cubicchunks.api.util.CubePos;
import io.github.opencubicchunks.cubicchunks.api.worldgen.populator.ICubicPopulator;

public class WorldGeneratorImpl_CubicPopulator implements ICubicPopulator
{
    public static final int GRID_SIZE_X = 3;
    public static final int GRID_SIZE_Z = 3;

    private void generateInternal(World world, int selfGridX, int selfGridZ, int chunkX, int chunkY, int chunkZ, Random random) {
        int halfSizeX = (GRID_SIZE_X - 1) / 2;
        int halfSizeZ = (GRID_SIZE_Z - 1) / 2;
        for (int gridX = -halfSizeX; gridX <= halfSizeX; gridX++) {
            for (int gridZ = -halfSizeZ; gridZ <= halfSizeZ; gridZ++) {
                CachedGridEntry cachedGridEntry = CachedGridEntry.getOrCreateEntry(world, selfGridX + gridX, selfGridZ + gridZ, chunkX, chunkZ);
                cachedGridEntry.populateCube(world, chunkX, chunkY, chunkZ, random);
            }
        }
    }

    @Override public void generate(World world, Random random, CubePos cubePos, Biome biome)
    {
        int chunkX = cubePos.getX();
        int chunkY = cubePos.getY();
        int chunkZ = cubePos.getZ();
        int selfGridX = Math.floorDiv(chunkX, GRID_SIZE_X);
        int selfGridZ = Math.floorDiv(chunkZ, GRID_SIZE_Z);
        generateInternal(world, selfGridX, selfGridZ, chunkX, chunkY, chunkZ, random);
    }
}
