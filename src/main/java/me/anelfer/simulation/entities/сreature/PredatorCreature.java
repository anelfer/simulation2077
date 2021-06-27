package me.anelfer.simulation.entities.сreature;

import me.anelfer.simulation.map.MapLocation;

import java.util.List;

public class PredatorCreature extends AbstractCreature {

    {
        speed = 1;
        health = new HP(30);
        attack = 10;
    }

    public PredatorCreature(String gender, MapLocation location) {
        super("predator", gender, location, List.of(HerbivoreCreature.class));
    }

}
