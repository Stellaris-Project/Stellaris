package com.st0x0ef.stellaris.common.config;

import com.st0x0ef.stellaris.Stellaris;
import dev.architectury.platform.Platform;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CustomConfig {

    public static Map<Object, ConfigEntry> CONFIG = new HashMap<>();


    public static void init() {
        loadConfigFile();

        addEntry();
        writeConfigFile(CONFIG, "stellaris.json");
        //config = Stellaris.GSON.fromJson(Platform.getStreamForResource("stellaris.json"), Map.class);

    }

    public static void addEntry() {

        CONFIG.put("test", new ConfigEntry.ConfigEntryInt(1, "test"));
        CONFIG.put("test2", new ConfigEntry.ConfigEntryString("test", "test"));
        CONFIG.put("test3", new ConfigEntry.ConfigEntryString("test", "test"));

        Stellaris.LOG.error(CONFIG.toString());

    }

    public static void writeConfigFile(Map<?, ?> config, String path) {
        try {
            FileWriter file = new FileWriter(Platform.getConfigFolder() + "/" + path);
            file.write(Stellaris.GSON.toJson(config));
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadConfigFile() {
        //config = Stellaris.GSON.fromJson(Platform.getStreamForResource("stellaris.json"), Map.class);
        Iterator<?> keysItr = CONFIG.keySet().iterator();

        Map<Object, ConfigEntry> config = new HashMap<>();

        while(keysItr.hasNext()) {
            String key = (String) keysItr.next();
            ConfigEntry value = CONFIG.get(key);


            Stellaris.LOG.error(key + " " + value);
            config.put(key, value);
        }

        CONFIG = config;
    }



}
