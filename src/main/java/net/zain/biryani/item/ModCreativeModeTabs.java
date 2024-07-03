package net.zain.biryani.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.zain.biryani.Biryani;
import net.zain.biryani.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Biryani.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BIRYANI_TAB = CREATIVE_MODE_TABS.register("biryani_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CHICKEN_BIRYANI.get()))
                    .title(Component.translatable("creativetab.biryani_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SALT.get());
                        output.accept(ModItems.TURMERIC.get());
                        output.accept(ModItems.RED_CHILI_POWDER.get());
                        output.accept(ModItems.BURNED_FOOD.get());

                        output.accept(ModItems.SPATULA.get());
                        output.accept(ModItems.FRYING_PAN.get());

                        output.accept(ModItems.CHICKEN_BIRYANI.get());

                        output.accept(ModBlocks.SALT_BLOCK.get());
                        output.accept(ModBlocks.SCREAMING_DIRT.get());
                        output.accept(ModBlocks.SCREAMING_END_STONE.get());
                        output.accept(ModBlocks.SCREAMING_NETHER_BRICKS.get());
                        output.accept(ModBlocks.SCREAMING_NETHERRACK.get());
                        output.accept(ModBlocks.SCREAMING_STONE.get());

                        output.accept(ModBlocks.BEDROCK_WOOD_PLANKS.get());
                        output.accept(ModBlocks.BEDROCK_WOOD_STAIRS.get());
                        output.accept(ModBlocks.BEDROCK_WOOD_SLAB.get());
                        output.accept(ModBlocks.BEDROCK_WOOD_FENCE.get());
                        output.accept(ModBlocks.BEDROCK_WOOD_FENCE_GATE.get());
                        output.accept(ModBlocks.BEDROCK_WOOD_WALL.get());
                        output.accept(ModBlocks.BEDROCK_WOOD_BUTTON.get());
                        output.accept(ModBlocks.BEDROCK_WOOD_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.BEDROCK_WOOD_DOOR.get());
                        output.accept(ModBlocks.BEDROCK_WOOD_TRAPDOOR.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
