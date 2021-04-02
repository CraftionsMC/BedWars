/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.bedwars.commands;

import net.craftions.bedwars.logger.Logger;
import net.craftions.bedwars.spawner.ISpawner;
import net.craftions.bedwars.spawner.SpawnerHelper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class CommandSetSpawner implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 0){
                Logger.pError("Please use §b/setspawn <type>", p);
            }else {
                ISpawner spawner = SpawnerHelper.createSpawnerByName(args[0], p.getLocation());
                if(spawner == null){
                    Logger.pError("This spawner type was not found!", p);
                }else {
                    spawner.getConfig().set("spawner." + UUID.randomUUID() + ".spawn", spawner.getSpawnerLocation());
                    spawner.getConfig().reload(true);
                    Logger.pInfo("§aThe spawner was set.", p);
                }
            }
        }else {
            Logger.warning("You need to be a player to run this command.");
        }
        return true;
    }
}
