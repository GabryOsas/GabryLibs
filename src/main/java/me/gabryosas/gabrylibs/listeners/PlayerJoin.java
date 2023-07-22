package me.gabryosas.gabrylibs.listeners;

import me.gabryosas.gabrylibs.GabryLibs;
import me.gabryosas.gabrylibs.api.events.PlayerFirstJoinEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        if (player.hasPlayedBefore()) return;
        PlayerFirstJoinEvent customEvent = new PlayerFirstJoinEvent(player, e.getJoinMessage());
        GabryLibs.plugin.getServer().getPluginManager().callEvent(customEvent);
        e.setJoinMessage(customEvent.getJoinMessage());
    }
}
