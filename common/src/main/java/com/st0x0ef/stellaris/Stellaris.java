package com.st0x0ef.stellaris;

import com.google.gson.Gson;
import com.st0x0ef.stellaris.client.renderers.entities.martianraptor.MartianRaptorModel;
import com.st0x0ef.stellaris.client.renderers.entities.martianraptor.MartianRaptorRenderer;
import com.st0x0ef.stellaris.client.renderers.entities.mogler.MoglerModel;
import com.st0x0ef.stellaris.client.renderers.entities.mogler.MoglerRenderer;
import com.st0x0ef.stellaris.client.renderers.entities.pygro.PygroBruteRenderer;
import com.st0x0ef.stellaris.client.renderers.entities.pygro.PygroModel;
import com.st0x0ef.stellaris.client.renderers.entities.pygro.PygroRenderer;
import com.st0x0ef.stellaris.client.renderers.entities.starcrawler.StarCrawlerModel;
import com.st0x0ef.stellaris.client.renderers.entities.starcrawler.StarCrawlerRenderer;
import com.st0x0ef.stellaris.client.screens.RocketStationScreen;
import com.st0x0ef.stellaris.common.config.CustomConfig;
import com.st0x0ef.stellaris.common.data.planets.StellarisData;
import com.st0x0ef.stellaris.common.registry.*;
import dev.architectury.event.events.client.ClientLifecycleEvent;
import dev.architectury.registry.ReloadListenerRegistry;
import dev.architectury.registry.client.level.entity.EntityModelLayerRegistry;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.menu.MenuRegistry;
import net.minecraft.server.packs.PackType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Stellaris {
    public static final String MODID = "stellaris";
    public static final String MOD_NAME = "Stellaris";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
    public static final Gson GSON = new Gson();
    public static void init() {

        CustomConfig.init();

        CreativeTabsRegistry.TABS.register();
        BlocksRegistry.BLOCKS.register();
        ItemsRegistry.ITEMS.register();
        MenuTypesRegistry.MENU_TYPE.register();
        EntityRegistry.BLOCK_ENTITY_TYPE.register();
        EntityRegistry.ENTITY_TYPE.register();
        EntityRegistry.registerAttributes();
        EntityRegistry.SENSOR.register();
        FeaturesRegistry.FEATURES.register();

        RecipesRegistry.register();

        ReloadListenerRegistry.register(PackType.SERVER_DATA, new StellarisData());

        ClientLifecycleEvent.CLIENT_SETUP.register(client -> {
            MenuRegistry.registerScreenFactory(MenuTypesRegistry.ROCKET_STATION.get(), RocketStationScreen::new);

            //Martian Raptor
            EntityRendererRegistry.register(EntityRegistry.MARTIAN_RAPTOR, MartianRaptorRenderer::new);
            EntityModelLayerRegistry.register(MartianRaptorModel.LAYER_LOCATION, MartianRaptorModel::createBodyLayer);
            //Pygro
            EntityRendererRegistry.register(EntityRegistry.PYGRO, PygroRenderer::new);
            EntityModelLayerRegistry.register(PygroModel.LAYER_LOCATION, PygroModel::createBodyLayer);
            //Pygro Brute
            EntityRendererRegistry.register(EntityRegistry.PYGRO_BRUTE, PygroBruteRenderer::new);
            //Mogler
            EntityRendererRegistry.register(EntityRegistry.MOGLER, MoglerRenderer::new);
            EntityModelLayerRegistry.register(MoglerModel.LAYER_LOCATION, MoglerModel::createBodyLayer);
            //Star Crawler
            EntityRendererRegistry.register(EntityRegistry.STAR_CRAWLER, StarCrawlerRenderer::new);
            EntityModelLayerRegistry.register(StarCrawlerModel.LAYER_LOCATION, StarCrawlerModel::createBodyLayer);
        });
    }

    public static void clientInit() {



    }
}
