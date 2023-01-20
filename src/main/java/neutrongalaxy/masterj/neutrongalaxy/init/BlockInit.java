package neutrongalaxy.masterj.neutrongalaxy.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GravelBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import neutrongalaxy.masterj.neutrongalaxy.NeutronGalaxy;
import neutrongalaxy.masterj.neutrongalaxy.base.LAUNCH_PAD;

import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NeutronGalaxy.MODID);

    public static final RegistryObject<Block> MOON_DIRT = BlockInit.register("moon_dirt",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).sound(SoundType.GRASS).strength(0.6F)),
                new Item.Properties().tab(NeutronGalaxy.TAB));
    public static final RegistryObject<Block> MERCURY_STONE = BlockInit.register("mercury_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)),
                new Item.Properties().tab(NeutronGalaxy.TAB));
    public static final RegistryObject<Block> MERCURY_GRAVEL = BlockInit.register("mercury_gravel",
            () -> new GravelBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.GRAVEL).strength(0.5F)),
                new Item.Properties().tab(NeutronGalaxy.TAB));
    public static final RegistryObject<Block> MOON_ROCK = BlockInit.register("moon_rock",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)),
                new Item.Properties().tab(NeutronGalaxy.TAB));
    public static final RegistryObject<Block> PLUTO_ROCK = BlockInit.register("pluto_rock",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)),
                new Item.Properties().tab(NeutronGalaxy.TAB));
    public static final RegistryObject<Block> JUPITER_ROCK = BlockInit.register("jupiter_rock",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)),
                new Item.Properties().tab(NeutronGalaxy.TAB));
    public static final RegistryObject<Block> JUPITER_STONE = BlockInit.register("jupiter_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)),
                new Item.Properties().tab(NeutronGalaxy.TAB));
    public static final RegistryObject<Block> MARS_DUST = BlockInit.register("mars_dust",
            () -> new Block(BlockBehaviour.Properties.of(Material.GRASS).sound(SoundType.SAND).strength(0.5F)),
                new Item.Properties().tab(NeutronGalaxy.TAB));
    public static final RegistryObject<Block> VENUS_DUST = BlockInit.register("venus_dust",
            () -> new Block(BlockBehaviour.Properties.of(Material.GRASS).sound(SoundType.SAND).strength(0.5F)),
                new Item.Properties().tab(NeutronGalaxy.TAB));
    public static final RegistryObject<Block> VENUS_ROCK = BlockInit.register("venus_rock",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)),
                new Item.Properties().tab(NeutronGalaxy.TAB));
    public static final RegistryObject<Block> VENUS_STONE = BlockInit.register("venus_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)),
                new Item.Properties().tab(NeutronGalaxy.TAB));
    public static final RegistryObject<Block> LAUNCH_PAD = BlockInit.register("launch_pad",
            () -> new LAUNCH_PAD(BlockBehaviour.Properties.of(Material.WOOL).sound(SoundType.METAL).strength(5.0F, 6.0F)),
            new Item.Properties().tab(NeutronGalaxy.TAB));

    private static <T extends Block> RegistryObject<T> register(final String name, Supplier<T> supplier, Item.Properties properties) {
        RegistryObject<T> block = BlockInit.BLOCKS.register(name, supplier);
        ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
        return block;
    }
}