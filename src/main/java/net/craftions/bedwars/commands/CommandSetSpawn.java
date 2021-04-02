/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.bedwars.commands;

import net.craftions.bedwars.api.Config;
import net.craftions.bedwars.logger.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetSpawn implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Config.getInstance("locations").set("spawn", ((Player) sender).getLocation());
            Config.getInstance("locations").reload(true);
            Logger.pInfo("§aThe spawn was set.", (Player) sender);
        }else {
            Logger.warning("You need to be a player.");
        }
        return true;
    }
}
