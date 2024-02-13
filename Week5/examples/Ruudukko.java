package com.example.jaavafxtesting;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Ruudukko extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane and set its properties
        GridPane pane = new GridPane();
        pane.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");

        pane.add(new Label("First Name:"), 0, 0);
        pane.add(new TextField(), 1, 0);
        pane.add(new Label("MI:"), 0, 1);
        pane.add(new TextField(), 1, 1);

        Circle circle = new Circle();
        circle.setRadius(10);
        circle.setCenterY(10);
        circle.setStroke(Color.BLACK);
        circle.setFill(new Color(0.5, 0.5, 0.5, 0.1));
        pane.add(circle,0,2); // Add circle to the pane

        GridPane inner_pane = new GridPane();
        inner_pane.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
        inner_pane.add(new Label("Hey"),0,0);
        inner_pane.add(new Label("Hex"),1,0);
        inner_pane.add(new Label("Hez"),0,1);

        pane.add(inner_pane,1,2);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowGridPane"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }


    public static void main(String[] args) {
        launch(args);
    }
}
