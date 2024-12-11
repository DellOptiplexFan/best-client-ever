package com.example.modules.movement;

import com.example.modules.Module;

import net.minecraft.block.BlockState;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.glfw.GLFW;

public class Safewalk extends Module {

    public Safewalk() {
        super("Eagle", "Sneaks on the edges of blocks.", Category.MOVEMENT);
        this.setKey(GLFW.GLFW_KEY_V); 
    }

    @Override
    public void onTick() {
        if (mc.player == null || mc.world == null) {
            return; // exit dis bih
        }

        KeyBinding sneakKey = mc.options.sneakKey;

        BlockPos playerPos = mc.player.getBlockPos();
        BlockState blockStateBelow = mc.world.getBlockState(playerPos.down());

        if (blockStateBelow.isAir()) {
            KeyBinding.setKeyPressed(sneakKey.getDefaultKey(), true);
        }
        else {
            KeyBinding.setKeyPressed(sneakKey.getDefaultKey(), false);
        }
    }

    @Override
    public void onDisable() {
        KeyBinding sneakKey1 = mc.options.sneakKey;
        KeyBinding.setKeyPressed(sneakKey1.getDefaultKey(), false);
    }
}
