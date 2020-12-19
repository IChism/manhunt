package com.mypackage;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.UUID;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

public class Teams {
    private Set<UUID> hunters;
    private Map<UUID, Location> runners;

    public Teams() {
        hunters = new HashSet<>();
        runners = new HashMap<>();
    }

    public Set<UUID> getHunters() {
        return hunters;
    }

    public void addHunter(Player hunter) {
        this.hunters.add(hunter.getUniqueId());
    }

    public void removeHunter(Player hunter) {
        this.hunters.remove(hunter.getUniqueId());
    }

    public Map<UUID, Location> getRunners() {
        return runners;
    }

    public void setRunners(Map<UUID, Location> runners) {
        this.runners = runners;
    }
}
