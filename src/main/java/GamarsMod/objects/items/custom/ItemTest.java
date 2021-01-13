package GamarsMod.objects.items.custom;

import GamarsMod.Main;
import GamarsMod.init.ItemInit;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ItemTest extends Item {

    public ItemTest(String name) {
        setRegistryName(name);
        setUnlocalizedName(name);
        setMaxStackSize(1);
        setCreativeTab(Main.gamarsTab);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        ItemStack item = player.getHeldItem(hand);

        if(!world.isRemote) {
            EntityItem entityItem = new EntityItem(world, player.posX, player.posY, player.posZ, new ItemStack(ItemInit.BONK_HAMMER));
            world.spawnEntity(entityItem);
            item.shrink(1);
        }

        return EnumActionResult.SUCCESS;
    }
}
