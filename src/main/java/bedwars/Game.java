package bedwars;

import org.bukkit.entity.Player;

import java.util.*;

public class Game {
    public static ArrayList<String> colors = new ArrayList<String>(List.of("Yellow", "Red", "White"));
    public static ArrayList<Player> onlinePlayers = new ArrayList<Player>();

    public static Hashtable<Integer, ArrayList<BedwarsPlayer>> teams = new Hashtable<Integer, ArrayList<BedwarsPlayer>>();
    public static Hashtable<Integer, ArrayList<Integer>> baseSpawners = new Hashtable<Integer, ArrayList<Integer>>();
    public static Hashtable<Integer, ArrayList<Integer>> diamondSpawners = new Hashtable<Integer, ArrayList<Integer>>();
    public static Hashtable<Integer, ArrayList<Integer>> emeraldSpawners = new Hashtable<Integer, ArrayList<Integer>>();

    public static void addPlayer(String name, int team, int x, int y, int z) {
        BedwarsPlayer bp = new BedwarsPlayer(name, team, x, y, z);
        if (teams.containsKey(team)) {
            ArrayList<BedwarsPlayer> newTeam = teams.get(team);
            newTeam.add(bp);
            teams.put(team, newTeam);
        }    
        else teams.put(team, new ArrayList<BedwarsPlayer>(Arrays.asList(bp)));
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
}    
