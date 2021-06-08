package me.anelfer.simulation.actions.move;

import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.entities.сreature.PredatorCreature;
import me.anelfer.simulation.map.MapLocation;
import me.anelfer.simulation.map.MapSimulation;
import me.anelfer.simulation.map.Simulation;

import java.util.HashMap;

public class PredatorMoveAction extends AbstractMoveAction {

    private final MapSimulation map;

    public PredatorMoveAction(MapSimulation map) {
        this.map = map;
    }

    @Override
    public void move() {
        if(Simulation.getCounter() < 2) {
            return;
        }

        HashMap<SimulationEntity, MapLocation> entityMoveMap = new HashMap<>();

        for (SimulationEntity entity : map.values()) {
            if (entity.getType() == PredatorCreature.class) {
                entityMoveMap.put(entity, entity.getLocation());
            }
        }

        entityMoveMap.forEach(((simulationEntity, location) -> {
            map.remove(location);

            int locX = location.getX() + 1;
            int locY = location.getY() + 1;

            if(locX > Simulation.getX() || locY > Simulation.getY() || locX < 0 || locY < 0) {
                return;
            }

            simulationEntity.setLocation(new MapLocation(locX, locY));
            map.putEntity(locX, locY, simulationEntity);
        }));
    }

}
