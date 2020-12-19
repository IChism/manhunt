package com.mypackage;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Set;
import java.util.UUID;

public class DebugDisplayHunters implements CommandExecutor {

    private Teams team;

    public DebugDisplayHunters(Teams inputTeam){
        this.team = inputTeam;
    }

    @Override
    @SuppressWarnings("NullPointerException")
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(team.getHunters().isEmpty()){
            commandSender.sendMessage("No players on hunter team");
        }
        else {
            for (UUID u : team.getHunters()) {

                commandSender.sendMessage(ChatColor.YELLOW+"Player: "+ ChatColor.AQUA + Bukkit.getPlayer(u).getName());
            }
        }
        return true;
    }
}
