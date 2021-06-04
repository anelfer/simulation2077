package me.anelfer.simulation.actions.move;

import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.entities.сreature.PredatorCreature;
import me.anelfer.simulation.map.MapLocation;
import me.anelfer.simulation.map.MapSimulation;

public class PredatorMoveAction extends AbstractMoveAction {

    private final MapSimulation map;

    public PredatorMoveAction(MapSimulation map) {
        this.map = map;
    }

    @Override
    public void move() {
        System.out.println(map);

        for (SimulationEntity entity : map.values()) {
            if (entity instanceof PredatorCreature) {
                System.out.println(entity.getName() + entity.getLocation());
                MapLocation location = entity.getLocation();
                map.remove(entity.getLocation());
                map.putEntity(entity, location.getX() + 1, location.getY() - 5);
            }
        }
    }

}
