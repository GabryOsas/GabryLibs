package me.gabryosas.gabrylibs.api.skript;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import me.legofreak107.vehiclesplus.gui.vehicles.VehicleGarageGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class EffGarageGUI extends Effect {

    private Expression<Player> giocatoreExpr;

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parseResult) {
        giocatoreExpr = (Expression<Player>) exprs[0];
        return true;
    }

    @Override
    protected void execute(Event e) {
        Player giocatore = giocatoreExpr.getSingle(e);
        if (giocatore != null) {
            VehicleGarageGUI.open(giocatore);
        }
    }
    @Override
    public String toString(Event e, boolean debug) {
        return "open garage to " + giocatoreExpr.toString(e, debug);
    }
}