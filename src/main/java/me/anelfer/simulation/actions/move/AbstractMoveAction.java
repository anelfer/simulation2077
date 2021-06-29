package me.anelfer.simulation.actions.move;

import me.anelfer.simulation.actions.AbstractAction;
import me.anelfer.simulation.actions.move.pathfinding.BfsPathFinder;
import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.entities.object.EmptyEntity;
import me.anelfer.simulation.entities.сreature.AbstractCreature;
import me.anelfer.simulation.entities.сreature.HP;
import me.anelfer.simulation.map.MapLocation;
import me.anelfer.simulation.map.MapSimulation;
import me.anelfer.simulation.map.Simulation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public abstract class AbstractMoveAction extends AbstractAction {

    private final MapSimulation map;
    private final Class<?> creatureType;

    protected AbstractMoveAction(MapSimulation map, Class<?> creatureType) {
        this.map = map;
        this.creatureType = creatureType;
    }

    @Override
    public void perform() {
        if (Simulation.getMoveCounter() < 1) {
            return;
        }

        HashMap<AbstractCreature, MapLocation> entityMoveMap = new HashMap<>();

        for (SimulationEntity entity : map.values()) {
            if (entity.getType() == creatureType) {
                entityMoveMap.put((AbstractCreature) entity, entity.getLocation());
            }
        }

        entityMoveMap.forEach(((entity, previousLocation) -> {
            BfsPathFinder finding = new BfsPathFinder(map, entity);
            MapLocation newLocation = finding.getDestination();

            SimulationEntity prey = map.getSimulationEntity(newLocation);

            if (entity.getPreys().contains(map.getSimulationEntity(newLocation).getType())) {
                HP preyHP = ((AbstractCreature) prey).getHealth();
                HP healthSimulation = entity.getHealth();

                preyHP.takeDamage(entity.getAttack());
                healthSimulation.heal(preyHP.getMax() / Integer.parseInt(Simulation.getProperty().getProperty("hp.heal")));

                if (preyHP.getCurrent() == 0) {
                    map.remove(newLocation);
                } else {
                    return;
                }

            }

            map.remove(previousLocation);

            entity.setLocation(newLocation);
            map.putEntity(newLocation, entity);

            map.putEntity(previousLocation, new EmptyEntity(previousLocation));

        }));
    }

}
