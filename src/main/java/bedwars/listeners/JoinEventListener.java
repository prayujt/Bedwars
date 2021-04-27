package bedwars.listeners;

import bedwars.BedwarsPlayer;
import bedwars.PluginCore;
import bedwars.Game;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEventListener implements Listener {
    public JoinEventListener(PluginCore plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }    
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        System.out.println("Player joined! " + event.getPlayer().getName());
        Game.onlinePlayers.add(event.getPlayer());
    }
}
