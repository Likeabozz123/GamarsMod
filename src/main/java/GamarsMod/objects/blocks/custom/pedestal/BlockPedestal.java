package GamarsMod.objects.blocks.custom.pedestal;

import GamarsMod.Main;
import GamarsMod.objects.blocks.BlockTileEntity;
import GamarsMod.util.handlers.GuiRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;

public class BlockPedestal extends BlockTileEntity<TileEntityPedestal> {

    public static final AxisAlignedBB PEDESTAL_AABB = new AxisAlignedBB(0.0875D, 0, 0.0875D, 0.9125D, 0.825D, 0.9125D);

    public BlockPedestal(String name) {
        super(name, Material.IRON, 8.0F, 8.0F, 1, "pickaxe");
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            ItemStack heldItem = player.getHeldItem(hand);
            TileEntityPedestal tile = getTileEntity(world, pos);
            IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, side);
            if (!player.isSneaking()) {
                if (heldItem.isEmpty()) {
                    player.openGui(Main.instance, GuiRegistry.GUI_PEDESTAL, world, pos.getX(), pos.getY(), pos.getZ());
                } else {
                    player.openGui(Main.instance, GuiRegistry.GUI_PEDESTAL, world, pos.getX(), pos.getY(), pos.getZ());
                }
                tile.markDirty();
            } else {
                player.setHeldItem(hand, itemHandler.extractItem(0, 64, false));
                ItemStack stack = itemHandler.getStackInSlot(0);
/*                if (!stack.isEmpty()) {
                    String localized = Main.proxy.localize(stack.getUnlocalizedName() + ".name");
                    player.sendMessage(new TextComponentString(stack.getCount() + "x " + localized));
                } else {
                    player.sendMessage(new TextComponentString("Empty"));
                }*/
            }
        }
        return true;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntityPedestal tile = getTileEntity(world, pos);
        IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        ItemStack stack = itemHandler.getStackInSlot(0);
        if (!stack.isEmpty()) {
            EntityItem item = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
            world.spawnEntity(item);
        }
        super.breakBlock(world, pos, state);
    }

    @Override
    public Class<TileEntityPedestal> getTileEntityClass() {
        return TileEntityPedestal.class;
    }

    @Nullable
    @Override
    public TileEntityPedestal createTileEntity(World world, IBlockState state) {
        return new TileEntityPedestal();
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return PEDESTAL_AABB;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }
}
