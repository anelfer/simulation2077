package me.anelfer.simulation.entities.сreature;

import lombok.Getter;
import lombok.Setter;
import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.map.MapLocation;
import me.anelfer.simulation.map.MapSimulation;


public abstract class AbstractCreature extends SimulationEntity {

    @Getter @Setter
    private int speed;

    @Getter @Setter
    private int health;

    @Getter
    private final String gender;

    public AbstractCreature(String name, int speed, int health, String gender, MapLocation location) {
        super(name, location);
        this.speed = speed;
        this.health = health;
        this.gender = gender;
    }

    public abstract void makeMove(MapSimulation map);

}
