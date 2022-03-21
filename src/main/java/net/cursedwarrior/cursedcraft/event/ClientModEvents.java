package net.cursedwarrior.cursedcraft.event;

import net.cursedwarrior.cursedcraft.CursedCraft;
import net.cursedwarrior.cursedcraft.entity.ModEntities;
import net.cursedwarrior.cursedcraft.entity.custom.HairyCow;
import net.cursedwarrior.cursedcraft.entity.model.HairyCowModel;
import net.cursedwarrior.cursedcraft.entity.render.HairyCowRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CursedCraft.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public final class ClientModEvents {

    private ClientModEvents() {}

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(HairyCowModel.LAYER_LOCATION, HairyCowModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.HAIRY_COW.get(), HairyCowRenderer::new);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.HAIRY_COW.get(), HairyCow.createAttributes().build());
    }

}
