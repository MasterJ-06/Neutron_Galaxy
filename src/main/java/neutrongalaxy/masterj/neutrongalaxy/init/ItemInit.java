package neutrongalaxy.masterj.neutrongalaxy.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.SpawnEggItem;
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
    public static final RegistryObject<Item> COFFEE = ItemInit.ITEMS.register("coffee",
            () -> new DRINK(new Item.Properties().tab(NeutronGalaxy.TAB).food(Foods.COFFEE)));
    public static final RegistryObject<Item> ROCKET = ItemInit.ITEMS.register("rocket",
            () -> new RocketItem(new Item.Properties().tab(NeutronGalaxy.TAB)));

    public static class Foods {
        public static final FoodProperties COFFEE = new FoodProperties.Builder()
                .nutrition(6)
                .saturationMod(0.6f)
                .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 1200, 4), 0.97f)
                .build();
    }
}

//add coffee as food