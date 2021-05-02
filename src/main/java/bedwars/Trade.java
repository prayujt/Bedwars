package bedwars;

import org.bukkit.Material;

public class Trade {
    public String name;
    public Material get;
    public int getAmount;
    public Material give;
    public int giveAmount;

    public Trade(String name, Material get, int getAmount, Material give, int giveAmount) {
        this.name = name;
        this.get = get;
        this.getAmount = getAmount;
        this.give = give;
        this.giveAmount = giveAmount;
    }
}
