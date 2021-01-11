package GamarsMod.recipes;

import GamarsMod.init.BlockInit;
import GamarsMod.init.ItemInit;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingRecipes {

    public static void init()
    {
                                // INPUT                                     // OUTPUT
        GameRegistry.addSmelting(new ItemStack(BlockInit.ANCIENT_DEBRIS),new ItemStack(ItemInit.NETHERITE_SCRAP), 1.0F);

        GameRegistry.addSmelting(new ItemStack(BlockInit.TEST_ORE), new ItemStack(ItemInit.TEST_MATERIAL), 1.0F);
    }

}
