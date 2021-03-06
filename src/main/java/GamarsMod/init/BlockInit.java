package GamarsMod.init;

import GamarsMod.objects.blocks.BlockBase;
import GamarsMod.objects.blocks.custom.BlockRejuvenator;
import GamarsMod.objects.blocks.custom.BlockStoneMug;
import GamarsMod.objects.blocks.custom.counter.BlockCounter;
import GamarsMod.objects.blocks.custom.pedestal.BlockPedestal;
import GamarsMod.objects.blocks.machines.customfurnace.BlockCustomFurnace;
import GamarsMod.objects.blocks.machines.BlockTestCoalGen;
import GamarsMod.objects.blocks.machines.sinteringfurnace.BlockSinteringFurnace;
import GamarsMod.objects.blocks.seeds.BlockTestSeed;
import GamarsMod.objects.tileentity.TileEntityTestCoalGen;
import GamarsMod.util.Reference;
import GamarsMod.util.handlers.TileEntityHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

import static net.minecraftforge.fml.common.registry.GameRegistry.*;

@EventBusSubscriber
@ObjectHolder(Reference.MOD_ID)
public class BlockInit {

    private static final ArrayList<Block> BLOCKS = new ArrayList<Block>();

    //BLOCKS
    public static final Block LIGHT_BLOCK = null;
    public static final Block REJUVENATOR = null;
    public static final Block STONE_MUG = null;

    //SEEDS
    public static final Block TEST_PLANT = null;

    //ORES
    public static final Block TEST_ORE = null;
    public static final Block ANCIENT_DEBRIS = null;

    //MATERIALS
    public static final Block PACKED_WOOL = null;

    //MATERIAL BLOCKS
    public static final Block TEST_BLOCK = null;
    public static final Block NETHERITE_BLOCK = null;

    public static final Block COUNTER = null;
    public static final Block PEDESTAL = null;

    public static final Block CUSTOM_FURNACE = null;

    public static final Block TEST_COAL_GENERATOR = null;
    public static final Block LIT_TEST_COAL_GENERATOR = null;

    public static final Block SINTERING_FURNACE = null;

    @SubscribeEvent // Tell forge the below method is an event handler
    public static void registerBlocks(final RegistryEvent.Register<Block> event) { // Handle the Registry event for Block objects.
        final IForgeRegistry<Block> registry = event.getRegistry(); // Store registry here to save redundant code

        //BLOCKS
        registerBlock(registry, new BlockBase("light_block", Material.GLASS, 8.0F, 8.0F, 2, "pickaxe").setLightLevel(1.0F));
        registerBlock(registry, new BlockRejuvenator("rejuvenator", Material.PORTAL, 8.0F, 8.0F, 2, "pickaxe"));
        registerBlock(registry, new BlockStoneMug("stone_mug", Material.ROCK, 8.0F, 8.0F, 1, "pickaxe"));
        registerBlock(registry, new BlockCustomFurnace("custom_furnace", 8.0F, 8.0F, 2, "pickaxe"));

        //SEEDS
        registerBlock(registry, new BlockTestSeed("test_plant"));

        //ORES
        registerBlock(registry, new BlockBase("test_ore", Material.ROCK, 25f, 50f, 3, "pickaxe")); // Call to register our block here, with our new block instance
        registerBlock(registry, new BlockBase("ancient_debris", Material.ROCK, 30.0F, 1200.0F, 3, "pickaxe"));

        //MATERIALS
        registerBlock(registry, new BlockBase("packed_wool", Material.SAND, 15.25F, 100.0F, 2, "axe"));

        //MATERIAL BLOCKS
        registerBlock(registry, new BlockBase("netherite_block", Material.ROCK, 15.0F, 50.0F, 3, "pickaxe", true));
        registerBlock(registry, new BlockBase("test_block", Material.IRON, 8.0F, 8.0F, 2, "pickaxe", true));

        registerBlock(registry, new BlockCounter("counter"));
        registerBlock(registry, new BlockPedestal("pedestal"));

        registerBlock(registry, new BlockTestCoalGen("test_coal_generator", Material.IRON, 8.0F, 8.0F, 2, "pickaxe"));
        registerBlock(registry, new BlockTestCoalGen("lit_test_coal_generator", Material.IRON, 8.0F, 8.0F, 2, "pickaxe").setCreativeTab(null));

        registerBlock(registry, new BlockSinteringFurnace("sintering_furnace"));

        GameRegistry.registerTileEntity(TileEntityTestCoalGen.class, new ResourceLocation(Reference.MOD_ID + ":test_coal_generator"));

    }

    @SubscribeEvent // Another event handler
    public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry(); // Store registry here to save redundant code

        for (Block blocks : BLOCKS) {
            registry.register((ItemBlock)new ItemBlock(blocks).setRegistryName(blocks.getRegistryName())); // Convert our block into a block item, and register it as an item
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(blocks), 0, new ModelResourceLocation(blocks.getRegistryName(), "inventory"));
        }
    }

    private static void registerBlock(IForgeRegistry<Block> registry, Block block) { // Make a helper method to reduce redundant code
        registry.register(block); // Register our block officially here
        BLOCKS.add(block); // Add the block to our registration list here so we can do their items soon

        TileEntityHandler.registerTileEntities();

    }

}

