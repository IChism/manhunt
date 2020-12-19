package com.mypackage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddRunner implements CommandExecutor {

    private Teams team;

    public AddRunner(Teams inputTeam){
        this.team = inputTeam;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        //The Console Needs a player to send the title to fail if a player argument isnt provided
        if (args.length == 0) {
            commandSender.sendMessage(ChatColor.RED + "Incorrect Syntax");
            return false;
        }

        //If the player is already on the hunter team then send the player an error message
        Player target = Bukkit.getPlayerExact(args[0]);
        if(target == null) {
            commandSender.sendMessage(ChatColor.RED + "Error, " +target.getDisplayName() + " not found or online");
            return true;
        }
        String name = target.getName();

        if(team.getRunners().keySet().contains(target.getUniqueId())){
            commandSender.sendMessage(ChatColor.RED + "Error, " + name + " is already on runner team");
            return true;
        }
        else if(team.getHunters().contains(target.getUniqueId())){
            commandSender.sendMessage(ChatColor.RED + "Error, " + name + " is already on hunter team");
            commandSender.sendMessage(ChatColor.RED + "Remove the player from the other team first");
            return true;
        }
        else{
            team.addRunner(target);
            commandSender.sendMessage(ChatColor.GREEN +"[Manhunt] " + name + " was successfully added to runners");
        }

        return true;
    }
}
