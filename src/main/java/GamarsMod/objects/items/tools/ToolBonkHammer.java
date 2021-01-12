package GamarsMod.objects.items.tools;

import GamarsMod.Main;
import GamarsMod.objects.items.custom.ItemBonkHammer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;

public class ToolBonkHammer extends ItemBonkHammer {

    public ToolBonkHammer(String name, ToolMaterial material, float attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed);
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(Main.gamarsTab);

        this.attackSpeed = attackSpeed - 4.0F;
        this.attackDamage = attackDamage - 1.0F;

        // ItemInit.ITEMS.add(this);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {

        if(enchantment == Enchantments.SHARPNESS) {
            return true;
        }
        if(enchantment == Enchantments.BANE_OF_ARTHROPODS) {
            return true;
        }
        if(enchantment == Enchantments.SMITE) {
            return true;
        }
        else return super.canApplyAtEnchantingTable(stack, enchantment);
    }
}
