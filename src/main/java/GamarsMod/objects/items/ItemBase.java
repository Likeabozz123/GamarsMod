package GamarsMod.objects.items;

import GamarsMod.Main;
import GamarsMod.init.ItemInit;
import GamarsMod.tabs.GamarsTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    public ItemBase(String name) {
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(Main.gamarsTab);

        // ItemInit.ITEMS.add(this);
    }

}
