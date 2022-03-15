package net.cursedwarrior.cursedcraft.Item;

import net.cursedwarrior.cursedcraft.CursedCraft;
import net.cursedwarrior.cursedcraft.Item.custom.CoalChunkItem;
import net.cursedwarrior.cursedcraft.Item.custom.FoolsGoldItem;
import net.cursedwarrior.cursedcraft.Item.custom.PoisonSwordItem;
import net.cursedwarrior.cursedcraft.Item.custom.SteelDowsingRodItem;
import net.minecraft.world.item.*;
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

    public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword",
            () -> new SwordItem(ModTiers.STEEL, 2,1f,
                    new Item.Properties().tab(ModCreativeModeTab.Cursed_CRAFT)));
    public static final RegistryObject<Item> POISON_STEEL_SWORD = ITEMS.register("poison_steel_sword",
            () -> new PoisonSwordItem(ModTiers.STEEL, 2,1f,
                    new Item.Properties().tab(ModCreativeModeTab.Cursed_CRAFT)));
    public static final RegistryObject<Item> STEEL_PICKAXE = ITEMS.register("steel_pickaxe",
            () -> new PickaxeItem(ModTiers.STEEL, 1,1f,
                    new Item.Properties().tab(ModCreativeModeTab.Cursed_CRAFT)));
    public static final RegistryObject<Item> STEEL_AXE = ITEMS.register("steel_axe",
            () -> new AxeItem(ModTiers.STEEL, 4,0f,
                    new Item.Properties().tab(ModCreativeModeTab.Cursed_CRAFT)));
    public static final RegistryObject<Item> STEEL_SHOVEL = ITEMS.register("steel_shovel",
            () -> new ShovelItem(ModTiers.STEEL, 0,1f,
                    new Item.Properties().tab(ModCreativeModeTab.Cursed_CRAFT)));
    public static final RegistryObject<Item> STEEL_HOE = ITEMS.register("steel_hoe",
            () -> new HoeItem(ModTiers.STEEL, 0,0f,
                    new Item.Properties().tab(ModCreativeModeTab.Cursed_CRAFT)));

    public static final RegistryObject<Item> STEEL_DOWSING_ROD = ITEMS.register("steel_dowsing_rod",
            () -> new SteelDowsingRodItem(new Item.Properties().tab(ModCreativeModeTab.Cursed_CRAFT).durability(32)));

    public static final RegistryObject<Item> STEEL_SHEARS = ITEMS.register("steel_shears",
            () -> new ShearsItem(new Item.Properties().tab(ModCreativeModeTab.Cursed_CRAFT).durability(1280)));

    public static final RegistryObject<Item> FLINT_AND_IRON = ITEMS.register("flint_and_iron",
            () -> new FlintAndSteelItem(new Item.Properties().tab(ModCreativeModeTab.Cursed_CRAFT).durability(32)));

    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.Cursed_CRAFT).food(ModFoods.TOMATO)));

    public static final RegistryObject<Item> COAL_CHUNK = ITEMS.register("coal_chunk",
            () -> new CoalChunkItem(new Item.Properties().tab(ModCreativeModeTab.Cursed_CRAFT)));

    public static final RegistryObject<Item> FOOLS_GOLD = ITEMS.register("fools_gold",
            () -> new FoolsGoldItem(new Item.Properties().tab(ModCreativeModeTab.Cursed_CRAFT).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> STEEL_HORSE_ARMOR = ITEMS.register("steel_horse_armor",
            () -> new HorseArmorItem(16, "steel",
                    new Item.Properties().tab(ModCreativeModeTab.Cursed_CRAFT)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }


}
