package me.gabryosas.gabrylibs.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerFirstJoinEvent extends Event {

        private static final HandlerList handlers = new HandlerList();
        private Player player;
        private String joinMessage;

        public PlayerFirstJoinEvent(Player player, String joinMessage) {
            this.player = player;
            this.joinMessage = joinMessage;
        }

        public Player getPlayer() {
            return player;
        }

        public String getJoinMessage() {
            return joinMessage;
        }

        public void setJoinMessage(String joinMessage) {
            this.joinMessage = joinMessage;
        }

        @Override
        public HandlerList getHandlers() {
            return handlers;
        }

        public static HandlerList getHandlerList() {
            return handlers;
        }
    }