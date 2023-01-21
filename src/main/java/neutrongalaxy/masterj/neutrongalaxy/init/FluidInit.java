package neutrongalaxy.masterj.neutrongalaxy.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import neutrongalaxy.masterj.neutrongalaxy.NeutronGalaxy;
import neutrongalaxy.masterj.neutrongalaxy.base.FluidRegistryContainer;

public class FluidInit {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, NeutronGalaxy.MODID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, NeutronGalaxy.MODID);

    public static final FluidRegistryContainer LIQUID_NITROGEN = new FluidRegistryContainer("liquid_nitrogen", FluidType.Properties.create()
            .canConvertToSource(true).canDrown(true).canExtinguish(true).canHydrate(true).canSwim(true).canPushEntity(true).supportsBoating(true),
            () -> FluidRegistryContainer.createExtension(new FluidRegistryContainer.ClientExtensions(NeutronGalaxy.MODID, "liquid_nitrogen")
                    .renderOverlay(null).tint(0xdcdbdb).fogColor(0.4f, 0.4f, 0.4f)), new FluidRegistryContainer.AdditionalProperties().explosionResistance(1.0f),
            BlockBehaviour.Properties.copy(Blocks.WATER), new Item.Properties().tab(NeutronGalaxy.TAB).stacksTo(1));
    public static final FluidRegistryContainer ROCKET_FUEL = new FluidRegistryContainer("rocket_fuel", FluidType.Properties.create()
            .canConvertToSource(true).canDrown(true).canSwim(true).canPushEntity(true).supportsBoating(true),
            () -> FluidRegistryContainer.createExtension(new FluidRegistryContainer.ClientExtensions(NeutronGalaxy.MODID, "rocket_fuel")
                    .renderOverlay(null).fogColor(0.9f, 0.5f, 0.4f)), new FluidRegistryContainer.AdditionalProperties().explosionResistance(1.0f),
            BlockBehaviour.Properties.copy(Blocks.WATER), new Item.Properties().tab(NeutronGalaxy.TAB).stacksTo(1));
}
