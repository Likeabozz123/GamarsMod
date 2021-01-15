package GamarsMod.util.handlers;

import GamarsMod.objects.blocks.machines.customfurnace.TileEntityCustomFurnace;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
    public static void registerTileEntities(){
        GameRegistry.registerTileEntity(TileEntityCustomFurnace.class, "custom");
    }
}
