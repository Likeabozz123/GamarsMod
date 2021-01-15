package GamarsMod.objects.blocks.custom.counter;

import GamarsMod.objects.blocks.BlockTileEntity;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockCounter extends BlockTileEntity<TileEntityCounter> {

    public BlockCounter(String name) {
        super(name, Material.IRON, 8.0F, 8.0F, 1, "pickaxe");
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileEntityCounter tile = getTileEntity(world, pos);
            if (side == EnumFacing.DOWN) {
                tile.decrementCount();
            } else if (side == EnumFacing.UP) {
                tile.incrementCount();
            }
            player.sendMessage(new TextComponentString("Count: " + tile.getCount()));
        }
        return true;
    }

    @Override
    public Class<TileEntityCounter> getTileEntityClass() {
        return TileEntityCounter.class;
    }

    @Nullable
    @Override
    public TileEntityCounter createTileEntity(World world, IBlockState state) {
        return new TileEntityCounter();
    }
}
