package neutrongalaxy.masterj.neutrongalaxy.entities;

import com.google.common.collect.Lists;
import net.minecraft.BlockUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.protocol.game.ServerboundPaddleBoatPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.entity.vehicle.ContainerEntity;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.ITeleporter;
import neutrongalaxy.masterj.neutrongalaxy.events.ClientEvents;
import neutrongalaxy.masterj.neutrongalaxy.init.EntityInit;
import neutrongalaxy.masterj.neutrongalaxy.init.ItemInit;
import neutrongalaxy.masterj.neutrongalaxy.networking.ModPackets;
import neutrongalaxy.masterj.neutrongalaxy.networking.packet.MoveRocketC2SPacket;
import neutrongalaxy.masterj.neutrongalaxy.networking.packet.RocketMsgC2SPacket;
import neutrongalaxy.masterj.neutrongalaxy.networking.packet.dispMsgS2CPacket;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class RocketEntity extends ChestBoat implements ITeleporter {

    public RocketEntity(EntityType<? extends RocketEntity> type, Level level) {
        super(type, level);
//        ClientEvents.launch = false;
        this.blocksBuilding = true;
    }

    public RocketEntity(Level pLevel, double pX, double pY, double pZ) {
        this(EntityInit.ROCKET.get(), pLevel);
//        ClientEvents.launch = false;
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
//        ModPackets.sendToServer(new RocketMsgC2SPacket());
        if (this.getFirstPassenger() instanceof LocalPlayer) {
            ModPackets.sendToPlayer(new dispMsgS2CPacket(), (ServerPlayer) this.getFirstPassenger());
        }
    }

    //    private static final EntityDataAccessor<Integer> DATA_ID_HURT = SynchedEntityData.defineId(RocketEntity.class, EntityDataSerializers.INT);
//    private static final EntityDataAccessor<Integer> DATA_ID_HURTDIR = SynchedEntityData.defineId(RocketEntity.class, EntityDataSerializers.INT);
//    private static final EntityDataAccessor<Float> DATA_ID_DAMAGE = SynchedEntityData.defineId(RocketEntity.class, EntityDataSerializers.FLOAT);
//    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(RocketEntity.class, EntityDataSerializers.INT);
//    private static final EntityDataAccessor<Boolean> DATA_ID_PADDLE_LEFT = SynchedEntityData.defineId(RocketEntity.class, EntityDataSerializers.BOOLEAN);
//    private static final EntityDataAccessor<Boolean> DATA_ID_PADDLE_RIGHT = SynchedEntityData.defineId(RocketEntity.class, EntityDataSerializers.BOOLEAN);
//    private static final EntityDataAccessor<Integer> DATA_ID_BUBBLE_TIME = SynchedEntityData.defineId(RocketEntity.class, EntityDataSerializers.INT);
//    public static final int PADDLE_LEFT = 0;
//    public static final int PADDLE_RIGHT = 1;
//    private static final int TIME_TO_EJECT = 60;
//    private static final float PADDLE_SPEED = ((float)Math.PI / 8F);
//    public static final double PADDLE_SOUND_TIME = (float)Math.PI / 4F;
//    public static final int BUBBLE_TIME = 60;
//    private final float[] paddlePositions = new float[2];
//    private float invFriction;
//    private float outOfControlTicks;
//    private float deltaRotation;
    private int lerpSteps;
    private double lerpX;
    private double lerpY;
    private double lerpZ;
    private double lerpYRot;
    private double lerpXRot;
//    private boolean inputLeft;
//    private boolean inputRight;
//    private boolean inputUp;
//    private boolean inputDown;
//    private double waterLevel;
//    private float landFriction;
//    private RocketEntity.Status status;
//    private RocketEntity.Status oldStatus;
//    private double lastYd;
//    private boolean isAboveBubbleColumn;
//    private boolean bubbleColumnDirectionIsDown;
//    private float bubbleMultiplier;
//    private float bubbleAngle;
//    private float bubbleAngleO;
//
//    protected float getEyeHeight(Pose pPose, EntityDimensions pSize) {
//        return pSize.height;
//    }
//
//    protected Entity.MovementEmission getMovementEmission() {
//        return Entity.MovementEmission.EVENTS;
//    }
//
//    protected void defineSynchedData() {
//        this.entityData.define(DATA_ID_HURT, 0);
//        this.entityData.define(DATA_ID_HURTDIR, 1);
//        this.entityData.define(DATA_ID_DAMAGE, 0.0F);
//        this.entityData.define(DATA_ID_TYPE, RocketEntity.Type.OAK.ordinal());
//        this.entityData.define(DATA_ID_PADDLE_LEFT, false);
//        this.entityData.define(DATA_ID_PADDLE_RIGHT, false);
//        this.entityData.define(DATA_ID_BUBBLE_TIME, 0);
//    }
//
//    public boolean canCollideWith(Entity pEntity) {
//        return canVehicleCollide(this, pEntity);
//    }
//
//    public static boolean canVehicleCollide(Entity pVehicle, Entity pEntity) {
//        return (pEntity.canBeCollidedWith() || pEntity.isPushable()) && !pVehicle.isPassengerOfSameVehicle(pEntity);
//    }
//
//    public boolean canBeCollidedWith() {
//        return false;
//    }
//
    /**
     * Returns {@code true} if this entity should push and be pushed by other entities when colliding.
     */
    @Override
    public boolean isPushable() {
        return false;
    }
//
//    protected Vec3 getRelativePortalPosition(Direction.Axis pAxis, BlockUtil.FoundRectangle pPortal) {
//        return LivingEntity.resetForwardDirectionOfRelativePortalPosition(super.getRelativePortalPosition(pAxis, pPortal));
//    }
//
    /**
     * Returns the Y offset from the entity's position for any entity riding this one.
     */
    @Override
    public double getPassengersRidingOffset() {
        return 1.4D;
    }
//
//    /**
//     * Called when the entity is attacked.
//     */
//    public boolean hurt(DamageSource pSource, float pAmount) {
//        if (this.isInvulnerableTo(pSource)) {
//            return false;
//        } else if (!this.level.isClientSide && !this.isRemoved()) {
//            this.setHurtDir(-this.getHurtDir());
//            this.setHurtTime(10);
//            this.setDamage(this.getDamage() + pAmount * 10.0F);
//            this.markHurt();
//            this.gameEvent(GameEvent.ENTITY_DAMAGE, pSource.getEntity());
//            boolean flag = pSource.getEntity() instanceof Player && ((Player)pSource.getEntity()).getAbilities().instabuild;
//            if (flag || this.getDamage() > 40.0F) {
//                if (!flag && this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
//                    this.destroy(pSource);
//                }
//
//                this.discard();
//            }
//
//            return true;
//        } else {
//            return true;
//        }
//    }
//
////    protected void destroy(DamageSource pDamageSource) {
////        this.spawnAtLocation(this.getDropItem());
////        this.chestVehicleDestroyed(pDamageSource, this.level, this);
////    }
//
//    public void onAboveBubbleCol(boolean pDownwards) {
//        if (!this.level.isClientSide) {
//            this.isAboveBubbleColumn = true;
//            this.bubbleColumnDirectionIsDown = pDownwards;
//            if (this.getBubbleTime() == 0) {
//                this.setBubbleTime(60);
//            }
//        }
//
//        this.level.addParticle(ParticleTypes.SPLASH, this.getX() + (double)this.random.nextFloat(), this.getY() + 0.7D, this.getZ() + (double)this.random.nextFloat(), 0.0D, 0.0D, 0.0D);
//        if (this.random.nextInt(20) == 0) {
//            this.level.playLocalSound(this.getX(), this.getY(), this.getZ(), this.getSwimSplashSound(), this.getSoundSource(), 1.0F, 0.8F + 0.4F * this.random.nextFloat(), false);
//            this.gameEvent(GameEvent.SPLASH, this.getControllingPassenger());
//        }
//
//    }
//
//    /**
//     * Applies a velocity to the entities, to push them away from each other.
//     */
//    public void push(Entity pEntity) {
//        if (pEntity instanceof RocketEntity) {
//            if (pEntity.getBoundingBox().minY < this.getBoundingBox().maxY) {
//                super.push(pEntity);
//            }
//        } else if (pEntity.getBoundingBox().minY <= this.getBoundingBox().minY) {
//            super.push(pEntity);
//        }
//
//    }
//
    @Override
    public @NotNull Item getDropItem() {
        return ItemInit.ROCKET.get();
    }
//
//    /**
//     * Setups the entity to do the hurt animation. Only used by packets in multiplayer.
//     */
//    public void animateHurt() {
//        this.setHurtDir(-this.getHurtDir());
//        this.setHurtTime(10);
//        this.setDamage(this.getDamage() * 11.0F);
//    }
//
//    /**
//     * Returns {@code true} if other Entities should be prevented from moving through this Entity.
//     */
//    public boolean isPickable() {
//        return !this.isRemoved();
//    }
//
//    /**
//     * Sets a target for the client to interpolate towards over the next few ticks
//     */
//    public void lerpTo(double pX, double pY, double pZ, float pYaw, float pPitch, int pPosRotationIncrements, boolean pTeleport) {
//        this.lerpX = pX;
//        this.lerpY = pY;
//        this.lerpZ = pZ;
//        this.lerpYRot = pYaw;
//        this.lerpXRot = pPitch;
//        this.lerpSteps = 10;
//    }
//
//    /**
//     * Gets the horizontal facing direction of this Entity, adjusted to take specially-treated entity types into account.
//     */
//    public Direction getMotionDirection() {
//        return this.getDirection().getClockWise();
//    }

//    private void tickLerp() {
//
//    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void tick() {
//        if (!this.level.isClientSide && this.outOfControlTicks >= 60.0F) {
//            this.ejectPassengers();
//        }
//
//        if (this.getHurtTime() > 0) {
//            this.setHurtTime(this.getHurtTime() - 1);
//        }
//
//        if (this.getDamage() > 0.0F) {
//            this.setDamage(this.getDamage() - 1.0F);
//        }

//        super.tick();
//        if (this.isControlledByLocalInstance()) {
//            this.lerpSteps = 0;
//            this.syncPacketPositionCodec(this.getX(), this.getY(), this.getZ());
//        }
//
//        if (this.lerpSteps > 0) {
//            double d0 = this.getX() + (this.lerpX - this.getX()) / (double)this.lerpSteps;
//            double d1 = this.getY() + (this.lerpY - this.getY()) / (double)this.lerpSteps;
//            double d2 = this.getZ() + (this.lerpZ - this.getZ()) / (double)this.lerpSteps;
//            double d3 = Mth.wrapDegrees(this.lerpYRot - (double)this.getYRot());
//            this.setYRot(this.getYRot() + (float)d3 / (float)this.lerpSteps);
//            this.setXRot(this.getXRot() + (float)(this.lerpXRot - (double)this.getXRot()) / (float)this.lerpSteps);
//            --this.lerpSteps;
//            this.setPos(d0, d1, d2);
//            this.setRot(this.getYRot(), this.getXRot());
//        }
//        noPhysics = true;
//        if (this.isControlledByLocalInstance()) {
//            if (!(this.getFirstPassenger() instanceof Player)) {
////                this.setPaddleState(false, false);
//                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.08D / 2.0D, 0.0D));
//            }
//
//            this.move(MoverType.SELF, this.getDeltaMovement());
//        } else {
////            this.setDeltaMovement(Vec3.ZERO);
//        }
//
//        for(int i = 0; i <= 1; ++i) {
//            if (this.getPaddleState(i)) {
//                if (!this.isSilent() && (double)(this.paddlePositions[i] % ((float)Math.PI * 2F)) <= (double)((float)Math.PI / 4F) && (double)((this.paddlePositions[i] + ((float)Math.PI / 8F)) % ((float)Math.PI * 2F)) >= (double)((float)Math.PI / 4F)) {}
//
//                this.paddlePositions[i] += ((float)Math.PI / 8F);
//            } else {
//                this.paddlePositions[i] = 0.0F;
//            }
//        }
//
//        this.checkInsideBlocks();
//        List<Entity> list = this.level.getEntities(this, this.getBoundingBox().inflate(0.2F, -0.01F, 0.2F), EntitySelector.pushableBy(this));
//        if (!list.isEmpty()) {
//            boolean flag = !this.level.isClientSide && !(this.getControllingPassenger() instanceof Player);
//
//            for(int j = 0; j < list.size(); ++j) {
//                Entity entity = list.get(j);
//                if (!entity.hasPassenger(this)) {
//                    if (flag && this.getPassengers().size() < this.getMaxPassengers() && !entity.isPassenger() && entity.getBbWidth() < this.getBbWidth() && entity instanceof LivingEntity && !(entity instanceof WaterAnimal) && !(entity instanceof Player)) {
//                        entity.startRiding(this);
//                    }// else {
////                        this.push(entity);
////                    }
//                }
//            }
//        }
//        this.move(MoverType.SELF, this.getDeltaMovement());
//        if (!ClientEvents.launch) {
//            this.setDeltaMovement(this.getDeltaMovement().normalize().add(0.0D, -0.08D / 2.0D, 0.0D));
//        }
//        if (ClientEvents.launch) { // Rocket goes up weirdly
//            ModPackets.sendToServer(new MoveRocketC2SPacket());
////            this.getControllingPassenger();
//        }
//        this.move(MoverType.SELF, this.getDeltaMovement());
//        System.out.println(ClientEvents.launch);
    }

    //    private void tickBubbleColumn() {
