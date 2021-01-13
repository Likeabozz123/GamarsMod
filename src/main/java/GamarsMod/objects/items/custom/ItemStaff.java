package GamarsMod.objects.items.custom;

import GamarsMod.Main;
import GamarsMod.objects.items.ItemBase;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemStaff extends Item {

    public ItemStaff(String name) {
        // super(name);
        setRegistryName(name);
        setUnlocalizedName(name);
        setMaxStackSize(1);
        setCreativeTab(Main.gamarsTab);
    }

    @Override // ON RIGHT CLICK
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {

        ItemStack item = player.getHeldItem(hand);

        /*
        if(!world.isRemote) {

            Vec3d aim = player.getLookVec();
            EntityLargeFireball fireball = new EntityLargeFireball(world, player, 1, 1,1);

            fireball.setPosition(player.posX + aim.x * 1.5D, player.posY + aim.y * 1.5D, player.posX + aim.z * 1.5D);
            fireball.accelerationX = aim.x * 0.1;
            fireball.accelerationY = aim.y * 0.1;
            fireball.accelerationZ = aim.z * 0.1;

            world.spawnEntity(fireball);

            // item.damageItem(1, player);*/

        world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_ENDERPEARL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        player.getCooldownTracker().setCooldown(this, 20);

        if (!world.isRemote)
        {
            EntityEnderPearl entityenderpearl = new EntityEnderPearl(world, player);
            entityenderpearl.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
            world.spawnEntity(entityenderpearl);
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
    }

/*
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if (!playerIn.capabilities.isCreativeMode)
        {
            itemstack.shrink(1);
        }

        worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_ENDERPEARL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        playerIn.getCooldownTracker().setCooldown(this, 20);

        if (!worldIn.isRemote)
        {
            EntityEnderPearl entityenderpearl = new EntityEnderPearl(worldIn, playerIn);
            entityenderpearl.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.spawnEntity(entityenderpearl);
        }

        playerIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
*/

/*    @Override // ON RIGHT CLICK ON BLOCK
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        ItemStack item = player.getHeldItem(hand);
        Vec3d aim = player.getLookVec();
        EntityLargeFireball fireball = new EntityLargeFireball(world, player, 1, 1,1);

        fireball.setPosition(player.posX + aim.x * 1.5D, player.posY + aim.y * 1.5D, player.posX + aim.z * 1.5D);
        fireball.accelerationX = aim.x * 0.1;
        fireball.accelerationY = aim.y * 0.1;
        fireball.accelerationZ = aim.z * 0.1;

        world.spawnEntity(fireball);

        item.damageItem(1, player);
        return EnumActionResult.SUCCESS;
    }*/
}
