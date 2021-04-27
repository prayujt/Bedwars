package bedwars;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.*;

public class BedwarsPlayer {
    public int spawnX;
    public int spawnY;
    public int spawnZ;

    public String name;
    public int team;
    public boolean inGame;

    public BedwarsPlayer(String name, int team, int x, int y, int z) {
        this.name = name;
        this.team = team;
        inGame = true;
        spawnX = x;
        spawnY = y;
        spawnZ = z;
    }    

    public void teleport(int x, int y, int z) {
        getPlayer().teleport(new Location(Bukkit.getWorld("world"), x, y, z));
    }    

    public Player getPlayer() {
        for (Player p: Game.onlinePlayers) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        //Should never happen
        return null;
    }    
}    
