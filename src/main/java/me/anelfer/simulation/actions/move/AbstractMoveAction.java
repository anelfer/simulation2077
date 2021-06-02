package me.anelfer.simulation.actions.move;

import me.anelfer.simulation.actions.AbstractAction;
import me.anelfer.simulation.map.MapSimulation;

public class AbstractMoveAction extends AbstractAction {

    private MapSimulation move() {
        return new MapSimulation(1, 1);
    }

    @Override
    public void perform() {

    }
}
