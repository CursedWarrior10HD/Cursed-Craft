package net.cursedwarrior.cursedcraft.Item.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class PoisonSwordItem extends SwordItem {
    public PoisonSwordItem(Tier pTier, int pAttackDamageModifier,
                           float pAttackModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackModifier, pProperties);

    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.addEffect(new MobEffectInstance(MobEffects.POISON, 200), pAttacker);
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
