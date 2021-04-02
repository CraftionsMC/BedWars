/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.bedwars.commands;

import net.craftions.bedwars.Bedwars;
import net.craftions.bedwars.logger.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandStart implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!Bedwars.isRunning && !Bedwars.isStarting){
            Bedwars.GameHandler.start(true);
        }else {
            if(sender instanceof Player){
                Logger.pError("The game is already running/starting.", (Player) sender);
            }else {
                Logger.error("The game is already running/starting.");
            }
        }
        return true;
    }
}
