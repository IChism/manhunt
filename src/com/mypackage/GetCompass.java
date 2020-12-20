package com.mypackage;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GetCompass implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            return false;
        }
        Player player = (Player) commandSender;

        ItemStack compass = ManhuntUtils.buildHunterCompass();

        player.getInventory().addItem(compass);

        player.sendRawMessage("You're welcome ;)");
        return true;
    }
}

