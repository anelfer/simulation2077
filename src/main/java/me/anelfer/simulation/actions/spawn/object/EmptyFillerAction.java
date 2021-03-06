package me.anelfer.simulation.actions.spawn.object;

import me.anelfer.simulation.actions.AbstractAction;
import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.entities.object.EmptyEntity;
import me.anelfer.simulation.map.MapLocation;
import me.anelfer.simulation.map.MapSimulation;
import me.anelfer.simulation.map.Simulation;

public class EmptyFillerAction extends AbstractAction {

    private final MapSimulation map;

    public EmptyFillerAction(MapSimulation map) {
        this.map = map;
    }

    @Override
    public void perform() {
        for (int y = 0; y < Simulation.Y; y++) {
            for (int x = 0; x < Simulation.X; x++) {
                if (map.isCellEmpty(x, y)) {
                    map.putEntity(x, y, createEntity(new MapLocation(x, y)));
                }
            }
        }
    }

    public SimulationEntity createEntity(MapLocation location) {
        return new EmptyEntity(location);
    }

}
