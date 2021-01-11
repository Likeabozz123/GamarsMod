package GamarsMod.objects.tools;

import GamarsMod.Main;
import GamarsMod.init.BlockInit;
import GamarsMod.init.ItemInit;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;

import java.util.Set;

public class ToolAxe extends ItemSword {

    // private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE, Blocks.CRAFTING_TABLE);

    public ToolAxe(String name, ToolMaterial material, float attackDamage, float attackSpeed) {
        super(material);
        setHarvestLevel("pickaxe", 3);
/*      this.attackDamage = attackDamage - 1.0F;
        this.attackSpeed = attackSpeed - 4.0F;*/
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.gamarsTab);

        ItemInit.ITEMS.add(this);
    }

/*    public float getStrVsBlock(ItemStack stack, IBlockState state) {
        Material material = state.getMaterial();
        return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? 1 : this.toolMaterial.getEfficiency();
    }*/

}
