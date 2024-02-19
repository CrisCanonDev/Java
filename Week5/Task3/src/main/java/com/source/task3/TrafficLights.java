package com.source.task3;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;


public class TrafficLights extends Application {
    Pane layout;
    public class LightBulbs{
        double radius;
        Circle trafficBulb;

        LightBulbs(double radius){
            this.radius = radius;
            trafficBulb = new Circle(radius);
        }

        public  boolean isSelectedToStroke(int randomValue, int bulbPosition){
            if( randomValue == bulbPosition){
                trafficBulb.setStroke(Color.BLACK);
                return true;
            }return  false;
        }
        public void setBulbColor(int bulbPosition){
            String[] colors = {"RED","YELLOW","GREEN"};
            trafficBulb.setFill(Color.valueOf(colors[bulbPosition]));
        }
        public void centerTo(Pane layout, int bulbPosition){
            int numberOfCircles = 3;
            double gapBetweenCircles = radius;
            trafficBulb.setCenterX(layout.getWidth()/2);
            trafficBulb.setCenterY( (layout.getHeight() /2)+ (bulbPosition - numberOfCircles / 2.0 +0.5) * gapBetweenCircles );
        }

    }

    public class BodyTrafficLight{
        double width;
        double height;
        Rectangle trafficBox;

        BodyTrafficLight(double width, double height){
            this.width = width;
            this.height = height;
            this.trafficBox = new Rectangle(width,height);
            trafficBox.setFill(Color.LIGHTBLUE);
        }
        public void centerTo(Pane layout){
            trafficBox.setLayoutX( (layout.getWidth() - width) / 2);
            trafficBox.setLayoutY( (layout.getHeight() - width) / 2);
        }
        public  Rectangle getTrafficBox(){
            return trafficBox;
        }

    }



    @Override
    public void start(Stage primaryStage){
        double widthRectangle = 80;
        double heightRectangle = 200;
        double circleRadius = widthRectangle / 3;
        int trafficLightsNumber = 3;

        Pane pane = new Pane();

        BodyTrafficLight bodyOfTrafficLights  = new BodyTrafficLight(widthRectangle,heightRectangle);
        Rectangle bodyTraffic = bodyOfTrafficLights.getTrafficBox();
        pane.getChildren().add(bodyTraffic);
        bodyTraffic.setLayoutX((pane.getWidth() - widthRectangle)/2);
        bodyTraffic.setLayoutY((pane.getHeight() - heightRectangle)/2);


        Scene scene = new Scene(pane, 200, 250);

//        Random random = new Random();
//        int randomTrafficLightSelected = random.nextInt(3);
//        for (int i = 0; i < trafficLightsNumber; i++) {
//            LightBulbs lightBulbs = new LightBulbs(circleRadius);
//            lightBulbs.setBulbColor(i);
//            lightBulbs.centerTo(pane,i);
//            lightBulbs.isSelectedToStroke(randomTrafficLightSelected, i);
//        }

        primaryStage.setTitle("Traffic color");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}