package me.gabryosas.gabrylibs.listeners;

import me.gabryosas.gabrylibs.GabryLibs;
import me.gabryosas.gabrylibs.api.events.PlayerShieldEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.EquipmentSlot;

public class PlayerInteractEvent implements Listener {
    @EventHandler
    public void onPlayerInteract(org.bukkit.event.player.PlayerInteractEvent e){
        Player player = (Player) e.getPlayer();
        Material mainHand = player.getInventory().getItemInMainHand().getType();
        Material offHand = player.getInventory().getItemInOffHand().getType();
        if (e.getAction() != Action.RIGHT_CLICK_BLOCK && e.getAction() != Action.RIGHT_CLICK_AIR) return;
        if ((mainHand == Material.SHIELD || offHand == Material.SHIELD)){
            PlayerShieldEvent customEvent = new PlayerShieldEvent(player);
            GabryLibs.plugin.getServer().getPluginManager().callEvent(customEvent);
        }
    }
}
