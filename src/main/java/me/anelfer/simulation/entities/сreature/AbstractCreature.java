package me.anelfer.simulation.entities.сreature;

import lombok.Getter;
import lombok.Setter;
import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.map.MapLocation;

import java.util.List;

@Getter
@Setter
public abstract class AbstractCreature extends SimulationEntity {

    protected int speed;
    protected HP health;
    protected int attack;
    private final String gender;
    private final List<Class<?>> preys;

    public AbstractCreature(String name,
                            String gender,
                            MapLocation location,
                            List<Class<?>> preys) {
        super(name, location);
        this.gender = gender;
        this.preys = preys;
    }

}
