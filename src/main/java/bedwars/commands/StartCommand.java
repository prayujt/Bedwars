package bedwars.commands;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.World;
import org.bukkit.Location;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

import bedwars.Game;

import java.util.*;

public class StartCommand implements CommandExecutor {
    public StartCommand() {}

    public static StartCommand INSTANCE = new StartCommand();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Hashtable<String, ArrayList<Integer>> bases = new Hashtable<String, ArrayList<Integer>>();
        bases.put("Green", new ArrayList<Integer>(List.of(74, 66, -34)));
        bases.put("Red", new ArrayList<Integer>(List.of(-34, 66, -72)));
        bases.put("Pink", new ArrayList<Integer>(List.of(-74, 66, 34)));
        bases.put("Cyan", new ArrayList<Integer>(List.of(34, 66, 74)));

        if (args.length != 1) {
            sender.sendMessage("Not correct number of arguments!");
            return false;
        }

        int numPlayers = Integer.valueOf(args[0]);
        if (Bukkit.getOnlinePlayers().size() % numPlayers != 0) {
            sender.sendMessage("Cannot have even teams with " + numPlayers + " players on each team!");
            return false;
        }    
        
        ArrayList<Player> players = new ArrayList<Player>(Bukkit.getOnlinePlayers());
        Bukkit.broadcastMessage("Starting game with " + players.size() / numPlayers + " teams of " + numPlayers + " players!");
        Collections.shuffle(players);
        ArrayList<ArrayList<Player>> teams = new ArrayList<ArrayList<Player>>();
        for (int i = 0; i < players.size(); i += numPlayers) {
            teams.add(new ArrayList<Player>(players.subList(i, i+numPlayers)));
        }
        System.out.println(teams.toString());

        // Teleport each player on each team to respective bases
        for (int i = 0; i < teams.size(); i += 1) {
            int x = bases.get(Game.colors.get(i)).get(0);
            int y = bases.get(Game.colors.get(i)).get(1);
            int z = bases.get(Game.colors.get(i)).get(2);
            for (Player p: teams.get(i)) {
                p.teleport(new Location(Game.getWorld(), x, y, z));
                p.setGameMode(GameMode.SURVIVAL);
                p.getInventory().clear();
                p.getInventory().addItem(new ItemStack(Material.WOODEN_SWORD));
                Game.addPlayer(p.getName(), i, x, y, z);
            }    
        }

        Game.startGame();

        return true;
    }    
}    
