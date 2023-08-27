package me.gabryosas.gabrylibs;


import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import ch.njol.skript.lang.ExpressionType;
import me.gabryosas.gabrylibs.api.skript.ExprSkullOfPlayer;
import me.gabryosas.gabrylibs.listeners.PlayerInteractEvent;
import me.gabryosas.gabrylibs.listeners.PlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class GabryLibs extends JavaPlugin {
    public static GabryLibs plugin;
    private SkriptAddon addon;
    @Override
    public void onEnable() {
        addon = Skript.registerAddon(this);
        plugin = this;
        try {
            addon.loadClasses("me.gabryosas.gabrylibs");
        } catch (IOException e) {
            e.printStackTrace();
        }
        CustomSimpleEvents.onRegisterCustomEvents();
        Skript.registerExpression(ExprSkullOfPlayer.class, ItemStack.class, ExpressionType.SIMPLE, "new skull named %string% of %player%");
        getServer().getPluginManager().registerEvents(new PlayerInteractEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getLogger().info(ChatColor.GREEN + "[GABRYLIBS] Abilitato con successo!");
    }
    @Override
    public void onDisable() {
    }
}
