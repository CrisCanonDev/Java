package com.source.task3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

import java.util.Random;

public class TrafficLights extends Application {
    Circle circle1, circle2, circle3;
    public void Rectangle(){

    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        int numberCircles = 3;
        primaryStage.setTitle("Traffic color");
        Pane pane = new Pane();
        double widthRectangle = 80;
        double heightRectangle = 200;
        double circleRadius = widthRectangle / 3;
        double gapBetweenCircles = heightRectangle / 3.3;

        Rectangle rectangle = new Rectangle(widthRectangle, heightRectangle);

        pane.getChildren().add(rectangle);

        VBox root = new VBox();


        Scene scene = new Scene(pane, 200, 250);
        double centerRectangleCoordenateX = (pane.getWidth() - widthRectangle) / 2;
        double centerRectangleCoordenateY = (pane.getHeight() - heightRectangle) / 2;
        rectangle.setLayoutX(centerRectangleCoordenateX);
        rectangle.setLayoutY(centerRectangleCoordenateY);
        rectangle.setFill(Color.LIGHTBLUE);

        String[] colors = {"RED","YELLOW","GREEN"};
        Random random = new Random();
        int circleBorderSelected = random.nextInt(numberCircles);
        for (int i = 0; i < numberCircles; i++) {
            Circle circle = new Circle();
            circle.setRadius(circleRadius);
            circle.setFill(Color.valueOf(colors[i]));
            circle.setCenterX((pane.getWidth()) / 2);
            circle.setCenterY((pane.getHeight() / 2) + (i - numberCircles / 2.0 + 0.5) * gapBetweenCircles);
            if (i == circleBorderSelected){
                circle.setStroke(Color.BLACK);
            }else{
                circle.setStroke(Color.TRANSPARENT);
            }
            pane.getChildren().add(circle);
        }


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}