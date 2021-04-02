package net.craftions.bedwars;

import net.craftions.bedwars.api.Config;
import net.craftions.bedwars.commands.CommandSetSpawner;
import net.craftions.bedwars.commands.TabCompleterSetSpawner;
import net.craftions.bedwars.logger.Logger;
import net.craftions.bedwars.spawner.ISpawner;
import net.craftions.bedwars.spawner.SpawnerHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;

public final class Bedwars extends JavaPlugin {

    public static String prefix = "[§bBedWars§r] ";

    public static Boolean enalbeGold        = true;
    public static Boolean enableIron        = true;
    public static Boolean enableBronze      = true;


    protected static Bedwars instance;
    public static ArrayList<ISpawner> spawners = new ArrayList<>();

    @Override
    public void onEnable() {
        Logger.info("Loading BedWars v" + this.getDescription().getVersion() + "...");
        instance = this;
        SpawnerHandler.createTasks();
        // TODO: Create Configs ["spawner-bronze", "spawner-iron", "spawner-gold"]
        new Config(new File("./plugins/Bedwars/spawner/bronze.yml"), "spawner-bronze");
        new Config(new File("./plugins/Bedwars/spawner/iron.yml"), "spawner-iron");
        new Config(new File("./plugins/Bedwars/spawner/gold.yml"), "spawner-gold");

        getCommand("setspawner").setExecutor(new CommandSetSpawner());
        getCommand("setspawner").setTabCompleter(new TabCompleterSetSpawner());

        SpawnerHandler.createSpawner();
        SpawnerHandler.createTasks();
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
