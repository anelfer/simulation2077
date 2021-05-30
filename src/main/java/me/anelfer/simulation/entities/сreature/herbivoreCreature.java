package me.anelfer.simulation.entities.сreature;

import javafx.scene.paint.Color;
import me.anelfer.simulation.map.MapSimulation;
import me.anelfer.simulation.map.Simulation;

public class herbivoreCreature extends AbstractCreature {

    private int speed = 1;
    private int health = 10;
    private String gender = "male";

    public herbivoreCreature(int speed, int health, String gender) {
        super("herbivore", Simulation.createImage(Color.PURPLE), speed, health, gender);
    }

    @Override
    public void makeMove(MapSimulation map) {
        return;
    }
}
