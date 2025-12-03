package com.nrleryx.arenanext.model;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.*;

public class Arena {

    private final String id;
    private String name;
    private ArenaState state;
    private ArenaType type;
    private final Set<UUID> players;
    private final Set<UUID> spectators;
    private Location lobbySpawn;
    private final List<Location> spawnPoints;
    private int minPlayers;
    private int maxPlayers;
    private int countdown;
    private boolean enabled;

    public Arena(String id, String name) {
        this.id = id;
        this.name = name;
        this.state = ArenaState.WAITING;
        this.type = ArenaType.FFA;
        this.players = new HashSet<>();
        this.spectators = new HashSet<>();
        this.spawnPoints = new ArrayList<>();
        this.minPlayers = 2;
        this.maxPlayers = 16;
        this.countdown = 10;
        this.enabled = true;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArenaState getState() {
        return state;
    }

    public void setState(ArenaState state) {
        this.state = state;
    }

    public ArenaType getType() {
        return type;
    }

    public void setType(ArenaType type) {
        this.type = type;
    }

    public Set<UUID> getPlayers() {
        return Collections.unmodifiableSet(players);
    }

    public void addPlayer(UUID uuid) {
        players.add(uuid);
    }

    public void removePlayer(UUID uuid) {
        players.remove(uuid);
    }

    public boolean hasPlayer(UUID uuid) {
        return players.contains(uuid);
    }

    public int getPlayerCount() {
        return players.size();
    }

    public Set<UUID> getSpectators() {
        return Collections.unmodifiableSet(spectators);
    }

    public void addSpectator(UUID uuid) {
        spectators.add(uuid);
    }

    public void removeSpectator(UUID uuid) {
        spectators.remove(uuid);
    }

    public boolean hasSpectator(UUID uuid) {
        return spectators.contains(uuid);
    }

    public Location getLobbySpawn() {
        return lobbySpawn;
    }

    public void setLobbySpawn(Location lobbySpawn) {
        this.lobbySpawn = lobbySpawn;
    }

    public List<Location> getSpawnPoints() {
        return Collections.unmodifiableList(spawnPoints);
    }

    public void addSpawnPoint(Location location) {
        spawnPoints.add(location);
    }

    public void removeSpawnPoint(Location location) {
        spawnPoints.remove(location);
    }

    public Location getSpawnPoint(int index) {
        if (index < 0 || index >= spawnPoints.size()) {
            return null;
        }
        return spawnPoints.get(index);
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getCountdown() {
        return countdown;
    }

    public void setCountdown(int countdown) {
        this.countdown = countdown;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean canJoin() {
        return enabled && state == ArenaState.WAITING && players.size() < maxPlayers;
    }

    public boolean canStart() {
        return enabled && state == ArenaState.WAITING && players.size() >= minPlayers;
    }
}

