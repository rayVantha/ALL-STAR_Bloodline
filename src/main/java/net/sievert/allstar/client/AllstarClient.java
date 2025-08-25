package net.sievert.allstar.client;

import net.minecraft.client.model.ArrowModel;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.sievert.allstar.Allstar;
import net.sievert.allstar.registry.AllstarEntities;
import net.sievert.allstar.world.entity.render.*;

@Mod(value = Allstar.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = Allstar.MOD_ID, value = Dist.CLIENT)
public class AllstarClient {
    public AllstarClient(ModContainer container) { }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) { }

    @SubscribeEvent
    static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(AllstarEntities.STAND_ARROW.get(), StandArrowRenderer::new);
    }

    @SubscribeEvent
    static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(AllstarModelLayers.STAND_ARROW, ArrowModel::createBodyLayer);
    }

}
