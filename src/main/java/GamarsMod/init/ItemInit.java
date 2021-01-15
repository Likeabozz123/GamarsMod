package GamarsMod.init;

import GamarsMod.objects.armour.ArmourBase;
import GamarsMod.objects.blocks.machines.customfurnace.CustomFurnaceFuel;
import GamarsMod.objects.items.ItemBase;
import GamarsMod.objects.items.MaterialTypes;
import GamarsMod.objects.items.custom.ItemFuel;
import GamarsMod.objects.items.custom.ItemStaff;
import GamarsMod.objects.items.custom.ItemTest;
import GamarsMod.objects.items.foods.ItemCustomFood;
import GamarsMod.objects.items.foods.ItemTestSeed;
import GamarsMod.objects.items.tools.*;
import GamarsMod.util.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

@EventBusSubscriber
@ObjectHolder(Reference.MOD_ID)
public class ItemInit {

                        //type of variable  //makes what the variable is equal to
    private static final ArrayList<Item> ITEMS = new ArrayList<Item>();
                                   //name of variable

    //MATERIAL TYPES ARE LOCATED IN GamarsMod.objects.items.MaterialTypes

    //ITEMS
    public static final Item TEST_ITEM = null;
    public static final Item SHATTERED_PEARL = null;
    public static final Item ENDERITE_SHARD = null;
    public static final Item CORRUPTED_PEARL = null;

    public static final Item TEST_TEST = null;
    public static final Item TEST_COAL = null;

    // FOODS
    public static final Item TEST_SEEDS = null;
    public static final Item TEST_WHEAT = null;
    public static final Item TEST_FOOD = null;

    //MATERIALS
    public static final Item TEST_MATERIAL = null;
    public static final Item NETHERITE_INGOT = null;
    public static final Item NETHERITE_SCRAP = null;
    public static final Item STACKED_IRON_ORE = null;

    //ARMOUR
    public static final Item TEST_HELMET = null;
    public static final Item TEST_CHESTPLATE = null;
    public static final Item TEST_LEGGINGS = null;
    public static final Item TEST_BOOTS = null;

    public static final Item NETHERITE_HELMET = null;
    public static final Item NETHERITE_CHESTPLATE = null;
    public static final Item NETHERITE_LEGGINGS = null;
    public static final Item NETHERITE_BOOTS = null;

    public static final Item ENDERITE_HELMET = null;
    public static final Item ENDERITE_CHESTPLATE = null;
    public static final Item ENDERITE_LEGGINGS = null;
    public static final Item ENDERITE_BOOTS = null;

    public static final Item REINFORCED_WOOLIN_PANTS = null;

    public static final Item LIGHT_HELMET = null;

    //TOOLS
    public static final Item TEST_SWORD = null;
    public static final Item TEST_PICKAXE = null;
    public static final Item TEST_AXE = null;
    public static final Item TEST_SHOVEL = null;
    public static final Item TEST_HOE = null;
    public static final Item TEST_MULTITOOL = null;

    public static final Item NETHERITE_SWORD = null;
    public static final Item NETHERITE_PICKAXE = null;
    public static final Item NETHERITE_AXE = null;
    public static final Item NETHERITE_SHOVEL = null;
    public static final Item NETHERITE_HOE = null;

    public static final Item BONK_HAMMER = null;

    //STAVES
    public static final Item TEST_STAFF = null;


