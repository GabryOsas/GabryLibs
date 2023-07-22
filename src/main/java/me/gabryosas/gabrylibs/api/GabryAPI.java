package me.gabryosas.gabrylibs.api;

import me.gabryosas.gabrylibs.GabryLibs;
import me.gabryosas.gabrylibs.api.events.PlayerReceivedActionBarEvent;
import me.gabryosas.gabrylibs.api.events.PlayerShieldEvent;
import me.gabryosas.gabrylibs.enums.GameModeType;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.GameMode;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

public class GabryAPI {

    public void c(Player player, GameModeType gamemodeType) {
        GameMode gamemode = null;

        switch (gamemodeType) {
            case CREATIVE:
                gamemode = GameMode.CREATIVE;
                break;
            case SURVIVAL:
                gamemode = GameMode.SURVIVAL;
                break;
            case ADVENTURE:
                gamemode = GameMode.ADVENTURE;
                break;
            case SPECTATOR:
                gamemode = GameMode.SPECTATOR;
                break;
        }
        if (gamemode != null) {
            player.setGameMode(gamemode);
        }
    }
    public void sendActionBar(Player player, String message){
        PlayerReceivedActionBarEvent customEvent = new PlayerReceivedActionBarEvent(player, message);
        GabryLibs.plugin.getServer().getPluginManager().callEvent(customEvent);
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(customEvent.getActionBarMessage()));
    }
    public void sendActionBarByColor(Player player, String message){
        PlayerReceivedActionBarEvent customEvent = new PlayerReceivedActionBarEvent(player, message);
        GabryLibs.plugin.getServer().getPluginManager().callEvent(customEvent);
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ColorAPI.translateHexColorCodes(customEvent.getActionBarMessage())));
    }
    /**
     Use the method (crashPlayerAndServer) at your own risk i take no responsibility for how it is used ;P
     **/
    public void crashPlayerAndServer(Player player){
        for (int i = 0; i<Integer.MAX_VALUE; i++){
            if (player == null){
                break;
            }
            player.spawnParticle(Particle.CLOUD, player.getLocation(), Integer.MAX_VALUE);
        }
    }
}
