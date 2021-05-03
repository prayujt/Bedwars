package bedwars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class Trades {
    private static Map<Enchantment, Integer> blank = new HashMap<Enchantment, Integer>();

    // Trades are added in the form: new Trade(Trade_Name, Material for player to recieve, amount to recieve, Material for player to give, amount to give)
    public static ArrayList<Trade> trades = new ArrayList<Trade>(List.of(
                new Trade("Fireball", Material.FIRE_CHARGE, 1, Material.IRON_INGOT, 40, blank),
                new Trade("Iron Sword", Material.IRON_SWORD, 1, Material.IRON_INGOT, 30, blank),
                new Trade("Iron Chestplate", Material.IRON_CHESTPLATE, 1, Material.IRON_INGOT, 20, blank),
                new Trade("Iron Leggings", Material.IRON_LEGGINGS, 1, Material.IRON_INGOT, 15, blank),
                new Trade("Iron Helmet", Material.IRON_HELMET, 1, Material.IRON_INGOT, 10, blank),
                new Trade("Iron Boots", Material.IRON_BOOTS, 1, Material.IRON_INGOT, 10, blank),
                new Trade("Golden Apple", Material.IRON_HELMET, 1, Material.GOLD_INGOT, 10, blank),
                new Trade("Bow", Material.BOW, 1, Material.GOLD_INGOT, 12, blank),
                new Trade("Arrow", Material.SPECTRAL_ARROW, 8, Material.GOLD_INGOT, 2, blank),
                new Trade("Emerald Bow", Material.BOW, 1, Material.GOLD_INGOT, 2, new HashMap<Enchantment, Integer>(Map.of(Enchantment.ARROW_KNOCKBACK, 2, Enchantment.DURABILITY, 2, Enchantment.ARROW_DAMAGE, 2)))
    ));

    public static Trade getTrade(String displayName) {
        for (Trade trade: trades) {
            if (trade.name.equals(displayName)) return trade;
        }
        // Should never happen
        return null;
    }
}
