package Task4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class TrafficLights extends Application {
    Pane pane = new Pane();
    int numberCircles = 3;
    double widthRectangle = 80;
    double heightRectangle = 200;
    double circleRadius = widthRectangle / 3;
    double gapBetweenCircles = heightRectangle / 3.3;
    Rectangle trafficBody= new Rectangle(widthRectangle, heightRectangle);
    Circle circle1 = new Circle(circleRadius), circle2 = new Circle(circleRadius), circle3 = new Circle(circleRadius);
    Circle[] trafficLights = new Circle[]{circle1,circle2,circle3};
    int circlePosition = -1;
    public void increaseCirclePosition(){
        circlePosition +=1;
    }
    public void setLightButtons(Circle trafficLight){
        String[] beginningColors = {"CORAL","BEIGE","CYAN"};
        increaseCirclePosition();
        trafficLight.setFill(Color.valueOf(beginningColors[circlePosition]));
        trafficLight.setCenterX(pane.getWidth()/ 2);
        trafficLight.setCenterY((pane.getHeight() / 2) + (circlePosition - numberCircles / 2.0 + 0.5) * gapBetweenCircles);
    }
    public void changeLightsColors(Circle trafficLightSelected){
        String[] colors = {"RED","YELLOW","GREEN"};
        for(int i=0; i<trafficLights.length;i++){
            if (trafficLights[i] == trafficLightSelected){
                trafficLights[i].setFill(Color.valueOf(colors[i]));
            }else{
                trafficLights[i].setFill(Color.WHEAT);
            }
        }

    }
    public void updateLightColors(MouseEvent event){
        Circle clickedTrafficLight = (Circle) event.getSource();
        changeLightsColors(clickedTrafficLight);

    }
    public void placingLightsInLayout(){
       for(Circle light: trafficLights){
           setLightButtons(light);
       }
    }
    public void setTrafficLightsBody(Rectangle body){
        double centerRectangleCoordinateX = (pane.getWidth() - widthRectangle) / 2;
        double centerRectangleCoordinateY = (pane.getHeight() - heightRectangle) / 2;
        body.setLayoutX(centerRectangleCoordinateX);
        body.setLayoutY(centerRectangleCoordinateY);
        body.setFill(Color.LIGHTBLUE);
    }
    @Override
    public void start(Stage primaryStage){

        Scene scene = new Scene(pane, 200, 250);

        setTrafficLightsBody(trafficBody);
        placingLightsInLayout();

        pane.getChildren().addAll(trafficBody, circle1, circle2, circle3);

        circle1.setOnMouseClicked(this::updateLightColors);
        circle2.setOnMouseClicked(this::updateLightColors);
        circle3.setOnMouseClicked(this::updateLightColors);


        primaryStage.setTitle("Traffic color");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}