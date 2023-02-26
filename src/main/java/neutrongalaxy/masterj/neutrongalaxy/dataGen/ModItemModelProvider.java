package neutrongalaxy.masterj.neutrongalaxy.dataGen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import neutrongalaxy.masterj.neutrongalaxy.NeutronGalaxy;
import neutrongalaxy.masterj.neutrongalaxy.init.ItemInit;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(final DataGenerator generator, final ExistingFileHelper existingFileHelper) {
        super(generator, NeutronGalaxy.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ItemInit.ALUMINIUM_INGOT);
        simpleItem(ItemInit.BRASS_INGOT);
        simpleItem(ItemInit.BRONZE_INGOT);
        simpleItem(ItemInit.COBALT_INGOT);
        simpleItem(ItemInit.NICKEL_INGOT);
        simpleItem(ItemInit.OPAL);
        simpleItem(ItemInit.PLATINUM_INGOT);
        simpleItem(ItemInit.RUBY);
        simpleItem(ItemInit.SILVER_INGOT);
        simpleItem(ItemInit.STEEL_INGOT);
        simpleItem(ItemInit.THERMAL_FABRIC);
        simpleItem(ItemInit.TIN_INGOT);
        simpleItem(ItemInit.ROCKET_WINDOW);
        simpleItem(ItemInit.STEEL_PLATE);
        simpleItem(ItemInit.ALUMINIUM_PLATE);
        simpleItem(ItemInit.IRON_PLATE);
        simpleItem(ItemInit.SILICON);
        simpleItem(ItemInit.SULFUR);
        simpleItem(ItemInit.COFFEE);
        simpleItem(ItemInit.CUP);
        simpleItem(ItemInit.ROCKET);
        handheldAxeItem(ItemInit.ALUMINIUM_AXE);
        handheldHoeItem(ItemInit.ALUMINIUM_HOE);
        handheldPickaxeItem(ItemInit.ALUMINIUM_PICKAXE);
        handheldShovelItem(ItemInit.ALUMINIUM_SHOVEL);
        handheldSwordItem(ItemInit.ALUMINIUM_SWORD);
        handheldAxeItem(ItemInit.BRASS_AXE);
        handheldHoeItem(ItemInit.BRASS_HOE);
        handheldPickaxeItem(ItemInit.BRASS_PICKAXE);
        handheldShovelItem(ItemInit.BRASS_SHOVEL);
        handheldSwordItem(ItemInit.BRASS_SWORD);
        handheldAxeItem(ItemInit.BRONZE_AXE);
        handheldHoeItem(ItemInit.BRONZE_HOE);
        handheldPickaxeItem(ItemInit.BRONZE_PICKAXE);
        handheldShovelItem(ItemInit.BRONZE_SHOVEL);
        handheldSwordItem(ItemInit.BRONZE_SWORD);
        handheldAxeItem(ItemInit.COBALT_AXE);
        handheldHoeItem(ItemInit.COBALT_HOE);
        handheldPickaxeItem(ItemInit.COBALT_PICKAXE);
        handheldShovelItem(ItemInit.COBALT_SHOVEL);
        handheldSwordItem(ItemInit.COBALT_SWORD);
        handheldAxeItem(ItemInit.COPPER_AXE);
        handheldHoeItem(ItemInit.COPPER_HOE);
        handheldPickaxeItem(ItemInit.COPPER_PICKAXE);
        handheldShovelItem(ItemInit.COPPER_SHOVEL);
        handheldSwordItem(ItemInit.COPPER_SWORD);
        handheldAxeItem(ItemInit.NICKEL_AXE);
        handheldHoeItem(ItemInit.NICKEL_HOE);
        handheldPickaxeItem(ItemInit.NICKEL_PICKAXE);
        handheldShovelItem(ItemInit.NICKEL_SHOVEL);
        handheldSwordItem(ItemInit.NICKEL_SWORD);
        handheldAxeItem(ItemInit.PLATINUM_AXE);
        handheldHoeItem(ItemInit.PLATINUM_HOE);
        handheldPickaxeItem(ItemInit.PLATINUM_PICKAXE);
        handheldShovelItem(ItemInit.PLATINUM_SHOVEL);
        handheldSwordItem(ItemInit.PLATINUM_SWORD);
        handheldAxeItem(ItemInit.RUBY_AXE);
        handheldHoeItem(ItemInit.RUBY_HOE);
        handheldPickaxeItem(ItemInit.RUBY_PICKAXE);
        handheldShovelItem(ItemInit.RUBY_SHOVEL);
        handheldSwordItem(ItemInit.RUBY_SWORD);
        handheldAxeItem(ItemInit.SILVER_AXE);
        handheldHoeItem(ItemInit.SILVER_HOE);
        handheldPickaxeItem(ItemInit.SILVER_PICKAXE);
        handheldShovelItem(ItemInit.SILVER_SHOVEL);
        handheldSwordItem(ItemInit.SILVER_SWORD);
        handheldAxeItem(ItemInit.STEEL_AXE);
        handheldHoeItem(ItemInit.STEEL_HOE);
        handheldPickaxeItem(ItemInit.STEEL_PICKAXE);
        handheldShovelItem(ItemInit.STEEL_SHOVEL);
        handheldSwordItem(ItemInit.STEEL_SWORD);
        handheldAxeItem(ItemInit.TIN_AXE);
        handheldHoeItem(ItemInit.TIN_HOE);
        handheldPickaxeItem(ItemInit.TIN_PICKAXE);
        handheldShovelItem(ItemInit.TIN_SHOVEL);
        handheldSwordItem(ItemInit.TIN_SWORD);
        simpleArmorItem(ItemInit.ALUMINIUM_HELMET);
        simpleArmorItem(ItemInit.ALUMINIUM_CHESTPLATE);
        simpleArmorItem(ItemInit.ALUMINIUM_LEGGINGS);
        simpleArmorItem(ItemInit.ALUMINIUM_BOOTS);
        simpleArmorItem(ItemInit.BRASS_HELMET);
        simpleArmorItem(ItemInit.BRASS_CHESTPLATE);
        simpleArmorItem(ItemInit.BRASS_LEGGINGS);
        simpleArmorItem(ItemInit.BRASS_BOOTS);
        simpleArmorItem(ItemInit.BRONZE_HELMET);
        simpleArmorItem(ItemInit.BRONZE_CHESTPLATE);
        simpleArmorItem(ItemInit.BRONZE_LEGGINGS);
        simpleArmorItem(ItemInit.BRONZE_BOOTS);
        simpleArmorItem(ItemInit.COBALT_HELMET);
        simpleArmorItem(ItemInit.COBALT_CHESTPLATE);
        simpleArmorItem(ItemInit.COBALT_LEGGINGS);
        simpleArmorItem(ItemInit.COBALT_BOOTS);
        simpleArmorItem(ItemInit.COPPER_HELMET);
        simpleArmorItem(ItemInit.COPPER_CHESTPLATE);
        simpleArmorItem(ItemInit.COPPER_LEGGINGS);
        simpleArmorItem(ItemInit.COPPER_BOOTS);
        simpleArmorItem(ItemInit.NICKEL_HELMET);
        simpleArmorItem(ItemInit.NICKEL_CHESTPLATE);
        simpleArmorItem(ItemInit.NICKEL_LEGGINGS);
        simpleArmorItem(ItemInit.NICKEL_BOOTS);
        simpleArmorItem(ItemInit.PLATINUM_HELMET);
        simpleArmorItem(ItemInit.PLATINUM_CHESTPLATE);
        simpleArmorItem(ItemInit.PLATINUM_LEGGINGS);
        simpleArmorItem(ItemInit.PLATINUM_BOOTS);
        simpleArmorItem(ItemInit.RUBY_HELMET);
        simpleArmorItem(ItemInit.RUBY_CHESTPLATE);
        simpleArmorItem(ItemInit.RUBY_LEGGINGS);
        simpleArmorItem(ItemInit.RUBY_BOOTS);
        simpleArmorItem(ItemInit.SILVER_HELMET);
        simpleArmorItem(ItemInit.SILVER_CHESTPLATE);
        simpleArmorItem(ItemInit.SILVER_LEGGINGS);
        simpleArmorItem(ItemInit.SILVER_BOOTS);
        simpleArmorItem(ItemInit.STEEL_HELMET);
        simpleArmorItem(ItemInit.STEEL_CHESTPLATE);
        simpleArmorItem(ItemInit.STEEL_LEGGINGS);
        simpleArmorItem(ItemInit.STEEL_BOOTS);
        simpleArmorItem(ItemInit.TIN_HELMET);
        simpleArmorItem(ItemInit.TIN_CHESTPLATE);
        simpleArmorItem(ItemInit.TIN_LEGGINGS);
        simpleArmorItem(ItemInit.TIN_BOOTS);
        simpleItem(ItemInit.THERMAL_HELMET);
        simpleItem(ItemInit.THERMAL_CHESTPLATE);
        simpleItem(ItemInit.THERMAL_LEGGINGS);
        simpleItem(ItemInit.THERMAL_BOOTS);
    }

    private ItemModelBuilder simpleItem(final RegistryObject<Item> item) {
        return this.withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(NeutronGalaxy.MODID, "items/" + item.getId().getPath()));
    }
    private ItemModelBuilder simpleArmorItem(final RegistryObject<ArmorItem> item) {
        return this.withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(NeutronGalaxy.MODID, "items/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(final RegistryObject<Item> item) {
        return this.withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(NeutronGalaxy.MODID, "items/" + item.getId().getPath()));
    }
    private ItemModelBuilder handheldAxeItem(final RegistryObject<AxeItem> item) {
        return this.withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(NeutronGalaxy.MODID, "items/" + item.getId().getPath()));
    }
    private ItemModelBuilder handheldSwordItem(final RegistryObject<SwordItem> item) {
        return this.withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(NeutronGalaxy.MODID, "items/" + item.getId().getPath()));
    }
    private ItemModelBuilder handheldPickaxeItem(final RegistryObject<PickaxeItem> item) {
        return this.withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(NeutronGalaxy.MODID, "items/" + item.getId().getPath()));
    }
    private ItemModelBuilder handheldShovelItem(final RegistryObject<ShovelItem> item) {
        return this.withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(NeutronGalaxy.MODID, "items/" + item.getId().getPath()));
    }
    private ItemModelBuilder handheldHoeItem(final RegistryObject<HoeItem> item) {
        return this.withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(NeutronGalaxy.MODID, "items/" + item.getId().getPath()));
    }
}
