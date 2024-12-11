package com.example.modules.render;

import com.example.modules.Module;
import org.lwjgl.glfw.GLFW;
import com.example.modules.ui.screens.ClickGui;
import net.minecraft.text.Text;

public class ClickGUI extends Module {

    public ClickGUI() {
        super("ClickGUI", "Clicks the GUI", Category.RENDER);
        this.setKey(GLFW.GLFW_KEY_RIGHT_SHIFT);
    }

    @Override
    public void onEnable() {
        if (mc.currentScreen == null) {
            mc.setScreen(new ClickGui(Text.literal("ClickGUI")));
        }
    }

    @Override
    public void onDisable() {
        // Potential cleanup logic if needed in the future
    }
}