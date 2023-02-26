package neutrongalaxy.masterj.neutrongalaxy.networking;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import neutrongalaxy.masterj.neutrongalaxy.NeutronGalaxy;
import neutrongalaxy.masterj.neutrongalaxy.networking.packet.*;

public class ModPackets {
    private static SimpleChannel INSTANCE;

    private static int packetId = 0;

    private static  int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(NeutronGalaxy.MODID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();
        INSTANCE = net;
        net.messageBuilder(MoveRocketC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER).decoder(MoveRocketC2SPacket::new).encoder(MoveRocketC2SPacket::toBytes)
                .consumerMainThread(MoveRocketC2SPacket::handle).add();
        net.messageBuilder(RequestDestPlanetS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT).decoder(RequestDestPlanetS2CPacket::new).encoder(RequestDestPlanetS2CPacket::toBytes)
                .consumerMainThread(RequestDestPlanetS2CPacket::handle).add();
        net.messageBuilder(SendDestPlanetC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER).decoder(SendDestPlanetC2SPacket::new).encoder(SendDestPlanetC2SPacket::toBytes)
                .consumerMainThread(SendDestPlanetC2SPacket::handle).add();
        net.messageBuilder(TempDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT).decoder(TempDataSyncS2CPacket::new).encoder(TempDataSyncS2CPacket::toBytes)
                .consumerMainThread(TempDataSyncS2CPacket::handle).add();
        net.messageBuilder(RocketMsgC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER).decoder(RocketMsgC2SPacket::new).encoder(RocketMsgC2SPacket::toBytes)
                .consumerMainThread(RocketMsgC2SPacket::handle).add();
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}
