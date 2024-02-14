package com.source.task3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;

public class TrafficLights extends Application {

    public boolean isTrafficLightSelected(int indexPosition, int randomValue){
       if(indexPosition == randomValue) return  true;
       return false;
    }
    public void setCircle(double radius, double trafficLightGap,Pane layout, int numberOfTrafficLights, int randomCircle, int index){
        String[] colors = {"RED","YELLOW","GREEN"};

        Circle circle = new Circle();
        circle.setRadius(radius);
        circle.setFill(Color.valueOf(colors[index]));
        circle.setCenterX((layout.getWidth()) / 2);
        circle.setCenterY( (layout.getHeight() / 2) + (index - numberOfTrafficLights / 2.0 + 0.5) * trafficLightGap);
        if (index == randomCircle){
            circle.setStroke(Color.BLACK);
        }else{
            circle.setStroke(Color.TRANSPARENT);
        }
        layout.getChildren().add(circle);
    }
    public void setRectangle(double width, double height, Pane layout){
        Rectangle rectangle = new Rectangle(width, height);
        double centerRectangleCoordinateX = (layout.getWidth() - width) / 2;
        double centerRectangleCoordinateY = (layout.getHeight() - height) / 2;

        rectangle.setLayoutX(centerRectangleCoordinateX);
        rectangle.setLayoutY(centerRectangleCoordinateY);
        rectangle.setFill(Color.LIGHTBLUE);
        layout.getChildren().add(rectangle);
    }


    @Override
    public void start(Stage primaryStage) {
        double widthRectangle = 80;
        double heightRectangle = 200;
        double circleRadius = widthRectangle / 3;
        double gapBetweenCircles = heightRectangle / 3.3;
        int trafficLightsNumber = 3;

        Pane pane = new Pane();
        Scene scene = new Scene(pane, 200, 250);

        setRectangle(widthRectangle, heightRectangle,pane);



        Random random = new Random();
        int randomTrafficLightSelected = random.nextInt(3);
        for (int i = 0; i < trafficLightsNumber; i++) {
            setCircle(circleRadius, gapBetweenCircles, pane, trafficLightsNumber, randomTrafficLightSelected, i);
        }

        primaryStage.setTitle("Traffic color");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}