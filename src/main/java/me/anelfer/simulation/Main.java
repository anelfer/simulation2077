package me.anelfer.simulation;

import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.util.Duration;
import me.anelfer.simulation.map.Simulation;
import me.anelfer.simulation.render.Renderer;

public class Main extends Application {

    private final int size;
    private final int canvasWidth;
    private final int canvasHeight;
    private boolean isStart = false;
    private final Renderer renderer = new Renderer();
    private final Label counterText = new Label();

    public Main() {
        this.size = (int) ((((float) Simulation.X / (Simulation.Y * Simulation.X))) * 500);
        this.canvasWidth = size * Simulation.X + ((Simulation.X * (size / 2)) + (size * 2));
        this.canvasHeight = size * Simulation.Y + ((Simulation.Y * (size / 2)) + (size * 2));
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Canvas canvas = new Canvas(canvasWidth, canvasHeight);

        primaryStage.setTitle("Simulation 2077");

        primaryStage.setMinWidth(canvasWidth);
        primaryStage.setMinHeight(canvasHeight);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.setStyle("-fx-background-color: #9280b8;");

        Button start = new javafx.scene.control.Button("Start");
        Button step = new javafx.scene.control.Button("Make 1 step");
        Button reset = new javafx.scene.control.Button("Reset");

        counterText.setText("Step: " + Simulation.getCounter());

        HBox hBox = new HBox(start, step, reset, counterText);
        hBox.setSpacing(15);

        VBox.setMargin(hBox, new Insets(size, 0, 0, size));
        VBox vBox = new VBox(hBox, canvas);

        root.getChildren().add(vBox);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        renderEmptyField(gc);

        ScheduledService<Color[][]> svc = new ScheduledService<>() {
            @Override
            protected Task<Color[][]> createTask() {
                return render();
            }
        };
        svc.setPeriod(Duration.millis(10));

        start.setOnAction(event -> {
            if (isStart) { //значит выключить
                start.setText("Start");
                svc.cancel();
                step.setDisable(false);
                reset.setDisable(false);
                isStart = false;
            } else {
                start.setText("Stop");
                svc.restart();
                step.setDisable(true);
                reset.setDisable(true);
                isStart = true;
            }
        });

        step.setOnAction(event -> {
            Task<Color[][]> task = render();

            task.setOnSucceeded(event1 -> renderOnMap((Color[][]) event1.getSource().getValue(), gc));
            task.run();
        });

        reset.setOnAction(event -> {
            isStart = false;
            svc.cancel();
            renderEmptyField(gc);
        });

        svc.setOnSucceeded(event -> renderOnMap((Color[][]) event.getSource().getValue(), gc));
    }

    private void renderEmptyField(GraphicsContext gc) {
        Task<Color[][]> firstRender = emptyFieldRender();

        firstRender.setOnSucceeded(event1 -> renderOnMap((Color[][]) event1.getSource().getValue(), gc));
        firstRender.run();
    }

    private Task<Color[][]> render() {
        return new Task<>() {
            @Override
            protected Color[][] call() {
                return renderer.render();
            }
        };
    }

    private Task<Color[][]> emptyFieldRender() {
        return new Task<>() {
            @Override
            protected Color[][] call() {
                return renderer.reset();
            }
        };
    }

    private void renderOnMap(Color[][] grid, GraphicsContext gc) {
        counterText.setText("Step: " + Simulation.getCounter());

        int spacingY = 0;

        for (int y = 0; y < grid.length; y++) {
            int spacingX = 0;
            for (int x = 0; x < grid[y].length; x++) {
                gc.setFill(grid[y][x]);
                gc.fillRect((x + 1) * size + spacingX, (y + 1) * size + spacingY, size, size);
                spacingX += size / 2;
            }
            spacingY += size / 2;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
