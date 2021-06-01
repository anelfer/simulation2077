package me.anelfer.simulation.render;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import me.anelfer.simulation.map.MapLocation;
import me.anelfer.simulation.map.Simulation;

public class Renderer {

    public Simulation simulation = new Simulation();

    public Renderer() {
        simulation.start();
    }

    public Image[][] render() {
        Image[][] grid = new Image[simulation.Y][simulation.X];

        for (int y = 0; y < simulation.Y; y++) {
            for (int x = 0; x < simulation.X; x++) {
                if (!simulation.map.containsKey(new MapLocation(x, y))) {
                    grid[y][x] = Simulation.createImage(Color.WHITE);
                } else {
                    switch (simulation.map.getMapSimulation(x, y).getName()) {
                        case "grass":
                            grid[y][x] = Simulation.createImage(Color.GREEN);
                            break;
                        case "rock":
                            grid[y][x] = Simulation.createImage(Color.GREY);
                            break;
                        case "tree":
                            grid[y][x] = Simulation.createImage(Color.web("#964B00"));
                            break;
                        case "herbivore":
                            grid[y][x] = Simulation.createImage(Color.PURPLE);
                            break;
                        case "predator":
                            grid[y][x] = Simulation.createImage(Color.RED);
                            break;
                    }
                }
            }
        }

        return grid;
    }

}
