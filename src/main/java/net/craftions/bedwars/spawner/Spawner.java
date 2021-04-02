package net.craftions.bedwars.spawner;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

public interface Spawner {

    Location getSpawnerLocation();

    ItemStack getItemToSpawn();

    int getSpawnStartDelay();
    int getSpawnIntervalDelay();

}
