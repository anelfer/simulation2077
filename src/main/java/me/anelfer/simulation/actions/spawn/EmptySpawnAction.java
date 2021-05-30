package me.anelfer.simulation.actions.spawn;

import me.anelfer.simulation.entities.object.EmptyEntity;
import me.anelfer.simulation.map.MapSimulation;

public class EmptySpawnAction {

    private final int X;
    private final int Y;
    private final MapSimulation map;

    public EmptySpawnAction(int X, int Y, MapSimulation map) {
        this.X = X;
        this.Y = Y;
        this.map = map;
    }

    public MapSimulation spawn() {

        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if (map.getMapSimulation(x, y) == null) {
                    map.putEntity(new EmptyEntity(), x, y);
                }
            }
        }

        return map;
    }

}
