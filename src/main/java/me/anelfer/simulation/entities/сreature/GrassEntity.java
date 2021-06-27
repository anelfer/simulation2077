package me.anelfer.simulation.entities.сreature;

import me.anelfer.simulation.map.MapLocation;

import java.util.Collections;

public class GrassEntity extends AbstractCreature {

    {
        speed = 0;
        health = new HP(15);
        attack = 0;
    }

    public GrassEntity(String gender, MapLocation location) {
        super("grass", gender, location, Collections.emptyList());
    }

}
