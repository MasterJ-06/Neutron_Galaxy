package neutrongalaxy.masterj.neutrongalaxy.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import neutrongalaxy.masterj.neutrongalaxy.NeutronGalaxy;
import net.minecraft.world.item.Item;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NeutronGalaxy.MODID);

    public static final RegistryObject<Item> ALUMINIUM_INGOT = ItemInit.ITEMS.register("aluminium_ingot",
            () -> new Item(new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<Item> BRASS_INGOT = ItemInit.ITEMS.register("brass_ingot",
            () -> new Item(new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<Item> BRONZE_INGOT = ItemInit.ITEMS.register("bronze_ingot",
            () -> new Item(new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<Item> COBALT_INGOT = ItemInit.ITEMS.register("cobalt_ingot",
            () -> new Item(new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<Item> COPPER_INGOT = ItemInit.ITEMS.register("copper_ingot",
            () -> new Item(new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<Item> NICKEL_INGOT = ItemInit.ITEMS.register("nickel_ingot",
            () -> new Item(new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<Item> OPAL = ItemInit.ITEMS.register("opal",
            () -> new Item(new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<Item> PLATINUM_INGOT = ItemInit.ITEMS.register("platinum_ingot",
            () -> new Item(new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<Item> RUBY = ItemInit.ITEMS.register("ruby",
            () -> new Item(new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<Item> SILVER_INGOT = ItemInit.ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<Item> STEEL_INGOT = ItemInit.ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<Item> THERMAL_FABRIC = ItemInit.ITEMS.register("thermal_fabric",
            () -> new Item(new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<Item> TIN_INGOT = ItemInit.ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<Item> ROCKET_WINDOW = ItemInit.ITEMS.register("rocket_window",
            () -> new Item(new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<Item> STEEL_PLATE = ItemInit.ITEMS.register("steel_plate",
            () -> new Item(new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<Item> ALUMINIUM_PLATE = ItemInit.ITEMS.register("aluminium_plate",
            () -> new Item(new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<Item> IRON_PLATE = ItemInit.ITEMS.register("iron_plate",
            () -> new Item(new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<Item> SILICON = ItemInit.ITEMS.register("silicon",
            () -> new Item(new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<Item> SULFUR_INGOT = ItemInit.ITEMS.register("sulfur",
            () -> new Item(new Item.Properties().tab(NeutronGalaxy.TAB)));
}

//add coffee as food