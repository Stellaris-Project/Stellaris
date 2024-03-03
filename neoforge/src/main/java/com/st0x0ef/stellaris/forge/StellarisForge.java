package com.st0x0ef.stellaris.forge;

import com.st0x0ef.stellaris.Stellaris;
import dev.architectury.platform.hooks.EventBusesHooks;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod(Stellaris.MOD_ID)
public class StellarisForge {
    public StellarisForge() {
        // Submit our event bus to let architectury register our content on the right time
        Stellaris.init();

    }
}