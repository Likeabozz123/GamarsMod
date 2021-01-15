package GamarsMod.objects.blocks.custom.pedestal;

import GamarsMod.Main;
import GamarsMod.init.BlockInit;
import GamarsMod.objects.blocks.machines.sinteringfurnace.ContainerSinteringFurnace;
import GamarsMod.objects.blocks.machines.sinteringfurnace.TileEntitySinteringFurnace;
import GamarsMod.util.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntityNote;
import net.minecraft.util.ResourceLocation;

public class GuiPedestal extends GuiContainer {

    private static final ResourceLocation BG_TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/gui/pedestal.png");
    private final InventoryPlayer player;
    private final TileEntityPedestal tileentity;

/*    public GuiPedestal(Container container, InventoryPlayer playerInv) {
        super(container);
        this.playerInv = playerInv;
    }*/

    public GuiPedestal(InventoryPlayer player, TileEntityPedestal tileentity) {
        super(new ContainerPedestal(player, tileentity));
        this.player = player;
        this.tileentity = tileentity;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1, 1, 1, 1);
        mc.getTextureManager().bindTexture(BG_TEXTURE);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String name = I18n.format(BlockInit.PEDESTAL.getUnlocalizedName() + ".name");
        fontRenderer.drawString(name, xSize / 2 - fontRenderer.getStringWidth(name) / 2, 6, 0x404040);
        fontRenderer.drawString(player.getDisplayName().getUnformattedText(), 8, ySize - 94, 0x404040);
    }

}
