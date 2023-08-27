package me.gabryosas.gabrylibs.api.skript;


import ch.njol.skript.classes.Changer;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public class ExprSkullOfPlayer extends SimpleExpression<ItemStack> {

    private Expression<String> nameExpr;
    private Expression<Player> playerExpr;

    @Override
    public Class<? extends ItemStack> getReturnType() {
        return ItemStack.class;
    }
    @Override
    public boolean isSingle() {
        return true;
    }


    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parser) {
        nameExpr = (Expression<String>) exprs[0];
        playerExpr = (Expression<Player>) exprs[1];
        return true;
    }

    @Override
    public String toString(Event e, boolean debug) {
        return "new skull named " + nameExpr.toString(e, debug) + " of " + playerExpr.toString(e, debug);
    }
    @Override
    protected ItemStack[] get(Event e) {
        String name = nameExpr.getSingle(e);
        return new ItemStack[] { createSkull(name) };
}

    @Override
    public Class<?>[] acceptChange(Changer.ChangeMode mode) {
        return null;
    }
    public static ItemStack createSkull(String url) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
        if (url.isEmpty()) return head;

        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);

        profile.getProperties().put("textures", new Property("textures", url));

        try {
            Field profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);

        } catch (IllegalArgumentException | NoSuchFieldException | SecurityException | IllegalAccessException error) {
            error.printStackTrace();
        }
        head.setItemMeta(headMeta);
        return head;
    }
}