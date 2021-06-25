package me.anelfer.simulation.render;

import javafx.scene.paint.Color;
import me.anelfer.simulation.entities.сreature.AbstractCreature;
import me.anelfer.simulation.map.Simulation;

public class Renderer {

    private final Simulation simulation = new Simulation();

    public Color[][] render() {
        simulation.start();

        Color[][] grid = new Color[Simulation.X][Simulation.Y];

        for (int y = 0; y < Simulation.Y; y++) {
            for (int x = 0; x < Simulation.X; x++) {
                switch (simulation.map.getSimulationEntity(x, y).getName()) {
                    case "grass":
                        AbstractCreature entityG = (AbstractCreature) simulation.map.getSimulationEntity(x, y);
                        float alphaG =  ((float) entityG.getHealth().getCurrent() / (float) entityG.getHealth().getMax());
                        grid[y][x] = Color.color(0.0f, 0.5019608f, 0.0f, alphaG);
                        break;
                    case "rock":
                        grid[y][x] = Color.GREY;
                        break;
                    case "tree":
                        grid[y][x] = Color.web("#964B00");
                        break;
                    case "herbivore":
                        AbstractCreature entityH = (AbstractCreature) simulation.map.getSimulationEntity(x, y);
                        float alphaH =  ((float) entityH.getHealth().getCurrent() / (float) entityH.getHealth().getMax());
                        grid[y][x] = Color.color(0.5019608f, 0.0f, 0.5019608f, alphaH);
                        break;
                    case "predator":
                        grid[y][x] = Color.RED;
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

}
