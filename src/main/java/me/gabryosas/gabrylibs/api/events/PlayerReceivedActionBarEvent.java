package me.gabryosas.gabrylibs.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerReceivedActionBarEvent extends Event {
    /**
     This event only works with methods sendActionBar and sendActionBarByColor.
     **/
    private static final HandlerList handlers = new HandlerList();
    private Player player;
    private String actionBarMessage;

    public PlayerReceivedActionBarEvent(Player player, String actionBarMessage) {
        this.player = player;
        this.actionBarMessage = actionBarMessage;
    }

    public Player getPlayer() {
        return player;
    }

    public String getActionBarMessage() {
        return actionBarMessage;
    }

    public void setActionBarMessage(String actionBarMessage) {
        this.actionBarMessage = actionBarMessage;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}