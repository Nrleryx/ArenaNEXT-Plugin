package com.nrleryx.arenanext;

import com.nrleryx.arenanext.config.ConfigManager;
import com.nrleryx.arenanext.manager.ArenaManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ArenaNextPlugin extends JavaPlugin {

    private static ArenaNextPlugin instance;
    private ConfigManager configManager;
    private ArenaManager arenaManager;

    @Override
    public void onEnable() {
        instance = this;
        configManager = new ConfigManager(this);
        arenaManager = new ArenaManager();
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

    public ArenaManager getArenaManager() {
        return arenaManager;
    }
}

