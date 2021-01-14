package GamarsMod.objects.blocks.machines;

import GamarsMod.objects.blocks.machines.ContainerCustomFurnace;
import GamarsMod.objects.blocks.machines.TileEntityCustomFurnace;
import GamarsMod.util.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiCustomFurnace extends GuiContainer {
    private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/gui/custom_furnace.png");
    private final InventoryPlayer player;
    private final TileEntityCustomFurnace tileentity;


    public GuiCustomFurnace(InventoryPlayer player, TileEntityCustomFurnace tileentity) {

        super(new ContainerCustomFurnace(player, tileentity));
        this.player = player;
        this.tileentity= tileentity;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String tileName = this.tileentity.getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(tileName, (this.xSize / 2 - this.fontRenderer.getStringWidth(tileName) / 2) + 3, 8, 4210752);
        this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 122, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURES);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

        if (TileEntityCustomFurnace.isBurning(tileentity)) {
            int  k = this.getBurnLeftScale(13);
            this.drawTexturedModalRect(this.guiLeft + 8, this.guiTop + 54 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        int l = this.getCockProgressionScaled(24);
        this.drawTexturedModalRect(this.guiLeft + 80, this.guiTop + 41, 176, 14, l + 1, 16);

    }
    private int getBurnLeftScale(int pixels){
        int i = this.tileentity.getField(1);
        if(i == 0) i = 200;
        return this.tileentity.getField(0) * pixels / i;

    }

    private int getCockProgressionScaled(int pixels) {
        int i = this.tileentity.getField(2);
        int j = this.tileentity.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;


    }
}
