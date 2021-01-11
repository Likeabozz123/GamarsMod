package GamarsMod.init;

import GamarsMod.objects.blocks.machines.BlockCustomFurnace;
import GamarsMod.objects.blocks.BlockBase;
import GamarsMod.objects.blocks.seeds.BlockTestSeed;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {

    public static final List<Block> BLOCKS = new ArrayList<Block>();

    //BLOCKS

    //SEEDS
    public static final Block TEST_PLANT = new BlockTestSeed("test_plant");

    //ORES
    public static final Block TEST_ORE = new BlockBase("test_ore", Material.ROCK, 25.0F, 50.0F, 3, "pickaxe");
    public static final Block ANCIENT_DEBRIS = new BlockBase("ancient_debris", Material.ROCK, 30.0F, 50.0F, 3, "pickaxe");

    //MATERIALS
    public static final Block PACKED_WOOL = new BlockBase("packed_wool", Material.SAND, 15.25F, 100.0F, 2, "axe");

    //MATERIAL BLOCKS
    public static final Block TEST_BLOCK = new BlockBase("test_block", Material.IRON, 8.0F, 8.0F, 2, "pickaxe");
    public static final Block NETHERITE_BLOCK = new BlockBase("netherite_block", Material.ROCK, 15.0F, 50.0F, 3, "pickaxe");

    //CUSTOM FURNACE
    public static final BlockCustomFurnace CUSTOM_FURNACE = new BlockCustomFurnace("custom_furnace");
}

