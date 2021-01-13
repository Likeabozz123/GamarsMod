package GamarsMod.objects.items.custom;

import GamarsMod.objects.items.ItemBase;
import net.minecraft.item.ItemStack;

public class ItemFuel extends ItemBase {

    int burnTimeInSeconds;

    public ItemFuel(String name, int burnTimeInSeconds) {
        super(name);
        this.burnTimeInSeconds = burnTimeInSeconds * 20;
    }

    @Override
    public int getItemBurnTime(ItemStack itemStack) {
        return this.burnTimeInSeconds;
    }
}
