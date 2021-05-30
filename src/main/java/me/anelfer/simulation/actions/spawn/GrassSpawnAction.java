package me.anelfer.simulation.actions.spawn;

import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.entities.object.GrassEntity;
import me.anelfer.simulation.map.MapSimulation;

public class GrassSpawnAction extends AbstractSpawnAction{

    public GrassSpawnAction(int max, MapSimulation map) {
        super(map, max);
    }

    @Override
    public SimulationEntity createEntity() {
        return new GrassEntity();
    }
}
