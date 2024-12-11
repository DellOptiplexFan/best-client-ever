package xyz.breadloaf.imguimc.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.util.profiling.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.breadloaf.imguimc.Imguimc;
import xyz.breadloaf.imguimc.imgui.ImguiLoader;

@Mixin(value = RenderSystem.class, remap = false)
public class TailRenderMixin {
    @Inject(at = @At("HEAD"), method="flipFrame")
    private static void runTickTail(CallbackInfo ci) {
        Profiler.get().push("ImGui Render");
        ImguiLoader.onFrameRender();
        Profiler.get().pop();
    }
}
