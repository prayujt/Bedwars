package bedwars.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.Location;

import org.jetbrains.annotations.NotNull;

import bedwars.BedwarsPlayer;
import bedwars.Game;

import java.util.*;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class ResetCommand implements CommandExecutor {
    public ResetCommand() {}

    public static ResetCommand INSTANCE = new ResetCommand();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Game.teams = new Hashtable<Integer, ArrayList<BedwarsPlayer>>();
        Game.beds = new Hashtable<Integer, Boolean>();

        File template = new File(Bukkit.getWorldContainer(), "bedwars_template");
        File destination = new File(Bukkit.getWorldContainer(), "bedwars1");
        try {
            FileUtils.copyDirectory(template, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        WorldCreator wc = new WorldCreator("bedwars1");
        wc.createWorld();

        for (Player player: Game.onlinePlayers) {
            player.setGameMode(GameMode.SURVIVAL);
            player.teleport(new Location(Bukkit.getWorld("bedwars1"), 0, 118, 0));
        }
        Bukkit.broadcastMessage("Returned to lobby!");
        return true;
    }    
}    
