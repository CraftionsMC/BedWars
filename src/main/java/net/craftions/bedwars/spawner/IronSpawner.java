/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.bedwars.spawner;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class IronSpawner implements Spawner{

    private Location spawnLocation;

    public IronSpawner(Location spawnLocation){
        this.spawnLocation = spawnLocation;
    }

    @Override
    public Location getSpawnerLocation() {
        return this.spawnLocation;
    }

    @Override
    public ItemStack getItemToSpawn() {
        return new ItemStack(Material.IRON_INGOT);
    }

    @Override
    public int getSpawnStartDelay() {
        return 15 * 20;
    }

    @Override
    public int getSpawnIntervalDelay() {
        return 15 * 20;
    }

    @Override
    public void spawn() {
        this.getSpawnerLocation().getWorld().dropItemNaturally(this.getSpawnerLocation(), this.getItemToSpawn());
    }
}
