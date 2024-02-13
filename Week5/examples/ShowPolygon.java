package com.example.jaavafxtesting;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;

public class ShowPolygon extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a scene and place it in the stage
        Scene scene = new Scene(new MyPolygon(), 400, 400);
        primaryStage.setTitle("ShowPolygon"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}

class MyPolygon extends Pane {
    private void paint() {
        // Create a polygon and place polygon to pane
        Polygon polygon = new Polygon();
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);

        polygon.getPoints().addAll(new Double[]{
                200.0, 50.0,
                400.0, 50.0,
                450.0, 150.0,
                480.0, 250.0,
                200.0, 250.0,
                105.0, 127.0,
                50.0 ,25.0,
                210.0,141.0
        });


        //ObservableList<Double> list = polygon.getPoints();

        //double centerX = getWidth() / 2, centerY = getHeight() / 2;
        //double radius = Math.min(getWidth(), getHeight()) * 0.4;

        // Add points to the polygon list
        //for (int i = 0; i < 6; i++) {
        //    list.add(centerX + radius * Math.cos(2 * i * Math.PI / 6));
        //    list.add(centerY - radius * Math.sin(2 * i * Math.PI / 6));
        //}

        getChildren().clear(); // Clear pane
        getChildren().add(polygon);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paint();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paint();
    }
}
