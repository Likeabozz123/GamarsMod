package GamarsMod;

import GamarsMod.objects.blocks.custom.pedestal.PacketRequestUpdatePedestal;
import GamarsMod.objects.blocks.custom.pedestal.PacketUpdatePedestal;
import GamarsMod.init.PotionInit;
import GamarsMod.proxy.CommonProxy;
import GamarsMod.recipes.CraftingRecipes;
import GamarsMod.recipes.SmeltingRecipes;
import GamarsMod.tabs.GamarsTab;
import GamarsMod.util.Reference;
import GamarsMod.util.handlers.GuiRegistry;
import GamarsMod.util.handlers.RegistryHandler;
import GamarsMod.world.gen.WorldGenOres;
import com.google.common.eventbus.Subscribe;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, name = Reference.MOD_NAME)
public class Main {
    @Mod.Instance
    public static Main instance;

    // Intializing Modded in Creative Tabs
    public static final CreativeTabs gamarsTab = new GamarsTab("gamarsmod");

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    public static SimpleNetworkWrapper network;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // RegistryHandler.preInitRegisteries();
        proxy.registerRenderers();

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiRegistry());

        network = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
        network.registerMessage(new PacketUpdatePedestal.Handler(), PacketUpdatePedestal.class, 0, Side.CLIENT);
        network.registerMessage(new PacketRequestUpdatePedestal.Handler(), PacketRequestUpdatePedestal.class, 1, Side.SERVER);
        PotionInit.registerPotions();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // RegistryHandler.initRegisteries();

        // Main.proxy.render();
        SmeltingRecipes.init();
        CraftingRecipes.init();
        GameRegistry.registerWorldGenerator(new WorldGenOres(), 0);

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        // RegistryHandler.postInitRegister();


    }

    @Mod.EventHandler
    public void serverInit(FMLServerStartingEvent event) {
        // RegistryHandler.serverRegisteries();


    }

    @Mod.EventBusSubscriber
    public static class WorldEvents{



    //potion shit
    @SubscribeEvent
    public static void yourPotionActive(TickEvent.PlayerTickEvent event)
    {
        boolean isActive = false;
        if(event.player.isPotionActive(PotionInit.YOUR_POTION_EFFECT)) isActive = true;

        if(isActive)
        {

            //someone put code here, tutorial guy said so

        }


    }
    }

}