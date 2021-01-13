package GamarsMod.objects.items;

import GamarsMod.Main;
import GamarsMod.init.ItemInit;
import GamarsMod.tabs.GamarsTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBase extends Item {

    public boolean enchantGlint;

    public ItemBase(String name) {
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(Main.gamarsTab);

    }

    public ItemBase(String name, boolean hasEnchantGlint) {
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(Main.gamarsTab);

        enchantGlint = hasEnchantGlint;
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return enchantGlint;
    }

}
