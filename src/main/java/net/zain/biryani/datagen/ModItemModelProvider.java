package net.zain.biryani.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zain.biryani.Biryani;
import net.zain.biryani.block.ModBlocks;
import net.zain.biryani.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Biryani.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.BURNED_FOOD);
        simpleItem(ModItems.SALT);
        simpleItem(ModItems.TURMERIC);
        simpleItem(ModItems.RED_CHILI_POWDER);
        simpleItem(ModItems.CHICKEN_BIRYANI);
        simpleItem(ModItems.SPATULA);
        simpleItem(ModItems.FRYING_PAN);

        simpleBlockItem(ModBlocks.BEDROCK_WOOD_DOOR);

        fenceItem(ModBlocks.BEDROCK_WOOD_FENCE, ModBlocks.BEDROCK_WOOD_PLANKS);
        buttonItem(ModBlocks.BEDROCK_WOOD_BUTTON, ModBlocks.BEDROCK_WOOD_PLANKS);
        wallItem(ModBlocks.BEDROCK_WOOD_WALL, ModBlocks.BEDROCK_WOOD_PLANKS);

        evenSimplerBlockItem(ModBlocks.BEDROCK_WOOD_STAIRS);
        evenSimplerBlockItem(ModBlocks.BEDROCK_WOOD_SLAB);
        evenSimplerBlockItem(ModBlocks.BEDROCK_WOOD_FENCE_GATE);
        evenSimplerBlockItem(ModBlocks.BEDROCK_WOOD_PRESSURE_PLATE);

        trapdoorItem(ModBlocks.BEDROCK_WOOD_TRAPDOOR);
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(Biryani.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(Biryani.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(Biryani.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(Biryani.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Biryani.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Biryani.MOD_ID,"item/" + item.getId().getPath()));
    }

}
