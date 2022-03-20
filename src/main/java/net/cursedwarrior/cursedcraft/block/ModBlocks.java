package net.cursedwarrior.cursedcraft.block;

import net.cursedwarrior.cursedcraft.CursedCraft;
import net.cursedwarrior.cursedcraft.Item.ModCreativeModeTab;
import net.cursedwarrior.cursedcraft.Item.ModItems;
import net.cursedwarrior.cursedcraft.block.custom.ModFlammableRotatedPillarBlock;
import net.cursedwarrior.cursedcraft.block.custom.SpeedySteelBlockBlock;
import net.cursedwarrior.cursedcraft.block.custom.TomatoPlantBlock;
import net.cursedwarrior.cursedcraft.world.feature.tree.CursedTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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

    public static final RegistryObject<Block> YELLOW_ROSE = registerBlock("yellow_rose",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 8,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.Cursed_CRAFT);
    public static final RegistryObject<Block> POTTED_YELLOW_ROSE = registerBlockWithotBlockItem("potted_yellow_rose",
            () -> new FlowerPotBlock(null, ModBlocks.YELLOW_ROSE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));

    public static final RegistryObject<Block> STEEL_GLASS = registerBlock("steel_glass",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()),
            ModCreativeModeTab.Cursed_CRAFT);

    public static final RegistryObject<Block> TOMATO_PLANT = registerBlockWithotBlockItem("tomato_plant",
            () -> new TomatoPlantBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));

    public static final RegistryObject<Block> CURSED_LOG = registerBlock("cursed_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)),
            ModCreativeModeTab.Cursed_CRAFT);
    public static final RegistryObject<Block> CURSED_WOOD = registerBlock("cursed_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)),
            ModCreativeModeTab.Cursed_CRAFT);
    public static final RegistryObject<Block> STRIPPED_CURSED_LOG = registerBlock("stripped_cursed_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)),
            ModCreativeModeTab.Cursed_CRAFT);
    public static final RegistryObject<Block> STRIPPED_CURSED_WOOD = registerBlock("stripped_cursed_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)),
            ModCreativeModeTab.Cursed_CRAFT);

    public static final RegistryObject<Block> CURSED_LEAVES = registerBlock("cursed_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            }, ModCreativeModeTab.Cursed_CRAFT);


    public static final RegistryObject<Block> CURSED_SAPLING = registerBlock("cursed_sapling",
            () -> new SaplingBlock(new CursedTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.Cursed_CRAFT);




    public static final RegistryObject<Block> CURSED_PLANKS = registerBlock("cursed_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }, ModCreativeModeTab.Cursed_CRAFT);

    private static <T extends Block> RegistryObject<T> registerBlockWithotBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }


    public static final RegistryObject<Block> SPEEDY_STEEL_BLOCK = registerBlock("speedy_steel_block",
            () -> new SpeedySteelBlockBlock(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.Cursed_CRAFT, "tooltip.cursedcraft.block.speedy.steel.block");



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