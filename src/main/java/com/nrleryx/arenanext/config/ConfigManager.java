package com.nrleryx.arenanext.config;

import com.nrleryx.arenanext.ArenaNextPlugin;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {

    private final ArenaNextPlugin plugin;
    private FileConfiguration config;

    public ConfigManager(ArenaNextPlugin plugin) {
        this.plugin = plugin;
        reload();
    }

    public void reload() {
        plugin.saveDefaultConfig();
        plugin.reloadConfig();
        this.config = plugin.getConfig();
    }

    public FileConfiguration getRaw() {
        return config;
    }

    public boolean isUseMySQL() {
        return config.getBoolean("settings.use-mysql", false);
    }

    public String getMySQLHost() {
        return config.getString("mysql.host", "localhost");
    }

    public int getMySQLPort() {
        return config.getInt("mysql.port", 3306);
    }

    public String getMySQLDatabase() {
        return config.getString("mysql.database", "arenanext");
    }

    public String getMySQLUsername() {
        return config.getString("mysql.username", "root");
    }

    public String getMySQLPassword() {
        return config.getString("mysql.password", "password");
    }

    public int getDefaultCountdown() {
        return config.getInt("arena.default-countdown", 10);
    }

    public int getMinPlayers() {
        return config.getInt("arena.min-players", 2);
    }

    public int getMaxPlayers() {
        return config.getInt("arena.max-players", 16);
    }

    public boolean isSpectatorEnabled() {
        return config.getBoolean("arena.spectator-enabled", true);
    }
}

