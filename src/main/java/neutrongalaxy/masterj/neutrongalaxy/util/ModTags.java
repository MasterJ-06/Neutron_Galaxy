package neutrongalaxy.masterj.neutrongalaxy.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import neutrongalaxy.masterj.neutrongalaxy.NeutronGalaxy;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_ALUMINIUM_TOOL = tag("needs_aluminium_tool");
        public static final TagKey<Block> NEEDS_BRASS_TOOL = tag("needs_brass_tool");
        public static final TagKey<Block> NEEDS_BRONZE_TOOL = tag("needs_bronze_tool");
        public static final TagKey<Block> NEEDS_COBALT_TOOL = tag("needs_cobalt_tool");
        public static final TagKey<Block> NEEDS_COPPER_TOOL = tag("needs_copper_tool");
        public static final TagKey<Block> NEEDS_NICKEL_TOOL = tag("needs_nickel_tool");
        public static final TagKey<Block> NEEDS_PLATINUM_TOOL = tag("needs_platinum_tool");
        public static final TagKey<Block> NEEDS_RUBY_TOOL = tag("needs_ruby_tool");
        public static final TagKey<Block> NEEDS_SILVER_TOOL = tag("needs_silver_tool");
        public static final TagKey<Block> NEEDS_STEEL_TOOL = tag("needs_steel_tool");
        public static final TagKey<Block> NEEDS_TIN_TOOL = tag("needs_tin_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(NeutronGalaxy.MODID, name));
        }

        private static TagKey<Block> forgeTag (String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
}
