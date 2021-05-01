package bedwars.listeners;

import bedwars.BedwarsPlayer;
import bedwars.PluginCore;
import bedwars.Game;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class RespawnEventListener implements Listener {
    public RespawnEventListener(PluginCore plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }    
    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        BedwarsPlayer player = Game.getPlayer(event.getPlayer());
        if (player.inGame == true && !(Game.checkBed(player.team))) event.getPlayer().setGameMode(GameMode.SPECTATOR);
        if (player.inGame == true && Game.checkBed(player.team)) event.getPlayer().getInventory().addItem(new ItemStack(Material.WOODEN_SWORD));
        event.setRespawnLocation(new Location(event.getPlayer().getWorld(), player.spawnX, player.spawnY, player.spawnZ));
        System.out.println(event.getPlayer().getWorld());
    }
}
