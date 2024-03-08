package com.st0x0ef.stellaris.common.menus;

import com.st0x0ef.stellaris.common.blocks.entities.RocketStationEntity;
import com.st0x0ef.stellaris.common.registry.MenuTypesRegistry;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

public class RocketStationMenu extends AbstractContainerMenu {

    RocketStationEntity rocketStationEntity;
    public RocketStationMenu(int i, Inventory inventory) {
        super(MenuTypesRegistry.ROCKET_STATION.get(), i);
    }

    public RocketStationMenu(int i, Inventory inventory, RocketStationMenu rocketStationMenu) {
        super(MenuTypesRegistry.ROCKET_STATION.get(), i);
        this.rocketStationEntity = rocketStationMenu.rocketStationEntity;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

}
