package com.mypackage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RemoveRunner implements CommandExecutor {

    private Manhunt plugin;

    public RemoveRunner(Manhunt plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        //The Console Needs a player to send the title to fail if a player argument isnt provided
        if (args.length == 0) {
            commandSender.sendMessage(ChatColor.RED+"Incorrect Syntax");
            return false;
        }

        //If the player is not on the hunter team then send the player an error message
        Player target = Bukkit.getPlayer(args[0]);

        if(target == null) {
            commandSender.sendMessage(ChatColor.RED+"Error, " + target.getName() + " not found or online");
            return true;
        }
        String name = target.getName();

        if(!plugin.getHunterIDs().contains(target.getUniqueId())){
            commandSender.sendMessage(ChatColor.RED+"Error, " + name + " is not on the runner team");
            return true;
        }
        else if(plugin.getRunnerIDs().contains(target.getUniqueId())){
            commandSender.sendMessage(ChatColor.RED+"Error, " + name + " is on the hunter team");
            commandSender.sendMessage(ChatColor.RED+"Remove the player from the other team");
            return true;
        }
        else{
            plugin.removeRunner(target);
            commandSender.sendMessage(ChatColor.GREEN +"[Manhunt] " + name + ", was successfully removed from runners");
        }

        return true;
    }
}
