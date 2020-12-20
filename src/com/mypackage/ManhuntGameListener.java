package com.mypackage;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import java.util.List;
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
            ItemStack compass = ManhuntUtils.buildHunterCompass();
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

            //Checks if the hunter right clicked with the compass, if so the sever will find runners in thier world point the compass to the nearest player
            //and alert the player about its findings using the actionbar
            ItemStack item = event.getItem();
            if(item.getType() == Material.COMPASS && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
                Player closestRunner = getClosestRunner(movedPlr);
                if(closestRunner == null){
                    movedPlr.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "No Players found in your dimension"));
                }
                movedPlr.setCompassTarget(closestRunner.getLocation());
                movedPlr.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                        new TextComponent(ChatColor.YELLOW + "Nearest Runner: " + ChatColor.GREEN + closestRunner.getName()));
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


