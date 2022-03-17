package net.cursedwarrior.cursedcraft.world;

import net.cursedwarrior.cursedcraft.CursedCraft;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.cursedwarrior.cursedcraft.world.gen.ModFlowerGeneration;


@Mod.EventBusSubscriber(modid = CursedCraft.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModFlowerGeneration.generateFlowers(event);

    }
}