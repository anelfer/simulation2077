package me.anelfer.simulation.entities;

import javafx.scene.image.Image;
import lombok.Getter;

public abstract class SimulationEntity {

    @Getter
    private final String name;
    @Getter
    private final Image image;

    public SimulationEntity(String name, Image image) {
        this.name = name;
        this.image = image;
    }

}
