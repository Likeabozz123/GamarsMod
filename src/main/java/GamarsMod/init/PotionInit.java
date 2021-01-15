package GamarsMod.init;

import GamarsMod.objects.potions.CustomPotion;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class PotionInit
{
    public static final Potion YOUR_POTION_EFFECT = new CustomPotion("custom potion", false, 11294042, 0, 0).registerPotionAttributeModifier(SharedMonsterAttributes.KNOCKBACK_RESISTANCE, MathHelper.getRandomUUID().toString(), 3.0D, 2 );

    public static final PotionType YOUR_POTION = new PotionType("your_potion", new PotionEffect[] {new PotionEffect(YOUR_POTION_EFFECT, 4800)}).setRegistryName("your_potion");
    public static final PotionType LONGER_YOUR_POTION = new PotionType("your_potion", new PotionEffect[] {new PotionEffect(YOUR_POTION_EFFECT, 4800)}).setRegistryName("longer_your_potion");

    public static void registerPotions()
    {
        registerPotions(YOUR_POTION, LONGER_YOUR_POTION, YOUR_POTION_EFFECT);

        registerPotionMixes();
    }

    public static void registerPotions(PotionType defaultPotion, PotionType longPotion, Potion effect)
    {
        ForgeRegistries.POTIONS.register(effect);
        ForgeRegistries.POTION_TYPES.register(defaultPotion);
        ForgeRegistries.POTION_TYPES.register(longPotion);
    }

    private static void registerPotionMixes()
    {
        PotionHelper.addMix(YOUR_POTION, Items.REDSTONE, LONGER_YOUR_POTION);
        PotionHelper.addMix(PotionTypes.MUNDANE, Items.MINECART, YOUR_POTION);
    }



}
