package com.example.modules.Movement;

import com.example.modules.Mod;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.PlayerEntity;
import org.lwjgl.glfw.GLFW;

public class Eagle extends Mod {

    public Eagle() {
        super("Eagle", "Sneaks on the edges of blocks.", Category.MOVEMENT);
        this.setKey(GLFW.GLFW_KEY_V);
    }
    @Override
    public void onTick() {
        BlockPos playerPos = mc.player.getBlockPos();
        BlockPos blockPelowPos = playerPos.down();
        BlockState blockState = mc.world.getBlockState(blockPelowPos);
        if (blockState.isAir()) {
            mc.player.setSneaking(true);
        } else {
            mc.player.setSneaking(false);
        }
    }

    @Override
    public void onDisable() {
        mc.player.setSneaking(false);
    }
}
