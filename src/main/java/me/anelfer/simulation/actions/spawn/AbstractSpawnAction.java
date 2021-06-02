package me.anelfer.simulation.actions.spawn;

import me.anelfer.simulation.actions.AbstractAction;
import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.map.MapSimulation;

import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractSpawnAction extends AbstractAction {

    private final MapSimulation map;
    private final int max;

    public AbstractSpawnAction(int max, MapSimulation map) {
        this.max = max;
        this.map = map;
    }

    private MapSimulation spawn() {
        int Y = map.getY();
        int X = map.getX();
        int counter = 0;

        int maxOnMap = (int) (((double) max * (X * Y)) / 100);

        while (counter < maxOnMap) {
            int randomX = ThreadLocalRandom.current().nextInt(0, X);
            int randomY = ThreadLocalRandom.current().nextInt(0, Y);

            if (map.getMapSimulation(randomX, randomY) == null) {
                map.putEntity(createEntity(), randomX, randomY);
                counter++;
            }
        }

        return map;
    }

    @Override
    public void perform() {
        spawn();
    }

    public abstract SimulationEntity createEntity();

}
