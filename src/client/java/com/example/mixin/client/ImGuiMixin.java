package com.example.mixin.client;

import com.example.screen.imgui.ImGuiImpl;
import imgui.ImGui;
import net.minecraft.client.util.Window;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ImGui.class)
public class ImGuiMixin {
    @Final
    private Window window;

    public void initImGui(CallbackInfo ci) {
        if (window != null && window.getHandle() != 0) {
            ImGuiImpl.create(window.getHandle());
        }
    }

    public void closeImGui(CallbackInfo ci) {
        ImGuiImpl.dispose();
    }
}