package com.example.modules.Movement;

import com.example.modules.Mod;
import org.lwjgl.glfw.GLFW;

public class Flight extends Mod {

    public Flight() {
        super("Flight", "Allows you to fly", Category.MOVEMENT);
        this.setKey(GLFW.GLFW_KEY_RIGHT_SHIFT);
    }
    @Override
    public void onTick() {
    }

    @Override
    public void onDisable() {
    }
}
