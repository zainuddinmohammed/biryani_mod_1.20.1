package net.zain.biryani.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zain.biryani.Biryani;
import net.zain.biryani.item.custom.FryingPanItem;
import net.zain.biryani.item.custom.FuelItem;
import net.zain.biryani.item.custom.SpatulaItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Biryani.MOD_ID);

    public static final RegistryObject<Item> SALT = ITEMS.register("salt",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TURMERIC = ITEMS.register("turmeric",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RED_CHILI_POWDER = ITEMS.register("red_chili_powder",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHICKEN_BIRYANI = ITEMS.register("chicken_biryani",
            () -> new Item(new Item.Properties().food(ModFoods.CHICKEN_BIRYANI)));

    public static final RegistryObject<Item> SPATULA = ITEMS.register("spatula",
            () -> new SpatulaItem(new Item.Properties()));

    public static final RegistryObject<Item> FRYING_PAN = ITEMS.register("frying_pan",
            () -> new FryingPanItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> BURNED_FOOD = ITEMS.register("burned_food",
            () -> new FuelItem(new Item.Properties(), 1200));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
