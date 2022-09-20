package neutrongalaxy.masterj.neutrongalaxy.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import neutrongalaxy.masterj.neutrongalaxy.NeutronGalaxy;
import net.minecraft.world.item.Item;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NeutronGalaxy.MODID);

    public static final RegistryObject<Item> ALUMINIUM_INGOT = ItemInit.ITEMS.register("aluminium_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> BRASS_INGOT = ItemInit.ITEMS.register("brass_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> BRONZE_INGOT = ItemInit.ITEMS.register("bronze_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> COBALT_INGOT = ItemInit.ITEMS.register("cobalt_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> COPPER_INGOT = ItemInit.ITEMS.register("copper_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> NICKEL_INGOT = ItemInit.ITEMS.register("nickel_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> OPAL = ItemInit.ITEMS.register("opal", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> PLATINUM_INGOT = ItemInit.ITEMS.register("platinum_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> RUBY = ItemInit.ITEMS.register("ruby", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> SILVER_INGOT = ItemInit.ITEMS.register("silver_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> STEEL_INGOT = ItemInit.ITEMS.register("steel_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> THERMAL_FABRIC = ItemInit.ITEMS.register("thermal_fabric", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> TIN_INGOT = ItemInit.ITEMS.register("tin_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> ROCKET_WINDOW = ItemInit.ITEMS.register("rocket_window", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> STEEL_PLATE = ItemInit.ITEMS.register("steel_plate", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> ALUMINIUM_PLATE = ItemInit.ITEMS.register("aluminium_plate", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> IRON_PLATE = ItemInit.ITEMS.register("iron_plate", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> SILICON = ItemInit.ITEMS.register("silicon", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> SULFUR_INGOT = ItemInit.ITEMS.register("sulfur", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<BlockItem> MOON_DIRT = ItemInit.ITEMS.register("moon_dirt", () -> new BlockItem(BlockInit.MOON_DIRT.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<BlockItem> MERCURY_STONE = ItemInit.ITEMS.register("mercury_stone", () -> new BlockItem(BlockInit.MERCURY_STONE.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<BlockItem> MERCURY_GRAVEL = ItemInit.ITEMS.register("mercury_gravel", () -> new BlockItem(BlockInit.MERCURY_GRAVEL.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<BlockItem> MOON_ROCK = ItemInit.ITEMS.register("moon_rock", () -> new BlockItem(BlockInit.MOON_ROCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<BlockItem> PLUTO_ROCK = ItemInit.ITEMS.register("pluto_rock", () -> new BlockItem(BlockInit.PLUTO_ROCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<BlockItem> JUPITER_ROCK = ItemInit.ITEMS.register("jupiter_rock", () -> new BlockItem(BlockInit.JUPITER_ROCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<BlockItem> JUPITER_STONE = ItemInit.ITEMS.register("jupiter_stone", () -> new BlockItem(BlockInit.JUPITER_STONE.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<BlockItem> LAUNCH_PAD = ItemInit.ITEMS.register("launch_pad", () -> new BlockItem(BlockInit.LAUNCH_PAD.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<BlockItem> MARS_DUST = ItemInit.ITEMS.register("mars_dust", () -> new BlockItem(BlockInit.MARS_DUST.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<BlockItem> VENUS_DUST = ItemInit.ITEMS.register("venus_dust", () -> new BlockItem(BlockInit.VENUS_DUST.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<BlockItem> VENUS_ROCK = ItemInit.ITEMS.register("venus_rock", () -> new BlockItem(BlockInit.VENUS_ROCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<BlockItem> VENUS_STONE = ItemInit.ITEMS.register("venus_stone", () -> new BlockItem(BlockInit.VENUS_STONE.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
}

//add coffee as food