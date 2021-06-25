package me.anelfer.simulation.entities.сreature;

import me.anelfer.simulation.map.MapLocation;

import java.util.List;

public class GrassEntity extends AbstractCreature {

    public GrassEntity(int speed, HP health, int attack, String gender, MapLocation location) {
        super("grass", speed, health, attack, gender, location, List.of());
    }

    @Override
    public Class<?> getType() {
        return this.getClass();
    }

}