//        if (this.level.isClientSide) {
//            int i = this.getBubbleTime();
//            if (i > 0) {
//                this.bubbleMultiplier += 0.05F;
//            } else {
//                this.bubbleMultiplier -= 0.1F;
//            }
//
//            this.bubbleMultiplier = Mth.clamp(this.bubbleMultiplier, 0.0F, 1.0F);
//            this.bubbleAngleO = this.bubbleAngle;
//            this.bubbleAngle = 10.0F * (float)Math.sin(0.5F * (float)this.level.getGameTime()) * this.bubbleMultiplier;
//        } else {
//            if (!this.isAboveBubbleColumn) {
//                this.setBubbleTime(0);
//            }
//
//            int k = this.getBubbleTime();
//            if (k > 0) {
//                --k;
//                this.setBubbleTime(k);
//                int j = 60 - k - 1;
//                if (j > 0 && k == 0) {
//                    this.setBubbleTime(0);
//                    Vec3 vec3 = this.getDeltaMovement();
//                    if (this.bubbleColumnDirectionIsDown) {
//                        this.setDeltaMovement(vec3.add(0.0D, -0.7D, 0.0D));
//                        this.ejectPassengers();
//                    } else {
//                        this.setDeltaMovement(vec3.x, this.hasPassenger((p_150274_) -> {
//                            return p_150274_ instanceof Player;
//                        }) ? 2.7D : 0.6D, vec3.z);
//                    }
//                }
//
//                this.isAboveBubbleColumn = false;
//            }
//        }
//
//    }
//
//    @Nullable
//    protected SoundEvent getPaddleSound() {
//        switch (this.getStatus()) {
//            case IN_WATER:
//            case UNDER_WATER:
//            case UNDER_FLOWING_WATER:
//                return SoundEvents.BOAT_PADDLE_WATER;
//            case ON_LAND:
//                return SoundEvents.BOAT_PADDLE_LAND;
//            case IN_AIR:
//            default:
//                return null;
//        }
//    }
//
//    private void tickLerp() {
//        if (this.isControlledByLocalInstance()) {
//            this.lerpSteps = 0;
//            this.syncPacketPositionCodec(this.getX(), this.getY(), this.getZ());
//        }
//
//        if (this.lerpSteps > 0) {
//            double d0 = this.getX() + (this.lerpX - this.getX()) / (double)this.lerpSteps;
//            double d1 = this.getY() + (this.lerpY - this.getY()) / (double)this.lerpSteps;
//            double d2 = this.getZ() + (this.lerpZ - this.getZ()) / (double)this.lerpSteps;
//            double d3 = Mth.wrapDegrees(this.lerpYRot - (double)this.getYRot());
//            this.setYRot(this.getYRot() + (float)d3 / (float)this.lerpSteps);
//            this.setXRot(this.getXRot() + (float)(this.lerpXRot - (double)this.getXRot()) / (float)this.lerpSteps);
//            --this.lerpSteps;
//            this.setPos(d0, d1, d2);
//            this.setRot(this.getYRot(), this.getXRot());
//        }
//    }
//
//    public void setPaddleState(boolean pLeft, boolean pRight) {
//        this.entityData.set(DATA_ID_PADDLE_LEFT, pLeft);
//        this.entityData.set(DATA_ID_PADDLE_RIGHT, pRight);
//    }
//
//    public float getRowingTime(int pSide, float pLimbSwing) {
//        return this.getPaddleState(pSide) ? Mth.clampedLerp(this.paddlePositions[pSide] - ((float)Math.PI / 8F), this.paddlePositions[pSide], pLimbSwing) : 0.0F;
//    }
//
//    /**
//     * Determines whether the boat is in water, gliding on land, or in air
//     */
//    private RocketEntity.Status getStatus() {
//        RocketEntity.Status boat$status = this.isUnderwater();
//        if (boat$status != null) {
//            this.waterLevel = this.getBoundingBox().maxY;
//            return boat$status;
//        } else if (this.checkInWater()) {
//            return RocketEntity.Status.IN_WATER;
//        } else {
//            float f = this.getGroundFriction();
//            if (f > 0.0F) {
//                this.landFriction = f;
//                return RocketEntity.Status.ON_LAND;
//            } else {
//                return RocketEntity.Status.IN_AIR;
//            }
//        }
//    }
//
//    public float getWaterLevelAbove() {
//        AABB aabb = this.getBoundingBox();
//        int i = Mth.floor(aabb.minX);
//        int j = Mth.ceil(aabb.maxX);
//        int k = Mth.floor(aabb.maxY);
//        int l = Mth.ceil(aabb.maxY - this.lastYd);
//        int i1 = Mth.floor(aabb.minZ);
//        int j1 = Mth.ceil(aabb.maxZ);
//        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
//
//        label39:
//        for(int k1 = k; k1 < l; ++k1) {
//            float f = 0.0F;
//
//            for(int l1 = i; l1 < j; ++l1) {
//                for(int i2 = i1; i2 < j1; ++i2) {
//                    blockpos$mutableblockpos.set(l1, k1, i2);
//                    FluidState fluidstate = this.level.getFluidState(blockpos$mutableblockpos);
//                    f = Math.max(f, fluidstate.getHeight(this.level, blockpos$mutableblockpos));
//
//                    if (f >= 1.0F) {
//                        continue label39;
//                    }
//                }
//            }
//
//            if (f < 1.0F) {
//                return (float)blockpos$mutableblockpos.getY() + f;
//            }
//        }
//
//        return (float)(l + 1);
//    }
//
//    /**
//     * Decides how much the boat should be gliding on the land (based on any slippery blocks)
//     */
//    public float getGroundFriction() {
//        AABB aabb = this.getBoundingBox();
//        AABB aabb1 = new AABB(aabb.minX, aabb.minY - 0.001D, aabb.minZ, aabb.maxX, aabb.minY, aabb.maxZ);
//        int i = Mth.floor(aabb1.minX) - 1;
//        int j = Mth.ceil(aabb1.maxX) + 1;
//        int k = Mth.floor(aabb1.minY) - 1;
//        int l = Mth.ceil(aabb1.maxY) + 1;
//        int i1 = Mth.floor(aabb1.minZ) - 1;
//        int j1 = Mth.ceil(aabb1.maxZ) + 1;
//        VoxelShape voxelshape = Shapes.create(aabb1);
//        float f = 0.0F;
//        int k1 = 0;
//        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
//
//        for(int l1 = i; l1 < j; ++l1) {
//            for(int i2 = i1; i2 < j1; ++i2) {
//                int j2 = (l1 != i && l1 != j - 1 ? 0 : 1) + (i2 != i1 && i2 != j1 - 1 ? 0 : 1);
//                if (j2 != 2) {
//                    for(int k2 = k; k2 < l; ++k2) {
//                        if (j2 <= 0 || k2 != k && k2 != l - 1) {
//                            blockpos$mutableblockpos.set(l1, k2, i2);
//                            BlockState blockstate = this.level.getBlockState(blockpos$mutableblockpos);
//                            if (!(blockstate.getBlock() instanceof WaterlilyBlock) && Shapes.joinIsNotEmpty(blockstate.getCollisionShape(this.level, blockpos$mutableblockpos).move((double)l1, (double)k2, (double)i2), voxelshape, BooleanOp.AND)) {
//                                f += blockstate.getFriction(this.level, blockpos$mutableblockpos, this);
//                                ++k1;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        return f / (float)k1;
//    }
//
//    private boolean checkInWater() {
//        AABB aabb = this.getBoundingBox();
//        int i = Mth.floor(aabb.minX);
//        int j = Mth.ceil(aabb.maxX);
//        int k = Mth.floor(aabb.minY);
//        int l = Mth.ceil(aabb.minY + 0.001D);
//        int i1 = Mth.floor(aabb.minZ);
//        int j1 = Mth.ceil(aabb.maxZ);
//        boolean flag = false;
//        this.waterLevel = -Double.MAX_VALUE;
//        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
//
//        for(int k1 = i; k1 < j; ++k1) {
//            for(int l1 = k; l1 < l; ++l1) {
//                for(int i2 = i1; i2 < j1; ++i2) {
//                    blockpos$mutableblockpos.set(k1, l1, i2);
//                    FluidState fluidstate = this.level.getFluidState(blockpos$mutableblockpos);
//                    float f = (float) l1 + fluidstate.getHeight(this.level, blockpos$mutableblockpos);
//                    this.waterLevel = Math.max((double)f, this.waterLevel);
//                    flag |= aabb.minY < (double)f;
//                }
//            }
//        }
//
//        return flag;
//    }
//
//    /**
//     * Decides whether the boat is currently underwater.
//     */
//    @Nullable
//    private RocketEntity.Status isUnderwater() {
//        AABB aabb = this.getBoundingBox();
//        double d0 = aabb.maxY + 0.001D;
//        int i = Mth.floor(aabb.minX);
//        int j = Mth.ceil(aabb.maxX);
//        int k = Mth.floor(aabb.maxY);
//        int l = Mth.ceil(d0);
//        int i1 = Mth.floor(aabb.minZ);
//        int j1 = Mth.ceil(aabb.maxZ);
//        boolean flag = false;
//        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
//
//        for(int k1 = i; k1 < j; ++k1) {
//            for(int l1 = k; l1 < l; ++l1) {
//                for(int i2 = i1; i2 < j1; ++i2) {
//                    blockpos$mutableblockpos.set(k1, l1, i2);
//                    FluidState fluidstate = this.level.getFluidState(blockpos$mutableblockpos);
//                    if (d0 < (double) ((float) blockpos$mutableblockpos.getY() + fluidstate.getHeight(this.level, blockpos$mutableblockpos))) {
//                        if (!fluidstate.isSource()) {
//                            return RocketEntity.Status.UNDER_FLOWING_WATER;
//                        }
//
//                        flag = true;
//                    }
//                }
//            }
//        }
//
//        return flag ? RocketEntity.Status.UNDER_WATER : null;
//    }
//
//    /**
//     * Update the boat's speed, based on momentum.
//     */
//    private void floatRocketEntity() {
//        double d0 = (double)-0.04F;
//        double d1 = this.isNoGravity() ? 0.0D : (double)-0.04F;
//        double d2 = 0.0D;
//        this.invFriction = 0.05F;
//        if (this.oldStatus == RocketEntity.Status.IN_AIR && this.status != RocketEntity.Status.IN_AIR && this.status != RocketEntity.Status.ON_LAND) {
//            this.waterLevel = this.getY(1.0D);
//            this.setPos(this.getX(), (double)(this.getWaterLevelAbove() - this.getBbHeight()) + 0.101D, this.getZ());
//            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.0D, 1.0D));
//            this.lastYd = 0.0D;
//            this.status = RocketEntity.Status.IN_WATER;
//        } else {
//            if (this.status == RocketEntity.Status.IN_WATER) {
//                d2 = (this.waterLevel - this.getY()) / (double)this.getBbHeight();
//                this.invFriction = 0.9F;
//            } else if (this.status == RocketEntity.Status.UNDER_FLOWING_WATER) {
//                d1 = -7.0E-4D;
//                this.invFriction = 0.9F;
//            } else if (this.status == RocketEntity.Status.UNDER_WATER) {
//                d2 = (double)0.01F;
//                this.invFriction = 0.45F;
//            } else if (this.status == RocketEntity.Status.IN_AIR) {
//                this.invFriction = 0.9F;
//            } else if (this.status == RocketEntity.Status.ON_LAND) {
//                this.invFriction = this.landFriction;
//                if (this.getControllingPassenger() instanceof Player) {
//                    this.landFriction /= 2.0F;
//                }
//            }
//
//            Vec3 vec3 = this.getDeltaMovement();
//            this.setDeltaMovement(vec3.x * (double)this.invFriction, vec3.y + d1, vec3.z * (double)this.invFriction);
//            this.deltaRotation *= this.invFriction;
//            if (d2 > 0.0D) {
//                Vec3 vec31 = this.getDeltaMovement();
//                this.setDeltaMovement(vec31.x, (vec31.y + d2 * 0.06153846016296973D) * 0.75D, vec31.z);
//            }
//        }
//
//    }
//
//    private void controlRocketEntity() {
//        if (this.isVehicle()) {
//            float f = 0.0F;
//            if (this.inputLeft) {
//                --this.deltaRotation;
//            }
//
//            if (this.inputRight) {
//                ++this.deltaRotation;
//            }
//
//            if (this.inputRight != this.inputLeft && !this.inputUp && !this.inputDown) {
//                f += 0.005F;
//            }
//
//            this.setYRot(this.getYRot() + this.deltaRotation);
//            if (this.inputUp) {
//                f += 0.04F;
//            }
//
//            if (this.inputDown) {
//                f -= 0.005F;
//            }
//
//            this.setDeltaMovement(this.getDeltaMovement().add((double)(Mth.sin(-this.getYRot() * ((float)Math.PI / 180F)) * f), 0.0D, (double)(Mth.cos(this.getYRot() * ((float)Math.PI / 180F)) * f)));
//            this.setPaddleState(this.inputRight && !this.inputLeft || this.inputUp, this.inputLeft && !this.inputRight || this.inputUp);
//        }
//    }
//
//    protected float getSinglePassengerXOffset() {
//        return 0.0F;
//    }
//
//    public void positionRider(Entity pPassenger) {
//        if (this.hasPassenger(pPassenger)) {
//            float f = this.getSinglePassengerXOffset();
//            float f1 = (float)((this.isRemoved() ? (double)0.01F : this.getPassengersRidingOffset()) + pPassenger.getMyRidingOffset());
//            if (this.getPassengers().size() > 1) {
//                int i = this.getPassengers().indexOf(pPassenger);
//                if (i == 0) {
//                    f = 0.2F;
//                } else {
//                    f = -0.6F;
//                }
//
//                if (pPassenger instanceof Animal) {
//                    f += 0.2F;
//                }
//            }
//
//            Vec3 vec3 = (new Vec3(f, 0.0D, 0.0D)).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
//            pPassenger.setPos(this.getX() + vec3.x, this.getY() + (double)f1, this.getZ() + vec3.z);
//            pPassenger.setYRot(pPassenger.getYRot() + this.deltaRotation);
//            pPassenger.setYHeadRot(pPassenger.getYHeadRot() + this.deltaRotation);
////            this.clampRotation(pPassenger);
//            if (pPassenger instanceof Animal && this.getPassengers().size() == this.getMaxPassengers()) {
//                int j = pPassenger.getId() % 2 == 0 ? 90 : 270;
//                pPassenger.setYBodyRot(((Animal)pPassenger).yBodyRot + (float)j);
//                pPassenger.setYHeadRot(pPassenger.getYHeadRot() + (float)j);
//            }
//
//        }
//    }
//
    @OnlyIn(Dist.CLIENT)
    private void client_stuff() {
        Minecraft.getInstance().options.setCameraType(CameraType.FIRST_PERSON);
    }
    @Override
    public Vec3 getDismountLocationForPassenger(LivingEntity pLivingEntity) {
//        client_stuff();
        Vec3 vec3 = getCollisionHorizontalEscapeVector((double)(this.getBbWidth() * Mth.SQRT_OF_TWO), (double)pLivingEntity.getBbWidth(), pLivingEntity.getYRot());
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

            for(Pose pose : pLivingEntity.getDismountPoses()) {
                for(Vec3 vec31 : list) {
                    if (DismountHelper.canDismountTo(this.level, vec31, pLivingEntity, pose)) {
                        pLivingEntity.setPose(pose);
                        return vec31;
                    }
                }
            }
        }

        return super.getDismountLocationForPassenger(pLivingEntity);
    }

    /**
     * Applies this boat's yaw to the given entity. Used to update the orientation of its passenger.
     */
    @Override
    protected void clampRotation(Entity pEntityToUpdate) {
        float f = Mth.wrapDegrees(pEntityToUpdate.getYRot() - this.getYRot());
        float f1 = Mth.clamp(f, -105.0F, 105.0F);
    }
