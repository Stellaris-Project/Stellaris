package com.st0x0ef.stellaris.common.config;

import com.google.common.reflect.TypeToken;
import com.google.gson.JsonObject;
import com.st0x0ef.stellaris.Stellaris;
import dev.architectury.platform.Platform;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CustomConfig {

    public static Map<Object, ConfigEntry> CONFIG = new HashMap<>();


    public static void init() {
        loadConfigFile();
        addEntries(CONFIG);
        writeConfigFile(CONFIG, "stellaris.json");
        //config = Stellaris.GSON.fromJson(Platform.getStreamForResource("stellaris.json"), Map.class);

    }

    public static void addEntries(Map<Object, ConfigEntry> config) {

        addEntry("test", new ConfigEntry.ConfigEntryInt(1, "caca"), config);
        addEntry("test2", new ConfigEntry.ConfigEntryInt(1, "caca"), config);
        addEntry("test3", new ConfigEntry.ConfigEntryInt(1, "caca"), config);

    }

    public static void addEntry(String name, ConfigEntry entry, Map<Object, ConfigEntry> config) {


        ConfigEntry test = config.get(name);


        if(entry.equals(test)) {
            return;
        }
        config.put(name, entry);

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

        String jsonString;
        HashMap<Object, ConfigEntry> map = new HashMap<>();

        try {
            jsonString = readFileAsString(Platform.getConfigFolder() + "/stellaris.json");
            JsonObject jsonObject = Stellaris.GSON.fromJson(jsonString, JsonObject.class);

            jsonObject.getAsJsonObject().entrySet().forEach(entry -> {
                String key = entry.getKey();
                JsonObject value = entry.getValue().getAsJsonObject();

                map.put(key, new ConfigEntry.ConfigEntryString(value.get("value").toString(), value.get("description").getAsString()));

            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        CONFIG = map;

    }

    public static String readFileAsString(String file) throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

}
