package bedwars;

import java.util.*;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Spawner {
    ArrayList<Double> coordinates;

    public Spawner(int type, ArrayList<Double> coordinates) {
        this.coordinates = coordinates;

        if (type == 0) {
            startBaseSpawn();
        }
        
        else if (type == 1) {
            startDiamondSpawn();
        }
        else if (type == 2) {
            startEmeraldSpawn();
        }
    }

    public synchronized void startBaseSpawn() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("Bedwars"), new Runnable(){
            public void run() {
                Location location = new Location(Game.getWorld(), coordinates.get(0), coordinates.get(1), coordinates.get(2));
                ItemStack stack = new ItemStack(Material.IRON_INGOT);
                Game.getWorld().dropItem(location, stack);
            }
        }, 10L, 20L);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("Bedwars"), new Runnable(){
            public void run() {
                Location location = new Location(Game.getWorld(), coordinates.get(0), coordinates.get(1), coordinates.get(2));
                ItemStack stack = new ItemStack(Material.GOLD_INGOT);
                Game.getWorld().dropItem(location, stack);
            }
        }, 10L, 80L);

    }

    public synchronized void startDiamondSpawn() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("Bedwars"), new Runnable(){
            public void run() {
                Location location = new Location(Game.getWorld(), coordinates.get(0), coordinates.get(1), coordinates.get(2));
                ItemStack stack = new ItemStack(Material.DIAMOND);
                Game.getWorld().dropItem(location, stack);
            }
        }, 10L, 600L);
    }

    public synchronized void startEmeraldSpawn() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("Bedwars"), new Runnable(){
            public void run() {
                Location location = new Location(Game.getWorld(), coordinates.get(0), coordinates.get(1), coordinates.get(2));
                ItemStack stack = new ItemStack(Material.EMERALD);
                Game.getWorld().dropItem(location, stack);
            }
        }, 10L, 1200L);
    }
}    
