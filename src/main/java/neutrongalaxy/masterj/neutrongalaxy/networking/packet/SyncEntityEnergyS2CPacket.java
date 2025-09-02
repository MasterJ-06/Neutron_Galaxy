package neutrongalaxy.masterj.neutrongalaxy.networking.packet;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkEvent;
import neutrongalaxy.masterj.neutrongalaxy.entities.RocketEntity;

import java.util.function.Supplier;

public class SyncEntityEnergyS2CPacket {
    private final int entityId;
    private final int capacity;
    private final int energy;

    public SyncEntityEnergyS2CPacket(int entityId, int capacity, int energy) {
        this.entityId = entityId;
        this.capacity = capacity;
        this.energy = energy;
    }

    // Decoder
    public SyncEntityEnergyS2CPacket(FriendlyByteBuf buf) {
        this.entityId = buf.readInt();
        this.capacity = buf.readInt();
        this.energy = buf.readInt();
    }

    // Encoder
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(entityId);
        buf.writeInt(capacity);
        buf.writeInt(energy);
    }

    // Handle on client
    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            client_stuff();
        });
        ctx.get().setPacketHandled(true);
    }

    @OnlyIn(Dist.CLIENT)
    private void client_stuff() {
        Minecraft mc = Minecraft.getInstance();
        Level level = mc.level;
        if (level != null) {
            Entity e = level.getEntity(entityId);
            if (e instanceof RocketEntity energyEntity) {
                energyEntity.setClientCapacity(capacity);
                energyEntity.setClientEnergy(energy);
            }
        }
    }
}
