package me.anelfer.simulation.actions.spawn;

import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.entities.object.RockEntity;
import me.anelfer.simulation.map.MapSimulation;

public class RockSpawnAction extends AbstractSpawnAction {

    public RockSpawnAction(int max, MapSimulation map) {
        super(map, max);
    }

    @Override
    public SimulationEntity createEntity() {
        return new RockEntity();
    }

}
