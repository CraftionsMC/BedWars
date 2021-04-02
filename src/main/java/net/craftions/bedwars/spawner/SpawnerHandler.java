/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.bedwars.spawner;

import net.craftions.bedwars.Bedwars;
import org.bukkit.Bukkit;

public class SpawnerHandler {

    public static void createTasks() {
        for(Spawner s : Bedwars.spawners){
            Bukkit.getScheduler().scheduleSyncRepeatingTask(Bedwars.getInstance(), new Runnable() {
                @Override
                public void run() {
                    s.spawn();
                }
            }, s.getSpawnStartDelay(), s.getSpawnIntervalDelay());
        }
    }
}
