package me.anelfer.simulation.actions.spawn.object;

import me.anelfer.simulation.actions.spawn.AbstractSpawnAction;
import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.entities.object.RockEntity;
import me.anelfer.simulation.map.MapSimulation;

public class RockSpawnAction extends AbstractSpawnAction {

    public RockSpawnAction(int max, MapSimulation map) {
        super(max, map);
    }

    @Override
    public SimulationEntity createEntity() {
        return new RockEntity();
    }

}
