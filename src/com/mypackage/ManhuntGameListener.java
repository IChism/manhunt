package com.mypackage;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class ManhuntGameListener implements Listener{

    private Manhunt plugin;

    public ManhuntGameListener(Manhunt plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onRespawn (PlayerRespawnEvent event){

        //Checks if the player is on the hunter team, and gives them the compass
        Player hunter = event.getPlayer();
        if(plugin.getHunterIDs().contains(hunter.getUniqueId())) {
            ItemStack compass = new ItemStack(Material.COMPASS);
            hunter.getInventory().addItem(compass);
        }

        //If the player is the only runner and is killed the game ends
        //If there are multiple runner than the killed player is removed from the team and put into spectator
    }
}


