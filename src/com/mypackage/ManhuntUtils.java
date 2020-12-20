package com.mypackage;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

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


}
