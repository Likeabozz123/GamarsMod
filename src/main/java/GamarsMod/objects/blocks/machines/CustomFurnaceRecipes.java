package GamarsMod.objects.blocks.machines;

import GamarsMod.init.ItemInit;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Map;

public class CustomFurnaceRecipes {

    private static final CustomFurnaceRecipes INSTANCE = new CustomFurnaceRecipes();
    private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
    private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

    public static CustomFurnaceRecipes getInstance()
    {
        return INSTANCE;
    }

    private CustomFurnaceRecipes()
    {
        addCustomRecipe(new ItemStack(ItemInit.ENDERITE_SHARD), new ItemStack(ItemInit.SHATTERED_PEARL), new ItemStack(ItemInit.CORRUPTED_PEARL), 1.0F);
    }


    public void addCustomRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience)
    {
        if(getCustomResult(input1, input2) != ItemStack.EMPTY) return;
        this.smeltingList.put(input1, input2, result);
        this.experienceList.put(result, Float.valueOf(experience));
    }

    public ItemStack getCustomResult(ItemStack input1, ItemStack input2)
    {
        for(Map.Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet())
        {
            if(this.compareItemStacks(input1, (ItemStack)entry.getKey()))
            {
                for(Map.Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet())
                {
                    if(this.compareItemStacks(input2, (ItemStack)ent.getKey()))
                    {
                        return (ItemStack)ent.getValue();
                    }
                }
            }
        }
        return ItemStack.EMPTY;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList()
    {
        return this.smeltingList;
    }

    public float getCustomExperience(ItemStack stack)
    {
        for (Map.Entry<ItemStack, Float> entry : this.experienceList.entrySet())
        {
            if(this.compareItemStacks(stack, (ItemStack)entry.getKey()))
            {
                return ((Float)entry.getValue()).floatValue();
            }
        }
        return 0.0F;
    }
}
