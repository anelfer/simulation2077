package me.anelfer.simulation.entities.object;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import lombok.Getter;
import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.map.MapFiller;

public class GrassEntity extends SimulationEntity {

    @Getter
    private final Image grass = MapFiller.createImage(Color.GREEN);

    public GrassEntity() {
        super("grass", MapFiller.createImage(Color.GREEN));
    }

}
