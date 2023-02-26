package neutrongalaxy.masterj.neutrongalaxy.temp;

import net.minecraft.nbt.CompoundTag;

public class PlayerTemp {
    private int temp;
    private final int MIN_TEMP = 0;
    private final int MAX_TEMP = 10;

    public int getTemp() {
        return temp;
    }

    public void addTemp(int add) {
        this.temp = Math.min(temp + add, MAX_TEMP);
    }

    public void subTemp(int sub) {
        this.temp = Math.max(temp - sub, MIN_TEMP);
    }

    public void setTemp(int set) {
        this.temp = set;
    }

    public void copyFrom(PlayerTemp source) {
        this.temp = source.temp;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("thirst", temp);
    }

    public void loadNBTData(CompoundTag nbt) {
        temp = nbt.getInt("thirst");
    }
}
