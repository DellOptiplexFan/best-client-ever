package com.example.modules;

import com.example.modules.Movement.Safewalk;
import com.example.modules.Movement.Flight;
import com.example.modules.Movement.Sprint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModuleManager {
    public static final ModuleManager INSTANCE = new ModuleManager();

    private static ModuleManager instance;

    private final List<Mod> modules = Collections.synchronizedList(new ArrayList<>());

    private ModuleManager() {
        addModules();
    }

    public static ModuleManager getInstance() {
        if (instance == null) {
            instance = new ModuleManager();
        }
        return instance;
    }

    public synchronized List<Mod> getModules() {
        return modules; // Returns a copy to prevent external modifications
    }

    public synchronized List<Mod> getEnabledModules() {
        List<Mod> enabled = new ArrayList<>();
        for (Mod module : modules) {
            if (module != null && module.isEnabled()) { // Null-safe check
                enabled.add(module);
            }
        }
        return enabled;
    }

    private void addModules() {
        modules.add(new Flight());
        modules.add(new Sprint());
        modules.add(new Safewalk());
    }
}