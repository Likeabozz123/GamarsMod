package GamarsMod.objects.items.tools;

import GamarsMod.Main;
import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword {

    public ToolSword(String name, ToolMaterial material) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(Main.gamarsTab);

        // ItemInit.ITEMS.add(this);
    }

}
