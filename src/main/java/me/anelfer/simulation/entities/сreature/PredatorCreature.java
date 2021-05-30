package me.anelfer.simulation.entities.сreature;

import javafx.scene.paint.Color;
import me.anelfer.simulation.map.MapFiller;

public class PredatorCreature extends AbstractCreature{

    private int speed = 2;
    private int health = 25;
    private String gender = "female";

    public PredatorCreature(int speed, int health, String gender) {
        super("predator", MapFiller.createImage(Color.RED), speed, health, gender);
    }

}
