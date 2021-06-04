package me.anelfer.simulation.entities.object;

import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.map.MapLocation;

public class TreeEntity extends SimulationEntity {

    public TreeEntity(MapLocation location) {
        super("tree", location);
    }

    @Override
    public Class<?> getType() {
        return this.getClass();
    }

}
