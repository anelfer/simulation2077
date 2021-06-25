package me.anelfer.simulation.entities.сreature;

import me.anelfer.simulation.map.MapLocation;

import java.util.List;

public class PredatorCreature extends AbstractCreature {

    public PredatorCreature(int speed, HP health, int attack, String gender, MapLocation location) {
        super("predator", speed, health, attack, gender, location, List.of(HerbivoreCreature.class));
    }

    @Override
    public Class<? extends PredatorCreature> getType() {
        return this.getClass();
    }

}
