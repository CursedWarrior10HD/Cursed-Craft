package net.cursedwarrior.cursedcraft.painting;

import net.cursedwarrior.cursedcraft.CursedCraft;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<Motive> PAINTING_MOTIVE =
        DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, CursedCraft.MOD_ID);

    public static final RegistryObject<Motive> TOMATO_FARM =
            PAINTING_MOTIVE.register("tomato_farm", () -> new Motive(32,16));

    public static void register(IEventBus eventBus) {
        PAINTING_MOTIVE.register(eventBus);
    }
}
