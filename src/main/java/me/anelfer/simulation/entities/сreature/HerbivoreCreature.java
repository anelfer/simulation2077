package me.anelfer.simulation.entities.сreature;

import me.anelfer.simulation.map.MapLocation;

import java.util.List;

public class HerbivoreCreature extends AbstractCreature {

    public HerbivoreCreature(int speed, HP health, int attack, String gender, MapLocation location) {
        super("herbivore", speed, health, attack, gender, location, List.of(GrassEntity.class));
    }

    @Override
    public Class<?> getType() {
        return this.getClass();
    }

}
