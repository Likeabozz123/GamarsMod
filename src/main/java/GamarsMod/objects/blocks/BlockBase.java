package GamarsMod.objects.blocks;

import GamarsMod.Main;
import GamarsMod.init.BlockInit;
import GamarsMod.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBase extends Block {

    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public boolean isDirectional;
    public boolean beaconBase;

    public BlockBase(String name, Material material, float hardness, float resistance, int miningLevel, String tool) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel(tool, miningLevel);
        setCreativeTab(Main.gamarsTab);
    }

    public BlockBase(String name, Material material, float hardness, float resistance, int miningLevel, String tool, boolean beaconBase) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel(tool, miningLevel);
        setCreativeTab(Main.gamarsTab);

        this.beaconBase = beaconBase;

    }

    public BlockBase(String name, Material material, float hardness, float resistance, int miningLevel, String tool, boolean beaconBase, boolean isDirectional) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel(tool, miningLevel);
        setCreativeTab(Main.gamarsTab);

        this.isDirectional = isDirectional;
    }

    @Override
    public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
        return beaconBase;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        if(isDirectional == true) {
            EnumFacing enumfacing = EnumFacing.getFront(meta);

            if (enumfacing.getAxis() == EnumFacing.Axis.Y)
            {
                enumfacing = EnumFacing.SOUTH;
            }

            return this.getDefaultState().withProperty(FACING, enumfacing);
        }
        return super.getStateFromMeta(meta);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        if(isDirectional == true) {
            EnumFacing facing=state.getValue(FACING);
            int meta=((EnumFacing)state.getValue(FACING)).getIndex();
            return meta;
        }
        return super.getMetaFromState(state);
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        if(isDirectional == true) {
            return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
        }
        return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer, hand);
    }
}
