package me.anelfer.simulation.entities.сreature;

import me.anelfer.simulation.map.MapSimulation;

public class PredatorCreature extends AbstractCreature {

    private final int speed;
    private final int health;
    private final String gender;

    public PredatorCreature(int speed, int health, String gender) {
        super("predator", speed, health, gender);
        this.speed = speed;
        this.health = health;
        this.gender = gender;
    }

    @Override
    public void makeMove(MapSimulation map) {
        return;
    }
}
