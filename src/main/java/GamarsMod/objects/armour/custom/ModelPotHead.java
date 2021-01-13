package GamarsMod.objects.armour.custom;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelCustomArmour - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelPotHead extends ModelBiped {

    public ModelRenderer potHead;

    public ModelPotHead() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.potHead = new ModelRenderer(this, 64, 0);
        this.potHead.setRotationPoint(-5.0F, -9.6F, -5.0F);
        this.potHead.addBox(0.0F, 0.0F, 0.0F, 10, 6, 10, 0.0F);

        this.bipedHead.addChild(potHead);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        super.render(entity, f, f1, f2, f3, f4, f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
