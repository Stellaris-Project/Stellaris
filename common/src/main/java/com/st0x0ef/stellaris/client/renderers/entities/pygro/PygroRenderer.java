package com.st0x0ef.stellaris.client.renderers.entities.pygro;

import com.st0x0ef.beyond_earth.BeyondEarth;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PygroRenderer extends HumanoidMobRenderer<Mob, PygroModel<Mob>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(BeyondEarth.MODID, "textures/entity/pygro.png");

    public PygroRenderer(EntityRendererProvider.Context context, ModelLayerLocation p_174345_, ModelLayerLocation p_174346_, ModelLayerLocation p_174347_) {
        super(context, createModel(context.getModelSet(), p_174345_), 0.5F, 1.0019531F, 1.0F, 1.0019531F);
        this.addLayer(new HumanoidArmorLayer<>(this, new HumanoidModel<>(context.bakeLayer(p_174346_)), new HumanoidModel<>(context.bakeLayer(p_174347_)), context.getModelManager()));
    }

    private static PygroModel<Mob> createModel(EntityModelSet p_174350_, ModelLayerLocation p_174351_) {

        return new PygroModel<>(p_174350_.bakeLayer(p_174351_));
    }

    public ResourceLocation getTextureLocation(Mob p_115708_) {
        return TEXTURE;
    }

    protected boolean isShaking(Mob p_115712_) {
        return super.isShaking(p_115712_) || p_115712_ instanceof AbstractPiglin && ((AbstractPiglin)p_115712_).isConverting();
    }
}