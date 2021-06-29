package me.anelfer.simulation.actions.starve;

import me.anelfer.simulation.entities.сreature.PredatorCreature;
import me.anelfer.simulation.map.MapSimulation;

public class PredatorStarveAction extends AbstractStarveAction {

    public PredatorStarveAction(MapSimulation map) {
        super(map, PredatorCreature.class);
    }
}
