package me.anelfer.simulation.actions.move;

import me.anelfer.simulation.actions.AbstractAction;
import me.anelfer.simulation.actions.move.pathfinding.AStarFinding;
import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.entities.object.EmptyEntity;
import me.anelfer.simulation.entities.сreature.AbstractCreature;
import me.anelfer.simulation.map.MapLocation;
import me.anelfer.simulation.map.MapSimulation;
import me.anelfer.simulation.map.Simulation;

import java.util.HashMap;

public abstract class AbstractMoveAction extends AbstractAction {

    private final MapSimulation map;
    private final Class<?> hunter;

    protected AbstractMoveAction(MapSimulation map, Class<?> hunter) {
        this.map = map;
        this.hunter = hunter;
    }

    public void move() {
        if(Simulation.getCounter() < 2) {
            return;
        }

        HashMap<AbstractCreature, MapLocation> entityMoveMap = new HashMap<>();

        for (SimulationEntity entity : map.values()) {
            if (entity.getType() == hunter) {
                entityMoveMap.put((AbstractCreature) entity, entity.getLocation());
            }
        }

        entityMoveMap.forEach(((simulationEntity, location) -> {
            AStarFinding starFinding = new AStarFinding(map, simulationEntity);
            MapLocation aStarLoc = starFinding.start();

            if (simulationEntity.getPreys().contains(map.getSimulationEntity(aStarLoc).getType())) {
                map.remove(aStarLoc);
            }

            map.remove(location);

            simulationEntity.setLocation(aStarLoc);
            map.putEntity(aStarLoc, simulationEntity);

            map.putEntity(location, new EmptyEntity(location));
        }));
    }

    @Override
    public void perform() {
        move();
    }

}
