package me.anelfer.simulation.entities;

import lombok.Getter;
import lombok.Setter;
import me.anelfer.simulation.map.MapLocation;

@Getter
@Setter
public abstract class SimulationEntity {

    private final String name;
    private MapLocation location;

    public SimulationEntity(String name, MapLocation location) {
        this.name = name;
        this.location = location;
    }

    public Class<?> getType() {
        return this.getClass();
    }

}
