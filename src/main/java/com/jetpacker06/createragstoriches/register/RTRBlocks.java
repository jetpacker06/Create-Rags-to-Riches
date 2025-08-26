package com.jetpacker06.createragstoriches.register;

import com.jetpacker06.createragstoriches.CreateRTR;
import com.jetpacker06.createragstoriches.custom.CrimsonCaneBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GravelBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class RTRBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CreateRTR.MOD_ID);
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static <T extends Block> void registerBlockItem(String name, Supplier<T> block) {
        RTRItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static final RegistryObject<Block> CRIMSON_CANE = registerBlock("crimson_cane",
            () -> new CrimsonCaneBlock(BlockBehaviour.Properties.copy(Blocks.SUGAR_CANE)));
    public static final RegistryObject<Block> IGNEOUS_GRAVEL = registerBlock("igneous_gravel",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(Blocks.GRAVEL)));

}