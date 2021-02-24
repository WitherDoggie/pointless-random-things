package io.github.witherdoggie.rpt.effects;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.player.PlayerEntity;

public class StepHeightEffect extends StatusEffect {

    public StepHeightEffect() {
        super(StatusEffectType.BENEFICIAL, 0x225);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean isInstant() {
        return true;
    }

    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {

        if(entity instanceof PlayerEntity){
            MinecraftClient.getInstance().player.stepHeight = 0.0f;
        }
        else {
            entity.stepHeight = 1.0f;
        }
        super.onRemoved(entity, attributes, amplifier);
    }

    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {

        if(entity instanceof PlayerEntity){
            MinecraftClient.getInstance().player.stepHeight = 3.0f;
        }
        else {
            entity.stepHeight = 3.0f;
        }
        super.onApplied(entity, attributes, amplifier);
    }
}
