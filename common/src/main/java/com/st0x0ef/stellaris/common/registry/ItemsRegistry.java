package com.st0x0ef.stellaris.common.registry;

import com.st0x0ef.stellaris.Stellaris;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class ItemsRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Stellaris.MODID, Registries.ITEM);

    public static final RegistrySupplier<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties().arch$tab(CreativeTabsRegistry.MY_TAB)));
    public static final RegistrySupplier<Item> STEEL_NUGGET = ITEMS.register("steel_nugget", () -> new Item(new Item.Properties().arch$tab(CreativeTabsRegistry.MY_TAB)));
    public static final RegistrySupplier<Item> RAW_STEEL_INGOT = ITEMS.register("raw_steel_ingot", () -> new Item(new Item.Properties().arch$tab(CreativeTabsRegistry.MY_TAB)));

    /** Block Items */
    public static final RegistrySupplier<Item> STEEL_BLOCK_ITEM = ITEMS.register("steel_block", () -> new BlockItem(BlocksRegistry.STEEL_BLOCK.get(), new Item.Properties().arch$tab(CreativeTabsRegistry.MY_TAB)));
    public static final RegistrySupplier<Item> RAW_STEEL_BLOCK_ITEM = ITEMS.register("raw_steel_block", () -> new BlockItem(BlocksRegistry.RAW_STEEL_BLOCK.get(), new Item.Properties().arch$tab(CreativeTabsRegistry.MY_TAB)));
    public static final RegistrySupplier<Item> STEEL_PLANTING_BLOCK_ITEM = ITEMS.register("steel_planting_block", () -> new BlockItem(BlocksRegistry.STEEL_PLANTING_BLOCK.get(), new Item.Properties().arch$tab(CreativeTabsRegistry.MY_TAB)));

    public static final RegistrySupplier<Item> STEEL_ORE_ITEM = ITEMS.register("steel_ore", () -> new BlockItem(BlocksRegistry.STEEL_ORE.get(), new Item.Properties().arch$tab(CreativeTabsRegistry.MY_TAB)));
    public static final RegistrySupplier<Item> DEEPSLATE_STEEL_ORE_ITEM = ITEMS.register("deepslate_steel_ore", () -> new BlockItem(BlocksRegistry.DEEPSLATE_STEEL_ORE.get(), new Item.Properties().arch$tab(CreativeTabsRegistry.MY_TAB)));

    /** Moon Items */
    public static final RegistrySupplier<Item> CHISELED_MOON_STONE_ITEM = ITEMS.register("chiseled_moon_stone", () -> new BlockItem(BlocksRegistry.CHISELED_MOON_STONE.get(), new Item.Properties().arch$tab(CreativeTabsRegistry.MY_TAB)));
    public static final RegistrySupplier<Item> MOON_COBBLESTONE_ITEM = ITEMS.register("moon_cobblestone", () -> new BlockItem(BlocksRegistry.MOON_COBBLESTONE.get(), new Item.Properties().arch$tab(CreativeTabsRegistry.MY_TAB)));
    public static final RegistrySupplier<Item> MOON_SAND_ITEM = ITEMS.register("moon_sand", () -> new BlockItem(BlocksRegistry.MOON_SAND.get(), new Item.Properties().arch$tab(CreativeTabsRegistry.MY_TAB)));
    public static final RegistrySupplier<Item> MOON_STONE_ITEM = ITEMS.register("moon_stone", () -> new BlockItem(BlocksRegistry.MOON_STONE.get(), new Item.Properties().arch$tab(CreativeTabsRegistry.MY_TAB)));

    /** Rocket Parts */
    public static final RegistrySupplier<Item> ROCKET_NOSE_CONE = ITEMS.register("rocket_nose_cone", () -> new Item(new Item.Properties()));
    public static final RegistrySupplier<Item> ROCKET_FIN = ITEMS.register("rocket_fin", () -> new Item(new Item.Properties().arch$tab(CreativeTabsRegistry.MY_TAB)));
    public static final RegistrySupplier<Item> ROCKET_FAN = ITEMS.register("engine_fan", () -> new Item(new Item.Properties().arch$tab(CreativeTabsRegistry.MY_TAB)));
    public static final RegistrySupplier<Item> ROCKET_ENGINE = ITEMS.register("rocket_engine", () -> new Item(new Item.Properties().arch$tab(CreativeTabsRegistry.MY_TAB)));
    public static final RegistrySupplier<Item> FUEL_ROCKET_MOTOR = ITEMS.register("fuel_rocket_motor", () -> new Item(new Item.Properties().arch$tab(CreativeTabsRegistry.MY_TAB)));


    public static final RegistrySupplier<Item> ROCKET_STATION = ITEMS.register("rocket_station", () -> new BlockItem(BlocksRegistry.ROCKET_STATION.get(), new Item.Properties().arch$tab(CreativeTabsRegistry.MY_TAB)));

}