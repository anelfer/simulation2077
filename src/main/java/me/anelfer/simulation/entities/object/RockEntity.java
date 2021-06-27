package me.anelfer.simulation.entities.object;

import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.map.MapLocation;

public class RockEntity extends SimulationEntity {

    public RockEntity(MapLocation location) {
        super("rock", location);
    }

}
