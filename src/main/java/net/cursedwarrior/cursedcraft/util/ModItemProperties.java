package net.cursedwarrior.cursedcraft.util;

import net.cursedwarrior.cursedcraft.Item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;

public class ModItemProperties {
    public static void addCustomItemProperties() {
    makeSteelBow(ModItems.STEEL_BOW.get());
    makeFishingRod(ModItems.STEEL_FISHING_ROD.get());
    makeElytra(ModItems.STEEL_ELYTRA.get());
    makeCrossBow(ModItems.STEEL_CROSSBOW.get());
    }

    private static void makeSteelBow(Item Item) {
        ItemProperties.register(Item, new ResourceLocation("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
            if (p_174637_ == null) {
                return 0.0F;
            } else {
                return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() -
                        p_174637_.getUseItemRemainingTicks()) / 10.0F;
            }
        });
        ItemProperties.register(Item, new ResourceLocation("pulling"), (p_174630_, p_174631_, p_174632_, p_174633_) -> {
            return p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F : 0.0F;
        });
    }

    private static void makeBow(Item Item) {
        ItemProperties.register(Item, new ResourceLocation("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
            if (p_174637_ == null) {
                return 0.0F;
            } else {
                return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() -
                        p_174637_.getUseItemRemainingTicks()) / 20.0F;
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

    private static void makeCrossBow(Item Item) {
        ItemProperties.register(Item, new ResourceLocation("pull"), (p_174620_, p_174621_, p_174622_, p_174623_) -> {
            if (p_174622_ == null) {
                return 0.0F;
            } else {
                return CrossbowItem.isCharged(p_174620_) ? 0.0F : (float)(p_174620_.getUseDuration() - p_174622_.getUseItemRemainingTicks()) / (float)CrossbowItem.getChargeDuration(p_174620_);
            }
        });
        ItemProperties.register(Item, new ResourceLocation("pulling"), (p_174615_, p_174616_, p_174617_, p_174618_) -> {
            return p_174617_ != null && p_174617_.isUsingItem() && p_174617_.getUseItem() == p_174615_ && !CrossbowItem.isCharged(p_174615_) ? 1.0F : 0.0F;
        });
        ItemProperties.register(Item, new ResourceLocation("charged"), (p_174610_, p_174611_, p_174612_, p_174613_) -> {
            return p_174612_ != null && CrossbowItem.isCharged(p_174610_) ? 1.0F : 0.0F;
        });
        ItemProperties.register(Item, new ResourceLocation("firework"), (p_174605_, p_174606_, p_174607_, p_174608_) -> {
            return p_174607_ != null && CrossbowItem.isCharged(p_174605_) && CrossbowItem.containsChargedProjectile(p_174605_, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
        });
    }
}
