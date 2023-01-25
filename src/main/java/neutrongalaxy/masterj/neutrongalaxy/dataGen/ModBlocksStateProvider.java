package neutrongalaxy.masterj.neutrongalaxy.dataGen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import neutrongalaxy.masterj.neutrongalaxy.NeutronGalaxy;
import neutrongalaxy.masterj.neutrongalaxy.init.BlockInit;
import neutrongalaxy.masterj.neutrongalaxy.init.FluidInit;

public class ModBlocksStateProvider extends BlockStateProvider {

    public ModBlocksStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, NeutronGalaxy.MODID, exFileHelper);
    }

    private void simpleBlockWithItem(Block block) {
        String blockName = ForgeRegistries.BLOCKS.getKey(block).getPath();

        this.simpleBlock(block);
        this.itemModels().withExistingParent(blockName, new ResourceLocation(NeutronGalaxy.MODID, "block/" + blockName));
    }

    @Override
    protected void registerStatesAndModels() {
        this.simpleBlockWithItem(BlockInit.MOON_DIRT.get());
        this.simpleBlockWithItem(BlockInit.MERCURY_STONE.get());
        this.simpleBlockWithItem(BlockInit.MERCURY_GRAVEL.get());
        this.simpleBlockWithItem(BlockInit.MOON_ROCK.get());
        this.simpleBlockWithItem(BlockInit.PLUTO_ROCK.get());
        this.simpleBlockWithItem(BlockInit.JUPITER_ROCK.get());
        this.simpleBlockWithItem(BlockInit.JUPITER_STONE.get());
        this.simpleBlockWithItem(BlockInit.MARS_DUST.get());
        this.simpleBlockWithItem(BlockInit.VENUS_DUST.get());
        this.simpleBlockWithItem(BlockInit.VENUS_ROCK.get());
        this.simpleBlockWithItem(BlockInit.VENUS_STONE.get());
        this.simpleBlockWithItem(BlockInit.ALUMINIUM_BLOCK.get());
        this.simpleBlockWithItem(BlockInit.BRASS_BLOCK.get());
        this.simpleBlockWithItem(BlockInit.BRONZE_BLOCK.get());
        this.simpleBlockWithItem(BlockInit.COBALT_BLOCK.get());
        this.simpleBlockWithItem(BlockInit.NICKEL_BLOCK.get());
        this.simpleBlockWithItem(BlockInit.PLATINUM_BLOCK.get());
        this.simpleBlockWithItem(BlockInit.RUBY_BLOCK.get());
        this.simpleBlockWithItem(BlockInit.SILVER_BLOCK.get());
        this.simpleBlockWithItem(BlockInit.STEEL_BLOCK.get());
        this.simpleBlockWithItem(BlockInit.TIN_BLOCK.get());
        this.simpleBlockWithItem(FluidInit.LIQUID_NITROGEN.block.get());
        this.simpleBlockWithItem(FluidInit.ROCKET_FUEL.block.get());

        // For the Launch Pad
        this.itemModels().withExistingParent("launch_pad", new ResourceLocation(NeutronGalaxy.MODID, "block/launch_pad"));
    }
}
