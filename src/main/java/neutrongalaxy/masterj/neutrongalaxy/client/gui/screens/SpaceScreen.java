package neutrongalaxy.masterj.neutrongalaxy.client.gui.screens;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.GameNarrator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.protocol.game.ServerboundSeenAdvancementsPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import neutrongalaxy.masterj.neutrongalaxy.NeutronGalaxy;
import neutrongalaxy.masterj.neutrongalaxy.networking.ModPackets;
import neutrongalaxy.masterj.neutrongalaxy.networking.packet.SendDestPlanetC2SPacket;
import neutrongalaxy.masterj.neutrongalaxy.util.KeyBinding;

import javax.annotation.Nullable;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class SpaceScreen extends Screen {
    private int delayTicker;
    private final List<ImageButton> exitButtons = Lists.newArrayList();
    public static String destPlanet = "";

    public SpaceScreen() {
        super(GameNarrator.NO_TITLE);
    }

    protected void init() {
        this.delayTicker = 0;
        this.exitButtons.clear();
        this.exitButtons.add(this.addRenderableWidget(new ImageButton(-40, 80, 75, 75, 0, 0, 0, new ResourceLocation(NeutronGalaxy.MODID, "textures/gui/sun.png"), 75, 75, (p_95930_) -> {
            this.minecraft.setScreen(null);
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("Sun"));
            this.destPlanet = "sun";
            Minecraft.getInstance().getSoundManager().stop();
            ModPackets.sendToServer(new SendDestPlanetC2SPacket(SpaceScreen.destPlanet));
        }, Component.translatable("neutrongalaxy.space.button.sun"))));
        this.exitButtons.add(this.addRenderableWidget(new ImageButton(40, 90, 20, 20, 0, 0, 0, new ResourceLocation(NeutronGalaxy.MODID, "textures/gui/mercury.png"), 20, 20, (p_95930_) -> {
            this.minecraft.setScreen(null);
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("Mercury"));
            this.destPlanet = "mercury";
            Minecraft.getInstance().getSoundManager().stop();
            ModPackets.sendToServer(new SendDestPlanetC2SPacket(SpaceScreen.destPlanet));
        }, Component.translatable("neutrongalaxy.space.button.mercury"))));
        this.exitButtons.add(this.addRenderableWidget(new ImageButton(60, 110, 30, 30, 0, 0, 0, new ResourceLocation(NeutronGalaxy.MODID, "textures/gui/venus.png"), 30, 30, (p_95930_) -> {
            this.minecraft.setScreen(null);
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("Venus"));
            this.destPlanet = "venus";
            Minecraft.getInstance().getSoundManager().stop();
            ModPackets.sendToServer(new SendDestPlanetC2SPacket(SpaceScreen.destPlanet));
        }, Component.translatable("neutrongalaxy.space.button.venus"))));
        this.exitButtons.add(this.addRenderableWidget(new ImageButton(100, 90, 30, 30, 0, 0, 0, new ResourceLocation(NeutronGalaxy.MODID, "textures/gui/earth.png"), 30, 30, (p_95930_) -> {
            this.minecraft.setScreen(null);
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("Earth"));
            this.destPlanet = "earth";
            Minecraft.getInstance().getSoundManager().stop();
            ModPackets.sendToServer(new SendDestPlanetC2SPacket(SpaceScreen.destPlanet));
        }, Component.translatable("neutrongalaxy.space.button.earth"))));
        this.exitButtons.add(this.addRenderableWidget(new ImageButton(140, 110, 25, 25, 0, 0, 0, new ResourceLocation(NeutronGalaxy.MODID, "textures/gui/mars.png"), 25, 25, (p_95930_) -> {
            this.minecraft.setScreen(null);
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("Mars"));
            this.destPlanet = "mars";
            Minecraft.getInstance().getSoundManager().stop();
            ModPackets.sendToServer(new SendDestPlanetC2SPacket(SpaceScreen.destPlanet));
        }, Component.translatable("neutrongalaxy.space.button.mars"))));
        this.exitButtons.add(this.addRenderableWidget(new ImageButton(190, 80, 60, 60, 0, 0, 0, new ResourceLocation(NeutronGalaxy.MODID, "textures/gui/jupiter.png"), 60, 60, (p_95930_) -> {
            this.minecraft.setScreen(null);
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("Jupiter"));
            this.destPlanet = "jupiter";
            Minecraft.getInstance().getSoundManager().stop();
            ModPackets.sendToServer(new SendDestPlanetC2SPacket(SpaceScreen.destPlanet));
        }, Component.translatable("neutrongalaxy.space.button.jupiter"))));
        this.exitButtons.add(this.addRenderableWidget(new ImageButton(245, 110, 95, 49, 0, 0, 0, new ResourceLocation(NeutronGalaxy.MODID, "textures/gui/saturn.png"), 95, 49, (p_95930_) -> {
            this.minecraft.setScreen(null);
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("Saturn"));
            this.destPlanet = "saturn";
            Minecraft.getInstance().getSoundManager().stop();
            ModPackets.sendToServer(new SendDestPlanetC2SPacket(SpaceScreen.destPlanet));
        }, Component.translatable("neutrongalaxy.space.button.saturn"))));
        this.exitButtons.add(this.addRenderableWidget(new ImageButton(320, 80, 40, 40, 0, 0, 0, new ResourceLocation(NeutronGalaxy.MODID, "textures/gui/neptune.png"), 40, 40, (p_95930_) -> {
            this.minecraft.setScreen(null);
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("Neptune"));
            this.destPlanet = "neptune";
            Minecraft.getInstance().getSoundManager().stop();
            ModPackets.sendToServer(new SendDestPlanetC2SPacket(SpaceScreen.destPlanet));
        }, Component.translatable("neutrongalaxy.space.button.neptune"))));
        this.exitButtons.add(this.addRenderableWidget(new ImageButton(370, 110, 40, 40, 0, 0, 0, new ResourceLocation(NeutronGalaxy.MODID, "textures/gui/uranus.png"), 40, 40, (p_95930_) -> {
            this.minecraft.setScreen(null);
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("Uranus"));
            this.destPlanet = "uranus";
            Minecraft.getInstance().getSoundManager().stop();
            ModPackets.sendToServer(new SendDestPlanetC2SPacket(SpaceScreen.destPlanet));
        }, Component.translatable("neutrongalaxy.space.button.uranus"))));
        this.exitButtons.add(this.addRenderableWidget(new ImageButton(125, 75, 15, 15, 0, 0, 0, new ResourceLocation(NeutronGalaxy.MODID, "textures/gui/moon.png"), 15, 15, (p_95930_) -> {
            this.minecraft.setScreen(null);
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("Moon"));
            this.destPlanet = "moon";
            Minecraft.getInstance().getSoundManager().stop();
            ModPackets.sendToServer(new SendDestPlanetC2SPacket(SpaceScreen.destPlanet));
        }, Component.translatable("neutrongalaxy.space.button.moon"))));
        for(Button button : this.exitButtons) {
            button.active = false;
        }
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }
    public boolean isPauseScreen() {
        return false;
    }

    public void removed() {
        ClientPacketListener clientpacketlistener = this.minecraft.getConnection();
        if (clientpacketlistener != null) {
            clientpacketlistener.send(ServerboundSeenAdvancementsPacket.closedScreen());
        }

    }

    public boolean mouseClicked(double p_95914_, double p_95915_, int p_95916_) {
        Style style = this.getClickedComponentStyleAt((int)p_95914_);
        if (style != null && style.getClickEvent() != null && style.getClickEvent().getAction() == ClickEvent.Action.OPEN_URL) {
            this.handleComponentClicked(style);
            return false;
        }

        return super.mouseClicked(p_95914_, p_95915_, p_95916_);
    }

    public void render(PoseStack poseStack, int p_95921_, int p_95922_, float p_95923_) {
        RenderSystem.setShaderTexture(0, new ResourceLocation(NeutronGalaxy.MODID, "textures/gui/space_backgroundlarge.jpg"));
        GuiComponent.blit(poseStack, 0, 0,0,0, this.width, this.height,480,270);
        GuiComponent.drawCenteredString(poseStack, this.font, Component.literal("Pick a planet."), this.width / 2 / 2, 15, 16777215);

        super.render(poseStack, p_95921_, p_95922_, p_95923_);
    }

    @Nullable
    private Style getClickedComponentStyleAt(int p_95918_) {
        if (Component.literal("nothing") == null) {
            return null;
        } else {
            int i = this.minecraft.font.width(Component.literal("nothing"));
            int j = this.width / 2 - i / 2;
            int k = this.width / 2 + i / 2;
            return p_95918_ >= k && p_95918_ <= i ? this.minecraft.font.getSplitter().componentStyleAtWidth(Component.literal("nothing"), p_95918_ - j) : null;
        }
    }

    public void tick() {
        super.tick();
        ++this.delayTicker;
        if (this.delayTicker == 1) {
            for(Button button : this.exitButtons) {
                button.active = true;
            }
        }

    }
}
