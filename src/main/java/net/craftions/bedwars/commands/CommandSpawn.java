/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.bedwars.commands;

import net.craftions.bedwars.Bedwars;
import net.craftions.bedwars.api.Config;
import net.craftions.bedwars.logger.Logger;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpawn implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(!Bedwars.isRunning){
                ((Player) sender).teleport((Location) Config.getInstance("locations").get("spawn"));
            }else {
                Logger.pError("You can't use this while the game is running.", (Player) sender);
            }
        }else {
            Logger.error("You need to be a player.");
        }
        return true;
    }
}
