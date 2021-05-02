package bedwars;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

public class Trades {
    // Trades are added in the form: new Trade(Trade_Name, Material for player to recieve, amount to recieve, Material for player to give, amount to give)
    public static ArrayList<Trade> trades = new ArrayList<Trade>(List.of(
                new Trade("Fireball", Material.FIRE_CHARGE, 1, Material.IRON_INGOT, 4),
                new Trade("White Wool", Material.WHITE_WOOL, 1, Material.IRON_INGOT, 1)
    ));

    public static Trade getTrade(Material material) {
        for (Trade trade: trades) {
            if (trade.get == material) return trade;
        }
        // Should never happen
        return null;
    }
}
