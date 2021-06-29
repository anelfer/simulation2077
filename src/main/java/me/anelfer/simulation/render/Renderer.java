package me.anelfer.simulation.render;

import javafx.scene.paint.Color;
import me.anelfer.simulation.entities.сreature.AbstractCreature;
import me.anelfer.simulation.map.MapSimulation;
import me.anelfer.simulation.map.Simulation;

public class Renderer {

    private final Simulation simulation = new Simulation();

    public Color[][] render() {
        simulation.nextTurn();
        MapSimulation map = simulation.getMap();

        Color[][] grid = new Color[Simulation.X][Simulation.Y];

        for (int y = 0; y < Simulation.Y; y++) {
            for (int x = 0; x < Simulation.X; x++) {
                switch (map.getSimulationEntity(x, y).getName()) {
                    case "grass":
                        grid[y][x] = Color.color(0.0f, 0.5019608f, 0.0f, getAlpha((AbstractCreature) map.getSimulationEntity(x, y)));
                        break;
                    case "rock":
                        grid[y][x] = Color.GREY;
                        break;
                    case "tree":
                        grid[y][x] = Color.web("#964B00");
                        break;
                    case "herbivore":
                        grid[y][x] = Color.color(0.5019608f, 0.0f, 0.5019608f, getAlpha((AbstractCreature) map.getSimulationEntity(x, y)));
                        break;
                    case "predator":
                        grid[y][x] = Color.color(1.0f, 0.0f, 0.0f, getAlpha((AbstractCreature) map.getSimulationEntity(x, y)));
                        break;
                    case "empty":
                        grid[y][x] = Color.WHITE;
                        break;
                }
            }
        }
        return grid;
    }

    public Color[][] reset() {
        simulation.reset();
        Color[][] grid = new Color[Simulation.X][Simulation.Y];

        for (int y = 0; y < Simulation.Y; y++) {
            for (int x = 0; x < Simulation.X; x++) {
                grid[y][x] = Color.WHITE;
            }
        }
        return grid;
    }

    private float getAlpha(AbstractCreature entity) {
        return ((float) entity.getHealth().getCurrent() / (float) entity.getHealth().getMax());
    }

}
