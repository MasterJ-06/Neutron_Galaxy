package neutrongalaxy.masterj.neutrongalaxy.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY = "key.category.masterj.neutrongalaxy";
    public static final String KEY_LAUNCH_ROCKET = "key.neutrongalaxy.launch_rocket";

    public  static final KeyMapping LAUNCH_KEY = new KeyMapping(KEY_LAUNCH_ROCKET, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_SPACE, KEY_CATEGORY);
}
