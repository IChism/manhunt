package com.mypackage;

import com.sun.istack.internal.Nullable;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ManhuntUtils {


    public static ItemStack buildHunterCompass(){

        ItemStack hunterCompass = new ItemStack(Material.COMPASS);
        ItemMeta compassMeta = hunterCompass.getItemMeta();

        List<String> compassLore = new ArrayList<String>();
        compassLore.add(ChatColor.AQUA + "Hunter Compass");
        compassLore.add(ChatColor.GREEN + "Right Click on the Compass to track Players");

        compassMeta.setDisplayName(ChatColor.AQUA +""+ ChatColor.BOLD + "Hunter Compass");
        compassMeta.setLore(compassLore);
        hunterCompass.setItemMeta(compassMeta);

        return hunterCompass;
    }

    //Manipulates the lodestone metadata to allow for tracking hunters through the nether and the overworld
    //The compass item meta is passed in to make sure its previous metadata isn't overrided
    public static ItemMeta setCompassTarget(ItemMeta compassMeta, Location closestRunner){

        CompassMeta newTarget = (CompassMeta) compassMeta;

        //Disables the compass from needing a lodestone block to point to locations
        newTarget.setLodestoneTracked(false);

        newTarget.setLodestone(closestRunner);

        return newTarget;
    }

    //Broadcasts a title to all players on a server
    public static void BroadCastTitle(SpigotTitle title, Server broadcastServer){
        Set<Player> broadcastPlayers = (Set<Player>) broadcastServer.getOnlinePlayers();
        for (Player p: broadcastPlayers) {
            p.sendTitle(title.title, title.subtitle, title.fadeIn, title.stay, title.fadeOut);
        }
    }

    //Broadcasts plays a sound to all players on the server
    public static void BroadCastSound(Sound sound, float volume, float pitch, Server broadcastServer){
        Set<Player> broadcastPlayers = (Set<Player>) broadcastServer.getOnlinePlayers();
        for (Player p: broadcastPlayers) {
            p.playSound(p.getLocation(), sound, volume, pitch);
        }
    }


}
