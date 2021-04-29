package bedwars;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import java.util.HashMap;

import bedwars.commands.ResetCommand;
import bedwars.commands.StartCommand;
import bedwars.listeners.BlockBreakEventListener;
import bedwars.listeners.JoinEventListener;
import bedwars.listeners.QuitEventListener;
import bedwars.listeners.RespawnEventListener;

public class PluginCore extends JavaPlugin {

    @Override
    public void onEnable(){
        // Fired when server plugin is first enabled
        this.getCommand("start").setExecutor(new StartCommand());
        this.getCommand("reset").setExecutor(new ResetCommand());
        RespawnEventListener spawnListener = new RespawnEventListener(this);
        JoinEventListener joinListener = new JoinEventListener(this);
        QuitEventListener quitListener = new QuitEventListener(this);
        BlockBreakEventListener blockBreakListener = new BlockBreakEventListener(this);
    }

    @Override
    public void onDisable(){
        // Fired when the server stops and disables all plugins
    }

}
