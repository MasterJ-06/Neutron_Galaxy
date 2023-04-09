package neutrongalaxy.masterj.neutrongalaxy.networking.packet;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkEvent;
import neutrongalaxy.masterj.neutrongalaxy.client.gui.screens.SpaceScreen;
import neutrongalaxy.masterj.neutrongalaxy.sounds.ModSounds;

import java.util.function.Supplier;

public class dispMsgS2CPacket {
    public dispMsgS2CPacket() {

    }

    public dispMsgS2CPacket(FriendlyByteBuf buf) {

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
        Minecraft.getInstance().player.sendSystemMessage(Component.literal("You will need thermal armour to go to any other planet other than the overworld or the moon.").withStyle(ChatFormatting.AQUA));
    }
}
