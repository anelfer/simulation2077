package me.anelfer.simulation.actions.move;

import me.anelfer.simulation.entities.сreature.HerbivoreCreature;
import me.anelfer.simulation.map.MapSimulation;

public class HerbivoreMoveAction extends AbstractMoveAction {

    public HerbivoreMoveAction(MapSimulation map) {
        super(map, HerbivoreCreature.class);
    }

}
