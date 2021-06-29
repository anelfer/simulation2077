package me.anelfer.simulation.actions.starve;

import me.anelfer.simulation.actions.AbstractAction;
import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.entities.сreature.AbstractCreature;
import me.anelfer.simulation.map.MapSimulation;
import me.anelfer.simulation.map.Simulation;

import java.util.ArrayList;
import java.util.List;

public class AbstractStarveAction extends AbstractAction {

    private final Class<?> entityClass;
    private final MapSimulation map;

    public AbstractStarveAction(MapSimulation map, Class<?> entityClass) {
        this.map = map;
        this.entityClass = entityClass;
    }

    @Override
    public void perform() {
        List<AbstractCreature> entities = new ArrayList<>();

        for (SimulationEntity entity : map.values()) {
            if (entity.getType() == entityClass) {
                entities.add((AbstractCreature) entity);
            }
        }

        for (AbstractCreature entity : entities) {
            entity.getHealth().takeDamage(entity.getHealth().getMax() / Integer.parseInt(Simulation.getProperty().getProperty("hp.starve")));
        }
    }

}
