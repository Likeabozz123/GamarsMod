package GamarsMod.init;

import GamarsMod.objects.enchantments.CustomEnchantment;
import GamarsMod.util.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

@EventBusSubscriber
/*@ObjectHolder(Reference.MOD_ID)*/
public class EnchantmentInit {

    public static final ArrayList<Enchantment> ENCHANTMENTS = new ArrayList<Enchantment>();

    public static final Enchantment CUSTOM_ENCHANTMENT = null;

    @SubscribeEvent // Tell forge the below method is an event handler
    public static void registerEnchantments(final RegistryEvent.Register<Enchantment> event) { // Handle the Registry event for Block objects.
        final IForgeRegistry<Enchantment> registry = event.getRegistry(); // Store registry here to save redundant code

        registerEnchantment(registry, new CustomEnchantment("custom_enchantment"));

    }

    @SubscribeEvent // Another event handler
    public static void registerEnchantmentModels(final RegistryEvent.Register<Enchantment> event) {
        final IForgeRegistry<Enchantment> registry = event.getRegistry(); // Store registry here to save redundant code

        for (Enchantment enchantment : ENCHANTMENTS) {
            // registry.register(enchantment);
        }
    }

    private static void registerEnchantment(IForgeRegistry<Enchantment> registry, Enchantment enchantment) { // Make a helper method to reduce redundant code
        registry.register(enchantment); // Register our block officially here
        ENCHANTMENTS.add(enchantment); // Add the block to our registration list here so we can do their items soon
        // ModelLoader.setCustomModelResourceLocation(enchantment, 0, new ModelResourceLocation(enchantment.getRegistryName(), "inventory"));
    }

    @SubscribeEvent
    public static void customEnchantFunction(LivingUpdateEvent event) {

        EntityLivingBase living = event.getEntityLiving();
        // int level = EnchantmentHelper.getMaxEnchantmentLevel(CUSTOM_ENCHANTMENT, living);
        BlockPos pos = living.getPosition();
        World world = event.getEntity().world;

    }

}
