package GamarsMod.util.handlers;

import GamarsMod.objects.blocks.machines.ContainerCustomFurnace;
import GamarsMod.objects.blocks.machines.GuiCustomFurnace;
import GamarsMod.objects.blocks.machines.TileEntityCustomFurnace;
import GamarsMod.objects.blocks.machines.slots.GuiCustomFurnace;
import GamarsMod.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == Reference.GUI_BLOCK_CUSTOM_FURNACE) return new ContainerCustomFurnace(player.inventory, (TileEntityCustomFurnace)world.getTileEntity(new BlockPos(x,y,z)));
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == Reference.GUI_BLOCK_CUSTOM_FURNACE) return new GuiCustomFurnace(player.inventory, (TileEntityCustomFurnace)world.getTileEntity(new BlockPos(x,y,z)));
        return null;
    }
}
