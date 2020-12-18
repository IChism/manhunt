package com.mypackage;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Set;
import java.util.UUID;

public class DebugDisplayHunters implements CommandExecutor {

    private Manhunt plugin;

    public DebugDisplayHunters(Manhunt plugin){
        this.plugin = plugin;
    }

    @Override
    @SuppressWarnings("NullPointerException")
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(plugin.getHunterIDs().isEmpty()){
            commandSender.sendMessage("No players on hunter team");
        }
        else {
            for (UUID u : plugin.getHunterIDs()) {

                commandSender.sendMessage(ChatColor.YELLOW+"Player: "+ ChatColor.AQUA + Bukkit.getPlayer(u).getName());
            }
        }
        return true;
    }
}
