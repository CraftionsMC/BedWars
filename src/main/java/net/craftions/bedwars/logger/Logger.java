/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.bedwars.logger;

import net.craftions.bedwars.Bedwars;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Logger {

    public static Boolean allowInfos         = true;
    public static Boolean allowWarnings      = true;
    public static Boolean allowErrors        = true;

    public static void info(String msg){
        if(allowInfos)
            System.err.println(Bedwars.prefix + ChatColor.WHITE + msg);
    }

    public static void pInfo(String msg, Player p){
        p.sendMessage(Bedwars.prefix + ChatColor.WHITE + msg);
    }

    public static void bInfo(String msg){
        Bukkit.broadcastMessage(Bedwars.prefix + ChatColor.WHITE + msg);
    }

    public static void warning(String msg){
        if(allowWarnings)
            System.err.println(Bedwars.prefix + ChatColor.YELLOW + msg);
    }

    public static void pWarning(String msg, Player p){
        p.sendMessage(Bedwars.prefix + ChatColor.YELLOW + msg);
    }

    public static void bWarning(String msg){
        Bukkit.broadcastMessage(Bedwars.prefix + ChatColor.YELLOW + msg);
    }

    public static void error(String msg){
        if(allowErrors)
            System.err.println(Bedwars.prefix + ChatColor.RED + msg);
    }

    public static void pError(String msg, Player p){
        p.sendMessage(Bedwars.prefix + ChatColor.RED + msg);
    }


    public static void bError(String msg){
        Bukkit.broadcastMessage(Bedwars.prefix + ChatColor.RED + msg);
    }

}
