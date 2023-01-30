package neutrongalaxy.masterj.neutrongalaxy.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import neutrongalaxy.masterj.neutrongalaxy.NeutronGalaxy;
import neutrongalaxy.masterj.neutrongalaxy.util.KeyBinding;

public class ClientEvents {

    public static boolean launch;

    @Mod.EventBusSubscriber(modid = NeutronGalaxy.MODID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if (KeyBinding.LAUNCH_KEY.consumeClick()) {
                launch = true;


                // This is used to check for a curio on the player
//                assert Minecraft.getInstance().player != null;
//                try {
//                    NeutronGalaxy.LOGGER.info(new GetCurios().findCurios(Minecraft.getInstance().player, ItemInit.ALUMINIUM_BOOTS.get()).get(0).toString());
//                } catch (IndexOutOfBoundsException e) {
//                    NeutronGalaxy.LOGGER.info("This player does not have an item in this curio.");
//                }
            }
        }
    }

    @Mod.EventBusSubscriber(modid = NeutronGalaxy.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.LAUNCH_KEY);
        }
    }
}
