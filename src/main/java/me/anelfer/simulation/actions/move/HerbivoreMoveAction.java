package me.anelfer.simulation.actions.move;

import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.entities.сreature.HerbivoreCreature;
import me.anelfer.simulation.entities.сreature.PredatorCreature;
import me.anelfer.simulation.map.MapLocation;
import me.anelfer.simulation.map.MapSimulation;
import me.anelfer.simulation.map.Simulation;

import java.util.HashMap;

public class HerbivoreMoveAction extends AbstractMoveAction {

    private final MapSimulation map;

    public HerbivoreMoveAction(MapSimulation map) {
        this.map = map;
    }

    @Override
    public void move() {
        if(Simulation.getCounter() < 2) {
            return;
        }

        HashMap<SimulationEntity, MapLocation> entityMoveMap = new HashMap<>();

        for (SimulationEntity entity : map.values()) {
            if (entity.getType() == HerbivoreCreature.class) {
                entityMoveMap.put(entity, entity.getLocation());
            }
        }

        entityMoveMap.forEach(((simulationEntity, location) -> {
            map.remove(location);

            int locX = location.getX() - 2;
            int locY = location.getY();

            if(locX > Simulation.getX() || locY > Simulation.getY() || locX < 0 || locY < 0) {
                return;
            }

            simulationEntity.setLocation(new MapLocation(locX, locY));
            map.putEntity(locX, locY, simulationEntity);
        }));
    }
}
