package bedwars.listeners;

import bedwars.BedwarsPlayer;
import bedwars.PluginCore;
import bedwars.Game;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class BlockBreakEventListener implements Listener {
    public BlockBreakEventListener(PluginCore plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }    
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (Game.inGame) {
            switch (event.getBlock().getType()) {
                case RED_BED:
                    if (Game.beds.containsKey(Game.colors.indexOf("Red"))) {
                        Bukkit.broadcastMessage("RED BED DESTROYED!!!");    
                        Game.beds.replace(Game.colors.indexOf("Red"), false);
                    }
                    break;
                case BLUE_BED:
                    if (Game.beds.containsKey(Game.colors.indexOf("Blue"))) {
                        Bukkit.broadcastMessage("BLUE BED DESTROYED!!!");    
                        Game.beds.replace(Game.colors.indexOf("Blue"), false);
                    }
                    break;
                case GREEN_BED:
                    if (Game.beds.containsKey(Game.colors.indexOf("Green"))) {
                        Bukkit.broadcastMessage("GREEN BED DESTROYED!!!");    
                        Game.beds.replace(Game.colors.indexOf("Green"), false);
                    }
                    break;
                case YELLOW_BED:
                    if (Game.beds.containsKey(Game.colors.indexOf("Yellow"))) {
                        Bukkit.broadcastMessage("YELLOW BED DESTROYED!!!");    
                        Game.beds.replace(Game.colors.indexOf("Yellow"), false);
                    }
                    break;
                case CYAN_BED:
                    if (Game.beds.containsKey(Game.colors.indexOf("Cyan"))) {
                        Bukkit.broadcastMessage("CYAN BED DESTROYED!!!");    
                        Game.beds.replace(Game.colors.indexOf("Cyan"), false);
                    }
                    break;
                case WHITE_BED:
                    if (Game.beds.containsKey(Game.colors.indexOf("White"))) {
                        Bukkit.broadcastMessage("WHITE BED DESTROYED!!!");    
                        Game.beds.replace(Game.colors.indexOf("White"), false);
                    }
                    break;
                case PINK_BED:
                    if (Game.beds.containsKey(Game.colors.indexOf("Pink"))) {
                        Bukkit.broadcastMessage("PINK BED DESTROYED!!!");    
                        Game.beds.replace(Game.colors.indexOf("Pink"), false);
                    }
                    break;
                case GRAY_BED:
                    if (Game.beds.containsKey(Game.colors.indexOf("Gray"))) {
                        Bukkit.broadcastMessage("GRAY BED DESTROYED!!!");    
                        Game.beds.replace(Game.colors.indexOf("Gray"), false);
                    }
                    break;
            }
        }
    }
}
