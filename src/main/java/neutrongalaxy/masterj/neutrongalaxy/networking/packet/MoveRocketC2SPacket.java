package neutrongalaxy.masterj.neutrongalaxy.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;
import neutrongalaxy.masterj.neutrongalaxy.entities.RocketEntity;
import neutrongalaxy.masterj.neutrongalaxy.entities.TP;
import neutrongalaxy.masterj.neutrongalaxy.events.ClientEvents;

import java.util.Objects;
import java.util.function.Supplier;

public class MoveRocketC2SPacket {
    public MoveRocketC2SPacket() {

    }

    public MoveRocketC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            // Here we are on the server
            ServerPlayer player = ctx.getSender();
            ServerLevel level = player.getLevel();

            if (player.getRootVehicle() instanceof RocketEntity) {
                if (player.getRootVehicle().getY() <= 151) {// this condition is true, just takes forever to get the entity moving
                    Objects.requireNonNull(player.getVehicle()).setDeltaMovement(player.getVehicle().getDeltaMovement().add(0.0D, 0.01D, 0.0D));
                } else if (player.getRootVehicle().getY() >= 151) {
                    player.getRootVehicle().changeDimension(Objects.requireNonNull(Objects.requireNonNull(player.getServer()).getLevel(Level.NETHER)), new TP());
                    player.changeDimension(Objects.requireNonNull(player.getServer().getLevel(Level.NETHER)), new TP());
                    player.getRootVehicle().setOnGround(true);
                }
            } else {
                ClientEvents.launch = false;
            }
        });
        return true;
    }
}
