package me.gabryosas.gabrylibs;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.util.SimpleEvent;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import me.gabryosas.gabrylibs.api.events.PlayerShieldEvent;
import me.legofreak107.vehiclesplus.gui.vehicles.VehicleGUI;
import me.legofreak107.vehiclesplus.gui.vehicles.VehicleGarageGUI;
import me.legofreak107.vehiclesplus.vehicles.api.events.VehicleEnterEvent;
import me.legofreak107.vehiclesplus.vehicles.api.events.VehicleLeaveEvent;
import me.legofreak107.vehiclesplus.vehicles.vehicles.objects.SpawnedVehicle;
import org.bukkit.entity.Player;

public class CustomSimpleEvents {
    protected static void onRegisterCustomEvents(){
        Skript.registerEvent("Player Enter Vehicle Plus", SimpleEvent.class, VehicleEnterEvent.class, "[vehicle name] [player] enter[ed] vehicle plus");
        EventValues.registerEventValue(VehicleEnterEvent.class, Player.class, new Getter<Player, VehicleEnterEvent>() {
            @Override
            public Player get(VehicleEnterEvent e) {
                return e.getDriver();
            }
        }, 0);
        EventValues.registerEventValue(VehicleEnterEvent.class, SpawnedVehicle.class, new Getter<SpawnedVehicle, VehicleEnterEvent>() {
            @Override
            public SpawnedVehicle get(VehicleEnterEvent e) {
                return (SpawnedVehicle) e.getVehicle();
            }
        }, 0);
        Skript.registerEvent("Player Left Vehicle Plus", SimpleEvent.class, VehicleLeaveEvent.class, "[player] left vehicle plus");
        EventValues.registerEventValue(VehicleLeaveEvent.class, Player.class, new Getter<Player, VehicleLeaveEvent>() {
            @Override
            public Player get(VehicleLeaveEvent e) {
                return e.getDriver();
            }
        }, 0);
        Skript.registerEvent("Player Shield", SimpleEvent.class, PlayerShieldEvent.class, "[player] player shield");
        EventValues.registerEventValue(PlayerShieldEvent.class, Player.class, new Getter<Player, PlayerShieldEvent>() {
            @Override
            public Player get(PlayerShieldEvent e) {
                return e.getPlayer();
            }
        }, 0);
    }
}
