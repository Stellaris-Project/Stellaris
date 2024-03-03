package com.st0x0ef.stellaris.fabric.datagen;

import com.st0x0ef.stellaris.common.registry.ItemsRegistry;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.client.renderer.block.model.ItemModelGenerator;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.ModelTemplates;

public class ModDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(MyModelGenerator::new);
    }

    private static class MyModelGenerator extends FabricModelProvider {
        private MyModelGenerator(FabricDataOutput generator) {
            super(generator);
        }

        @Override
        public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {

        }

        @Override
        public void generateItemModels(ItemModelGenerators itemModelGenerator) {
            //itemModelGenerator.register(SIMPLE_BLOCK_ITEM, Models.GENERATED);
            itemModelGenerator.generateFlatItem(ItemsRegistry.STEEL_NUGGET.get(), ModelTemplates.FLAT_ITEM);
            itemModelGenerator.generateFlatItem(ItemsRegistry.RAW_STEEL_INGOT.get(), ModelTemplates.FLAT_ITEM);
            itemModelGenerator.generateFlatItem(ItemsRegistry.STEEL_INGOT.get(), ModelTemplates.FLAT_ITEM);

        }

    }




}
