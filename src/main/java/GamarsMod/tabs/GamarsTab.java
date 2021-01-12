package GamarsMod.tabs;

import GamarsMod.init.BlockInit;
import GamarsMod.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GamarsTab extends CreativeTabs {

    // DON'T FORGET TO INITIALIZE IN MAIN CLASS

    public GamarsTab(String label) {
        super("gamarstab");

        // Looks for tab_gamars.png
        // this.setBackgroundImageName("gamars.png");
    }

    @Override
    public ItemStack getTabIconItem() {

        // Tab Icon Item
        return new ItemStack(ItemInit.TEST_ITEM);

        // Tab Icon Block
        //return new ItemStack(Item.getItemFromBlock(BlockInit.TEST_BLOCK));
    }

}
