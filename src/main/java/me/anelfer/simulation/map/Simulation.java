package me.anelfer.simulation.map;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import me.anelfer.simulation.actions.spawn.creature.HerbivoreSpawnAction;
import me.anelfer.simulation.actions.spawn.creature.PredatorSpawnAction;
import me.anelfer.simulation.actions.spawn.object.EmptySpawnAction;
import me.anelfer.simulation.actions.spawn.object.GrassSpawnAction;
import me.anelfer.simulation.actions.spawn.object.RockSpawnAction;
import me.anelfer.simulation.actions.spawn.object.TreeSpawnAction;

public class Simulation {
    private final GridPane gridPane;
    private final int Y = 10;
    private final int X = 10;
    private final MapSimulation map = new MapSimulation(X, Y);


    public Simulation(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public void mapFiller() {
        Image[][] grid = new Image[Y][X];

        RockSpawnAction rockAction = new RockSpawnAction(10, map);
        GrassSpawnAction grassAction = new GrassSpawnAction(15, map);
        TreeSpawnAction treeAction = new TreeSpawnAction(5, map);
        EmptySpawnAction emptyAction = new EmptySpawnAction(10, 10, map);

        PredatorSpawnAction predatorAction = new PredatorSpawnAction(2, map);
        HerbivoreSpawnAction herbivoreAction = new HerbivoreSpawnAction(2, map);

        rockAction.perform();
        grassAction.perform();
        treeAction.perform();

        predatorAction.perform();
        herbivoreAction.perform();

        emptyAction.spawn();

        for (MapLocation key : map.keySet()) {
            int x = key.getRow();
            int y = key.getColumn();
            grid[y][x] = map.get(key).getImage();
        }

        for (int y = 0 ; y < grid.length ; y++) {
            for (int x = 0 ; x < grid[y].length ; x++) {
                ImageView imageView = new ImageView(grid[y][x]);
                int tileSize = 30;
                imageView.setFitWidth(tileSize);
                imageView.setFitHeight(tileSize);
                gridPane.add(imageView, x, y);
            }
        }

    }

    public static Image createImage(Color color) {
        WritableImage image = new WritableImage(1, 1);
        image.getPixelWriter().setColor(0, 0, color);
        return image ;
    }


}
