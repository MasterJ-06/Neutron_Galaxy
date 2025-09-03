package neutrongalaxy.masterj.neutrongalaxy.networking.packet;

import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;
import neutrongalaxy.masterj.neutrongalaxy.entities.RocketEntity;
import neutrongalaxy.masterj.neutrongalaxy.entities.TP;
import neutrongalaxy.masterj.neutrongalaxy.init.DimensionInit;
import neutrongalaxy.masterj.neutrongalaxy.networking.ModPackets;
import neutrongalaxy.masterj.neutrongalaxy.temp.PlayerTempProvider;

import java.util.Objects;
import java.util.function.Supplier;

public class SendDestPlanetC2SPacket {
    String p = "";
    public SendDestPlanetC2SPacket(String x) {
        this.p = x;
    }

    public SendDestPlanetC2SPacket(FriendlyByteBuf buf) {
        this.p = buf.readUtf();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeUtf(p);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            // Here we are on the server
            ServerPlayer player = ctx.getSender();
            ServerLevel level = player.getLevel();
            int id;
            ResourceKey<Level> planet;

            planet = switch (this.p) {
                case "moon" -> DimensionInit.NG_MOON;
                case "mercury" -> DimensionInit.NG_MERCURY;
                case "venus" -> DimensionInit.NG_VENUS;
                case "mars" -> DimensionInit.NG_MARS;
                case "jupiter" -> DimensionInit.NG_JUPITER;
                case "saturn" -> DimensionInit.NG_SATURN;
                case "uranus" -> DimensionInit.NG_URANUS;
                case "neptune" -> DimensionInit.NG_NEPTUNE;
                default -> ServerLevel.OVERWORLD;
            };
            id = player.getRootVehicle().getId();
            int energy = 0;
            if (player.getRootVehicle() instanceof RocketEntity rocketEntity) {
                energy = rocketEntity.getServerEnergy();
            }
            player.getRootVehicle().changeDimension(Objects.requireNonNull(Objects.requireNonNull(player.getServer()).getLevel(planet)), new TP());
            if (planet == ServerLevel.OVERWORLD) {
                player.getCapability(PlayerTempProvider.PLAYER_TEMP).ifPresent(temp -> {
                    temp.setTemp(0);
//                    player.sendSystemMessage(Component.literal("Current Temp " + temp.getTemp()).withStyle(ChatFormatting.AQUA));
                    ModPackets.sendToPlayer(new TempDataSyncS2CPacket(temp.getTemp()), player);
                });
            } else if (planet == DimensionInit.NG_MOON) {
                player.getCapability(PlayerTempProvider.PLAYER_TEMP).ifPresent(temp -> {
                    temp.setTemp(0);
//                    player.sendSystemMessage(Component.literal("Current Temp " + temp.getTemp()).withStyle(ChatFormatting.AQUA));
                    ModPackets.sendToPlayer(new TempDataSyncS2CPacket(temp.getTemp()), player);
                });
            } else if (planet == DimensionInit.NG_MERCURY || planet == DimensionInit.NG_VENUS || planet == DimensionInit.NG_MARS || planet == DimensionInit.NG_JUPITER) {
                player.getCapability(PlayerTempProvider.PLAYER_TEMP).ifPresent(temp -> {
                    temp.setTemp(1);
//                    player.sendSystemMessage(Component.literal("Current Temp " + temp.getTemp()).withStyle(ChatFormatting.AQUA));
                    player.sendSystemMessage(Component.literal("You will need thermal armour to go to any other planet other than the overworld or the moon.").withStyle(ChatFormatting.AQUA));
                    ModPackets.sendToPlayer(new TempDataSyncS2CPacket(temp.getTemp()), player);
                });
            }
            else if (planet == DimensionInit.NG_SATURN || planet == DimensionInit.NG_URANUS || planet == DimensionInit.NG_NEPTUNE) {
                player.getCapability(PlayerTempProvider.PLAYER_TEMP).ifPresent(temp -> {
                    temp.setTemp(2);
//                    player.sendSystemMessage(Component.literal("Current Temp " + temp.getTemp()).withStyle(ChatFormatting.AQUA));
                    player.sendSystemMessage(Component.literal("You will need thermal armour to go to any other planet other than the overworld or the moon.").withStyle(ChatFormatting.AQUA));
                    ModPackets.sendToPlayer(new TempDataSyncS2CPacket(temp.getTemp()), player);
                });
            }
            player.changeDimension(Objects.requireNonNull(player.getServer().getLevel(planet)), new TP());
            // check what dimension the player is already in, don't let it move to the dimension it is already in.
            // This is to stop the player from falling to their death when changing dimension. Possibly going to be replaced by a parachute armour piece.
            // May need to increase or decrease 2nd int for MobEffectInstance depending on the height above the planet the rocket is so slow falling stops them from dying.
            if (!player.isOnGround()) {
                player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 310, 10));
            }
        });
        return true;
    }
}
