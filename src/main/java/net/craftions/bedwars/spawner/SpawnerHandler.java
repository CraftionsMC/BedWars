/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.bedwars.spawner;

import net.craftions.bedwars.Bedwars;
import net.craftions.bedwars.api.Config;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class SpawnerHandler {

    public static void createTasks() {
        for(ISpawner s : Bedwars.spawners){
            if(s instanceof BronzeSpawner){
                if(Bedwars.enableBronze){
                    createTaskFinal(s);
                }
            }else if(s instanceof IronSpawner) {
                if (Bedwars.enableIron) {
                    createTaskFinal(s);
                }
            }else if(s instanceof GoldSpawner) {
                if (Bedwars.enalbeGold) {
                    createTaskFinal(s);
                }
            }
        }
    }

    public static void createSpawner(){
        for(String s : Config.getInstance("spawner-bronze").getAll("spawner", true)){
            Bedwars.spawners.add(new BronzeSpawner((Location) Config.getInstance("spawner-bronze").get("spawner." + s + ".spawn")));
        }
        for(String s : Config.getInstance("spawner-iron").getAll("spawner", true)){
            Bedwars.spawners.add(new IronSpawner((Location) Config.getInstance("spawner-iron").get("spawner." + s + ".spawn")));
        }
        for(String s : Config.getInstance("spawner-gold").getAll("spawner", true)){
            Bedwars.spawners.add(new GoldSpawner((Location) Config.getInstance("spawner-gold").get("spawner." + s + ".spawn")));
        }
    }

    private static void createTaskFinal(ISpawner s){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Bedwars.getInstance(), new Runnable() {
            @Override
            public void run() {
                s.spawn();
            }
        }, s.getSpawnStartDelay(), s.getSpawnIntervalDelay());
    }
}
