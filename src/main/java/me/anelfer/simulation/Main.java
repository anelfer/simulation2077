package me.anelfer.simulation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import me.anelfer.simulation.map.Simulation;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        // for visualizing the different squares:
        gridPane.setHgap(2);
        gridPane.setVgap(2);
        gridPane.setStyle("-fx-background-color: #9280b8;");

        new Simulation(gridPane).mapFiller();

        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("Simulation");
        primaryStage.setMinWidth(340);
        primaryStage.setMinHeight(360);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
