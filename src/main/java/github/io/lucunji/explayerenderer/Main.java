package github.io.lucunji.explayerenderer;

import fi.dy.masa.malilib.config.ConfigManager;
import github.io.lucunji.explayerenderer.config.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.keybinding.FabricKeyBinding;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.fabricmc.fabric.impl.client.keybinding.KeyBindingRegistryImpl;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public class Main implements ModInitializer{

    public static final String MOD_ID = "explayerenderer";

    protected static final KeyBinding MASTER_CONTROL = new KeyBinding(
            "master_control",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_F8,
            "key.categories.ui"
    );

    @Override
    public void onInitialize(){
        ConfigManager.getInstance().registerConfigHandler(MOD_ID, new ConfigHandler());
        new Configs();
        ConfigHandler.loadFile();
        KeyBindingHelper.registerKeyBinding(MASTER_CONTROL);
        ClientTickCallback.EVENT.register(new KeyBindHandler());
    }
}
