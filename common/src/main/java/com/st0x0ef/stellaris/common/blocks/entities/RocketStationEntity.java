package com.st0x0ef.stellaris.common.blocks.entities;

import com.st0x0ef.stellaris.Stellaris;
import com.st0x0ef.stellaris.common.data.recipes.RocketStationRecipe;
import com.st0x0ef.stellaris.common.menus.RocketStationMenu;
import com.st0x0ef.stellaris.common.registry.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class RocketStationEntity extends BaseContainerBlockEntity implements WorldlyContainer {

    private NonNullList<ItemStack> items;
    private List<Integer> inputSlots = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);


    public RocketStationEntity(BlockPos blockPos, BlockState blockState) {
        super(EntityRegistry.ROCKET_STATION.get(), blockPos, blockState);

        this.items = NonNullList.withSize(15, ItemStack.EMPTY);

    }

    @Override
    protected Component getDefaultName() {
        return Component.literal("Rocket Station");
    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inventory) {
        return new RocketStationMenu(i, inventory, this);
    }

    public int getContainerSize() {
        return this.items.size();
    }

    @Override
    public boolean isEmpty() {
        Iterator var1 = this.items.iterator();

        ItemStack itemStack;
        do {
            if (!var1.hasNext()) {
                return true;
            }

            itemStack = (ItemStack) var1.next();
        } while (itemStack.isEmpty());

        return false;
    }

    @Override
    public ItemStack getItem(int i) {
        return i >= 0 && i < this.items.size() ? (ItemStack) this.items.get(i) : ItemStack.EMPTY;
    }

    @Override
    public ItemStack removeItem(int i, int j) {
        return ContainerHelper.removeItem(this.items, i, j);
    }

    @Override
    public ItemStack removeItemNoUpdate(int i) {
        return ContainerHelper.takeItem(this.items, i);
    }

    @Override
    public void setItem(int i, ItemStack itemStack) {
        if (i >= 0 && i < this.items.size()) {
            this.items.set(i, itemStack);
        }

    }

    @Override
    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }

    @Override
    public void clearContent() {
        this.items.clear();
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(compoundTag, this.items);
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        ContainerHelper.saveAllItems(compoundTag, this.items);
    }


    @Override
    public int[] getSlotsForFace(Direction direction) {
        return new int[0];
    }

    @Override
    public boolean canPlaceItemThroughFace(int i, ItemStack itemStack, @Nullable Direction direction) {
        return false;
    }

    @Override
    public boolean canTakeItemThroughFace(int i, ItemStack itemStack, Direction direction) {
        return false;
    }

    private boolean hasRecipe() {
        Optional<RecipeHolder<RocketStationRecipe>> recipe = this.getCurrentRecipe();

        return recipe.isPresent() && canInsertAmountIntoOutputSlot(recipe.get().value().getResultItem(null))
                && canInsertItemIntoOutputSlot(recipe.get().value().getResultItem(null).getItem());
    }

    private Optional<RecipeHolder<RocketStationRecipe>> getCurrentRecipe() {
        SimpleContainer simpleContainer = new SimpleContainer(this.getContainerSize());
        for (int i = 0; i < this.getContainerSize(); i++) {
            simpleContainer.setItem(i, this.getItem(i));
        }
       return getLevel().getRecipeManager().getRecipeFor(RocketStationRecipe.Type.INSTANCE, simpleContainer, getLevel());
    }

    private void craftItem() {
        Optional<RecipeHolder<RocketStationRecipe>> recipe = getCurrentRecipe();
        Stellaris.LOG.error("TEST Slot Count: " + getItem(0).getCount());

        for (int i : inputSlots) {
            this.removeItem(i, 1);
        }

        int count = recipe.get().value().getResultItem(null).getCount() + getItem(14).getCount();
        Stellaris.LOG.error("Recipe Count: " + recipe.get().value().getResultItem(null).getCount());

        Stellaris.LOG.error("Slot Count: " + getItem(14).getCount());

        Stellaris.LOG.error("Count: " + count);
        this.setItem(14, new ItemStack(recipe.get().value().getResultItem(null).getItem(), count));
    }


    public void tick(Level world, BlockPos pos, BlockState state) {
        if(world.isClientSide()) {
            return;
        }

        if(isOutputSlotEmptyOrReceivable()) {
            if(this.hasRecipe()) {
                setChanged(world, pos, state);
                this.craftItem();

            }
        } else {
            setChanged(world, pos, state);
        }
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.getItem(15).getItem() == item || this.getItem(15).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getItem(15).getCount() + result.getCount() <= getItem(15).getMaxStackSize();
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        return this.getItem(15).isEmpty() || this.getItem(15).getCount() < this.getItem(15).getMaxStackSize();
    }
}