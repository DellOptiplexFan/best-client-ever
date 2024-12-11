package xyz.breadloaf.imguimc.mixin;

import imgui.ImGui;
import net.minecraft.client.KeyboardHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.breadloaf.imguimc.Imguimc;
import xyz.breadloaf.imguimc.imgui.ImguiLoader;

@Mixin(KeyboardHandler.class)
public class KeyboardHandlerMixin {

    @Inject(method = "setup", at = @At("TAIL"))
    public void setup(long l, CallbackInfo ci) {
        ImguiLoader.onGlfwInit(l);
    }

    @Inject(method = "keyPress", at = @At("HEAD"), cancellable = true)
    public void keyPress(long l, int i, int j, int k, int m, CallbackInfo ci) {
        if (Imguimc.shouldCancelGameKeyboardInputs())
            ci.cancel();
    }

    @Inject(method = "charTyped", at = @At("HEAD"), cancellable = true)
    public void charTyped(long l, int i, int j, CallbackInfo ci) {
        if (Imguimc.shouldCancelGameKeyboardInputs())
            ci.cancel();
    }
}
