package me.anelfer.simulation;

import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javafx.util.Duration;
import me.anelfer.simulation.render.Renderer;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        gridPane.setHgap(2);
        gridPane.setVgap(2);
        gridPane.setStyle("-fx-background-color: #9280b8;");

        primaryStage.setTitle("Simulation 2077");
        primaryStage.setMinWidth(340);
        primaryStage.setMinHeight(360);

        primaryStage.setScene(new Scene(gridPane, 400, 400));
        primaryStage.show();

        ScheduledService<Image[][]> svc = new ScheduledService<>() {
            final Renderer renderer = new Renderer();

            @Override
            protected Task<Image[][]> createTask() {
                return new Task<>() {
                    @Override
                    protected Image[][] call() {
                        return renderer.render();
                    }
                };
            }
        };

        svc.setPeriod(Duration.seconds(1));
        svc.start();

        svc.setOnSucceeded(event -> {
            Image[][] grid = (Image[][]) event.getSource().getValue();
            for (int y = 0 ; y < grid.length ; y++) {
                for (int x = 0 ; x < grid[y].length ; x++) {
                    ImageView imageView = new ImageView(grid[y][x]);
                    int tileSize = 30;
                    imageView.setFitWidth(tileSize);
                    imageView.setFitHeight(tileSize);
                    gridPane.add(imageView, x, y);
                }
            }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
