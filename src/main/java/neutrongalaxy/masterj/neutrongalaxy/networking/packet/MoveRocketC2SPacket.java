package neutrongalaxy.masterj.neutrongalaxy.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkEvent;
import neutrongalaxy.masterj.neutrongalaxy.entities.RocketEntity;
import neutrongalaxy.masterj.neutrongalaxy.entities.TP;
import neutrongalaxy.masterj.neutrongalaxy.events.ClientEvents;
import neutrongalaxy.masterj.neutrongalaxy.networking.ModPackets;

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

//                if (player.getRootVehicle().getY() <= 151) {
//                    player.getRootVehicle().setDeltaMovement(player.getRootVehicle().getDeltaMovement().add(0.0D, 0.05D, 0.0D));
//                    player.getRootVehicle().move(MoverType.SELF, player.getRootVehicle().getDeltaMovement());
//                } else if (player.getRootVehicle().getY() >= 151) {
//                    player.getRootVehicle().setDeltaMovement(Vec3.ZERO);
//                    player.getRootVehicle().move(MoverType.SELF, player.getRootVehicle().getDeltaMovement());
//                    ModPackets.sendToPlayer(new RequestDestPlanetS2CPacket(), player);
//                }
            ModPackets.sendToPlayer(new RequestDestPlanetS2CPacket(), player);
        });
        return true;
    }
}
