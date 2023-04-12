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

    // Make blocks for saturn, neptune, uranus and change the noise gen

    public static final ResourceKey<Level> NG_MOON = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_moon"));
    public static final ResourceKey<DimensionType> NG_MOON_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_moon"));
    public static final ResourceKey<Biome> NG_MOON_FOREST =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_moon_forest"));
    public static final ResourceKey<Biome> NG_MOON_MEADOW =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_moon_meadow"));
    public static final ResourceKey<Biome> NG_MOON_PEAKS =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_moon_peaks"));
    public static final ResourceKey<Biome> NG_MOON_SWAMP =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_moon_swamp"));
    public static final ResourceKey<Biome> NG_MOON_OCEAN =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_moon_ocean"));
    public static final ResourceKey<NoiseGeneratorSettings> NG_MOON_NOISE_SETTINGS = ResourceKey.create(Registry.NOISE_GENERATOR_SETTINGS_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_moon"));

    public static final ResourceKey<Level> NG_MERCURY = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_mercury"));
    public static final ResourceKey<DimensionType> NG_MERCURY_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_mercury"));
    public static final ResourceKey<Biome> NG_MERCURY_FOREST =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_mercury_forest"));
    public static final ResourceKey<Biome> NG_MERCURY_MEADOW =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_mercury_meadow"));
    public static final ResourceKey<Biome> NG_MERCURY_PEAKS =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_mercury_peaks"));
    public static final ResourceKey<Biome> NG_MERCURY_SWAMP =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_mercury_swamp"));
    public static final ResourceKey<Biome> NG_MERCURY_OCEAN =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_mercury_ocean"));
    public static final ResourceKey<NoiseGeneratorSettings> NG_MERCURY_NOISE_SETTINGS = ResourceKey.create(Registry.NOISE_GENERATOR_SETTINGS_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_mercury"));

    public static final ResourceKey<Level> NG_VENUS = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_venus"));
    public static final ResourceKey<DimensionType> NG_VENUS_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_venus"));
    public static final ResourceKey<Biome> NG_VENUS_FOREST =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_venus_forest"));
    public static final ResourceKey<Biome> NG_VENUS_MEADOW =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_venus_meadow"));
    public static final ResourceKey<Biome> NG_VENUS_PEAKS =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_venus_peaks"));
    public static final ResourceKey<Biome> NG_VENUS_SWAMP =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_venus_swamp"));
    public static final ResourceKey<Biome> NG_VENUS_OCEAN =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_venus_ocean"));
    public static final ResourceKey<NoiseGeneratorSettings> NG_VENUS_NOISE_SETTINGS = ResourceKey.create(Registry.NOISE_GENERATOR_SETTINGS_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_venus"));

    public static final ResourceKey<Level> NG_MARS = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_mars"));
    public static final ResourceKey<DimensionType> NG_MARS_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_mars"));
    public static final ResourceKey<Biome> NG_MARS_FOREST =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_mars_forest"));
    public static final ResourceKey<Biome> NG_MARS_MEADOW =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_mars_meadow"));
    public static final ResourceKey<Biome> NG_MARS_PEAKS =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_mars_peaks"));
    public static final ResourceKey<Biome> NG_MARS_SWAMP =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_mars_swamp"));
    public static final ResourceKey<Biome> NG_MARS_OCEAN =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_mars_ocean"));
    public static final ResourceKey<NoiseGeneratorSettings> NG_MARS_NOISE_SETTINGS = ResourceKey.create(Registry.NOISE_GENERATOR_SETTINGS_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_mars"));

    public static final ResourceKey<Level> NG_JUPITER = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_jupiter"));
    public static final ResourceKey<DimensionType> NG_JUPITER_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_jupiter"));
    public static final ResourceKey<Biome> NG_JUPITER_FOREST =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_jupiter_forest"));
    public static final ResourceKey<Biome> NG_JUPITER_MEADOW =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_jupiter_meadow"));
    public static final ResourceKey<Biome> NG_JUPITER_PEAKS =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_jupiter_peaks"));
    public static final ResourceKey<Biome> NG_JUPITER_SWAMP =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_jupiter_swamp"));
    public static final ResourceKey<Biome> NG_JUPITER_OCEAN =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_jupiter_ocean"));
    public static final ResourceKey<NoiseGeneratorSettings> NG_JUPITER_NOISE_SETTINGS = ResourceKey.create(Registry.NOISE_GENERATOR_SETTINGS_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_jupiter"));

    public static final ResourceKey<Level> NG_SATURN = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_saturn"));
    public static final ResourceKey<DimensionType> NG_SATURN_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_saturn"));
    public static final ResourceKey<Biome> NG_SATURN_FOREST =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_saturn_forest"));
    public static final ResourceKey<Biome> NG_SATURN_MEADOW =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_saturn_meadow"));
    public static final ResourceKey<Biome> NG_SATURN_PEAKS =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_saturn_peaks"));
    public static final ResourceKey<Biome> NG_SATURN_SWAMP =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_saturn_swamp"));
    public static final ResourceKey<Biome> NG_SATURN_OCEAN =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_saturn_ocean"));
    public static final ResourceKey<NoiseGeneratorSettings> NG_SATURN_NOISE_SETTINGS = ResourceKey.create(Registry.NOISE_GENERATOR_SETTINGS_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_saturn"));

    public static final ResourceKey<Level> NG_NEPTUNE = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_neptune"));
    public static final ResourceKey<DimensionType> NG_NEPTUNE_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_neptune"));
    public static final ResourceKey<Biome> NG_NEPTUNE_FOREST =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_neptune_forest"));
    public static final ResourceKey<Biome> NG_NEPTUNE_MEADOW =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_neptune_meadow"));
    public static final ResourceKey<Biome> NG_NEPTUNE_PEAKS =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_neptune_peaks"));
    public static final ResourceKey<Biome> NG_NEPTUNE_SWAMP =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_neptune_swamp"));
    public static final ResourceKey<Biome> NG_NEPTUNE_OCEAN =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_neptune_ocean"));
    public static final ResourceKey<NoiseGeneratorSettings> NG_NEPTUNE_NOISE_SETTINGS = ResourceKey.create(Registry.NOISE_GENERATOR_SETTINGS_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_neptune"));

    public static final ResourceKey<Level> NG_URANUS = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_uranus"));
    public static final ResourceKey<DimensionType> NG_URANUS_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_uranus"));
    public static final ResourceKey<Biome> NG_URANUS_FOREST =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_uranus_forest"));
    public static final ResourceKey<Biome> NG_URANUS_MEADOW =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_uranus_meadow"));
    public static final ResourceKey<Biome> NG_URANUS_PEAKS =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_uranus_peaks"));
    public static final ResourceKey<Biome> NG_URANUS_SWAMP =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_uranus_swamp"));
    public static final ResourceKey<Biome> NG_URANUS_OCEAN =  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_uranus_ocean"));
    public static final ResourceKey<NoiseGeneratorSettings> NG_URANUS_NOISE_SETTINGS = ResourceKey.create(Registry.NOISE_GENERATOR_SETTINGS_REGISTRY, new ResourceLocation(NeutronGalaxy.MODID, "ng_uranus"));

    public static void register() {
        NeutronGalaxy.LOGGER.info("Registering Dimensions for " + NeutronGalaxy.MODID);
    }
}
