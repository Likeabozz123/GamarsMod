package GamarsMod.objects.items.foods;

import GamarsMod.Main;
import GamarsMod.init.ItemInit;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ItemCustomFood extends ItemFood {


    public ItemCustomFood(String name, int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(Main.gamarsTab);

        ItemInit.ITEMS.add(this);
    }
}
