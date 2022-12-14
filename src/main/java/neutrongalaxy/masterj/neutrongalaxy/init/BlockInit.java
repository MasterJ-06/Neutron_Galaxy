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

import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NeutronGalaxy.MODID);

    public static final RegistryObject<Block> MOON_DIRT = register("moon_dirt",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).sound(SoundType.GRASS).strength(0.6F)),
                new Item.Properties().tab(NeutronGalaxy.TAB));
    public static final RegistryObject<Block> MERCURY_STONE = register("mercury_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)),
                new Item.Properties().tab(NeutronGalaxy.TAB));
    public static final RegistryObject<Block> MERCURY_GRAVEL = register("mercury_gravel",
            () -> new GravelBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.GRAVEL).strength(0.5F)),
                new Item.Properties().tab(NeutronGalaxy.TAB));
    public static final RegistryObject<Block> MOON_ROCK = register("moon_rock",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)),
                new Item.Properties().tab(NeutronGalaxy.TAB));
    public static final RegistryObject<Block> PLUTO_ROCK = register("pluto_rock",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)),
                new Item.Properties().tab(NeutronGalaxy.TAB));
    public static final RegistryObject<Block> JUPITER_ROCK = register("jupiter_rock",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)),
                new Item.Properties().tab(NeutronGalaxy.TAB));
    public static final RegistryObject<Block> JUPITER_STONE = register("jupiter_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)),
                new Item.Properties().tab(NeutronGalaxy.TAB));
    public static final RegistryObject<Block> MARS_DUST = register("mars_dust",
            () -> new Block(BlockBehaviour.Properties.of(Material.GRASS).sound(SoundType.SAND).strength(0.5F)),
                new Item.Properties().tab(NeutronGalaxy.TAB));
    public static final RegistryObject<Block> VENUS_DUST = register("venus_dust",
            () -> new Block(BlockBehaviour.Properties.of(Material.GRASS).sound(SoundType.SAND).strength(0.5F)),
                new Item.Properties().tab(NeutronGalaxy.TAB));
    public static final RegistryObject<Block> VENUS_ROCK = register("venus_rock",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)),
                new Item.Properties().tab(NeutronGalaxy.TAB));
    public static final RegistryObject<Block> VENUS_STONE = register("venus_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)),
                new Item.Properties().tab(NeutronGalaxy.TAB));
    public static final RegistryObject<Block> LAUNCH_PAD = register("launch_pad",
            () -> new LAUNCH_PAD(BlockBehaviour.Properties.of(Material.WOOL).sound(SoundType.METAL).strength(5.0F, 6.0F)),
            new Item.Properties().tab(NeutronGalaxy.TAB));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier, Item.Properties properties) {
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
        return block;
    }
}