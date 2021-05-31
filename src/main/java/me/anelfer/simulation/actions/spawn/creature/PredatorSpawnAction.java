package me.anelfer.simulation.actions.spawn.creature;

import me.anelfer.simulation.actions.spawn.AbstractSpawnAction;
import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.entities.сreature.PredatorCreature;
import me.anelfer.simulation.map.MapSimulation;

public class PredatorSpawnAction extends AbstractSpawnAction {

    public PredatorSpawnAction(int max, MapSimulation map) {
        super(max, map);
    }

    @Override
    public SimulationEntity createEntity() {
        return new PredatorCreature(2, 30, "female");
    }

}
