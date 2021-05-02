package bedwars.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import bedwars.PluginCore;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;

public class FireballEventListener implements Listener {
    public FireballEventListener(PluginCore plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (player.getItemInHand().getType() == Material.FIRE_CHARGE) {
            event.setCancelled(true);
            Fireball fireball = player.getWorld().spawn(event.getPlayer().getLocation().add(new Vector(0.0D, 2.0D, 0.0D)), Fireball.class);
            fireball.setBounce(true);
            fireball.setShooter(player);
            fireball.setYield(2.0f);
        }
    }
}
