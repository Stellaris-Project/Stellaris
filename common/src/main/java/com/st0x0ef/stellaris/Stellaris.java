package com.st0x0ef.stellaris;

import com.google.gson.Gson;
import com.st0x0ef.stellaris.client.screens.RocketStationScreen;
import com.st0x0ef.stellaris.common.data.planets.StellarisData;
import com.st0x0ef.stellaris.common.entities.MartianRaptor;
import com.st0x0ef.stellaris.common.registry.*;
import dev.architectury.event.events.client.ClientLifecycleEvent;
import dev.architectury.registry.ReloadListenerRegistry;
import dev.architectury.registry.level.entity.EntityAttributeRegistry;
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

        CreativeTabsRegistry.TABS.register();
        BlocksRegistry.BLOCKS.register();
        ItemsRegistry.ITEMS.register();
        MenuTypesRegistry.MENU_TYPE.register();
        EntityRegistry.BLOCK_ENTITY_TYPE.register();
        EntityRegistry.ENTITY_TYPE.register();
        RecipesRegistry.register();

        EntityAttributeRegistry.register(EntityRegistry.MARTIAN_RAPTOR,  MartianRaptor.CreateMobAttributes());

        ReloadListenerRegistry.register(PackType.SERVER_DATA, new StellarisData());
        ClientLifecycleEvent.CLIENT_SETUP.register(client -> {
            MenuRegistry.registerScreenFactory(MenuTypesRegistry.ROCKET_STATION.get(), RocketStationScreen::new);
        });
    }

    public static void clientInit() {

    }
}
