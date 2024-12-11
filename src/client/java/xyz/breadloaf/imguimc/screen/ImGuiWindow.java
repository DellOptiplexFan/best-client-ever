package xyz.breadloaf.imguimc.screen;

import imgui.ImGui;
import imgui.type.ImBoolean;
import net.minecraft.network.chat.Component;
import xyz.breadloaf.imguimc.Imguimc;
import xyz.breadloaf.imguimc.interfaces.Renderable;
import xyz.breadloaf.imguimc.interfaces.Theme;

public class ImGuiWindow implements Renderable {
    Theme theme;

    Component name;

    WindowRenderer renderer;

    public boolean canClose;

    ImBoolean open;

    public ImGuiWindow(Theme theme, Component name, WindowRenderer renderer, boolean canClose) {
        this.theme = theme;
        this.name = name;
        this.renderer = renderer;
        this.canClose = canClose;
        this.open = new ImBoolean(true);
    }

    @Override
    public String getName() {
        return this.name.tryCollapseToString();
    }

    @Override
    public Theme getTheme() {
        return this.theme;
    }

    @Override
    public void render() {
        if (!open.get()) {
            Imguimc.pullRenderableAfterRender(this);
            return;
        }

        if (canClose) {
            ImGui.begin(getName(), open);
        } else {
            ImGui.begin(getName());
        }

        renderer.renderWindow();

        ImGui.end();
    }
}
