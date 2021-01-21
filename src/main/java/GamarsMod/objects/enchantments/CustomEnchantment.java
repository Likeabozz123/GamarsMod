package GamarsMod.objects.enchantments;

import GamarsMod.init.EnchantmentInit;
import GamarsMod.init.ItemInit;
import GamarsMod.util.Reference;
import com.google.common.collect.Lists;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.event.entity.living.LivingEvent;

import java.util.List;
import java.util.Random;

public class CustomEnchantment extends Enchantment {

    public static DamageSource source;

    public CustomEnchantment(String name) {
        super(Rarity.VERY_RARE, EnumEnchantmentType.ARMOR_CHEST, new EntityEquipmentSlot[] {EntityEquipmentSlot.CHEST});
        this.setName(name);
        this.setRegistryName(new ResourceLocation(Reference.MOD_ID + name));
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 20 * enchantmentLevel;
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return this.getMinEnchantability(enchantmentLevel) + 10;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int calcModifierDamage(int level, DamageSource source) {
        this.source = source;
        if(source.canHarmInCreative()) {
            return 0;
        }
        else if(source.isProjectile()) {
            return 10;
        }
        return super.calcModifierDamage(level, source);
    }

    public void teleportRandomly(EntityLivingBase living) {
        if(source.isProjectile()) {
            Random random = new Random();

            double d0 = living.posX + (random.nextDouble() - 0.5D) * 16.0D;
            double d1 = living.posY + (double)(random.nextInt(64) - 32);
            double d2 = living.posZ + (random.nextDouble() - 0.5D) * 16.0D;
            EnderTeleportEvent event = new EnderTeleportEvent(living, d0, living.posY, d2, 1);

            // living.attemptTeleport(d0, d1, d2);
            // living.setPosition(d0, d1, d2);
            // living.setPositionAndUpdate(d0, living.posY, d2);
            living.setPositionAndUpdate(event.getTargetX(), event.getTargetY(), event.getTargetZ());
        }
    }

    @Override
    public void onUserHurt(EntityLivingBase user, Entity attacker, int level) {
        if (user.isRiding()) {
            user.dismountRidingEntity();
        }
        teleportRandomly(user);
    }

    @Override
    public boolean canApply(ItemStack stack) {
        if(stack == new ItemStack(ItemInit.ENDERITE_CHESTPLATE)) {
            return true;
        } else return false;
    }
}
