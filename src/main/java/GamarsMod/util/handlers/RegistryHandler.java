package GamarsMod.util.handlers;

import GamarsMod.Main;
import GamarsMod.init.BlockInit;
import GamarsMod.init.ItemInit;
import GamarsMod.recipes.SmeltingRecipes;
import GamarsMod.recipes.CraftingRecipes;
import GamarsMod.util.Reference;
import GamarsMod.world.gen.WorldGenOres;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class RegistryHandler {

/*    @SubscribeEvent
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
    }*/

    public static void preInitRegisteries() {

    }
    public static void initRegisteries() {
        Main.proxy.render();
        SmeltingRecipes.init();
        CraftingRecipes.init();
        GameRegistry.registerWorldGenerator(new WorldGenOres(), 0);
        NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
    }

    public static void postInitRegister() {

    }

    public static void serverRegisteries() {

    }

}