package neutrongalaxy.masterj.neutrongalaxy.util;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import neutrongalaxy.masterj.neutrongalaxy.base.ModArmorMaterial;
import neutrongalaxy.masterj.neutrongalaxy.init.ItemInit;

public class ModArmorTiers {
    public static final ArmorMaterial ALUMINIUM = new ModArmorMaterial("aluminium", 33, new int[]{3, 6, 8, 3}, 25, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0f, 0.5f, () -> Ingredient.of(ItemInit.ALUMINIUM_INGOT.get()));
    public static final ArmorMaterial BRASS = new ModArmorMaterial("brass", 33, new int[]{3, 6, 8, 3}, 25, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0f, 0.5f, () -> Ingredient.of(ItemInit.BRASS_INGOT.get()));
    public static final ArmorMaterial BRONZE = new ModArmorMaterial("bronze", 33, new int[]{3, 6, 8, 3}, 25, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0f, 0.5f, () -> Ingredient.of(ItemInit.BRONZE_INGOT.get()));
    public static final ArmorMaterial COBALT = new ModArmorMaterial("cobalt", 33, new int[]{3, 6, 8, 3}, 25, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0f, 0.5f, () -> Ingredient.of(ItemInit.COBALT_INGOT.get()));
    public static final ArmorMaterial COPPER = new ModArmorMaterial("copper", 33, new int[]{3, 6, 8, 3}, 25, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0f, 0.5f, () -> Ingredient.of(Items.COPPER_INGOT));
    public static final ArmorMaterial NICKEL = new ModArmorMaterial("nickel", 33, new int[]{3, 6, 8, 3}, 25, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0f, 0.5f, () -> Ingredient.of(ItemInit.NICKEL_INGOT.get()));
    public static final ArmorMaterial PLATINUM = new ModArmorMaterial("platinum", 33, new int[]{3, 6, 8, 3}, 25, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0f, 0.5f, () -> Ingredient.of(ItemInit.PLATINUM_INGOT.get()));
    public static final ArmorMaterial RUBY = new ModArmorMaterial("ruby", 33, new int[]{3, 6, 8, 3}, 25, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0f, 0.5f, () -> Ingredient.of(ItemInit.RUBY.get()));
    public static final ArmorMaterial SILVER = new ModArmorMaterial("silver", 33, new int[]{3, 6, 8, 3}, 25, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0f, 0.5f, () -> Ingredient.of(ItemInit.SILVER_INGOT.get()));
    public static final ArmorMaterial STEEL = new ModArmorMaterial("steel", 33, new int[]{3, 6, 8, 3}, 25, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0f, 0.5f, () -> Ingredient.of(ItemInit.STEEL_INGOT.get()));
    public static final ArmorMaterial TIN = new ModArmorMaterial("tin", 33, new int[]{3, 6, 8, 3}, 25, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0f, 0.5f, () -> Ingredient.of(ItemInit.TIN_INGOT.get()));
}