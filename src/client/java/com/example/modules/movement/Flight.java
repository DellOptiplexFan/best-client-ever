package com.example.modules.movement;

import com.example.modules.Module;
import org.lwjgl.glfw.GLFW;

public class    Flight extends Module {

    public Flight() {
        super("Flight", "Allows you to fly", Category.MOVEMENT);
        this.setKey(GLFW.GLFW_KEY_F);
    }
    @Override
    public void onTick() {
    }

    @Override
    public void onDisable() {
    }
}
