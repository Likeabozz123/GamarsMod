package GamarsMod.objects.blocks;

import GamarsMod.Main;
import GamarsMod.init.BlockInit;
import GamarsMod.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.IBlockAccess;

public class BlockBase extends Block {

    public BlockBase(String name, Material material, float hardness, float resistance, int miningLevel, String tool) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel(tool, miningLevel);
        setCreativeTab(Main.gamarsTab);

/*        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));*/
    }

}
