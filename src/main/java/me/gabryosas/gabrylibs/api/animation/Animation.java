package me.gabryosas.gabrylibs.api.animation;

import me.gabryosas.gabrylibs.api.GabryAPI;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Animation {
    private final Plugin plugin;
    private final Player player;
    private final String[] messages;
    private final int interval;
    private int currentIndex = 0;
    private BukkitRunnable task;

    public Animation(Plugin plugin, Player player, String[] messages, int interval) {
        this.plugin = plugin;
        this.player = player;
        this.messages = messages;
        this.interval = interval;
    }

    public void start() {
        if (task == null) {
            task = new BukkitRunnable() {
                @Override
                public void run() {
                    if (currentIndex >= messages.length) {
                        stop();
                        return;
                    }

                    GabryAPI gabryAPI = new GabryAPI();
                    gabryAPI.sendActionBarByColor(player, messages[currentIndex]);

                    currentIndex++;
                }
            };
            task.runTaskTimer(plugin, 0, interval);
        }
    }

    public void stop() {
        if (task != null) {
            task.cancel();
            task = null;
        }
    }
}