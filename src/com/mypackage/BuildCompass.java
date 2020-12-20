package com.mypackage;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class BuildCompass {


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


}
