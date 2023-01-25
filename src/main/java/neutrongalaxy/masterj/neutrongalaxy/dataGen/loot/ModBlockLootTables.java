package neutrongalaxy.masterj.neutrongalaxy.dataGen.loot;

import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import neutrongalaxy.masterj.neutrongalaxy.init.BlockInit;
import neutrongalaxy.masterj.neutrongalaxy.init.FluidInit;
import neutrongalaxy.masterj.neutrongalaxy.init.ItemInit;

public class ModBlockLootTables extends BlockLoot {
    @Override
    protected void addTables() {
        this.dropSelf(BlockInit.ALUMINIUM_BLOCK.get());
        this.dropSelf(BlockInit.BRASS_BLOCK.get());
        this.dropSelf(BlockInit.BRONZE_BLOCK.get());
        this.dropSelf(BlockInit.COBALT_BLOCK.get());
        this.dropSelf(BlockInit.NICKEL_BLOCK.get());
        this.dropSelf(BlockInit.PLATINUM_BLOCK.get());
        this.dropSelf(BlockInit.RUBY_BLOCK.get());
        this.dropSelf(BlockInit.SILVER_BLOCK.get());
        this.dropSelf(BlockInit.STEEL_BLOCK.get());
        this.dropSelf(BlockInit.TIN_BLOCK.get());
        this.dropSelf(BlockInit.LAUNCH_PAD.get());
        this.dropSelf(BlockInit.MOON_DIRT.get());
        this.dropSelf(BlockInit.MOON_ROCK.get());
        this.dropSelf(BlockInit.MERCURY_STONE.get());
        this.dropSelf(BlockInit.MERCURY_GRAVEL.get());
        this.dropSelf(BlockInit.PLUTO_ROCK.get());
        this.dropSelf(BlockInit.JUPITER_ROCK.get());
        this.dropSelf(BlockInit.JUPITER_STONE.get());
        this.dropSelf(BlockInit.MARS_DUST.get());
        this.dropSelf(BlockInit.VENUS_STONE.get());
        this.dropSelf(BlockInit.VENUS_DUST.get());
        this.dropSelf(BlockInit.VENUS_ROCK.get());

        this.dropOther(FluidInit.LIQUID_NITROGEN.block.get(), Items.AIR);
        this.dropOther(FluidInit.ROCKET_FUEL.block.get(), Items.AIR);

        // this is for ore drops
//        this.add(BlockInit.BRASS_ORE.get(),
//                (block) -> createOreDrop(BlockInit.BRASS_ORE.get(), ItemInit.RAW_ALUMINIUM.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
