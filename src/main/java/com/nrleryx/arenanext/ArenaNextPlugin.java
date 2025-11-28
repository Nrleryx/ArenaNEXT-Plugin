package com.nrleryx.arenanext;

import org.bukkit.plugin.java.JavaPlugin;

public final class ArenaNextPlugin extends JavaPlugin {

    private static ArenaNextPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getLogger().info("ArenaNext has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("ArenaNext has been disabled!");
    }

    public static ArenaNextPlugin getInstance() {
        return instance;
    }
}

