package me.anelfer.simulation.entities.сreature;

import me.anelfer.simulation.map.MapLocation;

import java.util.List;

public class HerbivoreCreature extends AbstractCreature {

    {
        speed = 1;
        health = new HP(15);
        attack = 5;
    }

    public HerbivoreCreature(String gender, MapLocation location) {
        super("herbivore", gender, location, List.of(GrassEntity.class));
    }

}
