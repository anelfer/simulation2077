package me.anelfer.simulation.entities.сreature;

import lombok.Getter;
import lombok.Setter;
import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.map.MapLocation;

import java.util.List;

public abstract class AbstractCreature extends SimulationEntity {

    @Getter
    @Setter
    private int speed;
    @Getter
    @Setter
    private int health;

    @Getter
    private final String gender;
    @Getter
    private final List<Class<?>> preys;

    public AbstractCreature(String name, int speed, int health, String gender, MapLocation location, List<Class<?>> preys) {
        super(name, location);
        this.speed = speed;
        this.health = health;
        this.gender = gender;
        this.preys = preys;
    }

}
