package GamarsMod.init;

import GamarsMod.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {

    public static final List<Block> BLOCKS = new ArrayList<Block>();

    //BLOCKS
    public static final Block TEST_BLOCK = new BlockBase("test_block", Material.IRON, 8.0F, 8.0F, 2, "pickaxe");
    public static final Block TEST_ORE = new BlockBase("test_ore", Material.ROCK, 25.0F, 50.0F, 3, "pickaxe");

}