//
//    /**
//     * Applies this entity's orientation (pitch/yaw) to another entity. Used to update passenger orientation.
//     */
////    public void onPassengerTurned(Entity pEntityToUpdate) {
////        this.clampRotation(pEntityToUpdate);
////    }
//
//    protected void addAdditionalSaveData(CompoundTag pCompound) {
//        pCompound.putString("Type", this.getRocketEntityType().getName());
//        this.addChestVehicleSaveData(pCompound);
//    }
//
//    /**
//     * (abstract) Protected helper method to read subclass entity data from NBT.
//     */
//    protected void readAdditionalSaveData(CompoundTag pCompound) {
//        if (pCompound.contains("Type", 8)) {
//            this.setType(RocketEntity.Type.byName(pCompound.getString("Type")));
//        }
//        this.readChestVehicleSaveData(pCompound);
//    }
//
//    public InteractionResult interact(Player pPlayer, InteractionHand pHand) {
//        if (this.canAddPassenger(pPlayer) && !pPlayer.isSecondaryUseActive()) {
//            if (pPlayer.isSecondaryUseActive()) {
//                return InteractionResult.PASS;
//            } else if (this.outOfControlTicks < 60.0F) {
//                if (!this.level.isClientSide) {
//                    return pPlayer.startRiding(this) ? InteractionResult.CONSUME : InteractionResult.PASS;
//                } else {
//                    return InteractionResult.SUCCESS;
//                }
//            } else {
//                return InteractionResult.PASS;
//            }
//        } else {
//            return this.interactWithChestVehicle(this::gameEvent, pPlayer);
//        }
//    }
//
//    protected void checkFallDamage(double pY, boolean pOnGround, BlockState pState, BlockPos pPos) {
//        this.lastYd = this.getDeltaMovement().y;
//        if (!this.isPassenger()) {
//            if (pOnGround) {
//                if (this.fallDistance > 3.0F) {
//                    if (this.status != RocketEntity.Status.ON_LAND) {
//                        this.resetFallDistance();
//                        return;
//                    }
//
//                    this.causeFallDamage(this.fallDistance, 1.0F, DamageSource.FALL);
//                    if (!this.level.isClientSide && !this.isRemoved()) {
//                        this.kill();
//                        if (this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
//                            for(int i = 0; i < 3; ++i) {
//                                this.spawnAtLocation(this.getRocketEntityType().getPlanks());
//                            }
//
//                            for(int j = 0; j < 2; ++j) {
//                                this.spawnAtLocation(Items.STICK);
//                            }
//                        }
//                    }
//                }
//
//                this.resetFallDistance();
//            }
//
//        }
//    }
//
//    public boolean getPaddleState(int pSide) {
//        return this.entityData.<Boolean>get(pSide == 0 ? DATA_ID_PADDLE_LEFT : DATA_ID_PADDLE_RIGHT) && this.getControllingPassenger() != null;
//    }
//
//    /**
//     * Sets the damage taken from the last hit.
//     */
//    public void setDamage(float pDamageTaken) {
//        this.entityData.set(DATA_ID_DAMAGE, pDamageTaken);
//    }
//
//    /**
//     * Gets the damage taken from the last hit.
//     */
//    public float getDamage() {
//        return this.entityData.get(DATA_ID_DAMAGE);
//    }
//
//    /**
//     * Sets the time to count down from since the last time entity was hit.
//     */
//    public void setHurtTime(int pHurtTime) {
//        this.entityData.set(DATA_ID_HURT, pHurtTime);
//    }
//
//    /**
//     * Gets the time since the last hit.
//     */
//    public int getHurtTime() {
//        return this.entityData.get(DATA_ID_HURT);
//    }
//
//    private void setBubbleTime(int pBubbleTime) {
//        this.entityData.set(DATA_ID_BUBBLE_TIME, pBubbleTime);
//    }
//
//    private int getBubbleTime() {
//        return this.entityData.get(DATA_ID_BUBBLE_TIME);
//    }
//
//    public float getBubbleAngle(float pPartialTicks) {
//        return Mth.lerp(pPartialTicks, this.bubbleAngleO, this.bubbleAngle);
//    }
//
//    /**
//     * Sets the forward direction of the entity.
//     */
//    public void setHurtDir(int pHurtDirection) {
//        this.entityData.set(DATA_ID_HURTDIR, pHurtDirection);
//    }
//
//    /**
//     * Gets the forward direction of the entity.
//     */
//    public int getHurtDir() {
//        return this.entityData.get(DATA_ID_HURTDIR);
//    }
//
//    public void setType(RocketEntity.Type pRocketEntityType) {
//        this.entityData.set(DATA_ID_TYPE, pRocketEntityType.ordinal());
//    }
//
//    public RocketEntity.Type getRocketEntityType() {
//        return RocketEntity.Type.byId(this.entityData.get(DATA_ID_TYPE));
//    }
//
//    protected boolean canAddPassenger(Entity pPassenger) {
//        return this.getPassengers().size() < this.getMaxPassengers();
//    }
//
//    protected int getMaxPassengers() {
//        return 1;
//    }
//
//    /**
//     * For vehicles, the first passenger is generally considered the controller and "drives" the vehicle. For example,
//     * Pigs, Horses, and RocketEntitys are generally "steered" by the controlling passenger.
//     */
//    @Nullable
//    public Entity getControllingPassenger() {
//        return this.getFirstPassenger();
//    }
//
//    public void setInput(boolean pInputLeft, boolean pInputRight, boolean pInputUp, boolean pInputDown) {
//        this.inputLeft = pInputLeft;
//        this.inputRight = pInputRight;
//        this.inputUp = pInputUp;
//        this.inputDown = pInputDown;
//    }
//
//    public Packet<?> getAddEntityPacket() {
//        return new ClientboundAddEntityPacket(this);
//    }
//
//    public boolean isUnderWater() {
//        return this.status == RocketEntity.Status.UNDER_WATER || this.status == RocketEntity.Status.UNDER_FLOWING_WATER;
//    }
//
    @OnlyIn(Dist.CLIENT)
    private void client_stuff2() {
        Minecraft.getInstance().options.setCameraType(CameraType.THIRD_PERSON_FRONT);
    }

    // Forge: Fix MC-119811 by instantly completing lerp on board
    @Override
    protected void addPassenger(Entity passenger) {
//        client_stuff2();
        super.addPassenger(passenger);
        if (this.isControlledByLocalInstance() && this.lerpSteps > 0) {
            this.lerpSteps = 0;
            this.absMoveTo(this.lerpX, this.lerpY, this.lerpZ, (float)this.lerpYRot, (float)this.lerpXRot);
        }
    }
