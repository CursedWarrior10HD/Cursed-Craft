package net.cursedwarrior.cursedcraft;


import com.mojang.logging.LogUtils;
import net.cursedwarrior.cursedcraft.Item.ModItems;
import net.cursedwarrior.cursedcraft.block.ModBlocks;
import net.cursedwarrior.cursedcraft.enchantments.ModEnchantments;
import net.cursedwarrior.cursedcraft.entity.ModEntities;
import net.cursedwarrior.cursedcraft.event.ModEvents;
import net.cursedwarrior.cursedcraft.painting.ModPaintings;
import net.cursedwarrior.cursedcraft.util.ModItemProperties;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(CursedCraft.MOD_ID)
public class CursedCraft {
    public static final String MOD_ID = "cursedcraft";

    private static final Logger LOGGER = LogUtils.getLogger();


    public CursedCraft() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModPaintings.register(eventBus);
        ModEnchantments.register(eventBus);
        ModEntities.register(eventBus);



        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CURSED_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CURSED_TRAPDOOR.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CURSED_LEAVES.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CURSED_SAPLING.get(), RenderType.cutoutMipped());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.YELLOW_ROSE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_YELLOW_ROSE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.STEEL_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TOMATO_PLANT.get(), RenderType.cutout());


        ModItemProperties.addCustomItemProperties();


    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.YELLOW_ROSE.getId(), ModBlocks.POTTED_YELLOW_ROSE);
        });
    }
}