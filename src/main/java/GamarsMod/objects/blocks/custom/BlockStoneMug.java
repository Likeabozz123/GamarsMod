package GamarsMod.objects.blocks.custom;

import GamarsMod.Main;
import GamarsMod.objects.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockStoneMug extends BlockBase {
    public static final AxisAlignedBB STONE_MUG_AABB = new AxisAlignedBB(0.1875D, 0, 0.1875D, 0.8125D, 0.625D, 0.8125D);

    public BlockStoneMug(String name, Material material, float hardness, float resistance, int miningLevel, String tool) {
        super(name, material, hardness, resistance, miningLevel, tool);
        //setRegistryName(name);
        setUnlocalizedName(name);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel(tool, miningLevel);
        setCreativeTab(Main.gamarsTab);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return STONE_MUG_AABB;
    }
}