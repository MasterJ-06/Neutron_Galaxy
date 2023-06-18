package neutrongalaxy.masterj.neutrongalaxy;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import neutrongalaxy.masterj.neutrongalaxy.init.*;
import neutrongalaxy.masterj.neutrongalaxy.networking.ModPackets;
import neutrongalaxy.masterj.neutrongalaxy.sounds.ModSounds;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeMessage;

@Mod(NeutronGalaxy.MODID)
public class NeutronGalaxy {
    public static final String MODID = "neutrongalaxy";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public NeutronGalaxy() {
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
//        ClientEvents.launch = false;
        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);
        EntityInit.ENTITIES.register(bus);
        FluidInit.FLUID_TYPES.register(bus);
        FluidInit.FLUIDS.register(bus);
        ModSounds.register(bus);
        DimensionInit.register();
        bus.addListener(this::commonSetup);
        InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("ng_hat").icon(InventoryMenu.EMPTY_ARMOR_SLOT_HELMET).priority(1).build());
        InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("ng_torso").icon(InventoryMenu.EMPTY_ARMOR_SLOT_CHESTPLATE).priority(2).build());
        InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("ng_legs").icon(InventoryMenu.EMPTY_ARMOR_SLOT_LEGGINGS).priority(3).build());
        InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("ng_feet").icon(InventoryMenu.EMPTY_ARMOR_SLOT_BOOTS).priority(4).build());
        NeutronGalaxy.LOGGER.debug("Enqueued IMC to {}", CuriosApi.MODID);
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
