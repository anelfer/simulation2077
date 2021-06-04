package me.anelfer.simulation.map;

import lombok.Getter;
import me.anelfer.simulation.entities.SimulationEntity;

import java.util.HashMap;

public class MapSimulation extends HashMap<MapLocation, SimulationEntity> {

    private final HashMap<Class<?>, Integer> entityCount = new HashMap<>();

    @Getter
    private final int X;
    @Getter
    private final int Y;

    public MapSimulation(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public void putEntity(SimulationEntity entity, int X, int Y) {
        if (entityCount.containsKey(entity.getType())) {
            int counter = entityCount.get(entity.getType()) + 1;
            entityCount.put(entity.getType(), counter);
        } else {
            entityCount.put(entity.getType(), 1);
        }

        this.put(new MapLocation(X, Y), entity);
    }

    public SimulationEntity getSimulationEntity(int X, int Y) {
        return this.get(new MapLocation(X, Y));
    }

    public int getEntityCount(Class<?> entityClass) {
        return entityCount.getOrDefault(entityClass, 0);
    }

}
