/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.bedwars.spawner;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BronzeSpawner implements ISpawner {

    private Location spawnLocation;

    public BronzeSpawner(Location spawnLocation){
        this.spawnLocation = spawnLocation;
    }

    @Override
    public Location getSpawnerLocation() {
        return this.spawnLocation;
    }

    @Override
    public ItemStack getItemToSpawn() {
        return new ItemStack(Material.BRICK);
    }

    @Override
    public int getSpawnStartDelay() {
        return 1 * 20;
    }

    @Override
    public int getSpawnIntervalDelay() {
        return 1 * 20;
    }

    @Override
    public void spawn() {
        this.getSpawnerLocation().getWorld().dropItemNaturally(this.getSpawnerLocation(), this.getItemToSpawn());
    }
}
