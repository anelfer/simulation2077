package me.anelfer.simulation.entities.сreature;

import javafx.scene.image.Image;
import lombok.Getter;
import lombok.Setter;
import me.anelfer.simulation.entities.SimulationEntity;


public abstract class AbstractCreature extends SimulationEntity {

    @Getter @Setter
    private int speed;

    @Getter @Setter
    private int health;

    @Getter
    private final String gender;

    public AbstractCreature(String name, Image image, int speed, int health, String gender) {
        super(name, image);
        this.speed = speed;
        this.health = health;
        this.gender = gender;
    }

}
