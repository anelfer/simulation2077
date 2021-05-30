package me.anelfer.simulation.entities.object;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import lombok.Getter;
import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.map.Simulation;

public class TreeEntity extends SimulationEntity {

    @Getter
    private final Image tree = Simulation.createImage(Color.web("#964B00"));

    public TreeEntity() {
        super("tree", Simulation.createImage(Color.web("#964B00")));
    }

}
