package com.mypackage;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;

import java.util.Objects;

public class Manhunt extends JavaPlugin {

    private Teams team;
    @Override
    public void onEnable() {
        team = new Teams(getServer().getScoreboardManager().getMainScoreboard());
        Objects.requireNonNull(this.getCommand("manhuntinfo")).setExecutor(new CommandManhuntinfo());
        Objects.requireNonNull(this.getCommand("getcompass")).setExecutor(new GetCompass());
        Objects.requireNonNull(this.getCommand("titletest")).setExecutor(new InfoTitleTest());
        Objects.requireNonNull(this.getCommand("addhunter")).setExecutor(new AddHunter(team));
        Objects.requireNonNull(this.getCommand("removehunter")).setExecutor(new RemoveHunter(team));
        Objects.requireNonNull(this.getCommand("disphunters")).setExecutor(new DebugDisplayHunters(team));
        Objects.requireNonNull(this.getCommand("addrunner")).setExecutor(new AddRunner(team));
        Objects.requireNonNull(this.getCommand("removerunner")).setExecutor(new RemoveRunner(team));
        Objects.requireNonNull(this.getCommand("clearteams")).setExecutor(new ClearTeam(team));
        getServer().getPluginManager().registerEvents(new ManhuntGameListener(team), this);
    }

    @Override
    public void onDisable() {

    }



}
