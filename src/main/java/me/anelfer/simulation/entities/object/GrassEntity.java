package me.anelfer.simulation.entities.object;

import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.map.MapLocation;

public class GrassEntity extends SimulationEntity {

    public GrassEntity(MapLocation location) {
        super("grass", location);
    }

    @Override
    public Class<?> getType() {
        return this.getClass();
    }

}
