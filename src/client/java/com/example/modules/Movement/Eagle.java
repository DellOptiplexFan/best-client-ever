package com.example.modules.Movement;

import com.example.modules.Mod;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.glfw.GLFW;

public class Eagle extends Mod {

    public Eagle() {
        super("Eagle", "Sneaks on the edges of blocks.", Category.MOVEMENT);
        this.setKey(GLFW.GLFW_KEY_V); 
    }

    @Override
    public void onTick() {
        if (mc.player == null || mc.world == null) {
            return; // exit dis bih
        }

        BlockPos playerPos = mc.player.getBlockPos();
        BlockPos blockBelowPos = playerPos.down();

        BlockState blockStateBelow = mc.world.getBlockState(blockBelowPos);

        boolean shouldSneak = blockStateBelow.isAir();

        if (mc.player.isSneaking() != shouldSneak) {
            mc.player.setSneaking(shouldSneak);
        }
    }

    @Override
    public void onDisable() {
        mc.player.setSneaking(false);
    }
}
