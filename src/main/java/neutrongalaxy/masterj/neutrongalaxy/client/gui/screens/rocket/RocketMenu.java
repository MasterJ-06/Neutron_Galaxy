package neutrongalaxy.masterj.neutrongalaxy.client.gui.screens.rocket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import neutrongalaxy.masterj.neutrongalaxy.entities.RocketEntity;
import neutrongalaxy.masterj.neutrongalaxy.init.MenuInit;
import neutrongalaxy.masterj.neutrongalaxy.networking.ModPackets;
import neutrongalaxy.masterj.neutrongalaxy.networking.packet.SyncEntityEnergyS2CPacket;

public class RocketMenu extends AbstractContainerMenu {
    private static final int SLOTS_PER_ROW = 9;
    private final Container container;
    private int containerRows = 3;

    /**
     * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player
     * inventory and the other inventory(s).
     */
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (pIndex < this.containerRows * 9) {
                if (!this.moveItemStackTo(itemstack1, this.containerRows * 9, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, this.containerRows * 9, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    /**
     * Called when the container is closed.
     */
    public void removed(Player pPlayer) {
        super.removed(pPlayer);
        this.container.stopOpen(pPlayer);
    }

    /**
     * Gets the inventory associated with this chest container.
     */
    public Container getContainer() {
        return this.container;
    }

    public int getRowCount() {
        return this.containerRows;
    }

    public RocketEntity getRocketEntity() {
        return this.rocket;
    }

    private final Level level;
    public final RocketEntity rocket;
    private Inventory inventory;

    // Client-side constructor (reads entity ID)
    public RocketMenu(int id, Inventory inv, FriendlyByteBuf buf) {
        this(id, inv, (RocketEntity) inv.player.level.getEntity(buf.readInt()), new SimpleContainer(9 * 3));
    }

    // Server-side constructor
    public RocketMenu(int id, Inventory inv, RocketEntity rocket, Container pContainer) {
        super(MenuInit.ROCKET_MENU.get(), id);
        this.level = inv.player.level;
        this.rocket = rocket;
        this.inventory = inv;

        if (!level.isClientSide) {
            ModPackets.sendToPlayer(new SyncEntityEnergyS2CPacket(rocket.getId(), rocket.getServerEnergy(), rocket.getServerCapacity()), (ServerPlayer) inv.player);
        }

        // Add player inventory slots
        int pRows = 3;
        checkContainerSize(pContainer, pRows * 9);
        this.container = pContainer;
        this.containerRows = pRows;
        pContainer.startOpen(inv.player);
        int i = (this.containerRows - 4) * 18;

        for (int j = 0; j < this.containerRows; ++j) {
            for (int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(pContainer, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }

        for (int l = 0; l < 3; ++l) {
            for (int j1 = 0; j1 < 9; ++j1) {
                this.addSlot(new Slot(inv, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
            }
        }

        for (int i1 = 0; i1 < 9; ++i1) {
            this.addSlot(new Slot(inv, i1, 8 + i1 * 18, 161 + i));
        }
    }

    public RocketMenu(int pContainerId, Inventory pPlayerInventory) {
        this(pContainerId, pPlayerInventory, pPlayerInventory.player.level.getEntitiesOfClass(RocketEntity.class, pPlayerInventory.player.getBoundingBoxForCulling().inflate(10)).get(0), new SimpleContainer(9 * 3));
    }

    public RocketEntity getRocket() {
        return rocket;
    }

    @Override
    public boolean stillValid(Player player) {
        return rocket != null && rocket.isAlive() && player.distanceTo(rocket) <= 8.0;
    }

    @Override
    public void broadcastChanges() {
        super.broadcastChanges();
        if (!this.rocket.level.isClientSide) {
            ModPackets.sendToPlayer(new SyncEntityEnergyS2CPacket(rocket.getId(), rocket.getServerEnergy(), rocket.getServerCapacity()), (ServerPlayer) inventory.player);
        }
    }
}
