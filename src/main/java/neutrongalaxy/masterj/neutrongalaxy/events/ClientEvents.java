package neutrongalaxy.masterj.neutrongalaxy.events;

import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import neutrongalaxy.masterj.neutrongalaxy.NeutronGalaxy;
import neutrongalaxy.masterj.neutrongalaxy.client.gui.screens.PlanetTempOverlay;
import neutrongalaxy.masterj.neutrongalaxy.client.gui.screens.SpaceScreen;
import neutrongalaxy.masterj.neutrongalaxy.entities.RocketEntity;
import neutrongalaxy.masterj.neutrongalaxy.networking.ModPackets;
import neutrongalaxy.masterj.neutrongalaxy.networking.packet.MoveRocketC2SPacket;
import neutrongalaxy.masterj.neutrongalaxy.networking.packet.MoveRocketDownC2SPacket;
import neutrongalaxy.masterj.neutrongalaxy.networking.packet.RequestDestPlanetS2CPacket;
import neutrongalaxy.masterj.neutrongalaxy.sounds.ModSounds;
import neutrongalaxy.masterj.neutrongalaxy.util.KeyBinding;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class ClientEvents {

    public static boolean launch;

    @Mod.EventBusSubscriber(modid = NeutronGalaxy.MODID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if (KeyBinding.LAUNCH_KEY.consumeClick()) {
//                launch = true;
                assert Minecraft.getInstance().player != null;
                if (Minecraft.getInstance().player.getRootVehicle() instanceof RocketEntity entity) {
                    launch = true;
                    entity.setLaunch(launch);
//                    move_rocket();
//                    ModPackets.sendToServer(new MoveRocketC2SPacket());
                }
            }
        }

//        @SubscribeEvent
//        public static void ticks(TickEvent.PlayerTickEvent event) {
//            if (Minecraft.getInstance().player != null) {
//                if (Minecraft.getInstance().player.getRootVehicle() instanceof RocketEntity) {
//                    if (launch) {
//                        move_rocket();
////                        ModPackets.sendToServer(new MoveRocketC2SPacket());
//                    }
//                } else {
//                    launch = false;
//                    ModPackets.sendToServer(new MoveRocketDownC2SPacket());
//                }
//            }
//        }
//
//        private static void move_rocket() {
//            assert Minecraft.getInstance().player != null;
//            if (Minecraft.getInstance().player.getRootVehicle().getY() <= 151) {
//                Minecraft.getInstance().player.getRootVehicle().setDeltaMovement(Minecraft.getInstance().player.getRootVehicle().getDeltaMovement().add(0.0D, 0.01D, 0.0D));
//                Minecraft.getInstance().player.getRootVehicle().move(MoverType.SELF, Minecraft.getInstance().player.getRootVehicle().getDeltaMovement());
//            } else if (Minecraft.getInstance().player.getRootVehicle().getY() >= 151) {
//                Minecraft.getInstance().player.getRootVehicle().setDeltaMovement(Vec3.ZERO);
//                Minecraft.getInstance().player.getRootVehicle().move(MoverType.SELF, Minecraft.getInstance().player.getRootVehicle().getDeltaMovement());
//                assert Minecraft.getInstance().player != null;
//                if (!(Minecraft.getInstance().screen instanceof SpaceScreen)) {
//                    Minecraft.getInstance().player.playSound(ModSounds.SPACE_MUSIC.get(), 0.5f, 1f);
//                    Minecraft.getInstance().setScreen(new SpaceScreen());
//                }
//            }
//        }
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
