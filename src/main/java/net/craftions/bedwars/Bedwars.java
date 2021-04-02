package net.craftions.bedwars;

import net.craftions.bedwars.logger.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public final class Bedwars extends JavaPlugin {

    public static String prefix = "[§bBedWars§r] ";

    @Override
    public void onEnable() {
        Logger.info("Loading BedWars v" + this.getDescription().getVersion() + "...");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
