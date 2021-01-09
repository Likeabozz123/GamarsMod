package GamarsMod.util.handlers;

import GamarsMod.Main;
import GamarsMod.init.BlockInit;
import GamarsMod.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {

        event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));

    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {

        event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));

    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item item : ItemInit.ITEMS) {

            Main.proxy.registerItemRenderer(item, 0, "inventory");

        }

        for (Block block : BlockInit.BLOCKS) {
            Main.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory");
        }
    }

    public static void preInitRegisteries(){

    }

    public static void initRegisteries(){
        Main.proxy.render();
    }

    public static void postInitRegister(){

    }

    public static void serverRegisteries(){

    }

}