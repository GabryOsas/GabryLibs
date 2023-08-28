package me.gabryosas.gabrylibs.api.skript;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Door;
import org.bukkit.event.Event;

public class CondBlockActivate extends Condition {

    Expression<Block> block;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parseResult) {
        block = (Expression<Block>) exprs[0];
        return true;
    }

    @Override
    public String toString(Event e, boolean debug) {
        return "block is activate";
    }

    @Override
    public boolean check(Event e) {
        Block b = block.getSingle(e);
        if(!isDoor(b)) {
            return false;
        }
        org.bukkit.block.data.type.Door door = (Door) b.getBlockData();
        return door.isOpen();
    }
    private static boolean isDoor(Block block){
        if (block.getType().toString().endsWith("_DOOR")){
            return true;
        }
        return false;
    }
}
