package me.anelfer.simulation.actions.move;

import me.anelfer.simulation.actions.AbstractAction;
import me.anelfer.simulation.actions.move.pathfinding.AStarFinding;
import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.entities.object.EmptyEntity;
import me.anelfer.simulation.entities.сreature.AbstractCreature;
import me.anelfer.simulation.entities.сreature.HP;
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
        if (Simulation.getCounter() < 2) {
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
            SimulationEntity entity = map.getSimulationEntity(aStarLoc);

            if (simulationEntity.getPreys().contains(map.getSimulationEntity(aStarLoc).getType())) {
                HP healthEntity =  ((AbstractCreature) entity).getHealth();
                HP healthSimulation = simulationEntity.getHealth();
                healthEntity.takeDamage(simulationEntity.getAttack());
                healthSimulation.heal(healthEntity.getMax() / 4);

                if (healthEntity.getCurrent() == 0) {
                    map.remove(aStarLoc);
                } else {
                    return;
                }

            }

            if (simulationEntity.getType() != entity.getType()) {
                map.remove(location);

                simulationEntity.setLocation(aStarLoc);
                map.putEntity(aStarLoc, simulationEntity);

                map.putEntity(location, new EmptyEntity(location));
            }

        }));
    }

    @Override
    public void perform() {
        move();
    }

}
