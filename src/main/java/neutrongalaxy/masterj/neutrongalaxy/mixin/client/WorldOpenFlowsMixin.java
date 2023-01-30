package neutrongalaxy.masterj.neutrongalaxy.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Lifecycle;
import it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ConfirmScreen;
import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import net.minecraft.client.gui.screens.worldselection.WorldOpenFlows;
import net.minecraft.client.gui.screens.worldselection.WorldSelectionList;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WorldOpenFlows.class)
public abstract class WorldOpenFlowsMixin
{
    /**
     * Prevent Forge from rendering the little warning sign with the "this world may break at any time" tooltip, because it's nonsense.
     */
    @Inject(method = "confirmWorldCreation", at = @At("HEAD"), remap = false)
    private static void ignoreExperimentalTextOnCreate(Minecraft pMinecraft, CreateWorldScreen p_233128_, Lifecycle p_233129_, Runnable p_233130_, CallbackInfo ci)
    {
        BooleanConsumer booleanconsumer = (p_233154_) -> {
            if (p_233154_) {
                p_233130_.run();
            } else {
                pMinecraft.setScreen(p_233128_);
            }

        };
        if (p_233129_ == Lifecycle.stable()) {
            p_233130_.run();
        } else if (p_233129_ == Lifecycle.experimental()) {
            p_233130_.run();
        } else {
            pMinecraft.setScreen(new ConfirmScreen(booleanconsumer, Component.translatable("selectWorld.import_worldgen_settings.deprecated.title"), Component.translatable("selectWorld.import_worldgen_settings.deprecated.question")));
        }
//        ci.cancel();
    }
}