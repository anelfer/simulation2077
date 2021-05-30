package me.anelfer.simulation.map;

import me.anelfer.simulation.entities.SimulationEntity;

import java.util.HashMap;

public class MapSimulation extends HashMap<MapLocation, SimulationEntity> {

    public void putEntity(SimulationEntity entity, int row, int column) {
        this.put(new MapLocation(row, column), entity);
    }

    public SimulationEntity getMapSimulation(int row, int column) {
        return this.get(new MapLocation(row, column));
    }

}
