package com.st0x0ef.stellaris.common.blocks.entities;

import com.st0x0ef.stellaris.Stellaris;
import com.st0x0ef.stellaris.common.menus.RocketStationMenu;
import com.st0x0ef.stellaris.common.registry.BlockEntityTypesRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class RocketStationEntity extends BlockEntity implements MenuProvider {
    public RocketStationEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntityTypesRegistry.ROCKET_STATION.get(), blockPos, blockState);
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Test");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        Stellaris.LOG.error("TEST");
        return new RocketStationMenu(i, inventory);
    }
}
