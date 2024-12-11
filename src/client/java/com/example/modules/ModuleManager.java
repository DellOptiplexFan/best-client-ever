package com.example.modules;

import com.example.modules.movement.Safewalk;
import com.example.modules.movement.Flight;
import com.example.modules.movement.Sprint;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ModuleManager {
    public static final ModuleManager INSTANCE = new ModuleManager();
    private final List<Module> modules = Collections.synchronizedList(new ArrayList<>());

    static {
        INSTANCE.addModules();
    }

    public List<Module> getEnabledModules() {
        synchronized (modules) {
            return modules.stream()
                    .filter(Module::isEnabled)
                    .collect(Collectors.toList());
        }
    }

    private void addModules() {
        modules.add(new Flight());
        modules.add(new Sprint());
        modules.add(new Safewalk());
    }
}