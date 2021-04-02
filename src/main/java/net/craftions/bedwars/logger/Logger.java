/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.bedwars.logger;

import net.craftions.bedwars.Bedwars;
import org.bukkit.ChatColor;

public class Logger {

    public static void info(String msg){
        System.err.println(Bedwars.prefix + ChatColor.WHITE + msg);
    }

    public static void warning(String msg){
        System.err.println(Bedwars.prefix + ChatColor.YELLOW + msg);
    }

    public static void error(String msg){
        System.err.println(Bedwars.prefix + ChatColor.RED + msg);
    }
}
