package com.nrleryx.arenanext;

import com.nrleryx.arenanext.config.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ArenaNextPlugin extends JavaPlugin {

    private static ArenaNextPlugin instance;
    private ConfigManager configManager;

    @Override
    public void onEnable() {
        instance = this;
        configManager = new ConfigManager(this);
        getLogger().info("ArenaNext has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("ArenaNext has been disabled!");
    }

    public static ArenaNextPlugin getInstance() {
        return instance;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
}

