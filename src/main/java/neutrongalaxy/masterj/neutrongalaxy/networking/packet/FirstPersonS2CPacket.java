package neutrongalaxy.masterj.neutrongalaxy.networking.packet;

import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkEvent;
import neutrongalaxy.masterj.neutrongalaxy.entities.RocketEntity;

import java.util.function.Supplier;

public class FirstPersonS2CPacket {
    public FirstPersonS2CPacket() {

    }

    public FirstPersonS2CPacket(FriendlyByteBuf buf) {

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
        Minecraft.getInstance().options.setCameraType(CameraType.FIRST_PERSON);
    }
}
