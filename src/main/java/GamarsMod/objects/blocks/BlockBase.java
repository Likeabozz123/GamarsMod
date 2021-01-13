package GamarsMod.objects.blocks;

import GamarsMod.Main;
import GamarsMod.init.BlockInit;
import GamarsMod.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

    public class BlockBase extends Block {

        public boolean beaconBase;

        public BlockBase(String name, Material material, float hardness, float resistance, int miningLevel, String tool) {
            super(material);
            setRegistryName(name);
            setUnlocalizedName(name);
            setHardness(hardness);
            setResistance(resistance);
            setHarvestLevel(tool, miningLevel);
            setCreativeTab(Main.gamarsTab);
        }

        public BlockBase(String name, Material material, float hardness, float resistance, int miningLevel, String tool, boolean isBeaconBase) {
            super(material);
            setRegistryName(name);
            setUnlocalizedName(name);
            setHardness(hardness);
            setResistance(resistance);
            setHarvestLevel(tool, miningLevel);
            setCreativeTab(Main.gamarsTab);

            beaconBase = isBeaconBase;
        }

        @Override
        public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
            return beaconBase;
        }

    }
