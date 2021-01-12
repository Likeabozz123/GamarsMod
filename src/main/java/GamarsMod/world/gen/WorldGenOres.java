package GamarsMod.world.gen;

import GamarsMod.init.BlockInit;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenOres implements IWorldGenerator {

    // CREATE A WorldGenerator VARIABLE, IDENTIFY IN WorldGenOres, THROW INTO SWITCH CASE

    private WorldGenerator test_ore;
    private WorldGenerator ancient_debris;

    public WorldGenOres() {
        test_ore = new WorldGenMinable(BlockInit.TEST_ORE.getDefaultState(), 15, BlockMatcher.forBlock(Blocks.STONE));
        ancient_debris = new WorldGenMinable(BlockInit.ANCIENT_DEBRIS.getDefaultState(), 8, BlockMatcher.forBlock(Blocks.NETHERRACK));
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimensionType()) {

            case NETHER:
                genStandard(ancient_debris, world, random, chunkX, chunkZ, 1, 4, 80);
                break;

            case OVERWORLD:
                genStandard(test_ore, world, random, chunkX, chunkZ, 1, 4, 12);
                break;

            case THE_END:
                break;

        }
    }

    private void genStandard(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight) {
        if(minHeight < 0) minHeight = 0;
        if(maxHeight > 255) maxHeight = 255;

        if(maxHeight < minHeight) {
            int i = minHeight;
            minHeight = maxHeight;
            maxHeight = i;
        } else if(maxHeight == minHeight) {
            if(maxHeight < 255) {
                maxHeight++;
            } else minHeight--;
        }

        BlockPos chunkPosAsBlockPos = new BlockPos(chunkX << 4, 0, chunkZ << 4);
        int heightDiff = maxHeight - minHeight + 1;

        for (int i = 0; i < chance; i++) {
            generator.generate(world, random,
                    chunkPosAsBlockPos.add(
                            random.nextInt(16),
                            minHeight + random.nextInt(heightDiff),
                            random.nextInt(16)
                    )
            );
        }
    }

}