package com.example.modules;

import com.example.utils.MCInst;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j @Data @NoArgsConstructor
public class Module implements MCInst {
    private String name;
    private String description;
    private Category category;
    private int key = 0;
    private boolean enabled = false;

    public Module(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public void toggle() {
        setEnabled(!enabled);
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;

        if (enabled) {
            onEnable();
            log.info("{} has been enabled.", name);
        } else {
            onDisable();
            log.info("{} has been disabled.", name);
        }
    }

    public void onEnable() {}
    public void onDisable() {}
    public void onTick() {}

    public enum Category {
        COMBAT,
        MOVEMENT,
        RENDER,
        WORLD,
        MISC,
        EXPLOITS
    }
}
