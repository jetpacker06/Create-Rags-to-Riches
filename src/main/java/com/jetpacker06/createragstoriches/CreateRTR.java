package com.jetpacker06.createragstoriches;

import com.jetpacker06.createragstoriches.register.RTRBlocks;
import com.jetpacker06.createragstoriches.register.RTRFluids;
import com.jetpacker06.createragstoriches.register.RTRItems;
import com.jetpacker06.createragstoriches.register.Tab;
import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.Registrate;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CreateRTR.MOD_ID)
public class CreateRTR {
    public static final String MOD_ID = "crtr";
    public static final Logger LOGGER = LogManager.getLogger();
    public static Registrate REGISTRATE;

    public CreateRTR() {
        REGISTRATE = Registrate.create(MOD_ID);
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        RTRBlocks.register(eventBus);
        RTRItems.register(eventBus);
        RTRFluids.register(REGISTRATE);
        Tab.register(eventBus);

        eventBus.addListener(this::onClientSetupEvent);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SuppressWarnings("deprecation")
    private void onClientSetupEvent(FMLClientSetupEvent event) {
        event.enqueueWork(() -> ItemBlockRenderTypes.setRenderLayer(RTRBlocks.CRIMSON_CANE.get(), RenderType.cutout()));
    }
}
