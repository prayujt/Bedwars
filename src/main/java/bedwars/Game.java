package bedwars;

import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.*;

public class Game {
    public static ArrayList<String> colors = new ArrayList<String>(List.of("Yellow", "Red", "White"));
    public static ArrayList<Player> onlinePlayers = new ArrayList<Player>();

    public static Hashtable<Integer, ArrayList<BedwarsPlayer>> teams = new Hashtable<Integer, ArrayList<BedwarsPlayer>>();
    public static Hashtable<Integer, Boolean> beds = new Hashtable<Integer, Boolean>();

    public static ArrayList<ArrayList<Double>> baseSpawners = new ArrayList<ArrayList<Double>>();
    public static ArrayList<ArrayList<Double>> diamondSpawners = new ArrayList<ArrayList<Double>>(List.of(
                new ArrayList<Double>(List.of(-52.0, 65.0, 1.0)),
                new ArrayList<Double>(List.of(1.0, 65.0, -52.0)),
                new ArrayList<Double>(List.of(1.0, 65.0, 52.0)),
                new ArrayList<Double>(List.of(52.0, 65.0, 1.0))
            ));
    public static ArrayList<ArrayList<Double>> emeraldSpawners = new ArrayList<ArrayList<Double>>(List.of(
                new ArrayList<Double>(List.of(-11.5, 79.0, 12.5)),
                new ArrayList<Double>(List.of(12.5, 79.0, 12.5)),
                new ArrayList<Double>(List.of(12.0, 79.0, -11.5)),
                new ArrayList<Double>(List.of(-11.5, 79.0, -11.5))
            ));

    public static boolean inGame = false;
    public static int currentGame = 1;

    public static void startGame() {
        Game.inGame = true;            
        for (ArrayList<Double> coordinates: diamondSpawners) {
            Spawner spawner = new Spawner(1, coordinates);
        }
        for (ArrayList<Double> coordinates: emeraldSpawners) {
            Spawner spawner = new Spawner(2, coordinates);
        }
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
