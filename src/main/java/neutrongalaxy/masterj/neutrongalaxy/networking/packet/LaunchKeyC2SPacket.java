package neutrongalaxy.masterj.neutrongalaxy.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import neutrongalaxy.masterj.neutrongalaxy.entities.RocketEntity;

import java.util.function.Supplier;

public class LaunchKeyC2SPacket {
    private final boolean pressed;

    public LaunchKeyC2SPacket(boolean pressed) {
        this.pressed = pressed;
    }

    public LaunchKeyC2SPacket(FriendlyByteBuf buf) {
        this.pressed = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBoolean(pressed);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player != null && player.getVehicle() instanceof RocketEntity rocket) {
                rocket.setLaunch(pressed);
            }
        });
        ctx.get().setPacketHandled(true);
    }
}