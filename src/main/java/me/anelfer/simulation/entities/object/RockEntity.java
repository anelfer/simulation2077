package me.anelfer.simulation.entities.object;

import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.map.MapLocation;

public class RockEntity extends SimulationEntity {

    private final int wall = 1; //0 - notWall 1 - wall, 2 - edible

    public RockEntity(MapLocation location) {
        super("rock", location);
    }

    @Override
    public Class<?> getType() {
        return this.getClass();
    }

}
