package com.mypackage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearTeam implements CommandExecutor {

    private Teams team;

    public ClearTeam(Teams inputTeam){
        this.team = inputTeam;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        //If both teams are specified or no team is specified, both teams are cleared
        if (args.length == 0 || args[0].equalsIgnoreCase(Teams.Team.BOTH.name())) {
            team.clearHunters();
            team.clearRunners();
            commandSender.sendMessage(ChatColor.AQUA + "[Manhunt] all teams cleared");
        }


        //If a team is specified, checks if the team exists and removes the team specified
        if(args[0].equalsIgnoreCase(Teams.Team.HUNTERS.name())) {
            team.clearHunters();
            commandSender.sendMessage(ChatColor.AQUA + "[Manhunt] hunter team cleared");
            return true;
        }
        else if(args[0].equalsIgnoreCase(Teams.Team.RUNNERS.name())){
            team.clearRunners();
            commandSender.sendMessage(ChatColor.AQUA + "[Manhunt] runner team cleared");
            return true;
        }
        else{
            commandSender.sendMessage(ChatColor.RED + "Incorrect Syntax");
            return false;
        }
    }


    //TODO add a remove all hunters methods
}
