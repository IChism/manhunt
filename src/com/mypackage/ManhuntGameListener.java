package com.mypackage;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class ManhuntGameListener implements Listener{

    private Teams team;

    public ManhuntGameListener(Teams inputTeam){
        this.team = inputTeam;
    }

    @EventHandler
    public void onRespawn (PlayerRespawnEvent event){

        //Checks if the player is on the hunter team, and gives them the compass
        Player hunter = event.getPlayer();
        if(team.getHunters().contains(hunter.getUniqueId())) {
            ItemStack compass = BuildCompass.buildHunterCompass();
            hunter.getInventory().addItem(compass);
        }

        //If the player is the only runner and is killed the game ends
        //If there are multiple runner than the killed player is removed from the team and put into spectator
    }

    @EventHandler
    public void onHunterMove (PlayerInteractEvent event){

        //Checks if the player is on the hunter team, ignores updating the compass then
        Player movedPlr = event.getPlayer();
        UUID movedID = movedPlr.getUniqueId();
        if(team.getHunters().contains(movedID)) {
            ItemStack item = event.getItem();
            if(item.getType() == Material.COMPASS) {
                Player closestRunner = getClosestRunner(movedPlr);
                if(closestRunner == null){
                    movedPlr.sendRawMessage(ChatColor.RED + "No Players found in your dimension");
                }
                movedPlr.setCompassTarget(closestRunner.getLocation());
            }
        }
        //If the player is the only runner and is killed the game ends
        //If there are multiple runner than the killed player is removed from the team and put into spectator
    }

    public Player getClosestRunner(Player hunter){
        Location hunterLocation = hunter.getLocation();
        Player closestPlayer = null;
        double closestDistanceSquared = Double.MAX_VALUE;

        List<Player> candidates = hunter.getWorld().getPlayers();
        for (Player p : candidates) {
            if ( team.getRunners().keySet().contains(p.getUniqueId()) && p.getGameMode() == GameMode.SURVIVAL) {
                double distanceSquared = p.getLocation().distanceSquared(hunterLocation);
                if (distanceSquared <= closestDistanceSquared) {
                    closestDistanceSquared = distanceSquared;
                    closestPlayer = p;
                }
            }
        }
        return closestPlayer;
    }
}


