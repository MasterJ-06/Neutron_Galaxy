package neutrongalaxy.masterj.neutrongalaxy.networking.packet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraftforge.network.NetworkEvent;
import neutrongalaxy.masterj.neutrongalaxy.client.gui.screens.SpaceScreen;
import neutrongalaxy.masterj.neutrongalaxy.events.ClientEvents;
import neutrongalaxy.masterj.neutrongalaxy.sounds.ModSounds;

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

            Minecraft.getInstance().player.playSound(ModSounds.SPACE_MUSIC.get(), 0.5f, 1f);
            Minecraft.getInstance().setScreen(new SpaceScreen());
        });
        return true;
    }
}
