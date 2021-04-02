package net.craftions.bedwars;

import net.craftions.bedwars.logger.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Bedwars extends JavaPlugin {

    public static String prefix = "[§bBedWars§r] ";
    protected static Bedwars instance;

    @Override
    public void onEnable() {
        Logger.info("Loading BedWars v" + this.getDescription().getVersion() + "...");
        instance = this;

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
