package neutrongalaxy.masterj.neutrongalaxy.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import neutrongalaxy.masterj.neutrongalaxy.NeutronGalaxy;

public class DimensionInit {

    public static final ResourceKey<Level> NG_MOON = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_moon"));
    public static final ResourceKey<DimensionType> NG_MOON_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_moon"));
    public static final ResourceKey<Biome> NG_MOON_FOREST =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_moon_forest"));
    public static final ResourceKey<Biome> NG_MOON_MEADOW =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_moon_meadow"));
    public static final ResourceKey<Biome> NG_MOON_PEAKS =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_moon_peaks"));
    public static final ResourceKey<Biome> NG_MOON_SWAMP =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_moon_swamp"));
    public static final ResourceKey<Biome> NG_MOON_OCEAN =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_moon_ocean"));
    public static final ResourceKey<NoiseGeneratorSettings> NG_MOON_NOISE_SETTINGS = ResourceKey.create(Registry.NOISE_GENERATOR_SETTINGS_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_moon"));

    public static void register() {
        System.out.println("Registering Dimensions for " + NeutronGalaxy.MODID);
    }
}
