package com.jetpacker06.createragstoriches.register;

import com.jetpacker06.createragstoriches.CreateRTR;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.Create;
import com.simibubi.create.foundation.utility.Components;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class Tab {

    private static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Create.ID);

    public static final RegistryObject<CreativeModeTab> CRTR = TABS.register("crtr",
            () -> CreativeModeTab.builder()
                    .title(Components.translatable("tab.crtr.crtr"))
                    .displayItems((b, output) -> {
                        for (RegistryEntry<Item> item : CreateRTR.REGISTRATE.getAll(Registries.ITEM)) {
                            output.accept(item.get());
                        }
                                            })
                    .build());

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
