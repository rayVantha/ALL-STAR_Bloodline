package net.sievert.allstar;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.sievert.allstar.datagen.AllstarDataGenerator;
import net.sievert.allstar.registry.AllstarCreativeModeTabs;
import net.sievert.allstar.registry.AllstarItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(Allstar.MOD_ID)
public class Allstar {
    public static final String MOD_ID = "allstar";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Allstar(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        AllstarItems.register(modEventBus);
        AllstarCreativeModeTabs.register(modEventBus);

        modEventBus.addListener(AllstarDataGenerator::gatherServerData);
        modEventBus.addListener(AllstarDataGenerator::gatherClientData);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }


}
