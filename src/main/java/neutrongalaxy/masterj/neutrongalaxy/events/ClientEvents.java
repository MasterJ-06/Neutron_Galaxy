package neutrongalaxy.masterj.neutrongalaxy.events;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import neutrongalaxy.masterj.neutrongalaxy.NeutronGalaxy;
import neutrongalaxy.masterj.neutrongalaxy.client.gui.screens.PlanetTempOverlay;
import neutrongalaxy.masterj.neutrongalaxy.entities.RocketEntity;
import neutrongalaxy.masterj.neutrongalaxy.util.KeyBinding;

@OnlyIn(Dist.CLIENT)
public class ClientEvents {
    @Mod.EventBusSubscriber(modid = NeutronGalaxy.MODID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if (KeyBinding.LAUNCH_KEY.consumeClick()) {
                assert Minecraft.getInstance().player != null;
                if (Minecraft.getInstance().player.getRootVehicle() instanceof RocketEntity entity) {
                    entity.setLaunch(true);
                }
            }
        }
    }

    @Mod.EventBusSubscriber(modid = NeutronGalaxy.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.LAUNCH_KEY);
        }

        @SubscribeEvent
        public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
            event.registerAboveAll("temp", PlanetTempOverlay.HUD_TEMP);
        }
    }
}
