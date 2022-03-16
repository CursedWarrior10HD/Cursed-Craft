package net.cursedwarrior.cursedcraft.util;

import net.cursedwarrior.cursedcraft.Item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class ModItemProperties {
    public static void addCustomItemProperties() {
    makeBow(ModItems.STEEL_BOW.get());
    makeFishingRod(ModItems.STEEL_FISHING_ROD.get());
    makeElytra(ModItems.STEEL_ELYTRA.get());
    }

    private static void makeBow(Item Item) {
        ItemProperties.register(Item, new ResourceLocation("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
            if (p_174637_ == null) {
                return 0.0F;
            } else {
                return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() -
                        p_174637_.getUseItemRemainingTicks()) / 15.0F;
            }
        });
        ItemProperties.register(Item, new ResourceLocation("pulling"), (p_174630_, p_174631_, p_174632_, p_174633_) -> {
            return p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F : 0.0F;
        });
    }

    private static void makeFishingRod(Item Item) {
        ItemProperties.register(Item, new ResourceLocation("cast"), (p_174595_, p_174596_, p_174597_, p_174598_) -> {
            if (p_174597_ == null) {
                return 0.0F;
            } else {
                boolean flag = p_174597_.getMainHandItem() == p_174595_;
                boolean flag1 = p_174597_.getOffhandItem() == p_174595_;
                if (p_174597_.getMainHandItem().getItem() instanceof FishingRodItem) {
                    flag1 = false;
                }

                return (flag || flag1) && p_174597_ instanceof Player && ((Player)p_174597_).fishing != null ? 1.0F : 0.0F;
            }
        });

    }

    private static void makeElytra(Item Item) {
        ItemProperties.register(Item, new ResourceLocation("broken"), (p_174600_, p_174601_, p_174602_, p_174603_) -> {
            return ElytraItem.isFlyEnabled(p_174600_) ? 0.0F : 1.0F;
        });

    }
}
