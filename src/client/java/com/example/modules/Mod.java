package com.example.modules;

import net.minecraft.client.MinecraftClient;

public class Mod {

    private String name;
    private String description;
    public Category category;
    private int key;
    private boolean enabled;

    protected MinecraftClient mc = MinecraftClient.getInstance();

    public Mod(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.key = 0;
        this.enabled = false;
    }

    public void toggle() {
        this.enabled = !this.enabled;

        if (enabled) onEnable();
        else onDisable();
    }

    public void onEnable() {

    }

    public void onDisable() {

    }

    public void onTick() {

    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;

        if (enabled) onEnable();
        else onDisable();

        if (enabled) {
            System.out.println(this.name + " has been enabled.");
            onEnable();
        } else {
            System.out.println(this.name + " has been disabled.");
            onDisable();
        }
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public enum Category {
        COMBAT,
        MOVEMENT,
        RENDER,
        WORLD,
        MISC,
        EXPLOITS
    }
}

