package com.mypackage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddHunter implements CommandExecutor {

    private Manhunt plugin;

    public AddHunter(Manhunt plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        //The Console Needs a player to send the title to fail if a player argument isnt provided
        if (args.length == 0) {
            commandSender.sendMessage("§cIncorrect Syntax");
            return false;
        }

        //If the player is already on the hunter team then send the player an error message
        Player target = Bukkit.getPlayerExact(args[0]);
        if(target == null) {
            commandSender.sendMessage(ChatColor.RED + "Error, " +target.getDisplayName() + " not found or online");
            return true;
        }
        String name = target.getName();

        if(plugin.getHunterIDs().contains(target.getUniqueId())){
            commandSender.sendMessage(ChatColor.RED + "Error, " + name + " is already on hunter team");
            return true;
        }
        else if(plugin.getRunnerIDs().contains(target.getUniqueId())){
            commandSender.sendMessage(ChatColor.RED + "Error, " + name + " is already on runner team");
            commandSender.sendMessage(ChatColor.RED + "Remove the player from the other team first");
            return true;
        }
        else{
            plugin.addHunter(target);
            commandSender.sendMessage(ChatColor.AQUA +"[Manhunt] " + name + " was successfully added to hunters");
        }

        return true;
    }
}
