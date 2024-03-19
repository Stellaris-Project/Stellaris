package com.st0x0ef.stellaris.common.config;

import net.minecraft.util.StringRepresentable;

import java.io.Serializable;

public abstract class ConfigEntry implements Serializable {

    public abstract ConfigType getType();


    public static class ConfigEntryInt extends ConfigEntry {
        private final Integer value;
        private final String description;

        public ConfigEntryInt( Integer name, String description) {
            this.value = name;
            this.description = description;
        }

        @Override
        public ConfigType getType() {
            return ConfigType.INT;
        }

    }

    public static class ConfigEntryString extends ConfigEntry {
        private final String value;
        private final String description;

        public ConfigEntryString(String name, String description) {
            this.value = name;
            this.description = description;
        }

        @Override
        public ConfigType getType() {
            return ConfigType.INT;
        }

    }

    public enum ConfigType implements StringRepresentable {
        STRING,
        INT;

        @Override
        public String getSerializedName() {
            return name().toLowerCase();
        }
    }


}
