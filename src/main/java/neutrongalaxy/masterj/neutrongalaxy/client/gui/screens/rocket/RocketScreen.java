package neutrongalaxy.masterj.neutrongalaxy.client.gui.screens.rocket;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import neutrongalaxy.masterj.neutrongalaxy.NeutronGalaxy;
import neutrongalaxy.masterj.neutrongalaxy.client.gui.screens.rocket.renderer.EnergyInfoArea;
import neutrongalaxy.masterj.neutrongalaxy.client.gui.screens.rocket.renderer.RocketEnergyInfoArea;
import neutrongalaxy.masterj.neutrongalaxy.util.MouseUtil;

import java.util.Optional;

import static com.ibm.icu.impl.ValidIdentifiers.Datatype.x;

@OnlyIn(Dist.CLIENT)
public class RocketScreen extends AbstractContainerScreen<RocketMenu> {
    private RocketEnergyInfoArea energyInfoArea;

    private void renderEnergyAreaTooltips(PoseStack pPoseStack, int pMouseX, int pMouseY, int x, int y) {
        if (isMouseAboveArea(pMouseX, pMouseY, x, y, 156, 13, 8, 64)) {
            renderTooltip(pPoseStack, energyInfoArea.getTooltips(),
                    Optional.empty(), pMouseX - x - 162, pMouseY - y);
        }
    }

    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, int width, int height) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, width, height);
    }

    private static final ResourceLocation BG = new ResourceLocation(NeutronGalaxy.MODID, "textures/gui/rocket_inv.png");

    public RocketScreen(RocketMenu menu, Inventory inv, Component title) {
        super(menu, inv, title);
    }

    @Override
    protected void renderBg(PoseStack pose, float partial, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, BG);
        int x1 = (width - imageWidth) / 2;
        int y1 = (height - imageHeight) / 2;

        this.blit(pose, x1 - 16, y1, 0, 0, imageWidth + 16, imageHeight);

        int energy = menu.rocket.getClientEnergy();
        int cap = Math.max(1, menu.rocket.getClientCapacity());
        int barHeight = 60; // pixels for bar
        int filled = (int) Math.round((energy / (double) cap) * barHeight);

        energyInfoArea = new RocketEnergyInfoArea(x1 - 7, y1 + 6, energy, cap);
        energyInfoArea.draw(pose);
    }

    @Override
    protected void renderLabels(PoseStack pose, int mouseX, int mouseY) {
        drawString(pose, this.font, this.title, 8, 6, 0xEEEEEE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        renderEnergyAreaTooltips(pose, mouseX, mouseY, x - 162, y - 6);
    }

    @Override
    public void render(PoseStack pose, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(pose);
        super.render(pose, mouseX, mouseY, partialTick);
        this.renderTooltip(pose, mouseX, mouseY);
    }
}