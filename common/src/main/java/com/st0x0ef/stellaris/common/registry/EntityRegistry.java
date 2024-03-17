package com.st0x0ef.stellaris.common.registry;

import com.st0x0ef.stellaris.Stellaris;
import com.st0x0ef.stellaris.common.blocks.entities.RocketStationEntity;
import com.st0x0ef.stellaris.common.entities.MartianRaptor;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;
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


}
