package net.craftions.bedwars;

import net.craftions.bedwars.api.Config;
import net.craftions.bedwars.api.NetUtils;
import net.craftions.bedwars.commands.*;
import net.craftions.bedwars.event.EventPlayerJoin;
import net.craftions.bedwars.logger.Logger;
import net.craftions.bedwars.spawner.ISpawner;
import net.craftions.bedwars.spawner.SpawnerHandler;
import org.bukkit.Bukkit;
import org.bukkit.block.data.type.Bed;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public final class Bedwars extends JavaPlugin {

    public static String prefix                     = "[§bBedWars§r] ";

    public static Boolean enableGold                = true;
    public static Boolean enableIron                = true;
    public static Boolean enableBronze              = true;

    public static Integer MIN_PLAYERS               = 2;
    public static Integer TEAM_SIZE                 = 2;

    public static Boolean isRunning                 = false;
    public static Boolean isStarting                = false;

    public static HashMap<Player, Integer> teams    = new HashMap<>();

    protected static Bedwars instance;
    public static ArrayList<ISpawner> spawners      = new ArrayList<>();

    @Override
    public void onEnable() {
        Logger.info("Loading BedWars v" + this.getDescription().getVersion() + "...");
        instance = this;
        SpawnerHandler.createTasks();
        File root = new File("./plugins/Bedwars");
        File spawnerRoot = new File("./plugins/Bedwars/spawner");
        if(!root.isDirectory()){root.mkdirs();}
        if(!spawnerRoot.isDirectory()){spawnerRoot.mkdirs();}
        File bronzeConf = new File("./plugins/Bedwars/spawner/bronze.yml");
        File ironConf = new File("./plugins/Bedwars/spawner/iron.yml");
        File goldConf = new File("./plugins/Bedwars/spawner/gold.yml");
        if(!bronzeConf.exists()){NetUtils.download("https://cdn.craftions.net/plugins/Bedwars/default/spawner/bronze.yml", bronzeConf);}
        if(!ironConf.exists()){NetUtils.download("https://cdn.craftions.net/plugins/Bedwars/default/spawner/iron.yml", ironConf);}
        if(!goldConf.exists()){NetUtils.download("https://cdn.craftions.net/plugins/Bedwars/default/spawner/gold.yml", goldConf);}
        File locationConf = new File("./plugins/Bedwars/locations.yml");
        if(!locationConf.exists()){NetUtils.download("https://cdn.craftions.net/plugins/Bedwars/default/locations.yml", locationConf);}

        new Config(new File("./plugins/Bedwars/spawner/bronze.yml"), "spawner-bronze");
        new Config(new File("./plugins/Bedwars/spawner/iron.yml"), "spawner-iron");
        new Config(new File("./plugins/Bedwars/spawner/gold.yml"), "spawner-gold");
        new Config(new File("./plugins/Bedwars/locations.yml"), "locations");

        Bukkit.getPluginCommand("setspawner").setExecutor(new CommandSetSpawner());
        Bukkit.getPluginCommand("setspawner").setTabCompleter(new TabCompleterSetSpawner());
        Bukkit.getPluginCommand("setspawn").setExecutor(new CommandSetSpawn());
        Bukkit.getPluginCommand("spawn").setExecutor(new CommandSpawn());
        Bukkit.getPluginCommand("start").setExecutor(new CommandStart());

        Bukkit.getPluginManager().registerEvents(new EventPlayerJoin(), this);

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

    public static class GameHandler {

        public static void start(Boolean force){
            if(force){
                startFinal();
            }else {
                if(checkStartAllowed()){
                    startFinal();
                }else {
                    Logger.bError("Waiting for more players...");
                }
            }
        }

        private static void startFinal(){
            Logger.bInfo("The game starts...");
            int currentTS = 0;
            int currentTeam = 0;
            for(Player p : Bukkit.getOnlinePlayers()){

            }
        }

        public static Boolean checkStartAllowed(){
            if(!Bedwars.isStarting && !Bedwars.isRunning && Bukkit.getOnlinePlayers().size() >= Bedwars.MIN_PLAYERS){
                return true;
            }else {
                return false;
            }
        }
    }
}
