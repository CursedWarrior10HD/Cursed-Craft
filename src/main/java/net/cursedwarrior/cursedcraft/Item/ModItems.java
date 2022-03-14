package net.cursedwarrior.cursedcraft.Item;

import net.cursedwarrior.cursedcraft.CursedCraft;
import net.cursedwarrior.cursedcraft.Item.custom.SteelDowsingRodItem;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CursedCraft.MOD_ID);

    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.Cursed_CRAFT)));

    public static final RegistryObject<Item> RAW_STEEL = ITEMS.register("raw_steel",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.Cursed_CRAFT)));

    public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.Cursed_CRAFT)));

    public static final RegistryObject<Item> STEEL_DOWSING_ROD = ITEMS.register("steel_dowsing_rod",
            () -> new SteelDowsingRodItem(new Item.Properties().tab(ModCreativeModeTab.Cursed_CRAFT).durability(16)));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }


}
