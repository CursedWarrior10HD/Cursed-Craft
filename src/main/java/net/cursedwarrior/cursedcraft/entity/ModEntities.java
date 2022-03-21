package net.cursedwarrior.cursedcraft.entity;

import net.cursedwarrior.cursedcraft.CursedCraft;
import net.cursedwarrior.cursedcraft.entity.custom.HairyCow;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModEntities {

    private ModEntities() {}

    public static final DeferredRegister<EntityType<?>> ENTITIES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, CursedCraft.MOD_ID);

    public static final RegistryObject<EntityType<HairyCow>> HAIRY_COW = ENTITIES.register("hairy_cow",
            () -> EntityType.Builder.of(HairyCow::new, MobCategory.CREATURE).sized(1f,1.2f)
                    .build(new ResourceLocation(CursedCraft.MOD_ID, "hairy_cow").toString()));




    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }



}
