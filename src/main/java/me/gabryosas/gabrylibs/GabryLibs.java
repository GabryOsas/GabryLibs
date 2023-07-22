package me.gabryosas.gabrylibs;

import me.gabryosas.gabrylibs.api.GabryAPI;
import me.gabryosas.gabrylibs.api.SpamAPI;
import me.gabryosas.gabrylibs.listeners.PlayerInteractEvent;
import me.gabryosas.gabrylibs.listeners.PlayerJoin;
import org.bukkit.plugin.java.JavaPlugin;

public final class GabryLibs extends JavaPlugin {
    public static GabryLibs plugin;
    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new PlayerInteractEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        SpamAPI.spamMessage("&cThis is not a plugin!", 20, this);
        getPluginLoader().disablePlugin(this);
    }

    @Override
    public void onDisable() {
    }
}
