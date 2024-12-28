package com.jetpacker06.createragstoriches;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CreateRTR.MOD_ID)
public class CreateRTR {
    public static final String MOD_ID = "crtr";
    public static final Logger LOGGER = LogManager.getLogger();

    public CreateRTR() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        RTRBlocks.register(eventBus);
        RTRItems.register(eventBus);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }
}
