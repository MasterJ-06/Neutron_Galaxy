package neutrongalaxy.masterj.neutrongalaxy.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.MoverType;
import net.minecraftforge.network.NetworkEvent;
import neutrongalaxy.masterj.neutrongalaxy.entities.RocketEntity;
import neutrongalaxy.masterj.neutrongalaxy.events.ClientEvents;
import neutrongalaxy.masterj.neutrongalaxy.networking.ModPackets;

import java.util.UUID;
import java.util.function.Supplier;

public class MoveRocketDownC2SPacket {
    public MoveRocketDownC2SPacket() {

    }

    public MoveRocketDownC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            // Here we are on the server
            ServerPlayer player = ctx.getSender();
            ServerLevel level = player.getLevel();

//            player.getRootVehicle().setDeltaMovement(player.getRootVehicle().getDeltaMovement().normalize().add(0.0D, -0.14D, 0.0D));//player is no longer riding the rocket
            level.getAllEntities().forEach(x -> {
                if (x instanceof RocketEntity) {
                    if (!(x.getFirstPassenger() instanceof ServerPlayer)) {
                        x.setDeltaMovement(x.getDeltaMovement().normalize().add(0.0D, -0.14D, 0.0D));
                        x.move(MoverType.SELF, x.getDeltaMovement());
                    }
                }
            });
        });
        return true;
    }
}
