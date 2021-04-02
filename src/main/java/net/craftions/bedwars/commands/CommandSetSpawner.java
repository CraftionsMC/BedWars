/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.bedwars.commands;

import net.craftions.bedwars.logger.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetSpawner implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 0){
                Logger.pError("Please use §b/setspawn <type>", p);
            }else {

            }
        }else {
            Logger.warning("You need to be a player to run this command.");
        }
        return true;
    }
}
