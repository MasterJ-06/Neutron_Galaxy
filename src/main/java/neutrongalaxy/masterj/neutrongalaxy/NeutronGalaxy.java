package neutrongalaxy.masterj.neutrongalaxy;

import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import neutrongalaxy.masterj.neutrongalaxy.events.ClientEvents;
import neutrongalaxy.masterj.neutrongalaxy.init.BlockInit;
import neutrongalaxy.masterj.neutrongalaxy.init.EntityInit;
import neutrongalaxy.masterj.neutrongalaxy.init.ItemInit;
import neutrongalaxy.masterj.neutrongalaxy.networking.ModPackets;
import neutrongalaxy.masterj.neutrongalaxy.sounds.ModSounds;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

@Mod(NeutronGalaxy.MODID)
public class NeutronGalaxy {
    public static final String MODID = "neutrongalaxy";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public NeutronGalaxy() {
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ClientEvents.launch = false;
        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);
        EntityInit.ENTITIES.register(bus);
        ModSounds.register(bus);
        bus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        ModPackets.register();
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }

    public static final CreativeModeTab TAB = new CreativeModeTab(NeutronGalaxy.MODID) {
        @Override
        public @NotNull ItemStack makeIcon() {
            return BlockInit.PLUTO_ROCK.get().asItem().getDefaultInstance();
        }
    };
}
