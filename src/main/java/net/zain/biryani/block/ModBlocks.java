package net.zain.biryani.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zain.biryani.Biryani;
import net.zain.biryani.block.custom.*;
import net.zain.biryani.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Biryani.MOD_ID);

    public static final RegistryObject<Block> SALT_BLOCK = registerBlock("salt_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> SCREAMING_DIRT = registerBlock("screaming_dirt",
            () -> new ScreamingDirt(BlockBehaviour.Properties.copy(Blocks.DIRT)));

    public static final RegistryObject<Block> SCREAMING_END_STONE = registerBlock("screaming_end_stone",
            () -> new ScreamingEndStone(BlockBehaviour.Properties.copy(Blocks.END_STONE)));

    public static final RegistryObject<Block> SCREAMING_NETHER_BRICKS = registerBlock("screaming_nether_bricks",
            () -> new ScreamingNetherBricks(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS)));

    public static final RegistryObject<Block> SCREAMING_NETHERRACK = registerBlock("screaming_netherrack",
            () -> new ScreamingNetherrack(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)));

    public static final RegistryObject<Block> SCREAMING_STONE = registerBlock("screaming_stone",
            () -> new ScreamingStone(BlockBehaviour.Properties.copy(Blocks.STONE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
