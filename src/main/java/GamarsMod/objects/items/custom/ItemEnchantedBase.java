package GamarsMod.objects.items.custom;

import GamarsMod.Main;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemEnchantedBase extends Item
{

    public ItemEnchantedBase(String name){
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(Main.gamarsTab);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
