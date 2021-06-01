package me.anelfer.simulation.entities.сreature;

import javafx.scene.paint.Color;
import me.anelfer.simulation.map.MapSimulation;
import me.anelfer.simulation.map.Simulation;

public class HerbivoreCreature extends AbstractCreature {

    private int speed = 1;
    private int health = 10;
    private String gender = "male";

    public HerbivoreCreature(int speed, int health, String gender) {
        super("herbivore", speed, health, gender);
    }

    @Override
    public void makeMove(MapSimulation map) {
        return;
    }
}
