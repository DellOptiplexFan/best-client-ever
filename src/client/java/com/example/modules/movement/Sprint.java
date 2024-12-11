package com.example.modules.movement;

import com.example.modules.Module;
import org.lwjgl.glfw.GLFW;

public class Sprint extends Module {

    public Sprint() {
        super("Sprint", "Automatically sprints", Category.MOVEMENT);
        this.setKey(GLFW.GLFW_KEY_L); // dis better
    }

    @Override
    public void onTick() {
        if (mc.player.forwardSpeed > 0) {
            mc.player.setSprinting(true);
        }
    }
    @Override
    public void onDisable() {
        mc.player.setSprinting(false);
    }
}
