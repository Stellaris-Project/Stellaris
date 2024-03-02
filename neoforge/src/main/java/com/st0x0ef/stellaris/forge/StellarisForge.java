package com.st0x0ef.stellaris.forge;

import com.st0x0ef.stellaris.Stellaris;
import net.neoforged.fml.common.Mod;

@Mod(Stellaris.MOD_ID)
public class StellarisForge {
    public StellarisForge() {
        // Submit our event bus to let architectury register our content on the right time
        Stellaris.init();
    }
}