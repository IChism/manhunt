package com.mypackage;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Manhunt extends JavaPlugin {

    private Teams team = new Teams();

    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("manhuntinfo")).setExecutor(new CommandManhuntinfo());
        Objects.requireNonNull(this.getCommand("getcompass")).setExecutor(new GetCompass());
        Objects.requireNonNull(this.getCommand("titletest")).setExecutor(new InfoTitleTest());
        Objects.requireNonNull(this.getCommand("addhunter")).setExecutor(new AddHunter(team));
        Objects.requireNonNull(this.getCommand("removehunter")).setExecutor(new RemoveHunter(team));
        Objects.requireNonNull(this.getCommand("disphunters")).setExecutor(new DebugDisplayHunters(team));
        getServer().getPluginManager().registerEvents(new ManhuntGameListener(this), this);
    }

    @Override
    public void onDisable() {

    }

}
