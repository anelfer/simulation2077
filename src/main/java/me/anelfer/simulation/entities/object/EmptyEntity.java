package me.anelfer.simulation.entities.object;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import lombok.Getter;
import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.map.MapFiller;

public class EmptyEntity extends SimulationEntity {

    @Getter
    private final Image empty = MapFiller.createImage(Color.WHITE);

    public EmptyEntity() {
        super("empty", MapFiller.createImage(Color.WHITE));
    }

}
