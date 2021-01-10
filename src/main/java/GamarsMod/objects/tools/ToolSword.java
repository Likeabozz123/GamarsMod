package GamarsMod.objects.tools;

import GamarsMod.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword {

    public ToolSword(String name, ToolMaterial material) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTabs.TOOLS);

        ItemInit.ITEMS.add(this);
    }

}
