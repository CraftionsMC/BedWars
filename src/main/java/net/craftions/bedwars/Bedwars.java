package net.craftions.bedwars;

import net.craftions.bedwars.logger.Logger;
import net.craftions.bedwars.spawner.ISpawner;
import net.craftions.bedwars.spawner.SpawnerHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Bedwars extends JavaPlugin {

    public static String prefix = "[§bBedWars§r] ";

    protected static Bedwars instance;
    public static ArrayList<ISpawner> spawners = new ArrayList<>();

    @Override
    public void onEnable() {
        Logger.info("Loading BedWars v" + this.getDescription().getVersion() + "...");
        instance = this;
        SpawnerHandler.createTasks();
        // TODO: Create Configs ["spawner-bronze", "spawner-iron", "spawner-gold"]
    }

    @Override
    public void onDisable() {
        Logger.info("Unloading Bedwars v" + this.getDescription().getVersion() + "...");
    }

    public static void disable(){
        Bukkit.getPluginManager().disablePlugin(getInstance());
    }

    public static Bedwars getInstance() {
        return instance;
    }
}
