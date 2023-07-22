package me.gabryosas.gabrylibs.api;

import org.bukkit.plugin.Plugin;

public class SpamAPI {
    /**
     Use the method (spamMessage) at your own risk i take no responsibility for how it is used ;P
     **/
    public static void spamMessage(String message, int value, Plugin plugin){
        for (int i = 0; i < value; i++){
            plugin.getServer().getConsoleSender().sendMessage(ColorAPI.translateHexColorCodes(message));
        }
    }
}
