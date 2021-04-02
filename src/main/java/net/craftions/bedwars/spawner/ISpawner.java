package net.craftions.bedwars.spawner;

import net.craftions.bedwars.api.Config;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

public interface ISpawner {

    Location getSpawnerLocation();

    ItemStack getItemToSpawn();

    int getSpawnStartDelay();
    int getSpawnIntervalDelay();

    void spawn();

    Config getConfig();
}
