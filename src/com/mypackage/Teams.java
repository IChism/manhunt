package com.mypackage;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

import java.util.HashSet;
import java.util.UUID;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;



public class Teams {

    private Set<UUID> hunters;
    private Map<UUID, Location> runners;
    Scoreboard scoreboard;

    enum Team{
        RUNNERS,
        HUNTERS,
        BOTH
    }

    public Teams(Scoreboard scoreboard) {
        hunters = new HashSet<>();
        runners = new HashMap<>();
        this.scoreboard = scoreboard;
        setupNewTeam("Hunters", ChatColor.AQUA);
        setupNewTeam("Runners", ChatColor.GREEN);
    }

    private void setupNewTeam(String name, ChatColor chatColor){
        try {
            if(this.scoreboard.getTeam(name) != null) throw new Exception("Team Already Exists");
            this.scoreboard.registerNewTeam(name);
            this.scoreboard.getTeam(name).setAllowFriendlyFire(false);
            this.scoreboard.getTeam(name).setPrefix(chatColor + "");
        } catch (Exception exc){
            exc.printStackTrace();
            System.out.println(exc.getMessage());
        }
    }

    public Set<UUID> getHunters() {
        return hunters;
    }

    public void addHunter(Player hunter) {

        this.hunters.add(hunter.getUniqueId());
        scoreboard.getTeam("Hunters").addEntry(hunter.getName());
    }

    public void removeHunter(Player hunter) {

        this.hunters.remove(hunter.getUniqueId());
        scoreboard.getTeam("Hunters").removeEntry(hunter.getName());
    }

    public Map<UUID, Location> getRunners() {
        return runners;
    }

    public void setRunners(Map<UUID, Location> runners) {
        this.runners = runners;
    }

    public void addRunner(Player runner) {

        this.runners.put(runner.getUniqueId(), runner.getLocation());
        scoreboard.getTeam("Runners").addEntry(runner.getName());
    }

    public void removeRunner(Player runner) {

        this.runners.remove(runner.getUniqueId());
        scoreboard.getTeam("Runners").removeEntry(runner.getName());
    }

    //Removes all hunters from the team
    public void clearHunters()
    {

        this.hunters.clear();
        //Clears all members of the Hunter scoreboard team by creating a new team
        scoreboard.getTeam("Hunters").unregister();
        setupNewTeam("Hunters", ChatColor.AQUA);
    }

    //Removes all runners from the team
    public void clearRunners()
    {

        this.runners.clear();
        //Clears all members of the Runner scoreboard team by creating a new team
        scoreboard.getTeam("Runners").unregister();
        setupNewTeam("Runners", ChatColor.GREEN);
    }

    public Scoreboard getScoreboard(){
        return this.scoreboard;
    }

    public void setScoreboard(Scoreboard scoreboard){
        this.scoreboard = scoreboard;
    }
}
