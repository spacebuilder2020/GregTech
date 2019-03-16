package gregtech.integration.cubicchunks;

import gregtech.common.ConfigHolder;
import io.github.opencubicchunks.cubicchunks.api.worldgen.CubeGeneratorsRegistry;

public class CubicChunksCompatibility {
    public static void registerCompatibility() {
        if(!ConfigHolder.disableRubberTreeGeneration) {
            CubeGeneratorsRegistry.register(new WorldGenRubberTree_CubicPopulator(), 2);
        }
        CubeGeneratorsRegistry.register(new WorldGeneratorImpl_CubicPopulator(), 1);
    }
}
