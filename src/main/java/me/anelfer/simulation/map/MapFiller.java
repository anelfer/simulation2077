package me.anelfer.simulation.map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import me.anelfer.simulation.actions.spawn.EmptySpawnAction;
import me.anelfer.simulation.actions.spawn.GrassSpawnAction;
import me.anelfer.simulation.actions.spawn.RockSpawnAction;
import me.anelfer.simulation.actions.spawn.TreeSpawnAction;
import me.anelfer.simulation.entities.SimulationEntity;
import me.anelfer.simulation.entities.object.EmptyEntity;
import me.anelfer.simulation.entities.object.GrassEntity;
import me.anelfer.simulation.entities.object.RockEntity;
import me.anelfer.simulation.entities.object.TreeEntity;

import java.util.concurrent.ThreadLocalRandom;

public class MapFiller {
    private final GridPane gridPane;
    private final int Y = 10;
    private final int X = 10;

    public MapFiller(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public void mapFiller() {
        Image[][] grid = new Image[Y][X];
        MapSimulation map = new MapSimulation();

        RockSpawnAction rockAction = new RockSpawnAction(10, 10, 10, map);
        GrassSpawnAction grassAction = new GrassSpawnAction(25, 10,10, map);
        TreeSpawnAction treeAction = new TreeSpawnAction(5, 10, 10, map);
        EmptySpawnAction emptyAction = new EmptySpawnAction(10, 10, map);

        rockAction.spawn();
        grassAction.spawn();
        treeAction.spawn();
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
