package me.anelfer.simulation.actions.move;

import me.anelfer.simulation.entities.сreature.PredatorCreature;
import me.anelfer.simulation.map.MapSimulation;

public class PredatorMoveAction extends AbstractMoveAction {

    public PredatorMoveAction(MapSimulation map) {
        super(map, PredatorCreature.class);
    }

}
