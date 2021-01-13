package GamarsMod.objects.items;

import GamarsMod.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;

import static net.minecraftforge.common.util.EnumHelper.addArmorMaterial;
import static net.minecraftforge.common.util.EnumHelper.addToolMaterial;

public class MaterialTypes {

    //TOOL MATERIAL TYPES
    public static final ToolMaterial TEST_TOOL = addToolMaterial("test_tool", 3, 9001, 12.0F, 4.0F, 18);
    public static final ToolMaterial NETHERITE_TOOL = addToolMaterial("netherite_tool", 3, 2031, 9, 3, 10);

    //ARMOUR MATERIAL TYPES
    public static final ArmorMaterial TEST_ARMOUR = addArmorMaterial("test_armour", Reference.MOD_ID + ":TEST", 15, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
    public static final ArmorMaterial POT_HEAD = addArmorMaterial("pot_head", Reference.MOD_ID + ":POT_HEAD", 15, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
    public static final ArmorMaterial REINFORCED_WOOLIN = addArmorMaterial("reinforced_woolin", Reference.MOD_ID + ":REINFORCED_WOOLIN", 7, new int[]{4, 6, 7, 5}, 30, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 5.69F);
    public static final ArmorMaterial NETHERITE_ARMOUR = addArmorMaterial("netherite_armour", Reference.MOD_ID + ":NETHERITE_ARMOUR", 7, new int[]{5, 6, 9, 4}, 30, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 4);
    public static final ArmorMaterial LIGHT_ARMOUR = addArmorMaterial("light_armour", Reference.MOD_ID + ":LIGHT_ARMOUR", 15, new int[]{1, 3, 5, 1}, 14, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
    public static final ArmorMaterial ENDERITE_ARMOUR = addArmorMaterial("enderite_armour", Reference.MOD_ID + ":ENDERITE_ARMOUR", 7, new int[]{5, 7, 8, 3}, 30, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 4);

}
