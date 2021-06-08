package me.anelfer.simulation.render;

import javafx.scene.paint.Color;
import me.anelfer.simulation.map.MapLocation;
import me.anelfer.simulation.map.Simulation;

public class Renderer {

    private final Simulation simulation = new Simulation();

    public Color[][] render() {
        simulation.start();

        Color[][] grid = new Color[Simulation.X][Simulation.Y];

        for (int y = 0; y < Simulation.Y; y++) {
            for (int x = 0; x < Simulation.X; x++) {
                if (!simulation.map.containsKey(new MapLocation(x, y))) {
                    grid[y][x] = Color.WHITE;
                } else {
                    switch (simulation.map.getSimulationEntity(x, y).getName()) {
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