package GamarsMod.recipes;

import GamarsMod.init.BlockInit;
import GamarsMod.init.ItemInit;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingRecipes {

    public static void init() {

        // TEST BLOCK -> TEST MATERIAL
        ItemStack test_material = new ItemStack(BlockInit.TEST_BLOCK);
        ItemStack test_ingot = new ItemStack(ItemInit.TEST_MATERIAL, 9);
        GameRegistry.addShapelessRecipe(new ResourceLocation("test_material"), null, test_ingot, Ingredient.fromStacks(test_material));
    }
}
