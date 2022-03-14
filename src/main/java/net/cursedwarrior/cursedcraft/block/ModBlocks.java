package net.cursedwarrior.cursedcraft.block;

import net.cursedwarrior.cursedcraft.CursedCraft;
import net.cursedwarrior.cursedcraft.Item.ModCreativeModeTab;
import net.cursedwarrior.cursedcraft.Item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CursedCraft.MOD_ID);

    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(0.15f).requiresCorrectToolForDrops()), ModCreativeModeTab.Cursed_CRAFT);
    public static final RegistryObject<Block> STEEL_ORE = registerBlock("steel_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(0.1f).requiresCorrectToolForDrops()), ModCreativeModeTab.Cursed_CRAFT);
    public static final RegistryObject<Block> DEEPSLATE_STEEL_ORE = registerBlock("deepslate_steel_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.DEEPSLATE)
                    .strength(0.15f).requiresCorrectToolForDrops()), ModCreativeModeTab.Cursed_CRAFT);




    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}