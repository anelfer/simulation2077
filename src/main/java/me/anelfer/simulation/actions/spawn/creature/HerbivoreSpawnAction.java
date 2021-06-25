package me.anelfer.simulation.actions.spawn.creature;

import me.anelfer.simulation.actions.spawn.AbstractSpawnAction;
import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.entities.сreature.HP;
import me.anelfer.simulation.entities.сreature.HerbivoreCreature;
import me.anelfer.simulation.map.MapLocation;
import me.anelfer.simulation.map.MapSimulation;

public class HerbivoreSpawnAction extends AbstractSpawnAction {

    public HerbivoreSpawnAction(int max, MapSimulation map) {
        super(max, map);
    }

    @Override
    public SimulationEntity createEntity(MapLocation location) {
        return new HerbivoreCreature(1, new HP(15), 5, "male", location);
    }

    @Override
    public Class<?> getEntityClass() {
        return HerbivoreCreature.class;
    }

}
