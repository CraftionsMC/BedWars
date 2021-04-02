/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.bedwars.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TabCompleterSetSpawner implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> sug = new ArrayList<>();
        if(args.length == 0){
            sug.add("bronze");
            sug.add("iron");
            sug.add("gold");
        }else {
            if(args[0].startsWith("b")){
                sug.add("bronze");
            }else if(args[0].startsWith("i")) {
                sug.add("iron");
            }else if(args[0].startsWith("g")) {
                sug.add("gold");
            }else {
                sug.add("bronze");
                sug.add("iron");
                sug.add("gold");
            }
        }
        return sug;
    }
}
