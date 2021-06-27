package me.anelfer.simulation.map;

import lombok.Getter;
import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.entities.object.EmptyEntity;

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

    public void putEntity(int X, int Y, SimulationEntity entity) {
        putEntity(new MapLocation(X, Y), entity);
    }

    public void putEntity(MapLocation location, SimulationEntity entity) {
        if (this.containsKey(location)) {
            int count = entityCount.get(this.getSimulationEntity(location).getType()) - 1;
            entityCount.put(this.getSimulationEntity(location).getType(), count);
        }

        if (entityCount.containsKey(entity.getType())) {
            int counter = entityCount.get(entity.getType()) + 1;
            entityCount.put(entity.getType(), counter);
        } else {
            entityCount.put(entity.getType(), 1);
        }

        this.put(location, entity);
    }

    @Override
    public SimulationEntity remove(Object key) {
        int count = entityCount.get(this.getSimulationEntity((MapLocation) key).getType()) - 1;
        entityCount.put(this.getSimulationEntity((MapLocation) key).getType(), count);
        return super.remove(key);
    }

    public SimulationEntity getSimulationEntity(int X, int Y) {
        return this.get(new MapLocation(X, Y));
    }

    public SimulationEntity getSimulationEntity(MapLocation location) {
        return this.get(location);
    }

    public int getEntityCount(Class<?> entityClass) {
        return entityCount.getOrDefault(entityClass, 0);
    }

    @Override
    public void clear() {
        super.clear();
        entityCount.clear();
    }

    public boolean isCellEmpty(int x, int y) {
        if (!this.containsKey(new MapLocation(x, y))) {
            return true;
        } else {
            return this.getSimulationEntity(x, y).getType() == EmptyEntity.class;
        }
    }

}
