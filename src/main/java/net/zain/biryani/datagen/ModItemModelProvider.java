package net.zain.biryani.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.zain.biryani.Biryani;
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
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Biryani.MOD_ID,"item/" + item.getId().getPath()));
    }
}
