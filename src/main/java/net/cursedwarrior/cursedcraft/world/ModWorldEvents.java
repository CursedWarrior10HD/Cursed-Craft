package net.cursedwarrior.cursedcraft.world;

import net.cursedwarrior.cursedcraft.CursedCraft;
import net.cursedwarrior.cursedcraft.world.gen.ModTreeGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.cursedwarrior.cursedcraft.world.gen.ModFlowerGeneration;
import net.cursedwarrior.cursedcraft.world.gen.ModOreGeneration;



@Mod.EventBusSubscriber(modid = CursedCraft.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModFlowerGeneration.generateFlowers(event);
        ModOreGeneration.generateOres(event);
        ModTreeGeneration.generateTrees(event);


    }
}