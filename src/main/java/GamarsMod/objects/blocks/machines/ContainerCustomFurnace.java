package GamarsMod.objects.blocks.machines;

import GamarsMod.objects.blocks.machines.slots.SlotCustomFurnaceOutput;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerRepair;
import net.minecraft.inventory.Slot;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerCustomFurnace extends Container {

    private final TileEntityCustomFurnace tileentity;
    private int cookTime, totalCookTime, burnTime, currentBurnTime;


    public ContainerCustomFurnace(InventoryPlayer player, TileEntityCustomFurnace tileentity) {
        this.tileentity = tileentity;
        IItemHandler handler = tileentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

        this.addSlotToContainer(new SlotItemHandler(handler, 0, 21, 36));
        this.addSlotToContainer(new SlotItemHandler(handler, 0, 57, 36));
        this.addSlotToContainer(new SlotItemHandler(handler, 2, 114, 32));
        this.addSlotToContainer(new SlotCustomFurnaceOutput(player.player, tileentity, 3, 81, 36));

        for(int y =0; y < 3; y++){
            for(int x = 0; x < 9; x++){
                this.addSlotToContainer(new Slot(player, x + y*9 + 9, 8 + x*18, 84 + y*18));
            }
        }

        for(int x = 0; x < 9; x++) {
            this.addSlotToContainer(new Slot(player, x, 8 + x * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.tileentity.isUsableByPlayer(playerIn);
    }
}


