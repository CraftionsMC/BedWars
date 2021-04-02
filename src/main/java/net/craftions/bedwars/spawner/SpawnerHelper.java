/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.bedwars.spawner;

import org.bukkit.Location;

public class SpawnerHelper {

    public static ISpawner createSpawnerByName(String name, Location spawnLocation){
        if(name.toLowerCase().equals("bronze")){
            return new BronzeSpawner(spawnLocation);
        }else if(name.toLowerCase().equals("iron")){
            return new IronSpawner(spawnLocation);
        }else if(name.toLowerCase().equals("gold")){
            return new GoldSpawner(spawnLocation);
        }else {
            return null;
        }
    }
}
