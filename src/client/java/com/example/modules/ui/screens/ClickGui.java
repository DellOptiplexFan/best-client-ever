package com.example.modules.ui.screens;

import com.example.modules.Module;
import com.example.screen.imgui.ImGuiImpl;
import imgui.ImGui;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import static com.example.utils.MCInst.mc;

public class ClickGui extends Screen {
    private static boolean isInitialized = false;

    public ClickGui(Text title) {
        super(title);

        if (!isInitialized) {
            ImGuiImpl.create(mc.getWindow().getHandle());
            isInitialized = true;
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);

        ImGuiImpl.draw((io) -> {
            ImGui.showDemoWindow(); // Render ImGui content
        });
    }

    public void onClose() {
        if (isInitialized) {
            ImGuiImpl.dispose();
            isInitialized = false;
        }
    }
}