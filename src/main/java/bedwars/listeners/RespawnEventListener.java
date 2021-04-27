package bedwars.listeners;

import bedwars.BedwarsPlayer;
import bedwars.PluginCore;
import bedwars.Game;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnEventListener implements Listener {
    public RespawnEventListener(PluginCore plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }    
    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        BedwarsPlayer player = Game.getPlayer(event.getPlayer());
        event.setRespawnLocation(new Location(Bukkit.getWorld("world"), player.spawnX, player.spawnY, player.spawnZ));
    }
}
