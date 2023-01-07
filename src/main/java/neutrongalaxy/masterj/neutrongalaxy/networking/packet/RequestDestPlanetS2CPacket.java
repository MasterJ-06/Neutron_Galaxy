package neutrongalaxy.masterj.neutrongalaxy.networking.packet;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;
import neutrongalaxy.masterj.neutrongalaxy.client.gui.screens.SpaceScreen;
import neutrongalaxy.masterj.neutrongalaxy.entities.RocketEntity;
import neutrongalaxy.masterj.neutrongalaxy.entities.TP;
import neutrongalaxy.masterj.neutrongalaxy.events.ClientEvents;

import java.util.Objects;
import java.util.function.Supplier;

public class RequestDestPlanetS2CPacket {
    public RequestDestPlanetS2CPacket() {

    }

    public RequestDestPlanetS2CPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            // Here we are on the client
            Minecraft.getInstance().setScreen(new SpaceScreen());
        });
        return true;
    }
}
