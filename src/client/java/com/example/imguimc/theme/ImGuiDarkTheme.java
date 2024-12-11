package com.example.imguimc.theme;

import imgui.ImGui;
import com.example.imguimc.interfaces.Theme;

public class ImGuiDarkTheme implements Theme {
    @Override
    public void preRender() {
        ImGui.styleColorsDark();
    }

    @Override
    public void postRender() {

    }
}
