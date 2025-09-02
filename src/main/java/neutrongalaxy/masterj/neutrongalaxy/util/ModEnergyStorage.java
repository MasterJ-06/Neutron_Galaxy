package neutrongalaxy.masterj.neutrongalaxy.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.energy.EnergyStorage;

public abstract class ModEnergyStorage extends EnergyStorage {
    //only way to get pos for entities consider making new energy storage constructor or class for other things that need energy
    public int pos;
    public boolean receiving = false;
    public ModEnergyStorage(int capacity, int maxTransfer, int pos) {
        super(capacity, maxTransfer);
        this.pos = pos;
    }

    @Override
    public int extractEnergy(final int maxExtract, final boolean simulate) {
        int extractedEnergy = super.extractEnergy(maxExtract, simulate);
        receiving = false;
        if(extractedEnergy != 0) {
            onEnergyChanged();
        }

        return extractedEnergy;
    }

    @Override
    public int receiveEnergy(final int maxReceive, final boolean simulate) {
        int receiveEnergy = super.receiveEnergy(maxReceive, simulate);
        receiving = true;
        if(receiveEnergy != 0) {
            onEnergyChanged();
        }

        return receiveEnergy;
    }

    public int setEnergy(int energy) {
        this.energy = energy;
        return energy;
    }

    public abstract void onEnergyChanged();
}
