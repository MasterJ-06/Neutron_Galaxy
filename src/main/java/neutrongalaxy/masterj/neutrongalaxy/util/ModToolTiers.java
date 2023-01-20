package neutrongalaxy.masterj.neutrongalaxy.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import neutrongalaxy.masterj.neutrongalaxy.NeutronGalaxy;
import neutrongalaxy.masterj.neutrongalaxy.init.ItemInit;

import java.util.List;

public class ModToolTiers {
    public static Tier ALUMINIUM;
    public static Tier BRASS;
    public static Tier BRONZE;
    public static Tier COBALT;
    public static Tier COPPER;
    public static Tier NICKEL;
    public static Tier PLATINUM;
    public static Tier RUBY;
    public static Tier SILVER;
    public static Tier STEEL;
    public static Tier TIN;

    static {
        ALUMINIUM = TierSortingRegistry.registerTier(
                new ForgeTier(5, 1561, 8.0F, 3.0F, 10,
                        ModTags.Blocks.NEEDS_ALUMINIUM_TOOL, () -> Ingredient.of(ItemInit.ALUMINIUM_INGOT.get())),
                new ResourceLocation(NeutronGalaxy.MODID, "aluminium"), List.of(Tiers.NETHERITE), List.of());

        BRASS = TierSortingRegistry.registerTier(
                new ForgeTier(6, 1561, 8.0F, 3.0F, 10,
                        ModTags.Blocks.NEEDS_BRASS_TOOL, () -> Ingredient.of(ItemInit.BRASS_INGOT.get())),
                new ResourceLocation(NeutronGalaxy.MODID, "brass"), List.of(ModToolTiers.ALUMINIUM), List.of());

        BRONZE = TierSortingRegistry.registerTier(
                new ForgeTier(7, 1561, 8.0F, 3.0F, 10,
                        ModTags.Blocks.NEEDS_BRONZE_TOOL, () -> Ingredient.of(ItemInit.BRONZE_INGOT.get())),
                new ResourceLocation(NeutronGalaxy.MODID, "bronze"), List.of(ModToolTiers.BRASS), List.of());

        COBALT = TierSortingRegistry.registerTier(
                new ForgeTier(8, 1561, 8.0F, 3.0F, 10,
                        ModTags.Blocks.NEEDS_COBALT_TOOL, () -> Ingredient.of(ItemInit.COBALT_INGOT.get())),
                new ResourceLocation(NeutronGalaxy.MODID, "cobalt"), List.of(ModToolTiers.BRONZE), List.of());

        COPPER = TierSortingRegistry.registerTier(
                new ForgeTier(9, 1561, 8.0F, 3.0F, 10,
                        ModTags.Blocks.NEEDS_COPPER_TOOL, () -> Ingredient.of(Items.COPPER_INGOT)),
                new ResourceLocation(NeutronGalaxy.MODID, "copper"), List.of(ModToolTiers.COBALT), List.of());

        NICKEL = TierSortingRegistry.registerTier(
                new ForgeTier(10, 1561, 8.0F, 3.0F, 10,
                        ModTags.Blocks.NEEDS_NICKEL_TOOL, () -> Ingredient.of(ItemInit.NICKEL_INGOT.get())),
                new ResourceLocation(NeutronGalaxy.MODID, "nickel"), List.of(ModToolTiers.COPPER), List.of());

        PLATINUM = TierSortingRegistry.registerTier(
                new ForgeTier(11, 1561, 8.0F, 3.0F, 10,
                        ModTags.Blocks.NEEDS_PLATINUM_TOOL, () -> Ingredient.of(ItemInit.PLATINUM_INGOT.get())),
                new ResourceLocation(NeutronGalaxy.MODID, "platinum"), List.of(ModToolTiers.NICKEL), List.of());

        RUBY = TierSortingRegistry.registerTier(
                new ForgeTier(12, 1561, 8.0F, 3.0F, 10,
                        ModTags.Blocks.NEEDS_RUBY_TOOL, () -> Ingredient.of(ItemInit.RUBY.get())),
                new ResourceLocation(NeutronGalaxy.MODID, "ruby"), List.of(ModToolTiers.PLATINUM), List.of());

        SILVER = TierSortingRegistry.registerTier(
                new ForgeTier(13, 1561, 8.0F, 3.0F, 10,
                        ModTags.Blocks.NEEDS_SILVER_TOOL, () -> Ingredient.of(ItemInit.SILVER_INGOT.get())),
                new ResourceLocation(NeutronGalaxy.MODID, "silver"), List.of(ModToolTiers.RUBY), List.of());

        STEEL = TierSortingRegistry.registerTier(
                new ForgeTier(14, 1561, 8.0F, 3.0F, 10,
                        ModTags.Blocks.NEEDS_STEEL_TOOL, () -> Ingredient.of(ItemInit.STEEL_INGOT.get())),
                new ResourceLocation(NeutronGalaxy.MODID, "steel"), List.of(ModToolTiers.SILVER), List.of());

        TIN = TierSortingRegistry.registerTier(
                new ForgeTier(15, 1561, 8.0F, 3.0F, 10,
                        ModTags.Blocks.NEEDS_TIN_TOOL, () -> Ingredient.of(ItemInit.TIN_INGOT.get())),
                new ResourceLocation(NeutronGalaxy.MODID, "tin"), List.of(ModToolTiers.STEEL), List.of());
    }
}
