package me.anelfer.simulation.actions.spawn.creature;

import me.anelfer.simulation.actions.spawn.AbstractSpawnAction;
import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.entities.сreature.PredatorCreature;
import me.anelfer.simulation.map.MapLocation;
import me.anelfer.simulation.map.MapSimulation;

public class PredatorSpawnAction extends AbstractSpawnAction {

    public PredatorSpawnAction(int max, MapSimulation map) {
        super(max, map);
    }

    @Override
    public SimulationEntity createEntity(MapLocation location) {
        return new PredatorCreature("female", location);
    }

    @Override
    public Class<?> getEntityClass() {
        return PredatorCreature.class;
    }

}
