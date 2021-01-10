package GamarsMod;

import GamarsMod.proxy.CommonProxy;
import GamarsMod.tabs.GamarsTab;
import GamarsMod.util.Reference;
import GamarsMod.util.handlers.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, name = Reference.MOD_NAME)
public class Main {
    @Mod.Instance
    public static Main instance;

    // Intializing Modded in Creative Tabs
    public static final CreativeTabs gamarsTab = new GamarsTab("gamarsmod");

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        RegistryHandler.preInitRegisteries();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        RegistryHandler.initRegisteries();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        RegistryHandler.postInitRegister();
    }

    @Mod.EventHandler
    public void serverInit(FMLServerStartingEvent event) {
        RegistryHandler.serverRegisteries();
    }
}