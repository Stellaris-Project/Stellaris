package com.st0x0ef.stellaris.common.registry;

import com.st0x0ef.stellaris.Stellaris;
import com.st0x0ef.stellaris.common.blocks.entities.RocketStationEntity;
import com.st0x0ef.stellaris.common.entities.MartianRaptor;
import com.st0x0ef.stellaris.common.entities.Mogler;
import com.st0x0ef.stellaris.common.entities.PygroBrute;
import com.st0x0ef.stellaris.common.entities.StarCrawler;
import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.entity.BlockEntityType;

//For everything related to entities
public class EntityRegistry {
    //Block entity type
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPE = DeferredRegister.create(Stellaris.MODID, Registries.BLOCK_ENTITY_TYPE);
    public static final RegistrySupplier<BlockEntityType<RocketStationEntity>> ROCKET_STATION = BLOCK_ENTITY_TYPE.register("rocket_station",
            () -> BlockEntityType.Builder.of(RocketStationEntity::new, BlocksRegistry.ROCKET_STATION.get()).build(null));

    //Entity type

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create(Stellaris.MODID, Registries.ENTITY_TYPE);
    public static final RegistrySupplier<EntityType<MartianRaptor>> MARTIAN_RAPTOR = ENTITY_TYPE.register("martian_raptor",
        () -> EntityType.Builder.of(MartianRaptor::new, MobCategory.MONSTER).sized(0.75f, 2.0f).build(new ResourceLocation(Stellaris.MODID, "martian_raptor").toString()));
    //reserved for Pygro

    public static final RegistrySupplier<EntityType<PygroBrute>> PYGRO_BRUTE = ENTITY_TYPE.register("pygro_brute",
            () -> EntityType.Builder.of(PygroBrute::new, MobCategory.MONSTER).sized(0.75f, 2.0f).build(new ResourceLocation(Stellaris.MODID, "pygro_brute").toString()));
    public static final RegistrySupplier<EntityType<Mogler>> MOGLER = ENTITY_TYPE.register("mogler",
            () -> EntityType.Builder.of(Mogler::new, MobCategory.MONSTER).sized(0.75f, 2.0f).build(new ResourceLocation(Stellaris.MODID, "mogler").toString()));
    public static final RegistrySupplier<EntityType<StarCrawler>> STAR_CRAWLER = ENTITY_TYPE.register("star_crawler",
            () -> EntityType.Builder.of(StarCrawler::new, MobCategory.MONSTER).sized(0.75f, 2.0f).build(new ResourceLocation(Stellaris.MODID, "star_crawler").toString()));

    //Entity Attributes
    public static void registerAttributes() {
        EntityAttributeRegistry.register(EntityRegistry.MARTIAN_RAPTOR,  MartianRaptor::CreateRaptorAttributes);
        EntityAttributeRegistry.register(EntityRegistry.PYGRO_BRUTE, PygroBrute::setCustomAttributes);
        EntityAttributeRegistry.register(EntityRegistry.MOGLER, Mogler::setCustomAttributes);
        EntityAttributeRegistry.register(EntityRegistry.STAR_CRAWLER, StarCrawler::setCustomAttributes);
    }
}
