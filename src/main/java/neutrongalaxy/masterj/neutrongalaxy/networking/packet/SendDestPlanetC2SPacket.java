package neutrongalaxy.masterj.neutrongalaxy.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
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
import neutrongalaxy.masterj.neutrongalaxy.init.DimensionInit;

import java.awt.*;
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
            ResourceKey<Level> planet = ServerLevel.OVERWORLD;

            if (player.getRootVehicle() instanceof RocketEntity) {
                if (player.getRootVehicle().getY() >= 151) {
                    switch (SpaceScreen.destPlanet) {
                        case "moon":
                            planet = DimensionInit.NG_MOON;
                            break;
                        case "mercury":
                            planet = DimensionInit.NG_MERCURY;
                            break;
                        case "venus":
                            planet = DimensionInit.NG_VENUS;
                            break;
                        case "mars":
                            planet = DimensionInit.NG_MARS;
                            break;
                        case "jupiter":
                            planet = DimensionInit.NG_JUPITER;
                            break;
                        case "saturn":
                            planet = DimensionInit.NG_SATURN;
                            break;
                        case "uranus":
                            planet = DimensionInit.NG_URANUS;
                            break;
                        case "neptune":
                            planet = DimensionInit.NG_NEPTUNE;
                            break;
                        default:
                            planet = ServerLevel.OVERWORLD;
                            break;
                    }
                    player.getRootVehicle().changeDimension(Objects.requireNonNull(Objects.requireNonNull(player.getServer()).getLevel(planet)), new TP());
                    player.changeDimension(Objects.requireNonNull(player.getServer().getLevel(planet)), new TP());
                    // check what dimension the player is already in, don't let it move to the dimension it is already in.
                    // This is to stop the player from falling to their death when changing dimension. Possibly going to be replaced by a parachute armour piece.
                    // May need to increase or decrease 2nd int for MobEffectInstance depending on the height above the planet the rocket is so slow falling stops them from dying.
                    if (!player.isOnGround()) {
                        player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 310, 10));
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
