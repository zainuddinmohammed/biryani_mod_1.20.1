package net.zain.biryani.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.zain.biryani.Biryani;
import net.zain.biryani.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Biryani.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(ModBlocks.SALT_BLOCK);

        blockWithItem(ModBlocks.SCREAMING_DIRT);
        blockWithItem(ModBlocks.SCREAMING_END_STONE);
        blockWithItem(ModBlocks.SCREAMING_NETHER_BRICKS);
        blockWithItem(ModBlocks.SCREAMING_NETHERRACK);
        blockWithItem(ModBlocks.SCREAMING_STONE);

        blockWithItem(ModBlocks.BEDROCK_WOOD_PLANKS);

        stairsBlock(((StairBlock) ModBlocks.BEDROCK_WOOD_STAIRS.get()), blockTexture(ModBlocks.BEDROCK_WOOD_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.BEDROCK_WOOD_SLAB.get()), blockTexture(ModBlocks.BEDROCK_WOOD_PLANKS.get()), blockTexture(ModBlocks.BEDROCK_WOOD_PLANKS.get()));

        buttonBlock(((ButtonBlock) ModBlocks.BEDROCK_WOOD_BUTTON.get()), blockTexture(ModBlocks.BEDROCK_WOOD_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.BEDROCK_WOOD_PRESSURE_PLATE.get()), blockTexture(ModBlocks.BEDROCK_WOOD_PLANKS.get()));

        fenceBlock(((FenceBlock) ModBlocks.BEDROCK_WOOD_FENCE.get()), blockTexture(ModBlocks.BEDROCK_WOOD_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.BEDROCK_WOOD_FENCE_GATE.get()), blockTexture(ModBlocks.BEDROCK_WOOD_PLANKS.get()));
        wallBlock(((WallBlock) ModBlocks.BEDROCK_WOOD_WALL.get()), blockTexture(ModBlocks.BEDROCK_WOOD_PLANKS.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.BEDROCK_WOOD_DOOR.get()), modLoc("block/bedrock_wood_door_bottom"), modLoc("block/bedrock_wood_door_top"), modLoc("cutout"));
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.BEDROCK_WOOD_TRAPDOOR.get()), modLoc("block/bedrock_wood_trapdoor"), true, modLoc("cutout"));
        wallBlock(((WallBlock) ModBlocks.BEDROCK_WOOD_WALL.get()), blockTexture(ModBlocks.BEDROCK_WOOD_PLANKS.get()));



    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
