package GamarsMod.objects.items.tools;

import GamarsMod.Main;
import net.minecraft.item.ItemSpade;

public class ToolShovel extends ItemSpade {

    public ToolShovel(String name, ToolMaterial material) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(Main.gamarsTab);

        // ItemInit.ITEMS.add(this);
    }

}
