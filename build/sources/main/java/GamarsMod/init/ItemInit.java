package GamarsMod.init;

import GamarsMod.items.ItemBase;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {

                        //type of variable  //makes what the variable is equal to
    public static final List<Item> ITEMS = new ArrayList<Item>();
                                   //name of variable

    //ITEMS
    public static final Item TEST_ITEM = new ItemBase("test_item");
    public static final Item TEST_MATERIAL = new ItemBase("test_material");
    public static final Item TEST_FOOD = new ItemBase("test_food");
    public static final Item TEST_TEST = new ItemBase("test_test");
    //ROBERT ITEM
    public static final Item BONK_HAMMER = new ItemBase("bonk_hammer");
}
