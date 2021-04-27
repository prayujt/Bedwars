package bedwars;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import java.util.HashMap;

import bedwars.commands.StartCommand;
import bedwars.listeners.RespawnEventListener;

public class PluginCore extends JavaPlugin {

    @Override
    public void onEnable(){
        //When server plugin is first enabled
        this.getCommand("start").setExecutor(new StartCommand());
        RespawnEventListener spawnListener = new RespawnEventListener(this);
        
    }

    @Override
    public void onDisable(){
        //Fired when the server stops and disables all plugins
    }

}
