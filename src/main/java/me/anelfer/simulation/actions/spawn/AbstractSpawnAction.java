package me.anelfer.simulation.actions.spawn;

import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.map.MapSimulation;

import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractSpawnAction {

    private final MapSimulation map;
    private final int max;
    private final SimulationEntity entity;

    public AbstractSpawnAction(MapSimulation map, int max, SimulationEntity entity) {
        this.map = map;
        this.max = max;
        this.entity = entity;
    }

    public MapSimulation spawn() {
        int Y = map.getY();
        int X = map.getX();
        int counter = 0;

        int maxOnMap = (int) (((double) max / (X * Y)) * 100);

        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if (counter < maxOnMap) {
                    int randomX = ThreadLocalRandom.current().nextInt(0, X);
                    int randomY = ThreadLocalRandom.current().nextInt(0, Y);

                    map.putEntity(entity, randomX, randomY);

                    counter++;

                }
            }
        }

        return map;
    }

}
