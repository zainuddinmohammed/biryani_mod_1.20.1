package net.zain.biryani.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.zain.biryani.Biryani;
import net.zain.biryani.block.ModBlocks;
import net.zain.biryani.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Biryani.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE);

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);
        this.tag(BlockTags.NEEDS_STONE_TOOL);
        this.tag(BlockTags.NEEDS_IRON_TOOL);

        this.tag(BlockTags.FENCES).add(ModBlocks.BEDROCK_WOOD_FENCE.get());
        this.tag(BlockTags.FENCE_GATES).add(ModBlocks.BEDROCK_WOOD_FENCE_GATE.get());
        this.tag(BlockTags.WALLS).add(ModBlocks.BEDROCK_WOOD_WALL.get());

    }
}
