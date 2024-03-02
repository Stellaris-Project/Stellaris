package com.st0x0ef.stellaris;

import com.st0x0ef.stellaris.common.registry.ItemsRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Stellaris {
    public static final String MOD_ID = "stellaris";
    public static final String MOD_NAME = "Stellaris";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);


    public static void init() {
        LOG.info("Initializing Stellaris");

        ItemsRegistry.ITEMS.register();
    }
}
