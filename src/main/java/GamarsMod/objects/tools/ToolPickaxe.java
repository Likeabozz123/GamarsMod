package GamarsMod.objects.tools;

import GamarsMod.Main;
import GamarsMod.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;

public class ToolPickaxe extends ItemPickaxe {

    public ToolPickaxe(String name, ToolMaterial material) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(Main.gamarsTab);

        ItemInit.ITEMS.add(this);
    }

}
