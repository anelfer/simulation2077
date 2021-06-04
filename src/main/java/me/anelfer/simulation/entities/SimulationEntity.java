package me.anelfer.simulation.entities;

import lombok.Getter;
import lombok.Setter;
import me.anelfer.simulation.map.MapLocation;

public abstract class SimulationEntity {

    @Getter
    private final String name;

    @Getter
    @Setter
    private MapLocation location;

    public SimulationEntity(String name, MapLocation location) {
        this.name = name;
        this.location = location;
    }

    public abstract Class<?> getType();

}
