package me.anelfer.simulation.entities.object;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import lombok.Getter;
import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.map.Simulation;

public class RockEntity extends SimulationEntity {

    @Getter
    private final Image rock = Simulation.createImage(Color.GREY);

    public RockEntity() {
        super("rock", Simulation.createImage(Color.GREY));
    }

}
