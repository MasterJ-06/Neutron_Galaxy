package neutrongalaxy.masterj.neutrongalaxy.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GravelBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import neutrongalaxy.masterj.neutrongalaxy.NeutronGalaxy;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NeutronGalaxy.MODID);

    public static final RegistryObject<Block> MOON_DIRT = BlockInit.BLOCKS.register("moon_dirt", () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> MERCURY_STONE = BlockInit.BLOCKS.register("mercury_stone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MERCURY_GRAVEL = BlockInit.BLOCKS.register("mercury_gravel", () -> new GravelBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> MOON_ROCK = BlockInit.BLOCKS.register("moon_rock", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> PLUTO_ROCK = BlockInit.BLOCKS.register("pluto_rock", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> JUPITER_ROCK = BlockInit.BLOCKS.register("jupiter_rock", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> JUPITER_STONE = BlockInit.BLOCKS.register("jupiter_stone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> LAUNCH_PAD = BlockInit.BLOCKS.register("launch_pad", () -> new Block(BlockBehaviour.Properties.of(Material.WOOL).sound(SoundType.METAL)));
    public static final RegistryObject<Block> MARS_DUST = BlockInit.BLOCKS.register("mars_dust", () -> new Block(BlockBehaviour.Properties.of(Material.GRASS).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> VENUS_DUST = BlockInit.BLOCKS.register("venus_dust", () -> new Block(BlockBehaviour.Properties.of(Material.GRASS).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> VENUS_ROCK = BlockInit.BLOCKS.register("venus_rock", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> VENUS_STONE = BlockInit.BLOCKS.register("venus_stone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE)));
}
