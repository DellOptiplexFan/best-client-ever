package com.example.imguimc.theme;

import imgui.ImGui;
import com.example.imguimc.interfaces.Theme;

public class ImGuiLightTheme implements Theme {
    @Override
    public void preRender() {
        ImGui.styleColorsLight();
    }

    @Override
    public void postRender() {

    }
}
