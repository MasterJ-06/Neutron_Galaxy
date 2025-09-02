package neutrongalaxy.masterj.neutrongalaxy.entities;

import com.google.common.collect.Lists;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.ContainerEntity;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.network.NetworkHooks;
import neutrongalaxy.masterj.neutrongalaxy.client.gui.screens.rocket.RocketMenu;
import neutrongalaxy.masterj.neutrongalaxy.init.EntityInit;
import neutrongalaxy.masterj.neutrongalaxy.init.FluidInit;
import neutrongalaxy.masterj.neutrongalaxy.init.ItemInit;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.List;

public class RocketEntity extends Entity implements ITeleporter, ContainerEntity, HasCustomInventoryScreen, Serializable {
    private static final EntityDataAccessor<Integer> DATA_ID_HURT = SynchedEntityData.defineId(RocketEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_ID_HURTDIR = SynchedEntityData.defineId(RocketEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> DATA_ID_DAMAGE = SynchedEntityData.defineId(RocketEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(RocketEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> DATA_LAUNCH = SynchedEntityData.defineId(RocketEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_FUEL = SynchedEntityData.defineId(RocketEntity.class, EntityDataSerializers.BOOLEAN);
    private float outOfControlTicks;
    private float deltaRotation;
    private int lerpSteps;
    private double lerpX;
    private double lerpY;
    private double lerpZ;
    private double lerpYRot;
    private double lerpXRot;

    // Simple server-side energy store (authoritative)
    private int energy;
    private int capacity = 100000;
    private int maxReceive = 1000;
    private int maxExtract = 1000;

    public RocketEntity(EntityType<? extends RocketEntity> type, Level level) {
        super(type, level);
        this.blocksBuilding = true;
//        lazyEnergyHandler = LazyOptional.of(() -> ENERGY_STORAGE);
    }

    public RocketEntity(Level p_38293_, double p_38294_, double p_38295_, double p_38296_) {
        this(EntityInit.ROCKET.get(), p_38293_);
        this.setPos(p_38294_, p_38295_, p_38296_);
        this.xo = p_38294_;
        this.yo = p_38295_;
        this.zo = p_38296_;
//        lazyEnergyHandler = LazyOptional.of(() -> ENERGY_STORAGE);
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(DATA_ID_HURT, 0);
        this.entityData.define(DATA_ID_HURTDIR, 1);
        this.entityData.define(DATA_ID_DAMAGE, 0.0F);
        this.entityData.define(DATA_ID_TYPE, RocketEntity.Type.ROCKET.ordinal());
        this.entityData.define(DATA_LAUNCH, false);
        this.entityData.define(DATA_FUEL, false);
    }

    public void setLaunch(boolean bool) {
        this.entityData.set(RocketEntity.DATA_LAUNCH, bool);
    }

    public boolean getLaunch() {
        return this.entityData.get(DATA_LAUNCH);
    }

    public void setFuel(boolean bool) {
        this.entityData.set(DATA_FUEL, bool);
    }

    public boolean getFuel() {
        return this.entityData.get(DATA_FUEL);
    }

    public void tick() {

        if (this.getHurtTime() > 0) {
            this.setHurtTime(this.getHurtTime() - 1);
        }

        if (this.getDamage() > 0.0F) {
            this.setDamage(this.getDamage() - 1.0F);
        }

        super.tick();
//        if (!this.level.isClientSide) {
//            if (hasEnoughEnergy(this)) {
//                setFuel(true);
//            } else {
//                setFuel(false);
//                setLaunch(false);
//            }
//        }
//        if (this.getLaunch() && this.getFuel()) {
//            if (!this.hasExactlyOnePlayerPassenger()) {
//                this.setLaunch(false);
//            }
//            //not working
////            extractEnergy(this);
//            this.ENERGY_STORAGE.extractEnergy(ENERGY_REQ, false);
//            ModPackets.sendToServer(new MoveRocketC2SPacket());
//            this.move(MoverType.SELF, this.getDeltaMovement());
//        } else {
//            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.02D, 0.0D));
//            this.move(MoverType.SELF, this.getDeltaMovement());
//        }
//        this.checkInsideBlocks();
        int fuel_slot = this.hasRocketFuelInInv();
        if (fuel_slot != -1) {
            //try to fix this if statement so fuel can fill completely, but does not add fuel at 60000
            if (this.getEnergyStored() < capacity) {
                this.receiveEnergy(128, false);
                this.removeItem(fuel_slot, 1);
            }
        }
    }

    public BlockPos getPos() {
        return new BlockPos(this.getX(), this.getY(), this.getZ());
    }

    // Persist energy to NBT
    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        this.readChestVehicleSaveData(pCompound);
        if (pCompound.contains("Energy")) this.energy = pCompound.getInt("Energy");
        if (pCompound.contains("Capacity")) this.capacity = pCompound.getInt("Capacity");
        if (pCompound.contains("MaxReceive")) this.maxReceive = pCompound.getInt("MaxReceive");
        if (pCompound.contains("MaxExtract")) this.maxExtract = pCompound.getInt("MaxExtract");
        // Clamp after loading
        if (energy > capacity) energy = capacity;
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        this.addChestVehicleSaveData(pCompound);
        pCompound.putInt("Energy", energy);
        pCompound.putInt("Capacity", capacity);
        pCompound.putInt("MaxReceive", maxReceive);
        pCompound.putInt("MaxExtract", maxExtract);
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public boolean canCollideWith(Entity p_38376_) {
        return canVehicleCollide(this, p_38376_);
    }

    public static boolean canVehicleCollide(Entity p_38324_, Entity p_38325_) {
        return false; //(p_38325_.canBeCollidedWith() || p_38325_.isPushable()) && !p_38324_.isPassengerOfSameVehicle(p_38325_);
    }

    public boolean isPushable() {
        return false;
    }

    public double getPassengersRidingOffset() {
//        return -0.1D;
        return 1.4D;
    }

    public boolean hurt(DamageSource p_38319_, float p_38320_) {
        if (this.isInvulnerableTo(p_38319_)) {
            return false;
        } else if (!this.level.isClientSide && !this.isRemoved()) {
            this.setHurtDir(-this.getHurtDir());
            this.setHurtTime(10);
            this.setDamage(this.getDamage() + p_38320_ * 10.0F);
            this.markHurt();
            this.gameEvent(GameEvent.ENTITY_DAMAGE, p_38319_.getEntity());
            boolean flag = p_38319_.getEntity() instanceof Player && ((Player)p_38319_.getEntity()).getAbilities().instabuild;
            if (flag || this.getDamage() > 40.0F) {
                if (!flag && this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                    this.destroy(p_38319_);
                }

                this.discard();
            }

            return true;
        } else {
            return true;
        }
    }

    public void push(Entity p_38373_) {
        if (p_38373_ instanceof RocketEntity) {
            if (p_38373_.getBoundingBox().minY < this.getBoundingBox().maxY) {
                super.push(p_38373_);
            }
        } else if (p_38373_.getBoundingBox().minY <= this.getBoundingBox().minY) {
            super.push(p_38373_);
        }

    }

    public Item getDropItem() {
        return ItemInit.ROCKET.get();
    }

    public void animateHurt() {
        this.setHurtDir(-this.getHurtDir());
        this.setHurtTime(10);
        this.setDamage(this.getDamage() * 11.0F);
    }

    public boolean isPickable() {
        return !this.isRemoved();
    }

    protected float getSinglePassengerXOffset() {
        return 0.0F;
    }

    public void positionRider(Entity p_38379_) {
        if (this.hasPassenger(p_38379_)) {
            float f = this.getSinglePassengerXOffset();
            float f1 = (float)((this.isRemoved() ? (double)0.01F : this.getPassengersRidingOffset()) + p_38379_.getMyRidingOffset());

            p_38379_.setPos(this.getX(), this.getY() + (double)f1, this.getZ());
            p_38379_.setYRot(p_38379_.getYRot() + this.deltaRotation);
            p_38379_.setYHeadRot(p_38379_.getYHeadRot() + this.deltaRotation);
        }
    }

    @Override
    public Vec3 getDismountLocationForPassenger(LivingEntity pPassenger) {
//        Minecraft.getInstance().options.setCameraType(CameraType.FIRST_PERSON);
//        ModPackets.sendToServer(new ChangeCameraC2SPacket(0));
        Vec3 vec3 = getCollisionHorizontalEscapeVector(this.getBbWidth() * Mth.SQRT_OF_TWO, pPassenger.getBbWidth(), pPassenger.getYRot());
        double d0 = this.getX() + vec3.x;
        double d1 = this.getZ() + vec3.z;
        BlockPos blockpos = new BlockPos(d0, this.getBoundingBox().maxY, d1);
        BlockPos blockpos1 = blockpos.below();
        if (!this.level.isWaterAt(blockpos1)) {
            List<Vec3> list = Lists.newArrayList();
            double d2 = this.level.getBlockFloorHeight(blockpos);
            if (DismountHelper.isBlockFloorValid(d2)) {
                list.add(new Vec3(d0, (double)blockpos.getY() + d2, d1));
            }

            double d3 = this.level.getBlockFloorHeight(blockpos1);
            if (DismountHelper.isBlockFloorValid(d3)) {
                list.add(new Vec3(d0, (double)blockpos1.getY() + d3, d1));
            }

            for(Pose pose : pPassenger.getDismountPoses()) {
                for(Vec3 vec31 : list) {
                    if (DismountHelper.canDismountTo(this.level, vec31, pPassenger, pose)) {
                        pPassenger.setPose(pose);
                        return vec31;
                    }
                }
            }
        }

        return super.getDismountLocationForPassenger(pPassenger);
    }

    public InteractionResult interact(Player pPlayer, InteractionHand pHand) {
        if (pPlayer.isSecondaryUseActive()) {
            this.interactWithChestVehicle(this::gameEvent, pPlayer);
            return InteractionResult.SUCCESS;
        } else if (this.outOfControlTicks < 60.0F) {
            if (!this.level.isClientSide) {
                pPlayer.sendSystemMessage(Component.literal("You will need thermal armour to go to any other planet other than the overworld or the moon.").withStyle(ChatFormatting.AQUA));
                return pPlayer.startRiding(this) ? InteractionResult.CONSUME : InteractionResult.PASS;
            } else {
                return InteractionResult.SUCCESS;
            }
        } else {
            return InteractionResult.PASS;
        }
    }

    private static final int CONTAINER_SIZE = 27;
    private NonNullList<ItemStack> itemStacks = NonNullList.withSize(27, ItemStack.EMPTY);
    @Nullable
    private ResourceLocation lootTable;
    private long lootTableSeed;

    protected void destroy(DamageSource pDamageSource) {
        this.spawnAtLocation(this.getDropItem());
        this.chestVehicleDestroyed(pDamageSource, this.level, this);
    }

    public void remove(Entity.RemovalReason pReason) {
        if (!this.level.isClientSide && pReason.shouldDestroy()) {
            Containers.dropContents(this.level, this, this);
        }

        super.remove(pReason);
    }

    public void openCustomInventoryScreen(Player pPlayer) {
        pPlayer.openMenu(this);
        if (!pPlayer.level.isClientSide) {
            this.gameEvent(GameEvent.CONTAINER_OPEN, pPlayer);
            PiglinAi.angerNearbyPiglins(pPlayer, true);
        }

    }

    public void clearContent() {
        this.clearChestVehicleContent();
    }

    /**
     * Returns the number of slots in the inventory.
     */
    public int getContainerSize() {
        return 27;
    }

    /**
     * Returns the stack in the given slot.
     */
    public ItemStack getItem(int pSlot) {
        return this.getChestVehicleItem(pSlot);
    }

    /**
     * Removes up to a specified number of items from an inventory slot and returns them in a new stack.
     */
    public ItemStack removeItem(int pSlot, int pAmount) {
        return this.removeChestVehicleItem(pSlot, pAmount);
    }

    /**
     * Removes a stack from the given slot and returns it.
     */
    public ItemStack removeItemNoUpdate(int pSlot) {
        return this.removeChestVehicleItemNoUpdate(pSlot);
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setItem(int pSlot, ItemStack pStack) {
        this.setChestVehicleItem(pSlot, pStack);
    }

    public SlotAccess getSlot(int pSlot) {
        return this.getChestVehicleSlot(pSlot);
    }

    /**
     * For block entities, ensures the chunk containing the block entity is saved to disk later - the game won't think it
     * hasn't changed and skip it.
     */
    public void setChanged() {
    }

    /**
     * Don't rename this method to canInteractWith due to conflicts with Container
     */
    public boolean stillValid(Player pPlayer) {
        return this.isChestVehicleStillValid(pPlayer);
    }

    @Nullable
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        if (this.lootTable != null && pPlayer.isSpectator()) {
            return null;
        } else {
            this.unpackLootTable(pPlayerInventory.player);
            return new RocketMenu(pContainerId, pPlayerInventory, this, this);
        }
    }

    public void unpackLootTable(@Nullable Player pPlayer) {
        this.unpackChestVehicleLootTable(pPlayer);
    }

    @Nullable
    public ResourceLocation getLootTable() {
        return this.lootTable;
    }

    public void setLootTable(@Nullable ResourceLocation pLootTable) {
        this.lootTable = pLootTable;
    }

    public long getLootTableSeed() {
        return this.lootTableSeed;
    }

    public void setLootTableSeed(long pLootTableSeed) {
        this.lootTableSeed = pLootTableSeed;
    }

    public NonNullList<ItemStack> getItemStacks() {
        return this.itemStacks;
    }

    public void clearItemStacks() {
        this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
    }

    // Energy API for capability delegate
    public int getEnergyStored() { return energy; }
    public int getMaxEnergyStored() { return capacity; }
    public void setEnergy(int pEnergy) { this.energy = pEnergy; }

    public int receiveEnergy(int amount, boolean simulate) {
        int space = capacity - energy;
        int accepted = Math.min(space, Math.min(amount, maxReceive));
        if (!simulate && accepted > 0) energy += accepted;
        return accepted;
    }

    public int extractEnergy(int amount, boolean simulate) {
        int available = Math.min(energy, Math.min(amount, maxExtract));
        if (!simulate && available > 0) energy -= available;
        return available;
    }

    // Optional: setters to tweak stats at runtime
    public void setCapacity(int capacity) {
        this.capacity = Math.max(0, capacity);
        if (energy > this.capacity) energy = this.capacity;
    }
    public void setMaxReceive(int maxReceive) { this.maxReceive = Math.max(0, maxReceive); }
    public void setMaxExtract(int maxExtract) { this.maxExtract = Math.max(0, maxExtract); }

    private int clientCapacity = 0;

    @OnlyIn(Dist.CLIENT)
    public void setClientCapacity(int capacity) {
        this.clientCapacity = capacity;
    }

    public int getSyncedCapacity() {
        return level != null && level.isClientSide ? clientCapacity : getMaxEnergyStored();
    }

    private int clientEnergy = 0;

    @OnlyIn(Dist.CLIENT)
    public void setClientEnergy(int energy) {
        this.clientEnergy = energy;
    }

    public int getSyncedEnergy() {
        return level != null && level.isClientSide ? clientEnergy : getEnergyStored();
    }

    private int hasRocketFuelInInv() {
        return hasItemInInventory(FluidInit.ROCKET_FUEL.bucket.get());
    }

    private int hasItemInInventory(Item item) {
        if (this.getItem(0).getItem() == item) {
            return 0;
        } else if (this.getItem(1).getItem() == item) {
            return 1;
        } else if (this.getItem(2).getItem() == item) {
            return 2;
        } else if (this.getItem(3).getItem() == item) {
            return 3;
        } else if (this.getItem(4).getItem() == item) {
            return 4;
        } else if (this.getItem(5).getItem() == item) {
            return 5;
        } else if (this.getItem(6).getItem() == item) {
            return 6;
        } else if (this.getItem(7).getItem() == item) {
            return 7;
        } else if (this.getItem(8).getItem() == item) {
            return 8;
        } else if (this.getItem(9).getItem() == item) {
            return 9;
        } else if (this.getItem(10).getItem() == item) {
            return 10;
        } else if (this.getItem(11).getItem() == item) {
            return 11;
        } else if (this.getItem(12).getItem() == item) {
            return 12;
        } else if (this.getItem(13).getItem() == item) {
            return 13;
        } else if (this.getItem(14).getItem() == item) {
            return 14;
        } else if (this.getItem(15).getItem() == item) {
            return 15;
        } else if (this.getItem(16).getItem() == item) {
            return 16;
        } else if (this.getItem(17).getItem() == item) {
            return 17;
        } else if (this.getItem(18).getItem() == item) {
            return 18;
        } else if (this.getItem(19).getItem() == item) {
            return 19;
        } else if (this.getItem(20).getItem() == item) {
            return 20;
        } else if (this.getItem(21).getItem() == item) {
            return 21;
        } else if (this.getItem(22).getItem() == item) {
            return 22;
        } else if (this.getItem(23).getItem() == item) {
            return 23;
        } else if (this.getItem(24).getItem() == item) {
            return 24;
        } else if (this.getItem(25).getItem() == item) {
            return 25;
        } else if (this.getItem(26).getItem() == item) {
            return 26;
        } else {
            return -1;
        }
    }

    public void setDamage(float p_38312_) {
        this.entityData.set(DATA_ID_DAMAGE, p_38312_);
    }

    public float getDamage() {
        return this.entityData.get(DATA_ID_DAMAGE);
    }

    public void setHurtTime(int p_38355_) {
        this.entityData.set(DATA_ID_HURT, p_38355_);
    }

    public int getHurtTime() {
        return this.entityData.get(DATA_ID_HURT);
    }

    public void setHurtDir(int p_38363_) {
        this.entityData.set(DATA_ID_HURTDIR, p_38363_);
    }

    public int getHurtDir() {
        return this.entityData.get(DATA_ID_HURTDIR);
    }

    public void setType(RocketEntity.Type p_38333_) {
        this.entityData.set(DATA_ID_TYPE, p_38333_.ordinal());
    }

    protected boolean canAddPassenger(Entity p_38390_) {
        return this.getPassengers().size() < this.getMaxPassengers();
    }

    protected int getMaxPassengers() {
        return 1;
    }

    @Nullable
    public Entity getControllingPassenger() {
        return null;
    }

    // Forge: Fix MC-119811 by instantly completing lerp on board
    @Override
    protected void addPassenger(Entity passenger) {
//        Minecraft.getInstance().options.setCameraType(CameraType.THIRD_PERSON_FRONT);
//        ModPackets.sendToServer(new ChangeCameraC2SPacket(2));
        super.addPassenger(passenger);
        if (this.isControlledByLocalInstance() && this.lerpSteps > 0) {
            this.lerpSteps = 0;
            this.absMoveTo(this.lerpX, this.lerpY, this.lerpZ, (float)this.lerpYRot, (float)this.lerpXRot);
        }
    }

    public ItemStack getPickResult() {
        return new ItemStack(this.getDropItem());
    }

    public RocketEntity.Type getRocketType() {
        return RocketEntity.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    public enum Type {
        ROCKET("rocket");

        private final String name;

        private Type(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }

        public static RocketEntity.Type byId(int p_38431_) {
            RocketEntity.Type[] arocket$type = values();
            if (p_38431_ < 0 || p_38431_ >= arocket$type.length) {
                p_38431_ = 0;
            }

            return arocket$type[p_38431_];
        }
    }
}