//
//    public ItemStack getPickResult() {
//        return new ItemStack(this.getDropItem());
//    }
//
//    public static enum Status {
//        IN_WATER,
//        UNDER_WATER,
//        UNDER_FLOWING_WATER,
//        ON_LAND,
//        IN_AIR;
//    }
//
//    public static enum Type {
//        OAK(Blocks.OAK_PLANKS, "oak"),
//        SPRUCE(Blocks.SPRUCE_PLANKS, "spruce"),
//        BIRCH(Blocks.BIRCH_PLANKS, "birch"),
//        JUNGLE(Blocks.JUNGLE_PLANKS, "jungle"),
//        ACACIA(Blocks.ACACIA_PLANKS, "acacia"),
//        DARK_OAK(Blocks.DARK_OAK_PLANKS, "dark_oak"),
//        MANGROVE(Blocks.MANGROVE_PLANKS, "mangrove");
//
//        private final String name;
//        private final Block planks;
//
//        private Type(Block pPlanks, String pName) {
//            this.name = pName;
//            this.planks = pPlanks;
//        }
//
//        public String getName() {
//            return this.name;
//        }
//
//        public Block getPlanks() {
//            return this.planks;
//        }
//
//        public String toString() {
//            return this.name;
//        }
//
//        /**
//         * Get a boat type by its enum ordinal
//         */
//        public static RocketEntity.Type byId(int pId) {
//            RocketEntity.Type[] aboat$type = values();
//            if (pId < 0 || pId >= aboat$type.length) {
//                pId = 0;
//            }
//
//            return aboat$type[pId];
//        }
//
//        public static RocketEntity.Type byName(String pName) {
//            RocketEntity.Type[] aboat$type = values();
//
//            for(int i = 0; i < aboat$type.length; ++i) {
//                if (aboat$type[i].getName().equals(pName)) {
//                    return aboat$type[i];
//                }
//            }
//
//            return aboat$type[0];
//        }
//    }
}
