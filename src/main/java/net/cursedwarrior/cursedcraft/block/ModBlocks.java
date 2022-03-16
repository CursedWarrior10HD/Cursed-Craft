package net.cursedwarrior.cursedcraft.block;

import net.cursedwarrior.cursedcraft.CursedCraft;
import net.cursedwarrior.cursedcraft.Item.ModCreativeModeTab;
import net.cursedwarrior.cursedcraft.Item.ModItems;
import net.cursedwarrior.cursedcraft.block.custom.SpeedySteelBlockBlock;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CursedCraft.MOD_ID);

    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.Cursed_CRAFT);

    public static final RegistryObject<Block> STEEL_ORE = registerBlock("steel_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE)
                    .strength(3f).requiresCorrectToolForDrops()), ModCreativeModeTab.Cursed_CRAFT);

    public static final RegistryObject<Block> DEEPSLATE_STEEL_ORE = registerBlock("deepslate_steel_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.DEEPSLATE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.Cursed_CRAFT);

    public static final RegistryObject<Block> CURSED_PLANKS = registerBlock("cursed_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.Cursed_CRAFT);

    public static final RegistryObject<Block> CURSED_STAIRS = registerBlock("cursed_stairs",
            () -> new StairBlock(() -> ModBlocks.CURSED_PLANKS.get().defaultBlockState()
                    ,BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.Cursed_CRAFT);
    public static final RegistryObject<Block> CURSED_SLAB = registerBlock("cursed_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.Cursed_CRAFT);
    public static final RegistryObject<Block> CURSED_FENCE = registerBlock("cursed_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.Cursed_CRAFT);
    public static final RegistryObject<Block> CURSED_FENCE_GATE = registerBlock("cursed_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.Cursed_CRAFT);
    public static final RegistryObject<Block> CURSED_BUTTON = registerBlock("cursed_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.Cursed_CRAFT);
    public static final RegistryObject<Block> CURSED_PRESSURE_PLATE = registerBlock("cursed_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.Cursed_CRAFT);
    public static final RegistryObject<Block> CURSED_DOOR = registerBlock("cursed_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD)
                    .strength(2f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.Cursed_CRAFT);
    public static final RegistryObject<Block> CURSED_TRAPDOOR = registerBlock("cursed_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD)
                    .strength(2f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.Cursed_CRAFT);


    public static final RegistryObject<Block> SPEEDY_STEEL_BLOCK = registerBlock("speedy_steel_block",
            () -> new SpeedySteelBlockBlock(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.Cursed_CRAFT, "tooltip.cursedcraft.block.speedy.steel.block");



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                     CreativeModeTab tab, String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltipKey);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab, String tooltipKey) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)){
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                pTooltip.add(new TranslatableComponent(tooltipKey));
            }
        });
    }


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