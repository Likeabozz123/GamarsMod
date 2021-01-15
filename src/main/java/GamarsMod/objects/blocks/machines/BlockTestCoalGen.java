package GamarsMod.objects.blocks.machines;

import GamarsMod.Main;
import GamarsMod.init.BlockInit;
import GamarsMod.objects.blocks.BlockBase;
import GamarsMod.objects.energy.CustomEnergyStorage;
import GamarsMod.objects.tileentity.TileEntityTestCoalGen;
import GamarsMod.util.Reference;
import GamarsMod.util.handlers.GuiRegistry;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockTestCoalGen extends BlockBase {

    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public static boolean keepInventory;

    public BlockTestCoalGen(String name, Material material, float hardness, float resistance, int miningLevel, String tool) {
        super(name, material, hardness, resistance, miningLevel, tool);
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(FACING, EnumFacing.SOUTH));
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote) {
            playerIn.openGui(Main.instance, GuiRegistry.GUI_TEST_COAL_GENERATOR, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityTestCoalGen();
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {

        if(!keepInventory) {
            TileEntityTestCoalGen tileEntity = (TileEntityTestCoalGen)worldIn.getTileEntity(pos);
            worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), tileEntity.handler.getStackInSlot(0)));
        }
        super.breakBlock(worldIn, pos, state);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] { FACING});
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.SOUTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        EnumFacing facing=state.getValue(FACING);
        int meta=((EnumFacing)state.getValue(FACING)).getIndex();
        return meta;
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    public static void setState(boolean active, World worldIn, BlockPos pos)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        keepInventory = true;
        if (active)
        {
            worldIn.setBlockState(pos, BlockInit.LIT_TEST_COAL_GENERATOR.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
            worldIn.setBlockState(pos, BlockInit.LIT_TEST_COAL_GENERATOR.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);

        }
        else
        {
            worldIn.setBlockState(pos, BlockInit.TEST_COAL_GENERATOR.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
            worldIn.setBlockState(pos, BlockInit.TEST_COAL_GENERATOR.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
        }
        keepInventory = false;

        if (tileentity != null)
        {
            tileentity.validate();
            worldIn.setTileEntity(pos, tileentity);
        }
    }

}
