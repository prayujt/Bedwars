package bedwars;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.Location;

import java.util.*;

public class Game {
    public static ArrayList<String> colors = new ArrayList<String>(List.of("Green", "Red", "Pink", "Cyan", "Blue"));
    public static ArrayList<Player> onlinePlayers = new ArrayList<Player>();

    public static Hashtable<Integer, ArrayList<BedwarsPlayer>> teams = new Hashtable<Integer, ArrayList<BedwarsPlayer>>();
    public static Hashtable<Integer, Boolean> beds = new Hashtable<Integer, Boolean>();

    public static ArrayList<ArrayList<Double>> baseSpawners = new ArrayList<ArrayList<Double>>(List.of(
                new ArrayList<Double>(List.of(77.0, 66.0, -34.0)),
                new ArrayList<Double>(List.of(32.0, 66.0, -77.0)),
                new ArrayList<Double>(List.of(-34.0, 66.0, -77.0)),
                new ArrayList<Double>(List.of(-77.0, 66.0, -32.0)),
                new ArrayList<Double>(List.of(-77.0, 66.0, 34.0)),
                new ArrayList<Double>(List.of(-32.0, 66.0, 77.0)),
                new ArrayList<Double>(List.of(34.0, 66.0, 78.0)),
                new ArrayList<Double>(List.of(77.0, 66.0, 32.0))
            ));
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
    public static ArrayList<ArrayList<Double>> itemShops = new ArrayList<ArrayList<Double>>(List.of(
                new ArrayList<Double>(List.of(-74.0, 66.0, 29.0)),
                new ArrayList<Double>(List.of(-37.0, 66.0, 74.0)),
                new ArrayList<Double>(List.of(29.0, 66.0, 74.0)),
                new ArrayList<Double>(List.of(74.0, 66.0, 37.0)),
                new ArrayList<Double>(List.of(74.0, 66.0, -29.0)),
                new ArrayList<Double>(List.of(37.0, 66.0, -74.0)),
                new ArrayList<Double>(List.of(-29.0, 66.0, -74.0)),
                new ArrayList<Double>(List.of(-74.0, 66.0, -37.0))
            ));
    public static ArrayList<ArrayList<Double>> upgradeShops = new ArrayList<ArrayList<Double>>(List.of(
                new ArrayList<Double>(List.of(-74.0, 66.0, 39.0)),
                new ArrayList<Double>(List.of(-27.0, 66.0, 73.0)),
                new ArrayList<Double>(List.of(39.0, 66.0, 73.0)),
                new ArrayList<Double>(List.of(73.0, 66.0, 27.0)),
                new ArrayList<Double>(List.of(73.0, 66.0, -39.0)),
                new ArrayList<Double>(List.of(27.0, 66.0, -73.0)),
                new ArrayList<Double>(List.of(-39.0, 66.0, -73.0)),
                new ArrayList<Double>(List.of(-73.0, 66.0, -27.0))
            ));

    public static boolean inGame = false;
    public static int currentGame = 1;

    public static void startGame() {
        Game.inGame = true;            

        for (ArrayList<Double> coordinates: baseSpawners) {
            Spawner spawner = new Spawner(0, coordinates);
        }
        for (ArrayList<Double> coordinates: diamondSpawners) {
            Spawner spawner = new Spawner(1, coordinates);
        }
        for (ArrayList<Double> coordinates: emeraldSpawners) {
            Spawner spawner = new Spawner(2, coordinates);
        }

        for (int i = 0; i < itemShops.size(); i++) {
            Location itemShopLocation = new Location(Game.getWorld(), itemShops.get(i).get(0), itemShops.get(i).get(1), itemShops.get(i).get(2));
            Location teamUpgradesLocation = new Location(Game.getWorld(), upgradeShops.get(i).get(0), upgradeShops.get(i).get(1), upgradeShops.get(i).get(2));
            Villager itemShop = (Villager) Game.getWorld().spawnEntity(itemShopLocation, EntityType.VILLAGER);
            itemShop.setCustomName("Item Shop");
            Villager upgradeShop = (Villager) Game.getWorld().spawnEntity(teamUpgradesLocation, EntityType.VILLAGER);
            upgradeShop.setCustomName("Team Upgrades");
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
