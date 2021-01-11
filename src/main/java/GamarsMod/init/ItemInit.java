package GamarsMod.init;

import GamarsMod.objects.armour.ArmourBase;
import GamarsMod.objects.items.ItemBase;
import GamarsMod.objects.items.foods.ItemCustomFood;
import GamarsMod.objects.items.foods.ItemTestSeed;
import GamarsMod.objects.tools.*;
import GamarsMod.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {

                        //type of variable  //makes what the variable is equal to
    public static final List<Item> ITEMS = new ArrayList<Item>();
                                   //name of variable

    //TOOL MATERIAL TYPES
    public static final Item.ToolMaterial TEST_TOOL = EnumHelper.addToolMaterial("test_tool", 3, 9001, 12.0F, 4.0F, 18);
    public static final Item.ToolMaterial NETHERITE_TOOL = EnumHelper.addToolMaterial("netherite_tool", 3, 2031, 9, 3, 10);

    //ARMOUR MATERIAL TYPES
    public static final ItemArmor.ArmorMaterial TEST_ARMOUR = EnumHelper.addArmorMaterial("test_armour", Reference.MOD_ID + ":TEST", 15, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
    public static final ItemArmor.ArmorMaterial REINFORCED_WOOLIN = EnumHelper.addArmorMaterial("reinforced_woolin", Reference.MOD_ID + ":REINFORCED_WOOLIN", 7, new int[]{4, 6, 7, 5}, 30, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 5.69F);
    public static final ItemArmor.ArmorMaterial NETHERITE_ARMOUR = EnumHelper.addArmorMaterial("netherite_armour", Reference.MOD_ID + ":NETHERITE_ARMOUR", 7, new int[]{5, 6, 9, 4}, 30, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 4);

    //ITEMS
    public static final Item TEST_ITEM = new ItemBase("test_item");

    public static final Item BONK_HAMMER = new ToolSword("bonk_hammer", TEST_TOOL);

    // FOODS
    public static final Item TEST_SEEDS = new ItemTestSeed("test_seeds");
    public static final Item TEST_WHEAT = new ItemBase("test_wheat");
    public static final Item TEST_FOOD = new ItemCustomFood("test_food", 5, 3.5F, true);

    //MATERIALS
    public static final Item TEST_MATERIAL = new ItemBase("test_material");
    public static final Item NETHERITE_INGOT = new ItemBase("netherite_ingot");
    public static final Item NETHERITE_SCRAP = new ItemBase("netherite_scrap");
    public static final Item STACKED_IRON_ORE = new ItemBase("stacked_iron_ore");

    //ARMOUR
    public static final Item TEST_HELMET = new ArmourBase("test_helmet", TEST_ARMOUR, 1, EntityEquipmentSlot.HEAD);
    public static final Item TEST_CHESTPLATE = new ArmourBase("test_chestplate", TEST_ARMOUR,1, EntityEquipmentSlot.CHEST);
    public static final Item TEST_LEGGINGS = new ArmourBase("test_leggings", TEST_ARMOUR, 2, EntityEquipmentSlot.LEGS);
    public static final Item TEST_BOOTS = new ArmourBase("test_boots", TEST_ARMOUR, 1, EntityEquipmentSlot.FEET);

    public static final Item NETHERITE_HELMET = new ArmourBase("netherite_helmet", NETHERITE_ARMOUR,2, EntityEquipmentSlot.HEAD );
    public static final Item NETHERITE_CHESTPLATE = new ArmourBase("netherite_chestplate", NETHERITE_ARMOUR,1, EntityEquipmentSlot.CHEST);
    public static final Item NETHERITE_LEGGINGS = new ArmourBase("netherite_leggings", NETHERITE_ARMOUR, 2, EntityEquipmentSlot.LEGS);
    public static final Item NETHERITE_BOOTS = new ArmourBase("netherite_boots", NETHERITE_ARMOUR, 1, EntityEquipmentSlot.FEET);

    public static final Item REINFORCED_WOOLIN_PANTS = new ArmourBase("reinforced_woolin_pants", REINFORCED_WOOLIN,2, EntityEquipmentSlot.LEGS);

    //TOOLS
    public static final Item TEST_SWORD = new ToolSword("test_sword", TEST_TOOL);
    public static final Item TEST_PICKAXE = new ToolPickaxe("test_pickaxe", TEST_TOOL);
    public static final Item TEST_AXE = new ToolAxe("test_axe", TEST_TOOL, 10.0F, 1.0f);
    public static final Item TEST_SHOVEL = new ToolShovel("test_shovel", TEST_TOOL);
    public static final Item TEST_HOE = new ToolHoe("test_hoe", TEST_TOOL);
    public static final Item TEST_MULTITOOL = new ToolMultiTool("test_multitool", TEST_TOOL);

    public static final Item NETHERITE_SWORD = new ToolSword("netherite_sword", NETHERITE_TOOL);
    public static final Item NETHERITE_AXE = new ToolAxe("netherite_axe", NETHERITE_TOOL, 10.0F, 1.0F);
    public static final Item NETHERITE_PICKAXE = new ToolPickaxe("netherite_pickaxe", NETHERITE_TOOL);
    public static final Item NETHERITE_SHOVEL = new ToolShovel("netherite_shovel", NETHERITE_TOOL);
    public static final Item NETHERITE_HOE = new ToolHoe("netherite_hoe", NETHERITE_TOOL);

}
