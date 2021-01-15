package GamarsMod.objects.potions;

import GamarsMod.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class CustomPotion extends Potion
{
    public CustomPotion(String name, boolean isBadPotion, int colour, int iconIndexX, int iconIndexY)
    {
        super(isBadPotion, colour);
        setPotionName("effect." + name);
        setIconIndex(iconIndexX, iconIndexY);
        setRegistryName(new ResourceLocation(Reference.MOD_ID + ":" + name));

    }

    @Override
    public boolean hasStatusIcon()
    {
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + "textures/gui/potion_effects.png"));
        return true;

    }













}
