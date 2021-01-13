package GamarsMod.objects.blocks.custom;

import GamarsMod.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockRejuvenator extends Block {

    protected static final AxisAlignedBB REJUVENATOR_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D);

    public BlockRejuvenator(String name, Material material, float hardness, float resistance, int miningLevel, String tool) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel(tool, miningLevel);
        setCreativeTab(Main.gamarsTab);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return REJUVENATOR_AABB;
    }
}