    @SubscribeEvent // Tell forge the below method is an event handler
    public static void registerItems(final RegistryEvent.Register<Item> event) { // Handle the Registry event for Block objects.
        final IForgeRegistry<Item> registry = event.getRegistry(); // Store registry here to save redundant code

        //ITMES
        registerItem(registry, new ItemBase("test_item"));

        registerItem(registry, new ItemTest("test_test"));
        registerItem(registry, new ItemFuel("test_coal", 800));

        registerItem(registry,new ItemBase("shattered_pearl"));
        registerItem(registry,new ItemBase("enderite_shard"));
        registerItem(registry,new ItemBase("corrupted_pearl", true));

        registerItem(registry, new ToolBonkHammer("bonk_hammer", MaterialTypes.TEST_TOOL, 9001.0F, 50.0F));

        //FOODS
        registerItem(registry, new ItemTestSeed("test_seeds"));
        registerItem(registry, new ItemBase("test_wheat"));
        registerItem(registry, new ItemCustomFood("test_food", 5, 3.5F, true));

        //MATERIALS
        registerItem(registry, new ItemBase("test_material"));
        registerItem(registry, new ItemBase("netherite_ingot"));
        registerItem(registry, new ItemBase("netherite_scrap"));
        registerItem(registry, new ItemBase("stacked_iron_ore"));

        //ARMOUR
        registerItem(registry, new ArmourBase("test_helmet", MaterialTypes.TEST_ARMOUR, 1, EntityEquipmentSlot.HEAD));
        registerItem(registry, new ArmourBase("test_chestplate", MaterialTypes.TEST_ARMOUR,1, EntityEquipmentSlot.CHEST));
        registerItem(registry, new ArmourBase("test_leggings", MaterialTypes.TEST_ARMOUR, 2, EntityEquipmentSlot.LEGS));
        registerItem(registry, new ArmourBase("test_boots", MaterialTypes.TEST_ARMOUR, 1, EntityEquipmentSlot.FEET));

        registerItem(registry, new ArmourBase("netherite_helmet", MaterialTypes.NETHERITE_ARMOUR,2, EntityEquipmentSlot.HEAD));
        registerItem(registry, new ArmourBase("netherite_chestplate", MaterialTypes.NETHERITE_ARMOUR,1, EntityEquipmentSlot.CHEST));
        registerItem(registry, new ArmourBase("netherite_leggings", MaterialTypes.NETHERITE_ARMOUR, 2, EntityEquipmentSlot.LEGS));
        registerItem(registry, new ArmourBase("netherite_boots", MaterialTypes.NETHERITE_ARMOUR, 1, EntityEquipmentSlot.FEET));

        registerItem(registry, new ArmourBase("enderite_helmet", MaterialTypes.ENDERITE_ARMOUR,2, EntityEquipmentSlot.HEAD));
        registerItem(registry, new ArmourBase("enderite_chestplate", MaterialTypes.ENDERITE_ARMOUR,1, EntityEquipmentSlot.CHEST));
        registerItem(registry, new ArmourBase("enderite_leggings", MaterialTypes.ENDERITE_ARMOUR, 2, EntityEquipmentSlot.LEGS));
        registerItem(registry, new ArmourBase("enderite_boots", MaterialTypes.ENDERITE_ARMOUR, 1, EntityEquipmentSlot.FEET));

        registerItem(registry, new ArmourBase("reinforced_woolin_pants", MaterialTypes.REINFORCED_WOOLIN ,2, EntityEquipmentSlot.LEGS));

        registerItem(registry, new ArmourBase("light_helmet", MaterialTypes.LIGHT_ARMOUR, 1, EntityEquipmentSlot.HEAD));

        //TOOLS & WEAPONS
        registerItem(registry, new ToolSword("test_sword", MaterialTypes.TEST_TOOL));
        registerItem(registry, new ToolPickaxe("test_pickaxe", MaterialTypes.TEST_TOOL));
        registerItem(registry, new ToolAxe("test_axe", MaterialTypes.TEST_TOOL, 10.0F, 1.0f));
        registerItem(registry, new ToolShovel("test_shovel", MaterialTypes.TEST_TOOL));
        registerItem(registry, new ToolHoe("test_hoe", MaterialTypes.TEST_TOOL));
        registerItem(registry, new ToolMultiTool("test_multitool", MaterialTypes.TEST_TOOL));

        registerItem(registry, new ToolSword("netherite_sword", MaterialTypes.NETHERITE_TOOL));
        registerItem(registry, new ToolPickaxe("netherite_pickaxe", MaterialTypes.NETHERITE_TOOL));
        registerItem(registry, new ToolAxe("netherite_axe", MaterialTypes.NETHERITE_TOOL, 10.0F, 1.0F));
        registerItem(registry, new ToolShovel("netherite_shovel", MaterialTypes.NETHERITE_TOOL));
        registerItem(registry, new ToolHoe("netherite_hoe", MaterialTypes.NETHERITE_TOOL));

        //STAVES
        registerItem(registry, new ItemStaff("test_staff"));


    }

    @SubscribeEvent // Another event handler
    public static void registerItemModels(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry(); // Store registry here to save redundant code

        for (Item items : ITEMS) {
            // registry.register(items);
        }
    }

    private static void registerItem(IForgeRegistry<Item> registry, Item items) { // Make a helper method to reduce redundant code
        registry.register(items); // Register our block officially here
        ITEMS.add(items); // Add the block to our registration list here so we can do their items soon
        ModelLoader.setCustomModelResourceLocation(items, 0, new ModelResourceLocation(items.getRegistryName(), "inventory"));
    }

}
