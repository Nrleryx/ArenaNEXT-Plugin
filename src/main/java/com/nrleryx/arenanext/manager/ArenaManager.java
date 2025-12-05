package com.nrleryx.arenanext.manager;

import com.nrleryx.arenanext.model.Arena;
import org.bukkit.entity.Player;

import java.util.*;

public class ArenaManager {

    private final Map<String, Arena> arenas;
    private final Map<UUID, String> playerArenas;

    public ArenaManager() {
        this.arenas = new HashMap<>();
        this.playerArenas = new HashMap<>();
    }

    public void registerArena(Arena arena) {
        arenas.put(arena.getId().toLowerCase(), arena);
    }

    public void unregisterArena(String id) {
        Arena arena = arenas.remove(id.toLowerCase());
        if (arena != null) {
            for (UUID uuid : new HashSet<>(arena.getPlayers())) {
                playerArenas.remove(uuid);
            }
            for (UUID uuid : new HashSet<>(arena.getSpectators())) {
                playerArenas.remove(uuid);
            }
        }
    }

    public Arena getArena(String id) {
        return arenas.get(id.toLowerCase());
    }

    public Arena getArenaByName(String name) {
        for (Arena arena : arenas.values()) {
            if (arena.getName().equalsIgnoreCase(name)) {
                return arena;
            }
        }
        return null;
    }

    public Arena getPlayerArena(Player player) {
        return getPlayerArena(player.getUniqueId());
    }

    public Arena getPlayerArena(UUID uuid) {
        String arenaId = playerArenas.get(uuid);
        if (arenaId == null) {
            return null;
        }
        return getArena(arenaId);
    }

    public void setPlayerArena(UUID uuid, String arenaId) {
        if (arenaId == null) {
            playerArenas.remove(uuid);
        } else {
            playerArenas.put(uuid, arenaId.toLowerCase());
        }
    }

    public Collection<Arena> getArenas() {
        return Collections.unmodifiableCollection(arenas.values());
    }

    public List<Arena> getAvailableArenas() {
        List<Arena> available = new ArrayList<>();
        for (Arena arena : arenas.values()) {
            if (arena.canJoin()) {
                available.add(arena);
            }
        }
        return available;
    }

    public boolean exists(String id) {
        return arenas.containsKey(id.toLowerCase());
    }

    public int getArenaCount() {
        return arenas.size();
    }
}

