package neutrongalaxy.masterj.neutrongalaxy;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import neutrongalaxy.masterj.neutrongalaxy.events.ClientEvents;
import neutrongalaxy.masterj.neutrongalaxy.init.BlockInit;
import neutrongalaxy.masterj.neutrongalaxy.init.EntityInit;
import neutrongalaxy.masterj.neutrongalaxy.init.ItemInit;
import neutrongalaxy.masterj.neutrongalaxy.networking.ModPackets;
import org.jetbrains.annotations.NotNull;

@Mod(NeutronGalaxy.MODID)
public class NeutronGalaxy {
    public static final String MODID = "neutrongalaxy";

    public NeutronGalaxy() {
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ClientEvents.launch = false;
        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);
        EntityInit.ENTITIES.register(bus);
        bus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        ModPackets.register();
    }

    public static final CreativeModeTab TAB = new CreativeModeTab(NeutronGalaxy.MODID) {
        @Override
        public @NotNull ItemStack makeIcon() {
            return BlockInit.PLUTO_ROCK.get().asItem().getDefaultInstance();
        }
    };
}
