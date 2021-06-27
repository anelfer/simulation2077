package me.anelfer.simulation.entities.object;

import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.map.MapLocation;

public class EmptyEntity extends SimulationEntity {

    public EmptyEntity(MapLocation location) {
        super("empty", location);
    }

}
