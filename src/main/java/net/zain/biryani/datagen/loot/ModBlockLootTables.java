package net.zain.biryani.datagen.loot;

import net.minecraftforge.fml.loading.moddiscovery.ModValidator;
import net.zain.biryani.block.ModBlocks;
import net.zain.biryani.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.SALT_BLOCK.get());

        this.dropSelf(ModBlocks.SCREAMING_STONE.get());
        this.dropSelf(ModBlocks.SCREAMING_DIRT.get());
        this.dropSelf(ModBlocks.SCREAMING_END_STONE.get());
        this.dropSelf(ModBlocks.SCREAMING_NETHER_BRICKS.get());
        this.dropSelf(ModBlocks.SCREAMING_NETHERRACK.get());

        this.dropSelf(ModBlocks.BEDROCK_WOOD_PLANKS.get());
        this.dropSelf(ModBlocks.BEDROCK_WOOD_STAIRS.get());
        this.dropSelf(ModBlocks.BEDROCK_WOOD_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.BEDROCK_WOOD_BUTTON.get());
        this.dropSelf(ModBlocks.BEDROCK_WOOD_TRAPDOOR.get());
        this.dropSelf(ModBlocks.BEDROCK_WOOD_FENCE_GATE.get());
        this.dropSelf(ModBlocks.BEDROCK_WOOD_FENCE.get());
        this.dropSelf(ModBlocks.BEDROCK_WOOD_WALL.get());

        this.add(ModBlocks.BEDROCK_WOOD_SLAB.get(), block -> createSlabItemTable(ModBlocks.BEDROCK_WOOD_SLAB.get()));
        this.add(ModBlocks.BEDROCK_WOOD_DOOR.get(), block -> createDoorTable(ModBlocks.BEDROCK_WOOD_DOOR.get()));

        /*

        this.add(ModBlocks.SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
        this.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
        this.add(ModBlocks.NETHER_SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.NETHER_SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
        this.add(ModBlocks.END_STONE_SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.END_STONE_SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));

         */

    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}