package com.jetpacker06.createragstoriches;

import com.simibubi.create.AllCreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = CreateRTR.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void onCreativeModeTabBuildEvent(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() != AllCreativeModeTabs.BASE_CREATIVE_TAB.get()) return;
        System.out.println(event.getTab().getDisplayName().getString());
        for (RegistryObject<Item> item : RTRItems.ITEMS.getEntries()) {
            if (item.get() == RTRItems.UNPROCESSED_MAXIMALLY_COMPRESSED_CARBON.get()) continue;
            event.accept(item.get());
        }
    }
}
