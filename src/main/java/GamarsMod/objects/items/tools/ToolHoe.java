package GamarsMod.objects.items.tools;

import GamarsMod.Main;
import net.minecraft.item.ItemHoe;

public class ToolHoe extends ItemHoe {

    public ToolHoe(String name, ToolMaterial material) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(Main.gamarsTab);

        // ItemInit.ITEMS.add(this);
    }

}
