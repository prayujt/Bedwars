package bedwars;

import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.*;

public class Game {
    public static ArrayList<String> colors = new ArrayList<String>(List.of("Yellow", "Red", "White"));
    public static ArrayList<Player> onlinePlayers = new ArrayList<Player>();

    public static Hashtable<Integer, ArrayList<BedwarsPlayer>> teams = new Hashtable<Integer, ArrayList<BedwarsPlayer>>();
    public static Hashtable<Integer, Boolean> beds = new Hashtable<Integer, Boolean>();

    public static Hashtable<Integer, ArrayList<Integer>> baseSpawners = new Hashtable<Integer, ArrayList<Integer>>();
    public static Hashtable<Integer, ArrayList<Integer>> diamondSpawners = new Hashtable<Integer, ArrayList<Integer>>();
    public static Hashtable<Integer, ArrayList<Integer>> emeraldSpawners = new Hashtable<Integer, ArrayList<Integer>>();

    public static boolean inGame = false;
    public static int currentGame = 1;

    public static void startGame() {
        Game.inGame = true;            
    }    

    public static void addPlayer(String name, int team, int x, int y, int z) {
        BedwarsPlayer bp = new BedwarsPlayer(name, team, x, y, z);
        if (teams.containsKey(team)) {
            ArrayList<BedwarsPlayer> newTeam = teams.get(team);
            newTeam.add(bp);
            teams.put(team, newTeam);
        }    
        else {
            teams.put(team, new ArrayList<BedwarsPlayer>(Arrays.asList(bp)));
            beds.put(team, true);
        }
    }    

    public static BedwarsPlayer getPlayer(Player player) {
        for (ArrayList<BedwarsPlayer> arrayP : teams.values()) {
            for (BedwarsPlayer p : arrayP) {
                if (player.getName().equals(p.name)) {
                    return p;
                }
            }
        }
        return new BedwarsPlayer(player.getName(), -1, 0, 118, 0);
    }

    public static boolean checkBed(int team) {
        try {
            return beds.get(team);
        } catch (NullPointerException e) {
            return true;
        }
    }    

    public static World getWorld() {
        return onlinePlayers.get(0).getWorld();
    }    

}    
