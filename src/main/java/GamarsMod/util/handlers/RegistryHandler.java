package GamarsMod.util.handlers;

import GamarsMod.Main;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RegistryHandler {

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {

        event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));

    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item item : ItemInit.ITEMS) {
            Main.proxy.registerItemRenderer(item, 0, "inventory");
        }

        for (Block block : BlockInit.BLOCKS) {
            Main.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory");
        }
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {

        event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));

    }

    public static void preInitRegisteries(){

    }

    public static void initRegisteries(){

    }

    public static void postInitRegister(){

    }

    public static void serverRegisteries(){

    }

}