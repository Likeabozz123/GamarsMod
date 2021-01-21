package GamarsMod.init;

import GamarsMod.objects.potions.CustomPotion;
import GamarsMod.util.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class PotionInit {

    public static final Potion CUSTOM_POTION_EFFECT = new CustomPotion("custom potion", false, 11294042, 0, 0).registerPotionAttributeModifier(SharedMonsterAttributes.KNOCKBACK_RESISTANCE, MathHelper.getRandomUUID().toString(), 3.0D, 2 );

    public static final PotionType CUSTOM_PONGER = new PotionType("your_potion", new PotionEffect[] {new PotionEffect(CUSTOM_POTION_EFFECT, 4800)}).setRegistryName("your_potion");
    public static final PotionType LONGER_CUSTOM_POTION = new PotionType("your_potion", new PotionEffect[] {new PotionEffect(CUSTOM_POTION_EFFECT, 4800)}).setRegistryName("longer_your_potion");

    public static void registerPotions()
    {
        registerPotions(CUSTOM_PONGER, LONGER_CUSTOM_POTION, CUSTOM_POTION_EFFECT);

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
        PotionHelper.addMix(CUSTOM_PONGER, Items.REDSTONE, LONGER_CUSTOM_POTION);
        PotionHelper.addMix(PotionTypes.MUNDANE, Items.MINECART, CUSTOM_PONGER);
    }

}
