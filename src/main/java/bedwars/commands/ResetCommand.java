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
        String newWorld = "world" + Integer.toString(Game.currentGame);

        File template = new File(Bukkit.getWorldContainer(), "bedwars_template");
        File destination = new File(Bukkit.getWorldContainer(), newWorld);
        try {
            FileUtils.copyDirectory(template, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File delete = new File(Bukkit.getWorldContainer().getPath() + "/" + newWorld + "/", "uid.dat");
        delete.delete();

        WorldCreator wc = new WorldCreator(newWorld);
        wc.createWorld();

        String world = Game.getWorld().getName();

        for (Player player: Game.onlinePlayers) {
            player.setGameMode(GameMode.SURVIVAL);
            player.teleport(new Location(Bukkit.getWorld(newWorld), 0, 118, 0));
        }
        Bukkit.broadcastMessage("Returned to lobby!");

        File deleteFolder = new File(Bukkit.getWorldContainer(), world);
        System.out.println("Deleting: " + deleteFolder.getPath());
        try {
            FileUtils.deleteDirectory(deleteFolder);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Game.currentGame += 1;
        return true;
    }    
}    
