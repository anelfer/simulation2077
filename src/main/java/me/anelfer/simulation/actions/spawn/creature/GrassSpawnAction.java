package me.anelfer.simulation.actions.spawn.creature;

import me.anelfer.simulation.actions.spawn.AbstractSpawnAction;
import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.entities.сreature.GrassEntity;
import me.anelfer.simulation.entities.сreature.HP;
import me.anelfer.simulation.map.MapLocation;
import me.anelfer.simulation.map.MapSimulation;

public class GrassSpawnAction extends AbstractSpawnAction {

    public GrassSpawnAction(int max, MapSimulation map) {
        super(max, map);
    }

    @Override
    public SimulationEntity createEntity(MapLocation location) {
        return new GrassEntity(0, new HP(25), 0, "", location);
    }

    @Override
    public Class<?> getEntityClass() {
        return GrassEntity.class;
    }

}
