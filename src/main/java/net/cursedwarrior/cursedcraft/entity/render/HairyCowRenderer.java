package net.cursedwarrior.cursedcraft.entity.render;

import net.cursedwarrior.cursedcraft.CursedCraft;
import net.cursedwarrior.cursedcraft.entity.custom.HairyCow;
import net.cursedwarrior.cursedcraft.entity.model.HairyCowModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class HairyCowRenderer<Type extends HairyCow> extends MobRenderer<Type, HairyCowModel<Type>> {

    private static final ResourceLocation TEXTURE
            = new ResourceLocation(CursedCraft.MOD_ID, "textures/entities/hairy_cow.png");

    public HairyCowRenderer(EntityRendererProvider.Context context) {
        super(context, new HairyCowModel<>(context.bakeLayer(HairyCowModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }
}
