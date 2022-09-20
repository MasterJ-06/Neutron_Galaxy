package neutrongalaxy.masterj.neutrongalaxy;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import neutrongalaxy.masterj.neutrongalaxy.init.BlockInit;
import neutrongalaxy.masterj.neutrongalaxy.init.ItemInit;

@Mod(NeutronGalaxy.MODID)
public class NeutronGalaxy {
    public static final String MODID = "neutrongalaxy";

    public NeutronGalaxy() {
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);
    }
}
