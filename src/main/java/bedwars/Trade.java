package bedwars;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

import java.util.Map;

public class Trade {
    public String name;
    public Material get;
    public int getAmount;
    public Material give;
    public int giveAmount;
    public Map<Enchantment, Integer> enchantments;

    public Trade(String name, Material get, int getAmount, Material give, int giveAmount, Map<Enchantment, Integer> enchantments) {
        this.name = name;
        this.get = get;
        this.getAmount = getAmount;
        this.give = give;
        this.giveAmount = giveAmount;
        this.enchantments = enchantments;
    }
}
