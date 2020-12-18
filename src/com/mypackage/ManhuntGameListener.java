package com.mypackage;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class ManhuntGameListener implements Listener{

    @EventHandler
    public void onHunterRespawn (PlayerRespawnEvent event){

        ItemStack compass = new ItemStack(Material.COMPASS);

        event.getPlayer().getInventory().addItem(compass);

    }
}


