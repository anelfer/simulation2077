package me.anelfer.simulation.actions.spawn.object;

import me.anelfer.simulation.actions.spawn.AbstractSpawnAction;
import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.entities.object.TreeEntity;
import me.anelfer.simulation.map.MapLocation;
import me.anelfer.simulation.map.MapSimulation;

public class TreeSpawnAction extends AbstractSpawnAction {

    public TreeSpawnAction(int max, MapSimulation map) {
        super(max, map);
    }

    @Override
    public SimulationEntity createEntity(MapLocation location) {
        return new TreeEntity(location);
    }

    @Override
    public Class<?> getEntityClass() {
        return TreeEntity.class;
    }

}
