package com.example.jaavafxtesting;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class FontDemo extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane to hold the circle
        Pane pane = new StackPane();

        // Create a circle and set its properties
        Circle circle = new Circle();
        circle.setRadius(20);
        circle.setCenterY(10);
        circle.setStroke(Color.BLACK);
        circle.setFill(new Color(0.7,0.8,0.9,0.8));
        pane.getChildren().add(circle); // Add circle to the pane

        Circle circle2 = new Circle();
        circle2.setRadius(20);
        circle2.setCenterY(60);
        circle2.setStroke(Color.PINK);
        circle2.setFill(new Color(0.2, 0.7, 0.9, 0.5));

        Circle circle3 = new Circle();
        circle3.setRadius(20);
        circle3.setCenterY(110);
        circle3.setStroke(Color.PINK);
        circle3.setFill(new Color(0.1, 0.1, 0.9, 0.9));


        //pane.getChildren().add(circle2); // Add circle to the pane

        Group group = new Group();
        group.getChildren().addAll(circle,circle2,circle3);

        Rectangle r = new Rectangle(50, 150, 50, 150);
        //r.setRotate(i * 360 / 8);
        r.setStroke(Color.color(Math.random(), Math.random(),
                Math.random()));
        r.setFill(Color.WHITE);
        pane.getChildren().add(r);
        pane.getChildren().add(group);


        // Create a label and set its properties
        /*
        Label label = new Label("JavaFX");
        label.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 20));
        pane.getChildren().add(label);
        */

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 300, 300);

        //Scene scene = new Scene(pane);
        primaryStage.setTitle("Traffic"); // Set the stage title
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
