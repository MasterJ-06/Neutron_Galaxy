package neutrongalaxy.masterj.neutrongalaxy.networking.packet;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkEvent;
import neutrongalaxy.masterj.neutrongalaxy.client.gui.screens.SpaceScreen;
import neutrongalaxy.masterj.neutrongalaxy.sounds.ModSounds;

import java.util.function.Supplier;

public class RequestDestPlanetS2CPacket {
    public RequestDestPlanetS2CPacket() {

    }

    public RequestDestPlanetS2CPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

//    @OnlyIn(Dist.CLIENT)
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            // Here we are on the client
            client_stuff();
        });
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    private void client_stuff() {
        assert Minecraft.getInstance().player != null;
        if (!(Minecraft.getInstance().screen instanceof SpaceScreen)) {
            Minecraft.getInstance().player.playSound(ModSounds.SPACE_MUSIC.get(), 0.5f, 1f);
            Minecraft.getInstance().setScreen(new SpaceScreen());
        }
    }
}
