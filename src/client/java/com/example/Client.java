package com.example;

import com.example.modules.Mod;
import com.example.modules.ModuleManager;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

public class Client implements ClientModInitializer {

    public static final Client INSTANCE = new Client();
    public Logger logger = LogManager.getLogger(Client.class);

    // Use method to access MinecraftClient instance to avoid preview features
    private MinecraftClient getMinecraftClient() {
        return MinecraftClient.getInstance();
    }

    @Override
    public void onInitializeClient() {
    }

    public void onKeyPress(int key, int action) {
        if (action == GLFW.GLFW_PRESS) {
            for (Mod module : ModuleManager.INSTANCE.getModules()) {
                if (key == module.getKey()) module.toggle();
            }
        }
    }

    public void onTick() {
        if (getMinecraftClient().player != null) {
            for (Mod module : ModuleManager.INSTANCE.getEnabledModules()) {
                module.onTick();
            }
        }
    }
}