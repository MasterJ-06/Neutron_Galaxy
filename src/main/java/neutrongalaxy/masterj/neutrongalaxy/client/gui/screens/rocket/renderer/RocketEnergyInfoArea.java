package neutrongalaxy.masterj.neutrongalaxy.client.gui.screens.rocket.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.Rect2i;
import net.minecraft.network.chat.Component;
import net.minecraftforge.energy.IEnergyStorage;

import java.util.List;

/*
 *  BluSunrize
 *  Copyright (c) 2021
 *
 *  This code is licensed under "Blu's License of Common Sense"
 *  Details can be found in the license file in the root folder of this project
 */
public class RocketEnergyInfoArea extends InfoArea {
    private int energy;
    private int MAXENERGY;

    public RocketEnergyInfoArea(int xMin, int yMin, int MAXENERGY)  {
        this(xMin, yMin, 0,8,64, MAXENERGY);
    }

    public RocketEnergyInfoArea(int xMin, int yMin, int energy, int MAXENERGY)  {
        this(xMin, yMin, energy,8,64, MAXENERGY);
    }

    public RocketEnergyInfoArea(int xMin, int yMin, int energy, int width, int height, int MAXENERGY)  {
        super(new Rect2i(xMin, yMin, width, height));
        this.energy = energy;
        this.MAXENERGY = MAXENERGY;
    }

    public List<Component> getTooltips() {
        return List.of(Component.literal(energy+"/"+MAXENERGY+" FE"));
    }

    @Override
    public void draw(PoseStack transform) {
        final int height = area.getHeight();
        int stored = (int)(height*(energy/(float)MAXENERGY));
        //System.out.println(stored);
        fillGradient(
                transform,
                area.getX(), area.getY()+(height-stored),
                area.getX() + area.getWidth(), area.getY() +area.getHeight(),
                0xffb51500, 0xff600b00
        );
    }
}