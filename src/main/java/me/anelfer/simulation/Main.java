package me.anelfer.simulation;

import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javafx.util.Duration;
import me.anelfer.simulation.map.Simulation;
import me.anelfer.simulation.render.Renderer;

public class Main extends Application {

    private final int size;
    private final int canvasWidth;
    private final int canvasHeight;

    public Main() {
        Simulation simulation = new Simulation();
        this.size = (int) ((((float) simulation.X / (simulation.Y * simulation.X))) * 500);
        this.canvasWidth = size * simulation.X + ((simulation.X * (size/2)) + (size * 2));
        this.canvasHeight = size * simulation.Y + ((simulation.Y * (size/2)) + (size * 2));
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        StackPane holder = new StackPane();
        Canvas canvas = new Canvas(canvasWidth, canvasHeight);

        primaryStage.setTitle("Simulation 2077");

        primaryStage.setMinWidth(canvasWidth);
        primaryStage.setMinHeight(canvasHeight);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        holder.setStyle("-fx-background-color: #9280b8;");

        holder.getChildren().add(canvas);
        root.getChildren().add(holder);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        ScheduledService<Color[][]> svc = new ScheduledService<>() {
            final Renderer renderer = new Renderer();

            @Override
            protected Task<Color[][]> createTask() {
                return new Task<>() {
                    @Override
                    protected Color[][] call() {
                        return renderer.render();
                    }
                };
            }
        };

        svc.setPeriod(Duration.seconds(1));
        svc.start();

        svc.setOnSucceeded(event -> {
            Color[][] grid = (Color[][]) event.getSource().getValue();
            int spacingY = 0;
            for (int y = 0 ; y < grid.length ; y++) {
                int spacingX = 0;
                for (int x = 0 ; x < grid[y].length ; x++) {
                    gc.setFill(grid[y][x]);
                    gc.fillRect((x + 1) * size + spacingX , (y + 1) * size + spacingY, size, size);
                    spacingX += size / 2;
                }
                spacingY += size / 2;
            }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
