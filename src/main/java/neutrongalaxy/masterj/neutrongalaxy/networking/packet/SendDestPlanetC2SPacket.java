package neutrongalaxy.masterj.neutrongalaxy.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;
import neutrongalaxy.masterj.neutrongalaxy.client.gui.screens.SpaceScreen;
import neutrongalaxy.masterj.neutrongalaxy.entities.RocketEntity;
import neutrongalaxy.masterj.neutrongalaxy.entities.TP;
import neutrongalaxy.masterj.neutrongalaxy.events.ClientEvents;

import java.util.Objects;
import java.util.function.Supplier;

public class SendDestPlanetC2SPacket {
    public SendDestPlanetC2SPacket() {

    }

    public SendDestPlanetC2SPacket(FriendlyByteBuf buf) {

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
                if (player.getRootVehicle().getY() >= 151) {
                    player.sendSystemMessage(Component.literal(SpaceScreen.destPlanet));
                    player.getRootVehicle().changeDimension(Objects.requireNonNull(Objects.requireNonNull(player.getServer()).getLevel(Level.NETHER)), new TP());
                    player.changeDimension(Objects.requireNonNull(player.getServer().getLevel(Level.NETHER)), new TP());

                    // This is to stop the player from falling to their death when changing dimensions. Possibly going to be replaced by a parachute armour piece.
                    // May need to increase or decrease 2nd int for MobEffectInstance depending on the height above the planet the rocket is so slow falling stops them from dying.
                    if (!player.isOnGround()) {
                        player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 250, 10));
                    }
                    ClientEvents.launch = false;
                }
            } else {
                ClientEvents.launch = false;
            }
        });
        return true;
    }
}
