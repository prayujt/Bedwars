package bedwars.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.World;
import org.bukkit.Location;

import org.jetbrains.annotations.NotNull;

import bedwars.BedwarsPlayer;
import bedwars.Game;

import java.util.*;

public class ResetCommand implements CommandExecutor {
    public ResetCommand() {}

    public static ResetCommand INSTANCE = new ResetCommand();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Game.teams = new Hashtable<Integer, ArrayList<BedwarsPlayer>>();
        Game.beds = new Hashtable<Integer, Boolean>();
        for (Player player: Game.onlinePlayers) {
            player.setGameMode(GameMode.SURVIVAL);
            player.teleport(new Location(Bukkit.getWorld("world"), 0, 118, 0));
        }    
        Bukkit.broadcastMessage("Returned to lobby!");
        return true;
    }    
}    
