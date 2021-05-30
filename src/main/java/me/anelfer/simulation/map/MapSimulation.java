package me.anelfer.simulation.map;

import lombok.Getter;
import me.anelfer.simulation.entities.SimulationEntity;

import java.util.HashMap;

public class MapSimulation extends HashMap<MapLocation, SimulationEntity> {

    @Getter
    private final int X;
    @Getter
    private final int Y;

    public MapSimulation(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public void putEntity(SimulationEntity entity, int row, int column) {
        this.put(new MapLocation(row, column), entity);
    }

    public SimulationEntity getMapSimulation(int row, int column) {
        return this.get(new MapLocation(row, column));
    }

}
