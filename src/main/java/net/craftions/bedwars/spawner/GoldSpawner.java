/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.bedwars.spawner;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GoldSpawner implements Spawner{

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
}
