package com.mypackage;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Manhunt extends JavaPlugin {
    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("manhuntinfo")).setExecutor(new CommandManhuntinfo());
        Objects.requireNonNull(this.getCommand("getcompass")).setExecutor(new GetCompass());
        getServer().getPluginManager().registerEvents(new ManhuntGameListener(), this);
    }



    @Override
    public void onDisable() {

    }
}
