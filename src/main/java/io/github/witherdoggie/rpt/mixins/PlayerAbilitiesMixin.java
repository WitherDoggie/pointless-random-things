package io.github.witherdoggie.rpt.mixins;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.world.GameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMode.class)
public class PlayerAbilitiesMixin {

    @Inject(method = "setAbilities", at = @At("TAIL"))
    private void unsetInvulnerable(PlayerAbilities abilities, CallbackInfo ci) {
            abilities.allowFlying = true;
            abilities.creativeMode = true;
            abilities.invulnerable = false;
    }
}
