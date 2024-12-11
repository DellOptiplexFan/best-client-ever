package com.example.mixin.client;

import com.example.modules.Module;
import com.example.modules.ModuleManager;
import com.example.utils.MCInst;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin implements MCInst {

    @Inject(method = "tick", at = @At("HEAD"))
    public void onTick(CallbackInfo ci) {
        // use eventbus whenever u impl plssz
        if (mc.player != null) {
            ModuleManager.INSTANCE.getEnabledModules().forEach(Module::onTick);
        }
    }
}
