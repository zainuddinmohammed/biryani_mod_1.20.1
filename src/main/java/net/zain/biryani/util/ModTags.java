package net.zain.biryani.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.zain.biryani.Biryani;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");
        public static final TagKey<Block> NEEDS_SPATULA_TOOL = tag("needs_spatula_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Biryani.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Biryani.MOD_ID, name));
        }

    }
}
