package bedwars.listeners;

import bedwars.BedwarsPlayer;
import bedwars.PluginCore;
import bedwars.Game;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Iterator;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEventListener implements Listener {
    public QuitEventListener(PluginCore plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }    
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        System.out.println("Player quit! " + event.getPlayer().getName());
        Iterator<Player> iter = Game.onlinePlayers.iterator();
        while (iter.hasNext()) {
            Player player = iter.next();
            if (player.getName().equals(event.getPlayer().getName())) iter.remove();
        }
        System.out.println(Game.onlinePlayers.toString());
    }
}
