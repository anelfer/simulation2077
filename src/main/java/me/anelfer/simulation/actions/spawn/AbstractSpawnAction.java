package me.anelfer.simulation.actions.spawn;

import lombok.Getter;
import lombok.Setter;
import me.anelfer.simulation.actions.AbstractAction;
import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.map.MapLocation;
import me.anelfer.simulation.map.MapSimulation;

import java.util.Random;

public abstract class AbstractSpawnAction extends AbstractAction {

    private final MapSimulation map;
    private final int max; // This type entity in percent
    @Getter
    private static final Long seed = new Random().nextLong();
    @Setter
    private static Random random = new Random(seed);

    public AbstractSpawnAction(int max, MapSimulation map) {
        this.max = max;
        this.map = map;
    }

    @Override
    public void perform() {
        int maxOnMap = (int) (((double) max * (map.getX() * map.getY())) / 100);
        int counter = map.getEntityCount(this.getEntityClass());

        while (counter < maxOnMap) {
            spawn();
            counter = map.getEntityCount(this.getEntityClass());
        }
    }

    private void spawn() {
        int randomX = random.nextInt(map.getX());
        int randomY = random.nextInt(map.getY());

        if (map.isCellEmpty(randomX, randomY)) {
            map.putEntity(randomX, randomY, createEntity(new MapLocation(randomX, randomY)));
        }
    }

    public abstract SimulationEntity createEntity(MapLocation location);

    public abstract Class<?> getEntityClass();

}
