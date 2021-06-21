package me.anelfer.simulation.entities.сreature;

import me.anelfer.simulation.entities.object.GrassEntity;
import me.anelfer.simulation.entities.object.TreeEntity;
import me.anelfer.simulation.map.MapLocation;

import java.util.List;

public class HerbivoreCreature extends AbstractCreature {

    public HerbivoreCreature(int speed, int health, String gender, MapLocation location) {
        super("herbivore", speed, health, gender, location, List.of(TreeEntity.class, GrassEntity.class));
    }

    @Override
    public Class<?> getType() {
        return this.getClass();
    }

}
