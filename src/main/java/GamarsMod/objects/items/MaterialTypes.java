package GamarsMod.objects.items;

import GamarsMod.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class MaterialTypes {


    //TOOL MATERIAL TYPES
    public static final Item.ToolMaterial TEST_TOOL = EnumHelper.addToolMaterial("test_tool", 3, 9001, 12.0F, 4.0F, 18);
    public static final Item.ToolMaterial NETHERITE_TOOL = EnumHelper.addToolMaterial("netherite_tool", 3, 2031, 9, 3, 10);

    //ARMOUR MATERIAL TYPES
    public static final ItemArmor.ArmorMaterial TEST_ARMOUR = EnumHelper.addArmorMaterial("test_armour", Reference.MOD_ID + ":TEST", 15, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
    public static final ItemArmor.ArmorMaterial REINFORCED_WOOLIN = EnumHelper.addArmorMaterial("reinforced_woolin", Reference.MOD_ID + ":REINFORCED_WOOLIN", 7, new int[]{4, 6, 7, 5}, 30, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 5.69F);
    public static final ItemArmor.ArmorMaterial NETHERITE_ARMOUR = EnumHelper.addArmorMaterial("netherite_armour", Reference.MOD_ID + ":NETHERITE_ARMOUR", 7, new int[]{5, 6, 9, 4}, 30, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 4);

}
