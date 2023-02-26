package neutrongalaxy.masterj.neutrongalaxy.temp;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class PlayerTempProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PlayerTemp> PLAYER_TEMP = CapabilityManager.get(new CapabilityToken<PlayerTemp>() {
    });

    private PlayerTemp temp = null;
    private final LazyOptional<PlayerTemp> optional = LazyOptional.of(this::createPlayerThirst);

    private PlayerTemp createPlayerThirst() {
        if (this.temp == null) {
            this.temp = new PlayerTemp();
        }

        return this.temp;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == PLAYER_TEMP) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerThirst().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerThirst().loadNBTData(nbt);
    }
}
