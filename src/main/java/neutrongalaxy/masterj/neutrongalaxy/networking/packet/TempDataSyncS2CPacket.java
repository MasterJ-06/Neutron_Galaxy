package neutrongalaxy.masterj.neutrongalaxy.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import neutrongalaxy.masterj.neutrongalaxy.client.ClientTempData;

import java.util.function.Supplier;

public class TempDataSyncS2CPacket {

    private final int temp;

    public TempDataSyncS2CPacket(int thirst) {
        this.temp = thirst;
    }

    public TempDataSyncS2CPacket(FriendlyByteBuf buf) {
        this.temp = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(temp);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE CLIENT!
            ClientTempData.set(temp);
        });
        return true;
    }
}
