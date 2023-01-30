package neutrongalaxy.masterj.neutrongalaxy.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import neutrongalaxy.masterj.neutrongalaxy.NeutronGalaxy;
import neutrongalaxy.masterj.neutrongalaxy.base.COFFEE;
import neutrongalaxy.masterj.neutrongalaxy.base.DRINK;
import neutrongalaxy.masterj.neutrongalaxy.base.RocketItem;
import neutrongalaxy.masterj.neutrongalaxy.util.ModArmorTiers;
import neutrongalaxy.masterj.neutrongalaxy.util.ModToolTiers;

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
    public static final RegistryObject<Item> SULFUR = ItemInit.ITEMS.register("sulfur",
            () -> new Item(new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<Item> COFFEE = ItemInit.ITEMS.register("coffee",
            () -> new COFFEE(new Item.Properties().tab(NeutronGalaxy.TAB).food(Foods.COFFEE)));
    public static final RegistryObject<Item> CUP = ItemInit.ITEMS.register("cup",
            () -> new Item(new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<Item> ROCKET = ItemInit.ITEMS.register("rocket",
            () -> new RocketItem(new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<SwordItem> ALUMINIUM_SWORD = ItemInit.ITEMS.register("aluminium_sword",
            () -> new SwordItem(ModToolTiers.ALUMINIUM, 3, -2.4f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<PickaxeItem> ALUMINIUM_PICKAXE = ItemInit.ITEMS.register("aluminium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ALUMINIUM, 1, -2.8f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ShovelItem> ALUMINIUM_SHOVEL = ItemInit.ITEMS.register("aluminium_shovel",
            () -> new ShovelItem(ModToolTiers.ALUMINIUM, 1.5f, -3.0f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<AxeItem> ALUMINIUM_AXE = ItemInit.ITEMS.register("aluminium_axe",
            () -> new AxeItem(ModToolTiers.ALUMINIUM, 6, -3.1f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<HoeItem> ALUMINIUM_HOE = ItemInit.ITEMS.register("aluminium_hoe",
            () -> new HoeItem(ModToolTiers.ALUMINIUM, -2, -1.0f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<SwordItem> BRASS_SWORD = ItemInit.ITEMS.register("brass_sword",
            () -> new SwordItem(ModToolTiers.BRASS, 3, -2.4f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<PickaxeItem> BRASS_PICKAXE = ItemInit.ITEMS.register("brass_pickaxe",
            () -> new PickaxeItem(ModToolTiers.BRASS, 1, -2.8f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ShovelItem> BRASS_SHOVEL = ItemInit.ITEMS.register("brass_shovel",
            () -> new ShovelItem(ModToolTiers.BRASS, 1.5f, -3.0f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<AxeItem> BRASS_AXE = ItemInit.ITEMS.register("brass_axe",
            () -> new AxeItem(ModToolTiers.BRASS, 6, -3.1f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<HoeItem> BRASS_HOE = ItemInit.ITEMS.register("brass_hoe",
            () -> new HoeItem(ModToolTiers.BRASS, -2, -1.0f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<SwordItem> BRONZE_SWORD = ItemInit.ITEMS.register("bronze_sword",
            () -> new SwordItem(ModToolTiers.BRONZE, 3, -2.4f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<PickaxeItem> BRONZE_PICKAXE = ItemInit.ITEMS.register("bronze_pickaxe",
            () -> new PickaxeItem(ModToolTiers.BRONZE, 1, -2.8f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ShovelItem> BRONZE_SHOVEL = ItemInit.ITEMS.register("bronze_shovel",
            () -> new ShovelItem(ModToolTiers.BRONZE, 1.5f, -3.0f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<AxeItem> BRONZE_AXE = ItemInit.ITEMS.register("bronze_axe",
            () -> new AxeItem(ModToolTiers.BRONZE, 6, -3.1f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<HoeItem> BRONZE_HOE = ItemInit.ITEMS.register("bronze_hoe",
            () -> new HoeItem(ModToolTiers.BRONZE, -2, -1.0f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<SwordItem> COBALT_SWORD = ItemInit.ITEMS.register("cobalt_sword",
            () -> new SwordItem(ModToolTiers.COBALT, 3, -2.4f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<PickaxeItem> COBALT_PICKAXE = ItemInit.ITEMS.register("cobalt_pickaxe",
            () -> new PickaxeItem(ModToolTiers.COBALT, 1, -2.8f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ShovelItem> COBALT_SHOVEL = ItemInit.ITEMS.register("cobalt_shovel",
            () -> new ShovelItem(ModToolTiers.COBALT, 1.5f, -3.0f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<AxeItem> COBALT_AXE = ItemInit.ITEMS.register("cobalt_axe",
            () -> new AxeItem(ModToolTiers.COBALT, 6, -3.1f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<HoeItem> COBALT_HOE = ItemInit.ITEMS.register("cobalt_hoe",
            () -> new HoeItem(ModToolTiers.COBALT, -2, -1.0f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<SwordItem> COPPER_SWORD = ItemInit.ITEMS.register("copper_sword",
            () -> new SwordItem(ModToolTiers.COPPER, 3, -2.4f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<PickaxeItem> COPPER_PICKAXE = ItemInit.ITEMS.register("copper_pickaxe",
            () -> new PickaxeItem(ModToolTiers.COPPER, 1, -2.8f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ShovelItem> COPPER_SHOVEL = ItemInit.ITEMS.register("copper_shovel",
            () -> new ShovelItem(ModToolTiers.COPPER, 1.5f, -3.0f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<AxeItem> COPPER_AXE = ItemInit.ITEMS.register("copper_axe",
            () -> new AxeItem(ModToolTiers.COPPER, 6, -3.1f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<HoeItem> COPPER_HOE = ItemInit.ITEMS.register("copper_hoe",
            () -> new HoeItem(ModToolTiers.COPPER, -2, -1.0f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<SwordItem> NICKEL_SWORD = ItemInit.ITEMS.register("nickel_sword",
            () -> new SwordItem(ModToolTiers.NICKEL, 3, -2.4f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<PickaxeItem> NICKEL_PICKAXE = ItemInit.ITEMS.register("nickel_pickaxe",
            () -> new PickaxeItem(ModToolTiers.NICKEL, 1, -2.8f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ShovelItem> NICKEL_SHOVEL = ItemInit.ITEMS.register("nickel_shovel",
            () -> new ShovelItem(ModToolTiers.NICKEL, 1.5f, -3.0f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<AxeItem> NICKEL_AXE = ItemInit.ITEMS.register("nickel_axe",
            () -> new AxeItem(ModToolTiers.NICKEL, 6, -3.1f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<HoeItem> NICKEL_HOE = ItemInit.ITEMS.register("nickel_hoe",
            () -> new HoeItem(ModToolTiers.NICKEL, -2, -1.0f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<SwordItem> PLATINUM_SWORD = ItemInit.ITEMS.register("platinum_sword",
            () -> new SwordItem(ModToolTiers.PLATINUM, 3, -2.4f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<PickaxeItem> PLATINUM_PICKAXE = ItemInit.ITEMS.register("platinum_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PLATINUM, 1, -2.8f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ShovelItem> PLATINUM_SHOVEL = ItemInit.ITEMS.register("platinum_shovel",
            () -> new ShovelItem(ModToolTiers.PLATINUM, 1.5f, -3.0f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<AxeItem> PLATINUM_AXE = ItemInit.ITEMS.register("platinum_axe",
            () -> new AxeItem(ModToolTiers.PLATINUM, 6, -3.1f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<HoeItem> PLATINUM_HOE = ItemInit.ITEMS.register("platinum_hoe",
            () -> new HoeItem(ModToolTiers.PLATINUM, -2, -1.0f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<SwordItem> RUBY_SWORD = ItemInit.ITEMS.register("ruby_sword",
            () -> new SwordItem(ModToolTiers.RUBY, 3, -2.4f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<PickaxeItem> RUBY_PICKAXE = ItemInit.ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(ModToolTiers.RUBY, 1, -2.8f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ShovelItem> RUBY_SHOVEL = ItemInit.ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ModToolTiers.RUBY, 1.5f, -3.0f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<AxeItem> RUBY_AXE = ItemInit.ITEMS.register("ruby_axe",
            () -> new AxeItem(ModToolTiers.RUBY, 6, -3.1f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<HoeItem> RUBY_HOE = ItemInit.ITEMS.register("ruby_hoe",
            () -> new HoeItem(ModToolTiers.RUBY, -2, -1.0f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<SwordItem> SILVER_SWORD = ItemInit.ITEMS.register("silver_sword",
            () -> new SwordItem(ModToolTiers.SILVER, 3, -2.4f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<PickaxeItem> SILVER_PICKAXE = ItemInit.ITEMS.register("silver_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SILVER, 1, -2.8f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ShovelItem> SILVER_SHOVEL = ItemInit.ITEMS.register("silver_shovel",
            () -> new ShovelItem(ModToolTiers.SILVER, 1.5f, -3.0f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<AxeItem> SILVER_AXE = ItemInit.ITEMS.register("silver_axe",
            () -> new AxeItem(ModToolTiers.SILVER, 6, -3.1f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<HoeItem> SILVER_HOE = ItemInit.ITEMS.register("silver_hoe",
            () -> new HoeItem(ModToolTiers.SILVER, -2, -1.0f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<SwordItem> STEEL_SWORD = ItemInit.ITEMS.register("steel_sword",
            () -> new SwordItem(ModToolTiers.STEEL, 3, -2.4f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<PickaxeItem> STEEL_PICKAXE = ItemInit.ITEMS.register("steel_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STEEL, 1, -2.8f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ShovelItem> STEEL_SHOVEL = ItemInit.ITEMS.register("steel_shovel",
            () -> new ShovelItem(ModToolTiers.STEEL, 1.5f, -3.0f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<AxeItem> STEEL_AXE = ItemInit.ITEMS.register("steel_axe",
            () -> new AxeItem(ModToolTiers.STEEL, 6, -3.1f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<HoeItem> STEEL_HOE = ItemInit.ITEMS.register("steel_hoe",
            () -> new HoeItem(ModToolTiers.STEEL, -2, -1.0f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<SwordItem> TIN_SWORD = ItemInit.ITEMS.register("tin_sword",
            () -> new SwordItem(ModToolTiers.TIN, 3, -2.4f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<PickaxeItem> TIN_PICKAXE = ItemInit.ITEMS.register("tin_pickaxe",
            () -> new PickaxeItem(ModToolTiers.TIN, 1, -2.8f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ShovelItem> TIN_SHOVEL = ItemInit.ITEMS.register("tin_shovel",
            () -> new ShovelItem(ModToolTiers.TIN, 1.5f, -3.0f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<AxeItem> TIN_AXE = ItemInit.ITEMS.register("tin_axe",
            () -> new AxeItem(ModToolTiers.TIN, 6, -3.1f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<HoeItem> TIN_HOE = ItemInit.ITEMS.register("tin_hoe",
            () -> new HoeItem(ModToolTiers.TIN, -2, -1.0f, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> ALUMINIUM_HELMET = ItemInit.ITEMS.register("aluminium_helmet",
            () -> new ArmorItem(ModArmorTiers.ALUMINIUM, EquipmentSlot.HEAD, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> ALUMINIUM_CHESTPLATE = ItemInit.ITEMS.register("aluminium_chestplate",
            () -> new ArmorItem(ModArmorTiers.ALUMINIUM, EquipmentSlot.CHEST, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> ALUMINIUM_LEGGINGS = ItemInit.ITEMS.register("aluminium_leggings",
            () -> new ArmorItem(ModArmorTiers.ALUMINIUM, EquipmentSlot.LEGS, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> ALUMINIUM_BOOTS = ItemInit.ITEMS.register("aluminium_boots",
            () -> new ArmorItem(ModArmorTiers.ALUMINIUM, EquipmentSlot.FEET, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> BRASS_HELMET = ItemInit.ITEMS.register("brass_helmet",
            () -> new ArmorItem(ModArmorTiers.BRASS, EquipmentSlot.HEAD, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> BRASS_CHESTPLATE = ItemInit.ITEMS.register("brass_chestplate",
            () -> new ArmorItem(ModArmorTiers.BRASS, EquipmentSlot.CHEST, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> BRASS_LEGGINGS = ItemInit.ITEMS.register("brass_leggings",
            () -> new ArmorItem(ModArmorTiers.BRASS, EquipmentSlot.LEGS, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> BRASS_BOOTS = ItemInit.ITEMS.register("brass_boots",
            () -> new ArmorItem(ModArmorTiers.BRASS, EquipmentSlot.FEET, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> BRONZE_HELMET = ItemInit.ITEMS.register("bronze_helmet",
            () -> new ArmorItem(ModArmorTiers.BRONZE, EquipmentSlot.HEAD, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> BRONZE_CHESTPLATE = ItemInit.ITEMS.register("bronze_chestplate",
            () -> new ArmorItem(ModArmorTiers.BRONZE, EquipmentSlot.CHEST, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> BRONZE_LEGGINGS = ItemInit.ITEMS.register("bronze_leggings",
            () -> new ArmorItem(ModArmorTiers.BRONZE, EquipmentSlot.LEGS, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> BRONZE_BOOTS = ItemInit.ITEMS.register("bronze_boots",
            () -> new ArmorItem(ModArmorTiers.BRONZE, EquipmentSlot.FEET, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> COBALT_HELMET = ItemInit.ITEMS.register("cobalt_helmet",
            () -> new ArmorItem(ModArmorTiers.COBALT, EquipmentSlot.HEAD, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> COBALT_CHESTPLATE = ItemInit.ITEMS.register("cobalt_chestplate",
            () -> new ArmorItem(ModArmorTiers.COBALT, EquipmentSlot.CHEST, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> COBALT_LEGGINGS = ItemInit.ITEMS.register("cobalt_leggings",
            () -> new ArmorItem(ModArmorTiers.COBALT, EquipmentSlot.LEGS, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> COBALT_BOOTS = ItemInit.ITEMS.register("cobalt_boots",
            () -> new ArmorItem(ModArmorTiers.COBALT, EquipmentSlot.FEET, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> COPPER_HELMET = ItemInit.ITEMS.register("copper_helmet",
            () -> new ArmorItem(ModArmorTiers.COPPER, EquipmentSlot.HEAD, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> COPPER_CHESTPLATE = ItemInit.ITEMS.register("copper_chestplate",
            () -> new ArmorItem(ModArmorTiers.COPPER, EquipmentSlot.CHEST, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> COPPER_LEGGINGS = ItemInit.ITEMS.register("copper_leggings",
            () -> new ArmorItem(ModArmorTiers.COPPER, EquipmentSlot.LEGS, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> COPPER_BOOTS = ItemInit.ITEMS.register("copper_boots",
            () -> new ArmorItem(ModArmorTiers.COPPER, EquipmentSlot.FEET, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> NICKEL_HELMET = ItemInit.ITEMS.register("nickel_helmet",
            () -> new ArmorItem(ModArmorTiers.NICKEL, EquipmentSlot.HEAD, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> NICKEL_CHESTPLATE = ItemInit.ITEMS.register("nickel_chestplate",
            () -> new ArmorItem(ModArmorTiers.NICKEL, EquipmentSlot.CHEST, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> NICKEL_LEGGINGS = ItemInit.ITEMS.register("nickel_leggings",
            () -> new ArmorItem(ModArmorTiers.NICKEL, EquipmentSlot.LEGS, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> NICKEL_BOOTS = ItemInit.ITEMS.register("nickel_boots",
            () -> new ArmorItem(ModArmorTiers.NICKEL, EquipmentSlot.FEET, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> PLATINUM_HELMET = ItemInit.ITEMS.register("platinum_helmet",
            () -> new ArmorItem(ModArmorTiers.PLATINUM, EquipmentSlot.HEAD, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> PLATINUM_CHESTPLATE = ItemInit.ITEMS.register("platinum_chestplate",
            () -> new ArmorItem(ModArmorTiers.PLATINUM, EquipmentSlot.CHEST, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> PLATINUM_LEGGINGS = ItemInit.ITEMS.register("platinum_leggings",
            () -> new ArmorItem(ModArmorTiers.PLATINUM, EquipmentSlot.LEGS, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> PLATINUM_BOOTS = ItemInit.ITEMS.register("platinum_boots",
            () -> new ArmorItem(ModArmorTiers.PLATINUM, EquipmentSlot.FEET, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> RUBY_HELMET = ItemInit.ITEMS.register("ruby_helmet",
            () -> new ArmorItem(ModArmorTiers.RUBY, EquipmentSlot.HEAD, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> RUBY_CHESTPLATE = ItemInit.ITEMS.register("ruby_chestplate",
            () -> new ArmorItem(ModArmorTiers.RUBY, EquipmentSlot.CHEST, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> RUBY_LEGGINGS = ItemInit.ITEMS.register("ruby_leggings",
            () -> new ArmorItem(ModArmorTiers.RUBY, EquipmentSlot.LEGS, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> RUBY_BOOTS = ItemInit.ITEMS.register("ruby_boots",
            () -> new ArmorItem(ModArmorTiers.RUBY, EquipmentSlot.FEET, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> SILVER_HELMET = ItemInit.ITEMS.register("silver_helmet",
            () -> new ArmorItem(ModArmorTiers.SILVER, EquipmentSlot.HEAD, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> SILVER_CHESTPLATE = ItemInit.ITEMS.register("silver_chestplate",
            () -> new ArmorItem(ModArmorTiers.SILVER, EquipmentSlot.CHEST, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> SILVER_LEGGINGS = ItemInit.ITEMS.register("silver_leggings",
            () -> new ArmorItem(ModArmorTiers.SILVER, EquipmentSlot.LEGS, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> SILVER_BOOTS = ItemInit.ITEMS.register("silver_boots",
            () -> new ArmorItem(ModArmorTiers.SILVER, EquipmentSlot.FEET, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> STEEL_HELMET = ItemInit.ITEMS.register("steel_helmet",
            () -> new ArmorItem(ModArmorTiers.STEEL, EquipmentSlot.HEAD, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> STEEL_CHESTPLATE = ItemInit.ITEMS.register("steel_chestplate",
            () -> new ArmorItem(ModArmorTiers.STEEL, EquipmentSlot.CHEST, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> STEEL_LEGGINGS = ItemInit.ITEMS.register("steel_leggings",
            () -> new ArmorItem(ModArmorTiers.STEEL, EquipmentSlot.LEGS, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> STEEL_BOOTS = ItemInit.ITEMS.register("steel_boots",
            () -> new ArmorItem(ModArmorTiers.STEEL, EquipmentSlot.FEET, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> TIN_HELMET = ItemInit.ITEMS.register("tin_helmet",
            () -> new ArmorItem(ModArmorTiers.TIN, EquipmentSlot.HEAD, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> TIN_CHESTPLATE = ItemInit.ITEMS.register("tin_chestplate",
            () -> new ArmorItem(ModArmorTiers.TIN, EquipmentSlot.CHEST, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> TIN_LEGGINGS = ItemInit.ITEMS.register("tin_leggings",
            () -> new ArmorItem(ModArmorTiers.TIN, EquipmentSlot.LEGS, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<ArmorItem> TIN_BOOTS = ItemInit.ITEMS.register("tin_boots",
            () -> new ArmorItem(ModArmorTiers.TIN, EquipmentSlot.FEET, new Item.Properties().tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<Item> THERMAL_HELMET = ItemInit.ITEMS.register("thermal_helmet",
            () -> new Item(new Item.Properties().stacksTo(1).tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<Item> THERMAL_CHESTPLATE = ItemInit.ITEMS.register("thermal_chestplate",
            () -> new Item(new Item.Properties().stacksTo(1).tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<Item> THERMAL_LEGGINGS = ItemInit.ITEMS.register("thermal_leggings",
            () -> new Item(new Item.Properties().stacksTo(1).tab(NeutronGalaxy.TAB)));
    public static final RegistryObject<Item> THERMAL_BOOTS = ItemInit.ITEMS.register("thermal_boots",
            () -> new Item(new Item.Properties().stacksTo(1).tab(NeutronGalaxy.TAB)));
    

    public static class Foods {
        public static final FoodProperties COFFEE = new FoodProperties.Builder()
                .nutrition(6)
                .saturationMod(0.6f)
                .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 1200, 4), 0.97f)
                .build();
    }
}