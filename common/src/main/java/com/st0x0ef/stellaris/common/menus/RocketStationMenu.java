package com.st0x0ef.stellaris.common.menus;

import com.st0x0ef.stellaris.Stellaris;
import com.st0x0ef.stellaris.common.blocks.entities.RocketStationEntity;
import com.st0x0ef.stellaris.common.registry.MenuTypesRegistry;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BrewingStandBlockEntity;

public class RocketStationMenu extends AbstractContainerMenu {

    RocketStationEntity rocketStationEntity;
    private final Container rocketStation
            ;
    public RocketStationMenu(int i, Inventory inventory) {
        this(i, inventory, new SimpleContainer(3));
    }

    public RocketStationMenu(int i, Inventory inventory, Container container) {
        super(MenuTypesRegistry.ROCKET_STATION.get(), i);
        checkContainerSize(container, 3);
        this.rocketStation = container;
        addSlots(inventory);
        addPlayerHotbar(inventory);
        addPlayerInventory(inventory);


    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return this.rocketStation.stillValid(player);
    }


    private void addSlots(Inventory inventory) {
        this.addSlot(new Slot(inventory, 0, 56, 51));
        this.addSlot(new Slot(inventory, 1, 79, 58));
        this.addSlot(new Slot(inventory, 2, 102, 51));

    }

    public void addPlayerHotbar(Inventory playerInventory) {
        int j;
        for(j = 0; j < 9; ++j) {
            this.addSlot(new Slot(playerInventory, j, 8 + j * 18, 200));
        }
    }

    public void addPlayerInventory(Inventory playerInventory) {
        int j;
        int k;
        for(j = 0; j < 3; ++j) {
            for(k = 0; k < 9; ++k) {
                this.addSlot(new Slot(playerInventory, k + j * 9 + 9, 8 + k * 18, (84 + j * 18) + 58));
            }
        }
    }

}
