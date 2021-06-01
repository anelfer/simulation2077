package me.anelfer.simulation.map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import me.anelfer.simulation.actions.spawn.creature.HerbivoreSpawnAction;
import me.anelfer.simulation.actions.spawn.creature.PredatorSpawnAction;
import me.anelfer.simulation.actions.spawn.object.EmptySpawnAction;
import me.anelfer.simulation.actions.spawn.object.GrassSpawnAction;
import me.anelfer.simulation.actions.spawn.object.RockSpawnAction;
import me.anelfer.simulation.actions.spawn.object.TreeSpawnAction;

public class Simulation {
    private final int Y = 10;
    private final int X = 10;
    public final MapSimulation map = new MapSimulation(X, Y);

    public Image[][] mapFiller() {
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

        return grid;
    }

    public static Image createImage(Color color) {
        WritableImage image = new WritableImage(1, 1);
        image.getPixelWriter().setColor(0, 0, color);
        return image ;
    }

}
