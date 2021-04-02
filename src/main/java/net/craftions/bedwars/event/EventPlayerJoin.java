/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.bedwars.event;

import net.craftions.bedwars.Bedwars;
import net.craftions.bedwars.api.Config;
import net.craftions.bedwars.logger.Logger;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.concurrent.ThreadLocalRandom;

public class EventPlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        if(!Bedwars.isRunning){
            e.getPlayer().teleport((Location) Config.getInstance("locations").get("spawn"));
            Bedwars.GameHandler.start(false);
        }else {
            e.getPlayer().setGameMode(GameMode.SPECTATOR);
            Logger.pInfo("The game is already running. Get a coffee and watch the others.", e.getPlayer());
            Player to2 = (Player) Bukkit.getOnlinePlayers().toArray()[ThreadLocalRandom.current().nextInt(0, Bukkit.getOnlinePlayers().size())];
            e.getPlayer().teleport(to2.getLocation());
        }
    }
}
