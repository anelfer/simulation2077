package me.anelfer.simulation.actions.spawn;

import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.entities.object.RockEntity;
import me.anelfer.simulation.map.MapSimulation;

import java.util.concurrent.ThreadLocalRandom;

public class RockSpawnAction {

    private final int maxOnMap;
    private final int X;
    private final int Y;
    private final MapSimulation map;

    public RockSpawnAction(int maxOnMap, int X, int Y, MapSimulation map) {
        this.maxOnMap = maxOnMap;
        this.X = X;
        this.Y = Y;
        this.map = map;
    }

    public MapSimulation spawn() {

        int counter = 0;

        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if (counter < maxOnMap) {
                    int randomX = ThreadLocalRandom.current().nextInt(1, X);
                    int randomY = ThreadLocalRandom.current().nextInt(1, Y);

                    if (map.getMapSimulation(randomX, randomY) == null) {
                        map.putEntity(new RockEntity(), randomX, randomY);

                        counter++;
                    }
                }
            }
        }

        return map;
    }

}
