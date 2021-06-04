package me.anelfer.simulation.actions.spawn.object;

import me.anelfer.simulation.actions.spawn.AbstractSpawnAction;
import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.entities.object.RockEntity;
import me.anelfer.simulation.map.MapLocation;
import me.anelfer.simulation.map.MapSimulation;

public class RockSpawnAction extends AbstractSpawnAction {

    public RockSpawnAction(int max, MapSimulation map) {
        super(max, map);
    }

    @Override
    public SimulationEntity createEntity(MapLocation location) {
        return new RockEntity(location);
    }

    @Override
    public Class<?> getEntityClass() {
        return RockEntity.class;
    }

}
