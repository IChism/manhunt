package com.mypackage;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InfoTitleTest implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        //The Console Needs a player to send the title to fail if a player argument isnt provided
        if (args.length == 0 && !(commandSender instanceof Player)) return false;

            //Determines who to send the title to
            Player target;
            if(args.length == 0) target = (Player)commandSender;
            else target = Bukkit.getPlayerExact(args[0]);


            target.sendTitle("Test", "Subtitle Test");

            return true;
        }
}
