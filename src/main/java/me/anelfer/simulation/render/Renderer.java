package me.anelfer.simulation.render;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import me.anelfer.simulation.map.MapLocation;
import me.anelfer.simulation.map.Simulation;

public class Renderer {

    private final Simulation simulation = new Simulation();

    public Renderer() {
        simulation.start();
    }

    public Color[][] render() {
        Color[][] grid = new Color[simulation.X][simulation.Y];

        for (int y = 0; y < simulation.Y; y++) {
            for (int x = 0; x < simulation.X; x++) {
                if (!simulation.map.containsKey(new MapLocation(x, y))) {
                    grid[y][x] = Color.WHITE;
                } else {
                    switch (simulation.map.getMapSimulation(x, y).getName()) {
                        case "grass":
                            grid[y][x] = Color.GREEN;
                            break;
                        case "rock":
                            grid[y][x] = Color.GREY;
                            break;
                        case "tree":
                            grid[y][x] = Color.web("#964B00");
                            break;
                        case "herbivore":
                            grid[y][x] = Color.PURPLE;
                            break;
                        case "predator":
                            grid[y][x] = Color.RED;
                            break;
                    }
                }
            }
        }

        return grid;
    }

}
