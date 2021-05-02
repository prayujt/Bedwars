package bedwars.listeners;

import bedwars.BedwarsPlayer;
import bedwars.PluginCore;
import bedwars.Game;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class VillagerInteractionEventListener implements Listener {
    public VillagerInteractionEventListener(PluginCore plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }    
    @EventHandler
    public void onVillagerInteraction(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        
        if(event.getRightClicked() instanceof Villager) {
            Villager villager = (Villager) event.getRightClicked();
            if(villager.getCustomName().equalsIgnoreCase("Item Shop")) {
                Inventory inventory = Bukkit.createInventory(null, 27, "Item Shop");

                // Wool
                addShopItem(inventory, 0, "Wool", getWool(player), 16);

                // Fireball
                addShopItem(inventory, 1, "Fireball", Material.FIRE_CHARGE, 1);


                player.openInventory(inventory);
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();
        String name = event.getView().getTitle();
        Material wool = getWool(player);

        if (name.equals("Item Shop")) {
            event.setCancelled(true);
            if (item.getType() == wool) {
                trade(player, Material.IRON_INGOT, 4, wool, 16);
            }
            else if (item.getType() == Material.FIRE_CHARGE) {
                trade(player, Material.IRON_INGOT, 4, Material.FIRE_CHARGE, 1);
            }
        }
    }

    public void addShopItem(Inventory inventory, int position, String name, Material material, int quantity) {
            ItemStack item = new ItemStack(material, quantity);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(name);
            item.setItemMeta(meta);
            inventory.setItem(position, item);
    }

    public Material getWool(Player player) {
        switch (Game.getPlayer(player).team) {
            case 0:
                return Material.GREEN_WOOL;                
            case 1:
                return Material.RED_WOOL;                
            case 2:
                return Material.PINK_WOOL;
            case 3:
                return Material.CYAN_WOOL;
            default:
                return Material.WHITE_WOOL;
        }
    }

    public void trade(Player player, Material give, int giveAmount, Material get, int getAmount) {
        if (player.getInventory().contains(give, giveAmount)) {
            removeItems(player.getInventory(), give, giveAmount);
            player.getInventory().addItem(new ItemStack(get, getAmount));
        }
        else player.sendMessage("Not enough!");
    }
    
    public static void removeItems(Inventory inventory, Material type, int amount) {
        if (amount <= 0) return;
        int size = inventory.getSize();
        for (int slot = 0; slot < size; slot++) {
            ItemStack is = inventory.getItem(slot);
            if (is == null) continue;
            if (type == is.getType()) {
                int newAmount = is.getAmount() - amount;
                if (newAmount > 0) {
                    is.setAmount(newAmount);
                    break;
                }
                else {
                    inventory.clear(slot);
                    amount = -newAmount;
                    if (amount == 0) break;
                }
            }
        }
    }
}
