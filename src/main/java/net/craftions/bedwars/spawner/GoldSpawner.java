/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.bedwars.spawner;

import net.craftions.bedwars.api.Config;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class GoldSpawner implements ISpawner {

    private Location spawnLocation;

    public GoldSpawner(Location spawnLocation){
        this.spawnLocation = spawnLocation;
    }

    @Override
    public Location getSpawnerLocation() {
        return this.spawnLocation;
    }

    @Override
    public ItemStack getItemToSpawn() {
        return new ItemStack(Material.GOLD_INGOT);
    }

    @Override
    public int getSpawnStartDelay() {
        return 30 * 20;
    }

    @Override
    public int getSpawnIntervalDelay() {
        return 30 * 20;
    }

    @Override
    public void spawn() {
        this.getSpawnerLocation().getWorld().dropItemNaturally(this.getSpawnerLocation(), this.getItemToSpawn());
    }

    @Override
    public Config getConfig() {
        return Config.getInstance("spawner-gold");
    }
}
