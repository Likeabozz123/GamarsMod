package GamarsMod.proxy;

import GamarsMod.objects.blocks.custom.pedestal.TESRPedestal;
import GamarsMod.objects.blocks.custom.pedestal.TileEntityPedestal;
import net.minecraft.item.Item;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class CommonProxy {

/*  public void registerItemRenderer(Item item, int meta, String id) {
    }

    public void render() {
    }*/


    public void registerRenderers() {

    }

    public String localize(String unlocalized, Object... args) {
        return I18n.translateToLocalFormatted(unlocalized, args);
    }

}
