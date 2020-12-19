package com.mypackage;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Manhunt extends JavaPlugin {

    private Set<UUID> hunterPlayerIDs = new HashSet<>();
    private Set<UUID> runnerPlayerIDs = new HashSet<>();

    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("manhuntinfo")).setExecutor(new CommandManhuntinfo());
        Objects.requireNonNull(this.getCommand("getcompass")).setExecutor(new GetCompass());
        Objects.requireNonNull(this.getCommand("titletest")).setExecutor(new InfoTitleTest());
        Objects.requireNonNull(this.getCommand("addhunter")).setExecutor(new AddHunter(this));
        Objects.requireNonNull(this.getCommand("removehunter")).setExecutor(new RemoveHunter(this));
        Objects.requireNonNull(this.getCommand("addrunner")).setExecutor(new AddRunner(this));
        Objects.requireNonNull(this.getCommand("removerunner")).setExecutor(new RemoveRunner(this));
        Objects.requireNonNull(this.getCommand("disphunters")).setExecutor(new DebugDisplayHunters(this));
        getServer().getPluginManager().registerEvents(new ManhuntGameListener(this), this);
    }

    @Override
    public void onDisable() {

    }

    //General Hashset maipulation functions

    //Getters for Hashsets
    public Set<UUID> getHunterIDs() {
        return hunterPlayerIDs;
    }
    public Set<UUID> getRunnerIDs() {
        return runnerPlayerIDs;
    }

    //Removers for Hashsets
    public void removeHunter(Player hunter){
        hunterPlayerIDs.remove(hunter.getUniqueId());
    }
    public void removeRunner(Player runner){
        runnerPlayerIDs.remove(runner.getUniqueId());
    }

    //Adders for Hashsets
    public void addHunter(Player hunter){
        hunterPlayerIDs.add(hunter.getUniqueId());
    }
    public void addRunner(Player runner){
        runnerPlayerIDs.add(runner.getUniqueId());
    }




}
