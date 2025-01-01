package com.jetpacker06.createragstoriches;

import com.simibubi.create.AllCreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class RTRItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CreateRTR.MOD_ID);
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static final Supplier<Item> BASIC = () -> new Item(new Item.Properties().tab(AllCreativeModeTabs.BASE_CREATIVE_TAB));

    public static final RegistryObject<Item> WOOD_CHUNKS = ITEMS.register("wood_chunks", BASIC);
    public static final RegistryObject<Item> BRIQUETTE = ITEMS.register("briquette", BASIC);
    public static final RegistryObject<Item> COMPRESSED_CARBON = ITEMS.register("compressed_carbon", BASIC);
    public static final RegistryObject<Item> SUPERCOMPRESSED_CARBON = ITEMS.register("supercompressed_carbon", BASIC);
    public static final RegistryObject<Item> MAXIMALLY_COMPRESSED_CARBON = ITEMS.register("maximally_compressed_carbon", BASIC);
    public static final RegistryObject<Item> UNPROCESSED_MAXIMALLY_COMPRESSED_CARBON = ITEMS.register("unprocessed_maximally_compressed_carbon", BASIC);
    public static final RegistryObject<Item> ROUGH_DIAMOND = ITEMS.register("rough_diamond", BASIC);

    public static final RegistryObject<Item> POWDERED_COAL = ITEMS.register("powdered_coal", BASIC);
}